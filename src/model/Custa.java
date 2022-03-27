package model;

public class Custa {
	private Integer cod_custa;
	private String data_custa;
	private String descricao_custa;
	private double valor_custa;
	private Integer cod_processo;
	
	public Custa() {
		super();
	}

	public Custa(Integer cod_custa, String data_custa, String descricao_custa, double valor_custa,
			Integer cod_processo) {
		super();
		this.cod_custa = cod_custa;
		this.data_custa = data_custa;
		this.descricao_custa = descricao_custa;
		this.valor_custa = valor_custa;
		this.cod_processo = cod_processo;
	}

	public Integer getCod_custa() {
		return cod_custa;
	}

	public void setCod_custa(Integer cod_custa) {
		this.cod_custa = cod_custa;
	}

	public String getData_custa() {
		return data_custa;
	}

	public void setData_custa(String data_custa) {
		this.data_custa = data_custa;
	}

	public String getDescricao_custa() {
		return descricao_custa;
	}

	public void setDescricao_custa(String descricao_custa) {
		this.descricao_custa = descricao_custa;
	}

	public double getValor_custa() {
		return valor_custa;
	}

	public void setValor_custa(double valor_custa) {
		this.valor_custa = valor_custa;
	}

	public Integer getCod_processo() {
		return cod_processo;
	}

	public void setCod_processo(Integer cod_processo) {
		this.cod_processo = cod_processo;
	}

	@Override
	public String toString() {
		return "Custa [cod_custa=" + cod_custa + ", data_custa=" + data_custa + ", descricao_custa=" + descricao_custa
				+ ", valor_custa=" + valor_custa + ", cod_processo=" + cod_processo + "]";
	}

	
	
}
