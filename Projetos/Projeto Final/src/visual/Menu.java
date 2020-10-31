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
		
		//Catálogo
		Button catalogo = new Button("Catalogo");
		catalogo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		inicio.add(catalogo);
		catalogo.setBounds(117, 100, 350, 50);
		catalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Catalogo.criaCatalogo(contenPane, livraria);
			}
		});
		
		//Estoque
		Button livroEstoque = new Button("Estoque");
		livroEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		livroEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Estoque.criaEstoque(contenPane, livraria);
			}
		});
		livroEstoque.setBounds(117, 475, 350, 50);
		inicio.add(livroEstoque);
		
		//Clientes cadastrados
		Button clienteCadastrados = new Button("Cadastrados");
		clienteCadastrados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		clienteCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientesCadastrados.criaClientesCadastrados(contenPane, livraria);
			}
		});
		clienteCadastrados.setBounds(117, 250, 350, 50);
		inicio.add(clienteCadastrados);
		
		//Pagamentos Efetuados
		Button pagamentosEfetuados = new Button("Pagamentos efetuados");
		pagamentosEfetuados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		pagamentosEfetuados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PagamentosEfetuados.criaPagamentosEfetuados(contenPane, livraria);
			}
		});
		pagamentosEfetuados.setBounds(117, 325, 350, 50);
		inicio.add(pagamentosEfetuados);
		
		//Lista por perfil
		Button listaPerfil = new Button("Lista por perfil");
		listaPerfil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		listaPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPorPefil.criaListaPorPefil(contenPane, livraria);
			}
		});
		listaPerfil.setBounds(117, 400, 350, 50);
		inicio.add(listaPerfil);

		//Cadastro de Livro
		Button cadastroLivro = new Button("Cadastrar livro");
		cadastroLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDeLivro.cadastroDeLivro(contenPane, livraria);
			}
		});
		cadastroLivro.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		cadastroLivro.setBounds(117, 175, 350, 50);
		inicio.add(cadastroLivro);

	}
}

