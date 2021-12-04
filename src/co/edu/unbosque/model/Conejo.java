package co.edu.unbosque.model;

import java.util.Vector;

/**
 * Clase de Conejo, donde esta la distancia mas corta que debe recorrrer el conejo para llegar a su destino.
 * 
 * @authors Santiago Porras Sepúlveda, Fabian Camilo Gomez, Omar Felipe Ladino y
 *          Juan Felipe Rojas
 *
 */

public class Conejo {
	
	/**
	 * Metodo CaminoMasCorto, el cual halla la menor cantidad de saltos para llegar de un lugar a otro (saltos en diagonal)
	 * @param posInicial es donde se encuentra situado el conejo . posInicial!=null
	 * @param posFinal   es el destino a donde debe llegar el conejo. posFinal!=null
	 * @param filas      es la cantidad de filas que tiene el campo. filas!=null && filas >0
	 * @param columnas   es la cantidad de columnas que tiene el campo. columnas !=null && columnas >0
	 * @return el camino mas corto por el conejo.
	 */

	public int caminoMasCorto(int posInicial[], int posFinal[], int filas, int columnas) {
		int movX[] = { -1, 1, -1, 1 };

		int movY[] = { -1, -1, 1, 1 };

		int x, y;

		Vector<Casilla> aux = new Vector<>();
		aux.add(new Casilla(posInicial[0], posInicial[1], 0));
		Casilla posConejo;

		boolean visit[][] = new boolean[filas + 1][columnas + 1];
		for (int i = 1; i <= filas; i++)
			for (int j = 1; j <= columnas; j++)
				visit[i][j] = false;
		visit[posInicial[0]][posInicial[1]] = true;
		while (!aux.isEmpty()) {
			posConejo = aux.firstElement();
			aux.remove(0);
			if (posConejo.x == posFinal[0] && posConejo.y == posFinal[1])
				return posConejo.dis;

			for (int i = 0; i < 4; i++) {
				x = posConejo.x + movX[i];
				y = posConejo.y + movY[i];
				if (verificar(x, y, filas, columnas) && !visit[x][y]) {
					visit[x][y] = true;
					aux.add(new Casilla(x, y, posConejo.dis + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * Verifica que el conejo no se salga de los parametros enviados por el usuario
	 * @param x la coordenada en x a verificar. x !=null && x >0
	 * @param y la coordenada en y a verificar. y !=null && y >0
	 * @param n la cantidad de filas a donde puede llegar el conejo. n!=null
	 * @param m la cantidad de filas a donde puede llegar el conejo. n!=null
	 * @return
	 */

	public boolean verificar(int x, int y, int n, int m) {
		boolean resultado = false;
		if (x >= 0 && x <= n && y >= 0 && y <= m)
			resultado = true;
		return resultado;
	}
}
