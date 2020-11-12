package dados;

import java.util.ArrayList;

public class Livraria extends Catalogo{
	private Catalogo catalogo;
	private ArrayList<Cliente> clientes;
	private ArrayList<Funcionario> funcionarios;
	
	public Livraria() {
		this.clientes = new ArrayList<Cliente>();
		this.funcionarios = new ArrayList<Funcionario>();
		this.catalogo = new Catalogo();
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

	public void setCatalogoInfantil(Livro novoLivroInfantil) {
		catalogo.setInfantil(novoLivroInfantil);
	}
	
	public void setCatalogoFiccao(Livro novoLivroFiccao) {
		catalogo.setFiccao(novoLivroFiccao);
	}
	
	public void setCatalogoTecnico(Livro novoLivroTecnico) {
		catalogo.setTecnico(novoLivroTecnico);
	}
	
	public void setCatalogoOutros(Livro novoLivroOutros) {
		catalogo.setOutros(novoLivroOutros);
	}
	
	public void clientesCadastrados() {
		System.out.println("Clientes:\n\n");
		
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println("nome: " + clientes.get(i).getNome());
			System.out.println("CPF: " + clientes.get(i).getCPF());
			System.out.println("CEP: "+ clientes.get(i).getCEP());
			System.out.println("Frete: " + clientes.get(i).getFrete());
			System.out.println("Perfil:" + clientes.get(i).calculaPerfil());
		}
	}
	
	public void perfilClientes() {
		System.out.println("Clientes: Perfil\n\n");
		
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).getNome() + ": " + clientes.get(i).getPerfil());
		}
	}
	
}
