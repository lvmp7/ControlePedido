package model;

import java.util.Calendar;

public class Base {
	 private int codigo;
	 private Calendar dataHoraInclusao;
	 private Calendar dataHoraEdicao;
	
	 public Base(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setDataHoraInclusao(Calendar dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}
	
	public Calendar getDataHoraInclusao() {
		return dataHoraInclusao;
	}
	
	public void setDataHoraEdicao(Calendar dataHoraEdicao) {
		this.dataHoraEdicao = dataHoraEdicao;
	}
	
	public Calendar getDataHoraEdicao() {
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
