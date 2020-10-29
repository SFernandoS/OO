package visual;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;

public class Perfil extends JFrame {

	private JPanel contentPane;

	public static void listaDePerfil(Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil(livraria);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Perfil(Livraria livraria) {
		setTitle("Lista de Perfil");
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
		
		JLabel titulo = new JLabel("Lista de perfil");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(164, 21, 255, 87);
		contentPane.add(titulo);
		
		Choice cPerfil = new Choice();
		cPerfil.setBackground(new Color(204, 204, 153));
		cPerfil.setBounds(10, 114, 564, 20);
		contentPane.add(cPerfil);
		cPerfil.add("nao implementado");
	}

}
