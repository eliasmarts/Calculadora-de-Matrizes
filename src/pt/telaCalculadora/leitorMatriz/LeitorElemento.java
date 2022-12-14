package pt.telaCalculadora.leitorMatriz;

import java.awt.Color;
import java.awt.event.ActionEvent;

import pt.Configurations;
import pt.comandos.SetValor;
import pt.exceptions.ElementoInvalido;
import pt.telaCalculadora.util.AnyKeyAction;
import pt.telaCalculadora.util.TextFieldCommand;

public class LeitorElemento extends TextFieldCommand {

	public LeitorElemento(TelaLeitores t, int x, int y) {
		super();
		
		setComando(new SetValor(t.getM(), x, y, this));
		
		atualiza(t, x, y);
		
		addKeyListener(new AnyKeyAction(this));
	}

	
	public void atualiza(TelaLeitores t, int x, int y) {
		setText(t.getM().getValores()[x][y].getRepresentacao());
	}
}
