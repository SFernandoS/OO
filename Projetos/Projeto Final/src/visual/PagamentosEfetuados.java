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
import servicos.Servicos;

@SuppressWarnings("serial")
public class PagamentosEfetuados extends JPanel {

	public static void criaPagamentosEfetuados(JPanel contenPane, Livraria livraria) {

		JPanel pagamentosPanel = new JPanel();
		contenPane.add(pagamentosPanel, "pagamentos");
		pagamentosPanel.setLayout(null);
		pagamentosPanel.setBackground(new Color(204, 204, 102));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		pagamentosPanel.add(btnVoltar);

		JLabel tituloPagamentos = new JLabel("Pagamentos efetuados\r\n");
		tituloPagamentos.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloPagamentos.setBounds(66, 21, 441, 87);
		pagamentosPanel.add(tituloPagamentos);

		Choice cPagamentos = new Choice();
		cPagamentos.setBackground(new Color(204, 204, 153));
		cPagamentos.setBounds(10, 114, 564, 20);
		pagamentosPanel.add(cPagamentos);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(50, 203, 550, 550);
		pagamentosPanel.add(panel);
		panel.setLayout(null);

		for (int i = 0; i < livraria.getClientes().size(); i++) {
			if (!livraria.getClientes().get(i).getCesta().isPendente()) {
				cPagamentos.add(livraria.getClientes().get(i).getNome());
			}
		}

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (cPagamentos.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados!");
				else {
					Servicos.mostraPagamentosEfetuados(panel, livraria, cPagamentos);
				}
			}
		});
		btnPesquisa.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisa.setBounds(10, 148, 564, 27);
		pagamentosPanel.add(btnPesquisa);

		// Exibição
		CardLayout listaPagamentos = (CardLayout) (contenPane.getLayout());
		listaPagamentos.show(contenPane, "pagamentos");

	}

}
