package br.com.edu.pos.controle.automatizacao.residencial.view;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.controller.AcessoController;
import br.com.edu.pos.controle.automatizacao.residencial.controller.EquipamentoController;
import br.com.edu.pos.controle.automatizacao.residencial.controller.InicializarSistema;
import br.com.edu.pos.controle.automatizacao.residencial.controller.UsuarioController;
import br.com.edu.pos.controle.automatizacao.residencial.dto.AcessoDTO;
import br.com.edu.pos.controle.automatizacao.residencial.dto.EquipamentoIotDTO;
import br.com.edu.pos.controle.automatizacao.residencial.dto.UsuarioDTO;
import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoAcesso;
import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoEquipamentoIot;
import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.EquipamentoIotDAO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class ControleAutomatizacaoPrincipal extends Frame implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1417892011939669254L;
	private Panel cadastro;
	// Controles de Tela do Usuario e demais atributos
	TextField tfNomeUsuario;
	TextField tfCpfUsuario;
	TextField tfEnderecoUsuario;
	TextField tfEmailUsuario;
	TextField tfTelefoneUsuario;
	TextField tfIdUsuario;
	Choice choiceUsuario;
	Panel painelConsultarUsuario;
	TextArea textAreaUsuario;
	Button btIncluirUsuario, btAlterarUsuario, btConsultarUsuario, btExcluirUsuario, btUsuario, btLimparUsuario;
	UsuarioController usuario = new UsuarioController();
	UsuarioDTO usuarioDTOConsulta;
	EquipamentoIotDTO equipamentoIotDTOConsulta;
	Integer controlePaineis = new Integer(1);
	// Controles de Tela dos Equipamentos e demais atributos
	TextField tfNomeIot;
	TextField tfDescricaoIot;
	TextField tfIpIot;
	TextField tfCodigoIot;
	TextField tfIdIot;
	Choice choiceEquipamentoIOT;
	Panel painelConsultarEquipamentoIOT;
	TextArea textAreaEquipamentoIOT;
	Panel painelEquiptIOT;
	Button
	// Botoes do Cadastro de EquipamentoIOT e demais atributos
	btEquipamentoIot, btIncluirEquipamentoIot, btExcluirEquipamentoIot, btAlterarEquipamentoIot,
			btConsultarEquipamentoIot, btLimparEquipamentoIot;
	EquipamentoController equipamento = new EquipamentoController();
	EquipamentoIotDTO equipamentoIotDTO;
	
	//Botoes para Gerar acesso e demais atributos
	AcessoController acessoController = new AcessoController();
	AcessoDTO acessoDTOConsulta;
	TextField
		tfInicioAcesso,
		tfFimAcesso,
		tfIdAcesso,
		tfQtdeVezes;
	Choice choiceTipoAcesso;
	Checkbox chRepetido;
	Button
		btIniciar,
		btFinalizar,
		btConsultarAcesso,
		btLimparAcesso;
	TextArea textAreaAcesso;
	
	
	Choice choiceUsuarios,
		   choiceEquipamentos;
	


	Button btAcesso, btAgenda;

	@SuppressWarnings("deprecation")
	public ControleAutomatizacaoPrincipal() {

		
		SimpleDateFormat sd = new SimpleDateFormat("MMM");
		
		//setTitle("Cadastro de Automatizacao Residencial.");
		
		setTitle(sd.format(new Date()));
		
		setResizable(false);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 450) / 2, (screenSize.height - 565) / 2, 450, 565);
		setBackground(SystemColor.control);

		Panel principal = new Panel(), atalhos = new Panel(new GridLayout(4, 1, 5, 4));
		atalhos.add(btUsuario = new Button("Usuário"));
		atalhos.add(btEquipamentoIot = new Button("EquipIOT"));
		atalhos.add(btAcesso = new Button("Gerar Acesso"));
		principal.add(atalhos);
		add("East", principal);
		// Criar Painels
		cadastro = new Panel(new CardLayout());

		// Painel de cadastro do Usuario
		Panel painelUsuario = new Panel();
		painelUsuario.setBackground(Color.gray);
		painelUsuario.add(new Label("ID : "));
		painelUsuario.add(tfIdUsuario = new TextField());
		tfNomeUsuario = CriarPainelCampo(tfNomeUsuario, "Nome", painelUsuario);
		tfCpfUsuario = CriarPainelCampo(tfCpfUsuario, "CPF", painelUsuario);
		tfEnderecoUsuario = CriarPainelCampo(tfEnderecoUsuario, "Endereço", painelUsuario);
		tfEmailUsuario = CriarPainelCampo(tfEmailUsuario, "Email", painelUsuario);
		tfTelefoneUsuario = CriarPainelCampo(tfTelefoneUsuario, "Telefone", painelUsuario);
		choiceUsuario = CriarPainelCombo(choiceUsuario, "Tipo de Usuario", painelUsuario);
		choiceUsuario.addItem(TipoUsuario.ACESSO.getDescricao());
		choiceUsuario.addItem(TipoUsuario.EQUIPAMENTOIOT.getDescricao());
		choiceUsuario.addItem(TipoUsuario.MORADOR.getDescricao());
		choiceUsuario.addItem(TipoUsuario.VISITANTE.getDescricao());
		choiceUsuario.addItem(TipoUsuario.NENHUM.getDescricao());
		painelUsuario.add(btIncluirUsuario = new Button("Incluir"));
		painelUsuario.add(btAlterarUsuario = new Button("Alterar"));
		painelUsuario.add(btConsultarUsuario = new Button("Consultar"));
		painelUsuario.add(btExcluirUsuario = new Button("Excluir"));
		painelUsuario.add(btLimparUsuario = new Button("Limpar"));
		btAlterarUsuario.disable();
		btExcluirUsuario.disable();
		painelConsultarUsuario = new Panel(new GridLayout(5, 5));
		textAreaUsuario = new TextArea("", 10, 42);
		textAreaUsuario.setFont(new Font("Courier", Font.PLAIN, 12));
		painelConsultarUsuario.add(textAreaUsuario);
		painelUsuario.add(painelConsultarUsuario);
		painelConsultarUsuario.setBackground(Color.white);
		painelConsultarUsuario.setBounds(0, 0, 200, 250);
		btConsultarUsuario.addActionListener(this);
		btIncluirUsuario.addActionListener(this);
		btExcluirUsuario.addActionListener(this);
		btAlterarUsuario.addActionListener(this);
		btLimparUsuario.addActionListener(this);
		cadastro.add(painelUsuario);
		////////////////////////////////////////////

		// Painel de Cadastro de EquiptIOT
		painelEquiptIOT = new Panel();
		painelEquiptIOT.setBackground(Color.gray);
		painelEquiptIOT.add(new Label("ID : "));
		painelEquiptIOT.add(tfIdIot = new TextField());
		tfNomeIot = CriarPainelCampo(tfNomeIot, "nome", painelEquiptIOT);
		tfDescricaoIot = CriarPainelCampo(tfDescricaoIot, "Descrição", painelEquiptIOT);
		tfIpIot = CriarPainelCampo(tfIpIot, "IP do Equipamento", painelEquiptIOT);
		tfCodigoIot = CriarPainelCampo(tfCodigoIot, "Codigo ID", painelEquiptIOT);
		choiceEquipamentoIOT = CriarPainelCombo(choiceEquipamentoIOT, "Tipo de IOT", painelEquiptIOT);
		choiceEquipamentoIOT.addItem(TipoEquipamentoIot.ACESSO.getDescricao());
		choiceEquipamentoIOT.addItem(TipoEquipamentoIot.AUTOMATIZADOR.getDescricao());
		choiceEquipamentoIOT.addItem(TipoEquipamentoIot.LEITURA.getDescricao());
		painelEquiptIOT.add(btIncluirEquipamentoIot = new Button("Incluir"));
		painelEquiptIOT.add(btAlterarEquipamentoIot = new Button("Alterar"));
		painelEquiptIOT.add(btConsultarEquipamentoIot = new Button("Consultar"));
		painelEquiptIOT.add(btExcluirEquipamentoIot = new Button("Excluir"));
		painelEquiptIOT.add(btLimparEquipamentoIot = new Button("Limpar"));
		btAlterarEquipamentoIot.disable();
		btExcluirEquipamentoIot.disable();
		painelConsultarEquipamentoIOT = new Panel(new GridLayout(5, 5));
		textAreaEquipamentoIOT = new TextArea("", 10, 42);
		textAreaEquipamentoIOT.setFont(new Font("Courier", Font.PLAIN, 12));
		painelConsultarEquipamentoIOT.add(textAreaEquipamentoIOT);
		painelEquiptIOT.add(painelConsultarEquipamentoIOT);
		btIncluirEquipamentoIot.addActionListener(this);
		btAlterarEquipamentoIot.addActionListener(this);
		btConsultarEquipamentoIot.addActionListener(this);
		btExcluirEquipamentoIot.addActionListener(this);
		btLimparEquipamentoIot.addActionListener(this);
		cadastro.add(painelEquiptIOT);
		//////////////////////////////////////////////////
		
		//Painel para gerar acesso ao usuario
		Panel painelAcesso = new Panel();
		painelAcesso.setBackground(Color.gray);
		painelAcesso.add(new Label("ID : "));
		painelAcesso.add(tfIdAcesso = new TextField());
		tfInicioAcesso = CriarPainelCampo(tfInicioAcesso,"Início",painelAcesso);
		tfFimAcesso = CriarPainelCampo(tfFimAcesso,"Fim",painelAcesso);	
		tfQtdeVezes = CriarPainelCampo(tfQtdeVezes,"Número de vezes",painelAcesso);		
		Panel painel = new Panel(new GridLayout(2, 2));
		painel.add(new Label("Tipo de Acesso", Label.LEFT));
		choiceTipoAcesso = new Choice();
		choiceTipoAcesso.add("--Selecione--               ");
		painel.add(choiceTipoAcesso);
		choiceTipoAcesso.addItem(TipoAcesso.NENHUM.getDescricao());
		choiceTipoAcesso.addItem(TipoAcesso.PERMANENTE.getDescricao());
		choiceTipoAcesso.addItem(TipoAcesso.SERVICO.getDescricao());
		choiceTipoAcesso.addItem(TipoAcesso.SOCIAL.getDescricao());
		painelAcesso.add(painel);
		painelAcesso.add(new Label("                                                "));		
		Panel painel2 = new Panel(new GridLayout(2, 2));
		painel2.add(chRepetido = new Checkbox("Repetir", true));
		painelAcesso.add(painel2);
		painelAcesso.add(new Label("                                                                           "));
		Panel painel3 = new Panel(new GridLayout(2, 2));
		painel3.add(choiceUsuarios = new Choice());
		choiceUsuarios.addItem("--Selecione--                ");
		painelAcesso.add(painel3);		
		Panel painel4 = new Panel(new GridLayout(2, 2));
		painel4.add(choiceEquipamentos = new Choice());
		choiceEquipamentos.addItem("--Selecione--                ");
		painelAcesso.add(painel4);		
		painelAcesso.add(btIniciar = new Button("Inciar"));
		painelAcesso.add(btFinalizar = new Button("Finalizar"));
		painelAcesso.add(btConsultarAcesso = new Button("Consultar"));
		painelAcesso.add(btLimparAcesso = new Button("Limpar"));
		btFinalizar.disable();
		btIniciar.addActionListener(this);
		btFinalizar.addActionListener(this); 
		btConsultarAcesso.addActionListener(this);
		btLimparAcesso.addActionListener(this);
		Panel painelConsultarAcesso = new Panel(new GridLayout(5, 5));
		textAreaAcesso = new TextArea("", 10, 42);
		textAreaAcesso.setFont(new Font("Courier", Font.PLAIN, 12));
		painelConsultarAcesso.add(textAreaAcesso);
		painelAcesso.add(painelConsultarAcesso);
		cadastro.add(painelAcesso,"Acesso");
		////////////////////////////////////////////////////

		add("Center", cadastro);
		btUsuario.addActionListener(this);
		btEquipamentoIot.addActionListener(this);
		btAcesso.addActionListener(this);
		addWindowListener(this);

	}

	public Choice CriarPainelCombo(Choice choice, String label, Panel incluir) {
		Panel painel = new Panel(new GridLayout(2, 2));
		painel.add(new Label(label, Label.LEFT));
		choice = new Choice();
		choice.add("--Selecione--               ");
		painel.add(choice);
		incluir.add(painel);
		incluir.add(new Label("                                                "));

		return choice;
	}

	public TextField CriarPainelCampo(TextField textField, String label, Panel incluir) {
		Panel painel = new Panel(new GridLayout(2, 2));
		painel.add(new Label(label, Label.LEFT));
		textField = new TextField(40);
		painel.add(textField);
		incluir.add(painel);
		return textField;
	}
	
	@SuppressWarnings("deprecation")
	public void consultarEquipamentoIot(){
		
		EquipamentoIotDTO dados = new EquipamentoIotDTO();
		
		dados.setNome(tfNomeIot.getText());
		dados.setDescricao(tfDescricaoIot.getText());
		dados.setIp(tfIpIot.getText());
		dados.setId(tfIdIot.getText());
		dados.setCodigo(tfCodigoIot.getText());
		List<EquipamentoIotDTO> equipamentosConsulta = equipamento.consultar(dados);

		String cons = "";
		for (EquipamentoIotDTO equipamentoIotDTO : equipamentosConsulta) {

			cons = cons + String.format("|%-5.5s|%-20.20s|%-11.11s|%-40.40s|%-30.30s|%-11.11s|",
					equipamentoIotDTO.getId(), equipamentoIotDTO.getNome(), equipamentoIotDTO.getDescricao(), equipamentoIotDTO.getIp(),
					equipamentoIotDTO.getCodigo(),  equipamentoIotDTO.getTipoEquipamento()) + "\r\n";
			cons = cons + "----------------------------------------" + "\r\n";
		}

		textAreaEquipamentoIOT.setText(cons);
		if (equipamentosConsulta.size() == 1) {
			equipamentoIotDTOConsulta = equipamentosConsulta.get(0);
			tfNomeIot.setText(equipamentoIotDTOConsulta.getNome());
			tfDescricaoIot.setText(equipamentoIotDTOConsulta.getDescricao());
			tfIpIot.setText(equipamentoIotDTOConsulta.getIp());
			tfIdIot.setText(equipamentoIotDTOConsulta.getIp());
			tfCodigoIot.setText(equipamentoIotDTOConsulta.getCodigo());
			choiceEquipamentoIOT.select(equipamentoIotDTOConsulta.getTipoEquipamento().getDescricao());
			String idConsulta = equipamentoIotDTOConsulta.getId();
			tfIdIot.setText(idConsulta);
			btAlterarEquipamentoIot.enable();
			btExcluirEquipamentoIot.enable();
			btIncluirEquipamentoIot.disable();
		} else {
			tfIdIot.setText(" ");
			tfIdIot.setText("");
			btAlterarEquipamentoIot.disable();
			btExcluirEquipamentoIot.disable();
			btIncluirEquipamentoIot.enable();
		}
		
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void consultarAcesso() throws ParseException{
		AcessoDTO dados = new AcessoDTO();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");			
		try {
			if(!tfInicioAcesso.getText().equals(""))
				dados.setInicioAcesso(sd.parse(tfInicioAcesso.getText()));
			if(!tfFimAcesso.getText().equals(""))
				dados.setFimAcesso(sd.parse(tfFimAcesso.getText()));
			if(!tfQtdeVezes.getText().equals(""))
				dados.setQtdeVezes(Integer.parseInt(tfQtdeVezes.getText()));
			dados.setRepetido(chRepetido.getState());
			dados.setTipoAcesso(TipoAcesso.getTipo(choiceTipoAcesso.getSelectedItem()));
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<AcessoDTO> acessosConsulta =  acessoController.consultar(dados);
		String cons = "";
		for (AcessoDTO acessoDTO : acessosConsulta) {
			
			String dataInicio = sd.format(acessoDTO.getInicioAcesso());
			String dataFim = sd.format(acessoDTO.getFimAcesso());
			String repetir = "Não repetir";
			if(acessoDTO.getRepetido())
				repetir = "Repetir";
			
			cons = cons + String.format("|%-5.5s|%-10.10s|%-10.10s|%-5.5s|%-11.11s|%-20.20s|",
					acessoDTO.getId(), dataInicio, dataFim, acessoDTO.getQtdeVezes(), repetir,
					acessoDTO.getTipoAcesso()) + "\r\n";
			cons = cons + "--------------------------------------------------------------------------" + "\r\n";
		}
		textAreaAcesso.setText(cons);
		if(acessosConsulta.size() == 1)
		{
			
			
			
			acessoDTOConsulta = acessosConsulta.get(0);
			
			int i = 0;
			for(i = 0 ; i < choiceUsuarios.countItems();i++){
				String item = choiceUsuarios.getItem(i);
				String [] sp = item.split("-");
				if(sp[0].trim().equals( acessoDTOConsulta.getUsuarioAcessoId().getId() )){
					break;
				}
				
			}
			choiceUsuarios.select( choiceUsuarios.getItem(i));
			
			
			for(i = 0 ; i < choiceEquipamentos.countItems();i++){
				String item = choiceEquipamentos.getItem(i);
				String [] sp = item.split("-");
				if(sp[0].trim().equals( acessoDTOConsulta.getEquipamentoAcessoId().getId() )){
					break;
				}
				
			}
			choiceEquipamentos.select( choiceEquipamentos.getItem(i));
					
					
			tfInicioAcesso.setText(sd.format(acessoDTOConsulta.getInicioAcesso()));
			tfFimAcesso.setText(sd.format(acessoDTOConsulta.getFimAcesso()));
			tfQtdeVezes.setText(String.valueOf(acessoDTOConsulta.getQtdeVezes()));
			choiceTipoAcesso.select(acessoDTOConsulta.getTipoAcesso().getDescricao());			
			chRepetido.setState(acessoDTOConsulta.getRepetido());
			tfIdAcesso.setText(acessoDTOConsulta.getId());
			btIniciar.disable();
			btFinalizar.enable();
			
		}
		else
		{
			btIniciar.enable();
			btFinalizar.disable();
			
		}
	}

	@SuppressWarnings("deprecation")
	public void consultarUsuario() {
		UsuarioDTO dados = new UsuarioDTO();
		dados.setNome(tfNomeUsuario.getText());
		dados.setCpf(tfCpfUsuario.getText());
		dados.setEndereco(tfEnderecoUsuario.getText());
		dados.setEmail(tfEmailUsuario.getText());
		dados.setTelefone(tfTelefoneUsuario.getText());
		dados.setId(tfIdUsuario.getText());
		List<UsuarioDTO> usuariosConsulta = usuario.consultar(dados);

		String cons = "";
		for (UsuarioDTO usuarioDTO : usuariosConsulta) {

			cons = cons + String.format("|%-5.5s|%-20.20s|%-11.11s|%-40.40s|%-30.30s|%-11.11s|%-11.11s|",
					usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getCpf(), usuarioDTO.getEndereco(),
					usuarioDTO.getEmail(), usuarioDTO.getTelefone(), usuarioDTO.getTipoUsuario()) + "\r\n";
			cons = cons + "----------------------------------------" + "\r\n";
		}

		textAreaUsuario.setText(cons);
		if (usuariosConsulta.size() == 1) {
			usuarioDTOConsulta = usuariosConsulta.get(0);
			tfNomeUsuario.setText(usuarioDTOConsulta.getNome());
			tfCpfUsuario.setText(usuarioDTOConsulta.getCpf());
			tfEnderecoUsuario.setText(usuarioDTOConsulta.getEndereco());
			tfTelefoneUsuario.setText(usuarioDTOConsulta.getTelefone());
			tfEmailUsuario.setText(usuarioDTOConsulta.getEmail());
			choiceUsuario.select(usuarioDTOConsulta.getTipoUsuario().getDescricao());
			String idConsulta = usuarioDTOConsulta.getId();
			tfIdUsuario.setText(idConsulta);
			btAlterarUsuario.enable();
			btExcluirUsuario.enable();
			btIncluirUsuario.disable();
		} else {
			tfIdUsuario.setText(" ");
			tfIdUsuario.setText("");
			btAlterarUsuario.disable();
			btExcluirUsuario.disable();
			btIncluirUsuario.enable();
		}
	}

	@SuppressWarnings("deprecation")
	public void limparCamposUsuario() {
		tfNomeUsuario.setText(" ");
		tfNomeUsuario.setText("");
		tfCpfUsuario.setText(" ");
		tfCpfUsuario.setText("");
		tfEnderecoUsuario.setText("");
		tfEnderecoUsuario.setText(" ");
		tfTelefoneUsuario.setText("");
		tfTelefoneUsuario.setText(" ");
		tfEmailUsuario.setText(" ");
		tfEmailUsuario.setText("");
		tfIdUsuario.setText(" ");
		tfIdUsuario.setText("");
		tfIdUsuario.setText(" ");
		tfIdUsuario.setText("");
		btAlterarUsuario.disable();
		btExcluirUsuario.disable();
		btIncluirUsuario.enable();
		textAreaUsuario.setText("");
		choiceUsuario.select(0);

	}
	
	@SuppressWarnings("deprecation")
	public void limparCamposEquipamento() {
		tfNomeIot.setText(" ");
		tfNomeIot.setText("");
		tfDescricaoIot.setText(" ");
		tfDescricaoIot.setText("");
		tfIpIot.setText(" ");
		tfIpIot.setText("");
		tfCodigoIot.setText(" ");
		tfCodigoIot.setText("");		
		tfIdIot.setText(" ");
		tfIdIot.setText("");
		btAlterarEquipamentoIot.disable();
		btExcluirEquipamentoIot.disable();
		btIncluirEquipamentoIot.enable();
		textAreaEquipamentoIOT.setText("");
		choiceEquipamentoIOT.select(0);

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

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) cadastro.getLayout();
		if (e.getSource() == btLimparUsuario) {
			limparCamposUsuario();
		}
		if (e.getSource() == btIncluirUsuario) {
			UsuarioDTO dados = new UsuarioDTO();
			dados.setNome(tfNomeUsuario.getText());
			dados.setCpf(tfCpfUsuario.getText());
			dados.setEndereco(tfEnderecoUsuario.getText());
			dados.setEmail(tfEmailUsuario.getText());
			dados.setTelefone(tfTelefoneUsuario.getText());
			dados.setTipoUsuario(TipoUsuario.getTipo(choiceUsuario.getSelectedItem()));
			usuario.inserir(dados);
			consultarUsuario();
		}

		if (e.getSource() == btConsultarUsuario) {
			consultarUsuario();
		}
		if (e.getSource() == btExcluirUsuario) {
			usuario.excluir(usuarioDTOConsulta);
			UsuarioDTO dados = new UsuarioDTO();
			usuario.consultar(dados);
			tfIdUsuario.setText(" ");
			tfIdUsuario.setText("");
			btAlterarUsuario.disable();
			btExcluirUsuario.disable();
			btIncluirUsuario.enable();
			consultarUsuario();
		}

		if (e.getSource() == btAlterarUsuario) {
			UsuarioDTO dados = new UsuarioDTO();
			dados.setNome(tfNomeUsuario.getText());
			dados.setCpf(tfCpfUsuario.getText());
			dados.setEndereco(tfEnderecoUsuario.getText());
			dados.setEmail(tfEmailUsuario.getText());
			dados.setTelefone(tfTelefoneUsuario.getText());
			dados.setId(usuarioDTOConsulta.getId());
			dados.setTipoUsuario(TipoUsuario.getTipo(choiceUsuario.getSelectedItem()));
			usuario.alterar(dados);
			consultarUsuario();

		}

		

		if (e.getSource() == btIncluirEquipamentoIot) {
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
			consultarEquipamentoIot();
		}
		
		if(e.getSource() == btExcluirEquipamentoIot){
			EquipamentoIotDTO equipt = new EquipamentoIotDTO();
			equipt.setId(tfIdIot.getText());
			equipamento.excluir(equipt);
			limparCamposEquipamento();
			consultarEquipamentoIot();
		}
		
		if(e.getSource() == btAlterarEquipamentoIot)
		{
			EquipamentoIotDTO equipt = new EquipamentoIotDTO();
			equipt.setNome(tfNomeIot.getText());
			equipt.setDescricao(tfDescricaoIot.getText());
			equipt.setIp(tfIpIot.getText());
			equipt.setId(tfIdIot.getText());
			equipt.setCodigo(tfCodigoIot.getText());
			equipt.setTipoEquipamento(TipoEquipamentoIot.getTipo(choiceEquipamentoIOT.getSelectedItem()));			
			equipamento.alterar(equipt);
			consultarEquipamentoIot();
		}
		if(e.getSource() == btConsultarEquipamentoIot){
			consultarEquipamentoIot();
		}
		
		if(e.getSource() == btLimparEquipamentoIot){
			limparCamposEquipamento();
		}
		
		//Acesso
		if(e.getSource() == btIniciar)
		{
			
			String opcaoUsuario = choiceUsuarios.getSelectedItem();
			String opcaoEquipamento = choiceEquipamentos.getSelectedItem();
			String idUsuario = "";
			String idEquipamento="";
			
			if( !opcaoUsuario.trim().toLowerCase().equals("--selecione--") ){
				
				String[] sp = opcaoUsuario.split("-");
				idUsuario = sp[0];
			}
			
			if( !opcaoEquipamento.trim().toLowerCase().equals("--selecione--") ){
				String[] sp = opcaoEquipamento.split("-");
				idEquipamento = sp[0];
			}
			
			AcessoDTO dados = new AcessoDTO();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");			
			try {
				dados.setInicioAcesso(sd.parse(tfInicioAcesso.getText()));
				dados.setFimAcesso(sd.parse(tfFimAcesso.getText()));
				dados.setQtdeVezes(Integer.parseInt(tfQtdeVezes.getText()));
				dados.setRepetido(chRepetido.getState());
				dados.setTipoAcesso(TipoAcesso.getTipo(choiceTipoAcesso.getSelectedItem()));
				dados.getUsuarioAcessoId().setId(idUsuario);
				dados.getEquipamentoAcessoId().setId(idEquipamento);
				
				acessoController.incluir(dados);
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			try {
				consultarAcesso();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			btIniciar.disable();
			btFinalizar.enable();
		}
		
		if(e.getSource() == btFinalizar)
		{
			AcessoDTO dados = new AcessoDTO();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");			
			try {
				dados.setInicioAcesso(sd.parse(tfInicioAcesso.getText()));
				dados.setFimAcesso(sd.parse(tfFimAcesso.getText()));
				dados.setQtdeVezes(Integer.parseInt(tfQtdeVezes.getText()));
				dados.setRepetido(chRepetido.getState());
				dados.setTipoAcesso(TipoAcesso.getTipo(choiceTipoAcesso.getSelectedItem()));
				dados.setId(tfIdAcesso.getText());
				
				try {
					consultarAcesso();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btIniciar.enable();
				btFinalizar.disable();
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			acessoController.excluir(dados);
			
		}
		if(e.getSource() == btLimparAcesso)
		{
			tfIdAcesso.setText(" ");
			tfIdAcesso.setText("");
			tfInicioAcesso.setText(" ");
			tfInicioAcesso.setText("");
			tfFimAcesso.setText(" ");
			tfFimAcesso.setText("");
			tfQtdeVezes.setText(" ");
			tfQtdeVezes.setText("");
			choiceTipoAcesso.select(0);
			choiceUsuarios.select(0);
			choiceEquipamentos.select(0);
			btIniciar.enable();
			btFinalizar.disable();
			textAreaAcesso.setText("");
			chRepetido.setState(true);
			
			
		}
		if(e.getSource() == btConsultarAcesso)
		{
			try {
				consultarAcesso();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//navegacao entre configuraçoes
		if (e.getSource() == btUsuario) {
			cl.first(cadastro);
			controlePaineis = 1;
		}
		
		if (e.getSource() == btEquipamentoIot) {
			if(controlePaineis == 1)
				cl.next(cadastro);
			else if(controlePaineis == 3)
				cl.previous(cadastro);
			controlePaineis = 2;
		}
		if(e.getSource()  == btAcesso){
			cl.last(cadastro);
			controlePaineis = 3;
			
			
			
						
			
			
			choiceEquipamentos.removeAll();
			choiceUsuarios.removeAll();
			choiceEquipamentos.addItem("--Selecione--                ");
			choiceUsuarios.addItem("--Selecione--                ");
			
			
			
			
			List<EquipamentoIotDTO> equipamentosConsulta = equipamento.consultar(new EquipamentoIotDTO());			
			for (EquipamentoIotDTO equipamentoIotDTO : equipamentosConsulta) {
				
				String res = String.format("%-20.20s",equipamentoIotDTO.getId()+"-"+equipamentoIotDTO.getNome());
				choiceEquipamentos.addItem(res);
			}
			
			List<UsuarioDTO> usuariosConsulta = usuario.consultar(new UsuarioDTO());
			for (UsuarioDTO usuarioDTO : usuariosConsulta) {
				
				String res = String.format("%-20.20s",usuarioDTO.getId()+'-'+usuarioDTO.getNome());
				choiceUsuarios.addItem(res);
			}
			
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
