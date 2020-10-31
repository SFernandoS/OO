package visual;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dados.Livraria;

public class NagevacaoDoCliente extends JPanel {

	
	public static void nagevacaoDoCliente(JPanel contenPane, Livraria livraria) {	
		//Design
		Panel clientePanel = new Panel();
		contenPane.add(clientePanel, "navCliente");
		clientePanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout volta = (CardLayout) (contenPane.getLayout());
				volta.show(contenPane, "catalogo");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		clientePanel.add(btnVoltar);
		
		JLabel labelCatalogoCliente = new JLabel("Nao implementado");
		labelCatalogoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		labelCatalogoCliente.setBounds(108, 79, 336, 74);
		clientePanel.add(labelCatalogoCliente);
		
		
		//Exibição
		CardLayout btnCliente = (CardLayout) (contenPane.getLayout());
		btnCliente.show(contenPane, "navCliente");

	}

}
