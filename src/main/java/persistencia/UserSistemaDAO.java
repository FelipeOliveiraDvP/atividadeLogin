package persistencia;

import com.mysql.jdbc.Connection;

public class UserSistemaDAO  {
	Connection con;
	
	public UserSistemaDAO(Connection con){
		this.con = con;
	}
	
	
}
