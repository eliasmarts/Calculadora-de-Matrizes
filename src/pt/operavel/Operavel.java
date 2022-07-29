package pt.operavel;

import pt.exceptions.ErroDeTipo;
import pt.matriz.IMatriz;
import pt.matriz.IOperacoesStrategy;

public abstract class Operavel implements IOperavel {
	@Override
	public IOperacoesStrategy somarOp(IOperacoesStrategy op) {
		return op.somar(this);
	}

	@Override
	public IOperacoesStrategy subtrairOp(IOperacoesStrategy op) {
		return op.subtrair(this).negativo();
	}

	@Override
	public IOperacoesStrategy multiplicarOp(IOperacoesStrategy op) {
		return op.multiplicar(this);
	}

	@Override
	public IOperacoesStrategy somar(IMatriz matriz) {
		ErroDeTipo erro = new ErroDeTipo("numero", "matriz");
		erro.setOperacao("+");
		throw erro;
	}

	@Override
	public IOperacoesStrategy somar(IOperavel operavel) {
		return operavel.somar(this);
	}

	@Override
	public IOperacoesStrategy subtrair(IMatriz matriz) {
		ErroDeTipo erro = new ErroDeTipo("numero", "matriz");
		erro.setOperacao("-");
		throw erro;
	}

	@Override
	public IOperacoesStrategy subtrair(IOperavel operavel) {
		return operavel.subtrair(this);
	}

	@Override
	public IOperacoesStrategy multiplicar(IMatriz matriz) {
		return matriz.multiplicar(this);
	}

	@Override
	public IOperacoesStrategy multiplicar(IOperavel operavel) {
		return operavel.multiplicar(this);
	}

}
