package pt.comandos;

import javax.swing.JTextField;

import pt.matriz.IMatriz;

public class SetValor implements Command {
	private IMatriz m;
	private int i, j;
	private JTextField leitor;
	
	

	public SetValor(IMatriz m, int i, int j, JTextField leitor) {
		this.m = m;
		this.i = i;
		this.j = j;
		this.leitor = leitor;
	}



	@Override
	public void execute() {
		m.setElemento(i, j, leitor.getText());
	}

}
