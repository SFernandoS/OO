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

public class NavegacaoDoVisitante extends JPanel {

	public static void criaNavegacaoDoVisitante(JPanel contenPane, Livraria livraria) {
		
		//Design
		Panel navVisitantePanel = new Panel();
		contenPane.add(navVisitantePanel, "navVisitante");
		navVisitantePanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout volta = (CardLayout) (contenPane.getLayout());
				volta.show(contenPane, "catalogo");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		navVisitantePanel.add(btnVoltar);
		
		JLabel tituloVisitante = new JLabel("Nao implementado");
		tituloVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloVisitante.setBounds(117, 83, 360, 46);
		navVisitantePanel.add(tituloVisitante);
		
		//Exibição
		CardLayout btnCliente = (CardLayout) (contenPane.getLayout());
		btnCliente.show(contenPane, "navCliente");
	}

}
