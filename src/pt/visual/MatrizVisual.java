package pt.visual;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;

public class MatrizVisual implements Visual {
	private Visual operaveis[][];
	@Override
	public void draw(JFrame frame, int x, int y) {
		for (int i = 0; i < operaveis.length; i++) {
			for (int j = 0; j < operaveis[i].length; j++) {
				operaveis[i][j].draw(frame, x + 20 * i, y + 20 * j);
			}

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
