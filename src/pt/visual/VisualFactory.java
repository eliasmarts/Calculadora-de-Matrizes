package pt.visual;

import javax.swing.JComponent;
import javax.swing.JLabel;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;

public class VisualFactory implements IVisualFactory {
	private static VisualFactory instance = null;
	
	private VisualFactory() {
		
	}
	
	public static VisualFactory getInstance() {
		if (instance == null)
			instance = new VisualFactory();
	
		return instance;
	}
	
	public JComponent criaVisual(IOperavel op) {
		JComponent ret = null;
		if (op == null) {
			ret = null;
		}
		IMatriz matriz = op.getMatriz();
		IElemento operavel = op.getElemento();
		
		
		if (matriz != null) {
			MatrizVisual m = new MatrizVisual();
			m.connect(matriz);
			ret = m;
		} else if (operavel != null) {
			OperavelVisual opv = new OperavelVisual();
			opv.connect(operavel);
			ret = opv;
		}
		
		return ret;
	}
	
	public JComponent criaVisual(String s) {
		return new JLabel(s);
	}

	@Override
	public BarraDeComando criaBarraComando() {
		return new BarraDeComando();
	}
}
