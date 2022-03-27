package model;

import java.util.List;

public class Pessoa_Juridica extends Pessoa {
	private String cnpj_pessoa;

	public Pessoa_Juridica() {
		super();
	}

	public Pessoa_Juridica(String cnpj_pessoa) {
		super();
		this.cnpj_pessoa = cnpj_pessoa;
	}

	public Pessoa_Juridica(Integer cod_pessoa, Integer tipo_pessoa, String nome_pessoa, String endereco_pessoa,
			String telefone_pessoa, String cep_pessoa, String bairro_pessoa, String cidade_pessoa, String uf_pessoa,
			String email_pessoa, List<Processo> processos) {
		super(cod_pessoa, tipo_pessoa, nome_pessoa, endereco_pessoa, telefone_pessoa, cep_pessoa, bairro_pessoa, cidade_pessoa,
				uf_pessoa, email_pessoa, processos);
		// TODO Auto-generated constructor stub
	}

	public String getCnpj_pessoa() {
		return cnpj_pessoa;
	}

	public void setCnpj_pessoa(String cnpj_pessoa) {
		this.cnpj_pessoa = cnpj_pessoa;
	}

	@Override
	public String toString() {
		return "Pessoa_Juridica [cnpj_pessoa=" + cnpj_pessoa + ", Tipo_Pessoa="
				+ getTipo_pessoa() + ", Nome_pessoa=" + getNome_pessoa() + ", Endereco_pessoa="
				+ getEndereco_pessoa() + ", Telefone_pessoa=" + getTelefone_pessoa() + ", Cep_pessoa="
				+ getCep_pessoa() + ", Bairro_pessoa=" + getBairro_pessoa() + ", Cidade_pessoa="
				+ getCidade_pessoa() + ", Uf_pessoa=" + getUf_pessoa() + ", Email_pessoa=" + getEmail_pessoa()
				+ ", Processos=" + getProcessos() + ", Cod_pessoa=" + getCod_pessoa() + "]";
	}

	
	
	
}
