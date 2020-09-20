package validacao;

public class Validacao {
	public static boolean validaIdade(int idade) {
		if (idade < 0) {
			System.out.println("Entrada invalida! Tente novamente.");
			return false;
		}
		else
			return true;
	}
	
	public static boolean validaSatisfacao (int satisfacao) {
		if (satisfacao < 5 || satisfacao > 10) {
			System.out.println("Entrada invalida! Tente novamente.");
			return false;
		}
		else
			return true;
	}
}
