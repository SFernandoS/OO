package servicos;

import dados.Eleicao;
import leitura.Leitura;
import validacao.Validacao;

public class Servicos {
	public static Eleicao criaEleicao() {
		Eleicao novaEleicao = new Eleicao();
		return novaEleicao;
	}
	
	public static Eleicao cadastraVotos(Eleicao novaEleicao) {
		int voto;
		
		do {
			System.out.println("Votação:\n");
			System.out.println("13 - Haddad;");
			System.out.println("17 - Bolsonaro;");
			System.out.println("10 - Nulo;");
			System.out.println("11 - Branco;");
			System.out.println("\n0 - Finalizar.\n");
			System.out.println("Digite uma das opcoes: ");
			voto = Leitura.lerInt(0);
			if (Validacao.validaVoto(voto))
				guardaVoto(novaEleicao, voto);
		} while (voto != 0);
		return novaEleicao;
	}
	
	public static void guardaVoto(Eleicao novaEleicao, int voto) {
		
		limpaTela();
		System.out.println("Voto Cadastrado com sucesso!");
		switch (voto) {
		case 17:
			novaEleicao.setBolsonaro();
			break;
		case 13:
			novaEleicao.setHaddad();
			break;
		case 10:
			novaEleicao.setNulo();
			break;
		default:
			novaEleicao.setBranco();
			break;
		}
	}

	public static boolean outraUrna() {
		int escolha = 0;
		do {
			System.out.println("\nDeseja cadastrar outra urna: ");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			escolha = Leitura.lerInt(0);
		}while(!Validacao.validaRepeticao(escolha));
		limpaTela();
		return (escolha == 1)? true: false;
	}
	
	
	public static void limpaTela() {
		for (int i = 0; i < 50; i++)
		 System.out.println();		
	}
}
