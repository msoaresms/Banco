package administracao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    List<Agencia> agencias = new ArrayList<Agencia>();

    Scanner in = new Scanner(System.in);


    public int buscarAgencia(int codigo, int digito){
        for (int i = 0; i < this.agencias.size(); i++){
            if ((this.agencias.get(i).getCodigo() == codigo) && (this.agencias.get(i).getDigito() == digito)){
                return i;
            }
        }
        return -1;
    }

    public int buscarAgencia(int codigo){
        for (int i = 0; i < this.agencias.size(); i++){
            if (this.agencias.get(i).getCodigo() == codigo){
                return i;
            }
        }
        return -1;
    }

    public void cadastrarAgencia(){
        int codigo, digito;
        System.out.print("\nInforme o código da agência: ");
        codigo = in.nextInt();
        in.nextLine();
        System.out.print("Informe o dígito da agência: ");
        digito = in.nextInt();
        in.nextLine();
        Agencia agencia = new Agencia(codigo, digito);
        this.agencias.add(agencia);
        System.out.println("\nAGÊNCIA CRIADA");
    }

    public void excluirAgencia(){
        int codigo, digito, pos;
        System.out.print("\nInforme o código da agência: ");
        codigo = in.nextInt();
        in.nextLine();
        System.out.print("Informe o dígito da agência: ");
        digito = in.nextInt();
        in.nextLine();
        pos = this.buscarAgencia(codigo, digito);
        if (pos != -1){
            this.agencias.remove(pos);
            System.out.println("\nAGÊNCIA REMOVIDA");
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void cadastrarCliente(){
        int codigo, pos;
        System.out.print("\nInforme o código da agência onde deseja abrir a conta: ");
        codigo = in.nextInt();
        in.nextLine();

        pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).cadastrarCliente();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void excluirCliente(){
        System.out.print("\nInforme a agência do cliente: ");
        int codigo = in.nextInt();
        in.nextLine();
        int pos = this.buscarAgencia(codigo);

        if (pos != -1 ){
            this.agencias.get(pos).excluirCliente();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void abrirContaCorrente(){
        System.out.print("\nInforme a agência onde deseja abrir a conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(agencia);

        if (pos != -1){
            this.agencias.get(pos).abrirContaCorrente();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void abrirContaPoupanca(){
        System.out.print("\nInforme a agência onde deseja abrir a conta: ");
        int codigo = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).abrirContaPoupanca();
        } else {
            System.out.println("\nAGÊCIA INEXISTENTE");
        }
    }

    public void fecharContaCorrente(){
        System.out.print("\nInforme a agência onde deseja fechar a conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(agencia);

        if (pos != -1){
            this.agencias.get(pos).fecharContaCorrente();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void fecharContaPoupanca(){
        System.out.print("\nInforme a agência onde deseja fechar a conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(agencia);

        if (pos != -1){
            this.agencias.get(pos).fecharContaPoupanca();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void efetuarManutencao(){
        System.out.print("\nInforme a agência da conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int posAg = this.buscarAgencia(agencia);

        if (posAg != -1){
            this.agencias.get(posAg).efetuarManutencao();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void efetuarRendimento(){
        System.out.print("\nInforme a agência da conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int posAg = this.buscarAgencia(agencia);

        if (posAg != -1){
            this.agencias.get(posAg).efetuarRendimento();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void alterarManutencao(){
        System.out.print("\nInforme a agência da conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int posAg = this.buscarAgencia(agencia);

        if (posAg != -1){
            this.agencias.get(posAg).alterarManutencao();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void alterarRendimento(){
        System.out.print("\nInforme a agência da conta: ");
        int agencia = in.nextInt();
        in.nextLine();

        int posAg = this.buscarAgencia(agencia);

        if (posAg != -1){
            this.agencias.get(posAg).alterarRendimento();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void editarAgencia(){
        int codigo, digito, pos;
        System.out.print("\nInforme o código da agência que deseja editar: ");
        codigo = in.nextInt();
        in.nextLine();
        System.out.print("Informe o dígito da agência que deseja editar: ");
        digito = in.nextInt();
        in.nextLine();

        pos = this.buscarAgencia(codigo, digito);

        if (pos != -1){
            System.out.print("\nInforme o novo código da agência: ");
            codigo = in.nextInt();
            in.nextLine();
            this.agencias.get(pos).setCodigo(codigo);
            System.out.print("Informe o novo dígito da agência: ");
            digito = in.nextInt();
            in.nextLine();
            this.agencias.get(pos).setDigito(digito);

            System.out.println("\nAGÊNCIA EDITADA");
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void editarCliente(){
        int codigo, digito, pos;
        System.out.print("\nInforme o código da agência do cliente: ");
        codigo = in.nextInt();
        in.nextLine();
        System.out.print("Informe o dígito da agência do cliente: ");
        digito = in.nextInt();
        in.nextLine();

        pos = this.buscarAgencia(codigo, digito);

        if (pos != -1){
            this.agencias.get(pos).editarCliente();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void verSaldo(){
        System.out.print("\nInforme sua agência: ");
        int codigo = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).verSaldo();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void debitar(){
        System.out.print("\nInforme sua agência ");
        int codigo = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).debitar();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void creditar(){
        System.out.print("\nInforme sua agência: ");
        int codigo = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).creditar();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void transferir(Banco banco){
        System.out.print("\nInforme sua agência: ");
        int codigo = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).transferir(banco, pos);
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }

    public void historico(){
        System.out.print("\nInforme sua agência: ");
        int codigo = in.nextInt();
        in.nextLine();

        int pos = this.buscarAgencia(codigo);

        if (pos != -1){
            this.agencias.get(pos).historico();
        } else {
            System.out.println("\nAGÊNCIA INEXISTENTE");
        }
    }
}