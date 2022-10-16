package pt.controleCalculo;

import pt.visual.Visual;

public interface ICalculoMatriz {
	/**
	 * Realiza um comando, que pode ser calculo e atribuicao
	 * @param expressao a expressao que representa o comando
	 */
	public Visual realizarExpressao(String expressao);
	
	
	/**
	 * 
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @return a representacao da matriz
	 */
	public Visual getMatriz(char nome);
	
	
	/**
	 * armazena uma matriz
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @param matriz a representacao da matriz
	 */
	public void armazenaMatriz(char nome, String[][] matriz);
}
