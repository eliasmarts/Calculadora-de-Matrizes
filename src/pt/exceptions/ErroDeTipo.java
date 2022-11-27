package pt.exceptions;

public class ErroDeTipo extends OperacaoInvalida {
	private String tipo1, tipo2;

	public ErroDeTipo(String tipo1, String tipo2) {
		super();
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}

	public ErroDeTipo(String tipo1) {
		this(tipo1, "");
	}


	public ErroDeTipo() {
		this("", "");
	}

	
	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	
	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}
	
	
	@Override
	public String getMessage() {
		String message = "";
		
		if (operacao != "")
			message += "A operacao " + operacao + " nao pode ser aplicada ";
		
		if (tipo2 != "")
			message += " entre " + tipo1 + " e " + tipo2;
		
		else if (tipo1 != "")
			message += " em " + tipo1;
		
		return message;
	}
}
