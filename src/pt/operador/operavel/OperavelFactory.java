package pt.operador.operavel;

public class OperavelFactory {
	public static IOperavel criarOperavel(String representacao) {
		return new Numero(Integer.parseInt(representacao));
	}
}
