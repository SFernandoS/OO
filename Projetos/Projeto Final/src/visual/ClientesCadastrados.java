package visual;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dados.Livraria;

@SuppressWarnings("serial")
public class ClientesCadastrados extends JPanel {
	public ClientesCadastrados() {
	}

	public static void criaClientesCadastrados(JPanel contenPane, Livraria livraria) {
		
		//Design
		JPanel cadastradosPanel = new JPanel();
		contenPane.add(cadastradosPanel, "clientesCadastrados");
		cadastradosPanel.setLayout(null);
		cadastradosPanel.setBackground(new Color(204, 204, 102));

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		cadastradosPanel.add(btnVoltar);
		
		JLabel tituloClientesCadastrados = new JLabel("Clientes cadastrados");
		tituloClientesCadastrados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloClientesCadastrados.setBounds(85, 27, 403, 75);
		cadastradosPanel.add(tituloClientesCadastrados);
		
		Choice lista = new Choice();
		lista.setBackground(new Color(204, 204, 153));
		lista.setBounds(50, 108, 483, 20);
		cadastradosPanel.add(lista);
		
		for (int i = 0; i < livraria.getClientes().size(); i++) 
			lista.add(livraria.getClientes().get(i).getNome());
			
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(lista.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados!");
				else {
					
					JPanel panel = new JPanel();
					panel.setBackground(new Color(204, 204, 153));
					panel.setBounds(50, 203, 483, 279);
					cadastradosPanel.add(panel);
					panel.setLayout(null);
					
					JLabel lblNome = new JLabel("Nome: ");
					lblNome.setBounds(10, 45, 66, 27);
					panel.add(lblNome);
					lblNome.setForeground(Color.DARK_GRAY);
					lblNome.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					
					JLabel lblCPF = new JLabel("CPF:");
					lblCPF.setBounds(10, 136, 46, 27);
					panel.add(lblCPF);
					lblCPF.setForeground(Color.DARK_GRAY);
					lblCPF.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					
					JLabel lblCEP = new JLabel("CEP:");
					lblCEP.setBounds(10, 230, 46, 20);
					panel.add(lblCEP);
					lblCEP.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					lblCEP.setForeground(Color.DARK_GRAY);
										
					JLabel nomeDoCliente = new JLabel(livraria.getClientes().get(lista.getSelectedIndex()).getNome());
					nomeDoCliente.setBounds(77, 45, 417, 22);
					panel.add(nomeDoCliente);
					nomeDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					
					JLabel cepDoCliente = new JLabel(Integer.toString(livraria.getClientes().get(lista.getSelectedIndex()).getCEP()));
					cepDoCliente.setBounds(77, 136, 407, 21);
					panel.add(cepDoCliente);
					cepDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					
					JLabel cpfDoCliente = new JLabel(Integer.toString(livraria.getClientes().get(lista.getSelectedIndex()).getCPF()));
					cpfDoCliente.setBounds(77, 230, 417, 19);
					panel.add(cpfDoCliente);
					cpfDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
				
				}
			}
		});
		btnPesquisa.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisa.setBounds(50, 148, 483, 27);
		cadastradosPanel.add(btnPesquisa);
		
		//Exibição
		CardLayout cadastrados = (CardLayout) (contenPane.getLayout());
		cadastrados.show(contenPane, "clientesCadastrados");

	}

}
