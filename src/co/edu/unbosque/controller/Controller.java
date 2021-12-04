package co.edu.unbosque.controller;

import co.edu.unbosque.view.View;

/**
 * Clase de Controller, donde unimos la vista con los métodos que hay en el
 * modelo, en este caso los algoritmos a realizar.
 * 
 * @authors Santiago Porras Sepúlveda, Fabian Camilo Gomez, Omar Felipe Ladino y
 *          Juan Felipe Rojas
 *
 */

public class Controller {
	/**
	 * vista de tipo View.
	 */

	private View vista;

	/**
	 * Constructor de la clase Controller en donde se inicializan las clases que
	 * tenemos como atributos.
	 */

	public Controller() {

		vista = new View();
		run();
	}

	/**
	 * Constructor de la clase Controller en donde se inicializan las clases que
	 * tenemos como atributos.
	 */

	private void run() {

		int decision = 0;
		String dec = "";
		do {
			vista.show("Bienvenido al programa proyecto final de Complejidad: ");
			dec = vista
					.write("[1] Problema Nutricionista \n[2] Problema de la liga de Futbol \n[3] Problema del conejo\n"
							+ "[4] Salir");
			try {
				if (vista.exceptionNumber(dec)) {
				}
			} catch (Exception e1) {
				vista.show("Señor usuario, escriba bien los números\n");

			}

			switch (dec) {
			case "1":
				String t = vista.write(" Ingreso 1 ");
				try {
					if (vista.exceptionNumber(t)) {

					}
				} catch (Exception e1) {
					vista.show("Ingrese bien los numeros");
				}

				break;

			case "2":

				String n1 = vista.write("Ingreso 2 ");
				try {

				} catch (Exception e) {
					vista.show("Escriba bien el numero");
				}

				break;

			case "3":

				String t3 = vista.write("Ingreso 3");
				try {

				} catch (Exception e) {
					vista.show("Escriba bien el numero");
				}

				break;

			case "4":
				break;
			default:
				vista.show("Escoja alguna opción valida");
			}

		} while (!dec.equals("4"));
		vista.show("Muchas gracias");

	}
}
