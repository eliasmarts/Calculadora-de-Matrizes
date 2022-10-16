package pt.visual;

import java.io.PrintStream;

import pt.elemento.IElemento;

public class OperavelVisual implements Visual {
	private IElemento op;
	@Override
	public void draw(PrintStream out) {
		out.print(op.getRepresentacao());
	}
	
	
	protected void connect(IElemento op) {
		this.op = op;
	}

}
