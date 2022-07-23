package pt.exceptions;

public class OperacaoInvalida extends RuntimeException {
	private String message;
	
	
	public OperacaoInvalida(String message) {
		this.message = message;
	}
	
	
	@Override
	public String getMessage() {
		return message;
	}
}
