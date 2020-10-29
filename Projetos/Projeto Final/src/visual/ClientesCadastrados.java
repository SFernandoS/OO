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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import java.awt.Choice;

public class ClientesCadastrados extends JFrame {

	private JPanel contentPane;

	public static void listaDeClientes(Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesCadastrados frame = new ClientesCadastrados(livraria);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientesCadastrados(Livraria livraria) {
		setTitle("Clientes Cadastrados\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
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
		
		JLabel titulo = new JLabel("Clientes cadastrados");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(109, 27, 366, 75);
		contentPane.add(titulo);
		
		Choice lista = new Choice();
		lista.setBackground(new Color(204, 204, 153));
		lista.setBounds(50, 108, 483, 20);
		contentPane.add(lista);
		lista.add("Não implementado");
	}
}
