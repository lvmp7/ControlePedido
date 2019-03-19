package br.com.vv.controlePedido.model;

import java.time.LocalDateTime;

public class Base {
	 private int codigo;
	 private LocalDateTime dataHoraInclusao;
	 private LocalDateTime dataHoraEdicao;
	
	 public Base(int codigo) {
		this.codigo = codigo;
		dataHoraInclusao = LocalDateTime.now();
	}

	public int getCodigo() {
		return codigo;
	}
	
	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}
	
	public void setDataHoraEdicao(LocalDateTime dataHoraEdicao) {
		this.dataHoraEdicao = dataHoraEdicao;
	}
	
	public LocalDateTime getDataHoraEdicao() {
		return dataHoraEdicao;
	}
	
	 @Override
	public boolean equals(Object obj) {
		Base v = (Base) obj;
		return (this.codigo == v.getCodigo());
	}
	
	@Override
	public int hashCode() {
		return codigo;
	}
	 
	 @Override
	public String toString() {
		return String.valueOf(codigo);
	}
}
