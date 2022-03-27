package model;

import java.util.List;

public class Vara {
	private Integer cod_vara;
	private String descricao_vara;
	private Integer cod_tribunal;
	List<Processo> processos;
	private Tribunal tribunal;
	
	public Vara() {
		super();
	}

	public Vara(Integer cod_vara, String descricao_vara, Integer cod_tribunal, List<Processo> processos,
			Tribunal tribunal) {
		super();
		this.cod_vara = cod_vara;
		this.descricao_vara = descricao_vara;
		this.cod_tribunal = cod_tribunal;
		this.processos = processos;
		this.tribunal = tribunal;
	}

	public Integer getCod_vara() {
		return cod_vara;
	}

	public void setCod_vara(Integer cod_vara) {
		this.cod_vara = cod_vara;
	}

	public String getDescricao_vara() {
		return descricao_vara;
	}

	public void setDescricao_vara(String descricao_vara) {
		this.descricao_vara = descricao_vara;
	}

	public Integer getCod_tribunal() {
		return cod_tribunal;
	}

	public void setCod_tribunal(Integer cod_tribunal) {
		this.cod_tribunal = cod_tribunal;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Tribunal getTribunal() {
		return tribunal;
	}

	public void setTribunal(Tribunal tribunal) {
		this.tribunal = tribunal;
	}

	@Override
	public String toString() {
		return "Vara [cod_vara=" + cod_vara + ", descricao_vara=" + descricao_vara + ", cod_tribunal=" + cod_tribunal
				+ ", processos=" + processos + ", tribunal=" + tribunal + "]";
	}

	
	
}
