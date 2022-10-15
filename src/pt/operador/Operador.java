package pt.operador;

import java.util.Map;
import java.util.Set;

import pt.matriz.IOperacoesStrategy;

public class Operador implements IOperador {
	private static final Operador instance = new Operador();
	
	private Operador() {
		
	}
	
	
	public static Operador getInstance() {
		return instance;
	}
	
	
	@Override
	public IOperacoesStrategy somar(IOperacoesStrategy op1, IOperacoesStrategy op2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesStrategy subtrair(IOperacoesStrategy op1, IOperacoesStrategy op2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesStrategy multiplicar(IOperacoesStrategy op1, IOperacoesStrategy op2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesStrategy dividir(IOperacoesStrategy op1, IOperacoesStrategy op2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesStrategy inverso(IOperacoesStrategy op1) {
		// TODO Auto-generated method stub
		return null;
	}

}
