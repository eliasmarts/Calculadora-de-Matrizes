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
		String resp = "<html> ! ";
		
		if (msg != null) {
			String linhas[] = msg.split("%n");
			
			for (String string : linhas) {
				resp += string;
				resp += " <br> ";
			}
		}
		else
			resp += "Algo insesperado ocorreu";
		
		resp += " </html>";
		
		return resp;
	}
}
