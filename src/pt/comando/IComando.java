package pt.comando;

import javax.swing.JPanel;

import pt.telaCalculadora.IRCalculoMatriz;

public interface IComando extends IRCalculoMatriz {
	public void realizaComando(String comando, JPanel telaMat);
	
	
	public String getMsg();
}
