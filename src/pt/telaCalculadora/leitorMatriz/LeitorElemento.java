package pt.telaCalculadora.leitorMatriz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import pt.Configurations;
import pt.exceptions.ElementoInvalido;

public class LeitorElemento extends JTextField implements ActionListener {
	private TelaLeitores t;
	private int x, y;

	public LeitorElemento(TelaLeitores t, int x, int y) {
		super(3);
		
		this.t = t;
		
		this.x = x;
		this.y = y;
		
		setText(t.getM().getValores()[x][y].getRepresentacao());
		
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			t.getM().setElemento(x, y, getText());
			
			setBackground(Color.white);
		} catch (ElementoInvalido err) {
			setBackground(Configurations.COR_ERRO);
		}
	}
}
