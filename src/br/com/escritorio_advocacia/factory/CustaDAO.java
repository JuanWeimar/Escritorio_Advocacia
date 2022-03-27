package br.com.escritorio_advocacia.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Custa;

public class CustaDAO {
	public static boolean save(Custa custa) {
		String sql = "INSERT INTO custa(data_custa, descricao_custa, valor_custa, cod_processo)"
				+ "VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, custa.getData_custa());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, custa.getDescricao_custa());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setDouble(3, custa.getValor_custa());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setInt(4, custa.getCod_processo());

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
	
	public static boolean update(Custa custa) {
		String sql = "UPDATE custa SET data_custa = ?, descricao_custa = ?, valor_custa = ?, cod_processo = ?";
		sql += " WHERE cod_custa = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setString(1, custa.getData_custa());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, custa.getDescricao_custa());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setDouble(3, custa.getValor_custa());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setInt(4, custa.getCod_processo());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setInt(5, custa.getCod_custa());
			
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
	
	public static List<Custa> getCustas(){
		String sql = "SELECT * FROM custa";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			List<Custa> custas = new ArrayList<Custa>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				custas.add(resultsetToCusta(rset));
			}
			return custas;
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
	
	public static Custa selectCustaById(int codigo) throws Exception {
		final String sql = "SELECT * FROM custa WHERE cod_custa=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			ResultSet rset = pstm.executeQuery();
			
			Custa custa = null;
			if (rset.next()) {
				custa = resultsetToCusta(rset);
			}
			rset.close();
			return custa;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static Custa resultsetToCusta(ResultSet rset) throws SQLException{
		Custa c = new Custa();
		c.setCod_custa(rset.getInt("cod_custa"));
		c.setData_custa(rset.getString("data_custa"));
		c.setDescricao_custa(rset.getString("descricao_custa"));
		c.setValor_custa(rset.getDouble("valor_custa"));
		c.setCod_processo(rset.getInt("cod_processo"));
		return c;
	}
}
