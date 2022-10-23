package pt.visual.matrizVisual;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;
import pt.visual.OperavelVisual;
import pt.visual.Visual;

public class MatrizVisual extends JPanel implements Visual {
	private static final long serialVersionUID = 1L;
	
	public MatrizVisual(IMatriz matriz) {
		super();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JLabel("Matriz"));
		
		add(new Elementos(matriz));
	}

}
