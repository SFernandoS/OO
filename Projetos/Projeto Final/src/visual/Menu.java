package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dados.Livraria;
import servicos.Servicos;
import validacao.Validacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Menu extends JFrame{

	private JPanel contenPane;
	//livro
	private JTextField textTitulo;
	private JTextField textISBN;
	private JTextField textAutor;
	private JTextField textEditora;
	private JTextField textPreco;
	private JTextField textQuantidade;
	//pessoa
	private JTextField nome;
	private JTextField cpf;
	private JTextField cep;

	public static void criaMenu(Livraria livraria) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(livraria);
					frame.setResizable(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public Menu(Livraria livraria) {
	
		setTitle("Livraria 'Menu'");
		setBounds(100, 100, 600, 600);
		contenPane = new JPanel();
		contenPane.setBackground(new Color(204, 204, 102));
		contenPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenPane);
		contenPane.setLayout(new CardLayout(0, 0));
		
		/*
		 * 			INICIO
		 */
		
		Panel inicio = new Panel();
		contenPane.add(inicio, "inicio");
		inicio.setLayout(null);
		
		Label welcome = new Label("Bem vindo(a)");
		welcome.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		welcome.setBounds(157, 35, 259, 40);
		inicio.add(welcome);
		
		Button catalogo = new Button("Catalogo");
		catalogo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		inicio.add(catalogo);
		catalogo.setBounds(117, 100, 350, 50);
		catalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cadastro = (CardLayout) (contenPane.getLayout());
				cadastro.show(contenPane, "catalogo");
			}
		});
		
		Button livroEstoque = new Button("Estoque");
		livroEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		livroEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout estoque = (CardLayout) (contenPane.getLayout());
				estoque.show(contenPane, "estoque");
			}
		});
		livroEstoque.setBounds(117, 475, 350, 50);
		inicio.add(livroEstoque);
		
		Button clienteCadastrados = new Button("Cadastrados");
		clienteCadastrados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		clienteCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cadastrados = (CardLayout) (contenPane.getLayout());
				cadastrados.show(contenPane, "clientesCadastrados");
			}
		});
		clienteCadastrados.setBounds(117, 250, 350, 50);
		inicio.add(clienteCadastrados);
		
		Button pagamentosEfetuados = new Button("Pagamentos efetuados");
		pagamentosEfetuados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		pagamentosEfetuados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout listaPagamentos = (CardLayout) (contenPane.getLayout());
				listaPagamentos.show(contenPane, "pagamentos");
			}
		});
		pagamentosEfetuados.setBounds(117, 325, 350, 50);
		inicio.add(pagamentosEfetuados);
		
		Button listaPerfil = new Button("Lista por perfil");
		listaPerfil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		listaPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout listaPerfil = (CardLayout) (contenPane.getLayout());
				listaPerfil.show(contenPane, "listaPerfil");
			}
		});
		listaPerfil.setBounds(117, 400, 350, 50);
		inicio.add(listaPerfil);
		
		Button cadastroLivro = new Button("Cadastrar livro");
		cadastroLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cadLivro = (CardLayout) (contenPane.getLayout());
				cadLivro.show(contenPane, "cadLivro");
			}
		});
		cadastroLivro.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		cadastroLivro.setBounds(117, 175, 350, 50);
		inicio.add(cadastroLivro);
		
		/*
		 * 					Catalogo
		 */
		
		Panel catalogoPanel = new Panel();
		contenPane.add(catalogoPanel, "catalogo");
		catalogoPanel.setLayout(null);
		
		Label lblCatalogo = new Label("Cat\u00E1logo");
		lblCatalogo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblCatalogo.setBounds(196, 23, 182, 83);
		catalogoPanel.add(lblCatalogo);
		
		Button navVisitante = new Button("Navegar como visitante");
		navVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		navVisitante.setBounds(132, 161, 310, 55);
		catalogoPanel.add(navVisitante);
		navVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout navVisitante = (CardLayout) (contenPane.getLayout());
				navVisitante.show(contenPane, "navVisitante");
			}
		});
		
		Button cadCliente = new Button("Cadastrar cliente");
		cadCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		cadCliente.setBounds(132, 248, 310, 55);
		catalogoPanel.add(cadCliente);
		cadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cadCliente = (CardLayout) (contenPane.getLayout());
				cadCliente.show(contenPane, "cadCliente");
			}
		});
		
		
		Button btnCliente = new Button("Cliente");
		btnCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnCliente.setBounds(132, 419, 310, 55);
		catalogoPanel.add(btnCliente);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout btnCliente = (CardLayout) (contenPane.getLayout());
				btnCliente.show(contenPane, "navCliente");
			}
		});
		
		
		/*
		 * 					Cadastro de Livros
		 */
		
		Panel cadastroLivroPanel = new Panel();
		contenPane.add(cadastroLivroPanel, "cadLivro");
		cadastroLivroPanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		cadastroLivroPanel.add(btnVoltar);
		
		Label titulo = new Label("Cadastro de livro");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(119, 30, 336, 45);
		cadastroLivroPanel.add(titulo);
		
		Label labelTitulo = new Label("T\u00EDtulo");
		labelTitulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelTitulo.setBounds(264, 95, 56, 20);
		cadastroLivroPanel.add(labelTitulo);
		
		Label labelISBN = new Label("ISBN");
		labelISBN.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelISBN.setBounds(269, 155, 46, 20);
		cadastroLivroPanel.add(labelISBN);
		
		Label labelAutor = new Label("Autor");
		labelAutor.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelAutor.setBounds(259, 215, 56, 20);
		cadastroLivroPanel.add(labelAutor);
		
		Label labelEditora = new Label("Editora");
		labelEditora.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelEditora.setBounds(258, 275, 67, 20);
		cadastroLivroPanel.add(labelEditora);
		
		Label labelGenero = new Label("G\u00EAnero");
		labelGenero.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelGenero.setBounds(259, 455, 67, 20);
		cadastroLivroPanel.add(labelGenero);
		
		Label labelPreco = new Label("Pre\u00E7o (x.xx)");
		labelPreco.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelPreco.setBounds(239, 335, 105, 20);
		cadastroLivroPanel.add(labelPreco);
		
		Label labelQuantidade = new Label("Quantidade");
		labelQuantidade.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelQuantidade.setBounds(233, 395, 107, 20);
		cadastroLivroPanel.add(labelQuantidade);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(142, 120, 300, 25);
		cadastroLivroPanel.add(textTitulo);
		textTitulo.setColumns(10);
		
		textISBN = new JTextField();
		textISBN.setBounds(142, 180, 300, 25);
		cadastroLivroPanel.add(textISBN);
		textISBN.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(142, 240, 300, 25);
		cadastroLivroPanel.add(textAutor);
		textAutor.setColumns(10);
		
		textEditora = new JTextField();
		textEditora.setBounds(142, 300, 300, 25);
		cadastroLivroPanel.add(textEditora);
		textEditora.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(142, 360, 300, 25);
		cadastroLivroPanel.add(textPreco);
		textPreco.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(142, 420, 300, 25);
		cadastroLivroPanel.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		Choice choiceGenero = new Choice();
		choiceGenero.setBackground(new Color(204, 204, 153));
		choiceGenero.setBounds(142, 480, 300, 25);
		cadastroLivroPanel.add(choiceGenero);
		choiceGenero.add("nao implementado");
		
		Button btnFim = new Button("Finalizar");
		btnFim.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFim.setBounds(234, 510, 116, 30);
		cadastroLivroPanel.add(btnFim);
		
		/*
		 * 					Estoque
		 */		
		Panel estoquePanel = new Panel();
		contenPane.add(estoquePanel, "estoque");
		estoquePanel.setLayout(null);
		
		//btnVoltar.setBounds(10, 11, 89, 22);
		//estoquePanel.add(btnVoltar);
		
		Label labelEstoque = new Label("Estoque");
		labelEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		labelEstoque.setBounds(202, 40, 170, 52);
		estoquePanel.add(labelEstoque);
		
		Choice genero = new Choice();
		genero.setBackground(new Color(204, 204, 153));
		genero.setBounds(44, 111, 496, 20);
		estoquePanel.add(genero);
		genero.add("nao implementado");
		
		Choice livro = new Choice();
		livro.setBackground(new Color(204, 204, 153));
		livro.setBounds(44, 150, 496, 20);
		estoquePanel.add(livro);
		
		Button pesquisa = new Button("Pesquisar");
		pesquisa.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		pesquisa.setBounds(234, 188, 116, 31);
		estoquePanel.add(pesquisa);
		livro.add("nao implementado");
		
		/*
		 * 					Lista por perfil
		 */	
		
		Panel listaPerfilPanel = new Panel();
		contenPane.add(listaPerfilPanel, "listaPerfil");
		estoquePanel.setLayout(null);
		listaPerfilPanel.setLayout(null);
		
		//btnVoltar.setBounds(10, 11, 89, 22);
		//listaPerfilPanel.add(btnVoltar);
		
		Label tituloPerfil = new Label("Lista de perfil");
		tituloPerfil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloPerfil.setBounds(153, 31, 268, 55);
		listaPerfilPanel.add(tituloPerfil);
		
		Choice cPerfil = new Choice();
		cPerfil.setBackground(new Color(204, 204, 153));
		cPerfil.setBounds(10, 114, 564, 20);
		listaPerfilPanel.add(cPerfil);
	
		
		/*
		 * 					Pagamentos
		 */	
		
		Panel pagamentosPanel = new Panel();
		contenPane.add(pagamentosPanel, "pagamentos");
		pagamentosPanel.setLayout(null);
		cPerfil.add("nao implementado");
		
		//btnVoltar.setBounds(10, 11, 89, 22);
		//pagamentosPanel.add(btnVoltar);
		
		Label tituloPagamentos = new Label("Pagamentos efetuados\r\n");
		tituloPagamentos.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloPagamentos.setBounds(66, 21, 441, 87);
		pagamentosPanel.add(tituloPagamentos);
		
		Choice cPagamentos = new Choice();
		cPagamentos.setBackground(new Color(204, 204, 153));
		cPagamentos.setBounds(10, 114, 564, 20);
		pagamentosPanel.add(cPagamentos);
		
		
		/*
		 * 					Clientes Cadastrados
		 */	
		
		Panel cadastradosPanel = new Panel();
		contenPane.add(cadastradosPanel, "clientesCadastrados");
		cadastradosPanel.setLayout(null);
		cPagamentos.add("nao implementado");
		
		//btnVoltar.setBounds(10, 11, 89, 22);
		//cadastradosPanel.add(btnVoltar);
		
		Label tituloClientesCadastrados = new Label("Clientes cadastrados");
		tituloClientesCadastrados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloClientesCadastrados.setBounds(85, 27, 403, 75);
		cadastradosPanel.add(tituloClientesCadastrados);
		
		Choice lista = new Choice();
		lista.setBackground(new Color(204, 204, 153));
		lista.setBounds(50, 108, 483, 20);
		cadastradosPanel.add(lista);
		
		/*
		 * 					Navegacao do Visitante
		 */	

		
		Panel navVisitantePanel = new Panel();
		contenPane.add(navVisitantePanel, "navVisitante");
		navVisitantePanel.setLayout(null);
		
		JLabel tituloVisitante = new JLabel("Nao implementado");
		tituloVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloVisitante.setBounds(117, 83, 360, 46);
		navVisitantePanel.add(tituloVisitante);
		
		/*
		 * 					Cadastro do cliente
		 */	
		
		Panel cadClientePanel = new Panel();
		contenPane.add(cadClientePanel, "cadCliente");
		cadClientePanel.setLayout(null);
		
		//btnVoltar.setBounds(10, 11, 89, 22);
		//cadClientePanel.add(btnVoltar);
		
		JLabel tituloCadastroCliente = new JLabel("Cadastro");
		tituloCadastroCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloCadastroCliente.setBounds(209, 37, 166, 46);
		cadClientePanel.add(tituloCadastroCliente);
		
		JLabel labelName = new JLabel("Digite o nome (min: 3 caracteres)");
		labelName.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelName.setBounds(164, 136, 255, 30);
		cadClientePanel.add(labelName);
		
		JLabel labelCPF = new JLabel("Digite o CPF (apenas n\u00FAmeros)");
		labelCPF.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelCPF.setBounds(170, 243, 244, 30);
		cadClientePanel.add(labelCPF);
		
		JLabel labelCEP = new JLabel("Digite o CEP (apenas numeros)");
		labelCEP.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelCEP.setBounds(170, 344, 244, 30);
		cadClientePanel.add(labelCEP);
		
		nome = new JTextField();
		nome.setBounds(114, 178, 350, 30);
		cadClientePanel.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(114, 284, 350, 30);
		cadClientePanel.add(cpf);
		cpf.setColumns(10);
		
		cep = new JTextField();
		cep.setBounds(114, 385, 350, 30);
		cadClientePanel.add(cep);
		cep.setColumns(10);
		
		JButton confirma = new JButton("Confirmar");
		confirma.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		confirma.setBounds(192, 471, 200, 35);
		cadClientePanel.add(confirma);
		confirma.addActionListener(new ActionListener() {
			//Cria e guarda o Cliente
			public void actionPerformed(ActionEvent arg0) {
				if (Validacao.validaCPF(cpf.getText()) && Validacao.validaCEP(cep.getText()) && Validacao.validaNome(nome.getText())) {
					livraria.setClientes(
					Servicos.criaCliente(
							nome.getText(), Integer.parseInt(cpf.getText()), Integer.parseInt(cep.getText())));
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				}
				else 
					JOptionPane.showMessageDialog(null, "O nome tem que ser maior que 2 caracteres, CEP e CPF precisam ser numeros, apenas!");
					
			}
		});
		
		/*
		 * 					Navegacao do Cliente
		 */	
		
		Panel clientePanel = new Panel();
		contenPane.add(clientePanel, "navCliente");
		clientePanel.setLayout(null);
		
		JLabel labelCatalogoCliente = new JLabel("Nao implementado");
		labelCatalogoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		labelCatalogoCliente.setBounds(108, 79, 336, 74);
		clientePanel.add(labelCatalogoCliente);
		lista.add("Nao implementado");
	}
}

