package principal;

import procedimentos.Procedimentos;
import saida.Saida;

public class principal {

	public static void main(String[] args) {
		
		do {
			String frase = Procedimentos.criaFrase();		
			Saida.imprimeQuantidadeDeVogais(Procedimentos.tamanhoDaFrase(frase));
			Saida.imprimeVogais(Procedimentos.pegaVogais(frase));
		}while(Procedimentos.continua());
	}
}
