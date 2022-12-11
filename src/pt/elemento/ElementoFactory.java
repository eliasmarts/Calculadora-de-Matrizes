package pt.elemento;

import pt.exceptions.ElementoInvalido;

public class ElementoFactory {
	private static final int INTEIRO = 0, DOUBLE = 1, ERRO = -1;
	
	
	public static IElemento criarOperavel(String representacao) {
		int tipo = getTipo(representacao);
		
		IElemento el = null;
		
		switch (tipo) {
		case ERRO:
			throw new ElementoInvalido(representacao);
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
		
		for (int i = 0; i < representacao.length(); i++) {
			if (representacao.charAt(i) == '.') {
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
