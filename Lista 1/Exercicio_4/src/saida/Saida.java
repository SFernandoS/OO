package saida;

public class Saida {
	public static void imprimeQuantidadeDeVogais(int quantidade) {
		System.out.println("\nTamanho da frase digitada: " + quantidade + " caracteres\n");		
	}
	
	public static void imprimeVogais(int [] vogaisQuantidade) {
		char[] vogais = {'a','e','i','o','u'};
		int totalDevogais = 0;
		
		System.out.println("Quantidade de vogais:");
		for (int i = 0; i < vogaisQuantidade.length; i++) {
			System.out.println(vogais[i] + " ------ " + vogaisQuantidade[i]);
			totalDevogais += vogaisQuantidade[i];
		}
		
		System.out.println("\nTotal de vogais: " + totalDevogais);
	}
}
