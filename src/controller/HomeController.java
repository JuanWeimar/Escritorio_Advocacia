package controller;

import java.util.Scanner;

public class HomeController {
	
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		int opcao = 0;
		do {
			System.out.println("\n------------Home--------");
			System.out.println(
					"\n1. Audiencia" +
					"\n2. Manter Processos" +
					"\n3. Manter Pessoas" +
					"\n4. Manter Custa" +
					"\n5. Manter Vara" +
					"\n6. Manter Tribunal" +
					"\n0. Opção (Zero para sair): ");
			opcao = input.nextInt();
			switch(opcao) {
				case 1:
					AudienciaController.main(null);
					break;
				case 2:
					ProcessoController.main(null);
					break;
				case 3:
					PessoaController.main(null);
					break;
				case 4:
					CustaController.main(null);
					break;
				case 5:
					VaraController.main(null);
					break;
				case 6:
					TribunalController.main(null);
					break;
				default:
					if(opcao != 0) System.out.println("Opção Inválida.");
			}
		} while(opcao != 0);
		System.out.println("Fim da Aplicação");

	}

}
