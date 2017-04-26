package administracao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Debito extends Movimentacao {

    public Debito(double pValor, Calendar pData){
        super(pValor, pData);
    }

    public void mostrar(){
        System.out.println("DÉBITO");
        System.out.println("Valor - R$ " +this.getValor());

        String data = new SimpleDateFormat("dd/MM/yyyy").format(this.getData().getTime());
        System.out.println("Data: " +data);
    }

}
