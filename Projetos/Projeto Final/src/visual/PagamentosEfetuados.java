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

public class PagamentosEfetuados extends JPanel {

	public static void criaPagamentosEfetuados(JPanel contenPane, Livraria livraria) {
		
		
		Panel pagamentosPanel = new Panel();
		contenPane.add(pagamentosPanel, "pagamentos");
		pagamentosPanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		pagamentosPanel.add(btnVoltar);
		
		Label tituloPagamentos = new Label("Pagamentos efetuados\r\n");
		tituloPagamentos.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloPagamentos.setBounds(66, 21, 441, 87);
		pagamentosPanel.add(tituloPagamentos);
		
		Choice cPagamentos = new Choice();
		cPagamentos.setBackground(new Color(204, 204, 153));
		cPagamentos.setBounds(10, 114, 564, 20);
		pagamentosPanel.add(cPagamentos);
		cPagamentos.add("nao implementado");
		
		//Exibição
		CardLayout listaPagamentos = (CardLayout) (contenPane.getLayout());
		listaPagamentos.show(contenPane, "pagamentos");
		
	}

}
