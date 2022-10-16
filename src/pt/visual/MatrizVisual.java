package pt.visual;

import java.io.PrintStream;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;

public class MatrizVisual implements Visual {
	private Visual operaveis[][];
	@Override
	public void draw(PrintStream out) {
		for (int i = 0; i < operaveis.length; i++) {
			for (int j = 0; j < operaveis[i].length; j++) {
				operaveis[i][j].draw(out);
				out.print(" ");
			}
			out.print("\n");
		}
	}
	
	
	public void connect(IMatriz matriz) {
		operaveis = new Visual[matriz.getNumLinhas()][matriz.getNumColunas()];
		OperavelVisual opv;
		IElemento valores[][] = matriz.getValores();
		
		for (int i = 0; i < operaveis.length; i++)
			for (int j = 0; j < operaveis[i].length; j++) {
					opv = new OperavelVisual();
					opv.connect(valores[i][j]);
					operaveis[i][j] = opv;
			}
	
	}

}
