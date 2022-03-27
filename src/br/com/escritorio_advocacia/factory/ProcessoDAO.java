package br.com.escritorio_advocacia.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Processo;


public class ProcessoDAO {
	public static boolean save(Processo processo) {
		String sql = "INSERT INTO processo(nro_processo, data_abertura, data_conclusao, situacao, cod_pessoa, cod_vara)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setLong(1, processo.getNro_processo());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, processo.getData_abertura());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, processo.getData_conclusao());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setBoolean(4, processo.getSituacao());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setInt(5, processo.getCod_pessoa());
				//Adiciona o valor do sexto parâmetro da sql
				pstm.setInt(6, processo.getCod_vara());
			
			//Executa a sql para inserção dos dados
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fecha as conexões
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public void removeById(int id) {
		String sql = "DELETE FROM processo where cod_processo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Boolean softDeleteProcesso(Integer cod_processo, boolean situacao) {
		String sql = "UPDATE processo SET situacao = ?";
		sql += "WHERE cod_processo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setBoolean(1, situacao);
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setInt(2, cod_processo);

			//Executa a sql para inserção dos dados
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fecha as conexões
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean update(Processo processo) {
		String sql = "UPDATE processo SET nro_processo = ?, data_abertura = ?, data_conclusao = ?, situacao = ?, cod_pessoa = ?, cod_vara = ?";
		sql += " WHERE cod_processo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setLong(1, processo.getNro_processo());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, processo.getData_abertura());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, processo.getData_conclusao());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setBoolean(4, processo.getSituacao());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setInt(5, processo.getCod_pessoa());
				//Adiciona o valor do sexto parâmetro da sql
				pstm.setInt(6, processo.getCod_vara());
				//Adiciona o valor do sétimo parâmetro da sql
				pstm.setInt(7, processo.getCod_processo());
			
			//Executa a sql para inserção dos dados
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fecha as conexões
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static List<Processo> getProcessos(){
		String sql = "SELECT * FROM processo";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			List<Processo> processos = new ArrayList<Processo>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				processos.add(resultsetToProcesso(rset));
			}
			return processos;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Processo selectProcessoById(int codigo) throws Exception {
		final String sql = "SELECT * FROM processo WHERE cod_processo=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			ResultSet rset = pstm.executeQuery();
			
			Processo processo = null;
			if (rset.next()) {
				processo = resultsetToProcesso(rset);
			}
			rset.close();
			return processo;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Processo resultsetToProcesso(ResultSet rset) throws SQLException{
		Processo p = new Processo();
		p.setCod_processo(rset.getInt("cod_processo"));
		p.setNro_processo(rset.getLong("nro_processo"));
		p.setData_abertura(rset.getString("data_abertura"));
		p.setData_conclusao(rset.getString("data_conclusao"));
		p.setSituacao(rset.getBoolean("situacao"));
		p.setCod_pessoa(rset.getInt("cod_pessoa"));
		p.setCod_vara(rset.getInt("cod_vara"));
		return p;
	}
}
