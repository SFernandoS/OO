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

import dados.Livraria;

public class Estoque extends JPanel {

	public static void criaEstoque(JPanel contenPane, Livraria livraria) {
		Panel estoquePanel = new Panel();
		contenPane.add(estoquePanel, "estoque");
		estoquePanel.setLayout(null);
		
		Button btnVoltar = new Button("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		estoquePanel.add(btnVoltar);
		
		Label labelEstoque = new Label("Estoque");
		labelEstoque.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		labelEstoque.setBounds(202, 40, 170, 52);
		estoquePanel.add(labelEstoque);
		
		Choice genero = new Choice();
		genero.setBackground(new Color(204, 204, 153));
		genero.setBounds(44, 111, 496, 20);
		estoquePanel.add(genero);
		genero.add("nao implementado");
		
		Choice livro = new Choice();
		livro.setBackground(new Color(204, 204, 153));
		livro.setBounds(44, 150, 496, 20);
		estoquePanel.add(livro);
		
		Button pesquisa = new Button("Pesquisar");
		pesquisa.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		pesquisa.setBounds(234, 188, 116, 31);
		estoquePanel.add(pesquisa);
		livro.add("nao implementado");
		
		
		//Exibição
		CardLayout estoque = (CardLayout) (contenPane.getLayout());
		estoque.show(contenPane, "estoque");
	}

}
