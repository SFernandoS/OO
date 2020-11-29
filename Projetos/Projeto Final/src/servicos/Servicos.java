package servicos;

/**
 * Servicos: Aqui se faz as manipulações secundárias, cria clientes, cadastra livros, faz novos pedidos, etc
 * @author Fernando Vargas
 * @version 1.0 (nov 2020)
 */
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.sun.tools.javac.Main;
import dados.Cliente;
import dados.Livraria;
import dados.Livro;
import dados.Pedidos;
import validacao.Validacao;

public class Servicos extends Main {

	/**
	 * O método cadastra um cliente na livraria
	 * 
	 * @param nome
	 * @param cep
	 * @param cpf
	 * @return Cliente
	 */
	public static Cliente criaCliente(String nome, String cep, String cpf) {
		nome = nome.toLowerCase();
		nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
		Cliente novoCliente = new Cliente(nome, cep, cpf, 50.00);
		return novoCliente;
	}

	/**
	 * O método cadastra um livro na livraria
	 * 
	 * @param titulo
	 * @param isbn
	 * @param autor
	 * @param editora
	 * @param preco
	 * @param genero
	 * @param quantidade
	 * @return Livro
	 */
	public static Livro cadastraLivro(String titulo, String isbn, String autor, String editora, double preco,
			int genero, int quantidade) {
		Livro novoLivro = new Livro(titulo, isbn, autor, editora, preco, genero, quantidade);
		return novoLivro;
	}

	/**
	 * O método faz um novo pedido
	 * 
	 * @param cliente
	 * @return Pedido
	 */
	public static Pedidos novoPedido(Cliente cliente) {
		Pedidos pedido = new Pedidos(cliente);
		return pedido;
	}

	/**
	 * O método faz um novo pedido e confirma-o
	 * 
	 * @param cliente
	 * @param confirma
	 * @return Pedido
	 */
	public static Pedidos novoPedido(Cliente cliente, boolean confirma) {
		Pedidos pedido = new Pedidos(cliente, confirma);
		return pedido;
	}

	/**
	 * O método cadastra uma compra de livro infantil
	 * 
	 * @param livraria
	 * @param numeroDoCliente
	 * @param indexDoChoice
	 */
	public static void cadastraCompraInfantil(Livraria livraria, int numeroDoCliente, int indexDoChoice) {

		int escolha = JOptionPane.YES_NO_OPTION;

		livraria.getClientes().get(numeroDoCliente).getCesta()
				.setItens(livraria.getCatalogo().getInfantil().get(indexDoChoice));
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");

		livraria.getClientes().get(numeroDoCliente).setPerfil(0);

		escolha = JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra?", null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			finalizaCompra(livraria, numeroDoCliente);
	}

	/**
	 * O método cadastra uma compra de livro de ficcao
	 * 
	 * @param livraria
	 * @param numeroDoCliente
	 * @param indexDoChoice
	 */
	public static void cadastraCompraFiccao(Livraria livraria, int numeroDoCliente, int indexDoChoice) {

		int escolha = JOptionPane.YES_NO_OPTION;

		livraria.getClientes().get(numeroDoCliente).getCesta()
				.setItens(livraria.getCatalogo().getFiccao().get(indexDoChoice));
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");

		livraria.getClientes().get(numeroDoCliente).setPerfil(1);

		escolha = JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra?", null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			finalizaCompra(livraria, numeroDoCliente);
	}

	/**
	 * O método cadastra a compra de um livro tecnico
	 * 
	 * @param livraria
	 * @param numeroDoCliente
	 * @param indexDoChoice
	 */
	public static void cadastraCompraTecnico(Livraria livraria, int numeroDoCliente, int indexDoChoice) {

		int escolha = JOptionPane.YES_NO_OPTION;

		livraria.getClientes().get(numeroDoCliente).getCesta()
				.setItens(livraria.getCatalogo().getTecnico().get(indexDoChoice));
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");

		livraria.getClientes().get(numeroDoCliente).setPerfil(2);

		escolha = JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra?", null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			finalizaCompra(livraria, numeroDoCliente);
	}

