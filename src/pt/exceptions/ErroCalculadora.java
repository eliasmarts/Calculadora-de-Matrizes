package pt.exceptions;

public class ErroCalculadora extends RuntimeException {
	protected String msg;
	
	public void setMotivo(String msg) {
		this.msg = msg;
	}

	public ErroCalculadora() {
		super();
	}
	
	
	public ErroCalculadora(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
	
	
	public String getHTMLMessage() {
		String resp = "<html> ! ";
		String msg = getMessage();
		
		
		
		if (msg != null) {
			for (int i = 0; i < msg.length(); i++) {
				if (msg.charAt(i) == '\n')
					resp += " <br> ";
				else if (msg.charAt(i) == '<')
					resp += "&lt";
				else if (msg.charAt(i) == '>')
					resp += "&gt";
				else
					resp += msg.charAt(i);
			}
		}
		else
			resp += "Algo insesperado ocorreu";
		
		resp += " </html>";
		
		return resp;
	}
}
