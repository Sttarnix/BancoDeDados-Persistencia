package br.com.persistencia.model;
import br.com.persistencia.dao.CategoriaDAO;

public class Produto {
	//Informações do Item
	private int id;
    public String nome;
    public String imagem;   
    public String descricao; 
    public String status;
    public Float preco;
    //Informações Relacionadas
    private Categoria categoria = new Categoria();
    
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
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem){
    this.imagem = imagem;
    }
    public Float getPreco() {
    return preco;
    } 
    public void setPreco(Float preco){
    this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Categoria getCategoria() {
		return categoria;
	}
    public Categoria getCategoria(int id) {
    	CategoriaDAO cat = new CategoriaDAO();
    	return cat.getCategoria(id);
    }
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
