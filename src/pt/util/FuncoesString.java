package pt.util;

public class FuncoesString {
	/*
	 * substitui na string target todas as ocorrencias de
	 * cont por atual
	 */
	public static String substitute(String target, String cont, String atual) {
		String[] targetSplit = target.split(cont);
		StringBuilder resp = new StringBuilder();
		
		resp.append(targetSplit[0]);
		
		for (int i = 1; i < targetSplit.length; i++) {
			resp.append(atual);
			resp.append(targetSplit[i]);
		}
		
		return resp.toString();
	}
}
