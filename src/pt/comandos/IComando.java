package pt.comandos;

import pt.telaCalculadora.IRCalculoMatriz;
import pt.telaCalculadora.IRVisualFactory;
import pt.telaCalculadora.TelaCalculadora;

public interface IComando extends IRCalculoMatriz, IRVisualFactory {
	public void realizaComando(String comando, TelaCalculadora tela);
	
	
	public String getMsg();
}
