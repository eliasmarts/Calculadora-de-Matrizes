package pt.comandos.menu;

import javax.swing.JDialog;

import pt.comandos.Command;

public class ShowJDialog implements Command {
	private JDialog dialog;

	
	
	public ShowJDialog(JDialog dialog) {
		this.dialog = dialog;
	}



	@Override
	public void execute() {
		dialog.setVisible(true);
	}

}
