package br.com.persistencia.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.persistencia.factory.ConnectorFactory;
import br.com.persistencia.model.Usuario;

	public class UsuarioDAO {
	/*   * CRUD c: CREATE - OK - INSERT r: READ - SELECT u: UPDATE - UPDATE d: DELETE - DELETE */

	public void save(Usuario usuario) {
		String sql = "INSERT INTO usuario(email, senha, login, nome, status, pessoa) VALUES ( ?, ?, ?, ?, ?, ? )";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectorFactory.createConnectionToMySQL();
			// Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar os valores que são esperados pela query
			pstm.setString(1, usuario.getEmail());
			pstm.setString(2, usuario.getSenha());
			pstm.setString(3, usuario.getLogin());
			pstm.setString(4, usuario.getNome());
			pstm.setString(5, usuario.getStatus());
			pstm.setInt(6, usuario.getPessoa().getId());
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

	public List<Usuario> getUsuario() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;

		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Usuario usuario = new Usuario();
				// Recuperar o id
				usuario.setId(rset.getInt("id_usuario"));
				// Recuperar o Email
				usuario.setEmail(rset.getString("email"));
				// Recuperar a Senha
				usuario.setSenha(rset.getString("senha"));
				// Recuperar o Login
				usuario.setLogin(rset.getString("login"));
				// Recuperar o Nome
				usuario.setNome(rset.getString("nome"));
       
				usuarios.add(usuario);
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
		return usuarios;
	}

	public void update(Usuario usuario) {
		String sql = " UPDATE produto SET email = ?, senha = ?, login = ?, nome = ?, pessoa = ? " + "WHERE id_usuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria a conexão com o banco
			conn = ConnectorFactory.createConnectionToMySQL();
			// Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar valores para atualizar
			pstm.setString(1, usuario.getEmail());
			pstm.setString(2, usuario.getSenha());
			pstm.setString(3, usuario.getLogin());
			pstm.setString(4, usuario.getNome());
			pstm.setInt(6, usuario.getPessoa().getId());
			// Qual ID do registro vai atualizar
			pstm.setInt(5, usuario.getId());

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
		String sql = "DELETE FROM pessoa WHERE id_usuario = ?";

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

	public Usuario getUsuarioById(int idUsuario) {	
		String sql = "SELECT * FROM pessoa WHERE id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
    
		Usuario usuario = new Usuario();

		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, idUsuario);
			rset = pstm.executeQuery();

			while (rset.next()) {
				// Recuperar o id
				usuario.setId(rset.getInt("id_usuario"));
				// Recuperar o email
				usuario.setEmail(rset.getString("email"));
				// Recuperar a senha
				usuario.setSenha(rset.getString("senha"));
				// Recuperar o login
				usuario.setLogin(rset.getString("login"));
				// Recuperar o nome
				usuario.setNome(rset.getString("nome"));
				// Recuperar o Id Pessoa
				usuario.setPessoa(usuario.getPessoa(rset.getInt("pessoa")));
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
		return usuario;
	}

	public Usuario getIdByName(String nomeUsuario) {
		String sql = "SELECT id_usuario FROM usuario WHERE nome like ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
    
		Usuario usuario = new Usuario();

		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, nomeUsuario);
			rset = pstm.executeQuery();
			// Recuperar o id
			usuario.setId(rset.getInt("id_usuario"));
			
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
		return usuario;
	}	
	
	public Usuario getUsuario(int id) {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		Usuario usuario = new Usuario();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while (rset.next()); {
				usuario.setId(rset.getInt("id_categoria"));
				usuario.setNome(rset.getString("nome"));
				usuario.setStatus(rset.getString("Status"));
				usuario.setPessoa(usuario.getPessoa(rset.getInt("pessoa")));
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
		return usuario;
	}
}
