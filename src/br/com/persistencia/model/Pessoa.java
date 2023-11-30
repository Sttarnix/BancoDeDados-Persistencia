package br.com.persistencia.model;

public class Pessoa {
	private int id;
	private int numero;
	private int CEP;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumero() {
    	return numero;
    }
    public void setNumero(int numero) {
    	this.numero = numero;
    }
    public int getCEP() {
    	return CEP;
    }
    public void setCEP(int CEP) {
    	this.CEP = CEP;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf){
    	this.cpf = cpf;
    }
    public String getEmail() {
    	return email;
    } 
    public void setEmail(String email){
    this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getRua() {
    	return rua;
    }
    public void setRua(String rua) {
    	this.rua = rua;
    }
    public String getBairro() {
    	return bairro;
    }
    public void setBairro(String bairro) {
    	this.bairro = bairro;
    }
    public String getCidade() {
    	return cidade;
    }
    public void setCidade(String cidade) {
    	this.cidade = cidade;
    }
    public String getEstado() {
    	return estado;
    }
    public void setEstado(String estado) {
    	this.estado = estado;
    }
    public String getComplemento() {
    	return complemento;
    }
    public void setComplemento (String complemento) {
    	this.complemento = complemento;
    }
}
