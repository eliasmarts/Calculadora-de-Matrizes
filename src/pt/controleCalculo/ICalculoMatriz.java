package pt.controleCalculo;

public interface ICalculoMatriz {
	/**
	 * Realiza um comando, que pode ser calculo e atribuicao
	 * @param expressao a expressao que representa o comando
	 */
	public void realizarExpressao(String expressao);
	
	
	/**
	 * 
	 * @param nome a letra de 'A' a 'Z' que representa a matriz
	 * @return a representacao da matriz
	 */
	public String[][] getMatriz(char nome);
}
