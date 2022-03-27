package controller;

import java.util.Scanner;

import br.com.escritorio_advocacia.factory.CustaDAO;
import model.Custa;

public class CustaController {

	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {

		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Custa -------\"");
			System.out.print(
					"\n1. Inserir uma nova custa" + 
					"\n2. Atualizar uma custa" +
					"\n3. Listar todas custas" + 
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
				selectCustas();
				break;
			default:
				if (opcao != 0)
					System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
}
	private static void inserir() {
		Custa custa = new Custa();
		System.out.println("\n++++++ Cadastro de Custa ++++++");
        System.out.print("Digite a data da custa: ");
        custa.setData_custa(input.nextLine());
        input.nextLine();
        System.out.print("\nDigite a descrição da custa: ");
        custa.setDescricao_custa(input.nextLine());
        System.out.println("\nDigite o valor da custa: ");
        custa.setValor_custa(input.nextDouble());
        System.out.println("\nDigite o código do processo");
        custa.setCod_processo(input.nextInt());
        
        if(CustaDAO.save(custa)) {
        	System.out.println("\nCusta salva com sucesso." + custa);
        }else {
        	System.out.println("\nHouve um erro ao salvar a custa. Por favor, contate o administrador do sistema.");
        }
	}
	
	private static void atualizar() throws Exception {
		System.out.println("\n+++++++++ Alterar Custa +++++++");
		Custa custa = null;
	int opcao = 0;
	do {
		System.out.println("\nDigite o codigo da custa (Zero para sair): ");
		int codigo = input.nextInt();
		input.nextLine();
		if(codigo == 0) {
			opcao = 0;
		} else {
			custa = CustaDAO.selectCustaById(codigo);
			if(custa == null) {
				System.out.println("Código inválido. ");
			}else {
				System.out.println("Data da Custa: " + custa.getData_custa());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite a nova data: ");
					custa.setData_custa(input.nextLine());
				}
				System.out.println("Descrição da Custa: " + custa.getDescricao_custa());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite a nova descrição da custa: ");
					custa.setDescricao_custa(input.nextLine());
				}
				System.out.println("Valor da Custa: " + custa.getValor_custa());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite o novo valor da custa: ");
					custa.setValor_custa(input.nextDouble());
				}
				System.out.println("Código do Processo: " + custa.getCod_processo());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite o novo código do processo: ");
					custa.setCod_processo(input.nextInt());
				}
				if(CustaDAO.update(custa)) {
					System.out.println("Custa salva: " + custa);
				}else {
					System.out.println("Erro ao tentar salvar a custa. Por favor, contate o administrador");
				}
				opcao = 1;
			}
		}
	}while(opcao != 0);
	}
	
	private static void selectCustas() {
		System.out.println("\nLista de custas cadastradas no banco de dados:\n" + CustaDAO.getCustas());
	}

}
