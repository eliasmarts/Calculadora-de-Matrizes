package pt.matriz;

public class OperadorMatriz {
	private static final OperadorMatriz instance = new OperadorMatriz();
	
	
	private OperadorMatriz() {
		
	}
	
	
	public OperadorMatriz getInstance() {
		return instance;
	}
}
