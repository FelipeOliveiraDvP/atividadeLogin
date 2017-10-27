package persistencia;

import java.util.List;

import model.UserSistema;

public interface IDAO <T>{
	
	public void inserir(T o) throws Exception; 
	List<T> listar() throws Exception;
	public void atualizar(T o) throws Exception;
	public void excluir(T o) throws Exception; 

}
