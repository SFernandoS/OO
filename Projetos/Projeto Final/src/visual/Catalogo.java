package visual;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import dados.Livraria;

public class Catalogo extends JPanel {

	public static void criaCatalogo(JPanel contenPane, Livraria livraria) {
		
		Panel catalogoPanel = new Panel();
		contenPane.add(catalogoPanel, "catalogo");
		catalogoPanel.setLayout(null);
		
		Label lblCatalogo = new Label("Cat\u00E1logo");
		lblCatalogo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblCatalogo.setBounds(196, 23, 182, 83);
		catalogoPanel.add(lblCatalogo);
		
		Button btnVoltar = new Button("Voltar");
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
		Button navVisitante = new Button("Navegar como visitante");
		navVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		navVisitante.setBounds(132, 161, 310, 55);
		catalogoPanel.add(navVisitante);
		navVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NagevacaoDoCliente.nagevacaoDoCliente(contenPane, livraria);
			}
		});
		
		// CADASTRO DO CLIENTE
		Button cadCliente = new Button("Cadastrar cliente");
		cadCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		cadCliente.setBounds(132, 248, 310, 55);
		catalogoPanel.add(cadCliente);
		cadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDoCliente.cadastroDoCliente(contenPane, livraria);
			}
		});
		
		//CLIENTE
		Button btnCliente = new Button("Cliente");
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
