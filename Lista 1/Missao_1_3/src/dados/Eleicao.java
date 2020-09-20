package dados;

public class Eleicao {
	private int bolsonaro;
	private int haddad;
	private int nulo;
	private int branco ;
	
	public Eleicao() {
		this.bolsonaro = 0;
		this.haddad = 0;
		this.branco = 0;
		this.nulo = 0;
	}
	
	
	public int getBolsonaro() {
		return bolsonaro;
	}
	public void setBolsonaro() {
		bolsonaro++;
	}
	public int getHaddad() {
		return haddad;
	}
	public void setHaddad() {
		haddad++;
	}
	public int getNulo() {
		return nulo;
	}
	public void setNulo() {
		nulo++;
	}
	public int getBranco() {
		return branco;
	}
	public void setBranco() {
		branco++;
	}

	public int getTotal() {
		return bolsonaro + haddad + nulo + branco;
	}

}
