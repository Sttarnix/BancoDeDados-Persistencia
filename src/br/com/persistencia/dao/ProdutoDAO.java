package br.com.persistencia.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.persistencia.factory.ConnectorFactory;
import br.com.persistencia.model.Produto;

public class ProdutoDAO {
  /* CRUD c: CREATE - OK - INSERT r: READ - SELECT u: UPDATE - UPDATE d: DELETE - DELETE */

  public void save(Produto produto) {
    String sql = "INSERT INTO usuario(nome, imagem, preco, descricao, status, categoria) VALUES (?, ?, ?, ?, ?, ?)";
    
    Connection conn = null;
    PreparedStatement pstm = null;

    try {
	  // Criar uma conexão com o banco de dados
	  conn = ConnectorFactory.createConnectionToMySQL();
	  // Criamos uma PreparedStatement, para executar uma query
	  pstm = (PreparedStatement) conn.prepareStatement(sql);
	  // Adicionar os valores que são esperados pela query
	  pstm.setString(1, produto.getNome());
	  pstm.setString(2, produto.getImagem());
	  pstm.setFloat(3, produto.getPreco());
	  pstm.setString(4, produto.getDescricao());
	  pstm.setString(5, produto.getStatus());
	  pstm.setInt(6, produto.getCategoria().getId());
	
	  // Executar a query
	  pstm.execute();
	
    } catch (Exception e) {
	  e.printStackTrace();
	} finally {
		// Fechar as conexões
		try {
	        if (pstm != null) {
	          pstm.close();
	        }
	        if (conn != null) {
	          conn.close();
	        }
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}
}
	
  public List<Produto> getProduto() {
	  String sql = "SELECT * FROM produto";
	
	  List<Produto> Listprodutos = new ArrayList<Produto>();

	  Connection conn = null;
	  PreparedStatement pstm = null;
	  // Classe que vai recuperar os dados do banco. ***SELECT****
	  ResultSet rset = null;
	
	  try {
		  conn = ConnectorFactory.createConnectionToMySQL();
		  pstm = (PreparedStatement) conn.prepareStatement(sql);
		  rset = pstm.executeQuery();
		  
		  while (rset.next()) {
			  Produto produto = new Produto();
			  produto.setId(rset.getInt("id_produto"));
			  produto.setNome(rset.getString("nome"));
			  produto.setImagem(rset.getString("imagem"));
			  produto.setPreco(rset.getFloat("preco"));
			  produto.setDescricao(rset.getString("descricao"));
			  produto.setCategoria(produto.getCategoria(rset.getInt("categoria")));
			 
			  Listprodutos.add(produto);
	
		  }
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally {
		  try {
			  if (rset != null) {
				  rset.close();
			  }
			  if (pstm != null) {
				  pstm.close();
			  }
			  if (conn != null) {
				  conn.close();
			  }
		  } catch (Exception e) {
	        e.printStackTrace();
	      }
	  }
	  return Listprodutos;
  }
	
  public void update(Produto produto) {
	 String sql = "UPDATE produto SET nome = ?, imagem = ?, preco= ?, descricao = sysdate(), categoria = ? " +
	    "WHERE id_produto = ?";
	
	 Connection conn = null;
	 PreparedStatement pstm = null;
	
	 try {
		 // Cria a conexão com o banco
		 conn = ConnectorFactory.createConnectionToMySQL();
		 // Cria a classe para executar a query
		 pstm = (PreparedStatement) conn.prepareStatement(sql);
		 // Adicionar valores para atualizar
		 pstm.setString(1, produto.getNome());
		 pstm.setString(2, produto.getImagem());
		 pstm.setDouble(3, produto.getPreco());
		 pstm.setString(4, produto.getDescricao());
		 // Qual ID do registro vai atualizar
		 pstm.setInt(5, produto.getId());
		 pstm.setInt(6, produto.getCategoria().getId());
		
		 pstm.execute();
	
	 } catch (Exception e) {
	      e.printStackTrace();
	 } finally {
		 try {
			 if (pstm != null) {
				 pstm.close();
			 }
			 if (conn != null) {
				 conn.close();
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
  }
	
  public void deleteByID(int id) {
	  String sql = "DELETE FROM produto WHERE id_produto = ?";
	  
	  Connection conn = null;
	  PreparedStatement pstm = null;
	  
	  try {
		  conn = ConnectorFactory.createConnectionToMySQL();
	      pstm = (PreparedStatement) conn.prepareStatement(sql);
	      pstm.setInt(1, id);
	
	      pstm.execute();
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally {
		  try {
			  if (pstm != null) {
				  pstm.close();
			  }
			  if (conn != null) {
				  conn.close();
			  }
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	}
	
	 public Produto getProduto(int id) {
		 String sql = "SELECT * FROM produto WHERE id_produto = ?";
		 
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 // Classe que vai recuperar os dados do banco. ***SELECT****
		 ResultSet rset = null;
	
		 Produto produto = new Produto();
		 try {
			 conn = ConnectorFactory.createConnectionToMySQL();
			 pstm = (PreparedStatement) conn.prepareStatement(sql);
			 rset = pstm.executeQuery();
			
			 while (rset.next()) {
				 produto.setId(rset.getInt("id_produto"));
				 produto.setNome(rset.getString("nome"));
				 produto.setImagem(rset.getString("imagem"));
				 produto.setPreco(rset.getFloat("preco"));
				 produto.setDescricao(rset.getString("descricao"));
				 produto.setCategoria(produto.getCategoria(rset.getInt("categoria")));
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 try {
				 if (pstm != null) {
					 pstm.close();
				 }
				 if (conn != null) {
					 conn.close();
				 }
			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }
		 return produto;
	 }
	
	 public Produto getIdByName(String nomeProduto) {
		 String sql = "SELECT id_produto FROM produto WHERE nome like ?";
	
		 Connection conn = null;
		 PreparedStatement pstm = null;
		 // Classe que vai recuperar os dados do banco. ***SELECT****
		 ResultSet rset = null;
	
		 Produto produto = new Produto();
		 	try {
		 		conn = ConnectorFactory.createConnectionToMySQL();
		 		pstm = (PreparedStatement) conn.prepareStatement(sql);
		 		pstm.setString(1, nomeProduto);
		 		rset = pstm.executeQuery();
		 		// Recuperar o id
		 		produto.setId(rset.getInt("id_produto"));
	
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 	} finally {
		 		try {
		 			if (pstm != null) {
		 				pstm.close();
		 			}
	
		 			if (conn != null) {
		 				conn.close();
		 			}
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 		}
		 	}
		 	return produto;
	 	}
	
	}
