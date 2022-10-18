package pt.visual;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Texto implements Visual {
	private String str;
	JTextArea text;
	
	
	public Texto(String str) {
		this.str = str;
		text = new JTextArea(str);
	}
	@Override
	public void draw(JFrame frame, int x, int y) {
		text.setBounds(x, y, x + 20, y + 20);
		
		frame.add(text);
	}

}
