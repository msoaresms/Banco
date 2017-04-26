package controle;

import java.util.Scanner;

import administracao.Banco;

public class ControleCliente {
    public void administracao(Banco banco){
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int opcao;
        do{
            System.out.print("\n1 - Ver Saldo\n2 - Debitar\n3 - Creditar\n4 - Transferir\n"
                    + "5 - Histórico\n6 - Voltar\nInforme a opção desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao){
                case 1:
                    banco.verSaldo();
                    break;
                case 2:
                    banco.debitar();
                    break;
                case 3:
                    banco.creditar();
                    break;
                case 4:
                    banco.transferir(banco);
                    break;
                case 5:
                    banco.historico();
                    break;
                default:
                    if (opcao != 6){
                        System.out.println("\nOPÇÃO INVÁLIDA");
                    }
                    break;
            }
        }while(opcao != 6);
    }
}