	/**
	 * O método cadastra a compra de livro da categoria "outros"
	 * 
	 * @param livraria
	 * @param numeroDoCliente
	 * @param indexDoChoice
	 */
	public static void cadastraCompraOutros(Livraria livraria, int numeroDoCliente, int indexDoChoice) {

		int escolha = JOptionPane.YES_NO_OPTION;

		livraria.getClientes().get(numeroDoCliente).getCesta()
				.setItens(livraria.getCatalogo().getOutros().get(indexDoChoice));
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");

		livraria.getClientes().get(numeroDoCliente).setPerfil(3);

		escolha = JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra?", null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			finalizaCompra(livraria, numeroDoCliente);
	}

	/**
	 * 1 - Finaliza a compra 2 - Escolhe a forma de pagamentos 3 - Cadastra o
	 * endereço do cliente 4 - Faz o pedido 5 - limpa a cesta, após o pedido feito
	 * 
	 * @param livraria
	 * @param numeroDoCliente
	 */
	public static void finalizaCompra(Livraria livraria, int numeroDoCliente) {
		int escolha = JOptionPane.YES_OPTION;
		String[] pagamentoOpcoes = { "Dinheiro", "Cartao" };
		String endereco;

		do {
			endereco = JOptionPane.showInputDialog("Endereco completo: ");
		} while (!Validacao.validaEndereco(endereco));

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

	/**
	 * Confirma a compra
	 * 
	 * @param contenPane
	 * @param livraria
	 */
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

	/**
	 * Procura o cliente e retorna a posição dele no ArrayList
	 * 
	 * @param livraria
	 * @param contenPane
	 * @return int
	 */
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

	/**
	 * Procura o cliente pelo nome e retorna a posição dele no ArrayList
	 * 
	 * @param livraria
	 * @param nome
	 * @return int
	 */
	public static int procuraCliente(Livraria livraria, String nome) {
		for (int i = 0; i < livraria.getClientes().size(); i++)
			if (nome.equals(livraria.getClientes().get(i).getNome()))
				return i;
		return 0;
	}

	/**
	 * Mostra a lista de pagamentos efetuados no Panel
	 * 
	 * @param panel
	 * @param livraria
	 * @param cPagamentos
	 */
	public static void mostraPagamentosEfetuados(JPanel panel, Livraria livraria, Choice cPagamentos) {
		panel.removeAll();

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

		JLabel nomeDoCliente = new JLabel(
				livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getPedido().getNome());
		nomeDoCliente.setBounds(77, 47, 407, 22);
		panel.add(nomeDoCliente);
		nomeDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel cepDoCliente = new JLabel(
				livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getPedido().getCEP());
		cepDoCliente.setBounds(77, 139, 407, 21);
		panel.add(cepDoCliente);
		cepDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel cpfDoCliente = new JLabel(
				livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getPedido().getCPF());
		cpfDoCliente.setBounds(77, 231, 407, 19);
		panel.add(cpfDoCliente);
		cpfDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));

		JLabel pagamentoDoCliente = new JLabel(
				Double.toString(livraria.getFuncionario().getVendas().get(cPagamentos.getSelectedIndex()).getTotal()));
		pagamentoDoCliente.setBounds(120, 300, 360, 19);
		panel.add(pagamentoDoCliente);
		pagamentoDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
	}

	public static void verificaPedidosExpirados(Livraria livraria) {
		for (int i = 0; i < livraria.getFuncionario().getVendas().size(); i++) {
			if (livraria.getFuncionario().getVendas().get(i).getValidade() == LocalDate.now()) {
				livraria.getFuncionario().vendaExpirada(i);
			}
		}
	}
}
