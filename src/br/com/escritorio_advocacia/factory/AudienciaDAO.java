package br.com.escritorio_advocacia.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Audiencia;

public class AudienciaDAO {
	public static boolean save(Audiencia audiencia) {
		String sql = "INSERT INTO audiencia(data_audiencia, parecer, cod_processo)"
				+ "VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, audiencia.getData_audiencia());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, audiencia.getParecer());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, audiencia.getCod_processo());
			
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
	
	public static boolean update(Audiencia audiencia) {
		String sql = "UPDATE audiencia SET data_audiencia = ?, parecer = ?, cod_processo = ?";
		sql += " WHERE cod_audiencia = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, audiencia.getData_audiencia());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, audiencia.getParecer());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setDouble(3, audiencia.getCod_processo());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setInt(4, audiencia.getCod_audiencia());
			
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
	
	public static List<Audiencia> getAudiencias(){
		String sql = "SELECT * FROM audiencia";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			List<Audiencia> audiencias = new ArrayList<Audiencia>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				audiencias.add(resultsetToAudiencia(rset));
			}
			return audiencias;
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
	
	public static Audiencia selectAudienciaById(int codigo) throws Exception {
		final String sql = "SELECT * FROM audiencia WHERE cod_audiencia=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			ResultSet rset = pstm.executeQuery();
			
			Audiencia audiencia = null;
			if (rset.next()) {
				audiencia = resultsetToAudiencia(rset);
			}
			rset.close();
			return audiencia;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Audiencia resultsetToAudiencia(ResultSet rset) throws SQLException{
		Audiencia a = new Audiencia();
		a.setCod_audiencia(rset.getInt("cod_audiencia"));
		a.setData_audiencia(rset.getString("data_audiencia"));
		a.setParecer(rset.getString("parecer"));
		a.setCod_processo(rset.getInt("cod_processo"));
		return a;
	}
}
