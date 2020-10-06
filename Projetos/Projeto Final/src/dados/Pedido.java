package dados;

public class Pedido {
	private Cliente cliente;
	private int codigo;
	private String endereco;
	
	public Pedido(Cliente cliente, int codigo, String endereco) {
		this.cliente = cliente;
		this.codigo = codigo;
		this.endereco = endereco;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
