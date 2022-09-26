package TDACola;

/**
 * Clase EmptyQueueException
 * @author Diego Villarroel, Nicol�s Marini
 * Modela una excepcion de cola vac�a con un mensaje asociado
 */
public class EmptyQueueException extends Exception {

	/**
	 * Inicializaci�n de la excepci�n
	 */
	public EmptyQueueException(String msg) {
		super(msg);
	}
}
