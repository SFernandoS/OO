package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame{

	private JPanel contentPane;

	public static void criaMenu(Livraria livraria) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(livraria);
					frame.setResizable(false);
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel saudacao = new JLabel("Bem vindo(a)");
		saudacao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		saudacao.setBounds(167, 35, 250, 40);
		contentPane.add(saudacao);
		
		JButton catalogo = new JButton("Catalogo");
		catalogo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		catalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ClienteOuVisitante.criaClienteOuVisitante(livraria);
			}
		});
		
		catalogo.setBounds(117, 100, 350, 50);
		contentPane.add(catalogo);
		
		JButton livroEstoque = new JButton("Estoque");
		livroEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		livroEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Estoque.estoque(livraria);
			}
		});
		livroEstoque.setBounds(117, 475, 350, 50);
		contentPane.add(livroEstoque);
		
		JButton clienteCadastrados = new JButton("Cadastrados");
		clienteCadastrados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		clienteCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ClientesCadastrados.listaDeClientes(livraria);
			}
		});
		clienteCadastrados.setBounds(117, 250, 350, 50);
		contentPane.add(clienteCadastrados);
		
		JButton pagamentosEfetuados = new JButton("Pagamentos efetuados");
		pagamentosEfetuados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		pagamentosEfetuados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Pagamentos.pagamentos(livraria);
			}
		});
		pagamentosEfetuados.setBounds(117, 325, 350, 50);
		contentPane.add(pagamentosEfetuados);
		
		JButton listaPerfil = new JButton("Lista por perfil");
		listaPerfil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		listaPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Perfil.listaDePerfil(livraria);
			}
		});
		listaPerfil.setBounds(117, 400, 350, 50);
		contentPane.add(listaPerfil);
		
		JButton cadastroLivro = new JButton("Cadastrar livro");
		cadastroLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				CadastroDeLivro.cadastroDeLivro(livraria);
			}
		});
		cadastroLivro.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		cadastroLivro.setBounds(117, 175, 350, 50);
		contentPane.add(cadastroLivro);
	}
}
