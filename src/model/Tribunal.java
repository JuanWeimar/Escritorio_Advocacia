package model;

import java.util.List;

public class Tribunal {
	private Integer cod_tribunal;
	private String descricao_tribunal;
	private String endereco_tribunal;
	List<Vara> varas;
	
	public Tribunal() {
		super();
	}

	public Tribunal(Integer cod_tribunal, String descricao_tribunal, String endereco_tribunal, List<Vara> varas) {
		super();
		this.cod_tribunal = cod_tribunal;
		this.descricao_tribunal = descricao_tribunal;
		this.endereco_tribunal = endereco_tribunal;
		this.varas = varas;
	}

	public Integer getCod_tribunal() {
		return cod_tribunal;
	}

	public void setCod_tribunal(Integer cod_tribunal) {
		this.cod_tribunal = cod_tribunal;
	}

	public String getDescricao_tribunal() {
		return descricao_tribunal;
	}

	public void setDescricao_tribunal(String descricao_tribunal) {
		this.descricao_tribunal = descricao_tribunal;
	}

	public String getEndereco_tribunal() {
		return endereco_tribunal;
	}

	public void setEndereco_tribunal(String endereco_tribunal) {
		this.endereco_tribunal = endereco_tribunal;
	}

	public List<Vara> getVaras() {
		return varas;
	}

	public void setVaras(List<Vara> varas) {
		this.varas = varas;
	}

	@Override
	public String toString() {
		return "Tribunal [cod_tribunal=" + cod_tribunal + ", descricao_tribunal=" + descricao_tribunal
				+ ", endereco_tribunal=" + endereco_tribunal + ", varas=" + varas + "]";
	}

	
	
}
