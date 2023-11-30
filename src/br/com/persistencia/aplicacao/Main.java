package br.com.persistencia.aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import br.com.persistencia.dao.*;
import br.com.persistencia.model.*;

public class Main {
	private static List<Categoria> categoria = new ArrayList<>();
	private static List<Item> itens = new ArrayList<>();
	private static List<Pedido> pedido = new ArrayList<>();
	private static List<Pessoa> pessoa = new ArrayList<>();
	private static List<Produto> produto = new ArrayList<>();
	private static List<Usuario> usuario = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("------M E N U------");
			//CATEGORIA
			System.out.println("1. Visualizar ID Categoria");
			System.out.println("1.1. Cadastrar Nome Categoria");
			System.out.println("1.2. Visualizar Nome Categoria");
			System.out.println("1.3. Atualizar Nome Categoria");
			System.out.println("1.4. Visualizar Situação Categoria");
			System.out.println("1.5. Atualizar Situação Categoria");
			System.out.println("1.6. Excluir Categoria");
			//ITEM
			System.out.println("2. Visualizar ID Item");
			System.out.println("2.1. Excluir Item");		
			System.out.println("2.2. Cadastrar Item");
			System.out.println("2.3. Visualizar Quantidade do Item");
			System.out.println("2.4. Atualizar Quantidade do Item");
			System.out.println("2.5. Cadastrar Preço do Item");
			System.out.println("2.6. Visualizar Preço do Item");
			System.out.println("2.7. Atualizar Preço do Item");
			//PEDIDO
			System.out.println("3. Visualizar ID Pedido");
			System.out.println("3.1. Visualizar Número do Pedido");
			System.out.println("3.2. Visualizar Data da Compra do Pedido");
			System.out.println("3.3. Visalizar Status do Pedido");
			System.out.println("3.4. Cancelar Pedido");
			System.out.println("3.5. Visualizar Valor Total do Pedido");
			//PESSOA
			System.out.println("4. Visualizar ID Pessoa");
			System.out.println("4.1. Excluir Pessoa");
			System.out.println("4.2. Cadastrar Número de Telefone");
			System.out.println("4.3. Visualizar Número de Telefone");
			System.out.println("4.4. Atualizar Número de Telefone");
			System.out.println("4.5. Cadastrar E-mail");
			System.out.println("4.6. Visualizar E-mail");
			System.out.println("4.7. Atualizar E-mail");
			System.out.println("4.8. Cadastrar CPF");
			System.out.println("4.9. Visualizar CPF");
			//PRODUTO
			System.out.println("5. Visualizar ID Produto");
			System.out.println("5.1. Cadastrar Nome do Produto");
			System.out.println("5.2. Visualizar Nome do Produto");
			System.out.println("5.3. Atualizar Nome do Produto");
			System.out.println("5.4. Cadastrar Imagem do Produto");
			System.out.println("5.5. Visualizar Imagem do Produto");
			System.out.println("5.6. Atualizar Imagem do Produto");
			System.out.println("5.7. Cadastrar Preço do Produto");
			System.out.println("5.8. Visualizar Preço do Produto");
			System.out.println("5.9. Atualizar Preço do Produto");
			System.out.println("5.10. Cadastrar Descrição do Produto");
			System.out.println("5.11. Visualizar Descrição do Produto");
			System.out.println("5.12. Atualizar Descrição do Produto");
			System.out.println("5.13. Visualizar Situação do Produto");
			System.out.println("5.14. Excluir Produto");
			//USUÁRIO
			System.out.println("6. Visualizar ID Usuário");
			System.out.println("6.1. Cadastrar E-mail do Usuário");
			System.out.println("6.2. Visualizar E-mail do Usuário");
			System.out.println("6.3. Atualizar E-mail do Usuário");
			System.out.println("6.4. Cadastrar Senha do Usuário");
			System.out.println("6.5. Atualizar Senha do Usuário");
			System.out.println("6.6. Cadastrar Login do Usuário");
			System.out.println("6.7. Visualizar Login do Usuário");
			System.out.println("6.8. Atualizar Login do Usuário");
			System.out.println("6.9. Cadastrar Nome do Usuário");
			System.out.println("6.10. Visualizar Nome do Usuário");
			System.out.println("6.11. Atualizar Nome do Usuário");
			System.out.println("6.12. Visualizar Situação do Usuário");
			System.out.println("6.13. Excluir Usuário");
			
			System.out.println("0. Sair");
			System.out.print("Escolha uma opção: ");
			
			int opcao = scanner.nextInt();
		}
	}
}
