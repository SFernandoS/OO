package dados;

import java.awt.Choice;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Catalogo: aqui ficam todos os livros
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */
public class Catalogo {
	private ArrayList<Livro> infantil;
	private ArrayList<Livro> tecnico;
	private ArrayList<Livro> ficcao;
	private ArrayList<Livro> outros;

	public Catalogo() {
		this.infantil = new ArrayList<Livro>();
		this.tecnico = new ArrayList<Livro>();
		this.ficcao = new ArrayList<Livro>();
		this.outros = new ArrayList<Livro>();
	}

	public ArrayList<Livro> getInfantil() {
		return infantil;
	}

	public void setInfantil(Livro novoLivroInfantil) {
		infantil.add(novoLivroInfantil);
	}

	public ArrayList<Livro> getTecnico() {
		return tecnico;
	}

	public void setTecnico(Livro novoLivroTecnico) {
		tecnico.add(novoLivroTecnico);
	}

	public ArrayList<Livro> getFiccao() {
		return ficcao;
	}

	public void setFiccao(Livro novoLivroFiccao) {
		ficcao.add(novoLivroFiccao);
	}

	public ArrayList<Livro> getOutros() {
		return outros;
	}

	public void setOutros(Livro novoLivroOutros) {
		outros.add(novoLivroOutros);
	}

	/**
	 * Mostra todos os livros cadastrados no Terminal, não está sendo instânciado no
	 * programa, mas acho legal ter caso queiramos visualizar os livros cadastrados
	 * de uma maneira fácil, facilitando a manutenção
	 */
	public void relacaoDeLivros() {

		System.out.println("Relacao de Livros: \n");

		System.out.println("Infantis: ");
		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros infantis");
		else
			for (int i = 0; i < infantil.size(); i++) {
				System.out.println("Titulo" + infantil.get(0).getTitulo() + ":");
				System.out.println("autor: " + infantil.get(0).getAutor() + ";");
				System.out.println("Editora: " + infantil.get(0).getEditora() + ";");
				System.out.println("ISNB: " + infantil.get(0).getIsbn() + ";");
				System.out.println("Preco: " + infantil.get(0).getPreco() + ".\n");
				System.out.println("------------------------------------------------------------------");
			}

		System.out.println("Tecnicos: ");

		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros tecnicos");
		else
			for (int i = 0; i < tecnico.size(); i++) {
				System.out.println("Titulo" + tecnico.get(0).getTitulo() + ":");
				System.out.println("autor: " + tecnico.get(0).getAutor() + ";");
				System.out.println("Editora: " + tecnico.get(0).getEditora() + ";");
				System.out.println("ISNB: " + tecnico.get(0).getIsbn() + ";");
				System.out.println("Preco: " + tecnico.get(0).getPreco() + ".\n");
				System.out.println("------------------------------------------------------------------");
			}

		System.out.println("Ficcao: ");

		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros de ficcao");
		else
			for (int i = 0; i < ficcao.size(); i++) {
				System.out.println("Titulo" + ficcao.get(0).getTitulo() + ":");
				System.out.println("autor: " + ficcao.get(0).getAutor() + ";");
				System.out.println("Editora: " + ficcao.get(0).getEditora() + ";");
				System.out.println("ISNB: " + ficcao.get(0).getIsbn() + ";");
				System.out.println("Preco: " + ficcao.get(0).getPreco() + ".\n");
				System.out.println("------------------------------------------------------------------");
			}

		System.out.println("Outros: ");

		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros outros livros");
		else
			for (int i = 0; i < outros.size(); i++) {
				System.out.println("Titulo" + outros.get(0).getTitulo() + ":");
				System.out.println("autor: " + outros.get(0).getAutor() + ";");
				System.out.println("Editora: " + outros.get(0).getEditora() + ";");
				System.out.println("ISNB: " + outros.get(0).getIsbn() + ";");
				System.out.println("Preco: " + outros.get(0).getPreco() + ".\n");
				System.out.println("------------------------------------------------------------------");
			}

		System.out.println("\nTotal de livros: " + (infantil.size() + tecnico.size() + ficcao.size() + outros.size()));
	}

