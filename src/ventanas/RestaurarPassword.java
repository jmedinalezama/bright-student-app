package ventanas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import arreglos.ArregloUsuarios;
import clases.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RestaurarPassword extends JDialog implements ActionListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel contentPane;
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JLabel lblNuevoPassword;
	private JLabel lblConfirmarPassword;
	private JPasswordField txtConfirmarPassword;
	private JButton btnConfirmar;
	private JPasswordField txtNuevoPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RestaurarPassword dialog = new RestaurarPassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RestaurarPassword() {
		setTitle("Restaurar Password");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RestaurarPassword.class.getResource("/imagenes/icon-window.png")));
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 400, 300, 25, 25));
		setSize(400, 300);
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
		
		lblSalir = new JLabel("<-");
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(0, 0, 30, 30);
		panelSalir.add(lblSalir);
		
		lblTituloVentana = new JLabel("Restaurar Password");
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setBounds(0, 0, 400, 30);
		panelBar.add(lblTituloVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(370, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblNuevoPassword = new JLabel("Nueva Contrase\u00F1a:");
		lblNuevoPassword.setForeground(Color.WHITE);
		lblNuevoPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNuevoPassword.setBounds(0, 41, 400, 30);
		contentPane.add(lblNuevoPassword);
		
		txtNuevoPassword = new JPasswordField();
		txtNuevoPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtNuevoPassword.setForeground(Color.WHITE);
		txtNuevoPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNuevoPassword.setBackground(Color.BLACK);
		txtNuevoPassword.setBounds(75, 82, 250, 30);
		contentPane.add(txtNuevoPassword);
		
		lblConfirmarPassword = new JLabel("Confirmar Nueva Contrase\u00F1a:");
		lblConfirmarPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmarPassword.setForeground(Color.WHITE);
		lblConfirmarPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmarPassword.setBounds(0, 130, 400, 30);
		contentPane.add(lblConfirmarPassword);
		
		txtConfirmarPassword = new JPasswordField();
		txtConfirmarPassword.setBackground(Color.BLACK);
		txtConfirmarPassword.setForeground(Color.WHITE);
		txtConfirmarPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmarPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConfirmarPassword.setBounds(75, 171, 250, 30);
		contentPane.add(txtConfirmarPassword);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.addMouseListener(this);
		btnConfirmar.setBorder(new LineBorder(Color.GREEN, 2));
		btnConfirmar.setBackground(Color.BLACK);
		btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmar.setBounds(139, 230, 120, 30);
		contentPane.add(btnConfirmar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 400, 270);
		contentPane.add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
	}
	
	ArregloUsuarios objUsu = new ArregloUsuarios();
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConfirmar) {
			this.actionPerformedBtnConfirmar();
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
		if(e.getSource() == btnConfirmar) {
			this.mouseEnteredBtnIngresar();
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnConfirmar) {
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
	
	
	
	
	private void actionPerformedBtnConfirmar() {
		
		String pass1 = String.valueOf(txtNuevoPassword.getPassword()).trim();
		if(pass1.length()>0) {
			String pass2 = String.valueOf(txtConfirmarPassword.getPassword()).trim();
			if(pass2.length()>0) {
				if(pass1.equals(pass2)) {
					
					int opcion = confirmar("Presione 'Aceptar' para confirmar cambio de contrase�a", 
							"Cambio de contrase�a", "src/imagenes/confirmar.png");
					
					if(opcion == 0) {
						Usuario usu = objUsu.buscarUsuarioPorCodigo(GestionarUsuarios.updatecodigo);
						usu.setPassword(pass1);
						objUsu.grabarUsuarios();
						
						mensaje("Se modific� la contrase�a correctamente",
								"Modificaci�n correcta", 
								"src/imagenes/correcto.png");
						
						new InformacionUsuario().setVisible(true);
						this.dispose();
						
					} 
				} else {
					mensaje("La contrase�as no coinciden, intente de nuevo", "Contrase�as diferentes", "src/imagenes/error.png");
				}
			}else {
				txtConfirmarPassword.setBackground(Color.RED);
				mensaje("El campo 'Confirmar nueva contrase�a' est� vac�o", "Confirmar Nueva Contrase�a", "src/imagenes/advertencia.png");
				txtConfirmarPassword.setBackground(Color.BLACK);
			}
		} else {
			txtNuevoPassword.setBackground(Color.RED);
			mensaje("El campo 'Nueva contrase�a' est� vac�o", "Nueva Contrase�a", "src/imagenes/advertencia.png");
			txtNuevoPassword.setBackground(Color.BLACK);
		}
		
	}
	
	private void mouseClickedPanelSalir() {
		new InformacionUsuario().setVisible(true);
		this.dispose();
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnIngresar() {
		btnConfirmar.setBorder(new LineBorder(Color.WHITE, 2));
		btnConfirmar.setBackground(new Color(10,240,0));
		btnConfirmar.setForeground(new Color(0,0,0));
		btnConfirmar.setText("CONFIRMAR");
	}
	
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnIngresar() {
		btnConfirmar.setBorder(new LineBorder(Color.GREEN, 2));
		btnConfirmar.setBackground(new Color(0,0,0));
		btnConfirmar.setForeground(new Color(255,255,255));
		btnConfirmar.setText("Confirmar");
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
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), 
				Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}

}
