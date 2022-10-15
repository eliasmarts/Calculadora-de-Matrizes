package pt.visual;

import java.io.PrintStream;

public class Texto implements Imprimivel {
	private String str;
	
	
	public Texto(String str) {
		this.str = str;
	}
	@Override
	public void draw(PrintStream out) {
		out.print(str);
	}

}
