package pt.exceptions;

public class OperacaoInvalida extends ErroDeCalculo {
	protected String operacao;
	
	
	public OperacaoInvalida() {
		super();
	}
	
	
	public OperacaoInvalida(String message) {
		super();
		this.motivo = message;
	}
	
	
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	
	@Override
	public String getMessage() {
		return motivo;
	}
}
