package pt.controleCalculo;

import javax.swing.JComponent;

import pt.matriz.IMatriz;
import pt.matriz.IOperavel;

public interface ICalculoMatriz {
	/**
	 * Realiza um comando, que pode ser calculo e atribuicao
	 * @param expressao a expressao que representa o comando
	 */
	public IOperavel realizarExpressao(String expressao);
	
	
	/**
	 * 
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @return a representacao da matriz
	 */
	public IMatriz getMatriz(char nome);
	
	
	public void criaMatriz(char nome);
	
	
	/**
	 * armazena uma matriz
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @param matriz a representacao da matriz
	 */
	public void armazenaMatriz(char nome, String[][] matriz);
}
