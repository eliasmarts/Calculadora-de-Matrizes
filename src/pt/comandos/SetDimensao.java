package pt.comandos;

import javax.swing.JTextField;

import pt.matriz.IMatriz;
import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;

public class SetDimensao implements Command {
	private IMatriz m;
	private JTextField leitor;
	private char dim;
	private LeitorDeMatriz leitorM;
	

	public SetDimensao(IMatriz m, JTextField leitor, LeitorDeMatriz leitorM, char dim) {
		this.m = m;
		this.leitor = leitor;
		this.dim = dim;
		this.leitorM = leitorM;
	}


	@Override
	public void execute() {
		int linhas = Integer.valueOf(leitor.getText());
		
		if (dim == 'x')
			m.setLinhas(linhas);
		else
			m.setColunas(linhas);
	
		leitorM.atualiza();
	}

}
