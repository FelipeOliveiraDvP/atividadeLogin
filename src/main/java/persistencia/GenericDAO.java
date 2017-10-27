package persistencia;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.List;

import org.w3c.dom.Entity;

public class GenericDAO<T extends IEntidade> implements IDAO<T> {
	
	private Class clazz;

	public GenericDAO(Connection conn, Class clazz ) {
		this.clazz = clazz;
	}
	
	public void inserir(T o) throws Exception {
		String sql = "";
		Field[] declaredFields = clazz.getDeclaredFields();
		
		
	}

	public List listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(T o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void excluir(T o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
}
