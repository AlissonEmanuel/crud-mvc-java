package delegacia.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String url = "jdbc:mysql://localhost/db-delegacia";
	private String user = "root";
	private String pass = "mysql";
	
	public Connection getConnection(){
		try{
			return DriverManager.getConnection(url, user, pass);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
