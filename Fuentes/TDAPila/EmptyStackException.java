package TDAPila;

/**
 * Clase EmptyStackException
 * @author Diego Villarroel, Nicol�s Marini
 * Modela una excepcion de pila vac�a con un mensaje asociado
 */
public class EmptyStackException extends Exception {

	/**
	 * Inicializaci�n de la excepci�n
	 */
	public EmptyStackException(String a) {
		super(a);
	}

}
