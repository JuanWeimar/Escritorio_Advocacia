package controller;


import java.util.Scanner;
import br.com.escritorio_advocacia.factory.ProcessoDAO;
import model.Processo;

public class ProcessoController {
	
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Pessoa -------\"");
			System.out.print(
					"\n1. Inserir um novo processo" + 
					"\n2. Atualizar um processo" +
					"\n3. Listar todos processos" + 
					"\n4. Apagar um processo" +
					"\nOpção (Zero p/sair): ");
			opcao = input.nextInt();
			input.nextLine();
			switch (opcao) {
			case 1:
				inserir();
				break;
			case 2:
				atualizar();
				break;
			case 3:
				selectProcessos();
				break;
			case 4:
				softDeleteProcesso();
			default:
				if (opcao != 0)
					System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}
		
		private static void inserir() {
			Processo processo = new Processo();
			System.out.println("\n++++++ Cadastro de Processo ++++++");
	        System.out.print("Digite o número do processo: ");
	        processo.setNro_processo(input.nextLong());
	        input.nextLine();
	        System.out.print("\nDigite a data da abertura: ");
	        processo.setData_abertura(input.nextLine());
	        System.out.println("\nDigite a data da conclusão: ");
	        processo.setData_conclusao(input.nextLine());
	        System.out.println("\nDigite o codigo de pessoa: ");
	        processo.setCod_pessoa(input.nextInt());
	        System.out.println("\nDigite o codigo da vara: ");
	        processo.setCod_vara(input.nextInt());
	        processo.setSituacao(true);
	        
	        if(ProcessoDAO.save(processo)) {
	        	System.out.println("\nProcesso salvo com sucesso." + processo);
	        }else {
	        	System.out.println("\nHouve um erro ao salvar o processo. Por favor, contate o administrador do sistema.");
	        }

		}
		
		private static void atualizar() throws Exception {
			System.out.println("\n+++++++++ Alterar Processo +++++++");
			Processo processo = null;
		int opcao = 0;
		do {
			System.out.println("\nDigite o codigo do processo (Zero para sair): ");
			int codigo = input.nextInt();
			input.nextLine();
			if(codigo == 0) {
				opcao = 0;
			} else {
				processo = ProcessoDAO.selectProcessoById(codigo);
				if(processo == null) {
					System.out.println("Código inválido. ");
				}else {
					System.out.println("Número: " + processo.getNro_processo());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite o novo número: ");
						processo.setNro_processo(input.nextLong());
					}
					System.out.println("Data Abertura: " + processo.getData_abertura());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite a nova Data de Abertura: ");
						processo.setData_abertura(input.nextLine());
					}
					System.out.println("Data Conclusão: " + processo.getData_conclusao());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite a nova Data de Conclusão: ");
						processo.setData_conclusao(input.nextLine());
					}
					System.out.println("Situação: " + processo.getSituacao());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite a nova Situação: ");
						processo.setSituacao(input.nextBoolean());
					}
					System.out.println("Código Pessoa: " + processo.getCod_pessoa());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite o novo código: ");
						processo.setCod_pessoa(input.nextInt());
					}
					System.out.println("Código Vara: " + processo.getCod_vara());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite a nova Vara: ");
						processo.setCod_vara(input.nextInt());
					}
					
					if(ProcessoDAO.update(processo)) {
						System.out.println("Processo salvo: " + processo);
					}else {
						System.out.println("Erro ao tentar salvar o processo. Por favor, contate o administrador");
					}
					opcao = 1;
				}
			}
		}while(opcao != 0); 
		}
		
		private static void selectProcessos() {
			System.out.println("\nLista de processos cadastrados no banco de dados:\n" + ProcessoDAO.getProcessos());
		}
		
		private static void softDeleteProcesso() throws Exception {
			Processo processo = null;
			int opcao = 0;
			boolean situacao = true;
			do {
				System.out.println("\nDigite o codigo do processo (Zero para sair): ");
				int codigo = input.nextInt();
				input.nextLine();
				if(codigo == 0) {
					opcao = 0;
				} else {
					processo = ProcessoDAO.selectProcessoById(codigo);
					if(processo == null) {
						System.out.println("Código inválido. ");
					}else {
						situacao = processo.setSituacao(false);
					}	
						if(ProcessoDAO.softDeleteProcesso(codigo, situacao)) {
							System.out.println("Processo Apagado: " + processo);
						}else {
							System.out.println("Erro ao tentar apagar o processo. Por favor, contate o administrador");
						}
						opcao = 1;
					}
			}while(opcao != 0); 
		}
}
