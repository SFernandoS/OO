package dados;

public class Cliente extends Pessoa {
	private int CEP;
	private float frete;
	private Cesta cesta;
	
	public Cliente() {
		super();
	}
	
	public Cliente (String nome, int CPF, int CEP, float frete) {
		super(nome,CPF);
		this.CEP = CEP;
		this.frete = frete;
		this.cesta = new Cesta();
	}
	
	
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public float getFrete() {
		return frete;
	}
	public void setFrete(float frete) {
		this.frete = frete;
	}
	public Cesta getCesta() {
		return cesta;
	}
	public void setCesta(Cesta cesta) {
		this.cesta = cesta;
	}
}
