package dados;

/**
 * Cliente: dados do cliente
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */

public class Cliente extends Pessoa {
	private int perfil;
	private String CEP;
	private double frete;
	private Cesta cesta;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String CPF, String CEP, double frete) {
		super(nome, CPF);
		this.CEP = CEP;
		this.frete = frete;
		this.perfil = -1;
		this.cesta = new Cesta();
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	public Cesta getCesta() {
		return cesta;
	}

	public void setCesta(Cesta cesta) {
		this.cesta = cesta;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getPerfil() {
		return perfil;
	}
}
