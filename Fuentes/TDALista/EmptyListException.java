package TDALista;

/**
 * Clase EmptyListException
 * @author Diego Villarroel, Nicol�s Marini
 * Modela una excepcion de lista vac�a con un mensaje asociado
 */
public class EmptyListException extends Exception {

	/**
	 * Inicializaci�n de la excepci�n
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}
