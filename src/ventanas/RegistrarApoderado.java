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
import clases.Apoderado;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarApoderado extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
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
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarApoderado dialog = new RegistrarApoderado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarApoderado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarApoderado.class.getResource("/imagenes/icon-window.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setTitle("Registrar Apoderado");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 800, 350, 25, 25));
		setSize(800, 350);
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
		
		lblTituloVentana = new JLabel("Registrar Apoderado - Sesión de " + Login.user);
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
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.addMouseListener(this);
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistrar.setBounds(300, 264, 200, 30);
		getContentPane().add(btnRegistrar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 320);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.codigoCorrelativo();
		
	}
	
	ArregloApoderados objApo = new ArregloApoderados();
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrar) {
			this.actionPerformedBtnRegistrar();
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
		if(e.getSource() == btnRegistrar) {
			this.mouseEnteredBtnRegistrar();
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnRegistrar) {
			this.mouseExitedBtnRegistrar();
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
	
	
	
	
	
	private void actionPerformedBtnRegistrar() {
		boolean camposllenos = this.validarCampos();
		
		if(camposllenos) {
			int codigo = this.leerCodigo();
			String nombre = this.leerNombre();
			String apellido = this.leerApellido();
			String dni = this.leerDni();
			String direccion = this.leerDireccion();
			String telefono = this.leerTelefono();
			String ultimamodificacion = Login.user;
			
			objApo.adicionarApoderado(
				new Apoderado(codigo,nombre, apellido,dni,direccion,telefono,ultimamodificacion)
			);
			
			mensaje("Se registr� el apoderado correctamente",
					"Registro correcto", 
					"src/imagenes/correcto.png");
			
			this.limpiarCampos();
			
		}
	}
	
	private void mouseClickedPanelSalir() {
		new Secretario().setVisible(true);
		this.dispose();
	}
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnRegistrar() {
		btnRegistrar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnRegistrar.setBackground(Color.GREEN);
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setText("REGISTRAR");
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnRegistrar() {
		btnRegistrar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setText("Registrar");
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

	
	private void limpiarCampos() {
		this.codigoCorrelativo();
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
	}
	
	/*Metodos adicionales*/
	private void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
	
	/*Metodos de mensaje*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	/*Codigo Correlativo*/
	private void codigoCorrelativo() {
		txtCodigo.setText(String.valueOf(objApo.codigoCorrelativoApoderado()));
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
