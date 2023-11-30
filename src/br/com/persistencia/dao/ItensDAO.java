package br.com.persistencia.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.persistencia.factory.ConnectorFactory;
import br.com.persistencia.model.Item;

public class ItensDAO {
	public void save(Item item) {
		String sql = "INSERT INTO item ( id, quantidade, preco, pedido, produto )VALUES ( ?,?,?,?,? )";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria a conexão com o banco
			conn = ConnectorFactory.createConnectionToMySQL();
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar valores para atualizar
			pstm.setInt(1, item.getId());
			pstm.setInt(2, item.getQuantidade());
			pstm.setFloat(3, item.getPreco());
			pstm.setInt(4, item.getPedido().getId());
			pstm.setInt(5, item.getProduto().getId());
			
			
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
	
	public void update(Item item) {
		String sql = " UPDATE item SET id = ?, quantidade = ?, preco = ?, pedido = ?, produto = ? " + "WHERE id_item = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, item.getId());
			pstm.setInt(2, item.getQuantidade());
			pstm.setFloat(3, item.getPreco());
			pstm.setInt(4, item.getId());
			
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
		String sql = "DELETE FROM item WHERE id_item =?";
		
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
	
	public List<Item> getItem() {
		String sql = "SELECT * FROM item";
		List<Item> itens = new ArrayList<Item>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()); {
				Item item = new Item	(rset.getInt("id_item"),
										 rset.getInt("quantidade"),
										 rset.getFloat("preco"));
										 rset.getInt("pedido");
										 rset.getInt("produto");
				itens.add(item);
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
		return itens;
	}
}
