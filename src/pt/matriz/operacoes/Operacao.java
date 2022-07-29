package pt.matriz.operacoes;

import pt.matriz.IMatriz;

public abstract class Operacao {
	private int prioridade;
	private String representacao;
	
	public abstract boolean isUnaria();
	
	public abstract boolean isBinaria();
	
	public abstract IMatriz realizarOperacao(IMatriz matriz1);
	
	public abstract IMatriz realizarOperacao(IMatriz matriz1, IMatriz matriz2);
}
