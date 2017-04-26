package administracao;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
    private int diaAniversario;
    private float juros;

    Scanner in = new Scanner(System.in);

    public ContaPoupanca(int pCodigo, int pDigito, float pRendimento, int pDia){
        super(pCodigo, pDigito);
        this.juros = pRendimento;
        this.setDiaAniversario(pDia);
    }

    public void efetuarRendimento(){
        if (this.getSaldo() == 0){
            System.out.println("SEM SALDO");
        } else {
            this.setSaldo(this.getSaldo() + (this.getSaldo() * juros));
            System.out.println("VALORES ATUALIZADOS");
            System.out.println("Saldo atual: " +this.verSaldo());
        }
    }

    public void alterarRendimento() {
        System.out.print("INFORME A NOVA PORCENTAGEM DE RENDIMENTO: ");
        this.juros = in.nextFloat();
        in.nextLine();
        System.out.println("TAXA DE RENDIMENTO ALTERADA");
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public float getJuros() {
        return juros;
    }

    public void setJuros(float juros) {
        this.juros = juros;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

}
