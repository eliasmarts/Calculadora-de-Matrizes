package pt.visual.matrizVisual;

import java.awt.GridLayout;

import javax.swing.JPanel;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;
import pt.visual.OperavelVisual;
import pt.visual.Visual;

public class Elementos extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Visual operaveis[][];

	protected Elementos(IMatriz matriz) {
		super();
		
		int linhas = matriz.getNumLinhas(), colunas = matriz.getNumColunas();
		operaveis = new Visual[linhas][colunas];
		
		setLayout(new GridLayout(linhas, colunas, 5, 5));
		
		OperavelVisual opv;
		IElemento valores[][] = matriz.getValores();
		
		for (int i = 0; i < operaveis.length; i++)
			for (int j = 0; j < operaveis[i].length; j++) {
					opv = new OperavelVisual();
					opv.connect(valores[i][j]);
					operaveis[i][j] = opv;
					add(opv);
			}
		
	}
}

