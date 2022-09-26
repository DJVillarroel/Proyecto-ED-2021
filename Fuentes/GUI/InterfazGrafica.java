package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Programa.Logica;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;

public class InterfazGrafica {

	private JFrame frmRegistroDePacientes;
	private JTextField tNombre;
	private JTextField tDNI;
	private Logica logica = new Logica();
	private JTextField tApellido;
	private JTextField tRiesgoso;
	private JTextArea aPacientes;
	private JTextField tDNIeliminar;
	private JPanel pEliminar;
	private JTextField tDNIhistorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica window = new InterfazGrafica();
					window.frmRegistroDePacientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistroDePacientes = new JFrame();
		frmRegistroDePacientes.setTitle("Registro de pacientes -COVID-19");
		frmRegistroDePacientes.setBounds(100, 100, 900, 575);
		frmRegistroDePacientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroDePacientes.getContentPane().setLayout(null);
		
		JPanel pInscripcion = new JPanel();
		pInscripcion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		pInscripcion.setBounds(0, 0, 540, 300);
		frmRegistroDePacientes.getContentPane().add(pInscripcion);
		pInscripcion.setLayout(null);
		
		tNombre = new JTextField();
		tNombre.setToolTipText("Ingresar Nombre y Apellido");
		tNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tNombre.setBounds(172, 20, 195, 32);
		pInscripcion.add(tNombre);
		tNombre.setColumns(10);
		
		JComboBox cbRiesgo = new JComboBox();
		cbRiesgo.setToolTipText("Grupo de riesgo del paciente (menor n\u00FAmero, menor riesgo)");
		cbRiesgo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbRiesgo.setBounds(172, 239, 84, 32);
		pInscripcion.add(cbRiesgo);
		cbRiesgo.addItem("1");
		cbRiesgo.addItem("2");
		cbRiesgo.addItem("3");
		cbRiesgo.addItem("4");
		cbRiesgo.addItem("5");
		
