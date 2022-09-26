package TDALista;

/**
 * Clase BoundaryViolationException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de violación de los limites de la estructura con un mensaje asociado
 */
public class BoundaryViolationException extends Exception {

	/**
	 * Inicialización de la excepción
	 */
	public BoundaryViolationException(String a) {
		super(a);
	}
}
