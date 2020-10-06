package dados;

import java.util.ArrayList;

public class Supermercado {
	private ArrayList<Pessoa> clientes;
	
	public Supermercado() {
		clientes = new ArrayList<Pessoa>();
	}
	
	public ArrayList<Pessoa> getClientes() {
		return clientes;
	}

	public void setClientes(Pessoa cliente) {
		clientes.add(cliente);
	}
	
	public float mediaDeIdade(Supermercado mercado) {
		int media = 0;
		
		for (int i = 0; i < mercado.getClientes().size(); i++) {
			media += mercado.getClientes().get(i).getIdade();
		}
		
		return (float) media/(mercado.getClientes().size());
	}
	
	public float mediaIndiceSatisfacao(Supermercado mercado) {
		int media = 0;
		
		for (int i = 0; i < mercado.getClientes().size(); i++) {
			media += mercado.getClientes().get(i).getSatisfacao();
		}
		
		return (float) media/(mercado.getClientes().size());
	}

	public float mediaCinco(Supermercado mercado) {
		int quantidade = 0;
		
		for (int i = 0; i < mercado.getClientes().size(); i++) {
			quantidade += (mercado.getClientes().get(i).getSatisfacao() == 5)? 1:0;
		}
		return quantidade;
	}
	
	public float mediaDez(Supermercado mercado) {
		int quantidade = 0;
		
		for (int i = 0; i < mercado.getClientes().size(); i++) {
			quantidade += (mercado.getClientes().get(i).getSatisfacao() == 10)? 1:0;
		}
		return quantidade;
	}

	public float idadeMedia(Supermercado mercado) {
		float media;
		
		media =	(float) ((mercado.getClientes().size() % 2 == 0 )? 
				(mercado.getClientes().get(mercado.getClientes().size()/2).getIdade() + 
				mercado.getClientes().get((mercado.getClientes().size()/2 - 1)).getIdade())/2.0:
				mercado.getClientes().get(mercado.getClientes().size()/2).getIdade());
				
		return media;
	}
	
	public float indiceMenorQueSete(Supermercado mercado) {
		int quantidade = 0;
		
		for (int i = 0; i < mercado.getClientes().size(); i++) {
			quantidade += (mercado.getClientes().get(i).getSatisfacao() < 7)? 1:0;
		}
		
		return quantidade;
	}
}

