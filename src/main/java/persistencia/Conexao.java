package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexao {
	public Connection getMysqlConnection() throws Exception{
		String stringDeConexao = "jdbc:mysql://localhost/escola";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(stringDeConexao,"root","");
		return conn;		
	}


	
	
}
