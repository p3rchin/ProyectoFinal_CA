package co.edu.unbosque.model;


/**
 * Clase de Menu, donde se encuentra la lista de platos, la cantidad de calorias maximas y la cantidad de calorias a tener en cuenta.
 * 
 * @authors Santiago Porras Sepúlveda, Fabian Camilo Gomez, Omar Felipe Ladino y
 *          Juan Felipe Rojas
 *
 */
public class Menu {

	private int cantidadMax;
	private Comida[] comidaElementos;
	private int calorias;

	/**
	 * constructor vacio
	 */
	public Menu() {
		
	}
	
	/**
	 * Metodo menu que contiene la cantidad maxima y el numero de elementos
	 * @param cantidadMaxima de calorias. cantidadMaxima !=null
	 * @param numElementos cantidad de platos . numElementos !=null
	 */

	public Menu(int cantidadMaxima, int numElementos) {
		this.cantidadMax = cantidadMaxima;
		this.comidaElementos = new Comida[numElementos];
		this.calorias = 0;
	}

	

	/**
	 * @return the cantidadMax
	 */
	public int getCantidadMax() {
		return cantidadMax;
	}

	/**
	 * @param cantidadMax the cantidadMax to set
	 */
	public void setCantidadMax(int cantidadMax) {
		this.cantidadMax = cantidadMax;
	}

	/**
	 * @return the comidaElementos
	 */
	public Comida[] getComidaElementos() {
		return comidaElementos;
	}

	/**
	 * @param comidaElementos the comidaElementos to set
	 */
	public void setComidaElementos(Comida[] comidaElementos) {
		this.comidaElementos = comidaElementos;
	}

	/**
	 * @return the calorias
	 */
	public int getCalorias() {
		return calorias;
	}

	/**
	 * @param calorias the calorias to set
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	/**
	 * AÃ±ade un elemento a la mochila
	 * 
	 * @param e
	 */
	public void aniadirComida(Comida e) {

		for (int i = 0; i < this.comidaElementos.length; i++) {
			if (this.comidaElementos[i] == null) {
				this.comidaElementos[i] = e;
				this.calorias += e.getCalorias();
				break;
			}
		}

	}

	/**
	 * Vaciamos la mochila
	 */
	public void clear() {
		this.calorias = 0;
		for (int i = 0; i < this.comidaElementos.length; i++) {
			this.comidaElementos[i] = null;
		}
	}

	/**
	 * Elimina elemento dado
	 * 
	 * @param e
	 */
	public void eliminarComida(Comida e) {
		for (int i = 0; i < this.comidaElementos.length; i++) {
			if (this.comidaElementos[i].equals(e)) {
				this.comidaElementos[i] = null; // el elemento fuera
				this.calorias -= e.getCalorias(); // reduce el beneficio
				break;
			}
		}
	}

	/**
	 * Indica si existe un elemento
	 * 
	 * @param e
	 * @return una comida existente o no
	 */
	public boolean existeComida(Comida e) {
		for (int i = 0; i < this.comidaElementos.length; i++) {
			if (this.comidaElementos[i] != null && this.comidaElementos[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Muestra la mochila
	 * 
	 * @return una cadena de string 
	 */
	public String toString() {
		String cadena = "";
		for (int i = 0; i < this.comidaElementos.length; i++) {
			if (this.comidaElementos[i] != null) {
				cadena += comidaElementos[i] + "\n";
			}
		}

		cadena += "Calorias: " + getCalorias() + "\n";
		return cadena;
	}
	
	/**
	 * Metodo para realizar el calculo del menu
	 * @param menu con el que se cuenta. menu!=null
	 * @param elementos lista de platos . elementos !=null
	 * @param total verificacion de si cumple con las calorias. total!=null
	 * @param mOptimo menu ideal . mOptimo!=null
	 * @return la lista de platos esperada
	 */

	public Menu realizarCalculo(Menu menu, Comida[] elementos, boolean total, Menu mOptimo) {

		if (total) {
			if (menu.getCalorias() > mOptimo.getCalorias()) {

				Comida[] elementosMochBase = menu.getComidaElementos();
				mOptimo.clear();

				for (Comida e : elementosMochBase) {
					if (e != null) {
						mOptimo.aniadirComida(e);
					}

				}

			}

		} else {
			for (int i = 0; i < elementos.length; i++) {
				if (!menu.existeComida(elementos[i])) {
					if (menu.getCantidadMax() >= menu.getCalorias() + elementos[i].getCalorias()) {
						menu.aniadirComida(elementos[i]);
						realizarCalculo(menu, elementos, false, mOptimo);
						menu.eliminarComida(elementos[i]);
					} else {
						realizarCalculo(menu, elementos, true, mOptimo);
					}
				}
			}
		}

		return mOptimo;
	}

}
