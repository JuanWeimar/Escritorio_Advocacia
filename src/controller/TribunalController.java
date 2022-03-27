package controller;

import java.util.Scanner;

import br.com.escritorio_advocacia.factory.TribunalDAO;
import model.Tribunal;

public class TribunalController {

	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Tribunal -------\"");
			System.out.print(
					"\n1. Inserir um novo tribunal" + 
					"\n2. Atualizar um tribunal" +
					"\n3. Listar todos tribunais" + 
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
				selectTribunais();
				break;
			default:
				if (opcao != 0)
					System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
}
	private static void inserir() {
		Tribunal tribunal = new Tribunal();
		System.out.println("\n++++++ Cadastro de Tribunal ++++++");
        System.out.print("Digite a descrição do tribunal: ");
        tribunal.setDescricao_tribunal(input.nextLine());
        input.nextLine();
        System.out.print("\nDigite o endereço do tribunal: ");
        tribunal.setEndereco_tribunal(input.nextLine());
        
        if(TribunalDAO.save(tribunal)) {
        	System.out.println("\nTribunal salvo com sucesso." + tribunal);
        }else {
        	System.out.println("\nHouve um erro ao salvar o tribunal. Por favor, contate o administrador do sistema.");
        }
	}
	
	private static void atualizar() throws Exception {
		System.out.println("\n+++++++++ Alterar Tribunal +++++++");
		Tribunal tribunal = null;
	int opcao = 0;
	do {
		System.out.println("\nDigite o codigo do tribunal (Zero para sair): ");
		int codigo = input.nextInt();
		input.nextLine();
		if(codigo == 0) {
			opcao = 0;
		} else {
			tribunal = TribunalDAO.selectTribunalById(codigo);
			if(tribunal == null) {
				System.out.println("Código inválido. ");
			}else {
				System.out.println("Descrição: " + tribunal.getDescricao_tribunal());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite a nova descrição: ");
					tribunal.setDescricao_tribunal(input.nextLine());
				}
				System.out.println("Endereço: " + tribunal.getEndereco_tribunal());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite o novo endereço do tribunal: ");
					tribunal.setEndereco_tribunal(input.nextLine());
				}
				
				if(TribunalDAO.update(tribunal)) {
					System.out.println("Tribunal salvo: " + tribunal);
				}else {
					System.out.println("Erro ao tentar salvar o tribunal. Por favor, contate o administrador");
				}
				opcao = 1;
			}
		}
	}while(opcao != 0);
	}
	
	private static void selectTribunais() {
		System.out.println("\nLista de tribunais cadastradas no banco de dados:\n" + TribunalDAO.getTribunais());
	}

}
