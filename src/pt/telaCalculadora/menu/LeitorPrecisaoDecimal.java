package pt.telaCalculadora.menu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.Configurations;
import pt.comandos.menu.CloseDialog;
import pt.comandos.menu.SetPrecisao;
import pt.telaCalculadora.util.ButtonCommand;
import pt.telaCalculadora.util.TextFieldCommand;

public class LeitorPrecisaoDecimal extends JDialog {
	private TextFieldCommand leitor;
	
	public LeitorPrecisaoDecimal(JFrame frame) {
		super(frame, "Precisao Decimal");
		
		setLayout(new FlowLayout());
		add(new JLabel("Precisao decimal: "));

		leitor = new TextFieldCommand(2);
		
		leitor.setText(Integer.toString(Configurations.getDecimalPrecision()));
		
		leitor.setComando(new SetPrecisao(leitor, this));
		
		leitor.setCaretPosition(leitor.getText().length());
		
		
		
		add(leitor);
		
		JButton button = new ButtonCommand("OK", new CloseDialog(this));
		
		button.addActionListener(leitor);

		add(button);
		
		pack();
	}
	
	@Override
	public void setVisible(boolean value) {
		if (value == true) {
			leitor.requestFocusInWindow();
			
			leitor.setText(Integer.toString(Configurations.getDecimalPrecision()));
			
			leitor.setComando(new SetPrecisao(leitor, this));
			
			leitor.setCaretPosition(leitor.getText().length());
		}
		
		super.setVisible(value);
	}
}
