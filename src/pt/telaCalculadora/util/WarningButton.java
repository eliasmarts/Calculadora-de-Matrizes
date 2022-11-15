package pt.telaCalculadora.util;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

import pt.Configurations;

public class WarningButton extends JPanel implements MouseListener{
	private JLabel msg;
	Rectangle bound;
	Popup pop;
	PopupFactory pf;
	
	public WarningButton(String s) {
		super();
		
		msg = new JLabel(s);

		
		
		pf = new PopupFactory();
		add(new JLabel("!"));
		
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		revalidate();
		pop = pf.getPopup(getRootPane(), msg, this.getX(), 300);
		
		pop.show();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		pop.hide();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
