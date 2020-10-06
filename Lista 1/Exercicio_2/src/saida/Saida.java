package saida;

import java.text.DecimalFormat;

import dados.Supermercado;
import servicos.Servicos;

public class Saida {
	public static void imprimeResultados(Supermercado mercado) {
		
		DecimalFormat df = new DecimalFormat("0.00");
		Servicos.limpaTela();
		System.out.println("Resultados: \n");
		
		System.out.println("Numero de pessoas entrevistadas: "+ mercado.getClientes().size());
		System.out.println("Idade media: " + df.format(mercado.idadeMedia(mercado)) + " anos");
		System.out.println("Media da idade: " + df.format(mercado.mediaDeIdade(mercado)) + " anos");
		System.out.println("Media de satisfacao: " + df.format(mercado.mediaIndiceSatisfacao(mercado)));
		System.out.println("Quantidades de notas 5: " + mercado.mediaCinco(mercado) + " -- " + df.format(mercado.mediaCinco(mercado)/mercado.getClientes().size()*100) + " %");
		System.out.println("Quantidades de notas 10: " + mercado.mediaDez(mercado) + " -- " + df.format(mercado.mediaDez(mercado)/mercado.getClientes().size()*100) + " %");
		System.out.println("Indice menor que 7: " + mercado.indiceMenorQueSete(mercado) + " -- " + df.format(mercado.indiceMenorQueSete(mercado)/mercado.getClientes().size()*100) + " %");
	}
}
