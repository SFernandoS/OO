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

public class ListaPorPefil extends JPanel {

	public static void criaListaPorPefil(JPanel contenPane, Livraria livraria) {	
		
		//Design
		Panel listaPerfilPanel = new Panel();
		contenPane.add(listaPerfilPanel, "listaPerfil");
		listaPerfilPanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		listaPerfilPanel.add(btnVoltar);
		
		Label tituloPerfil = new Label("Lista de perfil");
		tituloPerfil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloPerfil.setBounds(153, 31, 268, 55);
		listaPerfilPanel.add(tituloPerfil);
		
		Choice cPerfil = new Choice();
		cPerfil.setBackground(new Color(204, 204, 153));
		cPerfil.setBounds(10, 114, 564, 20);
		listaPerfilPanel.add(cPerfil);
		cPerfil.add("Nao implementado");
		
		//Exibição
		CardLayout listaPerfil = (CardLayout) (contenPane.getLayout());
		listaPerfil.show(contenPane, "listaPerfil");
	}

}
