package administracao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Cliente {
    private int cpf;
    private String nome;
    private String telefone;
    private Calendar dataNascimento;
    private Endereco endereco;
    private ContaCorrente contaC = null;
    private ContaPoupanca contaP = null;

    Scanner in = new Scanner(System.in);

    public Cliente(int pCpf, String pNome, String pTelefone, Calendar pData, String pRua,
                   String pNumero, String pCep, int pCodigo, int pDigito, double pValor){

        this.cpf = pCpf;
        this.nome = pNome;
        this.telefone = pTelefone;
        this.dataNascimento = pData;
        this.endereco = new Endereco(pRua, pNumero, pCep);
        this.setContaC(new ContaCorrente(pCodigo, pDigito, pValor));
    }

    public void editarCliente(){
        System.out.print("Informe o novo telefone: ");
        this.telefone = in.nextLine();
        this.endereco.editarEndereco();
        System.out.println("\nDADOS ALTERADOS");
    }

    public void verSaldo(){
        System.out.print("Informe a conta que deseja verificar o saldo: ");
        int codigo = in.nextInt();
        in.nextLine();

        if (this.contaC.getCodigo() == codigo){
            System.out.println("Conta Corrente - SALDO: " +this.contaC.verSaldo());
        } else if (this.contaP.getCodigo() == codigo){
            System.out.println("Conta Poupança - SALDO: " +this.contaP.verSaldo());
        } else {
            System.out.println("CONTA INEXISTENTE");
        }
    }

    public void debitar(){
        System.out.print("Informe a conta onde ocorrera o débito: ");
        int codigo = in.nextInt();
        in.nextLine();

        if (this.contaC.getCodigo() == codigo){
            System.out.print("Informe o valor do débito: ");
            double debito = in.nextDouble();
            in.nextLine();
            this.contaC.debitar(debito);

        } else if (this.contaP.getCodigo() == codigo){
            System.out.print("Informe o valor do débito: ");
            double debito = in.nextDouble();
            in.nextLine();
            this.contaP.debitar(debito);

        } else {
            System.out.println("CONTA INEXISTENTE");
        }
    }

    public void creditar(){
        System.out.print("Informe a conta onde ocorrera o crédito: ");
        int codigo = in.nextInt();
        in.nextLine();

        if (this.contaC.getCodigo() == codigo){
            System.out.print("Informe o valor do crédito: ");
            double credito = in.nextDouble();
            in.nextLine();
            this.contaC.creditar(credito);

        } else if (this.contaP.getCodigo() == codigo){
            System.out.print("Informe o valor do crédito: ");
            double credito = in.nextDouble();
            in.nextLine();
            this.contaP.creditar(credito);
        } else {
            System.out.println("CONTA INEXISTENTE");
        }
    }

    public void transferir(Banco banco, int posAgenciaOrigem, int posCpfCliente){
        System.out.print("Informe a conta de origem: ");
        int codigo = in.nextInt();
        in.nextLine();

        if (this.contaC.getCodigo() == codigo){
            this.contaC.transferir(banco, posAgenciaOrigem, posCpfCliente);
        } else {
            System.out.println("CONTA INEXISTENTE OU CONTA POUPANÇA");
        }
    }

    public void historico(){
        System.out.print("Informe a conta: ");
        int codigo = in.nextInt();
        in.nextLine();

        if (this.contaC.getCodigo() == codigo){
            this.contaC.historico();
        } else if (this.contaP.getCodigo() == codigo){
            this.contaP.historico();
        } else {
            System.out.println("CONTA INEXISTENTE");
        }
    }

    public void mostrar(){
        System.out.println("Cliente: " +this.nome);
        System.out.println("Telefone: " +this.telefone);

        String data = new SimpleDateFormat("dd/MM/yyyy").format(this.dataNascimento.getTime());
        System.out.println("Data de nascimento: " +data);
        System.out.println();
    }

    public Boolean verificaContas(){
        if (this.contaC == null && this.contaP == null){
            return false;
        }
        return true;
    }


    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContaCorrente getContaC() {
        return contaC;
    }

    public void setContaC(ContaCorrente contaC) {
        this.contaC = contaC;
    }

    public ContaPoupanca getContaP() {
        return contaP;
    }

    public void setContaP(ContaPoupanca contaP) {
        this.contaP = contaP;
    }


}
