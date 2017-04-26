package execucao;

import java.util.Scanner;

import administracao.Banco;
import controle.ControleBanco;
import controle.ControleCliente;

public class Execucao {

    public static void main(String[] args) {
        Banco banco = new Banco();
        ControleBanco bancoC = new ControleBanco();
        ControleCliente clienteC = new ControleCliente();

        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nInforme a opçãoo:\n1 - Administração\n2 - Cliente\n9 - Sair");
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao){
                case 1:
                    bancoC.administracao(banco);
                    break;

                case 2:
                    clienteC.administracao(banco);
                    break;
                default:
                    if (opcao != 9){
                        System.out.println("\nOPÇÃO INVÁLIDA");
                    }
                    break;
            }
        }while (opcao != 9);
    }
}
