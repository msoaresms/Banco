package administracao;

import java.util.Calendar;
import java.util.Scanner;

public class ContaCorrente extends Conta{
    private double valorManutencao;

    Scanner in = new Scanner(System.in);

    public ContaCorrente(int pCodigo, int pDigito, double pValorMan){
        super(pCodigo, pDigito);
        this.valorManutencao = pValorMan;
    }

    public void debitarManutencao(){
        if (this.getSaldo() - this.valorManutencao < 0){
            System.out.println("SALDO INSUFICIENTE");
        } else {
            this.setSaldo(this.getSaldo() - this.valorManutencao);
            System.out.println("\nTAXA DE MANUTENÇÃO DEBITADA");
            System.out.println("Saldo atualizado: " +this.getSaldo());
        }
    }

    public void alterarManutencao() {
        System.out.print("Informe a nova taxa de manutenção: ");
        this.valorManutencao = in.nextDouble();
        in.nextLine();
        System.out.println("TAXA DE MANUTENÇÃO ALTERADA");
    }

    public void transferir(Banco banco, int posAgenciaOrigem, int posClienteOrigem){
        System.out.print("Informe a agência de destino: ");
        int codigo = in.nextInt();
        in.nextLine();
        int posA = banco.buscarAgencia(codigo);

        if (posA != -1){
            System.out.print("Informe o CPF do destinatário: ");
            int cpf = in.nextInt();
            in.nextLine();
            int posC = banco.agencias.get(posA).buscarCliente(cpf);

            if (posC != -1){
                System.out.print("Informe a conta de destino: ");
                codigo = in.nextInt();
                in.nextLine();

                if (banco.agencias.get(posA).clientes.get(posC).getContaC().getCodigo() == codigo){
                    System.out.print("Informe o valor: ");
                    int valor = in.nextInt();
                    in.nextLine();

                    banco.agencias.get(posAgenciaOrigem).clientes.get(posClienteOrigem).getContaC().transferirOrigem(valor);

                    Calendar data = Calendar.getInstance();
                    banco.agencias.get(posA).clientes.get(posC).getContaC().transferirDestino(valor);
                    Transferencia transferencia = new Transferencia(valor, data, codigo);
                    this.historico.add(transferencia);
                    System.out.println("TRANSFERÊNCIA EFETUADA");

                } else if (banco.agencias.get(posA).clientes.get(posC).getContaP().getCodigo() == codigo){
                    System.out.print("Informe o valor: ");
                    int valor = in.nextInt();
                    in.nextLine();

                    banco.agencias.get(posAgenciaOrigem).clientes.get(posClienteOrigem).getContaC().transferirOrigem(valor);

                    Calendar data = Calendar.getInstance();
                    banco.agencias.get(posA).clientes.get(posC).getContaP().transferirDestino(valor);
                    Transferencia transferencia = new Transferencia(valor, data, codigo);
                    this.historico.add(transferencia);
                    System.out.println("TRANSFERÊNCIA EFETUADA");
                } else {
                    System.out.println("CONTA DE DESTINO INEXISTENTE");
                }

            } else {
                System.out.println("CLIENTE DE DESTINO NÃO ENCONTRADO");
            }

        } else {
            System.out.println("AGÊNCIA DE DESTINO INEXISTENTE");
        }

    }

    public void transferirOrigem(double pValor){
        this.setSaldo(this.getSaldo()- pValor);
    }

    public double getValorManutencao() {
        return valorManutencao;
    }

    public void setValorManutencao(double valorManutencao) {
        this.valorManutencao = valorManutencao;
    }

}
