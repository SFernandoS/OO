package servicos;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.tools.javac.Main;

import dados.Cliente;
import dados.Livraria;
import dados.Livro;

public class Servicos extends Main {
	
	public static Cliente criaCliente(String nome, int cep, int cpf) {
		Cliente novoCliente = new Cliente(nome, cep, cpf, 50.00);
		return novoCliente;
	}
	
	public static Livro cadastraLivro(String titulo, String isbn, String autor, String editora, double preco, int genero, int quantidade) {
		Livro novoLivro = new Livro(titulo, isbn, autor, editora, preco, genero, quantidade);
		return novoLivro;
	}
	
	public static void cadastraCompra(Livraria livraria, int numeroDoCliente, int indexDoChoice) {	
		
		int escolha = JOptionPane.YES_NO_OPTION;
		
		livraria.getClientes().get(numeroDoCliente).getCesta().setItens(livraria.getCatalogo().getInfantil().get(indexDoChoice));
		//for (int i = 0; i <livraria.getClientes().get(numeroDoCliente).getCesta().getItens().size(); i++)
			//JOptionPane.showMessageDialog(null, livraria.getClientes().get(numeroDoCliente).getCesta().getItens().get(i).getTitulo());
		JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");
		
		JOptionPane.showConfirmDialog(null, "Deseja finalizar a compra?",null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			finalizaCompra(livraria, numeroDoCliente);		
	}
	
public static void finalizaCompra(Livraria livraria, int numeroDoCliente) {
		int escolha = JOptionPane.YES_OPTION;
		
		String endereco =JOptionPane.showInputDialog("Endereco completo: ");
		String [] pagamentoOpcoes = {"Dinheiro", "Cartao"};
		
		
		int pagamento = JOptionPane.showOptionDialog(null, "Formas de pagamentos: (Dinheiro -10%)",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,pagamentoOpcoes , null);
		
		livraria.getClientes().get(numeroDoCliente).getCesta().setEndereco(endereco);
		
		if (pagamento == 0) 
			livraria.getClientes().get(numeroDoCliente).getCesta().setTotal();
		else
			livraria.getClientes().get(numeroDoCliente).getCesta().setTotal(0.10);
		
		JOptionPane.showConfirmDialog(null, "Deseja confimar a compra?",null, escolha);
		if (escolha == JOptionPane.YES_OPTION)
			livraria.getClientes().get(numeroDoCliente).getCesta().setPendente(false);
	}

	public static void confirmaCompra(JPanel contenPane, Livraria livraria) {
		String nomeDoClienteInput = null;
		int numeroDoCliente = -1;
		
		//Encontra o cliente
			try {
				nomeDoClienteInput = JOptionPane.showInputDialog("Digite o nome do cliente:");
				nomeDoClienteInput = nomeDoClienteInput.toLowerCase();
				nomeDoClienteInput = Character.toUpperCase(nomeDoClienteInput.charAt(0)) + nomeDoClienteInput.substring(1);		
				
				//Guarda o cliente
				for (int i = 0; i < livraria.getClientes().size(); i++)
					if (nomeDoClienteInput.equals(livraria.getClientes().get(i).getNome())){
						numeroDoCliente = i;
					}
					
					//Verifica se encontrou o cliente
				if (numeroDoCliente == -1) {
					JOptionPane.showMessageDialog(null, "Cliente nao encontrado");
					CardLayout cadastro = (CardLayout) (contenPane.getLayout());
					cadastro.show(contenPane, "catalogo");
				}
				
				livraria.getClientes().get(numeroDoCliente).getCesta().setPendente(false);
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "entrada invalida");
				//voltaCliente(contenPane);
			}

			JOptionPane.showConfirmDialog(null, "Venda confirmada com sucesso");
			
	}
}
