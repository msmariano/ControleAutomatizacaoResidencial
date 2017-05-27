package br.com.edu.pos.controle.automatizacao.residencial.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import br.com.edu.pos.controle.automatizacao.residencial.controller.InicializarSistema;
import br.com.edu.pos.controle.automatizacao.residencial.controller.UsuarioController;
import br.com.edu.pos.controle.automatizacao.residencial.dto.UsuarioDTO;


public class ControleAutomatizacaoPrincipal extends Frame implements ActionListener, WindowListener{
	
	TextField tfNome;
	TextField tfCpf;
	TextField tfEndereco;
	TextField tfEmail;
	TextField tfTelefone;
	Label lbNome;
	Label lbCpf;
	UsuarioController usuario = new UsuarioController();
	
	Button btIncluir;
	public ControleAutomatizacaoPrincipal(){
		setTitle("Cadastro de Controle de Automatizacao Residencial.");
		setBounds(0,0,500,500);
		setLayout(new FlowLayout());
		lbNome = new Label("Nome");
		lbCpf = new Label("CPF");
		
		
		tfNome  = new TextField(50);
		
		
		
		tfCpf  = new TextField(12);
		tfCpf.setLocation(0, 10);
		tfEndereco  = new TextField(50);
		tfEmail  = new TextField(30);
		tfTelefone  = new TextField(12);
				
				
		add(lbNome);
		add(tfNome);
		add(lbCpf);
		add(tfCpf);
		add(tfEndereco);
		add(tfEmail);
		add(tfTelefone);
		
		add(btIncluir = new Button("Incluir"),BorderLayout.SOUTH);
		btIncluir.addActionListener(this);
		addWindowListener(this);
		
		//pack();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando sistema...");
		InicializarSistema iniciar = new InicializarSistema();
		iniciar.executarInicializacao();
		ControleAutomatizacaoPrincipal controle = new ControleAutomatizacaoPrincipal();
		controle.show();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btIncluir )
		{
			UsuarioDTO dados = new UsuarioDTO();
			dados.setNome(tfNome.getText());
			dados.setCpf(tfCpf.getText());
			dados.setEndereco(tfEndereco.getText());
			dados.setEmail(tfEmail.getText());
			dados.setTelefone(tfTelefone.getText());			
			usuario.inserir(dados);
			tfNome.setText("");
			tfCpf.setText("");
			tfEndereco.setText("");
			tfTelefone.setText("");
			tfEmail.setText("");
		}
		
	}

}


