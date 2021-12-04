package co.edu.unbosque.model;

public class Menu {

	private int cantidadMax;
	private Comida[] comidaElementos;
	private int calorias;

	public Menu() {
		
	}

	public Menu(int cantidadMaxima, int numElementos) {
		this.cantidadMax = cantidadMaxima;
		this.comidaElementos = new Comida[numElementos];
		this.calorias = 0;
	}

	public Comida[] getComidaElementos() {
		return comidaElementos;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int beneficio) {
		this.calorias = beneficio;
	}

	public int getCantidadMax() {
		return cantidadMax;
	}

	public void setCantidadMax(int pesoMaximo) {
		this.cantidadMax = pesoMaximo;
	}

	/**
	 * Añade un elemento a la mochila
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
	 * @return
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
	 * @return
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
