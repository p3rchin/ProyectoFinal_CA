package co.edu.unbosque.view;

import java.util.Scanner;

/**
 * Clase de vista, donde podemos hacer el metodo de escritura y mostrar en consola los problemas.
 * 
 * @authors Santiago Porras Sep�lveda, Fabian Camilo Gomez, Omar Felipe Ladino y Juan Felipe Rojas
 *
 */

public class View {
	/**
	 * sc de tipo Scanner, donde inicializamos la clase para la escritura.
	 */
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor vac�o para llamar los m�todos de la clase.
	 */
	public View() {

	}
	
	/**
	 * M�todo para escribir lo que el usuario necesite.
	 * 
	 * @param mensaje de tipo String para mostrar el mensaje antes de la escritura.
	 *                mensaje != null.
	 * @return la variable escrito que es lo escrito por el usuario.
	 */
	public String write(String mess) {
		System.out.println(mess);
		String writen = sc.nextLine();
		return writen;
	}
	
	/**
	 * M�todo de tipo void para imprimir el mensaje generado.
	 * 
	 * @param mensaje de tipo String para mostrar el mensaje antes de la escritura.
	 *                mensaje != null.
	 */
	public void show(String mess) {
		System.out.println(mess);
	}
	/**
	 * M�todo para verificar si los datos ingresados por el usuario son solomante
	 * n�meros que escrito el usuario.
	 * 
	 * @param pNumber es de tipo String y son los datos del usuario. pNumber !=
	 *                null.
	 * @return un valor booleano para verificar si son n�meros ingresados o no.
	 */
	
	public boolean onlyNumber(String pNumber) {

		boolean show = true;

		if (!pNumber.trim().matches("[0-9]")) {
			show = false;
		}
		return show;
	}
	
	/**
	 * M�todo que verifica y genera una excepci�n sobre, si el texto tiene n�meros o
	 * no.
	 * 
	 * @param pNumber es de tipo String y son los datos del usuario. pNumber !=
	 *                null.
	 * @return un valor booleano para verificar si son n�meros ingresados o no.
	 * @throws Exception
	 */
	
	public boolean exceptionNumber(String pNumber) throws Exception {
		boolean show;

		if (onlyNumber(pNumber)) {
			show = true;
		} else {
			throw new Exception("Error, solo escriba n�meros");
		}
		return show;
	}

}
