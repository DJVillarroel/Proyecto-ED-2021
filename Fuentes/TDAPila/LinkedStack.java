package TDAPila;

/**
 * Clase LinkedStack
 * @author Diego Villarroel, Nicolás Marini
 * Implementación de la interface Stack con una pila enlazada
 * @param <E> parametro genérico
 */

public class LinkedStack<E> implements Stack<E> {

	protected Node<E> head;
	protected int size;

	/**
	 * Inicializa una pila vacia
	 */
	public LinkedStack() {
		head = null;
		size = 0;
	}

	@Override
	public void push(E elem) {
		Node<E> aux = new Node<E>();
		aux.setElement(elem);
		aux.setNext(head);
		head = aux;
		size++;

	}

	@Override
	public E pop() throws EmptyStackException {
		E aux;
		if (head == null)
			throw new EmptyStackException("Pila vacia");
		else {
			aux = head.getElement();
			head = head.getNext();
			size--;
		}

		return aux;
	}

	@Override
	public E top() throws EmptyStackException {
		E aux;
		if (head == null)
			throw new EmptyStackException("Pila vacia");
		else
			aux = head.getElement();

		return aux;
	}

	@Override
	public boolean isEmpty() {

		return head == null;
	}

	@Override
	public int size() {
		return size;
	}

}
