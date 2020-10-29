package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;

public class CadastroDeLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textISBN;
	private JTextField textAutor;
	private JTextField textEditora;
	private JTextField textPreco;
	private JTextField textQuantidade;

	public static void cadastroDeLivro(Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeLivro frame = new CadastroDeLivro(livraria);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CadastroDeLivro(Livraria livraria) {
		setTitle("Cadastro de Livro\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu.criaMenu(livraria);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		contentPane.add(btnVoltar);
		
		JLabel titulo = new JLabel("Cadastro de livro");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(136, 30, 306, 45);
		contentPane.add(titulo);
		
		JLabel labelTitulo = new JLabel("T\u00EDtulo");
		labelTitulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelTitulo.setBounds(264, 95, 56, 20);
		contentPane.add(labelTitulo);
		
		JLabel labelISBN = new JLabel("ISBN");
		labelISBN.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelISBN.setBounds(269, 155, 46, 20);
		contentPane.add(labelISBN);
		
		JLabel labelAutor = new JLabel("Autor");
		labelAutor.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelAutor.setBounds(269, 215, 46, 20);
		contentPane.add(labelAutor);
		
		JLabel labelEditora = new JLabel("Editora");
		labelEditora.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelEditora.setBounds(258, 275, 67, 20);
		contentPane.add(labelEditora);
		
		JLabel labelGenero = new JLabel("G\u00EAnero");
		labelGenero.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelGenero.setBounds(259, 455, 67, 20);
		contentPane.add(labelGenero);
		
		JLabel labelPreco = new JLabel("Pre\u00E7o (x.xx)");
		labelPreco.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelPreco.setBounds(239, 335, 105, 20);
		contentPane.add(labelPreco);
		
		JLabel labelQuantidade = new JLabel("Quantidade");
		labelQuantidade.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelQuantidade.setBounds(243, 395, 98, 20);
		contentPane.add(labelQuantidade);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(142, 120, 300, 25);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		textISBN = new JTextField();
		textISBN.setBounds(142, 180, 300, 25);
		contentPane.add(textISBN);
		textISBN.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(142, 240, 300, 25);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		textEditora = new JTextField();
		textEditora.setBounds(142, 300, 300, 25);
		contentPane.add(textEditora);
		textEditora.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(142, 360, 300, 25);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(142, 420, 300, 25);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		Choice choiceGenero = new Choice();
		choiceGenero.setBackground(new Color(204, 204, 153));
		choiceGenero.setBounds(142, 480, 300, 25);
		contentPane.add(choiceGenero);
		choiceGenero.add("nao implementado");
		
		JButton btnFim = new JButton("Finalizar");
		btnFim.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFim.setBounds(234, 510, 116, 30);
		contentPane.add(btnFim);
	}
}
