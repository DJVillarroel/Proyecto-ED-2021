package TDALista;

import java.util.Iterator;

/**
 * Clase DoubleLinkedList
 * @author Diego Villarroel, Nicolás Marini
 * Implementación de la interfaz PositionList con una lista de posiciones doblemente enlazadas
 * @param <E> parametro de tipo genérico
 */
public class DoubleLinkedList<E> implements PositionList<E> {

	protected DNode<E> header, trailer;
	protected int size;

	/**
	 * Inicializa una lista de enlace doble
	 */
	public DoubleLinkedList() {
		header = trailer = null;
		size = 0;
	}

	/**
	 * Chequea que la posición pasada por parametro sea de la lista no sea nula
	 * @param p posición de la lista a comprobar
	 * @return p casteo a nodo de la posición obtenida por parametro
	 * @throws InvalidPositionException si la posición no es valida
	 */
private DNode<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if (p == null) throw new InvalidPositionException ("Posicion nula.");
		try {
			DNode<E> temp = (DNode<E>) p;
			return temp;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("La posicion es de tipo incorrecto para esta lista.");
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Position<E> first() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException ("La lista esta vacia.");
		return header;
	}
	
	public Position<E> last() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException ("La lista esta vacia.");
		return trailer;
	}
	
	@Override
	public void addFirst(E element) {
		if(size==0) {
			DNode<E> newNodo = new DNode<E>(element);
			header = newNodo;
			trailer = newNodo;
			size++;
		}
		else {
			DNode<E> newNodo = new DNode<E>(null,header,element);
			header.setPrev(newNodo);
			header = newNodo;
			size++;
		}
	}
	
	@Override
	public void addLast(E element) {
		if(size == 0) { 
			DNode<E> nuevo = new DNode<E>(element);
			header = nuevo;
			trailer = nuevo;
			size++;
		}
		else {
			DNode<E> nuevo = new DNode<E>(trailer,null,element);
			trailer.setNext(nuevo);
			trailer = nuevo;
			size++;
		}
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v = checkPosition(p);
		if(v == header)
			throw new BoundaryViolationException("No hay previo para header.");
		DNode<E> prev = v.getPrev();
		return prev;
	}

	@Override
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> pos = checkPosition(p);
		DNode<E> newNodo = new DNode<E>(element);
		if(isEmpty()) throw new InvalidPositionException("La lista esta vacia.");
		if(header == pos) {
			newNodo.setNext(pos);
			newNodo.setPrev(null);
			pos.setPrev(newNodo);
			header = newNodo;
		} else {
			newNodo.setNext(pos);
			newNodo.setPrev(pos.getPrev());
			newNodo.getPrev().setNext(newNodo);
			pos.setPrev(newNodo);
		}
		size++;
	}
	
	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> Nodo_p = checkPosition(p);
		if(isEmpty()) throw new InvalidPositionException("Lista vacia.");
		if(size == 1 || Nodo_p == trailer) throw new BoundaryViolationException("No hay siguiente para trailer.");
		DNode<E> next = Nodo_p.getNext();
		return next;
	}

	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> pos = checkPosition(p); 
		DNode<E> newNodo = new DNode<E>(element); 
		if(isEmpty())
			throw new InvalidPositionException("La lista esta vacia.");
		if(pos == trailer) { 
			newNodo.setNext(null);
			newNodo.setPrev(pos);
			pos.setNext(newNodo);
			trailer = newNodo;
		} else {
			newNodo.setNext(pos.getNext()); 
			newNodo.setPrev(pos); 
			newNodo.getNext().setPrev(newNodo); 
			pos.setNext(newNodo); 
		}
		size++;
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		if(isEmpty()) throw new InvalidPositionException("Lista vacia");
		DNode<E> pos = checkPosition(p);
		E toReturn = pos.element();
		if(pos != header && pos != trailer) {
			pos.getNext().setPrev(pos.getPrev());
			pos.getPrev().setNext(pos.getNext());
		}
		else {
			if(pos == header && pos == trailer) {
				header = null;
				trailer = null;
			}
			else {
				if(pos == header) {
					header = pos.getNext();
				}
				else {
					trailer = pos.getPrev();
				}
			}
		}
		pos.setElement(null);
		pos.setNext(null);
		pos.setPrev(null);
		size--;
		return toReturn;
	}

	@Override
public E set(Position<E> p, E e) throws InvalidPositionException {
		if(isEmpty()) throw new InvalidPositionException("La lista esta vacia.");
		DNode<E> v = checkPosition(p);
		E oldElem = v.element();
		v.setElement(e);
		return oldElem;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> LP = new DoubleLinkedList<Position<E>>();
		if (size != 0) {
				DNode<E> pos = header;
				boolean seguir = true;
				while (seguir) {
					LP.addLast(pos);
					if (pos == trailer)
						seguir = false;
					else
						pos = pos.getNext();
				}
			}
		return LP;
	}

}
