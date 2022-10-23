package pt.visual;

import javax.swing.JComponent;

import pt.matriz.IOperavel;
import pt.telaCalculadora.barraComando.BarraDeComando;

public interface IVisualFactory {
	public JComponent criaVisual(IOperavel op);
	
	
	public JComponent criaVisual(String s);
}
