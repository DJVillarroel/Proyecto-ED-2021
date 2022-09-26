package TDACola;

/**
 * Clase EmptyQueueException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de cola vacía con un mensaje asociado
 */
public class EmptyQueueException extends Exception {

	/**
	 * Inicialización de la excepción
	 */
	public EmptyQueueException(String msg) {
		super(msg);
	}
}
