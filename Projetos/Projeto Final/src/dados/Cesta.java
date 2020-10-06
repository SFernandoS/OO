package dados;

import java.util.ArrayList;

public class Cesta {
	private ArrayList<Livro> itens;
	private float desconto;
	private float total;

	public Cesta() {
		this.itens = new ArrayList<Livro>();
		this.desconto = 0F;
		this.total = 0f;
	}

	public ArrayList<Livro> getItens() {
		return itens;
	}

	public void setItens(Livro novoItem) {
		itens.add(novoItem);
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
}

