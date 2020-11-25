package dados;

public class Pessoa {
	private String nome;
	private long  CPF;
	
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
	public long getCPF() {
		return CPF;
	}
	public void setCPF(long CPF) {
		this.CPF = CPF;
	}
}
