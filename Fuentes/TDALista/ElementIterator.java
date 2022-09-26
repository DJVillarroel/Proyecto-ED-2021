package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase ElementIterator
 * @author Diego Villarroel, Nicolás Marini
 * Implementación de la interfaz Iterator con una lista iterable
 * @param <E> parametro genérico
 */
public class ElementIterator<E> implements Iterator<E> {

	protected PositionList<E> list;
	protected Position<E> cursor;

	/**
	 * Inicializa un iterador de elementos con una lista
	 * @param l lista de posiciones
	 */
	public ElementIterator(PositionList<E> l) {
		list = l;
		if (list.isEmpty())
			cursor = null;
		else
			try {
				cursor = list.first();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
	}

	@Override
	public boolean hasNext() {
		return cursor != null;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (cursor == null)
			throw new NoSuchElementException("Error: No hay siguiente");
		E toReturn = cursor.element();
		try {
			cursor = (cursor == list.last()) ? null : list.next(cursor);
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}

		return toReturn;
	}

}
