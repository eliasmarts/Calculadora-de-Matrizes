package pt.telaCalculadora.barraComando;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.comandos.Command;
import pt.comandos.barraComando.ComandoExpressao;
import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ErroCalculadora;
import pt.telaCalculadora.TelaCalculadora;
import pt.telaCalculadora.util.TextFieldCommand;
import pt.visual.IVisualFactory;

public class BarraDeComando extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Command comando;
	private TextFieldCommand leitor;
	private JButton botao;
	private JLabel texto;


	public BarraDeComando(TelaCalculadora tela, ICalculoMatriz controle, IVisualFactory visFac) {
		super();
		leitor = new TextFieldCommand(50);
		leitor.setFont(new Font("Arial", Font.BOLD, 15));
		botao = new JButton("=");
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new BotoesCalculadora(leitor, tela));
		
		botao.addActionListener(leitor);
		
		comando = new ComandoExpressao(controle, visFac, leitor, tela);
		
		leitor.setComando(comando);

		texto = new JLabel("Digite sua expressao");
		
		add(texto);
		add(criaLinhaBaixo());
	}

	
	private JPanel criaLinhaBaixo() {
		JPanel linhaBaixo;
		linhaBaixo = new JPanel();
		linhaBaixo.setLayout(new FlowLayout());
		linhaBaixo.add(leitor);
		linhaBaixo.add(botao);
		
		return linhaBaixo;
	}

	

}
