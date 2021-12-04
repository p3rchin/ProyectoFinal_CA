package co.edu.unbosque.model;

import java.util.Vector;

public class Conejo {

	static int caminoMasCorto(int posInicial[], int posFinal[], int filas, int columnas) {
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

	static boolean verificar(int x, int y, int n, int m) {
		boolean resultado = false;
		if (x >= 0 && x <= n && y >= 0 && y <= m)
			resultado = true;
		return resultado;
	}

	public static void main(String[] args) {
		int filas = 3;
		int columnas = 4;
		int knightPos[] = { 0, 3 };
		int targetPos[] = { 2, 3 };
		System.out.println(caminoMasCorto(knightPos, targetPos, filas, columnas));
	}
}
