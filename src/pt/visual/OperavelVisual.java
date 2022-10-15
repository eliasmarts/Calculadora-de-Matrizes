package pt.visual;

import java.io.PrintStream;

import pt.operavel.IOperacoesElemento;

public class OperavelVisual implements Imprimivel {
	private IOperacoesElemento op;
	@Override
	public void draw(PrintStream out) {
		out.print(op.getRepresentacao());
	}
	
	
	protected void connect(IOperacoesElemento op) {
		this.op = op;
	}

}
