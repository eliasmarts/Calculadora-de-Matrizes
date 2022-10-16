package pt.elemento;

public class ElementoFactory {
	public static IElemento criarOperavel(String representacao) {
		return new Numero(Integer.parseInt(representacao));
	}
	
	
	public static IElemento criarOperavel(int valor) {
		return new Numero(valor);
	}
	
	
	public static IElemento criarOperavel(double valor) {
		return new Numero(valor);
	}
}
