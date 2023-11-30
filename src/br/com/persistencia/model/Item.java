package br.com.persistencia.model;

import br.com.persistencia.dao.PedidoDAO;
import br.com.persistencia.dao.ProdutoDAO;

public class Item {
	//Informações do Item
	private int id;
	private int quantidade;
	private float preco;
	//Informações Relacionadas
	private Pedido pedido = new Pedido();
	private Produto produto = new Produto();
	
	public Item(int id, int quantidade, float preco) {
		this.setId(id);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public Pedido getPedido(int id) {
		PedidoDAO ped = new PedidoDAO();
		return ped.getPedido(id);
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public Produto getProduto(int id) {
    	ProdutoDAO prod = new ProdutoDAO();
    	return prod.getProduto(id);
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}