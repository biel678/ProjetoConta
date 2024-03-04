package conta;

import java.util.Scanner;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND +"*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = scan.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_PURPLE_BOLD+"\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				scan.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Criar Conta\n\n");

				break;

			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Listar todas as Contas\n\n");

				break;

			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Consultar dados da Conta - por número\n\n");

				break;

			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Atualizar dados da Conta\n\n");

				break;

			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Apagar a Conta\n\n");

				break;

			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Saque\n\n");

				break;

			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Depósito\n\n");

				break;

			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD+"Transfer~encia entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida!\n");
			}

		}

	}
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por:  ");
		System.out.println("Gabriel Carvalho Tomarchio - bieltomarchio@hotmail.com");
		System.out.println("github.com/biel678/");
		System.out.println("*********************************************************");
	}
}
