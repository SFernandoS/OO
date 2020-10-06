package dados;

public class Pessoa {
	private int idade;
	private int satisfacao;
	
	public Pessoa(int idade, int satisfacao) {
		this.idade = idade;
		this.satisfacao = satisfacao;
	}

	public int getIdade() {
		return idade;
	}

	public int getSatisfacao() {
		return satisfacao;
	}
}
