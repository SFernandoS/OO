package dados;

/**
 * dados das pessoas
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

public class Pessoa {
	private String nome;
	private String CPF;

	public Pessoa() {
	}

	public Pessoa(String nome, String CPF) {
		super();
		this.nome = nome;
		this.CPF = CPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
}
