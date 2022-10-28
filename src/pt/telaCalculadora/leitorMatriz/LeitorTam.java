package pt.telaCalculadora.leitorMatriz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pt.Configurations;
import pt.matriz.IMatriz;

public class LeitorTam extends JTextField implements ActionListener {
	private static final long serialVersionUID = 1L;
	private IMatriz m;
	private char direcao;
	private LeitorDeMatriz lei;
	
	public LeitorTam(IMatriz m, LeitorDeMatriz lei, char direcao, int tamI) {
		super(2);
		addActionListener(this);
		
		setText(String.valueOf(tamI));
		
		this.direcao = direcao;
		
		this.m = m;
		
		this.lei = lei;
		
		setar(tamI);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s = getText();
		int size;
		
		try {
			size = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			setBackground(Configurations.COR_ERRO);
			return;
		}
		
		if (size > 0 && size < Configurations.MAX_SIZE) {
			setBackground(Color.white);
			
			setar(size);
		} else {
			setBackground(Configurations.COR_ERRO);
		}
	}
	
	
	private void setar(int size) {
		if (direcao == 'x') {
			m.setColunas(size);
			lei.getTelaLeitores().setColunas(size);
		}
		else {
			m.setLinhas(size);
			lei.getTelaLeitores().setLinhas(size);
		}
		
		lei.repaint();
	}
}
