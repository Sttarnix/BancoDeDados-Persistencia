package br.com.persistencia.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.persistencia.factory.ConnectorFactory;
import br.com.persistencia.model.Pessoa;

	public class PessoaDAO {
		//CRUD c: CREATE - OK - INSERT r: READ - SELECT u: UPDATE - UPDATE d: DELETE - DELETE
	public void save(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa( id, nome, cpf, email, telefone, CEP, numero, rua, bairro, cidade, estado, complemento ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			//Cria a conexão com o banco
		    conn = ConnectorFactory.createConnectionToMySQL();
		    //Cria a classe para executar a query
		    pstm = (PreparedStatement) conn.prepareStatement(sql);
		    //Adicionar valores
		    pstm.setInt(1, pessoa.getId());
		    pstm.setInt(2, pessoa.getCEP());
		    pstm.setInt(3, pessoa.getNumero());
		    pstm.setString(4, pessoa.getNome());
		    pstm.setString(5, pessoa.getCpf());
		    pstm.setString(6, pessoa.getEmail());
		    pstm.setString(7, pessoa.getTelefone());
		    pstm.setString(8, pessoa.getRua());
		    pstm.setString(9, pessoa.getBairro());
		    pstm.setString(10, pessoa.getCidade());
		    pstm.setString(11, pessoa.getEstado());
		    pstm.setString(12, pessoa.getComplemento());
		    
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

	public List<Pessoa> getPessoas() {
		String sql = "SELECT * FROM pessoa";
		List<Pessoa> Listpessoas = new ArrayList<Pessoa>();
	
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    // Classe que vai recuperar os dados do banco. ***SELECT****
	    ResultSet rset = null;
	
	    try {
	    	conn = ConnectorFactory.createConnectionToMySQL();
	       	pstm = (PreparedStatement) conn.prepareStatement(sql);
	    	rset = pstm.executeQuery();
	
	    	while (rset.next()); {
	    		Pessoa pessoa = new Pessoa();
		    	  // Recuperar o id
		    	  pessoa.setId(rset.getInt("id_pessoa"));
		    	  // Recuperar o CEP
		    	  pessoa.setCEP(rset.getInt("CEP"));
		    	  // Recuperar o Numero
		    	  pessoa.setNumero(rset.getInt("numero"));
		    	  // Recuperar o Nome
			      pessoa.setNome(rset.getString("nome"));
			      // Recuperar o CPF
			      pessoa.setCpf(rset.getString("cpf"));
			      // Recuperar o Email
			      pessoa.setEmail(rset.getString("email"));
			      // Recuperar o Telefone
			      pessoa.setTelefone(rset.getString("telefone"));
			      // Recuperar a Rua
			      pessoa.setRua(rset.getString("rua"));
			      // Recuperar o Bairro
			      pessoa.setBairro(rset.getString("bairro"));
			      // Recuperar a Cidade
			      pessoa.setCidade(rset.getString("cidade"));
			      // Recuperar o Estado
			      pessoa.setEstado(rset.getString("estado"));
			      // Recuperar o Complemento
			      pessoa.setComplemento(rset.getString("complemento"));
			       
			      Listpessoas.add(pessoa);
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
	    return Listpessoas;
	}
	
	public void update(Pessoa pessoa) {
		String sql = "UPDATE pessoa SET nome = ?, cpf = ?, email= ?, telefone = sysdate(), CEP = ?, numero = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, complemento = ?" + "WHERE id_pessoa = ?";
	
	    Connection conn = null;
	    PreparedStatement pstm = null;
	
	    try {
	    	//Cria a conexão com o banco
			conn = ConnectorFactory.createConnectionToMySQL();
			//Cria a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			// Adicionar valores para atualizar
		    pstm.setInt(1, pessoa.getCEP());
		    pstm.setInt(2, pessoa.getNumero());
		    pstm.setString(3, pessoa.getNome());
		    pstm.setString(4, pessoa.getCpf());
		    pstm.setString(5, pessoa.getEmail());
		    pstm.setString(6, pessoa.getTelefone());
		    pstm.setString(7, pessoa.getRua());
		    pstm.setString(8, pessoa.getBairro());
		    pstm.setString(9, pessoa.getCidade());
		    pstm.setString(10, pessoa.getEstado());
		    pstm.setString(11, pessoa.getComplemento());
			// Qual ID do registro vai atualizar
			pstm.setInt(5, pessoa.getId());
			
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
		String sql = "DELETE FROM pessoa WHERE id_pessoa = ?";
	
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
	
	public Pessoa getPessoaById(int idPessoa) {
		String sql = "SELECT * FROM pessoa WHERE id_pessoa = ?";
	
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    // Classe que vai recuperar os dados do banco. ***SELECT****
	    ResultSet rset = null;
	    
	    Pessoa pessoa = new Pessoa();
	
	    try {
	    	conn = ConnectorFactory.createConnectionToMySQL();
	    	pstm = (PreparedStatement) conn.prepareStatement(sql);
	    	pstm.setInt(1, idPessoa);
	    	
	    	rset = pstm.executeQuery();
	
	    	while (rset.next()) {
	    		// Recuperar o id
	    		pessoa.setId(rset.getInt("id_pessoa"));
	    		// Recuperar o CEP
	    		pessoa.setCEP(rset.getInt("CEP"));
	    		// Recuperar o Numero
	    		pessoa.setNumero(rset.getInt("numero"));
	    		// Recuperar o Nome
	    		pessoa.setNome(rset.getString("nome"));
	    		// Recuperar o CPF
	    		pessoa.setCpf(rset.getString("cpf"));
	    		// Recuperar o Email
	    		pessoa.setEmail(rset.getString("email"));
	    		// Recuperar o Telefone
	    		pessoa.setTelefone(rset.getString("telefone"));
	    		// Recuperar a Rua
			    pessoa.setRua(rset.getString("rua"));
			    // Recuperar o Bairro
			    pessoa.setBairro(rset.getString("bairro"));
			    // Recuperar a Cidade
			    pessoa.setCidade(rset.getString("cidade"));
			    // Recuperar o Estado
			    pessoa.setEstado(rset.getString("estado"));
	    		// Recuperar o Complemento
	    		pessoa.setComplemento(rset.getString("complemento"));
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
	    return pessoa;
	}
	
	public Pessoa getIdByName(String nomePessoa) {
		String sql = "SELECT id_pessoa FROM pessoa WHERE nome like ?";
	
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    // Classe que vai recuperar os dados do banco. ***SELECT****
	    ResultSet rset = null;
	    
	    Pessoa pessoa = new Pessoa();
	
	    try {
		    conn = ConnectorFactory.createConnectionToMySQL();
		    pstm = (PreparedStatement) conn.prepareStatement(sql);
		    pstm.setString(1, nomePessoa);
		    rset = pstm.executeQuery();
		    // Recuperar o id
		    pessoa.setId(rset.getInt("id_pessoa"));
		
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
		    return pessoa;
		}
	
	public Pessoa getPessoa(int id) {
		String sql = "SELECT * FROM pessoa WHERE id = ?";
		Pessoa pessoa = new Pessoa();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectorFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			while (rset.next()); {
				// Recuperar o id
	    		pessoa.setId(rset.getInt("id_pessoa"));
	    		// Recuperar o CEP
	    		pessoa.setCEP(rset.getInt("CEP"));
	    		// Recuperar o Numero
	    		pessoa.setNumero(rset.getInt("numero"));
	    		// Recuperar o Nome
	    		pessoa.setNome(rset.getString("nome"));
	    		// Recuperar o CPF
	    		pessoa.setCpf(rset.getString("cpf"));
	    		// Recuperar o Email
	    		pessoa.setEmail(rset.getString("email"));
	    		// Recuperar o Telefone
	    		pessoa.setTelefone(rset.getString("telefone"));
	    		// Recuperar a Rua
			    pessoa.setRua(rset.getString("rua"));
			    // Recuperar o Bairro
			    pessoa.setBairro(rset.getString("bairro"));
			    // Recuperar a Cidade
			    pessoa.setCidade(rset.getString("cidade"));
			    // Recuperar o Estado
			    pessoa.setEstado(rset.getString("estado"));
	    		// Recuperar o Complemento
	    		pessoa.setComplemento(rset.getString("complemento"));
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
		return pessoa;
	}
}