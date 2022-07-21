package pt.operador;

import java.util.HashMap;
import java.util.Map;

import pt.separador.MatrizVirtual;

public class Operador implements IOperador {
	private Map<Character, String[][]> matrizes;
	
	
	public Operador() {
		matrizes = new HashMap<Character, String[][]>();
	}

	@Override
	public String[][] realizarOperacao(String operacao, char matriz1, char matriz2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] realizarOperacao(String operacao, String[][] matriz1, String[][] matriz2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isValida(String operacao, MatrizVirtual matriz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String isValida(String operacao, MatrizVirtual matriz1, MatrizVirtual matriz2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void armazenaMatriz(char nome, String[][] matriz) {
		matrizes.put(nome, matriz);
	}

	@Override
	public String[][] getMatriz(char nome) {
		return matrizes.get(nome);
	}

}
