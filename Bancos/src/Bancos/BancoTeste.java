package bancos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;



public class BancoTeste {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		 Menu mn = new Menu();

		char op;
		char saida;
		int numeroConta = 1; 
		int contador = 0;
		int quantidadeMovimentacao = 10;
		int movimentacaoDisponivel = 0;
		char opcaoTipo, opcaoMov;
		int diaUsuario = 0;
		int continuar;

		List<ContaCorrente> corrente = new ArrayList<>();
		List<ContaEmpresa> empresa = new ArrayList<>();
		List<ContaEspecial> especial = new ArrayList<>();
		List<ContaPoupanca> poupanca = new ArrayList<>();
		List<ContaUniversitaria> universitaria = new ArrayList<>();
		
		do {
			mn.menuEntrada();
			op = leia.next().charAt(0);
			if (op == '1') {
				
				mn.menuPrincipal();
				char opconta = leia.next().charAt(0);

				System.out.println("Digite o seu CPF:");
				String cpfConta = leia.next();
				switch (opconta) {
				case '1': 
				{
					
					Calendar dia = GregorianCalendar.getInstance();
					int dataAniversario = dia.get(Calendar.DAY_OF_MONTH);
					
					poupanca.add(new ContaPoupanca(numeroConta, cpfConta, dataAniversario));
					numeroConta++;
				}
					break;

				case '2': {

					corrente.add(new ContaCorrente(numeroConta, cpfConta));
					numeroConta++;
				}
					break;

				case '3': 
				{

					System.out.println("Obrigado por usar o G5- BANK ");
					
				}	
				break;

				case '4': {

		

				}
					break;
					
				default:
					System.out.println("Op��o inv�lida, tente novamente!");
				

				/*
				 * case '5': {
				 * 
				 * universitaria.add(new ContaUniversitaria(numeroConta, cpfConta, 2000, 5000));
				 * 
				 * } break;
				 */

				}

			} else if (op == '2') 
			{
				String tipo = " ";
				boolean busca = false;
				System.out.println("Digite o n�mero do cpf: ");
				String numero = leia.next();
				mn.menuPrincipal();
				int opcao = leia.nextInt();
				switch (opcao) {
				case 1: {

					for (ContaPoupanca conta : poupanca) 
					{
						if (numero.equals(conta.getCpf()))
						{
							busca=true;
							
								System.out.println("SEU SALDO � DE :" +conta.getSaldo());
							
							System.out.printf("DIA DO ANIVERS�RIO DA SUA CONTA: %d", conta.getDataAniversarioConta());
							System.out.print("\nINFORME O DIA DE HOJE: ");
							diaUsuario = leia.nextInt();

							System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
							
							opcaoMov = leia.next().toUpperCase().charAt(0);
							while (opcaoMov == 'S') 
							{

								for (int x = 0; x < quantidadeMovimentacao; x++) {

									movimentacaoDisponivel = quantidadeMovimentacao - x;
									System.out.printf("\nTransa��es "+movimentacaoDisponivel);
									   
									    mn.menuPrincipal();
									
									opcaoTipo = leia.next().toUpperCase().charAt(0);

									if (opcaoTipo == 'D') {
										System.out.print("\n D�BITO :  R$ ");
										conta.debito(leia.nextDouble());
									} else if (opcaoTipo == 'C') {
										System.out.print("\nCR�DITO :  R$ ");
										conta.credito(leia.nextDouble());
									} else if (opcaoTipo == 'S') {
										System.out.printf("AGRADE�EMOS A SUA VINDA\n");
										break;
									}

									System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
									opcaoMov = leia.next().toUpperCase().charAt(0);
									while (opcaoMov != 'S' && opcaoMov != 'N') {
									System.out.println(" OP��O INV�LIDA ");
									opcao = leia.next().toUpperCase().charAt(0);
									}
									if (opcaoMov == 'N') {
										break;
									} else {
										System.out.print("\nIndo para pr�xima transa��o");
									}

								}

							}
						}

						if (diaUsuario == conta.getDataAniversarioConta()) 
						{
							conta.saldo = 1.005 * conta.saldo;
							System.out.printf("Parab�ns pra vc nesta data querida seu saldo atual � de : R$ %.2f\n", conta.saldo);
						}

					}
					if(busca==false) {
						System.out.println("PESSOA N�O POSSUI CONTA ABERTA");
					}

				}
					break;

				case 2: {

					for (ContaCorrente conta : corrente) 
					{
						if (numero.equals(conta.getCpf())) 
						{
							busca=true;
							System.out.println("SEU SALDO � DE :" +conta.getSaldo());
							System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
						

							opcaoMov = leia.next().toUpperCase().charAt(0);
							while (opcaoMov == 'S') {

								for (int x = 0; x < quantidadeMovimentacao; x++) {

									movimentacaoDisponivel = quantidadeMovimentacao - x;
									System.out.printf("\nVoc� possui %d transa��es disponiveis",
											movimentacaoDisponivel);
									System.out.println();
									System.out.printf("\nO que voc� deseja fazer: [D]-D�bito, [C]-Cr�dito , [T]-Tal�o ou [S]-Sair");
									System.out.print("\nOp��o: ");
									opcaoTipo = leia.next().toUpperCase().charAt(0);

									if (opcaoTipo == 'D') {
										System.out.print("\nInforme quanto gostaria debitar:  R$ ");
										conta.debito(leia.nextDouble());
									} else if (opcaoTipo == 'C') {
										System.out.print("\nInforme quanto gostaria creditar:  R$ ");
										conta.credito(leia.nextDouble());
									}else if (opcaoTipo=='T') {
										System.out.printf("%d Tal�es dispon�veis \n",conta.talaoRestante());
										
										if(conta.talaoRestante() != 0) {
											System.out.printf(" Vai um tal�ozin ? [S]-Sim ou [N]-N�o ");
											continuar = leia.nextInt();
											
											if(continuar == 1) {
												conta.emitirTalao();
											}	
										}
									}
									else if (opcaoTipo == 'S') {
										System.out.printf("To vazando \n");
										break;
									}

									System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
									opcaoMov = leia.next().toUpperCase().charAt(0);

									while (opcaoMov != 'S' && opcaoMov != 'N') {
										System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
									opcao = leia.next().toUpperCase().charAt(0);
									}
									if (opcaoMov == 'N') {
										break;
									} else {
										System.out.print("\n Pr�xima transa��o");
									}

								}

							}
						}

					}
					
					if(busca==false) {
						System.out.println("PESSOA N�O POSSUI CONTA ABERTA");
					}

				}
					break;

				case 3: {

					for (ContaEspecial conta : especial) {
						if (numero.equals(conta.getCpf())) {
							busca=true;
							System.out.println("SEU SALDO � DE :" +conta.getSaldo());
							System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
							System.out.print("\nOP��O: ");

							opcaoMov = leia.next().toUpperCase().charAt(0);
							while (opcaoMov == 'S') {

								for (int x = 0; x < quantidadeMovimentacao; x++) {

									movimentacaoDisponivel = quantidadeMovimentacao - x;
									System.out.printf("\nTransa��es disponiveis",movimentacaoDisponivel);
									System.out.println();
									System.out.printf("\nO que voc� deseja fazer: [D]-D�bito, [C]-Cr�dito, [T]-Tal�o ou [S]-Sair");
									System.out.print("\nOp��o: ");
									opcaoTipo = leia.next().toUpperCase().charAt(0);

									if (opcaoTipo == 'D') {
										System.out.print("\nDebito   R$ ");
										conta.debito(leia.nextDouble());
									} else if (opcaoTipo == 'C') {
										System.out.print("\nInforme quanto gostaria creditar:  R$ ");
										conta.credito(leia.nextDouble());
									}else if (opcaoTipo =='T') {
										System.out.printf(" %d Tal�es dispon�veis \n", conta.talaoRestante());
										
										if(conta.talaoRestante()!= 0) 
										{
											System.out.println("Vai um tal�ozin ? [S]-Sim ou [N]-N�o ");
											continuar = leia.nextInt();
											
											if(continuar == 1) {
												conta.emitirTalao();
											}	
										}
									}
									
									else if (opcaoTipo == 'S') {
										System.out.printf("To vazando \n");
										break;
									}

									System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
									System.out.print("\nOp��o: ");
									opcaoMov = leia.next().toUpperCase().charAt(0);

									while (opcaoMov != 'S' && opcaoMov != 'N') {
										System.out.println("CONTINUAR :[S]-Sim ou [N]-N�o ");
										System.out.print("\nOp��o: ");
										opcao = leia.next().toUpperCase().charAt(0);
									}
									if (opcaoMov == 'N') {
										break;
									} else {
										System.out.print("\nPr�xima transa��o");
									}

								}

							}
						}

					}
					
					if(busca==false) {
						System.out.println("N�o tem conta ? crie uma !!!");
					}

				}
					break;

				case 4: {

					for (ContaEmpresa conta : empresa) {
						if (numero.equals(conta.getCpf())) {

							System.out.println("SEU SALDO � DE :" +conta.getSaldo());
							System.out.println("DESEJA INICIAR UMA MOVIMENTA��O:[S]-Sim ou [N]-N�o ");
							System.out.print("\nOP��O: ");

							opcaoMov = leia.next().toUpperCase().charAt(0);
							while (opcaoMov == 'S') {

								for (int x = 0; x < quantidadeMovimentacao; x++) {

									movimentacaoDisponivel = quantidadeMovimentacao - x;
									System.out.printf("\nVoc� possui %d transa��es disponiveis",
											movimentacaoDisponivel);
									System.out.println();
									System.out.printf("\n[D]-D�bito, [C]-Cr�dito ou [S]-Sair");
									opcaoTipo = leia.next().toUpperCase().charAt(0);

									if (opcaoTipo == 'D') {
										System.out.print("\nInforme quanto gostaria debitar:  R$ ");
										conta.debito(leia.nextDouble());
									} else if (opcaoTipo == 'C') {
										System.out.print("\nInforme quanto gostaria creditar:  R$ ");
										conta.credito(leia.nextDouble());
									} else if (opcaoTipo == 'S') {
										System.out.printf("saindo...\n");
										break;
									}

									System.out.println("\nDeseja Continuar? [S]-Sim ou [N]-N�o ");
									System.out.print("\nOp��o: ");
									opcaoMov = leia.next().toUpperCase().charAt(0);

									while (opcaoMov != 'S' && opcaoMov != 'N') {
										System.out.println("Por favor digite [S] ou [N]. Tente novamente! ");
										System.out.print("\nOp��o: ");
										opcao = leia.next().toUpperCase().charAt(0);
									}
									if (opcaoMov == 'N') {
										break;
									} else {
										System.out.print("\nIndo para pr�xima transa��o");
									}

								}

							}
						}

					}

				}
					break;

				/*
				 * case 5: { System.out.println("Digite o seu CPF:");
				 * 
				 * } break;
				 */
				}

			}else if(op == '3') {
				break;
			}
		
			else {
				while (op != '1' && op != '2' && op != '3') {
					System.out.println("Selecione uma op��o v�lida!!! ");
					System.out.println("1 - Abertura de conta: ");
					System.out.println("2 - Acesso a uma conta existente: ");
					System.out.println("3 - Sair: ");
					op = leia.next().charAt(0);
				}

			}
			System.out.println("Continua S/N");
			saida = leia.next().toUpperCase().charAt(0);
			if (saida == 'N') {
				break;
			}

		} while (true);

	}

	public static void inseriLinha(int tamanho, String simbolo) {
		for (int i = 0; i < tamanho; i++) {
			System.out.print(simbolo);
		}
		System.out.println();
	}
}
