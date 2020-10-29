package servicos;

import com.sun.tools.javac.Main;

import dados.Cliente;

public class Servicos extends Main {
	
	public static Cliente criaCliente(String nome, int cep, int cpf) {
		Cliente novoCliente = new Cliente(nome, cep, cpf, 50.00);
		return novoCliente;
	}
}
