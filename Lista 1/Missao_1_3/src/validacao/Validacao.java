package validacao;

import servicos.Servicos;

public class Validacao {
	public static boolean validaVoto(int voto) {
		
		switch (voto) {
		case 17:
			return true;
		case 13:
			return true;
		case 10:
			return true;
		case 11:
			return true;
		case 0:
			return false;
		default:
			Servicos.limpaTela();
			System.out.println("Entrada invalida! Tente novamente");
			return false;
		}
	}
	
	public static boolean validaRepeticao(int argumento) {
		return (argumento != 1 || argumento !=2)? true: false;
	}
	
}
