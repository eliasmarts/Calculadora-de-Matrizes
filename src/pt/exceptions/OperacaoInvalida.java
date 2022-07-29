package pt.exceptions;

public class OperacaoInvalida extends ErroDeCalculo {
	private String message;
	protected String operacao;
	
	
	public OperacaoInvalida() {
		super();
	}
	
	
	public OperacaoInvalida(String message) {
		super();
		this.message = message;
	}
	
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
}
