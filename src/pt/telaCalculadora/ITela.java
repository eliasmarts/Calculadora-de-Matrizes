package pt.telaCalculadora;

public interface ITela extends IRCalculoMatriz, IRComando, IRVisualFactory {
	public void iniciar();
	
	
	public void encerrar();
}
