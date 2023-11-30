package br.com.persistencia.model;
import java.util.Date;

import br.com.persistencia.dao.PessoaDAO;

public class Pedido {
	//Informações do Pedido
	private int id;
	private float valorTotal;
	private String numero;
	private String status;
	private Date dataPedido;
	//Informações Relacionadas
	private Pessoa pessoa = new Pessoa();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public Pessoa getPessoa(int id) {
    	PessoaDAO pessoa = new PessoaDAO();
    	return pessoa.getPessoa(id);
    }
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
