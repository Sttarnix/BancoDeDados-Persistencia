package br.com.persistencia.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.persistencia.factory.ConnectorFactory;
import br.com.persistencia.model.Pedido;

public class PedidoDAO {
	public void save(Pedido pedido) {
		String sql = "INSERT INTO pedido (id, valorTotal, numero, status, dataPedido, pessoa)VALUES ( ?, ?, ?, ?, ?, ? )";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria a conexão com o banco
			conn = ConnectorFactory.createConnectionToMySQL();
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar valores para atualizar
			pstm.setInt(1, pedido.getId());
			pstm.setFloat(2, pedido.getValorTotal());
			pstm.setString(3, pedido.getNumero());
			pstm.setString(4, pedido.getStatus());
			pstm.setDate(5, new Date(pedido.getDataPedido().getTime()));
			pstm.setInt(6, pedido.getPessoa().getId());
			
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
	
	public void update(Pedido pedido) {
		String sql = " UPDATE pedido SET id = ?, valorTotal = ?, numero = ?, status = ?, dataPedido = ?, pessoa = ? " + "WHERE id_pedido = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getId());
			pstm.setFloat(2, pedido.getValorTotal());
			pstm.setString(3, pedido.getNumero());
			pstm.setString(4, pedido.getStatus());
			pstm.setDate(5, new Date(pedido.getDataPedido().getTime()));
			pstm.setInt(6, pedido.getPessoa().getId());
			
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
		String sql = " DELETE FROM item WHERE id_pedido = ? ";
		
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
	
	public List<Pedido> getPedido() {
		String sql = "SELECT * FROM pedido";
		List<Pedido> Listpedidos = new ArrayList<Pedido>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rset.getInt("id_pedido"));
				pedido.setValorTotal(rset.getFloat("valorTotal"));
				pedido.setNumero(rset.getString("numero"));
				pedido.setStatus(rset.getString("status"));
				pedido.setDataPedido(rset.getDate("dataPedido"));
				pedido.setPessoa(pedido.getPessoa(rset.getInt("pessoa")));
				
				Listpedidos.add(pedido);
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
		return Listpedidos;
	}
	public Pedido getIdByName(String numeroPedido) {
		String sql = "SELECT id_pedido FROM pedido WHERE numero like ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		Pedido pedido = new Pedido();
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, numeroPedido);
			rset = pstm.executeQuery();
			
			pedido.setId(rset.getInt("id_pedido"));
			
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
		return pedido;
	}
	public Pedido getPedido(int id) {
		String sql = "SELECT * FROM pedido WHERE id = ?";
		Pedido pedido = new Pedido();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while (rset.next()); {
				pedido.setId(rset.getInt("id_pedido"));
				pedido.setValorTotal(rset.getFloat("valorTotal"));
				pedido.setNumero(rset.getString("numero"));
				pedido.setDataPedido(rset.getDate("dataPedido"));
				pedido.setStatus(rset.getString("status"));
				pedido.setPessoa(pedido.getPessoa(rset.getInt("pessoa")));
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
		return pedido;
	}
}
