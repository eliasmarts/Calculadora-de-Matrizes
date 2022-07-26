package pt.avaliador;

import pt.exceptions.ExpressaoInvalida;

public interface IAvaliaExpressao {
	public final int ATRIBUICAO = 0;
	public final int COMPARACAO = 1;
	public final int CALCULO = 2;
	
	
	public int getTipoExpressao(String expressao) throws ExpressaoInvalida;
	
	
	/**
	 * Separa uma expressao
	 * @param expressao a expressao
	 * @return vetor onde cada posicao contem um numero, uma matriz
	 * ou uma operacao
	 */
	public String[] separaExpressao(String expressao) throws ExpressaoInvalida;
	
	
	public String[] converterPraPosFixa(String[] expressaoInfixa) throws ExpressaoInvalida;
}
