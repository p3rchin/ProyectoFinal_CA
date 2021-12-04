package co.edu.unbosque.controller;

import co.edu.unbosque.model.Comida;
import co.edu.unbosque.model.Conejo;
import co.edu.unbosque.model.Menu;
import co.edu.unbosque.view.View;

/**
 * Clase de Controller, donde unimos la vista con los m�todos que hay en el
 * modelo, en este caso los algoritmos a realizar.
 * 
 * @authors Santiago Porras Sep�lveda, Fabian Camilo Gomez, Omar Felipe Ladino y
 *          Juan Felipe Rojas
 *
 */

public class Controller {
	/**
	 * vista de tipo View.
	 */

	private View vista;
	
	private Menu m;
	
	private Conejo conejo;

	/**
	 * Constructor de la clase Controller en donde se inicializan las clases que
	 * tenemos como atributos.
	 */

	public Controller() {
		m = new Menu();
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
				vista.show("Se�or usuario, escriba bien los n�meros\n");

			}

			switch (dec) {
			case "1":
				String opcionMenu = vista.write("[1] Usar un men� pre-seleccionado\n[2]Ingresar tu propio men�.");
				try {
					String comida = "";
					int calorias = 0;
					if (opcionMenu.equals("1")) {

						Comida[] listaComidas = { new Comida("Pollo", 150), new Comida("Carne", 190),
								new Comida("Arroz", 80), new Comida("Huevo", 100), new Comida("Lentejas", 210),
								new Comida("Juego de maracuy�", 39)

						};
						
						Menu mUsuario = new Menu(600, listaComidas.length);
						Menu calculoM = new Menu(0, listaComidas.length);
						
						System.out.println(m.realizarCalculo(mUsuario, listaComidas, false, calculoM));
						

					} else {

						String tam = vista.write("Ingresa el tama�o del men�: ");
						int tamanio = Integer.parseInt(tam);
						Comida[] listaComidas = new Comida[tamanio];

						for (int i = 0; i < listaComidas.length; i++) {
							comida = vista.write("Ingrese el nombre de la comida: " + (i + 1) + ": ");
							calorias = Integer
									.parseInt(vista.write("Ingrese las calorias de la comida " + (i + 1) + ": "));
							listaComidas[i] = new Comida(comida, calorias);
						}

						int cantidadC = Integer.parseInt(vista.write("Ingrese la cantidad de calorias que necesita: "));

						Menu mUsuario = new Menu(cantidadC, listaComidas.length);
						Menu calculoM = new Menu(cantidadC, listaComidas.length);

						System.out.println(m.realizarCalculo(mUsuario, listaComidas, false, calculoM));

					}

				} catch (Exception e1) {
					vista.show("Ingrese bien los numeros 1" + e1.getMessage());
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
				try {
					
				int filas = Integer.parseInt(vista.write("Ingrese la cantidad de filas del campo: "));
				int columnas = Integer.parseInt(vista.write("Ingrese la cantidad de columnas del campo: "));
				int cx = Integer.parseInt(vista.write("Ingrese la posicion en x de partida: "));
				int cy = Integer.parseInt(vista.write("Ingrese la posicion en y de partida: "));
				int fx = Integer.parseInt(vista.write("Ingrese la posicion en x final: "));
				int fy = Integer.parseInt(vista.write("Ingrese la posicion en y final: "));
				int conejoPos[] = { cx, cy };
				int posFinal[] = { fx, fy };
					
					

				} catch (Exception e) {
					vista.show("Escriba bien el numero");
				}

				break;

			case "4":
				break;
			default:
				vista.show("Escoja alguna opci�n valida");
			}

		} while (!dec.equals("4"));
		vista.show("Muchas gracias");

	}
}
