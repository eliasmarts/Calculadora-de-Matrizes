package pt.operador;


import java.util.Map;

import pt.matriz.IOperavel;
import pt.operador.operacao.*;

public class Operador implements IOperador {
	private static final Operador instance = new Operador();
	
	private Map<String, Operacao> operacoes;
	
	private Operador() {
		operacoes = Map.of(
				"+", new Soma(),
				"-", new Subtracao(),
				"*", new Multiplicacao(),
				"--", new Negativo(),
				"/", new Divisao(),
				"det", new Determinante(),
				"^", new Potencia()
				);
				
	}
	
	
	public static Operador getInstance() {
		return instance;
	}


	@Override
	public IOperavel realizarOperacao(String operacao, IOperavel op) {
		if (operacao == "-")
			operacao = "--";
		
		return operacoes.get(operacao).realizarOperacao(op, null);
	}


	@Override
	public IOperavel realizarOperacao(String operacao, IOperavel op1, IOperavel op2) {
		return operacoes.get(operacao).realizarOperacao(op1, op2);
	}
	
	
	
}
