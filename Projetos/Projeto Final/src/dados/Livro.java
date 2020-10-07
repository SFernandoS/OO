package dados;

public class Livro {
	private String titulo;
	private String isbn;
	private String autor;
	private String editora;
	private int genero;  // 0 - infantil; 1 - tecnico; 2 - ficcao, 3 - outros. 
	private double preco;
	
	public Livro(String titulo, String isbn, String autor, String editora, double preco, int genero) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.genero = genero;
		this.preco = preco;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}
}
