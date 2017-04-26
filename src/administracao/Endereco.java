package administracao;

import java.util.Scanner;

public class Endereco {
    private String rua;
    private String numero;
    private String cep;

    Scanner in = new Scanner(System.in);

    public Endereco(String pRua, String pNumero, String pCep){
        this.rua = pRua;
        this.numero = pNumero;
        this.cep = pCep;
    }

    public void editarEndereco(){
        System.out.print("Nova rua: ");
        this.rua = in.nextLine();
        System.out.print("Novo número: ");
        this.numero = in.nextLine();
        System.out.print("Novo CEP: ");
        this.cep = in.nextLine();
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
