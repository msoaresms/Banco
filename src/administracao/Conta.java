package administracao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Conta {
    private int codigo;
    private int digito;
    private double saldo = 0.00;
    private Calendar dataAbertura;
    List<Movimentacao> historico = new ArrayList<Movimentacao>();

    public Conta(int pCodigo, int pDigito){
        this.codigo = pCodigo;
        this.digito = pDigito;
        dataAbertura = Calendar.getInstance();
    }

    public String verSaldo(){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(this.saldo);
    }

    public void debitar(double pDebito){
        if ((this.saldo - pDebito) < 0.0){
            System.out.println("SALDO INSUFICIENTE");
        } else {
            Calendar data = Calendar.getInstance();
            this.saldo = this.saldo - pDebito;
            Debito debito = new Debito(pDebito, data);
            this.historico.add(debito);
            System.out.println("Saldo atual: " +this.verSaldo());
        }
    }

    public void creditar(double pCredito){
        Calendar data = Calendar.getInstance();
        this.saldo = this.saldo + pCredito;
        Credito credito = new Credito(pCredito, data);
        this.historico.add(credito);
        System.out.println("Saldo atual: " +this.verSaldo());
    }

    public void historico(){
        System.out.println("\nHISTÓRICO\n");
        for (int i = 0; i < this.historico.size(); i++){
            this.historico.get(i).mostrar();
        }
    }

    public void transferirDestino(double pValor){
        this.saldo = this.saldo + pValor;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

}
