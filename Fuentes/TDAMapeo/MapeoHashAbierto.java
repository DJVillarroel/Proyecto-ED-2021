package TDAMapeo;

import java.util.Iterator;
import TDALista.*;

/**
 * Clase MapeoHashAbierto
 * @author Diego Villarroel, Nicolás Marini
 * Implementación de la interfaz Map con un hash abierto (Open Addressing)
 * @param <K> parametro genérico de clave
 * @param <V> parametro genérico de valor
 */
public class MapeoHashAbierto<K, V> implements Map<K, V> {

	protected PositionList<Entrada<K, V>>[] A;
	protected int N;
	protected int n;
	private static double fc = 0.9;

	
	private int hash(K key) {
		return Math.abs(key.hashCode()) % N;
	}

	/**
	 * Inicializa un mapeo vacio.
	 * @param tam tamaño del bucket
	 */
	public MapeoHashAbierto(int tam) {
		N = tam;
		n = 0;
		A = (PositionList<Entrada<K, V>>[]) new PositionList[N];
		for (int i = 0; i < N; i++)
			A[i] = new DoubleLinkedList<Entrada<K, V>>();
	}

	/**
	 * Inicializa un mapeo vacio
	 */
	public MapeoHashAbierto() {
		this(13);
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public V get(K key) throws InvalidKeyException {

		checkKey(key);
		V ret = null;
		int clave = hash(key);
		Iterator<Entrada<K, V>> it = A[clave].iterator();
		Entrada<K, V> act = it.hasNext() ? it.next() : null;
		boolean esta = false;

		while (!esta && act != null) {
			if (act.getKey().equals(key)) {
				ret = act.getValue();
				esta = true;
			} else {
				act = it.hasNext() ? it.next() : null;
			}
		}
		return ret;
	}
	
	@Override
	public V put(K key, V value) throws InvalidKeyException {

		checkKey(key);

		V ret = null;
		int clave = hash(key);

		Iterator<Entrada<K, V>> it = A[clave].iterator();
		boolean esta = false;

		while (!esta && it.hasNext()) {
			Entrada<K, V> act = it.next();

			if (key.equals(act.getKey())) {
				esta = true;
				ret = act.getValue();
				act.setValue(value);

			} else {
				act = it.hasNext() ? it.next() : null;
			}
		}
		if (!esta) {
			Entrada<K, V> e = new Entrada<K, V>(key, value);
			A[clave].addLast(e);
			n++;
		}

		if (n / N > fc)
			agrandarTabla();
		return ret;

	}

	@Override
	public V remove(K key) throws InvalidKeyException {
		if (key == null)
			throw new InvalidKeyException("Clave invalida");
		V valor = null;
		PositionList<Entrada<K,V>> list = A[hash(key)];
		try {
		Position<Entrada<K, V>> pos = list.isEmpty() ? null : list.first();
		boolean esta = false;
			while (!esta && pos != null) {
				if (pos.element().getKey().equals(key)) {
					valor = pos.element().getValue();
					esta = true;
					A[hash(key)].remove(pos);
					n--;
				} else {
					pos = (list.last() == pos) ? null : list.next(pos);
				}
			}
		} catch (InvalidPositionException | BoundaryViolationException | EmptyListException e) {
			System.out.println(e.getMessage());
		}
		return valor;
	}

	@Override
	public Iterable<K> keys() {
		PositionList<K> lista = new DoubleLinkedList<K>();
		Iterator<Entrada<K,V>> it;
		for (int i = 0; i < N; i++) {
			it = A[i].iterator();
			Entrada<K, V> en = it.hasNext() ? it.next() : null;
			while(en != null){
				lista.addLast(en.getKey());
				en = it.hasNext() ? it.next() : null;
			}
		}
		return lista;
}

	

	@Override
	public Iterable<V> values() {
		PositionList<V> lista = new DoubleLinkedList<V>();
		Iterator<Entrada<K,V>> it;
		for (int i = 0; i < N; i++) {
			it = A[i].iterator();
			Entrada<K, V> en = it.hasNext() ? it.next() : null;
			while(en != null){
				lista.addLast(en.getValue());
				en = it.hasNext() ? it.next() : null;
			}
		}
		return lista;
}

	@Override
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> lista = new DoubleLinkedList<Entry<K,V>>();
		Iterator<Entrada<K,V>> it;
		for (int i = 0; i < N; i++) {
			it = A[i].iterator();
			Entrada<K, V> en = it.hasNext() ? it.next() : null;
			while(en != null){
				lista.addLast(en);
				en = it.hasNext() ? it.next() : null;
			}
		}
		return lista;
	}

	/**
	 * Agranda los buckets de la tabla de hash
	 */
	private void agrandarTabla() {
		N = proximo_primo(N * 2);
		PositionList<Entrada<K, V>>[] T;
		T = (PositionList<Entrada<K, V>>[]) new DoubleLinkedList[N];
		for (int i = 0; i < N; i++)
			T[i] = new DoubleLinkedList<Entrada<K, V>>();

		for (int i = 0; i < A.length; i++)
			for (Entrada<K, V> e : A[i]) {
				int p = hash(e.getKey());
				T[p].addLast(e);
			}
		A = T;
	}

	/**
	 * Chequea si la clave no es invalida y pertenece al mapeo
	 * @param key clave a chequear
	 * @throws InvalidKeyException
	 */
	private void checkKey(K key) throws InvalidKeyException {
		if (key == null) {
			throw new InvalidKeyException("Clave invalida");
		}
	}

	/**
	 * Retorna el próximo numero primo de n
	 * @param n numero a buscar su próximo primo
	 * @return n numero primo
	 */
	private int proximo_primo(int n) {
		boolean es = false;
		n++;
		while (!es) {
			if (esPrimo(n))
				es = true;
			else
				n++;

		}
		return n;
	}

	/**
	 * Chequea si el numero pasado por parametro es primo
	 * @param n numero a chequear
	 * @return es valor booleano que determina si n es o no primo
	 */
	
	public static boolean esPrimo(int n) {  
		boolean es = true;
	       if (n <= 1) {  //Ni 0 ni 1 son primos
	           es = false; 
	       }  
	       for (int i = 2; i < n; i++) {  //Si algún numero entre 2 y n divide enteramente a n, n no es primo
	           if (n % i == 0) {  
	               es = false;  
	           }  
	       }  
	       return es;  
	   }  

}
