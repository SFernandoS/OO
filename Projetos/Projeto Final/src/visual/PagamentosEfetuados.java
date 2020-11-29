package visual;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dados.Livraria;
import servicos.Servicos;

/**
 * mostra todos os pagamentos efetuados
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

@SuppressWarnings("serial")
public class PagamentosEfetuados extends JPanel {

	/**
	 * Um Panel que mostra todos os pagamentos efetuados
	 * 
	 * @param contenPane
	 * @param livraria
	 */
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
		panel.setBounds(10, 203, 550, 550);
		pagamentosPanel.add(panel);
		panel.setLayout(null);

		for (int i = 0; i < livraria.getFuncionario().getVendas().size(); i++) {
			if (livraria.getFuncionario().getVendas().get(i).getConfirma()) {
				cPagamentos.add(livraria.getFuncionario().getVendas().get(i).getPedido().getNome());
			}
		}

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DecimalFormat format = new DecimalFormat("##.##");

				if (cPagamentos.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados!");
				else {
					panel.removeAll();
					JLabel lblNome = new JLabel("Nome: ");
					lblNome.setBounds(10, 45, 66, 27);
					panel.add(lblNome);
					lblNome.setForeground(Color.DARK_GRAY);
					lblNome.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

					JLabel lblDtCompra = new JLabel("Data da Compra:");
					lblDtCompra.setBounds(10, 136, 200, 27);
					panel.add(lblDtCompra);
					lblDtCompra.setForeground(Color.DARK_GRAY);
					lblDtCompra.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

					JLabel lblCEP = new JLabel("CEP:");
					lblCEP.setBounds(10, 230, 100, 20);
					panel.add(lblCEP);
					lblCEP.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					lblCEP.setForeground(Color.DARK_GRAY);

					JLabel lblPagamento = new JLabel("Pagamento:");
					lblPagamento.setBounds(10, 300, 400, 19);
					panel.add(lblPagamento);
					lblPagamento.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
					lblPagamento.setForeground(Color.DARK_GRAY);

					JLabel nomeDoCliente = new JLabel(livraria.getFuncionario().getVendas()
							.get(cPagamentos.getSelectedIndex()).getPedido().getNome());
					nomeDoCliente.setBounds(77, 47, 407, 22);
					panel.add(nomeDoCliente);
					nomeDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

					JLabel dataDaCompra = new JLabel(livraria.getFuncionario().getVendas()
							.get(cPagamentos.getSelectedIndex()).getDataDaCompra());
					dataDaCompra.setBounds(150, 139, 407, 19);
					panel.add(dataDaCompra);
					dataDaCompra.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

					JLabel cepDoCliente = new JLabel(livraria.getFuncionario().getVendas()
							.get(cPagamentos.getSelectedIndex()).getPedido().getCEP());
					cepDoCliente.setBounds(77, 231, 407, 21);
					panel.add(cepDoCliente);
					cepDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

					JLabel pagamentoDoCliente = new JLabel(format.format(
							livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getTotal()));
					pagamentoDoCliente.setBounds(120, 300, 360, 19);
					panel.add(pagamentoDoCliente);
					pagamentoDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
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
