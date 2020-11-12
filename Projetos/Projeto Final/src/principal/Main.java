package principal;

import dados.Livraria;
import servicos.Servicos;

public class Main {
	public static void main(String[] args) {
		Livraria livraria = new Livraria();
		
		livraria.setClientes(Servicos.criaCliente("Fernando Almeidas", 1616, 1515));
		livraria.setClientes(Servicos.criaCliente("Augusto dos Anjos", 2354, 3652));
		livraria.setClientes(Servicos.criaCliente("Leonardo Albuquerque", 5630, 2541));
		livraria.setClientes(Servicos.criaCliente("Andrade", 3614, 3698));
		
		livraria.setCatalogoInfantil(Servicos.cadastraLivro("O Pequeno Principe", "3625", "Antonie de Saint",
				"Global",13.27, 0, 3));
		
		livraria.setCatalogoInfantil(Servicos.cadastraLivro("Alice no Pais das Maravilas ", "1515", "Lewis Carrol",
				"Lewis",56.17, 0, 3));
				
		livraria.setCatalogoInfantil(Servicos.cadastraLivro("Chapéuzinho Vermelho", "6348", "Charles Perrault",
				"LiteraturaBr",29.27,0, 3));
		
		livraria.getClientes().get(0).getCesta().setPendente(false);
		livraria.getClientes().get(1).getCesta().setPendente(false);
		livraria.getClientes().get(2).getCesta().setPendente(false);

		
		visual.Menu.criaMenu(livraria);
	}
}
