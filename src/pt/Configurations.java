package pt;

import java.awt.Color;
import java.text.NumberFormat;

public class Configurations {
	public static final Color COR_ERRO = new Color(255, 180, 180);
	public static final Color BACKGROUND = new Color(230, 230, 230);
	
	
	public static final int MAX_SIZE = 255;
	
	
	private static final NumberFormat nf = NumberFormat.getInstance();
	
	
	public static void setDecimalPrecision(int value) {
		nf.setMaximumFractionDigits(value);
	}


	public static NumberFormat getNumberFormatter() {
		return nf;
	}
}
