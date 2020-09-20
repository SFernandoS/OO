package servicos;

import dados.Pessoa;
import dados.Supermercado;
import leitura.Leitura;
import validacao.Validacao;

public class Servicos {
	public static Supermercado criaSupermercado() {
		return new Supermercado();
	}
	
	public static Supermercado criaCliente(Supermercado mercado) {
		int quantidadeDeClientes;
		
		System.out.print("Digite a quantidade de clientes: ");		
		quantidadeDeClientes = Leitura.lerInt(0);
		limpaTela();
		
		for (int i = 0; i < quantidadeDeClientes; i++) {	
			Pessoa novoCliente = new Pessoa(cadastraIdade(i), cadastraSatisfacao(i));
			mercado.setClientes(novoCliente);
		}
		return mercado;
	}
	
	public static int cadastraIdade(int parametroDoCliente) {
		int idade = 0;
		
		System.out.print("Digite a idade do cliente " + (1 + parametroDoCliente)+": ");
	
		do
			idade = Leitura.lerInt(0);
		while(!Validacao.validaIdade(idade));
	
		return idade;
	}
	
	public static int cadastraSatisfacao(int parametroDoCliente) {
		int satisfacao;
		
		System.out.print("Digite o grau de satisfacao do cliente "+ (1 + parametroDoCliente) + " (5 a 10): ");
		
		do
			satisfacao = Leitura.lerInt(0);
		while(!Validacao.validaSatisfacao(satisfacao));
		
		return satisfacao;
	}
	
	public static void limpaTela() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

}
