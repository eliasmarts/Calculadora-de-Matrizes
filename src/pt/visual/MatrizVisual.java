package pt.visual;

import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;
import pt.elemento.IElemento;
import pt.matriz.IMatriz;

public class MatrizVisual extends JPanel implements Visual {
	private Visual operaveis[][];
	
	public MatrizVisual() {
		super();
	}
	
	
	public void connect(IMatriz matriz) {
		int linhas = matriz.getNumLinhas(), colunas = matriz.getNumColunas();
		operaveis = new Visual[linhas][colunas];
		
		setLayout(new GridLayout(linhas, colunas));
		
		OperavelVisual opv;
		IElemento valores[][] = matriz.getValores();
		
		for (int i = 0; i < operaveis.length; i++)
			for (int j = 0; j < operaveis[i].length; j++) {
					opv = new OperavelVisual();
					opv.connect(valores[i][j]);
					operaveis[i][j] = opv;
					add(opv);
			}
		
		repaint();
	}

}
