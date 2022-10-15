package pt.visual;

import pt.matriz.IMatriz;
import pt.matriz.IOperacoesStrategy;
import pt.operavel.IOperavel;

public class ImprimivelFactory {
	public static Imprimivel criaImprimivel(IOperacoesStrategy op) {
		Imprimivel ret = new Texto("erro");
		if (op == null) {
			ret = new Texto("");
			return ret;
		}
		IMatriz matriz = op.getMatriz();
		IOperavel operavel = op.getOperavel();
		
		
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
	
	public static Imprimivel criaImprimivel(String s) {
		return new Texto(s);
	}
}
