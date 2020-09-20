package procedimentos;

import leitura.Leitura;

public class Procedimentos {
	
	public static String criaFrase() {
		String frase;
		
		do {
			System.out.print("Digite a frase: ");
			frase =  Leitura.lerString();
			
			if (frase.length() == 0) {
				for (int i = 0; i < 50; i++)
					System.out.println();
				System.out.println("Digite algo. Tente novamente.");
			}	
		
		}while(frase.length() == 0);
		
		return frase;
	}
	
	public static int tamanhoDaFrase(String frase) {
		return frase.length();
	}
	
	public static int [] pegaVogais(String frase) {
		int [] quantidadeDeVogais = {0,0,0,0,0};
			
		for (int i = 0; i < frase.length(); i++) {
			switch (frase.toLowerCase().charAt(i)) {
			case 'a':
				quantidadeDeVogais[0]++;
				break;
			case 'e':
				quantidadeDeVogais[1]++;
				break;
			case 'i':
				quantidadeDeVogais[2]++;
				break;
			case 'o':
				quantidadeDeVogais[3]++;
				break;
			case 'u':
				quantidadeDeVogais[4]++;
				break;
			default:
				break;
			}
		}
		
		return quantidadeDeVogais;
	}		

	public static boolean continua() {
		int escolha = 0;
		
		do {
			System.out.println("\nDeseja analisar outra frase? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Nao");
			escolha = Leitura.lerInt(0);
		}while(!validaContinua(escolha));
		
		if (escolha == 1)
			for (int i = 0; i < 50; i++)
				System.out.println();
		else
			System.out.println("PROGRAMA FINALIZADO!");
		
		return (escolha == 1)? true: false;
	}
	
	public static boolean validaContinua(int continua) {
		return (continua != 1 || continua != 2)? true: false;
	}
}
