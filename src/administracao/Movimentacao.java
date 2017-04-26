package administracao;

import java.util.Calendar;

public abstract class Movimentacao {
    private double valor;
    private Calendar data;

    public Movimentacao(double pValor, Calendar pData){
        this.valor = pValor;
        this.data = pData;
    }

    abstract public void mostrar();

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }


}
