package pt.exceptions;

public class OperacaoInvalida extends ErroCalculadora {
	protected String operacao;
	
	
	public OperacaoInvalida() {
		super();
	}
	
	
	public OperacaoInvalida(String message) {
		super();
		this.msg = message;
	}
	
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
}
