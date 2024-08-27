package ventanas;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import arreglos.ArregloApoderados;
import arreglos.ArregloJugador;
import clases.Apoderado;
import clases.Jugador;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacionApoderado extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	

	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblCodigo;
	private JLabel lblFondo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnModificar;
	private JLabel lblUltimaModificacion;
	private JTextField txtUltimaModificacion;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InformacionApoderado dialog = new InformacionApoderado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InformacionApoderado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionApoderado.class.getResource("/imagenes/icon-window.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setTitle("Información Apoderado");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 800, 400, 25, 25));
		setSize(800, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelBar = new JPanel();
		panelBar.addMouseListener(this);
		panelBar.addMouseMotionListener(this);
		panelBar.setBackground(Color.CYAN);
		panelBar.setBounds(0, 0, 800, 30);
		getContentPane().add(panelBar);
		panelBar.setLayout(null);
		
		panelSalir = new JPanel();
		panelSalir.addMouseListener(this);
		panelSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSalir.setBounds(0, 0, 30, 30);
		panelSalir.setBackground(new Color(225,100,100));
		panelBar.add(panelSalir);
		panelSalir.setLayout(null);
		
		lblSalir = new JLabel("<-");
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(0, 0, 30, 30);
		panelSalir.add(lblSalir);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(770, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblTituloVentana = new JLabel("Información de Apoderado - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 800, 30);
		panelBar.add(lblTituloVentana);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(30, 70, 100, 20);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(30, 130, 100, 20);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setBounds(30, 190, 100, 20);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDni.setBounds(400, 70, 100, 20);
		getContentPane().add(lblDni);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(400, 190, 100, 20);
		getContentPane().add(lblTelefono);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccion.setBounds(400, 130, 100, 20);
		getContentPane().add(lblDireccion);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setBackground(Color.BLACK);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigo.setBounds(135, 65, 200, 25);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBackground(Color.BLACK);
		txtNombre.setBounds(135, 125, 200, 25);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setForeground(Color.WHITE);
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.BLACK);
		txtApellido.setBounds(135, 185, 200, 25);
		getContentPane().add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtDni.setForeground(Color.WHITE);
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDni.setColumns(10);
		txtDni.setBackground(Color.BLACK);
		txtDni.setBounds(520, 65, 220, 25);
		getContentPane().add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setForeground(Color.WHITE);
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.BLACK);
		txtTelefono.setBounds(520, 185, 220, 25);
		getContentPane().add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setForeground(Color.WHITE);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.BLACK);
		txtDireccion.setBounds(520, 125, 220, 25);
		getContentPane().add(txtDireccion);
		
		lblUltimaModificacion = new JLabel("\u00DAltima modificaci\u00F3n:");
		lblUltimaModificacion.setForeground(Color.WHITE);
		lblUltimaModificacion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUltimaModificacion.setBounds(30, 249, 176, 20);
		getContentPane().add(lblUltimaModificacion);
		
		txtUltimaModificacion = new JTextField();
		txtUltimaModificacion.setEditable(false);
		txtUltimaModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtUltimaModificacion.setForeground(Color.WHITE);
		txtUltimaModificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUltimaModificacion.setColumns(10);
		txtUltimaModificacion.setBackground(Color.BLACK);
		txtUltimaModificacion.setBounds(201, 244, 200, 25);
		getContentPane().add(txtUltimaModificacion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(150, 323, 200, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBounds(450, 323, 200, 30);
		getContentPane().add(btnEliminar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 370);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.cargarDatosApoderado();
		
	}
	
	ArregloApoderados objApo = new ArregloApoderados();
	ArregloJugador objJug = new ArregloJugador();
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnModificar) {
			this.actionPerformedBtnModificar();
		}
		if(e.getSource() == btnEliminar) {
			this.actionPerformedBtnEliminar();
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == btnModificar) {
			this.mouseEnteredBtnX(btnModificar, "MODIFICAR");
		}
		if(e.getSource() == btnEliminar) {
			this.mouseEnteredBtnX(btnEliminar, "ELIMINAR");
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnModificar) {
			this.mouseExitedBtnX(btnModificar, "Modificar");
		}
		if(e.getSource() == btnEliminar) {
			this.mouseExitedBtnX(btnEliminar, "Eliminar");
		}
	}
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == panelBar) {
			this.mousePressedPanelBar(e);
		}
	}
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == panelBar) {
			this.mouseReleasedPanelBar();
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		if(e.getSource() == panelBar) {
			this.mouseDraggedPanelBar(e);
		}
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	
	
	
	
	private void actionPerformedBtnModificar() {
		boolean camposllenos = this.validarCampos();
		
		if(camposllenos) {
			int opcion = confirmar("�Modificar datos de apoderado?"
					+ "\n Si cancela este proceso, se volver�n a cargar los datos"
					+ "\n originales del apoderado",
					"Modificar", 
					"src/imagenes/confirmar.png");
			
			if(opcion == 0) {
				int codigo = this.leerCodigo();
				String nombre = this.leerNombre();
				String apellido = this.leerApellido();
				String dni = this.leerDni();
				String direccion = this.leerDireccion();
				String telefono = this.leerTelefono();
				String ultimamodificacion = Login.user;
				
				Apoderado apoactual = objApo.buscarApoderado(codigo);
				Apoderado apoupdate = new Apoderado(nombre, apellido, dni, direccion, telefono, ultimamodificacion);
				
				objApo.modificarApoderado(apoactual, apoupdate);
				
				mensaje("Se modific� el apoderado correctamente",
						"Modificaci�n correcta", 
						"src/imagenes/correcto.png");
				
				this.cargarDatosApoderado();
				
			} else {
				this.cargarDatosApoderado();
			}	
		} 
	}
	
	private void actionPerformedBtnEliminar() {
		int codigo = this.leerCodigo();
		
		Jugador jug = objJug.buscarJugadorPorCodigoApoderado(codigo);
		
		if(jug == null) {
			Apoderado apo = objApo.buscarApoderado(codigo);
			
			int opcion = confirmar("�Eliminar datos de apoderado?"
					+ "\n Si cancela este proceso, no se elimina el apoderado y se volver�n a cargar sus datos"
					+ "\n originales.",
					"Eliminar", 
					"src/imagenes/confirmar.png");
			
			if(opcion == 0) {
				objApo.eliminarApoderado(apo);
				
				mensaje("Se elimin� el apoderado correctamente",
						"Eliminaci�n correcta", 
						"src/imagenes/correcto.png");
				
				new GestionarApoderados().setVisible(true);
				this.dispose();
				
			} else {
				this.cargarDatosApoderado();
			}
			
		} else {
			mensaje("Este apoderado no puede ser eliminado porque est� asignado a un jugador", 
					"Apoderado asignado", "src/imagenes/informacion.png");
			this.cargarDatosApoderado();
		}
	}
	
	private void mouseClickedPanelSalir() {
		new GestionarApoderados().setVisible(true);
		this.dispose();
	}
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnX(JButton boton, String nombreboton) {
		boton.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		boton.setBackground(Color.GREEN);
		boton.setForeground(Color.BLACK);
		boton.setText(nombreboton);
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnX(JButton boton, String nombreboton) {
		boton.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		boton.setBackground(Color.BLACK);
		boton.setForeground(Color.WHITE);
		boton.setText(nombreboton);
	}
	
	
	private void mousePressedPanelBar(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
		panelBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	
	
	private void mouseReleasedPanelBar() {
		panelBar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	
	
	private void mouseDraggedPanelBar(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xMouse, y-yMouse);
	}
	
	
	/*Cargar Datos del Apoderado*/
	private void cargarDatosApoderado() {
		Apoderado apo = objApo.buscarApoderado(GestionarApoderados.codigoapoderadoseleccionado);
		
		if(apo != null) {
			this.establecerDatos(apo);
		} else {
			mensaje("El apoderado consultado no se encontró", "No se encontró apoderado", "src/imagenes/error.png");
		}
	}
	
	/*metodo para establecer datos a las cajas de texto*/
	private void establecerDatos(Apoderado apo) {
		txtCodigo.setText(String.valueOf(apo.getCodigoapoderado()));
		txtNombre.setText(apo.getNombreapoderado());
		txtApellido.setText(apo.getApellidoapoderado());
		txtDni.setText(apo.getDniapoderado());
		txtDireccion.setText(apo.getDireccionapoderado());
		txtTelefono.setText(apo.getTelefonoapoderado());
		txtUltimaModificacion.setText(apo.getUltimamodificacion());
	}
	
	/*mensaje y confirmacion*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	private int confirmar(String texto, String titulo, String img) {
		return JOptionPane.showConfirmDialog(this, texto, titulo, 2, -1, new ImageIcon(img));
	}
	
	/*Metodos adicionales*/
	private void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
	
	/*Validar campos*/
	private boolean validarCampos() {
		try {
			int codigo = this.leerCodigo();
			if(String.valueOf(codigo).length()>0) {
				String nombre = this.leerNombre();
				if(nombre.length()>0) {
					String apellido = this.leerApellido();
					if(apellido.length()>0) {
						String dni = this.leerDni();
						if(dni.length()>0 && dni.length()==8) {
							String direccion = this.leerDireccion();
							if(direccion.length()>0) {
								String telefono = this.leerTelefono();
								if(telefono.length()>0) {
									return true;
									
								} else {
									txtTelefono.setBackground(Color.RED);
									mensaje("El campo 'Tel�fono' est� vac�o", "Tel�fono", "src/imagenes/advertencia.png");
									txtTelefono.setBackground(Color.BLACK);
								}
								
							} else {
								txtDireccion.setBackground(Color.RED);
								mensaje("El campo 'Direcci�n' est� vac�o", "Direcci�n", "src/imagenes/advertencia.png");
								txtDireccion.setBackground(Color.BLACK);
							}
							
						} else {
							txtDni.setBackground(Color.RED);
							mensaje("El campo 'DNI' est� vac�o o\n no tiene 8 caracteres", "DNI", "src/imagenes/advertencia.png");
							txtDni.setBackground(Color.BLACK);
						}
						
					} else {
						txtApellido.setBackground(Color.RED);
						mensaje("El campo 'Apellido' est� vac�o", "Apellido", "src/imagenes/advertencia.png");
						txtApellido.setBackground(Color.BLACK);
					}
					
				}else {
					txtNombre.setBackground(Color.RED);
					mensaje("El campo 'Nombre' est� vac�o", "Nombre", "src/imagenes/advertencia.png");
					txtNombre.setBackground(Color.BLACK);
				}
				
			} else {
				txtCodigo.setBackground(Color.RED);
				mensaje("El campo 'C�digo' est� vac�o", "C�digo", "src/imagenes/advertencia.png");
				txtCodigo.setBackground(Color.BLACK);
			}
			
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error en Registrar Apoderado " + ex);
			mensaje("�Error! Contacte al administrador", "Error Registrar Apoderado", "src/imagenes/error.png");
		}
		return false;
	}
	
	/*Metodos para leer los datos del frame*/
	private int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	private String leerNombre() {
		return txtNombre.getText().trim();
	}
	private String leerApellido() {
		return txtApellido.getText().trim();
	}
	private String leerDni() {
		return txtDni.getText().trim();
	}
	private String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	private String leerTelefono() {
		return txtTelefono.getText().trim();
	}
}
