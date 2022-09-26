package TDAPila;

/**
 * Clase Node
 * @author Diego Villarroel, Nicol�s Marini
 * Implementaci�n de la clase nodo para la pila enlazada
 * @param <E> parametro de tipo gen�rico
 */
public class Node<E> {

	private E element;
	private Node<E> next;

	/**
	 * Inicializa un nodo vacio
	 */
	public Node() {
		element = null;
		next = null;
	}

	/**
	 * Obtiene el elemento del nodo que llama a la funci�n
	 * @return element elemento del nodo base
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Asigna un elemento pasado por parametro al nodo
	 * @param elem elemento a asignar al nodo base
	 */
	public void setElement(E elem) {
		element = elem;
	}

	/**
	 * Obtiene el nodo sucesor al nodo que llama la funci�n
	 * @return next nodo sucesor al nodo base
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Asigna un nodo sucesor pasado por parametro al nodo base
	 * @param e nodo a asignar como siguiente
	 */
	public void setNext(Node<E> e) {
		next = e;
	}
}
