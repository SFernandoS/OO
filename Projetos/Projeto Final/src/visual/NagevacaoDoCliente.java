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
import javax.swing.event.AncestorListener;

import dados.Livraria;
import servicos.Servicos;

@SuppressWarnings("serial")
public class NagevacaoDoCliente extends JPanel {

	public static void nagevacaoDoCliente(JPanel contenPane, Livraria livraria) {
		int numeroDoCliente = -1;

		JPanel clientePanel = new JPanel();
		contenPane.add(clientePanel, "navCliente");
		clientePanel.setLayout(null);
		clientePanel.setLayout(new CardLayout(0, 0));

		// Inicio: (menu)
		JPanel inicioclientePanel = new JPanel();
		inicioclientePanel.setBackground(new Color(204, 204, 102));
		clientePanel.add(inicioclientePanel, "inicioclientePanel");
		inicioclientePanel.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		inicioclientePanel.add(btnVoltar);

		JLabel tituloCliente = new JLabel("Cliente\n");
		tituloCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloCliente.setBounds(210, 46, 154, 43);
		inicioclientePanel.add(tituloCliente);

		// Exibicao infantil
		JButton btnInfantil = new JButton("Infantil");
		btnInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout infantilTela = (CardLayout) (clientePanel.getLayout());
				infantilTela.show(clientePanel, "infantilTela");
			}
		});
		btnInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnInfantil.setBounds(152, 139, 270, 40);
		inicioclientePanel.add(btnInfantil);

		// Exibicao ficcao
		JButton btnFiccao = new JButton("Ficcao");
		btnFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraFiccao = (CardLayout) (clientePanel.getLayout());
				mostraFiccao.show(clientePanel, "ficcaoTela");
			}
		});
		btnFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFiccao.setBounds(152, 210, 270, 40);
		inicioclientePanel.add(btnFiccao);

		// Exibicao tencico
		JButton btnTecnico = new JButton("Tecnico");
		btnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraTecnico = (CardLayout) (clientePanel.getLayout());
				mostraTecnico.show(clientePanel, "tecnicoTela");
			}
		});
		btnTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnTecnico.setBounds(152, 278, 270, 40);
		inicioclientePanel.add(btnTecnico);

		// Exibicao outros
		JButton btnOutros = new JButton("Outros");
		btnOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraOutros = (CardLayout) (clientePanel.getLayout());
				mostraOutros.show(clientePanel, "outrosTela");
			}
		});
		btnOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnOutros.setBounds(152, 351, 270, 40);
		inicioclientePanel.add(btnOutros);

		// Exibição da Navegação do Cliente
		CardLayout navCliente = (CardLayout) (contenPane.getLayout());
		navCliente.show(contenPane, "navCliente");

		// Encontra o cliente
		numeroDoCliente = Servicos.procuraCliente(livraria, contenPane);

		// Panel: Infantil
		infantilPanel(contenPane, clientePanel, livraria, numeroDoCliente);

		// Panel Ficcao
		ficcaoPanel(contenPane, clientePanel, livraria, numeroDoCliente);

		// Panel tecnico
		tecnicoPanel(contenPane, clientePanel, livraria, numeroDoCliente);

		// Panel: Outros
		outrosPanel(contenPane, clientePanel, livraria, numeroDoCliente);

	}

	// Volta para um Panel
	public static JButton voltaCliente(JPanel clientePanel) {
		JButton voltaCliente = new JButton("Voltar");
		voltaCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		voltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (clientePanel.getLayout());
				inicio.show(clientePanel, "inicioclientePanel");
			}
		});
		voltaCliente.setBounds(10, 11, 89, 22);

		return voltaCliente;
	}

	// Panel infantil
	public static void infantilPanel(JPanel contentPane, JPanel clientePanel, Livraria livraria, int numeroDoCliente) {
		JPanel infantil = new JPanel();
		infantil.setBackground(new Color(204, 204, 102));
		clientePanel.add(infantil, "infantilTela");
		infantil.setLayout(null);
		infantil.add(voltaCliente(clientePanel));

		JLabel lblInfantil = new JLabel("Infantil\r\n");
		lblInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblInfantil.setBounds(213, 35, 147, 60);
		infantil.add(lblInfantil);

		Choice choiceInfantil = new Choice();
		choiceInfantil.setBounds(10, 121, 554, 20);
		infantil.add(choiceInfantil);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnComprar.setBounds(325, 157, 190, 25);
		infantil.add(btnComprar);
		btnComprar.setVisible(false);

		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicos.cadastraCompra(livraria, numeroDoCliente, choiceInfantil.getSelectedIndex());
			}
		});

		// Panel do resultado da busca
		JPanel panelPesquisaInfantil = new JPanel();
		panelPesquisaInfantil.setBackground(new Color(204, 204, 153));
		panelPesquisaInfantil.setBounds(10, 214, 554, 500);
		infantil.add(panelPesquisaInfantil);
		panelPesquisaInfantil.setLayout(null);

		// adiciona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getInfantil().size(); i++)
			choiceInfantil.add(livraria.getCatalogo().getInfantil().get(i).getTitulo());

		JButton btnPesquisaInfantil = new JButton("Pesquisar");
		btnPesquisaInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceInfantil.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {
					btnComprar.setVisible(true);
					panelPesquisaInfantil.removeAll();

					JLabel lblTitulo = new JLabel("Titulo: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getTitulo());
					lblTitulo.setBounds(10, 5, 534, 22);
					panelPesquisaInfantil.add(lblTitulo);
					lblTitulo.setForeground(Color.DARK_GRAY);

					JLabel lblIsbn = new JLabel("ISBN: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getIsbn());
					lblIsbn.setBounds(10, 62, 534, 22);
					panelPesquisaInfantil.add(lblIsbn);
					lblIsbn.setForeground(Color.DARK_GRAY);

					JLabel lblAutor = new JLabel("Autor: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getAutor());
					lblAutor.setBounds(10, 114, 534, 22);
					panelPesquisaInfantil.add(lblAutor);
					lblAutor.setForeground(Color.DARK_GRAY);

					JLabel lblEditora = new JLabel("Editora: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getEditora());
					lblEditora.setBounds(10, 166, 534, 22);
					panelPesquisaInfantil.add(lblEditora);
					lblEditora.setForeground(Color.DARK_GRAY);

					JLabel lblQuantidade = new JLabel("Quantidade: " + livraria.getCatalogo().getInfantil()
							.get(choiceInfantil.getSelectedIndex()).getQuantidade());
					lblQuantidade.setBounds(10, 214, 534, 22);
					panelPesquisaInfantil.add(lblQuantidade);
					lblQuantidade.setForeground(Color.DARK_GRAY);

					JLabel lblPreco = new JLabel("Preco: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getPreco());
					lblPreco.setBounds(10, 260, 534, 22);
					panelPesquisaInfantil.add(lblPreco);
					lblPreco.setForeground(Color.DARK_GRAY);
				}
			}
		});
		btnPesquisaInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaInfantil.setBounds(75, 157, 190, 25);
		infantil.add(btnPesquisaInfantil);
	}

	// Panel ficcao
	public static void ficcaoPanel(JPanel contentPane, JPanel clientePanel, Livraria livraria, int numeroDoCliente) {
		JPanel ficcao = new JPanel();
		ficcao.setBackground(new Color(204, 204, 102));
		clientePanel.add(ficcao, "ficcaoTela");
		ficcao.setLayout(null);
		ficcao.add(voltaCliente(clientePanel));

		JLabel lblFiccao = new JLabel("Ficcao");
		lblFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblFiccao.setBounds(223, 27, 127, 68);
		ficcao.add(lblFiccao);

		Choice choiceFiccao = new Choice();
		choiceFiccao.setBounds(10, 121, 554, 20);
		ficcao.add(choiceFiccao);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnComprar.setBounds(325, 157, 190, 25);
		ficcao.add(btnComprar);
		btnComprar.setVisible(false);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicos.cadastraCompra(livraria, numeroDoCliente, choiceFiccao.getSelectedIndex());
			}
		});

		JPanel panelPesquisaFiccao = new JPanel();
		panelPesquisaFiccao.setBackground(new Color(204, 204, 153));
		panelPesquisaFiccao.setBounds(10, 214, 554, 326);
		ficcao.add(panelPesquisaFiccao);
		panelPesquisaFiccao.setLayout(null);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getFiccao().size(); i++)
			choiceFiccao.add(livraria.getCatalogo().getFiccao().get(i).getTitulo());

		JButton btnPesquisaFiccao = new JButton("Pesquisar");
		btnPesquisaFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceFiccao.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {
					btnComprar.setVisible(true);
					panelPesquisaFiccao.removeAll();

					JLabel lblTitulo = new JLabel("Titulo: "
							+ livraria.getCatalogo().getFiccao().get(choiceFiccao.getSelectedIndex()).getTitulo());
					lblTitulo.setBounds(10, 25, 534, 22);
					panelPesquisaFiccao.add(lblTitulo);
					lblTitulo.setForeground(Color.DARK_GRAY);

					JLabel lblIsbn = new JLabel("ISBN: "
							+ livraria.getCatalogo().getFiccao().get(choiceFiccao.getSelectedIndex()).getIsbn());
					lblIsbn.setBounds(10, 82, 534, 22);
					panelPesquisaFiccao.add(lblIsbn);
					lblIsbn.setForeground(Color.DARK_GRAY);

					JLabel lblAutor = new JLabel("Autor: "
							+ livraria.getCatalogo().getFiccao().get(choiceFiccao.getSelectedIndex()).getAutor());
					lblAutor.setBounds(10, 134, 534, 22);
					panelPesquisaFiccao.add(lblAutor);
					lblAutor.setForeground(Color.DARK_GRAY);

					JLabel lblEditora = new JLabel("Editora: "
							+ livraria.getCatalogo().getFiccao().get(choiceFiccao.getSelectedIndex()).getEditora());
					lblEditora.setBounds(10, 186, 534, 22);
					panelPesquisaFiccao.add(lblEditora);
					lblEditora.setForeground(Color.DARK_GRAY);

					JLabel lblQuantidade = new JLabel("Quantidade: "
							+ livraria.getCatalogo().getFiccao().get(choiceFiccao.getSelectedIndex()).getQuantidade());
					lblQuantidade.setBounds(10, 234, 534, 22);
					panelPesquisaFiccao.add(lblQuantidade);
					lblQuantidade.setForeground(Color.DARK_GRAY);

					JLabel lblPreco = new JLabel("Preco: "
							+ livraria.getCatalogo().getFiccao().get(choiceFiccao.getSelectedIndex()).getPreco());
					lblPreco.setBounds(10, 280, 534, 22);
					panelPesquisaFiccao.add(lblPreco);
					lblPreco.setForeground(Color.DARK_GRAY);
				}

			}
		});
		btnPesquisaFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaFiccao.setBounds(75, 157, 190, 25);
		ficcao.add(btnPesquisaFiccao);

	}

	// Panel tecnico
	public static void tecnicoPanel(JPanel contentPane, JPanel clientePanel, Livraria livraria, int numeroDoCliente) {
		JPanel tecnico = new JPanel();
		tecnico.setBackground(new Color(204, 204, 102));
		clientePanel.add(tecnico, "tecnicoTela");
		tecnico.setLayout(null);
		tecnico.add(voltaCliente(clientePanel));

		JLabel lblTecnico = new JLabel("Tecnico");
		lblTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblTecnico.setBounds(213, 35, 147, 60);
		tecnico.add(lblTecnico);

		Choice choiceTecnico = new Choice();
		choiceTecnico.setBounds(10, 121, 554, 20);
		tecnico.add(choiceTecnico);

		JPanel panelPesquisaTecnico = new JPanel();
		panelPesquisaTecnico.setBackground(new Color(204, 204, 153));
		panelPesquisaTecnico.setBounds(10, 214, 554, 326);
		tecnico.add(panelPesquisaTecnico);
		panelPesquisaTecnico.setLayout(null);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getTecnico().size(); i++)
			choiceTecnico.add(livraria.getCatalogo().getTecnico().get(i).getTitulo());

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnComprar.setBounds(325, 157, 190, 25);
		tecnico.add(btnComprar);
		btnComprar.setVisible(false);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicos.cadastraCompra(livraria, numeroDoCliente, choiceTecnico.getSelectedIndex());
			}
		});

		JButton btnPesquisaTecnico = new JButton("Pesquisar");
		btnPesquisaTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceTecnico.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {
					btnComprar.setVisible(true);
					panelPesquisaTecnico.removeAll();

					JLabel lblTitulo = new JLabel("Titulo: "
							+ livraria.getCatalogo().getTecnico().get(choiceTecnico.getSelectedIndex()).getTitulo());
					lblTitulo.setBounds(10, 25, 534, 22);
					panelPesquisaTecnico.add(lblTitulo);
					lblTitulo.setForeground(Color.DARK_GRAY);

					JLabel lblIsbn = new JLabel("ISBN: "
							+ livraria.getCatalogo().getTecnico().get(choiceTecnico.getSelectedIndex()).getIsbn());
					lblIsbn.setBounds(10, 82, 534, 22);
					panelPesquisaTecnico.add(lblIsbn);
					lblIsbn.setForeground(Color.DARK_GRAY);

					JLabel lblAutor = new JLabel("Autor: "
							+ livraria.getCatalogo().getTecnico().get(choiceTecnico.getSelectedIndex()).getAutor());
					lblAutor.setBounds(10, 134, 534, 22);
					panelPesquisaTecnico.add(lblAutor);
					lblAutor.setForeground(Color.DARK_GRAY);

					JLabel lblEditora = new JLabel("Editora: "
							+ livraria.getCatalogo().getTecnico().get(choiceTecnico.getSelectedIndex()).getEditora());
					lblEditora.setBounds(10, 186, 534, 22);
					panelPesquisaTecnico.add(lblEditora);
					lblEditora.setForeground(Color.DARK_GRAY);

					JLabel lblQuantidade = new JLabel("Quantidade: " + livraria.getCatalogo().getTecnico()
							.get(choiceTecnico.getSelectedIndex()).getQuantidade());
					lblQuantidade.setBounds(10, 234, 534, 22);
					panelPesquisaTecnico.add(lblQuantidade);
					lblQuantidade.setForeground(Color.DARK_GRAY);

					JLabel lblPreco = new JLabel("Preco: "
							+ livraria.getCatalogo().getTecnico().get(choiceTecnico.getSelectedIndex()).getPreco());
					lblPreco.setBounds(10, 280, 534, 22);
					panelPesquisaTecnico.add(lblPreco);
					lblPreco.setForeground(Color.DARK_GRAY);

				}
			}
		});
		btnPesquisaTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaTecnico.setBounds(75, 157, 190, 25);
		tecnico.add(btnPesquisaTecnico);

	}

	// Panel outros
	public static void outrosPanel(JPanel contentPane, JPanel clientePanel, Livraria livraria, int numeroDoCliente) {
		JPanel outros = new JPanel();
		outros.setBackground(new Color(204, 204, 102));
		clientePanel.add(outros, "outrosTela");
		outros.setLayout(null);
		outros.add(voltaCliente(clientePanel));

		JLabel lblOutros = new JLabel("Outros");
		lblOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblOutros.setBounds(223, 35, 127, 60);
		outros.add(lblOutros);

		Choice choiceOutros = new Choice();
		choiceOutros.setBounds(10, 121, 554, 20);
		outros.add(choiceOutros);

		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnComprar.setBounds(325, 157, 190, 25);
		outros.add(btnComprar);
		btnComprar.setVisible(false);
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servicos.cadastraCompra(livraria, numeroDoCliente, choiceOutros.getSelectedIndex());
			}
		});

		JPanel panelPesquisaOutros = new JPanel();
		panelPesquisaOutros.setBackground(new Color(204, 204, 153));
		panelPesquisaOutros.setBounds(10, 214, 554, 326);
		outros.add(panelPesquisaOutros);
		panelPesquisaOutros.setLayout(null);

		// adiona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getOutros().size(); i++)
			choiceOutros.add(livraria.getCatalogo().getOutros().get(i).getTitulo());

		JButton btnPesquisaOutros = new JButton("Pesquisar");
		btnPesquisaOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceOutros.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {
					btnComprar.setVisible(true);
					panelPesquisaOutros.removeAll();

					JLabel lblTitulo = new JLabel("Titulo: "
							+ livraria.getCatalogo().getOutros().get(choiceOutros.getSelectedIndex()).getTitulo());
					lblTitulo.setBounds(10, 25, 534, 22);
					panelPesquisaOutros.add(lblTitulo);
					lblTitulo.setForeground(Color.DARK_GRAY);

					JLabel lblIsbn = new JLabel("ISBN: "
							+ livraria.getCatalogo().getOutros().get(choiceOutros.getSelectedIndex()).getIsbn());
					lblIsbn.setBounds(10, 82, 534, 22);
					panelPesquisaOutros.add(lblIsbn);
					lblIsbn.setForeground(Color.DARK_GRAY);

					JLabel lblAutor = new JLabel("Autor: "
							+ livraria.getCatalogo().getOutros().get(choiceOutros.getSelectedIndex()).getAutor());
					lblAutor.setBounds(10, 134, 534, 22);
					panelPesquisaOutros.add(lblAutor);
					lblAutor.setForeground(Color.DARK_GRAY);

					JLabel lblEditora = new JLabel("Editora: "
							+ livraria.getCatalogo().getOutros().get(choiceOutros.getSelectedIndex()).getEditora());
					lblEditora.setBounds(10, 186, 534, 22);
					panelPesquisaOutros.add(lblEditora);
					lblEditora.setForeground(Color.DARK_GRAY);

					JLabel lblQuantidade = new JLabel("Quantidade: "
							+ livraria.getCatalogo().getOutros().get(choiceOutros.getSelectedIndex()).getQuantidade());
					lblQuantidade.setBounds(10, 234, 534, 22);
					panelPesquisaOutros.add(lblQuantidade);
					lblQuantidade.setForeground(Color.DARK_GRAY);

					JLabel lblPreco = new JLabel("Preco: "
							+ livraria.getCatalogo().getOutros().get(choiceOutros.getSelectedIndex()).getPreco());
					lblPreco.setBounds(10, 280, 534, 22);
					panelPesquisaOutros.add(lblPreco);
					lblPreco.setForeground(Color.DARK_GRAY);

				}
			}
		});
		btnPesquisaOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaOutros.setBounds(75, 157, 190, 25);
		outros.add(btnPesquisaOutros);

	}
}
