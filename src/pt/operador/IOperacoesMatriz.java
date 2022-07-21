package pt.operador;

public interface IOperacoesMatriz {
	public String[][] realizarOperacao(String operacao, char matriz1, char matriz2);
	
	
	public String[][] realizarOperacao(String operacao, String[][] matriz1, String[][] matriz2);
	
	
	/**
	 * armazena uma matriz
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @param matriz a representacao da matriz
	 */
	public void armazenaMatriz(char nome, String[][] matriz);
	
	
	/**
	 * 
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @return a representacao da matriz
	 */
	public String[][] getMatriz(char nome);
}
