package pt.telaCalculadora.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pt.comandos.Command;

public class ButtonCommand extends JButton implements ActionListener {
	private Command comando;
	
	public ButtonCommand() {
		super();
		addActionListener(this);
	}


	public ButtonCommand(String txt, Command comando) {
		super(txt);
		this.comando = comando;
		addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		comando.execute();
	}
	
	
}
