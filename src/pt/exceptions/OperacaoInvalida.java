package pt.exceptions;

public class OperacaoInvalida extends ErroDeCalculo {
	private String message;
	
	
	public OperacaoInvalida() {
		super();
	}
	
	
	public OperacaoInvalida(String message) {
		super();
		this.message = message;
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
}
