package br.com.escritorio_advocacia.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tribunal;

public class TribunalDAO {
	public static boolean save(Tribunal tribunal) {
		String sql = "INSERT INTO tribunal(descricao_tribunal, endereco_tribunal)"
				+ "VALUES(?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, tribunal.getDescricao_tribunal());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, tribunal.getEndereco_tribunal());

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
	
	public static boolean update(Tribunal tribunal) {
		String sql = "UPDATE tribunal SET descricao_tribunal = ?, endereco_tribunal = ?";
		sql += " WHERE cod_tribunal = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, tribunal.getDescricao_tribunal());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, tribunal.getEndereco_tribunal());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setInt(3, tribunal.getCod_tribunal());
			
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
	
	public static List<Tribunal> getTribunais(){
		String sql = "SELECT * FROM tribunal";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			List<Tribunal> tribunais = new ArrayList<Tribunal>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				tribunais.add(resultsetToTribunal(rset));
			}
			return tribunais;
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
	
	public static Tribunal selectTribunalById(int codigo) throws Exception {
		final String sql = "SELECT * FROM tribunal WHERE cod_tribunal=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			ResultSet rset = pstm.executeQuery();
			
			Tribunal tribunal = null;
			if (rset.next()) {
				tribunal = resultsetToTribunal(rset);
			}
			rset.close();
			return tribunal;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Tribunal resultsetToTribunal(ResultSet rset) throws SQLException{
		Tribunal t = new Tribunal();
		t.setCod_tribunal(rset.getInt("cod_tribunal"));
		t.setDescricao_tribunal(rset.getString("descricao_tribunal"));
		t.setEndereco_tribunal(rset.getString("endereco_tribunal"));
		return t;
	}
}
