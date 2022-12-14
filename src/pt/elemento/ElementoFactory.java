package pt.elemento;

import pt.Configurations;
import pt.exceptions.ElementoInvalido;
import pt.util.FuncoesString;

public class ElementoFactory {
	private static final int INTEIRO = 0, DOUBLE = 1, ERRO = -1;
	
	
	public static IElemento criarOperavel(String representacao) {
		int tipo = getTipo(representacao);
		
		IElemento el = null;
		
		if (tipo == ERRO)
			throw new ElementoInvalido(representacao);
		
		if (Configurations.getDecimalDivisor() == ',')
			representacao = FuncoesString.substitute(representacao, ",", ".");
		
		switch (tipo) {
		case INTEIRO:
			el = new Numero(Integer.parseInt(representacao));
			break;
		case DOUBLE:
			el = new Numero(Double.parseDouble(representacao));
			break;

		default:
			break;
		}
		
		
		return el;
	}
	
	
	private static int getTipo(String representacao) {
		int tipo = INTEIRO;
		boolean ponto = false;
		char decimalDivisor = Configurations.getDecimalDivisor();
		
		if (representacao.length() == 0)
			return ERRO;
		
		for (int i = 0; i < representacao.length(); i++) {
			if (representacao.charAt(i) == decimalDivisor) {
				tipo = DOUBLE;
				if (ponto) {
					return ERRO;
				}
			}
			else if (!Character.isDigit(representacao.charAt(i))) {
				return ERRO;
			}
		}
		
		return tipo;
	}
	
	
	public static IElemento criarOperavel(int valor) {
		return new Numero(valor);
	}
	
	
	public static IElemento criarOperavel(double valor) {
		return new Numero(valor);
	}
}
