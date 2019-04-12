package br.com.vv.ControlePedido.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends Base {
    private String nomeCliente;
    private String nomeFilial;
    private List<ItemPedido> itens = new ArrayList<>();

    /**
     * Retorna o valor total do pedido
     * @return {@link BigDecimal} retorna um BigDecimal com o valor total calculado
     */
    public BigDecimal getValor() {
        if (itens.isEmpty()) {
            return BigDecimal.ZERO;
        } else {
            BigDecimal total = BigDecimal.ZERO;
            for (ItemPedido it : itens) {
                total = total.add(it.getValor().multiply(BigDecimal.valueOf(it.getQuantidade())));
            }
            return total;
        }
    }
    /**
     * Retorna o nome do Cliente
     * @return {@link String}  Retorna uma String com o nome do Cliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }
    /**
     * Atribui um nome ao cliente
     * @param nomeCliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    /**
     * Retorna o nome da Filial
     * @return {@link String}  Retorna uma String com o nome do Filial
     */
    public String getNomeFilial() {
        return nomeFilial;
    }
    /**
     * Atribui o nome da Filial
     * @param nomeFilial
     */
    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }
    /**
     * Retorna a lista de Itens do Pedido
     * @return {@link List}  Retorna um List com os Itens do pedido
     */
    public List<ItemPedido> getItens() {
        return itens;
    }
    /**
     * Atribui uma lista de Itens no pedido
     * @param itens
     */
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
