package validacao;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacao {
	
	// Cliente
	public static boolean validaCPF(String cpf) {
		try {
			Integer.parseInt(cpf);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Apenas número!\n CPF invalido!");
			return false;
		}
		return true;
	}
	
	public static boolean validaCEP(String cep) {
		try {
			Integer.parseInt(cep);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Apenas número!\n CEP invalido!");
			return false;
		}
		return true;
	}
	
	public static boolean validaNome(String nome) {
		try {
			nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
			if(nome.length() < 3) {
				JOptionPane.showMessageDialog(null, "O nome tem que ser maior que 2 caracteres!");
				return false;
			}else 
				return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Os campos nao podem ficar vazio!");
			return false;
		}
	}
	
	//Livro
	public static boolean validaTitulo(String titulo) {
		titulo = Character.toUpperCase(titulo.charAt(0)) + titulo.substring(1);
		if(titulo.length() < 2) {
			JOptionPane.showMessageDialog(null, "O titulo tem que ser maior que 1 caracter!");
			return false;
		}else 
			return true;
	}
	
	public static boolean validaIsbn(String isbn) {
		isbn = Character.toUpperCase(isbn.charAt(0)) + isbn.substring(1);
		if(isbn.length() < 1) {
			JOptionPane.showMessageDialog(null, "O isbn tem que ser maior que 1 caracter!");
			return false;
		}else 
			return true;
	}
	
	public static boolean validaEditora(String editora) {
		editora = Character.toUpperCase(editora.charAt(0)) + editora.substring(1);
		if(editora.length() < 1) {
			JOptionPane.showMessageDialog(null, "A Editora tem que ser maior que 1 caracter!");
			return false;
		}else 
			return true;
	}
	
	public static boolean validaAutor(String autor) {
		autor = Character.toUpperCase(autor.charAt(0)) + autor.substring(1);
		if(autor.length() < 1) {
			JOptionPane.showMessageDialog(null, "O nome do autor tem que ser maior que 1 caracter!");
			return false;
		}else 
			return true;
	}
	
	public static boolean validaPreco(double preco) {
		if(preco < 0) {
			JOptionPane.showMessageDialog(null, "O preco tem que ser maior que 0!");
			return false;
		}
		else
			return true;
	}
	
	public static boolean validaQuantidade(int quantidade) {
		if(quantidade < 0) {
			JOptionPane.showMessageDialog(null, "A quantidade tem que ser maior que 0!");
			return false;
		}
		else
			return true;
	}
}
