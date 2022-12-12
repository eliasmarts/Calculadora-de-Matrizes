package pt.telaCalculadora.util;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;

import pt.Configurations;
import pt.comandos.Command;
import pt.exceptions.ErroCalculadora;

public class TextFieldCommand extends JTextField implements ActionListener {
	private static final PopupFactory pf = new PopupFactory();
	
	private Command comando;
	private Popup pop;
	private boolean popActive;
	

	public TextFieldCommand() {
		super();
		addActionListener(this);
		
		addKeyListener(new KeyListenerCommand(this));
		popActive = false;
	}
	
	
	public TextFieldCommand(int size) {
		super(size);
		addActionListener(this);
		popActive = false;
	}
	
	
	public void setComando(Command comando) {
		this.comando = comando;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			comando.execute();
			setBackground(Color.white);
			if (popActive) {
				pop.hide();
				popActive = false;
			}
		}
		catch (ErroCalculadora e) {
			setBackground(Configurations.COR_ERRO);
			
			if (popActive) {
				pop.hide();
			}
			JRootPane root = getRootPane();
			
			Point p = SwingUtilities.convertPoint(getParent(), getX(), getY(), root);
			
			pop = pf.getPopup(getRootPane(), new WarningMessage(e.getHTMLMessage()), p.x, p.y);
			
			pop.show();
			
			popActive = true;
			
		}
		catch (Exception e) {
			setBackground(Configurations.COR_ERRO);
			
			if (popActive) {
				pop.hide();
			}
			JRootPane root = getRootPane();
			
			Point p = SwingUtilities.convertPoint(getParent(), getX(), getY(), root);
			
			pop = pf.getPopup(getRootPane(), new WarningMessage(e.getMessage()), p.x, p.y);
			
			pop.show();
			
			popActive = true;
			
			e.printStackTrace();
		}
	}
}