		tDNI = new JTextField();
		tDNI.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) { //Esto permitirá escribir unicamente números en el campo de DNI
				String value = tDNI.getText();
	            int l = value.length();
	            if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
	            	tDNI.setEditable(true);
	            } else {
	            	tDNI.setEditable(false);
	            }
			}
		});
		tDNI.setToolTipText("Ingresar DNI (Campo num\u00E9rico)");
		tDNI.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tDNI.setColumns(10);
		tDNI.setBounds(172, 157, 140, 32);
		pInscripcion.add(tDNI);
		
		JLabel lNombre = new JLabel("Nombre:");
		lNombre.setFont(new Font("Calibri", Font.PLAIN, 18));
		lNombre.setBounds(10, 25, 154, 23);
		pInscripcion.add(lNombre);
		
		JButton bInscribir = new JButton("Inscribir Paciente"); //Acción de inscribir paciente
		bInscribir.setToolTipText("Inscribir\u00E1 a la persona a la lista de pacientes");
		bInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = tNombre.getText();
				String surname = tApellido.getText();
				String DNI = tDNI.getText();
				String risk = cbRiesgo.getSelectedItem().toString();
				validarDatos(name, surname, DNI, risk);
			}
		});
		bInscribir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bInscribir.setBounds(324, 240, 195, 32);
		pInscripcion.add(bInscribir);
		
		JLabel lDNI = new JLabel("Nro. de Documento:");
		lDNI.setFont(new Font("Calibri", Font.PLAIN, 18));
		lDNI.setBounds(10, 165, 154, 23);
		pInscripcion.add(lDNI);
		
		JLabel lRiesgo = new JLabel("Grupo de riesgo:");
		lRiesgo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lRiesgo.setBounds(10, 248, 154, 23);
		pInscripcion.add(lRiesgo);
		
		JLabel lApellido = new JLabel("Apellido:");
		lApellido.setFont(new Font("Calibri", Font.PLAIN, 18));
		lApellido.setBounds(10, 95, 154, 23);
		pInscripcion.add(lApellido);
		
		tApellido = new JTextField();
		tApellido.setToolTipText("Ingresar Nombre y Apellido");
		tApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tApellido.setColumns(10);
		tApellido.setBounds(172, 87, 195, 32);
		pInscripcion.add(tApellido);
		
		JPanel pRiesgoso = new JPanel();
		pRiesgoso.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		pRiesgoso.setBounds(0, 300, 540, 130);
		frmRegistroDePacientes.getContentPane().add(pRiesgoso);
		pRiesgoso.setLayout(null);
		
		tRiesgoso = new JTextField();
		tRiesgoso.setText("");
		tRiesgoso.setToolTipText("Paciente m\u00E1s riesgoso");
		tRiesgoso.setEditable(false);
		tRiesgoso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tRiesgoso.setBounds(260, 58, 218, 23);
		pRiesgoso.add(tRiesgoso);
		tRiesgoso.setColumns(10);
		
		JButton bRiesgoso = new JButton("Mostrar paciente m\u00E1s riesgoso"); //Acción de mostrar paciente más riesgoso
		bRiesgoso.setToolTipText("Mostrar\u00E1 en el recuadro qui\u00E9n es el paciente de mayor prioridad de atenci\u00F3n");
		bRiesgoso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bRiesgoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String riesgoso = logica.masRiesgoso();
				mostrarRiesgoso(riesgoso);
			}
		});
		bRiesgoso.setBounds(10, 58, 240, 23);
		pRiesgoso.add(bRiesgoso);
		
		JPanel pPacientes = new JPanel();
		pPacientes.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		pPacientes.setBounds(540, 0, 350, 430);
		frmRegistroDePacientes.getContentPane().add(pPacientes);
		pPacientes.setLayout(null);
		
		aPacientes = new JTextArea();
		aPacientes.setToolTipText("Lista de pacientes (Seg\u00FAn prioridad)");
		aPacientes.setFont(new Font("Arial", Font.PLAIN, 19));
		aPacientes.setEditable(false);
		aPacientes.setBounds(22, 99, 305, 258);
		pPacientes.add(aPacientes);
		
		JButton bListarPacientes = new JButton("Mostar pacientes de mayor a menor");
		bListarPacientes.setToolTipText("Mostrar\u00E1 los pacientes de mayor a menor prioridad");
		bListarPacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bListarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aPacientes.setText(logica.mostrarDatos());
			}
		});
		bListarPacientes.setBounds(22, 47, 289, 29);
		pPacientes.add(bListarPacientes);
		
		JButton btnMostarPacientesDe = new JButton("Mostar pacientes de menor a mayor");
		btnMostarPacientesDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aPacientes.setText(logica.mostrarDatosInvertidos());
			}
		});
		btnMostarPacientesDe.setToolTipText("Mostrar\u00E1 los pacientes de menor a mayor prioridad");
		btnMostarPacientesDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMostarPacientesDe.setBounds(22, 379, 289, 29);
		pPacientes.add(btnMostarPacientesDe);
		
		pEliminar = new JPanel();
		pEliminar.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		pEliminar.setBounds(0, 430, 445, 100);
		frmRegistroDePacientes.getContentPane().add(pEliminar);
		pEliminar.setLayout(null);
		
		tDNIeliminar = new JTextField();
		tDNIeliminar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) { //Esto permitirá escribir unicamente números en el campo de DNI
				String value = tDNIeliminar.getText();
	            int l = value.length();
	            if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
	            	tDNIeliminar.setEditable(true);
	            } else {
	            	tDNIeliminar.setEditable(false);
	            }
			}
		});
		tDNIeliminar.setToolTipText("Ingresar DNI (Campo num\u00E9rico)");
		tDNIeliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tDNIeliminar.setColumns(10);
		tDNIeliminar.setBounds(240, 35, 140, 32);
		pEliminar.add(tDNIeliminar);
		
		JButton btnNewButton = new JButton("Eliminar paciente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!tDNIeliminar.getText().equals("")) {
				int dni = Integer.parseInt(tDNIeliminar.getText());
					boolean eliminado = logica.eliminarPaciente(dni);
					notificacionEliminacion(eliminado);
					tDNIeliminar.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Inserte DNI del paciente a eliminar");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setToolTipText("Eliminar paciente por DNI");
		btnNewButton.setBounds(28, 35, 173, 32);
		pEliminar.add(btnNewButton);
		
		JPanel pEliminar_1 = new JPanel();
		pEliminar_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		pEliminar_1.setBounds(445, 430, 445, 100);
		frmRegistroDePacientes.getContentPane().add(pEliminar_1);
		pEliminar_1.setLayout(null);
		
		tDNIhistorial = new JTextField();
		tDNIhistorial.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent k) { //Esto permitirá escribir unicamente números en el campo de DNI
				String value = tDNIhistorial.getText();
	            int l = value.length();
	            if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
	            	tDNIhistorial.setEditable(true);
	            } else {
	            	tDNIhistorial.setEditable(false);
	            }
			}
		});
		tDNIhistorial.setToolTipText("Ingresar DNI (Campo num\u00E9rico)");
		tDNIhistorial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tDNIhistorial.setColumns(10);
		tDNIhistorial.setBounds(263, 35, 140, 32);
		pEliminar_1.add(tDNIhistorial);
		
		JButton btnNewButton_1 = new JButton("Consultar registro hist\u00F3rico");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!tDNIhistorial.getText().equals("")) {
					int dni = Integer.parseInt(tDNIhistorial.getText());
					String nombreRegistro = logica.consultarRegistro(dni);
					if (nombreRegistro!=null) {
						JOptionPane.showMessageDialog(null, "Paciente: " + nombreRegistro + "DNI: " + dni);
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró el paciente en el registro histórico");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese DNI del paciente");
				}
			}
		});
		btnNewButton_1.setToolTipText("Consultar\u00E1 los datos del paciente por DNI en el registro hist\u00F3rico");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(30, 35, 223, 32);
		pEliminar_1.add(btnNewButton_1);
	}

	protected void notificacionEliminacion(boolean eliminado) {
		if (eliminado) {
			JOptionPane.showMessageDialog(null, "Se ha eliminado el paciente");
		} else {
			JOptionPane.showMessageDialog(null, "No se ha encontrado un paciente con ese DNI");
		}
		
	}

	protected void mostrarRiesgoso(String r) { //Mostrará en el campo de texto aledaño el nombre del paciente más riesgoso.
		tRiesgoso.setText(r);
	}

	protected void validarDatos(String n, String s, String d, String r) { //Chequeará si los datos fueron ingresados correctamente
		// TODO Auto-generated method stub
		if (n.equals("") || s.equals("") || d.equals("")) {
			JOptionPane.showMessageDialog(null, "Faltan completar campos");
		} else {
			tNombre.setText("");
			tApellido.setText("");
			tDNI.setText("");
			int i = Integer.parseInt(r);
			int dni = Integer.parseInt(d);
			logica.capturarDatos(n, s, dni, i);
		}
	}
}
