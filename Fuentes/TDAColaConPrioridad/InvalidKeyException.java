package TDAColaConPrioridad;

/**
 * Clase InvalidKeyException
 * @author Diego Villarroel, Nicolás Marini
 * Modela una excepcion de clave invalida con un mensaje asociado
 */
public class InvalidKeyException extends Exception {
	
	/**
	 * Inicialización de la excepción
	 */
	public InvalidKeyException(String msg) {
		super(msg);
	}

}
