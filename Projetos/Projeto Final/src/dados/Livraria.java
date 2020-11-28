package dados;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public void clientesCadastrados(JPanel panel, Livraria livraria, Choice lista) {
		
		panel.removeAll();
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 45, 66, 27);
		panel.add(lblNome);
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 136, 46, 27);
		panel.add(lblCPF);
		lblCPF.setForeground(Color.DARK_GRAY);
		lblCPF.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(10, 230, 46, 20);
		panel.add(lblCEP);
		lblCEP.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		lblCEP.setForeground(Color.DARK_GRAY);
							
		JLabel nomeDoCliente = new JLabel(livraria.getClientes().get(lista.getSelectedIndex()).getNome());
		nomeDoCliente.setBounds(77, 45, 417, 22);
		panel.add(nomeDoCliente);
		nomeDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		JLabel cepDoCliente = new JLabel(livraria.getClientes().get(lista.getSelectedIndex()).getCEP());
		cepDoCliente.setBounds(77, 136, 407, 21);
		panel.add(cepDoCliente);
		cepDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		JLabel cpfDoCliente = new JLabel(livraria.getClientes().get(lista.getSelectedIndex()).getCPF());
		cpfDoCliente.setBounds(77, 230, 417, 19);
		panel.add(cpfDoCliente);
		cpfDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
	}
	
	public void perfilClientes() {
		System.out.println("Clientes: Perfil\n\n");
		
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).getNome() + ": " + clientes.get(i).getPerfil());
		}
	}
	
}
