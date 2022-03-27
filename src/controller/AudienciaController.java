package controller;

import java.util.Scanner;

import br.com.escritorio_advocacia.factory.AudienciaDAO;

import model.Audiencia;

public class AudienciaController {

	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Custa -------\"");
			System.out.print(
					"\n1. Inserir uma nova audiencia" + 
					"\n2. Atualizar uma audiencia" +
					"\n3. Listar todas audiencias" + 
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
				selectAudiencias();
				break;
			default:
				if (opcao != 0)
					System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
}
	private static void inserir() {
		Audiencia audiencia = new Audiencia();
		System.out.println("\n++++++ Cadastro de Audiencia ++++++");
        System.out.print("Digite a data da audiencia: ");
        audiencia.setData_audiencia(input.nextLine());
        input.nextLine();
        System.out.print("\nDigite o parecer: ");
        audiencia.setParecer(input.nextLine());
        System.out.println("\nDigite o código do processo: ");
        audiencia.setCod_processo(input.nextInt());
        
        if(AudienciaDAO.save(audiencia)) {
        	System.out.println("\nAudiencia salva com sucesso." + audiencia);
        }else {
        	System.out.println("\nHouve um erro ao salvar a audiencia. Por favor, contate o administrador do sistema.");
        }
	}
	
	private static void atualizar() throws Exception {
		System.out.println("\n+++++++++ Alterar Audiencia +++++++");
		Audiencia audiencia = null;
	int opcao = 0;
	do {
		System.out.println("\nDigite o codigo da audiencia (Zero para sair): ");
		int codigo = input.nextInt();
		input.nextLine();
		if(codigo == 0) {
			opcao = 0;
		} else {
			audiencia = AudienciaDAO.selectAudienciaById(codigo);
			if(audiencia == null) {
				System.out.println("Código inválido. ");
			}else {
				System.out.println("Data da Audiencia: " + audiencia.getData_audiencia());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite a nova data: ");
					audiencia.setData_audiencia(input.nextLine());
				}
				System.out.println("Parecer: " + audiencia.getParecer());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite o novo parecer: ");
					audiencia.setParecer(input.nextLine());
				}
				System.out.println("Código Processo: " + audiencia.getCod_processo());
				System.out.println("Alterar? (0-sim/1-não) ");
				if(input.nextInt() == 0) {
					input.nextLine();
					System.out.println("Digite o código do processo: ");
					audiencia.setCod_processo(input.nextInt());
				}
				if(AudienciaDAO.update(audiencia)) {
					System.out.println("Audiencia salva: " + audiencia);
				}else {
					System.out.println("Erro ao tentar salvar a audiencia. Por favor, contate o administrador");
				}
				opcao = 1;
			}
		}
	}while(opcao != 0);
	}
	
	private static void selectAudiencias() {
		System.out.println("\nLista de audiencias cadastradas no banco de dados:\n" + AudienciaDAO.getAudiencias());
	}
}
