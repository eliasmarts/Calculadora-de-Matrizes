package pt.comandos.menu;

import javax.swing.JDialog;
import javax.swing.JTextField;

import pt.Configurations;
import pt.comandos.Command;
import pt.exceptions.ComandoInvalido;

public class SetPrecisao implements Command {
	private JTextField font;
	private JDialog dialog;
	
	
	public SetPrecisao(JTextField font, JDialog dialog) {
		this.font = font;
		this.dialog = dialog;
	}


	@Override
	public void execute() {
		try {
			int i = Integer.parseInt(font.getText());
			Configurations.setDecimalPrecision(i);
			dialog.setVisible(false);
		} catch (NumberFormatException e) {
			throw new ComandoInvalido(font.getText() + " nao e numero");
		}
	}

}
