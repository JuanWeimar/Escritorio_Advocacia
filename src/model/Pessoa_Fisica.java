package model;

import java.util.List;

public class Pessoa_Fisica extends Pessoa {
	private String cpf_pessoa;
	private long rg_pessoa;
	
	public Pessoa_Fisica() {
		super();
	}

	public Pessoa_Fisica(String cpf_pessoa, long rg_pessoa) {
		super();
		this.cpf_pessoa = cpf_pessoa;
		this.rg_pessoa = rg_pessoa;
	}

	

	public Pessoa_Fisica(Integer cod_pessoa, Integer tipo_pessoa, String nome_pessoa, String endereco_pessoa,
			String telefone_pessoa, String cep_pessoa, String bairro_pessoa, String cidade_pessoa, String uf_pessoa,
			String email_pessoa, List<Processo> processos) {
		super(cod_pessoa, tipo_pessoa, nome_pessoa, endereco_pessoa, telefone_pessoa, cep_pessoa, bairro_pessoa, cidade_pessoa,
				uf_pessoa, email_pessoa, processos);
		// TODO Auto-generated constructor stub
	}

	public String getCpf_pessoa() {
		return cpf_pessoa;
	}

	public void setCpf_pessoa(String cpf_pessoa) {
		this.cpf_pessoa = cpf_pessoa;
	}

	public long getRg_pessoa() {
		return rg_pessoa;
	}

	public void setRg_pessoa(long rg_pessoa) {
		this.rg_pessoa = rg_pessoa;
	}

	@Override
	public String toString() {
		return "Pessoa_Fisica [cpf_pessoa=" + cpf_pessoa + ", rg_pessoa=" + rg_pessoa + ", Tipo_Pessoa="
				+ getTipo_pessoa() + ", Nome_pessoa=" + getNome_pessoa() + ", Endereco_pessoa="
				+ getEndereco_pessoa() + ", Telefone_pessoa=" + getTelefone_pessoa() + ", Cep_pessoa="
				+ getCep_pessoa() + ", Bairro_pessoa=" + getBairro_pessoa() + ", Cidade_pessoa="
				+ getCidade_pessoa() + ", Uf_pessoa=" + getUf_pessoa() + ", Email_pessoa=" + getEmail_pessoa()
				+ ", Processos=" + getProcessos() + ", Cod_pessoa=" + getCod_pessoa() + "]";
	}

	

	

	
	
}
