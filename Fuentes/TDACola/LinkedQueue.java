package TDACola;

/**
 * Clase LinkedQueue
 * @author Diego Villarroel, Nicolás Marini
 * Implementación de la interfaz Queue con una cola enlazada
 * @param <E> parametro genérico
 */
public class LinkedQueue<E> implements Queue<E> {

	protected Node<E> head, tail;
	protected int size;

	/**
	 * Inicializa una cola enlazada
	 */
	public LinkedQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public void enqueue(E elem) {
		Node<E> nodo = new Node<E>();
		nodo.setElement(elem);
		nodo.setNext(null);
		if (size == 0)
			head = nodo;
		else
			tail.setNext(nodo);
		tail = nodo;
		size++;
	}
	
	@Override
	public E dequeue() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException("Cola vacia");

		E aux = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;

		return aux;
	}

	@Override
	public E front() throws EmptyQueueException {
		E aux;
		if (size == 0)
			throw new EmptyQueueException("Cola vacia");
		aux = head.getElement();
		return aux;
	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}