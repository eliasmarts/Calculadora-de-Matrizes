package pt;

import java.awt.Color;
import java.text.NumberFormat;

import pt.exceptions.ComandoInvalido;

public class Configurations {
	public static final Color COR_ERRO = new Color(255, 180, 180);
	public static final Color BACKGROUND = new Color(230, 230, 230);
	
	
	public static final int MAX_SIZE = 255;
	
	
	private static final NumberFormat nf = NumberFormat.getInstance();
	
	
	public static void setDecimalPrecision(int value) {
		if (value >= 0 && value <= 10)
			nf.setMaximumFractionDigits(value);
		else
			throw new ComandoInvalido("Valores validos: 0 <= x <= 10");
	}


	public static NumberFormat getNumberFormatter() {
		return nf;
	}
}