	/**
	 * Printa os livros infantis no Panel
	 * 
	 * @param livraria
	 * @param escolha
	 * @param pesquisa
	 */
	public void relacaoDeLivrosInfantil(Livraria livraria, Choice escolha, JPanel pesquisa) {
		pesquisa.removeAll();

		JLabel lblTitulo = new JLabel(
				"Titulo: " + livraria.getCatalogo().getInfantil().get(escolha.getSelectedIndex()).getTitulo());
		lblTitulo.setBounds(10, 25, 534, 22);
		pesquisa.add(lblTitulo);
		lblTitulo.setForeground(Color.DARK_GRAY);

		JLabel lblIsbn = new JLabel(
				"ISBN: " + livraria.getCatalogo().getInfantil().get(escolha.getSelectedIndex()).getIsbn());
		lblIsbn.setBounds(10, 82, 534, 22);
		pesquisa.add(lblIsbn);
		lblIsbn.setForeground(Color.DARK_GRAY);

		JLabel lblAutor = new JLabel(
				"Autor: " + livraria.getCatalogo().getInfantil().get(escolha.getSelectedIndex()).getAutor());
		lblAutor.setBounds(10, 134, 534, 22);
		pesquisa.add(lblAutor);
		lblAutor.setForeground(Color.DARK_GRAY);

		JLabel lblEditora = new JLabel(
				"Editora: " + livraria.getCatalogo().getInfantil().get(escolha.getSelectedIndex()).getEditora());
		lblEditora.setBounds(10, 186, 534, 22);
		pesquisa.add(lblEditora);
		lblEditora.setForeground(Color.DARK_GRAY);

		JLabel lblQuantidade = new JLabel(
				"Quantidade: " + livraria.getCatalogo().getInfantil().get(escolha.getSelectedIndex()).getQuantidade());
		lblQuantidade.setBounds(10, 234, 534, 22);
		pesquisa.add(lblQuantidade);
		lblQuantidade.setForeground(Color.DARK_GRAY);

		JLabel lblPreco = new JLabel(
				"Preco: " + livraria.getCatalogo().getInfantil().get(escolha.getSelectedIndex()).getPreco());
		lblPreco.setBounds(10, 280, 534, 22);
		pesquisa.add(lblPreco);
		lblPreco.setForeground(Color.DARK_GRAY);
	}

	/**
	 * printa os livros de ficcao no Panel
	 * 
	 * @param livraria
	 * @param escolha
	 * @param pesquisa
	 */
	public void relacaoDeLivrosFiccao(Livraria livraria, Choice escolha, JPanel pesquisa) {
		pesquisa.removeAll();

		JLabel lblTitulo = new JLabel(
				"Titulo: " + livraria.getCatalogo().getFiccao().get(escolha.getSelectedIndex()).getTitulo());
		lblTitulo.setBounds(10, 25, 534, 22);
		pesquisa.add(lblTitulo);
		lblTitulo.setForeground(Color.DARK_GRAY);

		JLabel lblIsbn = new JLabel(
				"ISBN: " + livraria.getCatalogo().getFiccao().get(escolha.getSelectedIndex()).getIsbn());
		lblIsbn.setBounds(10, 82, 534, 22);
		pesquisa.add(lblIsbn);
		lblIsbn.setForeground(Color.DARK_GRAY);

		JLabel lblAutor = new JLabel(
				"Autor: " + livraria.getCatalogo().getFiccao().get(escolha.getSelectedIndex()).getAutor());
		lblAutor.setBounds(10, 134, 534, 22);
		pesquisa.add(lblAutor);
		lblAutor.setForeground(Color.DARK_GRAY);

		JLabel lblEditora = new JLabel(
				"Editora: " + livraria.getCatalogo().getFiccao().get(escolha.getSelectedIndex()).getEditora());
		lblEditora.setBounds(10, 186, 534, 22);
		pesquisa.add(lblEditora);
		lblEditora.setForeground(Color.DARK_GRAY);

		JLabel lblQuantidade = new JLabel(
				"Quantidade: " + livraria.getCatalogo().getFiccao().get(escolha.getSelectedIndex()).getQuantidade());
		lblQuantidade.setBounds(10, 234, 534, 22);
		pesquisa.add(lblQuantidade);
		lblQuantidade.setForeground(Color.DARK_GRAY);

		JLabel lblPreco = new JLabel(
				"Preco: " + livraria.getCatalogo().getFiccao().get(escolha.getSelectedIndex()).getPreco());
		lblPreco.setBounds(10, 280, 534, 22);
		pesquisa.add(lblPreco);
		lblPreco.setForeground(Color.DARK_GRAY);
	}

