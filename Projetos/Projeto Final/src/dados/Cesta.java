package dados;

import java.util.ArrayList;

public class Cesta {
	private ArrayList<Livro> itens;
	private String endereco;
	private double total;
	private boolean pendente;

	public Cesta() {
		this.itens = new ArrayList<Livro>();
		this.total = 0;
		this.setPendente(true);
	}

	public ArrayList<Livro> getItens() {
		return itens;
	}

	public void setItens(Livro novoItem) {
		itens.add(novoItem);
	}

	
	public void setTotal() {
		for (int i = 0; i < itens.size(); i++) 
			this.total += itens.get(i).getPreco();
	}
	
	public void setTotal(double desconto) {
		for (int i = 0; i < itens.size(); i++) 
		this.total += itens.get(i).getPreco();
		this.total = this.total*desconto;
	}
	
	public double getTotal() {
		return total;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isPendente() {
		return pendente;
	}

	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}
	
}

