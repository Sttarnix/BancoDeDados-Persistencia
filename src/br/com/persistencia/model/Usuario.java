package br.com.persistencia.model;
import br.com.persistencia.dao.PessoaDAO;

public class Usuario {
	private int id;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private String status;
    //Informações Relacionadas
  	private Pessoa pessoa = new Pessoa();
    
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
    this.email = email;
    }
    public String getLogin() {
    return login;
    } 
    public void setLogin(String login){
    this.login = login;
    
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getStatus() {
    	return status;
    }
    public void setStatus(String status) {
    	this.status = status;
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
