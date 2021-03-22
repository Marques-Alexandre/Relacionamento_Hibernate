package org.libertas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.libertas.model.Pessoa;


public class PessoaDaoJdbc {

	//classe responsável pelo mapeamento objeto->relacional
	//CRUD
	
	public void inserir(Pessoa p) {
		ConexaoJdbc con = new ConexaoJdbc();
		try {
			
			String sql = "INSERT INTO pessoa "
					+ "(nome, telefone, email, cpf) "
					+ "VALUES (?,?,?,?)";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCpf());
			
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void alterar(Pessoa p) {
		ConexaoJdbc con = new ConexaoJdbc();
		try {
			
			String sql = "UPDATE pessoa "
					+ "SET nome = ?, telefone = ?, email =?, cpf=?  "
					+ "WHERE idpessoa = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCpf());
			prep.setInt(5, p.getIdpessoa());
			
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public void excluir(Pessoa p) {
		ConexaoJdbc con = new ConexaoJdbc();
		try {
			
			String sql = "DELETE FROM pessoa WHERE idpessoa = ?";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setInt(1, p.getIdpessoa());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	public Pessoa consultar(int id) {
		Pessoa p = new Pessoa();
		
		ConexaoJdbc con = new ConexaoJdbc();
		try {
			
			String sql = "SELECT * FROM pessoa WHERE idpessoa = " + id;
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCpf(res.getString("cpf"));
				p.setIdpessoa(res.getInt("idpessoa"));
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		
		return p;
	}
	public List<Pessoa> listar() {
		List<Pessoa> lista = new LinkedList<Pessoa>();
		
		ConexaoJdbc con = new ConexaoJdbc();
		try {
			
			String sql = "SELECT * FROM pessoa ORDER BY nome";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pessoa p = new Pessoa();
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCpf(res.getString("cpf"));
				p.setIdpessoa(res.getInt("idpessoa"));
				lista.add(p);
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		
		return lista;
	}
	
	
	
}
