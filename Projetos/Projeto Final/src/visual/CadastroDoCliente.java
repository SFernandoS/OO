package visual;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dados.Livraria;
import servicos.Servicos;
import validacao.Validacao;

public class CadastroDoCliente extends JPanel {
	
	static private JTextField nome;
	static private JTextField cpf;
	static private JTextField cep;

	public static void cadastroDoCliente(JPanel contenPane, Livraria livraria) {
	
		//Design
		Panel cadClientePanel = new Panel();
		contenPane.add(cadClientePanel, "cadCliente");
		cadClientePanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout volta = (CardLayout) (contenPane.getLayout());
				volta.show(contenPane, "catalogo");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		cadClientePanel.add(btnVoltar);
		
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
		
		//Exibicao
		CardLayout cadCliente = (CardLayout) (contenPane.getLayout());
		cadCliente.show(contenPane, "cadCliente");
	}

}
