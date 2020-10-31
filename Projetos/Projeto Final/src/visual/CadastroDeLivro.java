package visual;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import dados.Livraria;

public class CadastroDeLivro extends JPanel {
	
	static private JTextField textTitulo;
	static private JTextField textISBN;
	static private JTextField textAutor;
	static private JTextField textEditora;
	static private JTextField textPreco;
	static private JTextField textQuantidade;
	
	public static void cadastroDeLivro(JPanel contenPane, Livraria livraria) {
		
		Panel cadastroLivroPanel = new Panel();
		contenPane.add(cadastroLivroPanel, "cadLivro");
		cadastroLivroPanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		cadastroLivroPanel.add(btnVoltar);
		
		Label titulo = new Label("Cadastro de livro");
		titulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		titulo.setBounds(119, 30, 336, 45);
		cadastroLivroPanel.add(titulo);
		
		Label labelTitulo = new Label("T\u00EDtulo");
		labelTitulo.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelTitulo.setBounds(264, 95, 56, 20);
		cadastroLivroPanel.add(labelTitulo);
		
		Label labelISBN = new Label("ISBN");
		labelISBN.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelISBN.setBounds(269, 155, 46, 20);
		cadastroLivroPanel.add(labelISBN);
		
		Label labelAutor = new Label("Autor");
		labelAutor.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelAutor.setBounds(259, 215, 56, 20);
		cadastroLivroPanel.add(labelAutor);
		
		Label labelEditora = new Label("Editora");
		labelEditora.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelEditora.setBounds(258, 275, 67, 20);
		cadastroLivroPanel.add(labelEditora);
		
		Label labelGenero = new Label("G\u00EAnero");
		labelGenero.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelGenero.setBounds(259, 455, 67, 20);
		cadastroLivroPanel.add(labelGenero);
		
		Label labelPreco = new Label("Pre\u00E7o (x.xx)");
		labelPreco.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelPreco.setBounds(239, 335, 105, 20);
		cadastroLivroPanel.add(labelPreco);
		
		Label labelQuantidade = new Label("Quantidade");
		labelQuantidade.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		labelQuantidade.setBounds(233, 395, 107, 20);
		cadastroLivroPanel.add(labelQuantidade);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(142, 120, 300, 25);
		cadastroLivroPanel.add(textTitulo);
		textTitulo.setColumns(10);
		
		textISBN = new JTextField();
		textISBN.setBounds(142, 180, 300, 25);
		cadastroLivroPanel.add(textISBN);
		textISBN.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(142, 240, 300, 25);
		cadastroLivroPanel.add(textAutor);
		textAutor.setColumns(10);
		
		textEditora = new JTextField();
		textEditora.setBounds(142, 300, 300, 25);
		cadastroLivroPanel.add(textEditora);
		textEditora.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(142, 360, 300, 25);
		cadastroLivroPanel.add(textPreco);
		textPreco.setColumns(10);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(142, 420, 300, 25);
		cadastroLivroPanel.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		Choice choiceGenero = new Choice();
		choiceGenero.setBackground(new Color(204, 204, 153));
		choiceGenero.setBounds(142, 480, 300, 25);
		cadastroLivroPanel.add(choiceGenero);
		choiceGenero.add("nao implementado");
		
		Button btnFim = new Button("Finalizar");
		btnFim.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFim.setBounds(234, 510, 116, 30);
		cadastroLivroPanel.add(btnFim);
		
		//Exibição
		CardLayout cadLivro = (CardLayout) (contenPane.getLayout());
		cadLivro.show(contenPane, "cadLivro");
	}

}
