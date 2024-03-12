package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner scan = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Joao da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
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

			try {
				opcao = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scan.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_PURPLE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				scan.close();
				System.exit(0);
			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Criar Conta\n\n");

				System.out.println("Digite o Número da Agência: ");
				agencia = scan.nextInt();
				System.out.println("Digite o Tipo da Conta (1-Conta Corrente ou 2- Conta Poupança): ");
				scan.skip("\\R?");
				titular = scan.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1-Conta Corrente ou 2- Conta Poupança): ");
					tipo = scan.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scan.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o Limite de Crédito (R$): ");
					limite = scan.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do Aniversario da Conta: ");
					aniversario = scan.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta; ");
				numero = scan.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o numero da agência:");
					agencia = scan.nextInt();
					System.out.println("Digite o Nome do Titular");
					scan.skip("\\R?");
					titular = scan.nextLine();
					
					System.out.println("Digite o Saldo da conta (R$): ");
					saldo = scan.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = scan.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero,agencia,tipo,titular,saldo,limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = scan.nextInt();
						
						contas.atualizar(new ContaPoupanca(numero,agencia,tipo,titular,saldo,aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}			
				} else {
					System.out.println("A conta não foi encontrada!");
				}
				
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Apagar a Conta\n\n");

				System.out.println("Digite o número da conta:");
				numero = scan.nextInt();
				contas.deletar(numero);
				
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Saque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = scan.nextFloat();
				}while(valor<= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Depósito\n\n");

				System.out.println("Digite o número da conta:");
				numero = scan.nextInt();
				
				do {
					System.out.println("Digite o valor do depósito (R$):");
					valor = scan.nextFloat();
				}while (valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o número da conta de origem:");
				numero = scan.nextInt();
				System.out.println("Digite o número da conta de destino:");
				numeroDestino = scan.nextInt();
				
				do {
					System.out.println("Digite o valor da transferêrencia (R$):");
					valor = scan.nextFloat();
				}while (valor<= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
			}

		}

	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
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
