package br.com.udemy.java.secao13.entities;

public class PedidoItem {
	
	private int quantidade;
	private Double preco;
	private Produto produto;
	
	public PedidoItem(int quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Double getPreco() {
		return preco;
	}
	
	public Double subTotal() {
		return produto.getPreco()*quantidade;
	}

	public Produto getProduto() {
		return produto;
	}
	
	

}
