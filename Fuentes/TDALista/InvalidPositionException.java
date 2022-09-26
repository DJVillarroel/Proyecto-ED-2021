package TDALista;

/**
 * Clase InvalidPositionException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de posicion invalida con un mensaje asociado
 */
public class InvalidPositionException extends Exception {
	
	/**
	 * Inicialización de la excepción
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}

}
