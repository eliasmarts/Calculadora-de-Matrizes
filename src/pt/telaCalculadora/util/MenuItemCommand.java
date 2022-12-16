package pt.telaCalculadora.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import pt.comandos.Command;

public class MenuItemCommand extends JMenuItem implements ActionListener {
	private Command comando;
	
	public MenuItemCommand(String text) {
		super(text);
		addActionListener(this);
	}
	
	public MenuItemCommand(String text, Command comando) {
		this(text);
		this.comando = comando;
	}

	public void setComando(Command comando) {
		this.comando = comando;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comando.execute();
	}
	
	
}
