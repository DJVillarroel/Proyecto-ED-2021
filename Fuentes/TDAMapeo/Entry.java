package TDAMapeo;

/**
 * Interface Entry
 * @author Diego Villarroel, Nicolás Marini
 * 
 * @param <E> parametro genérico
 */
public interface Entry<K,V> {
	
	/**
	 * Consulta la clave de la entrada
	 * @return clave de la entrada
	 */
	public K getKey();
	/**
	 * Consulta el valor de la entrada
	 * @return valor de la entrada
	 */
	public V getValue();
	/**
	 * Asigna una clave pasada por parametro
	 * @param key clave a asignar a la entrada
	 */
	public void setKey(K key);
	/**
	 * Asigna un valor pasado por parametro
	 * @param value valor a asignar a la entrada
	 */
	public void setValue(V value);

}
