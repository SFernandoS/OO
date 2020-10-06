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
	
}