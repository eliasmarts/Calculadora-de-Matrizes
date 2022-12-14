package pt.telaCalculadora.BotoesLeitores;

import pt.comandos.botoesLeitores.AdicionaBotaoLeitor;
import pt.telaCalculadora.util.AnyKeyAction;
import pt.telaCalculadora.util.TextFieldCommand;

public class NovoBotao extends TextFieldCommand {
	public NovoBotao(BotoesLeitores b) {
		super(1);
		
		setComando(new AdicionaBotaoLeitor(b, this));
		
		addKeyListener(new AnyKeyAction(this));
	}
}
