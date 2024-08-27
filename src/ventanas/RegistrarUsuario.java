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
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import arreglos.ArregloUsuarios;
import clases.Usuario;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
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
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	private JLabel lblNivel;
	private JLabel lblEstado;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JComboBox<String> cmbNivel;
	private JComboBox<String> cmbEstado;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuario dialog = new RegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarUsuario.class.getResource("/imagenes/icon-window.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setTitle("Registrar Usuario");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 800, 500, 25, 25));
		setSize(800, 500);
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
		
		lblTituloVentana = new JLabel("Registrar Usuario - Sesión de " + Login.user);
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
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCorreo.setBounds(30, 250, 100, 20);
		getContentPane().add(lblCorreo);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(30, 310, 100, 20);
		getContentPane().add(lblTelefono);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccion.setBounds(400, 70, 100, 20);
		getContentPane().add(lblDireccion);
		
		lblNivel = new JLabel("Nivel:");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNivel.setBounds(400, 130, 100, 20);
		getContentPane().add(lblNivel);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEstado.setBounds(400, 190, 100, 20);
		getContentPane().add(lblEstado);
		
		lblUser = new JLabel("Usuario:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(400, 250, 100, 20);
		getContentPane().add(lblUser);
		
		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(400, 310, 100, 20);
		getContentPane().add(lblPassword);
		
		txtCodigo = new JTextField();
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
		
		txtCorreo = new JTextField();
		txtCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCorreo.setForeground(Color.WHITE);
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCorreo.setColumns(10);
		txtCorreo.setBackground(Color.BLACK);
		txtCorreo.setBounds(135, 245, 200, 25);
		getContentPane().add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setForeground(Color.WHITE);
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(Color.BLACK);
		txtTelefono.setBounds(135, 305, 200, 25);
		getContentPane().add(txtTelefono);
		
		txtDireccion = new JTextField();
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setForeground(Color.WHITE);
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(Color.BLACK);
		txtDireccion.setBounds(520, 65, 220, 25);
		getContentPane().add(txtDireccion);
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setForeground(Color.WHITE);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUser.setColumns(10);
		txtUser.setBackground(Color.BLACK);
		txtUser.setBounds(520, 245, 220, 25);
		getContentPane().add(txtUser);
		
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBackground(Color.BLACK);
		txtPassword.setBounds(520, 305, 220, 25);
		getContentPane().add(txtPassword);
		
		cmbNivel = new JComboBox<String>();
		cmbNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbNivel.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrador", "Secretario", "Entrenador"}));
		cmbNivel.setForeground(Color.WHITE);
		cmbNivel.setBackground(Color.BLACK);
		cmbNivel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbNivel.setBounds(520, 125, 220, 25);
		getContentPane().add(cmbNivel);
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Activo", "Inactivo"}));
		cmbEstado.setForeground(Color.WHITE);
		cmbEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbEstado.setBackground(Color.BLACK);
		cmbEstado.setBounds(520, 185, 220, 25);
		getContentPane().add(cmbEstado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.addMouseListener(this);
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistrar.setBounds(300, 417, 200, 30);
		getContentPane().add(btnRegistrar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.codigoCorrelativo();
	}
	
	ArregloUsuarios objUsu = new ArregloUsuarios();
	
	
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
			String username = this.leerUserName();
			Usuario usu = objUsu.buscarUsuarioPorUserName(username);
			
			if(usu == null) {
				int codigo = this.leerCodigo();
				String nombre = this.leerNombre();
				String apellido = this.leerApellido();
				String correo = this.leerCorreo();
				String telefono = this.leerTelefono();
				String direccion = this.leerDireccion();
				String nivel = this.leerNivel();
				String estado = this.leerEstado();
				String pass = this.leerPassword();
				String registradopor = Login.user;
				
				objUsu.adicionarUsuario(
					new Usuario(codigo,nombre,apellido,correo,telefono,direccion,nivel,estado,
						username,pass,registradopor)
				);
				
				mensaje("Se registr� el usuario correctamente",
						"Registro correcto", 
						"src/imagenes/correcto.png");
				
				this.limpiarCampos();

			} else {
				txtUser.setBackground(Color.RED);
				mensaje("El usuario '" + username + "' ya existe.", "Aviso sobre usuario", "src/imagenes/informacion.png");
				txtUser.setBackground(Color.BLACK);
				txtUser.requestFocus();
			}
		}
	}
	
	private void mouseClickedPanelSalir() {
		new Administrador().setVisible(true);
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
			if(String.valueOf(codigo).length() > 0) {
				String nombre = this.leerNombre();
				if(nombre.length() > 0) {
					String apellido = this.leerApellido();
					if(apellido.length() > 0) {
						String correo = this.leerCorreo();
						if(correo.length()>0) {
							String telefono = this.leerTelefono();
							if(telefono.length()>0) {
								String direccion = this.leerDireccion();
								if(direccion.length()>0) {
									String username = this.leerUserName();
									if(username.length()>0) {
										String pass = this.leerPassword();
										if(pass.length()>0) {
											return true;
										} else {
											txtPassword.setBackground(Color.RED);
											mensaje("El campo 'Contrase�a' est� vac�o", "Contrase�a", "src/imagenes/advertencia.png");
											txtPassword.setBackground(Color.BLACK);
										}
									} else {
										txtUser.setBackground(Color.RED);
										mensaje("El campo 'Usuario' est� vac�o", "Usuario", "src/imagenes/advertencia.png");
										txtUser.setBackground(Color.BLACK);
									}
								} else {
									txtDireccion.setBackground(Color.RED);
									mensaje("El campo 'Direcci�n' est� vac�o", "Direcci�n", "src/imagenes/advertencia.png");
									txtDireccion.setBackground(Color.BLACK);
								}
							} else {
								txtTelefono.setBackground(Color.RED);
								mensaje("El campo 'Tel�fono' est� vac�o", "Tel�fono", "src/imagenes/advertencia.png");
								txtTelefono.setBackground(Color.BLACK);
							}
						} else {
							txtCorreo.setBackground(Color.RED);
							mensaje("El campo 'Correo' est� vac�o", "Correo", "src/imagenes/advertencia.png");
							txtCorreo.setBackground(Color.BLACK);
						}
					} else {
						txtApellido.setBackground(Color.RED);
						mensaje("El campo 'Apellidos' est� vac�o", "Apellidos", "src/imagenes/advertencia.png");
						txtApellido.setBackground(Color.BLACK);
					}
				} else {
					txtNombre.setBackground(Color.RED);
					mensaje("El campo 'Nombres' est� vac�o", "Nombres", "src/imagenes/advertencia.png");
					txtNombre.setBackground(Color.BLACK);
				}
			} else {
				txtCodigo.setBackground(Color.RED);
				mensaje("El campo 'Codigo' est� vac�o", "Codigo", "src/imagenes/advertencia.png");
				txtCodigo.setBackground(Color.BLACK);
			}
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error en Registrar Usuario " + ex);
			mensaje("�Error! Contacte al administrador", "Error Registrar Usuario", "src/imagenes/error.png");
		}
		return false;
	}
	
	private void limpiarCampos() {
		this.codigoCorrelativo();
		txtNombre.setText("");
		txtApellido.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		cmbNivel.setSelectedIndex(0);
		cmbEstado.setSelectedIndex(0);
		txtUser.setText("");
		txtPassword.setText("");
	}
	
	/*Metodos de mensaje*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	/*Metodos adicionales*/
	private void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
	
	/*Codigo Correlativo*/
	private void codigoCorrelativo() {
		txtCodigo.setText(String.valueOf(objUsu.codigoCorrelativoUsuario()));
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
	private String leerCorreo() {
		return txtCorreo.getText().trim();
	}
	private String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	private String leerDireccion() {
		return txtDireccion.getText().trim();
	}
	private String leerNivel() {
		return cmbNivel.getSelectedItem().toString().trim();
	}
	private String leerEstado() {
		return cmbEstado.getSelectedItem().toString().trim();
	}
	private String leerUserName() {
		return txtUser.getText().trim();
	}
	private String leerPassword() {
		return String.valueOf(txtPassword.getPassword()).trim();
	}
	
	
}
