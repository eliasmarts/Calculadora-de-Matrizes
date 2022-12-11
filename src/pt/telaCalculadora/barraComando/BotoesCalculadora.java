package pt.telaCalculadora.barraComando;

import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.comandos.barraComando.BotaoOperacao;
import pt.telaCalculadora.TelaCalculadora;
import pt.telaCalculadora.util.ButtonCommand;
import pt.telaCalculadora.util.WarningButton;

public class BotoesCalculadora extends JPanel {
	public BotoesCalculadora(JTextField leitor, TelaCalculadora tela) {
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
		add(new ButtonCommand("<html>A<sup>2</sup></html>", new BotaoOperacao(leitor, "^(2)")));
		add(new ButtonCommand("<html>A<sup>-1</sup></html>", new BotaoOperacao(leitor, "^(-1)")));
	}
}
