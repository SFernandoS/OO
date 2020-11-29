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
 * Panel do Cátalogo, aqui tem todos os livros cadastrados na livraria
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

@SuppressWarnings("serial")
public class Estoque extends JPanel {
	/**
	 * Panel do Cátalogo, aqui tem todos os livros cadastrados na livraria
	 * 
	 * @param contenPane
	 * @param livraria
	 */
	public static void criaEstoque(JPanel contenPane, Livraria livraria) {
		JPanel estoquePanel = new JPanel();
		contenPane.add(estoquePanel, "estoque");
		estoquePanel.setLayout(null);
		estoquePanel.setLayout(new CardLayout(0, 0));

		// Inicio: (menu)
		JPanel inicioEstoque = new JPanel();
		inicioEstoque.setBackground(new Color(204, 204, 102));
		estoquePanel.add(inicioEstoque, "inicioEstoque");
		inicioEstoque.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		inicioEstoque.add(btnVoltar);

		JLabel tituloEstoque = new JLabel("Estoque\r\n");
		tituloEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloEstoque.setBounds(210, 46, 154, 43);
		inicioEstoque.add(tituloEstoque);

		// Exibicao infantil
		JButton btnInfantil = new JButton("Infantil");
		btnInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout infantilTela = (CardLayout) (estoquePanel.getLayout());
				infantilTela.show(estoquePanel, "infantilTela");
			}
		});
		btnInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnInfantil.setBounds(152, 139, 270, 40);
		inicioEstoque.add(btnInfantil);

		// Exibicao ficcao
		JButton btnFiccao = new JButton("Ficcao");
		btnFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraFiccao = (CardLayout) (estoquePanel.getLayout());
				mostraFiccao.show(estoquePanel, "ficcaoTela");
			}
		});
		btnFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFiccao.setBounds(152, 210, 270, 40);
		inicioEstoque.add(btnFiccao);

		// Exibicao tencico
		JButton btnTecnico = new JButton("Tecnico");
		btnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraTecnico = (CardLayout) (estoquePanel.getLayout());
				mostraTecnico.show(estoquePanel, "tecnicoTela");
			}
		});
		btnTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnTecnico.setBounds(152, 278, 270, 40);
		inicioEstoque.add(btnTecnico);

		// Exibicao outros
		JButton btnOutros = new JButton("Outros");
		btnOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraOutros = (CardLayout) (estoquePanel.getLayout());
				mostraOutros.show(estoquePanel, "outrosTela");
			}
		});
		btnOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnOutros.setBounds(152, 351, 270, 40);
		inicioEstoque.add(btnOutros);

		// Voltar para o estoque

		// Panel: Infantil
		infantilPanel(estoquePanel, livraria);

		// Panel Ficcao
		ficcaoPanel(estoquePanel, livraria);

		// Panel tecnico
		tecnicoPanel(estoquePanel, livraria);

		// Panel: Outros
		outrosPanel(estoquePanel, livraria);

		// Exibição do estoque
		CardLayout estoque = (CardLayout) (contenPane.getLayout());
		estoque.show(contenPane, "estoque");
	}

	// Volta para o Estoque
	public static JButton voltarEstoque(JPanel estoquePanel) {
		JButton btnVoltarEstoque = new JButton("Voltar");
		btnVoltarEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (estoquePanel.getLayout());
				inicio.show(estoquePanel, "inicioEstoque");
			}
		});
		btnVoltarEstoque.setBounds(10, 11, 89, 22);

		return btnVoltarEstoque;
	}

	// Panel infantil
	public static void infantilPanel(JPanel estoquePanel, Livraria livraria) {
		JPanel infantil = new JPanel();
		infantil.setBackground(new Color(204, 204, 102));
		estoquePanel.add(infantil, "infantilTela");
		infantil.setLayout(null);
		infantil.add(voltarEstoque(estoquePanel));

		JLabel lblInfantil = new JLabel("Infantil\r\n");
		lblInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblInfantil.setBounds(213, 35, 147, 60);
		infantil.add(lblInfantil);

		Choice choiceInfantil = new Choice();
		choiceInfantil.setBounds(10, 121, 554, 20);
		infantil.add(choiceInfantil);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getInfantil().size(); i++)
			choiceInfantil.add(livraria.getCatalogo().getInfantil().get(i).getTitulo());

		// Panel do resultado da busca
		JButton btnPesquisaInfantil = new JButton("Pesquisar");
		btnPesquisaInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JPanel panelPesquisaInfantil = new JPanel();
				panelPesquisaInfantil.setBackground(new Color(204, 204, 153));
				panelPesquisaInfantil.setBounds(10, 214, 554, 326);
				infantil.add(panelPesquisaInfantil);
				panelPesquisaInfantil.setLayout(null);

				if (choiceInfantil.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else
					livraria.getCatalogo().relacaoDeLivrosInfantil(livraria, choiceInfantil, panelPesquisaInfantil);
			}
		});
		btnPesquisaInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaInfantil.setBounds(223, 157, 127, 25);
		infantil.add(btnPesquisaInfantil);
	}

	// Panel ficcao
	public static void ficcaoPanel(JPanel estoquePanel, Livraria livraria) {
		JPanel ficcao = new JPanel();
		ficcao.setBackground(new Color(204, 204, 102));
		estoquePanel.add(ficcao, "ficcaoTela");
		ficcao.setLayout(null);
		ficcao.add(voltarEstoque(estoquePanel));

		JLabel lblFiccao = new JLabel("Ficcao");
		lblFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblFiccao.setBounds(223, 27, 127, 68);
		ficcao.add(lblFiccao);

		Choice choiceFiccao = new Choice();
		choiceFiccao.setBounds(10, 121, 554, 20);
		ficcao.add(choiceFiccao);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getFiccao().size(); i++)
			choiceFiccao.add(livraria.getCatalogo().getFiccao().get(i).getTitulo());

		JButton btnPesquisaFiccao = new JButton("Pesquisar");
		btnPesquisaFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceFiccao.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else
					livraria.getCatalogo().relacaoDeLivrosFiccao(livraria, choiceFiccao, ficcao);
			}
		});
		btnPesquisaFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaFiccao.setBounds(223, 157, 127, 25);
		ficcao.add(btnPesquisaFiccao);
	}

	// Panel tecnico
	public static void tecnicoPanel(JPanel estoquePanel, Livraria livraria) {
		JPanel tecnico = new JPanel();
		tecnico.setBackground(new Color(204, 204, 102));
		estoquePanel.add(tecnico, "tecnicoTela");
		tecnico.setLayout(null);
		tecnico.add(voltarEstoque(estoquePanel));

		JLabel lblTecnico = new JLabel("Tecnico");
		lblTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblTecnico.setBounds(213, 35, 147, 60);
		tecnico.add(lblTecnico);

		Choice choiceTecnico = new Choice();
		choiceTecnico.setBounds(10, 121, 554, 20);
		tecnico.add(choiceTecnico);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getTecnico().size(); i++)
			choiceTecnico.add(livraria.getCatalogo().getTecnico().get(i).getTitulo());

		JButton btnPesquisaTecnico = new JButton("Pesquisar");
		btnPesquisaTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceTecnico.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else
					livraria.getCatalogo().relacaoDeLivrosTecnico(livraria, choiceTecnico, tecnico);
			}
		});
		btnPesquisaTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaTecnico.setBounds(223, 157, 127, 25);
		tecnico.add(btnPesquisaTecnico);
	}

	// Panel outros
	public static void outrosPanel(JPanel estoquePanel, Livraria livraria) {
		JPanel outros = new JPanel();
		outros.setBackground(new Color(204, 204, 102));
		estoquePanel.add(outros, "outrosTela");
		outros.setLayout(null);
		outros.add(voltarEstoque(estoquePanel));

		JLabel lblOutros = new JLabel("Outros");
		lblOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblOutros.setBounds(223, 35, 127, 60);
		outros.add(lblOutros);

		Choice choiceOutros = new Choice();
		choiceOutros.setBounds(10, 121, 554, 20);
		outros.add(choiceOutros);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getOutros().size(); i++)
			choiceOutros.add(livraria.getCatalogo().getOutros().get(i).getTitulo());

		JButton btnPesquisaOutros = new JButton("Pesquisar");
		btnPesquisaOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceOutros.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {

					JPanel panelPesquisaOutros = new JPanel();
					panelPesquisaOutros.setBackground(new Color(204, 204, 153));
					panelPesquisaOutros.setBounds(10, 214, 554, 326);
					outros.add(panelPesquisaOutros);
					panelPesquisaOutros.setLayout(null);

					livraria.getCatalogo().relacaoDeLivrosOutros(livraria, choiceOutros, panelPesquisaOutros);
				}
			}
		});
		btnPesquisaOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaOutros.setBounds(223, 157, 127, 25);
		outros.add(btnPesquisaOutros);
	}

}
