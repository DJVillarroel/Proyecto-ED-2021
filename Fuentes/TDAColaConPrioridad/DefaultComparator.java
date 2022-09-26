package TDAColaConPrioridad;

/**
 * Clase DefaultComparator
 * @author Diego Villarroel, Nicol�s Marini
 * Implementaci�n de un Comparator
 * @param <E> parametro gen�rico
 */
public class DefaultComparator<E> implements java.util.Comparator<E> {

	/**
	 * Realiza una comparaci�n de 2 elementos
	 */
	public int compare(E a, E b) throws ClassCastException {
		return -((Comparable<E>) a).compareTo(b);
	}
}
