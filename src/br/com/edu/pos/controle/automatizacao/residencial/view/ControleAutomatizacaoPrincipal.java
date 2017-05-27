package br.com.edu.pos.controle.automatizacao.residencial.view;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import br.com.edu.pos.controle.automatizacao.residencial.controller.EquipamentoController;
import br.com.edu.pos.controle.automatizacao.residencial.controller.InicializarSistema;
import br.com.edu.pos.controle.automatizacao.residencial.controller.UsuarioController;
import br.com.edu.pos.controle.automatizacao.residencial.dto.EquipamentoIotDTO;
import br.com.edu.pos.controle.automatizacao.residencial.dto.UsuarioDTO;


public class ControleAutomatizacaoPrincipal extends Frame implements ActionListener, WindowListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1417892011939669254L;
	private Panel cadastro;
	TextField tfNome;
	TextField tfCpf;
	TextField tfEndereco;
	TextField tfEmail;
	TextField tfTelefone;
	TextField tfNomeIot;
	TextField tfDescricaoIot;
	TextField tfIpIot;
	TextField tfCodigoIot;
	
	
	
	UsuarioController usuario = new UsuarioController();
	EquipamentoController equipamento = new EquipamentoController();
	Panel painelUsuario;
	
	Button btIncluirUsuario,
		   btAlterarUsuario,
		   btConsultarUsuario,
		   btExcluirUsuario,
		   btIncluirEquipamentoIot,
		   btUsuario,
		   btEquipamentoIot,
		   btAcesso,
		   btAgenda ;
	
	public ControleAutomatizacaoPrincipal(){
			
		setTitle("Cadastro de Automatizacao Residencial.");
		setResizable(false);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2,(screenSize.height-500)/2,400,500);
		setBackground(SystemColor.control);
		
		Panel principal = new Panel(),
		      atalhos = new Panel(new GridLayout(4,1,5,4));	
		atalhos.add(btUsuario = new Button("Usuário"));
		atalhos.add(btEquipamentoIot = new Button("EquipIOT"));
		atalhos.add(btAcesso = new Button("Acesso"));
		atalhos.add(btAgenda = new Button("Agenda"));
		principal.add(atalhos);
		add("East",principal);
		
		cadastro = new Panel(new CardLayout());      
		
		//Painel de cadastro do Usuario
		painelUsuario = new Panel();
		painelUsuario.setBackground(SystemColor.control);
		tfNome = CriarPainelCampo(tfNome,"Nome",painelUsuario);
		tfCpf = CriarPainelCampo(tfCpf,"CPF",painelUsuario);
		tfEndereco = CriarPainelCampo(tfEndereco,"Endereço",painelUsuario);
		tfEmail = CriarPainelCampo(tfEmail,"Email",painelUsuario);
		tfTelefone = CriarPainelCampo(tfTelefone,"Telefone",painelUsuario);
		painelUsuario.add(btIncluirUsuario = new Button("Incluir"));
		painelUsuario.add(btAlterarUsuario = new Button("Alterar"));
		painelUsuario.add(btConsultarUsuario = new Button("Consultar"));
		painelUsuario.add(btExcluirUsuario = new Button("Excluir"));
		btIncluirUsuario.addActionListener(this);
		cadastro.add(painelUsuario,"Principal");
		
		//Painel de Cadastro de EquiptIOT
		Panel painelEquiptIOT = new Panel();
		painelEquiptIOT.setBackground(SystemColor.control);
		tfNomeIot =  CriarPainelCampo(tfNomeIot,"nome",painelEquiptIOT);
		tfDescricaoIot =  CriarPainelCampo(tfDescricaoIot,"Descrição",painelEquiptIOT);
		tfIpIot  =  CriarPainelCampo(tfIpIot,"IP do Equipamento",painelEquiptIOT);
		tfCodigoIot  =  CriarPainelCampo(tfCodigoIot,"Codigo ID",painelEquiptIOT);
		painelEquiptIOT.add(btIncluirEquipamentoIot = new Button("Incluir IOT"));
		btIncluirEquipamentoIot.addActionListener(this);
		cadastro.add(painelEquiptIOT,"Principal");
		
		add("Center",cadastro);
		
		btUsuario.addActionListener(this);
		btEquipamentoIot.addActionListener(this);
		addWindowListener(this);
		
		
		
	}
	
	public TextField CriarPainelCampo(TextField textField,String label,Panel incluir){
		Panel painel = new Panel(new GridLayout(2,2));
		painel.add(new Label(label,Label.LEFT));
		textField = new TextField(40);
		painel.add(textField);
		incluir.add(painel);
		return textField;		
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando sistema...");
		InicializarSistema iniciar = new InicializarSistema();
		iniciar.executarInicializacao();
		ControleAutomatizacaoPrincipal controle = new ControleAutomatizacaoPrincipal();
		controle.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)cadastro.getLayout();
		if (e.getSource() == btIncluirUsuario )
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
		
		if (e.getSource() == btIncluirEquipamentoIot)
		{
			EquipamentoIotDTO equipt = new EquipamentoIotDTO();
			equipt.setNome(tfNomeIot.getText());
			equipt.setDescricao(tfDescricaoIot.getText());
			equipt.setIp(tfIpIot.getText());
			equipt.setCodigo(tfCodigoIot.getText());
			equipamento.inserir(equipt);
			tfNomeIot.setText("");
			tfDescricaoIot.setText("");
			tfIpIot.setText("");
			tfCodigoIot.setText("");
		}
		
		if (e.getSource() == btUsuario )
		{
			cl.first(cadastro);			
		}
		
		else if(e.getSource() == btEquipamentoIot){
			cl.next(cadastro);
		}
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);		
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

		
	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}


