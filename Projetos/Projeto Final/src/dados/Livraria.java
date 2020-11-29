package dados;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * parte principal dos dados
 * 
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */
public class Livraria extends Catalogo {
	private Catalogo catalogo;
	private ArrayList<Cliente> clientes;
	private Funcionario funcionario;

	public Livraria() {
		this.clientes = new ArrayList<Cliente>();
		this.funcionario = new Funcionario();
		this.catalogo = new Catalogo();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Cliente novoCliente) {
		clientes.add(novoCliente);
	}

	public Funcionario getFuncionario() {
		return funcionario;
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

	/**
	 * printa no Panel os clientes cadastrados
	 * 
	 * @param panel
	 * @param livraria
	 * @param lista
	 */
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

}
