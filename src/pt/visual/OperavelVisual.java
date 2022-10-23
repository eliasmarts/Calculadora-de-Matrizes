package pt.visual;

import javax.swing.JFrame;
import javax.swing.JLabel;

import pt.elemento.IElemento;

public class OperavelVisual extends JLabel implements Visual {
	private IElemento op;
	
	public OperavelVisual() {
		super();
	}
	
	
	public void connect(IElemento op) {
		this.op = op;
		
		
		setText(op.getRepresentacao());
		setVisible(true);
		setBorder(getBorder());
		repaint();
	}

}
