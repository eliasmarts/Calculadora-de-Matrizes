package pt.visual;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Texto extends JLabel implements Visual {
	private static final long serialVersionUID = 1L;
	private String str;
	JTextArea text;
	
	
	public Texto(String str) {
		super();
		setText(str);
	}

}
