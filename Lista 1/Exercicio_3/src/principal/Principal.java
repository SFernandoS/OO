package principal;

import saida.Saida;
import servicos.Servicos;

public class Principal {
	public static void main(String[] args) {
		
		do {
			Saida.imprimeResultado(Servicos.cadastraVotos(Servicos.criaEleicao()));
		}while(Servicos.outraUrna());
	}
}
