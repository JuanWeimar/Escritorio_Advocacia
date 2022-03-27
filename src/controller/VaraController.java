package controller;

import java.util.Scanner;

import br.com.escritorio_advocacia.factory.VaraDAO;
import model.Vara;

public class VaraController {

		public static final Scanner input = new Scanner(System.in);

		public static void main(String[] args) throws Exception {
			
			int opcao = 0;
			do {
				System.out.print("\n\"-------  MENU Vara -------\"");
				System.out.print(
						"\n1. Inserir uma nova vara" + 
						"\n2. Atualizar uma vara" +
						"\n3. Listar todas varas" + 
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
					selectVaras();
					break;
				default:
					if (opcao != 0)
						System.out.println("Opção inválida.");
				}
			} while (opcao != 0);
	}
		private static void inserir() {
			Vara vara = new Vara();
			System.out.println("\n++++++ Cadastro de Vara ++++++");
	        System.out.print("Digite a descrição da vara: ");
	        vara.setDescricao_vara(input.nextLine());
	        input.nextLine();
	        System.out.print("\nDigite o código do tribunal: ");
	        vara.setCod_tribunal(input.nextInt());
	        
	        if(VaraDAO.save(vara)) {
	        	System.out.println("\nVara salva com sucesso." + vara);
	        }else {
	        	System.out.println("\nHouve um erro ao salvar a vara. Por favor, contate o administrador do sistema.");
	        }

		}
		
		private static void atualizar() throws Exception {
			System.out.println("\n+++++++++ Alterar Vara +++++++");
			Vara vara = null;
		int opcao = 0;
		do {
			System.out.println("\nDigite o codigo da vara (Zero para sair): ");
			int codigo = input.nextInt();
			input.nextLine();
			if(codigo == 0) {
				opcao = 0;
			} else {
				vara = VaraDAO.selectVaraById(codigo);
				if(vara == null) {
					System.out.println("Código inválido. ");
				}else {
					System.out.println("Descrição: " + vara.getDescricao_vara());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite a nova descrição: ");
						vara.setDescricao_vara(input.nextLine());
					}
					System.out.println("Código Tribunal: " + vara.getCod_tribunal());
					System.out.println("Alterar? (0-sim/1-não) ");
					if(input.nextInt() == 0) {
						input.nextLine();
						System.out.println("Digite o novo código do tribunal: ");
						vara.setCod_tribunal(input.nextInt());
					}
					
					if(VaraDAO.update(vara)) {
						System.out.println("Vara salva: " + vara);
					}else {
						System.out.println("Erro ao tentar salvar a vara. Por favor, contate o administrador");
					}
					opcao = 1;
				}
			}
		}while(opcao != 0);
		}
		
		private static void selectVaras() {
			System.out.println("\nLista de varas cadastradas no banco de dados:\n" + VaraDAO.getVaras());
		}
		
}
