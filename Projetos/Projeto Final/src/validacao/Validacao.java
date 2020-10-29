package validacao;

public class Validacao {
	public static boolean validaCPF(String cpf) {
		try {
			Integer.parseInt(cpf);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean validaCEP(String cep) {
		try {
			Integer.parseInt(cep);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean validaNome(String nome) {
		nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
		return (nome.length() < 2) ? false : true;
	}
}
