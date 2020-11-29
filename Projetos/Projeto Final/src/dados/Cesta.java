package dados;

import java.util.ArrayList;

/**
 * Cesta: cesta do cliente
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

public class Cesta {
	private ArrayList<Livro> itens;
	private String endereco;
	private double total;

	public Cesta() {
		this.itens = new ArrayList<Livro>();
		this.total = 0;
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
		this.total = this.total * desconto;
	}

	public double getTotal() {
		return total;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Limpa a Cesta depois de finalizado o Pedido
	 */
	public void limpaCesta() {
		itens.clear();
		this.total = 0;
		this.endereco = "";
	}
}
