package TDAColaConPrioridad;

/**
 * Clase EmptyPriorityQueueException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de cola con prioridad vacía con un mensaje asociado
 */
public class EmptyPriorityQueueException extends Exception {

	/**
	 * Inicialización de la excepción
	 */
	public EmptyPriorityQueueException(String msg) {
		super(msg);
	}

}
