package validacao;

import javax.swing.JOptionPane;

import dados.Livraria;

/**
 * Serve para validar os dados de entrada do usuário
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

public class Validacao {

	// Cliente
	/**
	 * Verifica se o CPF é válido 1 - se tem 11 dígitos 2 - se contém só números
	 * 
	 * @param cpf
	 * @param livraria
	 * @return boolean
	 */
	public static boolean validaCPF(String cpf, Livraria livraria) {
		try {
			if (cpf.length() != 11) {
				JOptionPane.showMessageDialog(null, "O CPF tem que ter 11 digitos!");
				return false;
			}

			for (int i = 0; i < livraria.getClientes().size(); i++) {
				if (cpf.equals(livraria.getClientes().get(i).getCPF())) {
					JOptionPane.showMessageDialog(null, "O CPF já existe!");
					return false;
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Apenas número!\n CPF invalido!");
			return false;
		}
		return true;
	}

	/**
	 * Verifica se o CEP é válido 1 - se contém apenas números 2 - se tem 8 dígitos
	 * 
	 * @param cep
	 * @param livraria
	 * @return boolean
	 */
	public static boolean validaCEP(String cep, Livraria livraria) {
		try {
			if (cep.length() != 8) {
				JOptionPane.showMessageDialog(null, "O CEP tem que ter 8 digitos!");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Apenas número!\n CEP invalido!");
			return false;
		}
		return true;
	}

	/**
	 * Verifica se o nome é válido 1 - maior que 2 caracteres 2 - se o campo está
	 * vazio 3 - se o nome existe
	 * 
	 * @param nome
	 * @param livraria
	 * @return boolean
	 */
	public static boolean validaNome(String nome, Livraria livraria) {
		try {
			nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
			for (int i = 0; i < livraria.getClientes().size(); i++) {
				if (nome.equals(livraria.getClientes().get(i).getNome())) {
					JOptionPane.showMessageDialog(null, "O nome já existe. Tente novamente!");
					return false;
				}
			}
			if (nome.length() < 3) {
				JOptionPane.showMessageDialog(null, "O nome tem que ser maior que 2 caracteres!");
				return false;
			} else
				return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Os campos nao podem ficar vazio!");
			return false;
		}
	}

	// Livro
	/**
	 * Verifica se o título pe válido 1 - Verifica se o título existe
	 * 
	 * @param titulo
	 * @param livraria
	 * @return boolean
	 */
	public static boolean validaTitulo(String titulo, Livraria livraria) {

		titulo = Character.toUpperCase(titulo.charAt(0)) + titulo.substring(1);

		for (int i = 0; i < livraria.getCatalogo().getInfantil().size(); i++) {
			if (titulo.equals(livraria.getCatalogo().getInfantil().get(i).getTitulo())) {
				JOptionPane.showMessageDialog(null, "Este título já existe!");
				return false;
			}
		}

		for (int i = 0; i < livraria.getCatalogo().getFiccao().size(); i++) {
			if (titulo.equals(livraria.getCatalogo().getFiccao().get(i).getTitulo())) {
				JOptionPane.showMessageDialog(null, "Este título já existe!");
				return false;
			}
		}

		for (int i = 0; i < livraria.getCatalogo().getTecnico().size(); i++) {
			if (titulo.equals(livraria.getCatalogo().getTecnico().get(i).getTitulo())) {
				JOptionPane.showMessageDialog(null, "Este título já existe!");
				return false;
			}
		}

		for (int i = 0; i < livraria.getCatalogo().getOutros().size(); i++) {
			if (titulo.equals(livraria.getCatalogo().getOutros().get(i).getTitulo())) {
				JOptionPane.showMessageDialog(null, "Este título já existe!");
				return false;
			}
		}
		if (titulo.length() < 2) {
			JOptionPane.showMessageDialog(null, "O titulo tem que ser maior que 1 caracter!");
			return false;
		} else
			return true;
	}

	/**
	 * Verifica se o ISBN é válido
	 * 
	 * @param isbn
	 * @param livraria
	 * @return boolean
	 */
	public static boolean validaIsbn(String isbn, Livraria livraria) {
		isbn = Character.toUpperCase(isbn.charAt(0)) + isbn.substring(1);

		for (int i = 0; i < livraria.getCatalogo().getInfantil().size(); i++) {
			if (isbn.equals(livraria.getCatalogo().getInfantil().get(i).getIsbn())) {
				JOptionPane.showMessageDialog(null, "O isbn já existe");
				return false;
			}
		}

		for (int i = 0; i < livraria.getCatalogo().getFiccao().size(); i++) {
			if (isbn.equals(livraria.getCatalogo().getFiccao().get(i).getIsbn())) {
				JOptionPane.showMessageDialog(null, "O isbn já existe");
				return false;
			}
		}

		for (int i = 0; i < livraria.getCatalogo().getTecnico().size(); i++) {
			if (isbn.equals(livraria.getCatalogo().getTecnico().get(i).getIsbn())) {
				JOptionPane.showMessageDialog(null, "O isbn já existe");
				return false;
			}
		}

		for (int i = 0; i < livraria.getCatalogo().getOutros().size(); i++) {
			if (isbn.equals(livraria.getCatalogo().getOutros().get(i).getIsbn())) {
				JOptionPane.showMessageDialog(null, "O isbn já existe");
				return false;
			}
		}

		if (isbn.length() < 1) {
			JOptionPane.showMessageDialog(null, "O isbn tem que ser maior que 1 caracter!");
			return false;
		} else
			return true;
	}

	/**
	 * Verifica se a editora é válida
	 * 
	 * @param editora
	 * @return boolean
	 */
	public static boolean validaEditora(String editora) {
		editora = Character.toUpperCase(editora.charAt(0)) + editora.substring(1);
		if (editora.length() < 1) {
			JOptionPane.showMessageDialog(null, "A Editora tem que ser maior que 1 caracter!");
			return false;
		} else
			return true;
	}

	/**
	 * Verifica se o Autor é válido
	 * 
	 * @param autor
	 * @return boolean
	 */
	public static boolean validaAutor(String autor) {
		autor = Character.toUpperCase(autor.charAt(0)) + autor.substring(1);
		if (autor.length() < 1) {
			JOptionPane.showMessageDialog(null, "O nome do autor tem que ser maior que 1 caracter!");
			return false;
		} else
			return true;
	}

	/**
	 * Verifica se o preco é válido
	 * 
	 * @param preco
	 * @return boolean
	 */
	public static boolean validaPreco(double preco) {
		if (preco < 0) {
			JOptionPane.showMessageDialog(null, "O preco tem que ser maior que 0!");
			return false;
		} else
			return true;
	}

	/**
	 * verifica se a quantidade é válida
	 * 
	 * @param quantidade
	 * @return
	 */
	public static boolean validaQuantidade(int quantidade) {
		if (quantidade < 0) {
			JOptionPane.showMessageDialog(null, "A quantidade tem que ser maior que 0!");
			return false;
		} else
			return true;
	}

	public static boolean validaEndereco(String endereco) {
		if (endereco.length() < 1) {
			JOptionPane.showMessageDialog(null, "O endereco nao pode ficar vazio!");
			return false;
		} else
			return true;
	}
}
