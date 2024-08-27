package ventanas;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import arreglos.ArregloUsuarios;
import clases.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	
	private int xMouse, yMouse;
	public static String user;
	
	private JPanel contentPane;
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblPassword;
	private JPasswordField txtPassword;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Iniciar Sesi\u00F3n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagenes/icon-window.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 400, 500, 25, 25));
		setSize(400, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBar = new JPanel();
		panelBar.addMouseListener(this);
		panelBar.addMouseMotionListener(this);
		panelBar.setBackground(Color.CYAN);
		panelBar.setBounds(0, 0, 400, 30);
		contentPane.add(panelBar);
		panelBar.setLayout(null);
		
		panelSalir = new JPanel();
		panelSalir.addMouseListener(this);
		panelSalir.setBackground(new Color(225,100,100));
		panelSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSalir.setBounds(0, 0, 30, 30);
		panelBar.add(panelSalir);
		panelSalir.setLayout(null);
		
		lblSalir = new JLabel("X");
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(0, 0, 30, 30);
		panelSalir.add(lblSalir);
		
		lblTituloVentana = new JLabel("Iniciar Sesi\u00F3n");
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setBounds(0, 0, 400, 30);
		panelBar.add(lblTituloVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(370, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(0, 100, 400, 30);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setBackground(Color.BLACK);
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsuario.setBounds(75, 137, 250, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(0, 200, 400, 30);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(Color.BLACK);
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setBounds(75, 240, 250, 30);
		contentPane.add(txtPassword);
		
		btnIngresar = new JButton("Aceptar");
		btnIngresar.addActionListener(this);
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.addMouseListener(this);
		btnIngresar.setBorder(new LineBorder(Color.GREEN, 2));
		btnIngresar.setBackground(Color.BLACK);
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setBounds(140, 310, 120, 30);
		contentPane.add(btnIngresar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 400, 470);
		contentPane.add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo2.jpg", lblFondo);
	}
	
	ArregloUsuarios objUsu = new ArregloUsuarios();
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIngresar) {
			this.actionPerformedBtnAceptar();
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
		if(e.getSource() == btnIngresar) {
			this.mouseEnteredBtnIngresar();
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnIngresar) {
			this.mouseExitedBtnIngresar();
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
	
	
	
	
	
	
	private void actionPerformedBtnAceptar() {
		try {
			user = this.leerUserName();
			if(user.length() > 0) {
				String password = this.leerPassword();
				if(password.length() > 0) {
					
					Usuario usu = objUsu.buscarUsuarioPorUserName(user);
					
					if(usu != null) {
						
						this.validarDatosIngresados(user, password, usu);
						
					} else {
						mensaje("El usuario '" + user + "' no se encuentra registrado", 
								"No se encontr� usuario", "src/imagenes/error.png");
					}
					
				} else {
					txtPassword.setBackground(new Color(255,0,0));
					mensaje("El campo 'contrase�a' est� vac�o", "Contrase�a", "src/imagenes/advertencia.png");
					txtPassword.setBackground(Color.BLACK);
				}
				
			} else {
				txtUsuario.setBackground(new Color(255,0,0));
				mensaje("El campo 'usuario' est� vac�o", "Usuario", "src/imagenes/advertencia.png");
				txtUsuario.setBackground(Color.BLACK);
			}
			
			
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error al iniciar sesi�n " + ex);
			mensaje("�Error! Contacte al administrador", "Error al iniciar sesi�n", "src/imagenes/error.png");
		}
	}
	
	
	private void mouseClickedPanelSalir() {
		this.dispose();
		System.exit(0);
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnIngresar() {
		btnIngresar.setBorder(new LineBorder(Color.WHITE, 2));
		btnIngresar.setBackground(new Color(10,240,0));
		btnIngresar.setForeground(new Color(0,0,0));
		btnIngresar.setText("ACEPTAR");
	}
	
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnIngresar() {
		btnIngresar.setBorder(new LineBorder(Color.GREEN, 2));
		btnIngresar.setBackground(new Color(0,0,0));
		btnIngresar.setForeground(new Color(255,255,255));
		btnIngresar.setText("Aceptar");
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
	
	
	/*Metodos para manejar el Frame*/
	private void validarDatosIngresados(String user, String pass, Usuario usu) {
		if(usu.getUsername().equalsIgnoreCase(user) && usu.getPassword().equalsIgnoreCase(pass)) {
			if(usu.getEstadousuario().equalsIgnoreCase("Activo")) {
				
				if(usu.getNivelusuario().equalsIgnoreCase("Administrador")) {
					new Administrador().setVisible(true);
					
				} else if(usu.getNivelusuario().equalsIgnoreCase("Secretario")) {
					new Secretario().setVisible(true);
					
				} else if(usu.getNivelusuario().equalsIgnoreCase("Entrenador")) {
					new Entrenador().setVisible(true);
					
				}
				
				this.dispose();
				
			} else {
				mensaje("El usuario '" + user + "' actualmente se encuentra inactivo.\n"+
						"Contacte con el administrador.", "Usuario Inactivo", "src/imagenes/informacion.png");
			}
		} else {
			mensaje("Datos incorrectos", "�Error!", "src/imagenes/error.png");
		}
	}
	
	
	
	
	
	/*Metodos para leer los datos*/
	private String leerUserName() {
		return txtUsuario.getText().trim();
	}
	private String leerPassword() {
		return String.valueOf(txtPassword.getPassword()).trim();
	}
	
	
	
	/*mensaje y confirmacion*/
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
}
