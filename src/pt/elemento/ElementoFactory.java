package pt.elemento;

import pt.exceptions.ElementoInvalido;

public class ElementoFactory {
	public static IElemento criarOperavel(String representacao) {
		try {
		return new Numero(Integer.parseInt(representacao));
		}
		catch (NumberFormatException e) {
			throw new ElementoInvalido(representacao);
		}
	}
	
	
	public static IElemento criarOperavel(int valor) {
		return new Numero(valor);
	}
	
	
	public static IElemento criarOperavel(double valor) {
		return new Numero(valor);
	}
}
