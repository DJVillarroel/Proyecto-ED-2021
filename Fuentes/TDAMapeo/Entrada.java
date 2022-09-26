package TDAMapeo;

/**
 * Clase Entrada
 * @author Diego Villarroel, Nicolas Marini
 * Implementación de la interfaz Entry para el Mapeo
 */
public class Entrada<K, V> implements Entry<K, V> {
	private K clave;
	private V valor;

	/**
	 * Inicializa una entrada
	 * @param k clave
	 * @param v valor
	 */
	public Entrada(K k, V v) {
		clave = k;
		valor = v;
	}

	@Override
	public K getKey() {
		return clave;
	}

	@Override
	public V getValue() {
		return valor;
	}

	@Override
	public void setKey(K k) {
		clave = k;
	}

	@Override
	public void setValue(V v) {
		valor = v;
	}

	/**
	 * Genera un string con los datos de la entrada
	 */
	public String toString() {
	
		return "(" + getKey() + "," + getValue() + ")" ;
}
}