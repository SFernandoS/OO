package dados;

import java.util.ArrayList;


public class Funcionario extends Pessoa{
	private ArrayList<Pedidos> vendas;

	public Funcionario() {
		super();
		this.vendas = new ArrayList<Pedidos>();
	}

	public Funcionario(String nome, String CPF) {
		super(nome, CPF);
	}
	
	public ArrayList<Pedidos> getVendas() {
		return vendas;
	}

	public void setVendas(Pedidos novaVenda) {
		vendas.add(novaVenda);
	}
}
