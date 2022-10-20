package pt.visual;

import javax.swing.JComponent;

import pt.matriz.IOperavel;

public interface IVisualFactory {
	public JComponent criaVisual(IOperavel op);
	
	
	public JComponent criaVisual(String s);
	
	
	public BarraDeComando criaBarraComando();
}
