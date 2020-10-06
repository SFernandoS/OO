package dados;

public class Pessoa {
	private String nome;
	private int CPF;
	
	public Pessoa() {}
	
	public Pessoa(String nome, int CPF) {
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
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int CPF) {
		this.CPF =CPF;
	}
}
