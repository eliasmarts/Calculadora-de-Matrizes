package pt.comandos.barraComando;

import javax.swing.JTextField;

import pt.comandos.Command;

public class BotaoOperacao implements Command {
	
	private JTextField dest;
	private String txt;
	
	
	public BotaoOperacao(JTextField dest, String txt) {
		this.dest = dest;
		this.txt = txt;
	}


	@Override
	public void execute() {
		dest.setText(dest.getText() + txt);
	}

}
