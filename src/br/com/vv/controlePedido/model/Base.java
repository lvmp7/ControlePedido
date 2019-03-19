package br.com.vv.controlePedido.model;

import java.time.LocalDateTime;

public class Base {
	 private int codigo;
	 private LocalDateTime dataHoraInclusao;
	 private LocalDateTime dataHoraEdicao;
	 
	 /**
	  *Necessita passar um codigo do tipo int para instaciar a classe
	  *
	  *@param codigo  
	  *
	  */
	 public Base(int codigo) {
		this.codigo = codigo;
		dataHoraInclusao = LocalDateTime.now();
	}
	 /**
	  * 
	  * Retorna o codigo
	  * @return
	  * Retorna um int com o codigo
	  */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * Retorna a data/hora da inclusao
	 * 
	 * @return
	 * retorna um LocalDatetime com a data/hora da criação
	 */
	public LocalDateTime getDataHoraInclusao() {
		return dataHoraInclusao;
	}
	
	/**
	 * seta a data/hora da alteração
	 * @param dataHoraEdicao
	 */
	public void setDataHoraEdicao(LocalDateTime dataHoraEdicao) {
		this.dataHoraEdicao = dataHoraEdicao;
	}
	
	/**
	 * retorna a data/hora da ultima alteração
	 * @return
	 * retorna um LocalDatetime com a data/hora da edição
	 */
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