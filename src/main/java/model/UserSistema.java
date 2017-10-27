package model;

import java.sql.PreparedStatement;

import persistencia.IDAO;
import persistencia.IEntidade;

public class UserSistema extends Pessoa implements IEntidade{
	private Integer id;
	private String login;
	private String senha;
	
	public UserSistema(int id, String nomeCompleto,String login,String senha) {
		super(nomeCompleto);
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
		
	public UserSistema(String nome, String login,String senha) {
		super(nome);		
		this.login = login;
		this.senha = senha;
	}
    
	public UserSistema(String login,String senha) {
		super(null);
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}	


	public String getSenha() {
		return senha;
	}
	
	public Integer getId() {
		return this.id;
	}


	


	
	
}
