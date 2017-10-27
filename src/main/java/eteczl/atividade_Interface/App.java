package eteczl.atividade_Interface;

import java.util.List;

import javax.swing.JFrame;


import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.UserSistema;
import persistencia.Conexao;
import persistencia.GenericDAO;
import view.LoginPanel;
import persistencia.PessoaDAO;

public class App 
{
	private static String versao = "v1.0";
	private UserSistema usuarioLogado;
	
	public App(){		
		this.showPanelLogin();
	}
	
	public void showPanelLogin(){
		JFrame jFrame = new JFrame("Interface Principal");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jFrame.add(new LoginPanel(this));
		jFrame.pack();
		jFrame.setVisible(true);		
	}
	
	public static void main(String[] args) throws Exception {

		new App();
		Connection conn = new Conexao().getMysqlConnection();

		PessoaDAO pessoa = new PessoaDAO();
		UserSistema a = new UserSistema("Felipe","felipec8", "senha");
		pessoa.inserir(a);		
	
		new GenericDAO<>(conn, UserSistema.class);
		
	}
	
}
