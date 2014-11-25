package delegacia.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delegacia.conexao.Conexao;

public class CadastroDAO {

	private Connection connection = null;
	private PreparedStatement stm = null;
	
	public void inserir(Cadastro cadastro){
		String sql = "INSERT INTO cadastro (nome, cargo) VALUES (?,?);";
	
		try{
			this.connection = new Conexao().getConnection();
			this.stm=this.connection.prepareStatement(sql);
			this.stm.setString(1, cadastro.getNome());
			this.stm.setString(2, cadastro.getCargo());
			
			this.stm.execute();
			this.stm.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				this.connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
	
	
	public void excluir(Cadastro cadastro){
		String sql = "DELETE FROM  cadastro WHERE id=?";
		
		
		try{
			this.connection=new Conexao().getConnection();
			this.stm=this.connection.prepareStatement(sql);
			this.stm.setInt(1,cadastro.getId());
			this.stm.execute();
			this.stm.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				this.connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
	
	public void alterar(Cadastro cadastro){
		String sql = "UPDATE cadastro SET nome=?, cargo=? WHERE id=?";
		
		
		try{
			this.connection=new Conexao().getConnection();
			this.stm=this.connection.prepareStatement(sql);
			this.stm.setString(1,cadastro.getNome());
			this.stm.setString(2, cadastro.getCargo());
			this.stm.setInt(3,cadastro.getId());
			this.stm.execute();
			this.stm.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			try{
				this.connection.close();
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
	
	
	public List<Cadastro> listar(){
		String sql = "SELECT * FROM cadastro";
		ResultSet rs = null;
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		Cadastro cadastro = null;
		try{
			this.connection = new Conexao().getConnection();
			stm = this.connection.prepareStatement(sql);
			rs = this.stm.executeQuery();
			
			while(rs.next()){
				cadastro = new Cadastro();
				cadastro.setId(rs.getInt("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setCargo(rs.getString("cargo"));
				
				cadastros.add(cadastro);
			}
			
			this.stm.close();
			rs.close();
			return cadastros;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
		try{
			this.connection.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		
	
	}
	
	}
	}
}
	
