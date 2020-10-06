package dados;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
	private ArrayList<Pedido> vendas;

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, int CPF) {
		super(nome, CPF);
		vendas = new ArrayList<Pedido>();
	}
	
	public ArrayList<Pedido> getVendas() {
		return vendas;
	}

	public void setVendas(Pedido novoPedido) {
		vendas.add(novoPedido);
	}
}
