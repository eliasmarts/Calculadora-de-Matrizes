package pt.operavel;

public class OperavelFactory {
	public static IOperavel criarOperavel(String representacao) {
		return new Numero(Integer.parseInt(representacao));
	}
	
	
	public static IOperavel criarOperavel(int valor) {
		return new Numero(valor);
	}
	
	
	public static IOperavel criarOperavel(double valor) {
		return new Numero(valor);
	}
}
