package pt.telaCalculadora.util;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pt.Configurations;
import pt.comandos.Command;

public class TextFieldCommand extends JTextField implements ActionListener {
	private Command comando;

	public TextFieldCommand() {
		super();
		addActionListener(this);
	}
	
	
	public TextFieldCommand(int size) {
		super(size);
		addActionListener(this);
	}
	
	public void setComando(Command comando) {
		this.comando = comando;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			comando.execute();
			setBackground(Color.white);
		}
		catch (Exception e) {
			setBackground(Configurations.COR_ERRO);
			e.printStackTrace();
		}
	}
}
