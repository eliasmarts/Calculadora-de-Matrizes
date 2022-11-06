package pt.telaCalculadora;

import javax.swing.JComponent;

public interface ITela extends IRCalculoMatriz, IRVisualFactory {
	public void iniciar();
	
	
	public void encerrar();
}
