package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import eteczl.atividade_Interface.App;
import model.UserSistema;
import persistencia.Conexao;
import persistencia.PessoaDAO;

public class LoginPanel extends JPanel{

	private App app;
	private JLabel tituloPanel = new JLabel (""); 
	private JLabel lblLogin = new JLabel ("Login"); 
	private JTextField txtLogin  =  new JTextField("");
	private JLabel lblSenha = new JLabel ("Senha"); 
	private JPasswordField passFieldSenha = new JPasswordField("");
	private JButton btnEntrar = new JButton ("Entrar");
	
	public LoginPanel(App app){
		this.app = app;
		this.add(this.tituloPanel);
		
		//Posicionando o Login
		JPanel loginPanel = new JPanel(new GridLayout(3, 2));		
		//loginPanel.add(tituloPanel);
		loginPanel.add(lblLogin);
		loginPanel.add(txtLogin);		
		loginPanel.add(lblSenha);
		loginPanel.add(passFieldSenha);
		loginPanel.add(btnEntrar);
				
		this.btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			

				String login = LoginPanel.this.txtLogin.getText(); 
				String senha = LoginPanel.this.passFieldSenha.getText();
				
				//App app = LoginPanel.this.app;
				
				try {
				

				PessoaDAO pessoa = new PessoaDAO();
				List<UserSistema> usuariosCadastrados = pessoa.listar();
				
				for (UserSistema u : usuariosCadastrados) {
					if(u.getLogin().equals(login) && u.getSenha().equals(senha)) {
						JOptionPane.showMessageDialog(null,"Login efetuado com sucesso!!!");
						break;
					}else {
						JOptionPane.showMessageDialog(null,"Usuario ou Senha nao conferem!!!");
					}
				}//for
				
				}catch(Exception ae) {
					JOptionPane.showMessageDialog(null,"Um erro inesperado ocorreu!!!\n"+ae.getMessage());
				}	
				
			}
		});	
		this.add(loginPanel);
		
	}

}
