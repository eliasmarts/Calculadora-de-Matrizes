package pt.operador.operacao;

import java.util.ArrayList;
import java.util.List;

import pt.elemento.ElementoFactory;
import pt.elemento.IElemento;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;
import pt.matriz.Matriz;
import pt.operador.opElementar.MultiplicaLinha;
import pt.operador.opElementar.OpElementar;
import pt.operador.opElementar.SomaMultiplo;
import pt.operador.opElementar.TrocaDeLinha;

public abstract class Operacao {
	/**
	 * realiza a operacao entre os operaveis
	 * @param op1 1 operando
	 * @param op2 2 operando, null se for operacao unaria
	 * @return resultado
	 */
	public abstract IOperavel realizarOperacao(IOperavel op1, IOperavel op2);
	
	
	protected static IMatriz criaMatriz(IElemento[][] operaveis) {
		IMatriz m = new Matriz();
		m.setMatriz(operaveis);
		return m;
	}
	
	
	protected static List<OpElementar> getEscalonamento(IMatriz m) {
		List<OpElementar> escalonamento = new ArrayList<OpElementar>();
		IElemento um = ElementoFactory.criarOperavel(1), zero = ElementoFactory.criarOperavel(0);
		IMatriz copia = m.deepClone();
		int linhas = m.getNumLinhas(), colunas = m.getNumColunas();
	
		// i e j é a posicao do pivo atual
		int i = 0, j = 0;
		while (i < linhas && j < colunas){
			
			if (copia.getElemento(i, j).equals(zero)) {
				boolean trocou = false;
				// procura a proxima linha com pivo nao nulo
				for (int k = i + 1; k < linhas; k++) {
					if (!copia.getElemento(k, j).igual(zero)) {
						OpElementar troca = new TrocaDeLinha(i, k);
						troca.aplicar(copia);
						escalonamento.add(troca);
						trocou = true;
						break;
					}
					if (!trocou)
						// procura pivo na prox coluna
						j++;
				}
			}
			// deixa o pivo como 1
			if (!copia.getElemento(i, j).igual(um)) {
				OpElementar mult = new MultiplicaLinha(i, copia.getElemento(i, i).inverso());
				mult.aplicar(copia);
				escalonamento.add(mult);
			}
			
			// zera a coluna do pivo
			
			for (int k = 0; k < linhas; k++) {
				
				if (i != k && !copia.getElemento(k, j).igual(zero)) {
					OpElementar multL = new SomaMultiplo(k, i, copia.getElemento(k, j).negativo());
					multL.aplicar(copia);
					escalonamento.add(multL);
					
				}
			}
			
			i++;
			j++;
		}
		// TODO ajeitar clonagem da matriz (deep clone)
		return escalonamento;
	}
}
