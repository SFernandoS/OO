package principal;

import dados.*;

public class Main {

	public static void main(String[] args) {
		
		Livraria livraria = new Livraria();
		Cliente cliente = new Cliente("Eduardo", 7, 8, 9.3);
		livraria.setClientes(cliente);
		
		livraria.relacaoDeLivros();
		
	}
}
