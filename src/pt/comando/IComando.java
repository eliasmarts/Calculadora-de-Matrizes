package pt.comando;

import javax.swing.JPanel;

import pt.telaCalculadora.IRCalculoMatriz;
import pt.telaCalculadora.IRVisualFactory;

public interface IComando extends IRCalculoMatriz, IRVisualFactory {
	public void realizaComando(String comando, JPanel telaMat);
	
	
	public String getMsg();
}
