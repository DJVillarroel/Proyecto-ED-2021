package Programa;

import TDAColaConPrioridad.*;
import TDACola.*;
import TDAPila.*;
import TDAMapeo.*;

/**
 * Clase Logica
 * @author Diego Villarroel, Nicolas Marini
 * Implementación de la clase logica, provee metodos para el funcionamiento de la interfaz gráfica y sus estructuras de datos
 */
public class Logica {
	PriorityQueue<Integer,Persona> pacientes;
	Map<Integer, Persona> historialPacientes;
	
	/**
	 * Inicializa la lógica del programa
	 */
	public Logica() {
		pacientes = new HeapPQueue<Integer,Persona>();
		historialPacientes = new MapeoHashAbierto<Integer, Persona>();
	}
	
	/**
	 * Captura los datos ingresados del paciente
	 * @param nombre nombre del paciente
	 * @param apellido apellido del paciente
	 * @param dni numero de documento del paciente
	 * @param riesgo grupo de riesgo del paciente
	 */
	public void capturarDatos(String nombre, String apellido, Integer dni, Integer riesgo) {
		String fullname = nombre + " " + apellido;
		Persona persona = new Persona(fullname, dni);
		Integer prioridad = riesgo;
		try {
		pacientes.insert(prioridad, persona);
		} catch (TDAColaConPrioridad.InvalidKeyException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve en una cadena el paciente más riesgoso de la lista
	 * @return nombre nombre del paciente más riesgoso
	 */
	public String masRiesgoso(){
		String nombre = "";
		TDAColaConPrioridad.Entry<Integer, Persona> persona;
		try {
		if (!pacientes.isEmpty()) {
			persona = pacientes.min();
			nombre = persona.getValue().nombre();
		} 
		} catch(EmptyPriorityQueueException e) {e.printStackTrace();}
		return nombre;
	}
	
	/**
	 * Muestra en pantalla la lista ordenada de pacientes de mayor a menor grupo de riesgo
	 * @return toReturn lista de pacientes 
	 */
	public String mostrarDatos() {
		Queue<String> nombresPacientes = new LinkedQueue<String>();
		TDAColaConPrioridad.Entry<Integer, Persona> entrada= null;
		PriorityQueue<Integer,Persona> pacientesAux = new HeapPQueue<Integer,Persona>();
		String toReturn ="";
		try {
		while(!pacientes.isEmpty()) { //Remuevo la lista de pacientes y los coloco en una cola con prioridad auxiliar, inserto los nombres de los pacientes en una cola
			entrada = pacientes.removeMin();
			nombresPacientes.enqueue(entrada.getValue().nombre());
			pacientesAux.insert(entrada.getKey(), entrada.getValue());
		}
		
		while(!nombresPacientes.isEmpty()) {//Coloco los nombres de los pacientes en un String para retornar
			toReturn = toReturn + nombresPacientes.dequeue() + "\n";
		}
		
		pacientes = pacientesAux;
		} catch(EmptyPriorityQueueException | TDAColaConPrioridad.InvalidKeyException | EmptyQueueException e) {e.printStackTrace();}
		return toReturn;
	}
	
	/**
	 * Muestra en pantalla la lista ordenada de pacientes de menor a mayor grupo de riesgo
	 * @return toReturn lista de pacientes
	 */
	public String mostrarDatosInvertidos() {
		Stack<String> nombresPacientes = new LinkedStack<String>();
		TDAColaConPrioridad.Entry<Integer, Persona> entrada = null;
		PriorityQueue<Integer,Persona> pacientesAux = new HeapPQueue<Integer,Persona>();
		String toReturn = "";
		try {
		while(!pacientes.isEmpty()) {//Remuevo la lista de pacientes y los coloco en una cola con prioridad auxiliar, inserto los nombres de los pacientes en una pila
			entrada = pacientes.removeMin();
			nombresPacientes.push(entrada.getValue().nombre());
			pacientesAux.insert(entrada.getKey(), entrada.getValue());
		}
		
		while(!nombresPacientes.isEmpty()) {//Coloco los nombres de los pacientes en un String para retornar
			toReturn = toReturn + nombresPacientes.pop() + "\n";
		}
		
		pacientes = pacientesAux;
		} catch(EmptyPriorityQueueException | TDAColaConPrioridad.InvalidKeyException | EmptyStackException e) {e.printStackTrace();}
		return toReturn;
	}
	
	/**
	 * Si encuentra un paciente según su DNI, lo elimina y devuelve true, sino, devuelve false
	 * @param DNI
	 * @return
	 */
	public boolean eliminarPaciente(Integer DNI) { //Devuelve una variable booleana si el paciente ha sido o no eliminado;
		TDAColaConPrioridad.Entry<Integer, Persona> entrada;
		boolean eliminado = false;
		PriorityQueue<Integer,Persona> pacientesAux = new HeapPQueue<Integer,Persona>();
		try {
		while(!pacientes.isEmpty() && !eliminado) { //Busca uno por uno a los pacientes y checkea su DNI, lo elimina si coincide con el pasado por parametro, el resto entran a una cola auxiliar, deposita al eliminado en un mapeo
			entrada = pacientes.removeMin();
			if (entrada.getValue().DNI().equals(DNI)) { //Si el DNI coincide con la entrada, mete al a persona al historial, sino a la cola auxiliar
				historialPacientes.put(DNI, entrada.getValue());
				eliminado = true;
			} else {
				pacientesAux.insert(entrada.getKey(), entrada.getValue());
			}
		}
		
		pacientes = pacientesAux;
		} catch(EmptyPriorityQueueException | TDAColaConPrioridad.InvalidKeyException | TDAMapeo.InvalidKeyException e) {e.printStackTrace();}
		return eliminado;
	}
	
	/**
	 * Devuelve una cadena con el nombre de un paciente eliminado, en el registro histórico, según el DNI pasado por parametro
	 * @param DNI numero de documento del paciente eliminado
	 * @return toReturn nombre del paciente eliminado
	 */
	public String consultarRegistro(Integer DNI) { //Consultará en el mapeo de pacientes históricos según el DNI y devolverá al nombre de la persona y DNI
		String toReturn = null;
		try {
		if (!historialPacientes.isEmpty()) {
			toReturn = historialPacientes.get(DNI).nombre();
		}
		} catch(TDAMapeo.InvalidKeyException e) {e.printStackTrace();}
		return toReturn;
	}
}
