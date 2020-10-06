package dados;

import java.util.ArrayList;

public class Livraria {
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;
	private Catalogo catalogo;
	
	
	
	public Livraria(Catalogo catalogo) {
		this.clientes = new ArrayList<Cliente>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.catalogo = catalogo;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Cliente novoCliente) {
		clientes.add(novoCliente);
	}
	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario novoFuncionario) {
		funcionarios.add(novoFuncionario);
	}
	
	public Catalogo getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
}
