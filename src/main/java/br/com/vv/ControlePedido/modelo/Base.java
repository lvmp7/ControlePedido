package br.com.vv.ControlePedido.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Base implements Serializable {
    private String codigo;
    private LocalDateTime dataHoraInclusao;
    private LocalDateTime dataHoraEdicao;
    /**
     * Retorna o codigo
     * @return {@link String}  Retorna uma String com o codigo
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Atribui um codigo ao pedido
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Retorna o horario em que o pedido foi gerado
     * @return {@link LocalDateTime}  Retorna um LocalDateTime com a hora da inclusão
     */
    public LocalDateTime getDataHoraInclusao() {
        return dataHoraInclusao;
    }
    /**
     * Atribui a data/hora da inclucao do pedido
     * @param dataHoraInclusao
     */
    public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }
    /**
     * Retorna o horario em que o pedido foi gerado
     * @return {@link LocalDateTime}  Retorna um LocalDateTime com a hora da edição
     */
    public LocalDateTime getDataHoraEdicao() {
        return dataHoraEdicao;
    }
    /**
     * Atribui a data/hora da inclucao do pedido
     * @param dataHoraEdicao
     */
    public void setDataHoraEdicao(LocalDateTime dataHoraEdicao) {
        this.dataHoraEdicao = dataHoraEdicao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Base other = (Base) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Base [codigo=" + codigo + "]";
    }

}
