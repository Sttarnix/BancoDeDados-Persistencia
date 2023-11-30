package br.com.persistencia.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.persistencia.factory.ConnectorFactory;
import br.com.persistencia.model.Categoria;

public class CategoriaDAO {

	public void save(Categoria categoria) {
		String sql = "INSERT INTO categoria (id, nome, ativo)VALUES (?,?,?)";
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria a conexão com o banco
			conn = ConnectorFactory.createConnectionToMySQL();
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar valores para atualizar
			pstm.setInt(1, categoria.getId());
			pstm.setString(2, categoria.getNome());
			pstm.setString(3, categoria.getStatus());
			
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
	
	public void update(Categoria categoria) {
		String sql = "UPDATE categoria SET id = ?, nome = ?, status = ?" + "WHERE id_categoria = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria a conexão com o banco
			conn = ConnectorFactory.createConnectionToMySQL();
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar valores para atualizar
			pstm.setInt(1, categoria.getId());
			pstm.setString(2, categoria.getNome());
			pstm.setString(3, categoria.getStatus());
			//Qual ID do registro vai atualizar
			pstm.setInt(4, categoria.getId());
			
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
		String sql = "DELETE FROM categoria WHERE id_categoria =?";
		
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
	
	public List<Categoria> getListaCategorias() {
		String sql = "SELECT * FROM categoria";
		List<Categoria> Listcategorias = new ArrayList<Categoria>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()); {
				Categoria categoria = new Categoria	(rset.getInt("id_categoria"),
													 rset.getString("nome"),
													 rset.getString("Status"));
				Listcategorias.add(categoria);
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
		return Listcategorias;
	}
	
	public Categoria getCategoria(int id) {
		String sql = "SELECT * FROM categoria WHERE id = ?";
		Categoria categoria = new Categoria();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while (rset.next()); {
				categoria.setId(rset.getInt("id_categoria"));
				categoria.setNome(rset.getString("nome"));
				categoria.setStatus(rset.getString("Status"));
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
		return categoria;
	}
}