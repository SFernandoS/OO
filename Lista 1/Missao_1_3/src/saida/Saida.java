package saida;

import java.text.DecimalFormat;

import dados.Eleicao;
import servicos.Servicos;

public class Saida {
	public static void imprimeResultado(Eleicao novaEleicao) {
		DecimalFormat dc = new DecimalFormat("0.00");
		
		Servicos.limpaTela();
		System.out.println("Resultados: \n");
		System.out.println("Total de votos: " + novaEleicao.getTotal());
		System.out.println("Total de votos Bolsorano: " + novaEleicao.getBolsonaro() + " -- " + dc.format(porcentagem(novaEleicao.getBolsonaro(), novaEleicao.getTotal())) + " %");
		System.out.println("Total de votos Haddad: " + novaEleicao.getHaddad()+ " -- " + dc.format(porcentagem(novaEleicao.getHaddad(), novaEleicao.getTotal()))+ " %");
		System.out.println("Total de votos Brancos: " + novaEleicao.getBranco() + " -- " + dc.format(porcentagem(novaEleicao.getBranco(), novaEleicao.getTotal()))+ " %");
		System.out.println("Total de votos Nulos: " + novaEleicao.getNulo() + " -- " + dc.format(porcentagem(novaEleicao.getNulo(), novaEleicao.getTotal()))+ " %");
	}
	
	public static float porcentagem(int x, int total) {
		return (x == 0)? 0: (float) x/total*100;
	}
}
