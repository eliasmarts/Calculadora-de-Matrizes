package pt.telaCalculadora;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class AreaDeResposta extends JPanel {
	private JComponent respAnterior;
	
	
	public AreaDeResposta() {
		super();
		
		setLayout(new BorderLayout());
		
		respAnterior = null;
	}
	
	
	public void insereResposta(JComponent resposta) {
		if (respAnterior != null)
			remove(respAnterior);
	
		add(resposta, BorderLayout.SOUTH);
		
		respAnterior = resposta;
	}
}
