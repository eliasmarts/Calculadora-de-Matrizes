package pt.telaCalculadora.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import pt.comandos.Command;

public class ActionCommand extends AbstractAction {
	private Command comando;
	

	public ActionCommand(Command comando) {
		this.comando = comando;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		comando.execute();
	}

}
