package pt.comandos;

import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;
import pt.telaCalculadora.leitorMatriz.LeitorElementoDivisor;

public class PasteDivisor implements Command {
	private boolean control;
	private LeitorElementoDivisor leitor;
	private LeitorDeMatriz lei;
	private String ant;
	
	
	public PasteDivisor(LeitorElementoDivisor leitor, LeitorDeMatriz lei) {
		this.leitor = leitor;
		
		control = false;
		
		this.lei = lei;
	}

	@Override
	public void execute() {
		String pasted = leitor.getText();
		leitor.setText("");
		
		String[] linhas = pasted.split("\n");
		
		int numLinhas, numColunas = 0;
		
		numLinhas = linhas.length;
		
		String[][] valores = new String[numLinhas][];
		
		for (int i = 0; i < numLinhas; i++) {
			valores[i] = linhas[i].split(" ");
			
			if (valores[i].length > numColunas)
				numColunas = valores[i].length;
		}
		// TODO problema: o JTEXTFIELD n detecta /n
		
		lei.setLinhas(numLinhas);
		lei.setColunas(numColunas);
		
		for (int i = 0; i < numLinhas; i++) {
			for (int j = 0; j < numColunas; j++)
				lei.setValor(valores[i][j], i, j);
		}

	}

}
