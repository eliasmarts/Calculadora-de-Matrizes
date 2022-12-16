package pt.telaCalculadora.menu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.comandos.menu.CloseDialog;
import pt.comandos.menu.SetPrecisao;
import pt.telaCalculadora.util.ButtonCommand;
import pt.telaCalculadora.util.TextFieldCommand;

public class LeitorPrecisaoDecimal extends JDialog {
	public LeitorPrecisaoDecimal(JFrame frame) {
		super(frame, "Precisao Decimal");
		
		setLayout(new FlowLayout());
		add(new JLabel("Precisao decimal: "));

		TextFieldCommand leitor = new TextFieldCommand(2);
		
		leitor.setComando(new SetPrecisao(leitor, this));
		
		
		add(leitor);
		
		JButton button = new ButtonCommand("OK", new CloseDialog(this));
		
		button.addActionListener(leitor);

		add(button);
		
		pack();
	}
}
