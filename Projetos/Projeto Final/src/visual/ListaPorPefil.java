package visual;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dados.Livraria;

@SuppressWarnings("serial")
public class ListaPorPefil extends JPanel {

	public static void criaListaPorPefil(JPanel contenPane, Livraria livraria) {	
				
		JPanel listaPanel = new JPanel();
		contenPane.add(listaPanel, "perfilLista");
		listaPanel.setLayout(null);
		listaPanel.setLayout(new CardLayout(0, 0));
	
		//Inicio: (menu)
		JPanel inicioLista = new JPanel();
		inicioLista.setBackground(new Color(204, 204, 102));
		listaPanel.add(inicioLista, "inicioLista");
		inicioLista.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (contenPane.getLayout());
				inicio.show(contenPane, "inicio");
			}
		});
		btnVoltar.setBounds(10, 11, 89, 22);
		inicioLista.add(btnVoltar);
		
		JLabel tituloListaPerfil = new JLabel("Lista por perfil\r\n");
		tituloListaPerfil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		tituloListaPerfil.setBounds(160, 46, 454, 43);
		inicioLista.add(tituloListaPerfil);
		
		//Exibicao infantil
		JButton btnInfantil = new JButton("Infantil");
		btnInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout infantilTela = (CardLayout) (listaPanel.getLayout());
				infantilTela.show(listaPanel, "infantilTela");
			}
		});
		btnInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnInfantil.setBounds(152, 139, 270, 40);
		inicioLista.add(btnInfantil);
		
		//Exibicao ficcao
		JButton btnFiccao = new JButton("Ficcao");
		btnFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraFiccao = (CardLayout) (listaPanel.getLayout());
				mostraFiccao.show(listaPanel, "ficcaoTela");
			}
		});
		btnFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnFiccao.setBounds(152, 210, 270, 40);
		inicioLista.add(btnFiccao);
		
		//Exibicao tencico
		JButton btnTecnico = new JButton("Tecnico");
		btnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraTecnico = (CardLayout) (listaPanel.getLayout());
				mostraTecnico.show(listaPanel, "tecnicoTela");
			}
		});
		btnTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnTecnico.setBounds(152, 278, 270, 40);
		inicioLista.add(btnTecnico);
		
		//Exibicao outros
		JButton btnOutros = new JButton("Outros");
		btnOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout mostraOutros = (CardLayout) (listaPanel.getLayout());
				mostraOutros.show(listaPanel, "outrosTela");
			}
		});
		btnOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnOutros.setBounds(152, 351, 270, 40);
		inicioLista.add(btnOutros);
				
		//Panel: Infantil
		infantilPanel(listaPanel, livraria);

		//Panel Ficcao
		ficcaoPanel(listaPanel, livraria);
		
		// Panel tecnico
		tecnicoPanel(listaPanel, livraria);
		
		//Panel: Outros
		outrosPanel(listaPanel, livraria);
		
		//Exibição da Lista por perfil
		CardLayout inicioListaMostra = (CardLayout) (contenPane.getLayout());
		inicioListaMostra.show(contenPane, "perfilLista");
		 
	}

	//Volta para a Lista por perfil
	public static JButton voltarLista(JPanel listaPanel) {
		JButton btnVoltarLísta = new JButton("Voltar");
		btnVoltarLísta.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnVoltarLísta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout inicio = (CardLayout) (listaPanel.getLayout());
				inicio.show(listaPanel, "inicioLista");
			}
		});
		btnVoltarLísta.setBounds(10, 11, 89, 22);
		
		return btnVoltarLísta;
	}

	// Panel infantil
	public static void infantilPanel(JPanel listaPanel, Livraria livraria) {
		JPanel infantil = new JPanel();
		infantil.setBackground(new Color(204, 204, 102));
		listaPanel.add(infantil, "infantilTela");
		infantil.setLayout(null);
		infantil.add(voltarLista(listaPanel));
		
		
		JLabel lblInfantil = new JLabel("Infantil\r\n");
		lblInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblInfantil.setBounds(213, 35, 147, 60);
		infantil.add(lblInfantil);
		
		//Panel do resultado da busca
		JPanel panelPesquisaInfantil = new JPanel();
		panelPesquisaInfantil.setBackground(new Color(204, 204, 153));
		panelPesquisaInfantil.setBounds(10, 214, 554, 326);
		infantil.add(panelPesquisaInfantil);
		panelPesquisaInfantil.setLayout(null);
		
		Choice choiceInfantil = new Choice();
		choiceInfantil.setBounds(10, 121, 554, 20);
		infantil.add(choiceInfantil);
		
		for (int i = 0; i < livraria.getClientes().size(); i++) 
			if (livraria.getClientes().get(i).calculaPerfil() == 0)
				choiceInfantil.add(livraria.getClientes().get(i).getNome());
	
			
		JButton btnPesquisaInfantil = new JButton("Pesquisar");
		btnPesquisaInfantil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceInfantil.getSelectedIndex() == - 1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados com este perfil!");
				else 
					imprimeCliente(panelPesquisaInfantil, livraria, choiceInfantil);
			}
		});
		btnPesquisaInfantil.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaInfantil.setBounds(223, 157, 127, 25);
		infantil.add(btnPesquisaInfantil);
	}
	
	//Panel ficcao
	public static void ficcaoPanel(JPanel listaPanel, Livraria livraria) {
		JPanel ficcao = new JPanel();
		ficcao.setBackground(new Color(204, 204, 102));
		listaPanel.add(ficcao, "ficcaoTela");
		ficcao.setLayout(null);
		ficcao.add(voltarLista(listaPanel));
		
		JLabel lblFiccao = new JLabel("Ficcao");
		lblFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblFiccao.setBounds(223, 27, 127, 68);
		ficcao.add(lblFiccao);
		
		Choice choiceFiccao = new Choice();
		choiceFiccao.setBounds(10, 121, 554, 20);
		ficcao.add(choiceFiccao);
		
		JPanel panelPesquisaFiccao = new JPanel();
		panelPesquisaFiccao.setBackground(new Color(204, 204, 153));
		panelPesquisaFiccao.setBounds(10, 214, 554, 326);
		ficcao.add(panelPesquisaFiccao);
		panelPesquisaFiccao.setLayout(null);
	
		for (int i = 0; i < livraria.getClientes().size(); i++) 
			if (livraria.getClientes().get(i).calculaPerfil() == 1)
				choiceFiccao.add(livraria.getClientes().get(i).getNome());
		
		JButton btnPesquisaFiccao = new JButton("Pesquisar");
		btnPesquisaFiccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceFiccao.getSelectedIndex() == - 1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados com este perfil!");
				else
					imprimeCliente(panelPesquisaFiccao, livraria, choiceFiccao);
			}
		});
		btnPesquisaFiccao.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaFiccao.setBounds(223, 157, 127, 25);
		ficcao.add(btnPesquisaFiccao);
	}
	
	//Panel tecnico
	public static void tecnicoPanel(JPanel listaPanel, Livraria livraria) {
		JPanel tecnico = new JPanel();
		tecnico.setBackground(new Color(204, 204, 102));
		listaPanel.add(tecnico, "tecnicoTela");
		tecnico.setLayout(null);
		tecnico.add(voltarLista(listaPanel));
		
		JLabel lblTecnico = new JLabel("Tecnico");
		lblTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblTecnico.setBounds(213, 35, 147, 60);
		tecnico.add(lblTecnico);
		
		Choice choiceTecnico = new Choice();
		choiceTecnico.setBounds(10, 121, 554, 20);
		tecnico.add(choiceTecnico);
		
		JPanel panelPesquisaTecnico = new JPanel();
		panelPesquisaTecnico.setBackground(new Color(204, 204, 153));
		panelPesquisaTecnico.setBounds(10, 214, 554, 326);
		tecnico.add(panelPesquisaTecnico);
		panelPesquisaTecnico.setLayout(null);
		
		for (int i = 0; i < livraria.getClientes().size(); i++) 
			if (livraria.getClientes().get(i).calculaPerfil() == 2)
				choiceTecnico.add(livraria.getClientes().get(i).getNome());
		
		JButton btnPesquisaTecnico = new JButton("Pesquisar");
		btnPesquisaTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceTecnico.getSelectedIndex() == - 1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados com este perfil!");
				else
					imprimeCliente(panelPesquisaTecnico, livraria, choiceTecnico);
			}
		});
		btnPesquisaTecnico.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaTecnico.setBounds(223, 157, 127, 25);
		tecnico.add(btnPesquisaTecnico);
	}
	
	//Panel outros
	public static void outrosPanel(JPanel listaPanel, Livraria livraria) {
		JPanel outros = new JPanel();
		outros.setBackground(new Color(204, 204, 102));
		listaPanel.add(outros, "outrosTela");
		outros.setLayout(null);
		outros.add(voltarLista(listaPanel));
		
		JLabel lblOutros = new JLabel("Outros");
		lblOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 40));
		lblOutros.setBounds(223, 35, 127, 60);
		outros.add(lblOutros);
		
		Choice choiceOutros = new Choice();
		choiceOutros.setBounds(10, 121, 554, 20);
		outros.add(choiceOutros);
		
		JPanel panelPesquisaOutros = new JPanel();
		panelPesquisaOutros.setBackground(new Color(204, 204, 153));
		panelPesquisaOutros.setBounds(10, 214, 554, 326);
		outros.add(panelPesquisaOutros);
		panelPesquisaOutros.setLayout(null);
	
		for (int i = 0; i < livraria.getClientes().size(); i++) 
			if (livraria.getClientes().get(i).calculaPerfil() == 3)
				choiceOutros.add(livraria.getClientes().get(i).getNome());
		
		JButton btnPesquisaOutros = new JButton("Pesquisar");
		btnPesquisaOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (choiceOutros.getSelectedIndex() == - 1)
					JOptionPane.showMessageDialog(null, "Nao há clientes cadastrados com este perfil!");
				else
					imprimeCliente(panelPesquisaOutros, livraria, choiceOutros);
			}
		});
		btnPesquisaOutros.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		btnPesquisaOutros.setBounds(223, 157, 127, 25);
		outros.add(btnPesquisaOutros);	
	}
	
	//Mostra os clientes
	public static void imprimeCliente(JPanel panel, Livraria livraria, Choice lista) {
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
		nomeDoCliente.setBounds(77, 47, 547, 22);
		panel.add(nomeDoCliente);
		nomeDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		JLabel cepDoCliente = new JLabel((livraria.getClientes().get(lista.getSelectedIndex()).getCEP()));
		cepDoCliente.setBounds(77, 139, 407, 21);
		panel.add(cepDoCliente);
		cepDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
		
		JLabel cpfDoCliente = new JLabel(livraria.getClientes().get(lista.getSelectedIndex()).getCPF());
		cpfDoCliente.setBounds(77, 231, 417, 19);
		panel.add(cpfDoCliente);
		cpfDoCliente.setFont(new Font("Californian FB", Font.BOLD | Font.ITALIC, 18));
	}

}
