package pt.comandos;

import javax.swing.JTextField;

import pt.Configurations;
import pt.exceptions.ComandoInvalido;
import pt.exceptions.ErroCalculadora;
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
		try {
			int linhas = Integer.valueOf(leitor.getText());
			
			if (linhas < 0 || linhas > Configurations.MAX_SIZE)
				throw new ComandoInvalido("Tamanhos validos: 0 < x < " + String.valueOf(Configurations.MAX_SIZE));
			
			if (dim == 'x')
				m.setLinhas(linhas);
			else
				m.setColunas(linhas);
		
			leitorM.atualiza();
		}
		catch (NumberFormatException e) {
			throw new ErroCalculadora("'" + leitor.getText() + "' nao e um numero.");
		}
	}

}
