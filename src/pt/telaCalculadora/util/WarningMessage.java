package pt.telaCalculadora.util;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import pt.Configurations;

public class WarningMessage extends JLabel {
	
	public WarningMessage(String msg) {
		super(createMsg(msg));
		
		
		setBackground(Configurations.COR_ERRO);
		
		setBorder(BorderFactory.createLineBorder(Color.red));
	}
	
	
	private static String createMsg(String msg) {
		String resp;
		
		if (msg != null) {
			resp = msg;
		}
		else
			resp = "Algo insesperado ocorreu";
		
		return resp;
	}
}
