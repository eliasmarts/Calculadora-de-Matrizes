package pt.visual;

import pt.matriz.IOperavel;

public interface IVisualFactory {
	public Visual criaVisual(IOperavel op);
	
	
	public Visual criaVisual(String s);
}
