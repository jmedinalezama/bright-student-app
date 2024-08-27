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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrador extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private int xMouse, yMouse;
	private String username = Login.user;

	private JPanel contentPane;
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JPanel panelMinimizar;
	private JLabel lblMinimizar;
	private JLabel lblLogo;
	private JLabel lblLogout;
	private JLabel lblCerrarSesion;
	private JButton btnRegistrarUsuario;
	private JButton btnGestionarUsuario;
	private JButton btnCreadoPor;
	private JButton btnVistaSecretario;
	private JButton btnVistaEntrenador;
	private JLabel lblRegistrarUsuario;
	private JLabel lblGestionarUsuario;
	private JLabel lblCreadoPor;
	private JLabel lblVistaSecretario;
	private JLabel lblVistaEntrenador;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		setTitle("Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/imagenes/icon-window.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0,0,800,500,25,25));
		setSize(800,500);
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
		panelBar.setBounds(0, 0, 800, 30);
		contentPane.add(panelBar);
		panelBar.setLayout(null);
		
		panelSalir = new JPanel();
		panelSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSalir.addMouseListener(this);
		panelSalir.setBounds(0, 0, 30, 30);
		panelSalir.setBackground(new Color(255, 100, 100));
		panelBar.add(panelSalir);
		panelSalir.setLayout(null);
		
		lblSalir = new JLabel("X");
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setBounds(0, 0, 30, 30);
		panelSalir.add(lblSalir);
		
		panelMinimizar = new JPanel();
		panelMinimizar.addMouseListener(this);
		panelMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMinimizar.setBounds(30, 0, 30, 30);
		panelMinimizar.setBackground(new Color(125,245,120));
		panelBar.add(panelMinimizar);
		panelMinimizar.setLayout(null);
		
		lblMinimizar = new JLabel("-");
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMinimizar.setBounds(0, 0, 30, 30);
		panelMinimizar.add(lblMinimizar);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(770, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblLogout = new JLabel("logout");
		lblLogout.addMouseListener(this);
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setBounds(740, 2, 26, 26);
		panelBar.add(lblLogout);
		this.colocarImagenLabel("src/imagenes/logout.png", lblLogout);
		
		lblCerrarSesion = new JLabel("Cerrar Sesión");
		lblCerrarSesion.setVisible(false);
		lblCerrarSesion.setBounds(657, 8, 86, 14);
		panelBar.add(lblCerrarSesion);
		
		lblTituloVentana = new JLabel("Administrador - Sesión de " + username);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setBounds(0, 0, 800, 30);
		panelBar.add(lblTituloVentana);
		
		btnRegistrarUsuario = new JButton("");
		btnRegistrarUsuario.addActionListener(this);
		btnRegistrarUsuario.addMouseListener(this);
		btnRegistrarUsuario.setBackground(Color.LIGHT_GRAY);
		btnRegistrarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarUsuario.setBorder(new LineBorder(Color.WHITE, 2));
		btnRegistrarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRegistrarUsuario.setBounds(125, 60, 100, 100);
		contentPane.add(btnRegistrarUsuario);
		this.colocarImagenButton("src/imagenes/agregarusuario.png", btnRegistrarUsuario);
		
		btnGestionarUsuario = new JButton("");
		btnGestionarUsuario.addActionListener(this);
		btnGestionarUsuario.addMouseListener(this);
		btnGestionarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGestionarUsuario.setBackground(Color.LIGHT_GRAY);
		btnGestionarUsuario.setBorder(new LineBorder(Color.WHITE, 2));
		btnGestionarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGestionarUsuario.setBounds(350, 60, 100, 100);
		contentPane.add(btnGestionarUsuario);
		this.colocarImagenButton("src/imagenes/gestionusuario.png", btnGestionarUsuario);
		
		btnCreadoPor = new JButton("");
		btnCreadoPor.addActionListener(this);
		btnCreadoPor.addMouseListener(this);
		btnCreadoPor.setBackground(Color.LIGHT_GRAY);
		btnCreadoPor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreadoPor.setBorder(new LineBorder(Color.WHITE, 2));
		btnCreadoPor.setBounds(575, 60, 100, 100);
		contentPane.add(btnCreadoPor);
		this.colocarImagenButton("src/imagenes/j.png", btnCreadoPor);
		
		btnVistaSecretario = new JButton("");
		btnVistaSecretario.addActionListener(this);
		btnVistaSecretario.addMouseListener(this);
		btnVistaSecretario.setBorder(new LineBorder(Color.WHITE, 2));
		btnVistaSecretario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVistaSecretario.setBackground(Color.LIGHT_GRAY);
		btnVistaSecretario.setBounds(200, 260, 100, 100);
		contentPane.add(btnVistaSecretario);
		this.colocarImagenButton("src/imagenes/secretario.png", btnVistaSecretario);
		
		btnVistaEntrenador = new JButton("");
		btnVistaEntrenador.addActionListener(this);
		btnVistaEntrenador.addMouseListener(this);
		btnVistaEntrenador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVistaEntrenador.setBorder(new LineBorder(Color.WHITE, 2));
		btnVistaEntrenador.setBackground(Color.LIGHT_GRAY);
		btnVistaEntrenador.setBounds(500, 260, 100, 100);
		contentPane.add(btnVistaEntrenador);
		this.colocarImagenButton("src/imagenes/entrenador.png", btnVistaEntrenador);
		
		lblRegistrarUsuario = new JLabel("Registrar Usuario");
		lblRegistrarUsuario.setForeground(Color.WHITE);
		lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistrarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarUsuario.setBounds(100, 170, 150, 20);
		contentPane.add(lblRegistrarUsuario);
		
		lblGestionarUsuario = new JLabel("Gestionar Usuarios");
		lblGestionarUsuario.setForeground(Color.WHITE);
		lblGestionarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGestionarUsuario.setBounds(325, 170, 150, 20);
		contentPane.add(lblGestionarUsuario);
		
		lblCreadoPor = new JLabel("Creado Por");
		lblCreadoPor.setForeground(Color.WHITE);
		lblCreadoPor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreadoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreadoPor.setBounds(550, 170, 150, 20);
		contentPane.add(lblCreadoPor);
		
		lblVistaSecretario = new JLabel("Vista Secretario");
		lblVistaSecretario.setForeground(Color.WHITE);
		lblVistaSecretario.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaSecretario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVistaSecretario.setBounds(175, 370, 150, 20);
		contentPane.add(lblVistaSecretario);
		
		lblVistaEntrenador = new JLabel("Vista Entrenador");
		lblVistaEntrenador.setForeground(Color.WHITE);
		lblVistaEntrenador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVistaEntrenador.setHorizontalAlignment(SwingConstants.CENTER);
		lblVistaEntrenador.setBounds(477, 370, 150, 20);
		contentPane.add(lblVistaEntrenador);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 470);
		contentPane.add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrarUsuario) {
			this.actionPerformedBtnRegistrarUsuario();
		}
		if(e.getSource() == btnGestionarUsuario) {
			this.actionPerformedBtnGestionarUsuario();
		}
		if(e.getSource() == btnCreadoPor) {
			this.actionPerformedBtnCreadoPor();
		}
		if(e.getSource() == btnVistaSecretario) {
			this.actionPerformedBtnVistaSecretario();
		}
		if(e.getSource() == btnVistaEntrenador) {
			this.actionPerformedBtnVistaEntrenador();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == panelMinimizar) {
			this.mouseClickedPanelMinimizar();
		}
		if(e.getSource() == lblLogout) {
			this.mouseClikedLblLogout();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == panelMinimizar) {
			this.mouseEnteredPanelMinimizar();
		}
		if(e.getSource() == lblLogout) {
			this.mouseEnteredLblLogout();
		}
		if(e.getSource() == btnRegistrarUsuario) {
			this.mouseEnteredBtnX("src/imagenes/agregarusuario.png", btnRegistrarUsuario, lblRegistrarUsuario);
		}
		if(e.getSource() == btnGestionarUsuario) {
			this.mouseEnteredBtnX("src/imagenes/gestionusuario.png", btnGestionarUsuario, lblGestionarUsuario);
		}
		if(e.getSource() == btnCreadoPor) {
			this.mouseEnteredBtnX("src/imagenes/j.png", btnCreadoPor, lblCreadoPor);
		}
		if(e.getSource() == btnVistaSecretario) {
			this.mouseEnteredBtnX("src/imagenes/secretario.png", btnVistaSecretario, lblVistaSecretario);
		}
		if(e.getSource() == btnVistaEntrenador) {
			this.mouseEnteredBtnX("src/imagenes/entrenador.png", btnVistaEntrenador, lblVistaEntrenador);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == panelMinimizar) {
			this.mouseExitedPanelMinimizar();
		}
		if(e.getSource() == lblLogout) {
			this.mouseExitedLblLogout();
		}
		if(e.getSource() == btnRegistrarUsuario) {
			this.mouseExitedBtnX("src/imagenes/agregarusuario.png", btnRegistrarUsuario, lblRegistrarUsuario);
		}
		if(e.getSource() == btnGestionarUsuario) {
			this.mouseExitedBtnX("src/imagenes/gestionusuario.png", btnGestionarUsuario, lblGestionarUsuario);
		}
		if(e.getSource() == btnCreadoPor) {
			this.mouseExitedBtnX("src/imagenes/j.png", btnCreadoPor, lblCreadoPor);
		}
		if(e.getSource() == btnVistaSecretario) {
			this.mouseExitedBtnX("src/imagenes/secretario.png", btnVistaSecretario, lblVistaSecretario);
		}
		if(e.getSource() == btnVistaEntrenador) {
			this.mouseExitedBtnX("src/imagenes/entrenador.png", btnVistaEntrenador, lblVistaEntrenador);
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
	
	
	
	
	
	private void actionPerformedBtnRegistrarUsuario() {
		new RegistrarUsuario().setVisible(true);
		this.dispose();
	}
	
	private void actionPerformedBtnGestionarUsuario() {
		new GestionarUsuarios().setVisible(true);
		this.dispose();
	}
	
	private void actionPerformedBtnCreadoPor() {
		mensaje("Sistema creado por Jerson Medina", "Creado Por", "src/imagenes/creadopor.png");
	}

	private void actionPerformedBtnVistaSecretario() {
		new Secretario().setVisible(true);
		this.dispose();
	}

	private void actionPerformedBtnVistaEntrenador() {
		new Entrenador().setVisible(true);
		this.dispose();
	
	}
	
	private void mouseClickedPanelSalir() {
		this.dispose();
		System.exit(0);
	}
	private void mouseClickedPanelMinimizar() {
		this.setExtendedState(1);
	}
	
	private void mouseClikedLblLogout() {
		new Login().setVisible(true);
		this.dispose();
	}
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredPanelMinimizar() {
		panelMinimizar.setBackground(new Color(10,240,0));
		lblMinimizar.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredLblLogout() {
		lblCerrarSesion.setVisible(true);
	}
	private void mouseEnteredBtnX(String ruta, JButton boton, JLabel label) {
		boton.setBorder(new LineBorder(Color.GREEN, 2));
		boton.setBounds(boton.getX()+3, boton.getY()+3, boton.getWidth()-6, boton.getHeight()-6);
		boton.setBackground(new Color(0,255,0));
		this.colocarImagenButton(ruta, boton);
		label.setForeground(Color.GREEN);
	}
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedPanelMinimizar() {
		panelMinimizar.setBackground(new Color(125,245,120));
		lblMinimizar.setForeground(new Color(0,0,0));
	}
	private void mouseExitedLblLogout() {
		lblCerrarSesion.setVisible(false);
	}
	private void mouseExitedBtnX(String ruta, JButton boton, JLabel label) {
		boton.setBorder(new LineBorder(Color.WHITE, 2));
		boton.setBounds(boton.getX()-3, boton.getY()-3, boton.getWidth()+6, boton.getHeight()+6);
		boton.setBackground(Color.LIGHT_GRAY);
		this.colocarImagenButton(ruta, boton);
		label.setForeground(Color.WHITE);
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
	private void colocarImagenButton(String ruta, JButton boton) {
		ImageIcon imgboton = new ImageIcon(ruta);
		Icon icon_imgboton = new ImageIcon(imgboton.getImage().getScaledInstance(boton.getWidth()-5, boton.getHeight()-5, 
				Image.SCALE_DEFAULT));
		boton.setIcon(icon_imgboton);
		this.repaint();
	}
}
