package TDALista;

/**
 * Clase EmptyListException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de lista vacía con un mensaje asociado
 */
public class EmptyListException extends Exception {

	/**
	 * Inicialización de la excepción
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}
