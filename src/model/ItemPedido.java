package model;
public class ItemPedido extends Base {
	private static int codigoItem = 1;
	private double valor;
	private int quantidade;
	private String nome;
	
	public ItemPedido(String nome, double valor, int quantidade) {
		super(ItemPedido.codigoItem);
		this.valor = valor;
		this.quantidade = quantidade;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public double getValor() {
		return valor;
	}
}