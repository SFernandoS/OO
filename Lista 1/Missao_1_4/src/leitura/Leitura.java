package leitura;

import java.util.Scanner;

public class Leitura {

	public static String lerString() {
		Scanner ler = new Scanner(System.in);
		return ler.nextLine();
	}
	
	public static int lerInt(int argumento) {
		try {
			Scanner ler = new Scanner(System.in);
			argumento = ler.nextInt();
		}catch(java.util.InputMismatchException exception) {
			System.out.println("Valor invalido! Tente novamente.");
			argumento = lerInt(argumento);
		}
		return argumento;
	}
}
