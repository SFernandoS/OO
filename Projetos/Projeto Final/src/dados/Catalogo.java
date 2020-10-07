package dados;

import java.util.ArrayList;

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
	
	public void relacaoDeLivros() {
		
		System.out.println("Relacao de Livros: \n");
		
		System.out.println("Infantis: ");
		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros infantis");
		else
			for (int i = 0; i < infantil.size(); i++) {
				System.out.println("Titulo" + infantil.get(0).getTitulo()+":");
				System.out.println("autor: " + infantil.get(0).getAutor()+";");
				System.out.println("Editora: " + infantil.get(0).getEditora()+";");
				System.out.println("ISNB: " + infantil.get(0).getIsbn()+";");
				System.out.println("Preco: " + infantil.get(0).getPreco()+ ".\n");
				System.out.println("------------------------------------------------------------------");
			}
		
		System.out.println("Tecnicos: ");
		
		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros tecnicos");
		else
			for (int i = 0; i < tecnico.size(); i++) {
				System.out.println("Titulo" + tecnico.get(0).getTitulo()+":");
				System.out.println("autor: " + tecnico.get(0).getAutor()+";");
				System.out.println("Editora: " + tecnico.get(0).getEditora()+";");
				System.out.println("ISNB: " + tecnico.get(0).getIsbn()+";");
				System.out.println("Preco: " + tecnico.get(0).getPreco()+ ".\n");
				System.out.println("------------------------------------------------------------------");
			}

		System.out.println("Ficcao: ");
		
		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros de ficcao");
		else
			for (int i = 0; i < ficcao.size(); i++) {
				System.out.println("Titulo" + ficcao.get(0).getTitulo()+":");
				System.out.println("autor: " + ficcao.get(0).getAutor()+";");
				System.out.println("Editora: " + ficcao.get(0).getEditora()+";");
				System.out.println("ISNB: " + ficcao.get(0).getIsbn()+";");
				System.out.println("Preco: " + ficcao.get(0).getPreco()+ ".\n");
				System.out.println("------------------------------------------------------------------");
			}
			
		System.out.println("Outros: ");
		
		if (infantil.size() == 0)
			System.out.println("Ainda nao ha livros outros livros");
		else
			for (int i = 0; i < outros.size(); i++) {
				System.out.println("Titulo" + outros.get(0).getTitulo()+":");
				System.out.println("autor: " + outros.get(0).getAutor()+";");
				System.out.println("Editora: " + outros.get(0).getEditora()+";");
				System.out.println("ISNB: " + outros.get(0).getIsbn()+";");
				System.out.println("Preco: " + outros.get(0).getPreco()+ ".\n");
				System.out.println("------------------------------------------------------------------");
			}
		
		System.out.println("\nTotal de livros: " + (infantil.size() + tecnico.size() + ficcao.size() + outros.size()));
	}
}