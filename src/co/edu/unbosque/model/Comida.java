package co.edu.unbosque.model;

public class Comida {
 
	private String nombre;
    private int calorias;
    
    private Comida[] c;
    
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
