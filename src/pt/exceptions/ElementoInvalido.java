package pt.exceptions;

public class ElementoInvalido extends ErroCalculadora {
	private String elemento;
	

	public ElementoInvalido() {
		super();
	}
	
	public ElementoInvalido(String elemento) {
		super();
		
		this.elemento = elemento;
	}
	
	
	public String getMessage() {
		return "Erro '" + elemento + "' nao pode ser convertido";
	}
}
