package controller;


import java.util.Scanner;

import br.com.escritorio_advocacia.factory.PessoaDAO;
import model.Pessoa_Fisica;
import model.Pessoa_Juridica;

public class PessoaController {
	
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		int opcao = 0;
		do {
			System.out.print("\n\"-------  MENU Pessoa -------\"");
			System.out.print(
					"\n1. Inserir nova pessoa" + 
					"\n2. Atualizar uma pessoa" +
					"\n3. Listar todas pessoas" +  
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
				selectPessoas();
				break;
			default:
				if (opcao != 0)
					System.out.println("Opção inválida.");
			}
		} while (opcao != 0);

	}
	
	private static void inserir() {
		System.out.println("\nEscolha 1 para Pessoa Fisica ou 2 para Pessoa Juridica");
		int tipo_pessoa = input.nextInt();
		input.nextLine();
		if(tipo_pessoa == 1) {
			
		Pessoa_Fisica pessoa_fisica = new Pessoa_Fisica();
        System.out.println("\n++++++ Cadastro de Pessoa Fisica ++++++");
        System.out.print("Digite o nome da pessoa fisica: ");
        pessoa_fisica.setNome_pessoa(input.nextLine());
        System.out.print("\nDigite o endereço da pessoa: ");
        pessoa_fisica.setEndereco_pessoa(input.nextLine());
        System.out.println("\nDigite o telefone da pessoa: ");
        pessoa_fisica.setTelefone_pessoa(input.nextLine());
        System.out.println("\nDigite o CEP da pessoa: ");
        pessoa_fisica.setCep_pessoa(input.nextLine());
        System.out.println("\nDigite o Bairro da pessoa: ");
        pessoa_fisica.setBairro_pessoa(input.nextLine());
        System.out.println("\nDigite a cidade da pessoa: ");
        pessoa_fisica.setCidade_pessoa(input.nextLine());
        System.out.println("\nDigite o estado da pessoa: ");
        pessoa_fisica.setUf_pessoa(input.nextLine());
        System.out.println("\nDigite o email da pessoa: ");
        pessoa_fisica.setEmail_pessoa(input.nextLine());
        System.out.println("\nDigite o CPF da pessoa: ");
        pessoa_fisica.setCpf_pessoa(input.nextLine());
        System.out.println("\nDigite o RG da pessoa: ");
        pessoa_fisica.setRg_pessoa(input.nextLong());
        pessoa_fisica.setTipo_pessoa(tipo_pessoa);
        
	        if(PessoaDAO.save(pessoa_fisica, null, tipo_pessoa)) {
	        	System.out.println("\nPessoa Fisica salvo com sucesso.");
	        }else {
	        	System.out.println("\nHouve um erro ao salvar a pessoa. Por favor, contate o administrador do sistema.");
	        }
		}
		else if(tipo_pessoa == 2) {
			Pessoa_Juridica pessoa_juridica = new Pessoa_Juridica();
	        System.out.println("\n++++++ Cadastro de Pessoa Juridica ++++++");
	        System.out.print("Digite o nome da pessoa juridica: ");
	        pessoa_juridica.setNome_pessoa(input.nextLine());
	        System.out.print("\nDigite o endereço da pessoa: ");
	        pessoa_juridica.setEndereco_pessoa(input.nextLine());
	        System.out.println("\nDigite o telefone da pessoa: ");
	        pessoa_juridica.setTelefone_pessoa(input.nextLine());
	        System.out.println("\nDigite o CEP da pessoa: ");
	        pessoa_juridica.setCep_pessoa(input.nextLine());
	        System.out.println("\nDigite o Bairro da pessoa: ");
	        pessoa_juridica.setBairro_pessoa(input.nextLine());
	        System.out.println("\nDigite a cidade da pessoa: ");
	        pessoa_juridica.setCidade_pessoa(input.nextLine());
	        System.out.println("\nDigite o estado da pessoa: ");
	        pessoa_juridica.setUf_pessoa(input.nextLine());
	        System.out.println("\nDigite o email da pessoa: ");
	        pessoa_juridica.setEmail_pessoa(input.nextLine());
	        System.out.println("\nDigite o CNPJ da pessoa: ");
	        pessoa_juridica.setCnpj_pessoa(input.nextLine());
	        pessoa_juridica.setTipo_pessoa(tipo_pessoa);
	        
		        if(PessoaDAO.save(null, pessoa_juridica, tipo_pessoa)) {
		        	System.out.println("\nPessoa Juridica salvo com sucesso.");
		        }else {
		        	System.out.println("\nHouve um erro ao salvar a pessoa. Por favor, contate o administrador do sistema.");
		        }
		}
		else {
			System.out.println("\nNão existe a opção escolhida");
		}

	}
	
	private static void atualizar() throws Exception {
		System.out.println("\nDigite 1 para Pessoa Fisica e 2 para Pessoa Juridica");
		int tipo_pessoa = input.nextInt();
		input.nextLine();
		if(tipo_pessoa == 1) {
			System.out.println("\n++++++ Alterar uma Pessoa Fisica ++++++");
			Pessoa_Fisica pessoa_fisica = null;
	        int opcao = 0;
	        do{
	            System.out.print("\nDigite o código da pessoa (Zero p/sair): ");
	            int codigo = input.nextInt();
	            input.nextLine();
	            if(codigo == 0) {
	            	opcao = 0;
	            } else {
	                pessoa_fisica = PessoaDAO.selectPessoaFisicaById(codigo);
	                if(pessoa_fisica == null){
	                    System.out.println("Código inválido.");
	                }else{
	                    System.out.println("Nome: " + pessoa_fisica.getNome_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.println("Digite o novo nome da pessoa: ");
	                        pessoa_fisica.setNome_pessoa(input.nextLine());
	                    }
	                    System.out.println("Endereço: " + pessoa_fisica.getEndereco_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo endereço da pessoa: ");
	                        pessoa_fisica.setEndereco_pessoa(input.next());
	                    }
	                    System.out.println("Telefone: " + pessoa_fisica.getTelefone_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo telefone da pessoa: ");
	                        pessoa_fisica.setTelefone_pessoa(input.next());
	                    }
	                    System.out.println("CEP: " + pessoa_fisica.getCep_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo CEP da pessoa: ");
	                        pessoa_fisica.setCep_pessoa(input.next());
	                    }
	                    System.out.println("Bairro: " + pessoa_fisica.getBairro_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo bairro da pessoa: ");
	                        pessoa_fisica.setBairro_pessoa(input.next());
	                    }
	                    System.out.println("Cidade: " + pessoa_fisica.getCidade_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite a nova cidade da pessoa: ");
	                        pessoa_fisica.setCidade_pessoa(input.next());
	                    }
	                    System.out.println("Estado: " + pessoa_fisica.getUf_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo estado da pessoa: ");
	                        pessoa_fisica.setUf_pessoa(input.next());
	                    }
	                    System.out.println("Email: " + pessoa_fisica.getEmail_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo email da pessoa: ");
	                        pessoa_fisica.setEmail_pessoa(input.next());
	                    }
	                    System.out.println("CPF: " + pessoa_fisica.getCpf_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo CPF da pessoa: ");
	                        pessoa_fisica.setCpf_pessoa(input.next());
	                    }
	                    System.out.println("RG: " + pessoa_fisica.getRg_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo RG da pessoa: ");
	                        pessoa_fisica.setRg_pessoa(input.nextLong());
	                    }
	                    pessoa_fisica.setTipo_pessoa(1);
	                    if(PessoaDAO.update(pessoa_fisica, null, tipo_pessoa)){
	                        System.out.println("Pessoa Fisica salva:" + pessoa_fisica);
	                    }else{
	                        System.out.println("Erro ao tentar salvar o cliente. Por favor, contate o adminstrador.");
	                    }
	                    opcao = 1;
	                }
	
	            }
	        }while(opcao != 0); 
		}
		
		if(tipo_pessoa == 2) {
			System.out.println("\n++++++ Alterar uma Pessoa Juridica ++++++");
			Pessoa_Juridica pessoa_juridica = null;
	        int opcao = 0;
	        do{
	            System.out.print("\nDigite o código da pessoa (Zero p/sair): ");
	            int codigo = input.nextInt();
	            input.nextLine();
	            if(codigo == 0) {
	            	opcao = 0;
	            } else {
	                pessoa_juridica = PessoaDAO.selectPessoaJuridicaById(codigo);
	                if(pessoa_juridica == null){
	                    System.out.println("Código inválido.");
	                }else{
	                    System.out.println("Nome: " + pessoa_juridica.getNome_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.println("Digite o novo nome da pessoa: ");
	                        pessoa_juridica.setNome_pessoa(input.nextLine());
	                    }
	                    System.out.println("Endereço: " + pessoa_juridica.getEndereco_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo endereço da pessoa: ");
	                        pessoa_juridica.setEndereco_pessoa(input.next());
	                    }
	                    System.out.println("Telefone: " + pessoa_juridica.getTelefone_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo telefone da pessoa: ");
	                        pessoa_juridica.setTelefone_pessoa(input.next());
	                    }
	                    System.out.println("CEP: " + pessoa_juridica.getCep_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo CEP da pessoa: ");
	                        pessoa_juridica.setCep_pessoa(input.next());
	                    }
	                    System.out.println("Bairro: " + pessoa_juridica.getBairro_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo bairro da pessoa: ");
	                        pessoa_juridica.setBairro_pessoa(input.next());
	                    }
	                    System.out.println("Cidade: " + pessoa_juridica.getCidade_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite a nova cidade da pessoa: ");
	                        pessoa_juridica.setCidade_pessoa(input.next());
	                    }
	                    System.out.println("Estado: " + pessoa_juridica.getUf_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo estado da pessoa: ");
	                        pessoa_juridica.setUf_pessoa(input.next());
	                    }
	                    System.out.println("Email: " + pessoa_juridica.getEmail_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo email da pessoa: ");
	                        pessoa_juridica.setEmail_pessoa(input.next());
	                    }
	                    System.out.println("CNPJ: " + pessoa_juridica.getCnpj_pessoa());
	                    System.out.print("Alterar? (0-sim/1-não) ");
	                    if(input.nextInt() == 0){
	                    	input.nextLine();
	                        System.out.print("Digite o novo CNPJ da pessoa: ");
	                        pessoa_juridica.setCnpj_pessoa(input.next());
	                    }
	                    pessoa_juridica.setTipo_pessoa(2);
	                    if(PessoaDAO.update(null, pessoa_juridica, tipo_pessoa)){
	                        System.out.println("Pessoa Juridica salva:" + pessoa_juridica);
	                    }else{
	                        System.out.println("Erro ao tentar salvar o cliente. Por favor, contate o adminstrador.");
	                    }
	                    opcao = 1;
	                }
	
	            }
	        }while(opcao != 0); 
		}
	}
	
	private static void selectPessoas() {
		System.out.println("Digite 1 para listar as pessoas fisicas e 2 para juridicas: ");
		int tipo = input.nextInt();
		input.nextLine();
		if(tipo == 1) {
			System.out.println("\nLista de pessoas fisicas cadastradas no banco de dados:\n" + PessoaDAO.getPessoasFisicas(tipo));
		}
		if(tipo == 2) {
			System.out.println("\nLista de pessoas juridicas cadastradas no banco de dados: \n" + PessoaDAO.getPessoasJuridicas(tipo));
		}
	}
	

}
