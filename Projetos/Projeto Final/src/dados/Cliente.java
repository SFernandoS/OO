package dados;



public class Cliente extends Pessoa {
	private int [] perfil;
	private int CEP;
	private double frete;
	private Cesta cesta;
	
	public Cliente() {
		super();
	}
	
	public Cliente (String nome, int CPF, int CEP, double frete) {
		super(nome,CPF);
		this.CEP = CEP;
		this.frete = frete;
		this.perfil = new int [4];
		this.cesta = new Cesta();
	}
	
	
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int CEP) {
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

	public int calculaPerfil() {
			
		for (int i = 0; i < cesta.getItens().size(); i++) {
			switch (cesta.getItens().get(i).getGenero()) {
			case 1:
				perfil[0] ++;
				break;
			case 2:
				perfil[1] ++;
				break;
			case 3:
				perfil[2] ++;
				break;
			default:
				perfil[3] ++;
				break;
			}
		}
		
		if (perfil[0] > perfil [1] && perfil[0] > perfil [2] && perfil[0] > perfil [3])
			return 0; //infantil
		else if (perfil[1] > perfil [0] && perfil[1] > perfil [2] && perfil[1] > perfil [3])
			return 1; //tecnico
		else if (perfil[2] > perfil [1] && perfil[2] > perfil [0] && perfil[2] > perfil [3])
			return 2; //ficcao
		else if (perfil[3] > perfil [1] && perfil[3] > perfil [2] && perfil[3] > perfil [0])
			return 3; //outros
		else
			return -1;
	}
	
	public String getPerfil() {
		switch (calculaPerfil()) {
		case 0:
			return "Infantil";
		case 1:
			return "Tecnico";
		case 2:
			return "Ficcao";
		case 3:
			return "outros";
		default:
			return "Sem perfil";
		}
	}
}
