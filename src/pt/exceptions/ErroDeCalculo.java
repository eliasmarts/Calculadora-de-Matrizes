package pt.exceptions;

public class ErroDeCalculo extends RuntimeException {
	protected String motivo;
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public ErroDeCalculo() {
		super();
	}

	public String getMotivo() {
		return motivo;
	}
	
	public String getMessage() {
		return motivo;
	}
}
