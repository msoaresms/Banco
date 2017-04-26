package administracao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Credito extends Movimentacao{

    public Credito(double pValor, Calendar data){
        super(pValor, data);
    }

    public void mostrar(){
        System.out.println("CRÉDITO");
        System.out.println("Valor - R$ " +this.getValor());

        String data = new SimpleDateFormat("dd/MM/yyyy").format(this.getData().getTime());
        System.out.println("Data: " +data);
    }

}
