package pt.exceptions;

public class ErroDeTamanho extends OperacaoInvalida {
	private String matriz1, matriz2, operacao;
	private int tipoOperacao;
	
	public ErroDeTamanho() {
		this("");
	}
	
	
	public ErroDeTamanho(String operacao) {
		super();
		this.operacao = operacao;
		matriz1 = "";
		matriz2 = "";
		tipoOperacao = 0;
		motivo = "";
	}


	public void setMatriz1(String matriz1) {
		this.matriz1 = matriz1;
	}

	
	public void setMatriz2(String matriz2) {
		this.matriz2 = matriz2;
	}

	
	

	
	public void setTipoOperacao(int tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
	@Override
	public String getMessage() {
		String message = "Erro de tamanho";
		
		if (operacao != "") {
			message += ": A operacao " + operacao + " nao pode ser aplicada";
			if (matriz2 != "" && matriz1 != "") {
				message += "entre as matrizes"
						+ matriz1 + "e" + matriz2;
			}
			else if (matriz1 != "") {
				message += "na matriz" + matriz1;
			}
			
		}
		
		message += "%n" + motivo;
		
		return message;
	}
}