	/**
	 * printa os livros tecnicos no Panel
	 * 
	 * @param livraria
	 * @param escolha
	 * @param pesquisa
	 */
	public void relacaoDeLivrosTecnico(Livraria livraria, Choice escolha, JPanel pesquisa) {
		pesquisa.removeAll();

		JLabel lblTitulo = new JLabel(
				"Titulo: " + livraria.getCatalogo().getTecnico().get(escolha.getSelectedIndex()).getTitulo());
		lblTitulo.setBounds(10, 25, 534, 22);
		pesquisa.add(lblTitulo);
		lblTitulo.setForeground(Color.DARK_GRAY);

		JLabel lblIsbn = new JLabel(
				"ISBN: " + livraria.getCatalogo().getTecnico().get(escolha.getSelectedIndex()).getIsbn());
		lblIsbn.setBounds(10, 82, 534, 22);
		pesquisa.add(lblIsbn);
		lblIsbn.setForeground(Color.DARK_GRAY);

		JLabel lblAutor = new JLabel(
				"Autor: " + livraria.getCatalogo().getTecnico().get(escolha.getSelectedIndex()).getAutor());
		lblAutor.setBounds(10, 134, 534, 22);
		pesquisa.add(lblAutor);
		lblAutor.setForeground(Color.DARK_GRAY);

		JLabel lblEditora = new JLabel(
				"Editora: " + livraria.getCatalogo().getTecnico().get(escolha.getSelectedIndex()).getEditora());
		lblEditora.setBounds(10, 186, 534, 22);
		pesquisa.add(lblEditora);
		lblEditora.setForeground(Color.DARK_GRAY);

		JLabel lblQuantidade = new JLabel(
				"Quantidade: " + livraria.getCatalogo().getTecnico().get(escolha.getSelectedIndex()).getQuantidade());
		lblQuantidade.setBounds(10, 234, 534, 22);
		pesquisa.add(lblQuantidade);
		lblQuantidade.setForeground(Color.DARK_GRAY);

		JLabel lblPreco = new JLabel(
				"Preco: " + livraria.getCatalogo().getTecnico().get(escolha.getSelectedIndex()).getPreco());
		lblPreco.setBounds(10, 280, 534, 22);
		pesquisa.add(lblPreco);
		lblPreco.setForeground(Color.DARK_GRAY);
	}

	/**
	 * printa a categoria de livros "outros" no panel
	 * 
	 * @param livraria
	 * @param escolha
	 * @param pesquisa
	 */
	public void relacaoDeLivrosOutros(Livraria livraria, Choice escolha, JPanel pesquisa) {
		pesquisa.removeAll();

		JLabel lblTitulo = new JLabel(
				"Titulo: " + livraria.getCatalogo().getOutros().get(escolha.getSelectedIndex()).getTitulo());
		lblTitulo.setBounds(10, 25, 534, 22);
		pesquisa.add(lblTitulo);
		lblTitulo.setForeground(Color.DARK_GRAY);

		JLabel lblIsbn = new JLabel(
				"ISBN: " + livraria.getCatalogo().getOutros().get(escolha.getSelectedIndex()).getIsbn());
		lblIsbn.setBounds(10, 82, 534, 22);
		pesquisa.add(lblIsbn);
		lblIsbn.setForeground(Color.DARK_GRAY);

		JLabel lblAutor = new JLabel(
				"Autor: " + livraria.getCatalogo().getOutros().get(escolha.getSelectedIndex()).getAutor());
		lblAutor.setBounds(10, 134, 534, 22);
		pesquisa.add(lblAutor);
		lblAutor.setForeground(Color.DARK_GRAY);

		JLabel lblEditora = new JLabel(
				"Editora: " + livraria.getCatalogo().getOutros().get(escolha.getSelectedIndex()).getEditora());
		lblEditora.setBounds(10, 186, 534, 22);
		pesquisa.add(lblEditora);
		lblEditora.setForeground(Color.DARK_GRAY);

		JLabel lblQuantidade = new JLabel(
				"Quantidade: " + livraria.getCatalogo().getOutros().get(escolha.getSelectedIndex()).getQuantidade());
		lblQuantidade.setBounds(10, 234, 534, 22);
		pesquisa.add(lblQuantidade);
		lblQuantidade.setForeground(Color.DARK_GRAY);

		JLabel lblPreco = new JLabel(
				"Preco: " + livraria.getCatalogo().getOutros().get(escolha.getSelectedIndex()).getPreco());
		lblPreco.setBounds(10, 280, 534, 22);
		pesquisa.add(lblPreco);
		lblPreco.setForeground(Color.DARK_GRAY);
	}
}