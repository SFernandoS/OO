package dados;

import java.util.ArrayList;


public class Funcionario extends Pessoa{
	private ArrayList<Cesta> vendas;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String CPF) {
		super(nome, CPF);
		vendas = new ArrayList<Cesta>();
	}
	
	public ArrayList<Cesta> getVendas() {
		return vendas;
	}

	public void setVendas(Cesta novoPedido) {
		vendas.add(novoPedido);
	}
}
