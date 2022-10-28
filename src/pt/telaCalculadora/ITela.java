package pt.telaCalculadora;

import javax.swing.JComponent;

public interface ITela extends IRCalculoMatriz, IRComando, IRVisualFactory {
	public void iniciar();
	
	
	public void encerrar();
}
