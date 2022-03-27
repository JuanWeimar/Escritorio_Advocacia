package model;

public class Audiencia {
	private Integer cod_audiencia;
	private String data_audiencia;
	private String parecer;
	private Integer cod_processo;
	private Processo processo;
	
	public Audiencia() {
		super();
	}

	public Audiencia(Integer cod_audiencia, String data_audiencia, String parecer, Integer cod_processo,
			Processo processo) {
		super();
		this.cod_audiencia = cod_audiencia;
		this.data_audiencia = data_audiencia;
		this.parecer = parecer;
		this.cod_processo = cod_processo;
		this.processo = processo;
	}

	public Integer getCod_audiencia() {
		return cod_audiencia;
	}

	public void setCod_audiencia(Integer cod_audiencia) {
		this.cod_audiencia = cod_audiencia;
	}

	public String getData_audiencia() {
		return data_audiencia;
	}

	public void setData_audiencia(String data_audiencia) {
		this.data_audiencia = data_audiencia;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Integer getCod_processo() {
		return cod_processo;
	}

	public void setCod_processo(Integer cod_processo) {
		this.cod_processo = cod_processo;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	@Override
	public String toString() {
		return "Audiencia [cod_audiencia=" + cod_audiencia + ", data_audiencia=" + data_audiencia + ", parecer="
				+ parecer + ", cod_processo=" + cod_processo + ", processo=" + processo + "]";
	}

	
}
