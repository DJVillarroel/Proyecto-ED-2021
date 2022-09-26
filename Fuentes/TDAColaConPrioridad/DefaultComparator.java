package TDAColaConPrioridad;

/**
 * Clase DefaultComparator
 * @author Diego Villarroel, Nicolás Marini
 * Implementación de un Comparator
 * @param <E> parametro genérico
 */
public class DefaultComparator<E> implements java.util.Comparator<E> {

	/**
	 * Realiza una comparación de 2 elementos
	 */
	public int compare(E a, E b) throws ClassCastException {
		return -((Comparable<E>) a).compareTo(b);
	}
}
