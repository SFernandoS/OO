package principal;

/**
 * cabeça do programa
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */
import dados.Livraria;
import servicos.Servicos;

public class Main {
	/**
	 * Main: instância da livraria e inicia o Menu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Livraria livraria = new Livraria();

		Servicos.verificaPedidosExpirados(livraria);

		livraria.setClientes(Servicos.criaCliente("Fernando almeidas", "1616", "1515"));
		livraria.setClientes(Servicos.criaCliente("Augusto dos anjos", "2354", "3652"));
		livraria.setClientes(Servicos.criaCliente("Leonardo albuquerque", "5630", "2541"));
		livraria.setClientes(Servicos.criaCliente("Andrade", "3614", "3698"));

		livraria.setCatalogoInfantil(
				Servicos.cadastraLivro("O Pequeno Principe", "3625", "Antonie de Saint", "Global", 13.27, 1, 3));

		livraria.setCatalogoInfantil(
				Servicos.cadastraLivro("Alice no Pais das Maravilas ", "1515", "Lewis Carrol", "Lewis", 56.17, 2, 3));

		livraria.setCatalogoTecnico(
				Servicos.cadastraLivro("O Pequeno Principe", "3625", "Antonie de Saint", "Global", 13.27, 3, 3));

		livraria.setCatalogoTecnico(
				Servicos.cadastraLivro("Alice no Pais das Maravilas ", "1515", "Lewis Carrol", "Lewis", 56.17, 0, 3));

		livraria.setCatalogoFiccao(
				Servicos.cadastraLivro("O Pequeno Principe", "3625", "Antonie de Saint", "Global", 13.27, 0, 3));

		livraria.setCatalogoFiccao(
				Servicos.cadastraLivro("Alice no Pais das Maravilas ", "1515", "Lewis Carrol", "Lewis", 56.17, 0, 3));

		livraria.setCatalogoOutros(Servicos.cadastraLivro("Chapéuzinho Vermelho", "6348", "Charles Perrault",
				"LiteraturaBr", 29.27, 0, 3));

		visual.Menu.criaMenu(livraria);
	}
}
