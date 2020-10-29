package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;
import servicos.Servicos;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClienteOuVisitante extends JFrame{

	private JPanel contentPane;

	public static void criaClienteOuVisitante(Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteOuVisitante frame = new ClienteOuVisitante(livraria);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClienteOuVisitante(Livraria livraria) {
		setTitle("Catalogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setToolTipText("Catalogo");
		contentPane.setBackground(new Color(204, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cat\u00E1logo");
		lblNewLabel.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(200, 85, 184, 60);
		contentPane.add(lblNewLabel);
		
		JButton navVisitante = new JButton("Navegar como visitante");
		navVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		navVisitante.setBounds(117, 225, 350, 50);
		contentPane.add(navVisitante);
		
		JButton navCliente = new JButton("Navegar como cliente");
		navCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		navCliente.setBounds(117, 364, 350, 50);
		contentPane.add(navCliente);
		
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
		
		navCliente.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				CadastroDeCliente.cadastraCliente(livraria);
			}
		});
	}
}
