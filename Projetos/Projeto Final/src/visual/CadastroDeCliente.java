package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.Livraria;
import servicos.Servicos;
import validacao.Validacao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class CadastroDeCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField cpf;
	private JTextField cep;

	public static void cadastraCliente(Livraria livraria) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeCliente frame = new CadastroDeCliente(livraria);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastroDeCliente(Livraria livraria) {
		setTitle("Cadastro de Cliente\r\n");
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
				ClienteOuVisitante.criaClienteOuVisitante(livraria);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		contentPane.add(btnVoltar);
		
		JLabel titulo = new JLabel("Cadastro");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(209, 37, 166, 46);
		contentPane.add(titulo);
		
		JLabel labelName = new JLabel("Digite o nome (min: 3 caracteres)");
		labelName.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelName.setBounds(164, 136, 255, 30);
		contentPane.add(labelName);
		
		JLabel labelCPF = new JLabel("Digite o CPF (apenas n\u00FAmeros)");
		labelCPF.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelCPF.setBounds(170, 243, 244, 30);
		contentPane.add(labelCPF);
		
		JLabel labelCEP = new JLabel("Digite o CEP (apenas numeros)");
		labelCEP.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelCEP.setBounds(170, 344, 244, 30);
		contentPane.add(labelCEP);
		
		nome = new JTextField();
		nome.setBounds(114, 178, 350, 30);
		contentPane.add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(114, 284, 350, 30);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		cep = new JTextField();
		cep.setBounds(114, 385, 350, 30);
		contentPane.add(cep);
		cep.setColumns(10);
		
		JButton confirma = new JButton("Confirmar");
		confirma.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		confirma.setBounds(192, 471, 200, 35);
		contentPane.add(confirma);
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
	}
}
