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

/**
 * Panel que serve para mostrar os clientes cadastrados
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

@SuppressWarnings("serial")
public class ClientesCadastrados extends JPanel {
	/**
	 * Panel que serve para mostrar os clientes cadastrados
	 * 
	 * @param contenPane
	 * @param livraria
	 */
	public static void criaClientesCadastrados(JPanel contenPane, Livraria livraria) {

		// Design
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		panel.setBounds(50, 203, 483, 279);
		cadastradosPanel.add(panel);
		panel.setLayout(null);

		for (int i = 0; i < livraria.getClientes().size(); i++)
			lista.add(livraria.getClientes().get(i).getNome());

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (lista.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados!");
				else {
					livraria.clientesCadastrados(panel, livraria, lista);
				}
			}
		});
		btnPesquisa.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisa.setBounds(50, 148, 483, 27);
		cadastradosPanel.add(btnPesquisa);

		// Exibição
		CardLayout cadastrados = (CardLayout) (contenPane.getLayout());
		cadastrados.show(contenPane, "clientesCadastrados");

	}

}
