package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Choice;
import javax.swing.JButton;

public class Estoque extends JFrame {

	private JPanel contentPane;

	public static void estoque (Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque(livraria);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Estoque(Livraria livraria) {
		setBackground(new Color(255, 255, 255));
		setTitle("Estoque\r\n");
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
		
		JLabel labelEstoque = new JLabel("Estoque");
		labelEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		labelEstoque.setBounds(218, 40, 148, 52);
		contentPane.add(labelEstoque);
		
		Choice genero = new Choice();
		genero.setBackground(new Color(204, 204, 153));
		genero.setBounds(44, 111, 496, 20);
		contentPane.add(genero);
		genero.add("nao implementado");
		
		Choice livro = new Choice();
		livro.setBackground(new Color(204, 204, 153));
		livro.setBounds(44, 150, 496, 20);
		contentPane.add(livro);
		
		JButton pesquisa = new JButton("Pesquisar");
		pesquisa.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		pesquisa.setBounds(234, 188, 116, 31);
		contentPane.add(pesquisa);
		livro.add("nao implementado");
		pesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
