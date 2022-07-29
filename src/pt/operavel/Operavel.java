package pt.operavel;

import pt.matriz.IMatriz;
import pt.matriz.IOperacoes;

public abstract class Operavel implements IOperavel {
	@Override
	public IOperacoes somarOp(IOperacoes op) {
		return op.somar(this);
	}

	@Override
	public IOperacoes subtrairOP(IOperacoes op) {
		return op.subtrair(this).negativo();
	}

	@Override
	public IOperacoes multiplicarOp(IOperacoes op) {
		return op.multiplicar(this);
	}

	@Override
	public IOperacoes somar(IMatriz matriz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoes somar(IOperavel operavel) {
		return operavel.somar(this);
	}

	@Override
	public IOperacoes subtrair(IMatriz matriz) {
		return null;
	}

	@Override
	public IOperacoes subtrair(IOperavel operavel) {
		return operavel.subtrair(this);
	}

	@Override
	public IOperacoes multiplicar(IMatriz matriz) {
		return matriz.multiplicar(this);
	}

	@Override
	public IOperacoes multiplicar(IOperavel operavel) {
		return operavel.multiplicar(this);
	}

}
