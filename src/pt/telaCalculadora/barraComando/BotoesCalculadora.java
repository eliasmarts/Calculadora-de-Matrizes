package pt.telaCalculadora.barraComando;

import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.comandos.barraComando.BotaoOperacao;
import pt.telaCalculadora.util.ButtonCommand;

public class BotoesCalculadora extends JPanel {
	public BotoesCalculadora(JTextField leitor) {
		super();
		
		adicionaBotoes(leitor);
		
		
	}
	
	
	private void adicionaBotoes(JTextField leitor) {
		add(new ButtonCommand("+", new BotaoOperacao(leitor, "+")));
		add(new ButtonCommand("-", new BotaoOperacao(leitor, "-")));
		add(new ButtonCommand("x", new BotaoOperacao(leitor, "*")));
		add(new ButtonCommand("÷", new BotaoOperacao(leitor, "/")));
		add(new ButtonCommand("(", new BotaoOperacao(leitor, "(")));
		add(new ButtonCommand(")", new BotaoOperacao(leitor, ")")));
		add(new ButtonCommand("det(A)", new BotaoOperacao(leitor, "det(")));
		add(new ButtonCommand("A²", new BotaoOperacao(leitor, "^(2)")));
	}
}
