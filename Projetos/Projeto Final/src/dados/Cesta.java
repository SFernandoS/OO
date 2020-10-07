package dados;

import java.util.ArrayList;

public class Cesta {
	private ArrayList<Livro> itens;
	private double desconto;

	public Cesta() {
		this.itens = new ArrayList<Livro>();
		this.desconto = 0F;
	}

	public ArrayList<Livro> getItens() {
		return itens;
	}

	public void setItens(Livro novoItem) {
		itens.add(novoItem);
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getTotal() {
		double auxiliar = 0;
		
		for (int i = 0; i < itens.size(); i++) 
			auxiliar += itens.get(i).getPreco();
		
		return auxiliar;
	}
	
	public double getTotal(float desconto) {
		double auxiliar = 0;
		
		for (int i = 0; i < itens.size(); i++) 
			auxiliar += itens.get(i).getPreco();
		
		return auxiliar - desconto;
	}
	
	public void listaDeCompras() {
		System.out.println("Lista de Compras\n");
		for (int i = 0; i < itens.size(); i++) {
			System.out.println("\t\t" + itens.get(0).getTitulo()+":");
			System.out.println("autor: " + itens.get(0).getAutor()+";");
			System.out.println("Editora: " + itens.get(0).getEditora()+";");
			System.out.println("ISNB: " + itens.get(0).getIsbn()+";");
			System.out.println("Preco: " + itens.get(0).getPreco()+ ".\n");
		}
	}
	
}

