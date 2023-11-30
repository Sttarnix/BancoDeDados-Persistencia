package br.com.persistencia.model;

public class Categoria {
	//informações da Categoria
	private int id;
	private String nome;
	private String status;
	
	public Categoria() {
		
	}
	
	public Categoria(int id, String nome, String status) {
		this.setId(id);
		this.setNome(nome);
		this.setStatus(status);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
