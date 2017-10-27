package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserSistema;
import model.Pessoa;
import eteczl.atividade_Interface.App;
import java.sql.Connection;


public class PessoaDAO <T extends Pessoa>  implements IDAO<T>{
		
	//inserir usuario
	public void inserir(T o) throws Exception {
		UserSistema u = (UserSistema)o;
		//Conexao con = new Conexao();
		String sql ="insert INTO usuario (nome, login, senha) value (?, ?, ?)";		
		try(Connection conn = new Conexao().getMysqlConnection()){
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, u.getNome());
		stm.setString(2, u.getLogin());
		stm.setString(3, u.getSenha());
		stm.execute();
		stm.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//listar usuarios
	public List<T> listar() throws Exception {
		List<UserSistema> usuarios = new ArrayList<UserSistema>();
		
		String sql ="SELECT * FROM usuario";
		try(Connection conn = new Conexao().getMysqlConnection()){
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.execute();
		ResultSet rss = stm.executeQuery();
		while(rss.next()){
			UserSistema user = new UserSistema(rss.getInt("id"),
											   rss.getString("nome"),
											   rss.getString("login"),
											   rss.getString("senha")
											   );
			usuarios.add(user);
		}
		stm.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return (List<T>) usuarios;
	}
	//atualizar usuario
	public void atualizar(T o) throws Exception {
		UserSistema u = (UserSistema)o;
		
		String sql ="UPDATE usuario SET nome=?, login=?, senha=? WHERE id=?)";		
		try(Connection conn = new Conexao().getMysqlConnection()){
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setString(1, u.getNome());
		stm.setString(2, u.getLogin());
		stm.setString(3, u.getSenha());
		stm.setInt(4, u.getId());
		
		stm.execute();
		stm.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//excluir usuario
	public void excluir(T o) throws Exception {
		UserSistema u = (UserSistema)o;
		
		String sql ="DELETE FROM usuario WHERE id=?)";		
		try(Connection conn = new Conexao().getMysqlConnection()){
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setInt(1, u.getId());
		
		stm.execute();
		stm.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean validar(T o) {
		
		return false;
	}
	
		
}
