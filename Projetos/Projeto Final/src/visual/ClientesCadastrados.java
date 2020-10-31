package visual;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import dados.Livraria;

public class ClientesCadastrados extends JPanel {

	public static void criaClientesCadastrados(JPanel contenPane, Livraria livraria) {
		
		//Design
		Panel cadastradosPanel = new Panel();
		contenPane.add(cadastradosPanel, "clientesCadastrados");
		cadastradosPanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		cadastradosPanel.add(btnVoltar);
		
		Label tituloClientesCadastrados = new Label("Clientes cadastrados");
		tituloClientesCadastrados.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloClientesCadastrados.setBounds(85, 27, 403, 75);
		cadastradosPanel.add(tituloClientesCadastrados);
		
		Choice lista = new Choice();
		lista.setBackground(new Color(204, 204, 153));
		lista.setBounds(50, 108, 483, 20);
		cadastradosPanel.add(lista);
		lista.add("Nao implementado");
		
		//Exibição
		CardLayout cadastrados = (CardLayout) (contenPane.getLayout());
		cadastrados.show(contenPane, "clientesCadastrados");
	}

}
