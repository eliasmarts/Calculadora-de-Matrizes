package pt.separador;

public interface IAvaliaExpressao {
	/**
	 * Checa a validade de uma expressao
	 * @param expressao a expressao
	 * @return "valido" se for valido, se nao retorna 
	 * um texto descrevendo o erro
	 */
	public String checarValidade(String expressao);
	
	
	/**
	 * Separa uma expressao
	 * @param expressao a expressao
	 * @return vetor onde cada posicao contem um numero, uma matriz
	 * ou uma operacao
	 */
	public String[] separaExpressao(String expressao);
	
	
	public String[] converterPraPosFixa(String[] expressaoInfixa);
}
