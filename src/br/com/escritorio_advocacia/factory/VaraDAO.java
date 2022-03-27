package br.com.escritorio_advocacia.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Vara;

public class VaraDAO {
	public static boolean save(Vara vara) {
		String sql = "INSERT INTO vara(descricao_vara, cod_tribunal)"
				+ "VALUES(?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, vara.getDescricao_vara());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setInt(2, vara.getCod_tribunal());

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
	
	public static boolean update(Vara vara) {
		String sql = "UPDATE vara SET descricao_vara = ?, cod_tribunal = ?";
		sql += " WHERE cod_vara = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, vara.getDescricao_vara());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setInt(2, vara.getCod_tribunal());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, vara.getCod_vara());
			
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
	
	public static List<Vara> getVaras(){
		String sql = "SELECT * FROM vara";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			List<Vara> varas = new ArrayList<Vara>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				varas.add(resultsetToVara(rset));
			}
			return varas;
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
	
	public static Vara selectVaraById(int codigo) throws Exception {
		final String sql = "SELECT * FROM vara WHERE cod_vara=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			ResultSet rset = pstm.executeQuery();
			
			Vara vara = null;
			if (rset.next()) {
				vara = resultsetToVara(rset);
			}
			rset.close();
			return vara;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Vara resultsetToVara(ResultSet rset) throws SQLException{
		Vara v = new Vara();
		v.setCod_vara(rset.getInt("cod_vara"));
		v.setDescricao_vara(rset.getString("descricao_vara"));
		v.setCod_tribunal(rset.getInt("cod_tribunal"));
		return v;
	}
}
