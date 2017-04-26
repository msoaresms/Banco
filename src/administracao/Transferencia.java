package administracao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transferencia extends Movimentacao{
    private int destino;

    public Transferencia(double pValor, Calendar pData, int pDestino){
        super(pValor, pData);
        this.destino = pDestino;
    }

    public void mostrar(){
        System.out.println("TRANSFERÊNCIA");
        System.out.println("Valor - R$ " +this.getValor());
        System.out.println("Conta destino: " +this.destino);

        String data = new SimpleDateFormat("dd/MM/yyyy").format(this.getData().getTime());
        System.out.println("Data: " +data);
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

}
