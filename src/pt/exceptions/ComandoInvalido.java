package pt.exceptions;

public class ComandoInvalido extends ErroCalculadora {
	public ComandoInvalido() {
		super();
	}
	
	public ComandoInvalido(String msg) {
		this.msg = msg;
	}
}
