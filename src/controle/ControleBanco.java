package controle;

import java.util.Scanner;

import administracao.Banco;

public class ControleBanco {
    Scanner in = new Scanner(System.in);
    int opcao;

    public void administracao(Banco banco){
        do{
            System.out.print("\n1 - Cadastrar Agência\n2 - Excluir Agência\n"
                    + "3 - Cadastrar Cliente\n4 - Excluir Cliente\n5 - Abrir Conta Corrente\n6 - Abrir Conta Poupança\n"
                    + "7 - Fechar Conta Corrente\n8 - Fechar Conta Poupança\n9 - Efetuar desconto de manutenção\n"
                    + "10 - Efetuar rendimento de poupança\n11 - Alterar taxa de manutenção\n12 - "
                    + "Alterar rendimento da poupança\n13 - Editar Agência\n14 - Editar Cliente\n"
                    + "15 - Voltar\nInforme a opção desejada: ");
            this.opcao = this.in.nextInt();
            in.nextLine();

            switch (this.opcao){
                case 1:
                    banco.cadastrarAgencia();
                    break;
                case 2:
                    banco.excluirAgencia();
                    break;
                case 3:
                    banco.cadastrarCliente();
                    break;
                case 4:
                    banco.excluirCliente();
                    break;
                case 5:
                    banco.abrirContaCorrente();
                    break;
                case 6:
                    banco.abrirContaPoupanca();
                    break;
                case 7:
                    banco.fecharContaCorrente();
                    break;
                case 8:
                    banco.fecharContaPoupanca();
                    break;
                case 9:
                    banco.efetuarManutencao();
                    break;
                case 10:
                    banco.efetuarRendimento();
                    break;
                case 11:
                    banco.alterarManutencao();
                    break;
                case 12:
                    banco.alterarRendimento();
                    break;
                case 13:
                    banco.editarAgencia();
                    break;
                case 14:
                    banco.editarCliente();
                    break;
                default:
                    if (this.opcao != 15){
                        System.out.println("\nOPÇÃO INVÁLIDA");
                    }
                    break;
            }
        }while (this.opcao != 15);
    }
}
