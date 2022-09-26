package TDALista;

/**
 * Interface Position
 * @author Diego Villarroel, Nicolás Marini
 * 
 * @param <E> parametro genérico
 */
public interface Position<E> {
	
	/**
	 * Consulta el elemento contenido en la posición de la lista
	 * @return elemento de la posición
	 */
	public E element();

}
