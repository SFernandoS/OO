package servicos;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.sun.tools.javac.Main;
import dados.Cliente;
import dados.Livraria;
import dados.Livro;
import dados.Pedidos;

public class Servicos extends Main {

	public static Cliente criaCliente(String nome, String cep, String cpf) {
		nome = nome.toLowerCase();
		nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
		Cliente novoCliente = new Cliente(nome, cep, cpf, 50.00);
		return novoCliente;
	}

	public static Livro cadastraLivro(String titulo, String isbn, String autor, String editora, double preco,
			int genero, int quantidade) {
		Livro novoLivro = new Livro(titulo, isbn, autor, editora, preco, genero, quantidade);
		return novoLivro;
	}

	
	public static Pedidos novoPedido(Cliente cliente) {
		Pedidos pedido = new Pedidos(cliente);
		return pedido;
	}
	
	public static Pedidos novoPedido(Cliente cliente, boolean confirma) {
		Pedidos pedido = new Pedidos(cliente, confirma);
		return pedido;
	}
	
	public static void cadastraCompra(Livraria livraria, int numeroDoCliente, int indexDoChoice) {

		int escolha = JOptionPane.YES_NO_OPTION;

		livraria.getClientes().get(numeroDoCliente).getCesta()
				.setItens(livraria.getCatalogo().getInfantil().get(indexDoChoice));
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");

		escolha = JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra?", null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			finalizaCompra(livraria, numeroDoCliente);
	}

	public static void finalizaCompra(Livraria livraria, int numeroDoCliente) {
		int escolha = JOptionPane.YES_OPTION;

		String endereco = JOptionPane.showInputDialog("Endereco completo: ");
		String[] pagamentoOpcoes = { "Dinheiro", "Cartao" };

		int pagamento = JOptionPane.showOptionDialog(null, "Formas de pagamentos: (Dinheiro -10%)", null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, pagamentoOpcoes, null);

		livraria.getClientes().get(numeroDoCliente).getCesta().setEndereco(endereco);

		if (pagamento == 0)
			livraria.getClientes().get(numeroDoCliente).getCesta().setTotal(0.90);
		else
			livraria.getClientes().get(numeroDoCliente).getCesta().setTotal();

		escolha = JOptionPane.showConfirmDialog(null, "Deseja confimar a compra?", null, escolha);

		if (escolha == 0) 
			livraria.getFuncionario().setVendas(novoPedido(livraria.getClientes().get(numeroDoCliente), true));
		else
			livraria.getFuncionario().setVendas(novoPedido(livraria.getClientes().get(numeroDoCliente)));
		
		livraria.getClientes().get(numeroDoCliente).getCesta().limpaCesta();
		livraria.getClientes().get(numeroDoCliente).getCesta().setTotal();
		
	}

	public static void confirmaCompra(JPanel contenPane, Livraria livraria) {
		String nomeDoClienteInput = null;
		int numeroDoCliente = -1;

		// Encontra o cliente
		try {
			nomeDoClienteInput = JOptionPane.showInputDialog("Digite o nome do cliente:");
			nomeDoClienteInput = nomeDoClienteInput.toLowerCase();
			nomeDoClienteInput = Character.toUpperCase(nomeDoClienteInput.charAt(0)) + nomeDoClienteInput.substring(1);

			// Guarda o cliente
			for (int i = 0; i < livraria.getFuncionario().getVendas().size(); i++)
				if (nomeDoClienteInput.equals(livraria.getFuncionario().getVendas().get(0).getPedido().getNome())) {
					numeroDoCliente = i;
				}

			// Verifica se encontrou o cliente
			if (numeroDoCliente == -1) {
				JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
				CardLayout cadastro = (CardLayout) (contenPane.getLayout());
				cadastro.show(contenPane, "catalogo");
			} else {
				livraria.getFuncionario().getVendas().get(numeroDoCliente).setConfirma();
				JOptionPane.showMessageDialog(null, "Venda confirmada com sucesso");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "entrada invalida");
		}
	}

	public static int procuraCliente(Livraria livraria, JPanel contenPane) {
		int numeroDoCliente = -1;
		String nomeDoClienteInput;
		try {
			nomeDoClienteInput = JOptionPane.showInputDialog("Digite o nome do cliente:");
			nomeDoClienteInput = nomeDoClienteInput.toLowerCase();
			nomeDoClienteInput = Character.toUpperCase(nomeDoClienteInput.charAt(0)) + nomeDoClienteInput.substring(1);

			// Guarda o cliente
			for (int i = 0; i < livraria.getClientes().size(); i++)
				if (nomeDoClienteInput.equals(livraria.getClientes().get(i).getNome())) {
					numeroDoCliente = i;
				}

			// Verifica se encontrou o cliente
			if (numeroDoCliente == -1) {
				JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
				CardLayout cadastro = (CardLayout) (contenPane.getLayout());
				cadastro.show(contenPane, "catalogo");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "entrada invalida");
			CardLayout estoque = (CardLayout) (contenPane.getLayout());
			estoque.show(contenPane, "catalogo");
		}
		return numeroDoCliente;
	}

	public static int procuraCliente(Livraria livraria, String nome) {
		for (int i = 0; i < livraria.getClientes().size(); i++)
			if (nome.equals(livraria.getClientes().get(i).getNome()))
				return i;
		return 0;
	}

	public static void mostraPagamentosEfetuados(JPanel panel, Livraria livraria, Choice cPagamentos) {
		//panel.removeAll();
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 45, 66, 27);
		panel.add(lblNome);
		lblNome.setForeground(Color.DARK_GRAY);
		lblNome.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 136, 100, 27);
		panel.add(lblCPF);
		lblCPF.setForeground(Color.DARK_GRAY);
		lblCPF.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(10, 230, 100, 20);
		panel.add(lblCEP);
		lblCEP.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		lblCEP.setForeground(Color.DARK_GRAY);

		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(10, 300, 400, 19);
		panel.add(lblPagamento);
		lblPagamento.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		lblPagamento.setForeground(Color.DARK_GRAY);

		JLabel nomeDoCliente = new JLabel(livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getPedido().getNome());
		nomeDoCliente.setBounds(77, 47, 407, 22);
		panel.add(nomeDoCliente);
		nomeDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel cepDoCliente = new JLabel(livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getPedido().getCEP());
		cepDoCliente.setBounds(77, 139, 407, 21);
		panel.add(cepDoCliente);
		cepDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel cpfDoCliente = new JLabel(livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getPedido().getCPF());
		cpfDoCliente.setBounds(77, 231, 407, 19);
		panel.add(cpfDoCliente);
		cpfDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel pagamentoDoCliente = new JLabel(
				Double.toString(livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getTotal()));
		pagamentoDoCliente.setBounds(120, 300, 360, 19);
		panel.add(pagamentoDoCliente);
		pagamentoDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
	}

}
