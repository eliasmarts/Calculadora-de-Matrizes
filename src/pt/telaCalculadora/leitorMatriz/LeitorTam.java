package pt.telaCalculadora.leitorMatriz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pt.Configurations;
import pt.comandos.SetDimensao;
import pt.matriz.IMatriz;
import pt.telaCalculadora.util.TextFieldCommand;

public class LeitorTam extends TextFieldCommand {
	private static final long serialVersionUID = 1L;
	private IMatriz m;
	private char direcao;
	private LeitorDeMatriz lei;
	
	public LeitorTam(IMatriz m, LeitorDeMatriz lei, char direcao, int tamI) {
		super(2);
		
		setComando(new SetDimensao(m, this, lei, direcao));
		
		setText(String.valueOf(tamI));
		
		this.direcao = direcao;
		
		this.m = m;
		
		this.lei = lei;
	}
	
	
	public void update(IMatriz m, char direcao) {
		int novoTam;
		
		if (direcao == 'x')
			novoTam = m.getNumLinhas();
		else
			novoTam = m.getNumColunas();
		
		setText(String.valueOf(novoTam));
		
	}
}
