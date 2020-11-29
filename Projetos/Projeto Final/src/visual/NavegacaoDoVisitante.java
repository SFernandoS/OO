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
 * Navegação do visistante, funciona quase igual a Navegação do cliente, mas ser
 * apenas para visualização
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

@SuppressWarnings("serial")
public class NavegacaoDoVisitante extends JPanel {

	/**
	 * É um submenu que serve para a navegação de livros por gênero, ou seja, opções
	 * de gênero, mas só serve para a navegação
	 * 
	 * @param contenPane
	 * @param livraria
	 */
	public static void criaNavegacaoDoVisitante(JPanel contenPane, Livraria livraria) {

		JPanel visitantePanel = new JPanel();
		contenPane.add(visitantePanel, "navVisitante");
		visitantePanel.setLayout(null);
		visitantePanel.setLayout(new CardLayout(0, 0));

		// Inicio: (menu)
		JPanel inicioVisitantePanel = new JPanel();
		inicioVisitantePanel.setBackground(new Color(204, 204, 102));
		visitantePanel.add(inicioVisitantePanel, "inicioVisitantePanel");
		inicioVisitantePanel.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		inicioVisitantePanel.add(btnVoltar);

		JLabel tituloVistante = new JLabel("Catálogo\r\n");
		tituloVistante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloVistante.setBounds(210, 46, 154, 43);
		inicioVisitantePanel.add(tituloVistante);

		// Exibicao infantil
		JButton btnInfantil = new JButton("Infantil");
		btnInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout infantilTela = (CardLayout) (visitantePanel.getLayout());
				infantilTela.show(visitantePanel, "infantilTela");
			}
		});
		btnInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnInfantil.setBounds(152, 139, 270, 40);
		inicioVisitantePanel.add(btnInfantil);

		// Exibicao ficcao
		JButton btnFiccao = new JButton("Ficcao");
		btnFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraFiccao = (CardLayout) (visitantePanel.getLayout());
				mostraFiccao.show(visitantePanel, "ficcaoTela");
			}
		});
		btnFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFiccao.setBounds(152, 210, 270, 40);
		inicioVisitantePanel.add(btnFiccao);

		// Exibicao tencico
		JButton btnTecnico = new JButton("Tecnico");
		btnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraTecnico = (CardLayout) (visitantePanel.getLayout());
				mostraTecnico.show(visitantePanel, "tecnicoTela");
			}
		});
		btnTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnTecnico.setBounds(152, 278, 270, 40);
		inicioVisitantePanel.add(btnTecnico);

		// Exibicao outros
		JButton btnOutros = new JButton("Outros");
		btnOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraOutros = (CardLayout) (visitantePanel.getLayout());
				mostraOutros.show(visitantePanel, "outrosTela");
			}
		});
		btnOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnOutros.setBounds(152, 351, 270, 40);
		inicioVisitantePanel.add(btnOutros);

		// Panel: Infantil
		infantilPanel(contenPane, visitantePanel, livraria);

		// Panel Ficcao
		ficcaoPanel(contenPane, visitantePanel, livraria);

		// Panel tecnico
		tecnicoPanel(contenPane, visitantePanel, livraria);

		// Panel: Outros
		outrosPanel(contenPane, visitantePanel, livraria);

		// Exibição da Navegação do Visitante
		CardLayout navVisitante = (CardLayout) (contenPane.getLayout());
		navVisitante.show(contenPane, "navVisitante");
	}

	// Volta para um Panel
	/**
	 * Método que cria um botão no Panel para voltar para o Panel de Inicio do
	 * Visitante
	 * 
	 * @param visitantePanel
	 * @return
	 */
	public static JButton voltaVisitante(JPanel visitantePanel) {
		JButton btnvoltaVisitante = new JButton("Voltar");
		btnvoltaVisitante.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnvoltaVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (visitantePanel.getLayout());
				inicio.show(visitantePanel, "inicioVisitantePanel");
			}
		});
		btnvoltaVisitante.setBounds(10, 11, 89, 22);

		return btnvoltaVisitante;
	}

	// Panel infantil
	/**
	 * Panel que serve para pesquisar e mostrar os livros infantis Tem um botão para
	 * ir Cadastrar o Cliente
	 * 
	 * @param contentPane
	 * @param visitantePanel
	 * @param livraria
	 */
	public static void infantilPanel(JPanel contentPane, JPanel visitantePanel, Livraria livraria) {
		JPanel infantil = new JPanel();
		infantil.setBackground(new Color(204, 204, 102));
		visitantePanel.add(infantil, "infantilTela");
		infantil.setLayout(null);
		infantil.add(voltaVisitante(visitantePanel));

		JLabel lblInfantil = new JLabel("Infantil\r\n");
		lblInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblInfantil.setBounds(213, 35, 147, 60);
		infantil.add(lblInfantil);

		Choice choiceInfantil = new Choice();
		choiceInfantil.setBounds(10, 121, 554, 20);
		infantil.add(choiceInfantil);

		// adiciona os nomes do titulo em choice
		for (int i = 0; i < livraria.getCatalogo().getInfantil().size(); i++)
			choiceInfantil.add(livraria.getCatalogo().getInfantil().get(i).getTitulo());

		// Panel do resultado da busca

		JPanel panelPesquisaInfantil = new JPanel();
		panelPesquisaInfantil.setBackground(new Color(204, 204, 153));
		panelPesquisaInfantil.setBounds(10, 214, 554, 326);
		infantil.add(panelPesquisaInfantil);
		panelPesquisaInfantil.setLayout(null);

		JButton btnPesquisaInfantil = new JButton("Pesquisar");
		btnPesquisaInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceInfantil.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {

					panelPesquisaInfantil.removeAll();

					JLabel lblTitulo = new JLabel("Titulo: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getTitulo());
					lblTitulo.setBounds(10, 25, 534, 22);
					panelPesquisaInfantil.add(lblTitulo);
					lblTitulo.setForeground(Color.DARK_GRAY);

					JLabel lblIsbn = new JLabel("ISBN: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getIsbn());
					lblIsbn.setBounds(10, 82, 534, 22);
					panelPesquisaInfantil.add(lblIsbn);
					lblIsbn.setForeground(Color.DARK_GRAY);

					JLabel lblAutor = new JLabel("Autor: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getAutor());
					lblAutor.setBounds(10, 134, 534, 22);
					panelPesquisaInfantil.add(lblAutor);
					lblAutor.setForeground(Color.DARK_GRAY);

					JLabel lblEditora = new JLabel("Editora: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getEditora());
					lblEditora.setBounds(10, 186, 534, 22);
					panelPesquisaInfantil.add(lblEditora);
					lblEditora.setForeground(Color.DARK_GRAY);

					JLabel lblQuantidade = new JLabel("Quantidade: " + livraria.getCatalogo().getInfantil()
							.get(choiceInfantil.getSelectedIndex()).getQuantidade());
					lblQuantidade.setBounds(10, 234, 534, 22);
					panelPesquisaInfantil.add(lblQuantidade);
					lblQuantidade.setForeground(Color.DARK_GRAY);

					JLabel lblPreco = new JLabel("Preco: "
							+ livraria.getCatalogo().getInfantil().get(choiceInfantil.getSelectedIndex()).getPreco());
					lblPreco.setBounds(10, 280, 534, 22);
					panelPesquisaInfantil.add(lblPreco);
					lblPreco.setForeground(Color.DARK_GRAY);
				}
			}
		});
		btnPesquisaInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaInfantil.setBounds(75, 157, 190, 25);
		infantil.add(btnPesquisaInfantil);

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDoCliente.cadastroDoCliente(contentPane, livraria);
			}
		});
		btnCadastrarCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnCadastrarCliente.setBounds(325, 157, 190, 25);
		infantil.add(btnCadastrarCliente);

	}

	// Panel ficcao
	/**
	 * Panel que serve para pesquisar e mostrar os livros de ficcao Tem um botão
	 * para ir Cadastrar o Cliente
	 * 
	 * @param contentPane
	 * @param visitantePanel
	 * @param livraria
	 */
	public static void ficcaoPanel(JPanel contentPane, JPanel visitantePanel, Livraria livraria) {
		JPanel ficcao = new JPanel();
		ficcao.setBackground(new Color(204, 204, 102));
		visitantePanel.add(ficcao, "ficcaoTela");
		ficcao.setLayout(null);
		ficcao.add(voltaVisitante(visitantePanel));

		JLabel lblFiccao = new JLabel("Ficcao");
		lblFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblFiccao.setBounds(223, 27, 127, 68);
		ficcao.add(lblFiccao);

		Choice choiceFiccao = new Choice();
		choiceFiccao.setBounds(10, 121, 554, 20);
		ficcao.add(choiceFiccao);

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

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDoCliente.cadastroDoCliente(contentPane, livraria);
			}
		});
		btnCadastrarCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnCadastrarCliente.setBounds(325, 157, 190, 25);
		ficcao.add(btnCadastrarCliente);
	}

	// Panel tecnico
	/**
	 * Panel que serve para pesquisar e mostrar os livros tecnicos Tem um botão para
	 * ir Cadastrar o Cliente
	 * 
	 * @param contentPane
	 * @param visitantePanel
	 * @param livraria
	 */
	public static void tecnicoPanel(JPanel contentPane, JPanel visitantePanel, Livraria livraria) {
		JPanel tecnico = new JPanel();
		tecnico.setBackground(new Color(204, 204, 102));
		visitantePanel.add(tecnico, "tecnicoTela");
		tecnico.setLayout(null);
		tecnico.add(voltaVisitante(visitantePanel));

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

		JButton btnPesquisaTecnico = new JButton("Pesquisar");
		btnPesquisaTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceTecnico.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(null, "Nao há livros cadastrados!");
				else {
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

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDoCliente.cadastroDoCliente(contentPane, livraria);
			}
		});
		btnCadastrarCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnCadastrarCliente.setBounds(325, 157, 190, 25);
		tecnico.add(btnCadastrarCliente);

	}

	// Panel outros
	/**
	 * Panel que serve para pesquisar e mostrar os livros "outros" Tem um botão para
	 * ir Cadastrar o Cliente
	 * 
	 * @param contentPane
	 * @param visitantePanel
	 * @param livraria
	 */
	public static void outrosPanel(JPanel contentPane, JPanel visitantePanel, Livraria livraria) {
		JPanel outros = new JPanel();
		outros.setBackground(new Color(204, 204, 102));
		visitantePanel.add(outros, "outrosTela");
		outros.setLayout(null);
		outros.add(voltaVisitante(visitantePanel));

		JLabel lblOutros = new JLabel("Outros");
		lblOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblOutros.setBounds(223, 35, 127, 60);
		outros.add(lblOutros);

		Choice choiceOutros = new Choice();
		choiceOutros.setBounds(10, 121, 554, 20);
		outros.add(choiceOutros);

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

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDoCliente.cadastroDoCliente(contentPane, livraria);
			}
		});
		btnCadastrarCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnCadastrarCliente.setBounds(325, 157, 190, 25);
		outros.add(btnCadastrarCliente);
	}
}
