package TDALista;
/**
 * Clase DNode
 * @author Diego Villarroel, Nicolas Marini
 * Implementación de la interfaz Position para la lista doblemente enlazada
 */
public class DNode<E> implements Position<E> {
	private E elemento;
	private DNode<E> anterior,siguiente;
	/**
	 * 
	 * Inicializa un Nodo con doble enlace
	 * @param ante Nodo de doble enlace a asignar como anterior
	 * @param sig Nodo de doble enlace a asignar como siguiente
	 * @param elem elemento que contendrá el nodo
	 */
	public DNode(DNode<E> ante, DNode<E> sig, E elem) {
		elemento=elem;
		anterior=ante;
		siguiente=sig;
	}
	/**
	 * 
	 * Inicializa un nodo sin enlaces definidos
	 * @param elem elemento que contendrá el nodo
	 */
	public DNode(E elem) {
		this(null,null,elem);
	}
	/**
	 * 
	 * Retorna el elemento del nodo
	 * @return elemento, elemento que contiene el nodo
	 */
	@Override
	public E element(){
		return elemento;
	}
	/**
	 * 
	 * Retorna el siguiente nodo del nodo base
	 * @return siguiente, nodo sucesor al nodo base
	 */
	public DNode<E> getNext(){
		return siguiente;
	}
	/**
	 * 
	 * Retorna el anterior nodo del nodo base
	 * @return anterior, nodo predecesor al nodo base
	 */
	public DNode<E> getPrev(){
		return anterior;
	}
	/**
	 * 
	 * Asigna un elemento al nodo
	 * @param elem, elemento a asignar
	 */
	public void setElement(E elem) {
		elemento=elem;
	}
	/**
	 * 
	 * Asigna un nodo sucesor al nodo base
	 * @param sig, nodo a asignar
	 */
	public void setNext(DNode<E> sig) {
		siguiente=sig;
	}
	/**
	 * 
	 * Asigna un nodo predecesor al nodo base
	 * @param ante, nodo a asignar
	 */
	public void setPrev(DNode<E> ante) {
		anterior=ante;
	}

}