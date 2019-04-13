package br.com.vv.ControlePedido.modelo;

import java.math.BigDecimal;

public class ItemPedido extends Base{
    private BigDecimal valor;
    private Integer quantidade;
    private String nome;
    /**
     * Retorna o valor do item
     * @return {@link BigDecimal} retorna um BigDecimal com o valor o item
     */
    public BigDecimal getValor() {
        return valor;
    }
    /**
     * Atribui o valor do item
     * @param valor
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    /**
     * Retorna a quantidade de um mesmo item
     * @return {@link Integer} retorna um Integer com a quantidade de itens
     */
    public Integer getQuantidade() {
        return quantidade;
    }
    /**
     * Atribui a quantidade de um mesmo item
     * @param quantidade
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Retorna o nome doitem
     * @return {@link String} retorna o nome do item
     */
    public String getNome() {
        return nome;
    }
    /**
     * Atribui um nome ao item
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Item [valor=" + valor + ", quantidade=" + quantidade + ", nome=" + nome + "]";
    }
}
