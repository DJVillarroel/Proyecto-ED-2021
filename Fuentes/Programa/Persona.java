package Programa;

/**
 * Clase Persona
 * @author Diego Villarroel, Nicolás Marini
 * Implementación del objeto Persona, el cual almacena y manipula datos de un paciente
 */
public class Persona {
	private String name;
	private int DNI;

	/**
	 * Inicializa una persona con nombre, apellido y DNI
	 * @param n nombre y apellido
	 * @param dni numero de documento de la persona
	 */
	public Persona(String n, int dni) {
		name = n;
		DNI = dni;
	}
	
	/**
	 * Devuelve el nombre completo de la persona
	 * @return nombre y apellido
	 */
	public String nombre() {
		return name;
	}
	
	/**
	 * Devuelve el numero de documento de la persona
	 * @return numero de documento
	 */
	public Integer DNI() {
		return DNI;
	}
	
	/**
	 * Asigna un nombre y apellido pasado por parametro a la persona
	 * @param n nombre y apellido
	 */
	public void setNombre(String n) {
		name = n;
	}
	
	/**
	 * Asigna un DNI pasado por parametro a la persona
	 * @param dni numero de documento
	 */
	public void setDNI(int dni) {
		DNI = dni;
	}
}
