package TDALista;

/**
 * Clase InvalidPositionException
 * @author Diego Villarroel, Nicol�s Marini
 * Modela una excepcion de posicion invalida con un mensaje asociado
 */
public class InvalidPositionException extends Exception {
	
	/**
	 * Inicializaci�n de la excepci�n
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}

}
