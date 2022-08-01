package pt.controleCalculo;

public class RespostaTexto implements Resposta {
	private String texto;

	public RespostaTexto(String texto) {
		super();
		this.texto = texto;
	}

	@Override
	public String getTipo() {
		return "texto";
	}
	
	public String toString() {
		return texto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
