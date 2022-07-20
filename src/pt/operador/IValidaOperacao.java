package pt.operador;

import pt.separador.MatrizVirtual;

public interface IValidaOperacao {
	/**
	 * checa se uma operacao e valida.
	 * @param operacao
	 * @param matriz
	 * @return "valido" se for valida, se nao for retorna o tipo de erro
	 */
	public String isValida(String operacao, MatrizVirtual matriz);

	
	public String isValida(String operacao, MatrizVirtual matriz1, MatrizVirtual matriz2);
}
