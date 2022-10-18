package pt.visual;

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
	
	public Visual criaVisual(IOperavel op) {
		Visual ret = new Texto("erro");
		if (op == null) {
			ret = new Texto("");
			return ret;
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
	
	public Visual criaVisual(String s) {
		return new Texto(s);
	}

	@Override
	public BarraDeComando criaBarraComando() {
		return new BarraDeComando();
	}
}
