package model;

import java.util.List;

public abstract class Pessoa {
	private Integer cod_pessoa;
	private Integer tipo_pessoa;
	private String nome_pessoa;
	private String endereco_pessoa;
	private String telefone_pessoa;
	private String cep_pessoa;
	private String bairro_pessoa;
	private String cidade_pessoa;
	private String uf_pessoa;
	private String email_pessoa;
	List<Processo> processos;
	
	public Pessoa() {
		super();
	}


	public Pessoa(Integer cod_pessoa, Integer tipo_pessoa, String nome_pessoa, String endereco_pessoa,
			String telefone_pessoa, String cep_pessoa, String bairro_pessoa, String cidade_pessoa, String uf_pessoa,
			String email_pessoa, List<Processo> processos) {
		super();
		this.cod_pessoa = cod_pessoa;
		this.tipo_pessoa = tipo_pessoa;
		this.nome_pessoa = nome_pessoa;
		this.endereco_pessoa = endereco_pessoa;
		this.telefone_pessoa = telefone_pessoa;
		this.cep_pessoa = cep_pessoa;
		this.bairro_pessoa = bairro_pessoa;
		this.cidade_pessoa = cidade_pessoa;
		this.uf_pessoa = uf_pessoa;
		this.email_pessoa = email_pessoa;
		this.processos = processos;
	}



	public Integer getTipo_pessoa() {
		return tipo_pessoa;
	}

	public void setTipo_pessoa(Integer tipo_pessoa) {
		this.tipo_pessoa = tipo_pessoa;
	}

	public String getNome_pessoa() {
		return nome_pessoa;
	}

	public void setNome_pessoa(String nome_pessoa) {
		this.nome_pessoa = nome_pessoa;
	}

	public String getEndereco_pessoa() {
		return endereco_pessoa;
	}

	public void setEndereco_pessoa(String endereco_pessoa) {
		this.endereco_pessoa = endereco_pessoa;
	}

	public String getTelefone_pessoa() {
		return telefone_pessoa;
	}

	public void setTelefone_pessoa(String telefone_pessoa) {
		this.telefone_pessoa = telefone_pessoa;
	}

	public String getCep_pessoa() {
		return cep_pessoa;
	}

	public void setCep_pessoa(String cep_pessoa) {
		this.cep_pessoa = cep_pessoa;
	}

	public String getBairro_pessoa() {
		return bairro_pessoa;
	}

	public void setBairro_pessoa(String bairro_pessoa) {
		this.bairro_pessoa = bairro_pessoa;
	}

	public String getCidade_pessoa() {
		return cidade_pessoa;
	}

	public void setCidade_pessoa(String cidade_pessoa) {
		this.cidade_pessoa = cidade_pessoa;
	}

	public String getUf_pessoa() {
		return uf_pessoa;
	}

	public void setUf_pessoa(String uf_pessoa) {
		this.uf_pessoa = uf_pessoa;
	}

	public String getEmail_pessoa() {
		return email_pessoa;
	}

	public void setEmail_pessoa(String email_pessoa) {
		this.email_pessoa = email_pessoa;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Integer getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(Integer cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}


	@Override
	public String toString() {
		return "Pessoa [cod_pessoa=" + cod_pessoa + ", tipo_pessoa=" + tipo_pessoa + ", nome_pessoa=" + nome_pessoa
				+ ", endereco_pessoa=" + endereco_pessoa + ", telefone_pessoa=" + telefone_pessoa + ", cep_pessoa="
				+ cep_pessoa + ", bairro_pessoa=" + bairro_pessoa + ", cidade_pessoa=" + cidade_pessoa + ", uf_pessoa="
				+ uf_pessoa + ", email_pessoa=" + email_pessoa + ", processos=" + processos + "]";
	}

	
}
