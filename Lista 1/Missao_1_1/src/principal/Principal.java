package principal;

import leitura.Leitura;
import recursos.Metodos;
import saida.Saida;

public class Principal {

	public static void main(String[] args) {
		int number = 0;
		
		System.out.println("Digite o numero: ");
		number = Leitura.lerInt(number);
		
		System.out.println("\n\nO numero: "+ number + "\n");
		
		Saida.evenOrOdd(Metodos.evenOrOdd(number), Metodos.isNatural(number));
		Saida.divisibleThree(Metodos.divisibleThree(number));
		Saida.divisibleFive(Metodos.divisibleFive(number));
		Saida.isPrime(Metodos.isPrime(number, 2));
		Saida.isPerfect(Metodos.isPerfect(number, 1, 0), Metodos.isNatural(number));
		
	}
}
