package administracao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Agencia {
    private int codigo;
    private int digito;
    List<Cliente> clientes = new ArrayList<Cliente>();

    Scanner in = new Scanner(System.in);

    public Agencia(int pCodigo, int pDigito){
        this.codigo = pCodigo;
        this.digito = pDigito;
    }

    public int buscarCliente(int cpf){
        for (int i = 0; i < this.clientes.size(); i++){
            if (this.clientes.get(i).getCpf() == cpf){
                return i;
            }
        }
        return -1;
    }

    public void cadastrarCliente(){
        Calendar data = Calendar.getInstance();
        String nome, telefone, rua, cep, numero;
        int ano, mes, dia, cpf, pCodigo, pDigito;
        double valor;

        System.out.print("Informe o CPF: ");
        cpf = in.nextInt();
        in.nextLine();
        System.out.print("Informe o nome: ");
        nome = in.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = in.nextLine();
        System.out.print("Informe o ano de nascimento: ");
        ano = in.nextInt();
        in.nextLine();
        System.out.print("Informe o mês de nascimento: ");
        mes = in.nextInt();
        in.nextLine();
        System.out.print("Informe o dia de nascimento: ");
        dia = in.nextInt();
        in.nextLine();
        data.set(ano, mes-1, dia);

        System.out.print("Informe a rua: ");
        rua = in.nextLine();
        System.out.print("Informe o numero da residência: ");
        numero = in.nextLine();
        System.out.print("Informe o cep da rua: ");
        cep = in.nextLine();

        System.out.print("\nInforme a número da conta: ");
        pCodigo = in.nextInt();
        in.nextLine();
        System.out.print("Informe o dígito da conta: ");
        pDigito = in.nextInt();
        in.nextLine();
        System.out.print("Informe o valor da taxa de manuntenção: ");
        valor = in.nextDouble();
        in.nextLine();

        Cliente cliente = new Cliente(cpf, nome, telefone, data, rua, numero, cep, pCodigo, pDigito, valor);

        this.clientes.add(cliente);
        System.out.println("\nCLIENTE CADASTRADO - CONTA CORRENTE CRIADA");

    }

    public void excluirCliente(){
        System.out.print("Inform o CPF do cliente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if (pos != -1){
            this.clientes.remove(pos);
            System.out.println("CLIENTE REMOVIDO");
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public void abrirContaCorrente(){
        int pCodigo, pDigito, cpf;
        System.out.print("Informe o CPF do cliente: ");
        cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if ((pos != -1) && (this.clientes.get(pos).getContaC() == null)){

            System.out.print("Informe a número da conta: ");
            pCodigo = in.nextInt();
            in.nextLine();
            System.out.print("Informe o dígito da conta: ");
            pDigito = in.nextInt();
            in.nextLine();
            System.out.println("Informe o valor da taxa de manuntenção: ");
            double valor = in.nextDouble();
            in.nextLine();

            this.clientes.get(pos).setContaC(new ContaCorrente(pCodigo, pDigito, valor));
            System.out.println("\nCONTA CORRENTE CRIADA");
        } else {
            System.out.println("\nO CLIENTE NÃO EXISTE OU JÁ POSSUI CONTA CORRENTE");
        }

    }

    public void abrirContaPoupanca(){
        int pCodigo, pDigito, cpf;
        System.out.print("Informe o CPF do cliente: ");
        cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if ((pos != -1) && (this.clientes.get(pos).getContaP() == null)){

            System.out.print("Informe a número da conta: ");
            pCodigo = in.nextInt();
            in.nextLine();
            System.out.print("Informe o dígito da conta: ");
            pDigito = in.nextInt();
            in.nextLine();
            System.out.print("Informe a taxa de rendimento: ");
            float taxa = in.nextFloat();
            in.nextLine();
            System.out.print("Informe o dia de rendimento: ");
            int dia = in.nextInt();
            in.nextLine();

            this.clientes.get(pos).setContaP(new ContaPoupanca(pCodigo, pDigito, taxa, dia));
            System.out.println("\nCONTA POUPANÇA CRIADA");
        } else {
            System.out.println("\nO CLIENTE NÃO EXISTE OU JÁ POSSUI CONTA POUPANÇA");
        }
    }

    public void fecharContaCorrente(){
        System.out.print("Informe o CPF do cliente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if ((pos != -1) && (this.clientes.get(pos).getContaC() != null)){
            this.clientes.get(pos).setContaC(null);
            System.out.println("CONTA CORRENTE EXCLUÍDA");
        } else {
            System.out.println("O CLIENTE NÃO EXISTE OU NÃO POSSUI CONTA CORRENTE");
        }

        if (this.clientes.get(pos).verificaContas() == false){
            this.clientes.remove(pos);
            System.out.println("CONTA CORRENTE EXCLUÍDA\nCLIENTE REMOVIDO POR NÃO POSSUIR CONTAS");
        }
    }

    public void fecharContaPoupanca(){
        System.out.println("Informe o CPF do cliente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if ((pos != -1) && (this.clientes.get(pos).getContaP() != null)){
            this.clientes.get(pos).setContaP(null);
            System.out.println("CONTA POUPANÇA EXCLUÍDA");
        } else {
            System.out.println("O CLIENTE NÃO EXISTE OU NÃO POSSUI CONTA POUPANÇA");
        }

        if (this.clientes.get(pos).verificaContas() == false){
            this.clientes.remove(pos);
            System.out.println("CONTA POUPANÇA EXCLUÍDA\nCLIENTE REMOVIDO POR NÃO POSSUIR CONTAS");
        }
    }

    public void efetuarManutencao(){
        System.out.print("Informe o CPF do titular da conta-corrente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);
        if ((pos != -1) && (this.clientes.get(pos).getContaC() != null)){

            this.clientes.get(pos).getContaC().debitarManutencao();

        } else {
            System.out.println("CONTA INEXISTENTE OU CONTA POUPANÇA");
        }
    }

    public void efetuarRendimento(){
        System.out.print("Informe o CPF do titular da conta-poupança: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);
        if ((pos != -1) && (this.clientes.get(pos).getContaP() != null)){

            this.clientes.get(pos).getContaP().efetuarRendimento();

        } else {
            System.out.println("CONTA INEXISTENTE OU CONTA CORRENTE");
        }
    }

    public void alterarManutencao(){
        System.out.print("Informe o CPF do titular da conta-corrente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);
        if ((pos != -1) && (this.clientes.get(pos).getContaC() instanceof ContaCorrente)
                && (this.clientes.get(pos).getContaC() == null)){

            this.clientes.get(pos).getContaC().alterarManutencao();

        } else {
            System.out.println("CONTA INEXISTENTE OU CONTA CORRENTE");
        }
    }

    public void alterarRendimento(){
        System.out.print("Informe o CPF do titular da conta-corrente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);
        if ((pos != -1) && (this.clientes.get(pos).getContaP() instanceof ContaPoupanca)
                && (this.clientes.get(pos).getContaP() == null)){

            this.clientes.get(pos).getContaP().alterarRendimento();

        } else {
            System.out.println("CONTA INEXISTENTE OU CONTA CORRENTE");
        }
    }

    public void editarCliente(){
        System.out.print("Informe o CPF do cliente: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);
        if (pos != -1){
            this.clientes.get(pos).editarCliente();

        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public void verSaldo(){
        System.out.print("Informe seu CPF: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if (pos != -1){
            this.clientes.get(pos).mostrar();
            this.clientes.get(pos).verSaldo();
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public void debitar(){
        System.out.print("Informe seu CPF: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if (pos != -1){
            this.clientes.get(pos).debitar();
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public void creditar(){
        System.out.print("Informe seu CPF: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if (pos != -1){
            this.clientes.get(pos).creditar();
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public void transferir(Banco banco, int posAgenciaOrigem){
        System.out.print("Informe seu CPF: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if (pos != -1){
            this.clientes.get(pos).transferir(banco, posAgenciaOrigem, pos);
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public void historico(){
        System.out.print("Informe seu CPF: ");
        int cpf = in.nextInt();
        in.nextLine();

        int pos = this.buscarCliente(cpf);

        if (pos != -1){
            this.clientes.get(pos).historico();
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

}
