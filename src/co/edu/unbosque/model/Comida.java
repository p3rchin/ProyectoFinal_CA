package co.edu.unbosque.model;

/**
 * Clase de Comida, donde se guarda el plato y las calorias que este tiene.
 * 
 * @authors Santiago Porras Sepúlveda, Fabian Camilo Gomez, Omar Felipe Ladino y
 *          Juan Felipe Rojas
 *
 */

public class Comida {
 
	private String nombre;
	
    private int calorias;
    
    private Comida[] c;
    
    
    /**
     * Constructor 
     * @param nombre del plato. nombre!=null
     * @param calorias del plato . calorias !=null
     */
    public Comida(String nombre, int calorias) {
        this.calorias = calorias;
        this.nombre = nombre;
    }
    /**
	 * @param c
	 */
	public Comida(Comida[] c) {
		super();
		this.c = c;
	}

	public Comida() {
		// TODO Auto-generated constructor stub
	}
	public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int beneficio) {
        this.calorias = beneficio;
    }
    
    /**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the c
	 */
	public Comida[] getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(Comida[] c) {
		this.c = c;
	}
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comida other = (Comida) obj;
        if (this.calorias != other.calorias) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Nombre: "+nombre+" y sus "+" calorías: "+calorias +"\n";
    }
    
    
}
