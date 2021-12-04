package co.edu.unbosque.model;
/**
 * Clase de Casilla, donde se inicializa una posicion y una distancia a esta.
 * 
 * @authors Santiago Porras Sepúlveda, Fabian Camilo Gomez, Omar Felipe Ladino y
 *          Juan Felipe Rojas
 *
 */

public class Casilla {
	int x, y;
	int dis;
    
	/**
	 * Constructor de la clase Casilla
	 * @param x coordenada en x. x!=null.
	 * @param y coordenada en y. y!=null.
	 * @param dis distancia entre casillas.
	 */
	public Casilla (int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
