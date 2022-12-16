package pt.comandos.menu;

import javax.swing.JDialog;

import pt.comandos.Command;

public class CloseDialog implements Command {
	private JDialog dialog;
	
	
	
	public CloseDialog(JDialog dialog) {
		this.dialog = dialog;
	}



	@Override
	public void execute() {
		dialog.setVisible(false);
	}

}
