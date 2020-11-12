package visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dados.Livraria;
import servicos.Servicos;

@SuppressWarnings("serial")
public class Catalogo extends JPanel {

	public static void criaCatalogo(JPanel contenPane, Livraria livraria) {
		
		JPanel catalogoPanel = new JPanel();
		contenPane.add(catalogoPanel, "catalogo");
		catalogoPanel.setLayout(null);
		catalogoPanel.setBackground(new Color(204, 204, 102));
		
		JLabel lblCatalogo = new JLabel("Cat\u00E1logo");
		lblCatalogo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblCatalogo.setBounds(196, 23, 182, 83);
		catalogoPanel.add(lblCatalogo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		catalogoPanel.add(btnVoltar);
		
		// NAVEGACAO DO VISITANTE
		JButton navVisitante = new JButton("Navegar como visitante");
		navVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		navVisitante.setBounds(132, 161, 310, 55);
		catalogoPanel.add(navVisitante);
		navVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NavegacaoDoVisitante.criaNavegacaoDoVisitante(contenPane, livraria);
			}
		});
		
		// CADASTRO DO CLIENTE
		JButton cadCliente = new JButton("Cadastrar cliente");
		cadCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		cadCliente.setBounds(132, 248, 310, 55);
		catalogoPanel.add(cadCliente);
		cadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDoCliente.cadastroDoCliente(contenPane, livraria);
			}
		});
		
		//CONFIRMAR COMPRA
				JButton btnConfirmaVenda = new JButton("Confirmar Compra");
				btnConfirmaVenda.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
				btnConfirmaVenda.setBounds(132, 332, 310, 55);
				catalogoPanel.add(btnConfirmaVenda);
				btnConfirmaVenda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
		
		//CLIENTE
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnCliente.setBounds(132, 419, 310, 55);
		catalogoPanel.add(btnCliente);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NagevacaoDoCliente.nagevacaoDoCliente(contenPane, livraria);
			}
		});
		
		//Exibição
		CardLayout cadastro = (CardLayout) (contenPane.getLayout());
		cadastro.show(contenPane, "catalogo");
	}

}
