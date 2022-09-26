package TDALista;

/**
 * Clase BoundaryViolationException
 * @author Diego Villarroel, Nicol�s Marini
 * Modela una excepcion de violaci�n de los limites de la estructura con un mensaje asociado
 */
public class BoundaryViolationException extends Exception {

	/**
	 * Inicializaci�n de la excepci�n
	 */
	public BoundaryViolationException(String a) {
		super(a);
	}
}
