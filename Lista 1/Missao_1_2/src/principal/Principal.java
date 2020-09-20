package principal;

import dados.Supermercado;
import saida.Saida;
import servicos.Servicos;

public class Principal {

	public static void main(String[] args) {

		Supermercado mercado = Servicos.criaSupermercado();

		Servicos.criaCliente(mercado);
		
		Saida.imprimeResultados(mercado);
	}
}
