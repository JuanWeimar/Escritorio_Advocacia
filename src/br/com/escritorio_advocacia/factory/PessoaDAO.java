package br.com.escritorio_advocacia.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa_Fisica;
import model.Pessoa_Juridica;

public class PessoaDAO {

	public static boolean save(Pessoa_Fisica pessoa_fisica, Pessoa_Juridica pessoa_juridica, int Tipo_pessoa) {
		String sql = "INSERT INTO pessoa(tipo_pessoa, nome_pessoa, end_pessoa, tel_pessoa, cep_pessoa, bairro_pessoa, cidade_pessoa, uf_pessoa, email_pessoa, cpf_pessoa, rg_pessoa, cnpj_pessoa)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			if(Tipo_pessoa == 1) {
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setInt(1, pessoa_fisica.getTipo_pessoa());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, pessoa_fisica.getNome_pessoa());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, pessoa_fisica.getEndereco_pessoa());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setString(4, pessoa_fisica.getTelefone_pessoa());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setString(5, pessoa_fisica.getCep_pessoa());
				//Adiciona o valor do sexto parâmetro da sql
				pstm.setString(6, pessoa_fisica.getBairro_pessoa());
				//Adiciona o valor do sétimo parâmetro da sql
				pstm.setString(7, pessoa_fisica.getCidade_pessoa());
				//Adiciona o valor do oitavo parâmetro da sql
				pstm.setString(8, pessoa_fisica.getUf_pessoa());
				//Adiciona o valor do nono parâmetro da sql
				pstm.setString(9, pessoa_fisica.getEmail_pessoa());
				//Adiciona o valor do décimo parâmetro da sql
				pstm.setString(10,pessoa_fisica.getCpf_pessoa() );
				//Adiciona o valor do décimo primeiro parâmetro da sql
				pstm.setLong(11, pessoa_fisica.getRg_pessoa());
				//Adiciona o valor do décimo segundo parâmetro da sql
				pstm.setString(12, "NULL");
			}
			if(Tipo_pessoa == 2) {
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setInt(1, pessoa_juridica.getTipo_pessoa());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, pessoa_juridica.getNome_pessoa());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, pessoa_juridica.getEndereco_pessoa());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setString(4, pessoa_juridica.getTelefone_pessoa());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setString(5, pessoa_juridica.getCep_pessoa());
				//Adiciona o valor do sexto parâmetro da sql
				pstm.setString(6, pessoa_juridica.getBairro_pessoa());
				//Adiciona o valor do sétimo parâmetro da sql
				pstm.setString(7, pessoa_juridica.getCidade_pessoa());
				//Adiciona o valor do oitavo parâmetro da sql
				pstm.setString(8, pessoa_juridica.getUf_pessoa());
				//Adiciona o valor do nono parâmetro da sql
				pstm.setString(9, pessoa_juridica.getEmail_pessoa());
				//Adiciona o valor do décimo parâmetro da sql
				pstm.setString(10,"NULL");
				//Adiciona o valor do décimo primeiro parâmetro da sql
				pstm.setLong(11, 0);
				//Adiciona o valor do décimo segundo parâmetro da sql
				pstm.setString(12, pessoa_juridica.getCnpj_pessoa());
			}
			
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
		String sql = "DELETE FROM pessoa where cod_pessoa = ?";
		
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
	
	public static boolean update(Pessoa_Fisica pessoa_fisica, Pessoa_Juridica pessoa_juridica, int Tipo_pessoa) {
		String sql = "UPDATE pessoa SET tipo_pessoa = ?, nome_pessoa = ?, end_pessoa = ?, tel_pessoa = ?, cep_pessoa = ?, bairro_pessoa = ?, cidade_pessoa = ?, uf_pessoa = ?, email_pessoa = ?, cpf_pessoa = ?, rg_pessoa = ?, cnpj_pessoa = ? WHERE cod_pessoa = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			if(Tipo_pessoa == 1) {
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setInt(1, pessoa_fisica.getTipo_pessoa());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, pessoa_fisica.getNome_pessoa());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, pessoa_fisica.getEndereco_pessoa());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setString(4, pessoa_fisica.getTelefone_pessoa());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setString(5, pessoa_fisica.getCep_pessoa());
				//Adiciona o valor do sexto parâmetro da sql
				pstm.setString(6, pessoa_fisica.getBairro_pessoa());
				//Adiciona o valor do sétimo parâmetro da sql
				pstm.setString(7, pessoa_fisica.getCidade_pessoa());
				//Adiciona o valor do oitavo parâmetro da sql
				pstm.setString(8, pessoa_fisica.getUf_pessoa());
				//Adiciona o valor do nono parâmetro da sql
				pstm.setString(9, pessoa_fisica.getEmail_pessoa());
				//Adiciona o valor do décimo parâmetro da sql
				pstm.setString(10,pessoa_fisica.getCpf_pessoa() );
				//Adiciona o valor do décimo primeiro parâmetro da sql
				pstm.setLong(11, pessoa_fisica.getRg_pessoa());
				//Adiciona o valor do décimo segundo parâmetro da sql
				pstm.setString(12, "NULL");
				pstm.setInt(13, pessoa_fisica.getCod_pessoa());
			}
			if(Tipo_pessoa == 2) {
				//Adiciona o valor do primeiro parâmetro da sql
				pstm.setInt(1, pessoa_juridica.getTipo_pessoa());
				//Adiciona o valor do segundo parâmetro da sql
				pstm.setString(2, pessoa_juridica.getNome_pessoa());
				//Adiciona o valor do terceiro parâmetro da sql
				pstm.setString(3, pessoa_juridica.getEndereco_pessoa());
				//Adiciona o valor do quarto parâmetro da sql
				pstm.setString(4, pessoa_juridica.getTelefone_pessoa());
				//Adiciona o valor do quinto parâmetro da sql
				pstm.setString(5, pessoa_juridica.getCep_pessoa());
				//Adiciona o valor do sexto parâmetro da sql
				pstm.setString(6, pessoa_juridica.getBairro_pessoa());
				//Adiciona o valor do sétimo parâmetro da sql
				pstm.setString(7, pessoa_juridica.getCidade_pessoa());
				//Adiciona o valor do oitavo parâmetro da sql
				pstm.setString(8, pessoa_juridica.getUf_pessoa());
				//Adiciona o valor do nono parâmetro da sql
				pstm.setString(9, pessoa_juridica.getEmail_pessoa());
				//Adiciona o valor do décimo parâmetro da sql
				pstm.setString(10,"NULL");
				//Adiciona o valor do décimo primeiro parâmetro da sql
				pstm.setLong(11, 0);
				//Adiciona o valor do décimo segundo parâmetro da sql
				pstm.setString(12, pessoa_juridica.getCnpj_pessoa());
				pstm.setInt(13, pessoa_juridica.getCod_pessoa());

			}
			
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
	
	public static List<Pessoa_Fisica> getPessoasFisicas(int tipo){
		String sql = "SELECT * FROM pessoa WHERE tipo_pessoa = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, tipo);
			
			rset = pstm.executeQuery();
			
			List<Pessoa_Fisica> pessoas = new ArrayList<Pessoa_Fisica>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				pessoas.add(resultsetToPessoaFisica(rset));
			}
			return pessoas;
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
	
	public static List<Pessoa_Juridica> getPessoasJuridicas(int tipo){
		String sql = "SELECT * FROM pessoa WHERE tipo_pessoa = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, tipo);
			
			rset = pstm.executeQuery();
			
			List<Pessoa_Juridica> pessoas = new ArrayList<Pessoa_Juridica>();
			
			//Enquanto existir dados no banco de dados, faça
			while(rset.next()) {
				pessoas.add(resultsetToPessoaJuridica(rset));
			}
			return pessoas;
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
	
	public static Pessoa_Fisica selectPessoaFisicaById(int codigo) throws Exception {
		final String sql = "SELECT * FROM pessoa WHERE cod_pessoa=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, codigo);
			
			ResultSet rset = pstm.executeQuery();
			
			Pessoa_Fisica pessoa_fisica = null;
			if (rset.next()) {
				pessoa_fisica = resultsetToPessoaFisica(rset);
			}
			rset.close();
			return pessoa_fisica;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Pessoa_Juridica selectPessoaJuridicaById(int cod_pessoa) throws Exception {
		final String sql = "SELECT * FROM pessoa WHERE cod_pessoa=?";
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			ResultSet rset = pstm.executeQuery();
			
			pstm.setLong(1, cod_pessoa);
			
			Pessoa_Juridica pessoa_juridica = null;
			if (rset.next()) {
				pessoa_juridica = resultsetToPessoaJuridica(rset);
			}
			rset.close();
			return pessoa_juridica;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	private static Pessoa_Fisica resultsetToPessoaFisica(ResultSet rset) throws SQLException{
		Pessoa_Fisica pf = new Pessoa_Fisica();
		pf.setCod_pessoa(rset.getInt("cod_pessoa"));
		pf.setTipo_pessoa(rset.getInt("tipo_pessoa"));
		pf.setNome_pessoa(rset.getString("nome_pessoa"));
		pf.setEndereco_pessoa(rset.getString("end_pessoa"));
		pf.setTelefone_pessoa(rset.getString("tel_pessoa"));
		pf.setCep_pessoa(rset.getString("cep_pessoa"));
		pf.setBairro_pessoa(rset.getString("bairro_pessoa"));
		pf.setCidade_pessoa(rset.getString("cidade_pessoa"));
		pf.setUf_pessoa(rset.getString("uf_pessoa"));
		pf.setEmail_pessoa(rset.getString("email_pessoa"));
		pf.setCpf_pessoa(rset.getString("cpf_pessoa"));
		pf.setRg_pessoa(rset.getLong("rg_pessoa"));
		return pf;
	}
	
	private static Pessoa_Juridica resultsetToPessoaJuridica(ResultSet rset) throws SQLException{
		Pessoa_Juridica pj = new Pessoa_Juridica();
		pj.setCod_pessoa(rset.getInt("cod_pessoa"));
		pj.setTipo_pessoa(rset.getInt("tipo_pessoa"));
		pj.setNome_pessoa(rset.getString("nome_pessoa"));
		pj.setEndereco_pessoa(rset.getString("end_pessoa"));
		pj.setTelefone_pessoa(rset.getString("tel_pessoa"));
		pj.setCep_pessoa(rset.getString("cep_pessoa"));
		pj.setBairro_pessoa(rset.getString("bairro_pessoa"));
		pj.setCidade_pessoa(rset.getString("cidade_pessoa"));
		pj.setUf_pessoa(rset.getString("uf_pessoa"));
		pj.setEmail_pessoa(rset.getString("email_pessoa"));
		pj.setCnpj_pessoa(rset.getString("cnpj_pessoa"));
		return pj;
	}
}
