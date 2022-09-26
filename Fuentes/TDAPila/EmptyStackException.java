package TDAPila;

/**
 * Clase EmptyStackException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de pila vacía con un mensaje asociado
 */
public class EmptyStackException extends Exception {

	/**
	 * Inicialización de la excepción
	 */
	public EmptyStackException(String a) {
		super(a);
	}

}
