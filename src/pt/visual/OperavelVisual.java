package pt.visual;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import pt.elemento.IElemento;

public class OperavelVisual implements Visual {
	private IElemento op;
	JTextArea text;
	
	public OperavelVisual() {
		text = new JTextArea();
	}
	@Override
	public void draw(JFrame frame, int x, int y) {
		text.setText(op.getRepresentacao());
		
		text.setBounds(x, y, x + 10, y + 10);
		
		frame.add(text);
	}
	
	
	protected void connect(IElemento op) {
		this.op = op;
	}

}
