package pt.controleCalculo;

import pt.operador.IOperacoesMatriz;
import pt.separador.IAvaliaExpressao;

public class ControleCalculo implements IControleCalculo {
	private IOperacoesMatriz operador;

	@Override
	public void realizarExpressao(String expressao) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[][] getMatriz(char nome) {
		return operador.getMatriz(nome);
	}
	
	@Override
	public void armazenaMatriz(char nome, String[][] matriz) {
		operador.armazenaMatriz(nome, matriz);
		
	}

	@Override
	public void connect(IAvaliaExpressao avaliador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect(IOperacoesMatriz operador) {
		this.operador = operador;
	}

	

}
