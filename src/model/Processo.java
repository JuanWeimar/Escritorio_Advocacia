package model;

import java.util.List;

public class Processo {
	private Integer cod_processo;
	private long nro_processo;
	private String data_abertura;
	private String data_conclusao;
	private boolean situacao;
	private Integer cod_pessoa;
	private Integer cod_audiencia;
	private Integer cod_custa;
	private Integer cod_vara;
	private Pessoa pessoa;
	List<Audiencia> audiencias;
	List<Custa> custas;
	private Vara vara;
	
	public Processo() {
		super();
	}
	
	

	public Processo(Integer cod_processo, long nro_processo, String data_abertura, String data_conclusao,
			boolean situacao, Integer cod_pessoa, Integer cod_audiencia, Integer cod_custa, Integer cod_vara) {
		super();
		this.cod_processo = cod_processo;
		this.nro_processo = nro_processo;
		this.data_abertura = data_abertura;
		this.data_conclusao = data_conclusao;
		this.situacao = situacao;
		this.cod_pessoa = cod_pessoa;
		this.cod_audiencia = cod_audiencia;
		this.cod_custa = cod_custa;
		this.cod_vara = cod_vara;
	}



	public Processo(Integer cod_processo, long nro_processo, String data_abertura, String data_conclusao,
			boolean situacao, Integer cod_pessoa, Integer cod_audiencia, Integer cod_custa, Integer cod_vara,
			Pessoa pessoa, List<Audiencia> audiencias, List<Custa> custas, Vara vara) {
		super();
		this.cod_processo = cod_processo;
		this.nro_processo = nro_processo;
		this.data_abertura = data_abertura;
		this.data_conclusao = data_conclusao;
		this.situacao = situacao;
		this.cod_pessoa = cod_pessoa;
		this.cod_audiencia = cod_audiencia;
		this.cod_custa = cod_custa;
		this.cod_vara = cod_vara;
		this.pessoa = pessoa;
		this.audiencias = audiencias;
		this.custas = custas;
		this.vara = vara;
	}

	public Integer getCod_processo() {
		return cod_processo;
	}

	public void setCod_processo(Integer cod_processo) {
		this.cod_processo = cod_processo;
	}

	public long getNro_processo() {
		return nro_processo;
	}

	public void setNro_processo(long nro_processo) {
		this.nro_processo = nro_processo;
	}

	public String getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(String data_abertura) {
		this.data_abertura = data_abertura;
	}

	public String getData_conclusao() {
		return data_conclusao;
	}

	public void setData_conclusao(String data_conclusao) {
		this.data_conclusao = data_conclusao;
	}

	public boolean getSituacao() {
		return situacao;
	}

	public boolean setSituacao(boolean situacao) {
		return this.situacao = situacao;
	}

	public Integer getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(Integer cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}

	public Integer getCod_audiencia() {
		return cod_audiencia;
	}

	public void setCod_audiencia(Integer cod_audiencia) {
		this.cod_audiencia = cod_audiencia;
	}

	public Integer getCod_custa() {
		return cod_custa;
	}

	public void setCod_custa(Integer cod_custa) {
		this.cod_custa = cod_custa;
	}

	public Integer getCod_vara() {
		return cod_vara;
	}

	public void setCod_vara(Integer cod_vara) {
		this.cod_vara = cod_vara;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Audiencia> getAudiencias() {
		return audiencias;
	}

	public void setAudiencias(List<Audiencia> audiencias) {
		this.audiencias = audiencias;
	}

	public List<Custa> getCustas() {
		return custas;
	}

	public void setCustas(List<Custa> custas) {
		this.custas = custas;
	}

	public Vara getVara() {
		return vara;
	}

	public void setVara(Vara vara) {
		this.vara = vara;
	}

	@Override
	public String toString() {
		return "Processo [cod_processo=" + cod_processo + ", nro_processo=" + nro_processo + ", data_abertura="
				+ data_abertura + ", data_conclusao=" + data_conclusao + ", situacao=" + situacao + ", cod_pessoa="
				+ cod_pessoa + ", cod_audiencia=" + cod_audiencia + ", cod_custa=" + cod_custa + ", cod_vara="
				+ cod_vara + ", pessoa=" + pessoa + ", audiencias=" + audiencias + ", custas=" + custas + ", vara="
				+ vara + "]";
	}

	
	
}
