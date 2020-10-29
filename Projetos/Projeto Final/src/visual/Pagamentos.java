package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Choice;

public class Pagamentos extends JFrame {

	private JPanel painel;


	public static void pagamentos(Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagamentos frame = new Pagamentos(livraria);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Pagamentos(Livraria livraria) {
		setTitle("Pagamentos efetuados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		painel = new JPanel();
		painel.setBackground(new Color(204, 204, 102));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu.criaMenu(livraria);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		painel.add(btnVoltar);
		
		JLabel titulo = new JLabel("Pagamentos efetuados\r\n");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(99, 21, 386, 87);
		painel.add(titulo);
		
		Choice cPagamentos = new Choice();
		cPagamentos.setBackground(new Color(204, 204, 153));
		cPagamentos.setBounds(10, 114, 564, 20);
		painel.add(cPagamentos);
		cPagamentos.add("nao implementado");
		
	}
}
