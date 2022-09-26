package TDAColaConPrioridad;

/**
 * Clase EmptyPriorityQueueException
 * @author Diego Villarroel, Nicol�s Marini
 * Modela una excepcion de cola con prioridad vac�a con un mensaje asociado
 */
public class EmptyPriorityQueueException extends Exception {

	/**
	 * Inicializaci�n de la excepci�n
	 */
	public EmptyPriorityQueueException(String msg) {
		super(msg);
	}

}
