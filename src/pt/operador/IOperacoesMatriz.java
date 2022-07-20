package pt.operador;

public interface IOperacoesMatriz {
	public String[][] realizarOperacao(String operacao, char matriz1, char matriz2);
	
	
	public String[][] realizarOperacao(String operacao, String[][] matriz1, String[][] matriz2);
}
