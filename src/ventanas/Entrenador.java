package ventanas;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
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

import arreglos.ArregloUsuarios;
import clases.Usuario;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Entrenador extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	
	
	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	ArregloUsuarios objUsu = new ArregloUsuarios();

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
	private JButton btnGestionarFicha;
	private JButton btnListarFichas;
	private JLabel lblGestionarFicha;
	private JLabel lblListarFichas;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrenador frame = new Entrenador();
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
	public Entrenador() {
		setTitle("Entrenador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Entrenador.class.getResource("/imagenes/icon-window.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0,0,600,400,25,25));
		setSize(600,400);
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
		panelBar.setBounds(0, 0, 600, 30);
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
		lblLogo.setBounds(570, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblLogout = new JLabel("logout");
		lblLogout.addMouseListener(this);
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setBounds(540, 2, 26, 26);
		panelBar.add(lblLogout);
		this.colocarImagenLabel("src/imagenes/logout.png", lblLogout);
		
		lblCerrarSesion = new JLabel("Cerrar Sesión");
		lblCerrarSesion.setVisible(false);
		lblCerrarSesion.setBounds(457, 8, 86, 14);
		panelBar.add(lblCerrarSesion);
		
		lblTituloVentana = new JLabel("Entrenador - Sesión de " + Login.user);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setBounds(0, 0, 600, 30);
		panelBar.add(lblTituloVentana);
		
		btnGestionarFicha = new JButton("");
		btnGestionarFicha.addActionListener(this);
		btnGestionarFicha.addMouseListener(this);
		btnGestionarFicha.setBackground(Color.LIGHT_GRAY);
		btnGestionarFicha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGestionarFicha.setBorder(new LineBorder(Color.WHITE, 2));
		btnGestionarFicha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGestionarFicha.setBounds(109, 127, 100, 100);
		contentPane.add(btnGestionarFicha);
		this.colocarImagenButton("src/imagenes/fichajugador.png", btnGestionarFicha);
		
		btnListarFichas = new JButton("");
		btnListarFichas.addActionListener(this);
		btnListarFichas.addMouseListener(this);
		btnListarFichas.setBorder(new LineBorder(Color.WHITE, 2));
		btnListarFichas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListarFichas.setBackground(Color.LIGHT_GRAY);
		btnListarFichas.setBounds(382, 127, 100, 100);
		contentPane.add(btnListarFichas);
		this.colocarImagenButton("src/imagenes/fichas.png", btnListarFichas);
		
		lblGestionarFicha = new JLabel("Gestionar Ficha Jugador");
		lblGestionarFicha.setForeground(Color.WHITE);
		lblGestionarFicha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGestionarFicha.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarFicha.setBounds(60, 237, 200, 20);
		contentPane.add(lblGestionarFicha);
		
		lblListarFichas = new JLabel("Listar Todas las Fichas");
		lblListarFichas.setForeground(Color.WHITE);
		lblListarFichas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListarFichas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListarFichas.setBounds(335, 237, 200, 20);
		contentPane.add(lblListarFichas);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 600, 370);
		contentPane.add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.validarLogout();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGestionarFicha) {
			this.actionPerformedBtnGestionarFichas();
		}
		if(e.getSource() == btnListarFichas) {
			this.actionPerformedBtnListarFichas();
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
			this.mouseClickedLblLogout();
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
		if(e.getSource() == btnGestionarFicha) {
			this.mouseEnteredBtnX("src/imagenes/fichajugador.png", btnGestionarFicha, lblGestionarFicha);
		}
		if(e.getSource() == btnListarFichas) {
			this.mouseEnteredBtnX("src/imagenes/fichas.png", btnListarFichas, lblListarFichas);
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
		if(e.getSource() == btnGestionarFicha) {
			this.mouseExitedBtnX("src/imagenes/fichajugador.png", btnGestionarFicha, lblGestionarFicha);
		}
		if(e.getSource() == btnListarFichas) {
			this.mouseExitedBtnX("src/imagenes/fichas.png", btnListarFichas, lblListarFichas);
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
	
	
	
	
	private void actionPerformedBtnGestionarFichas() {
		new GestionarFichaJug().setVisible(true);
		this.dispose();
	}
	
	private void actionPerformedBtnListarFichas() {
		new ListaDeFichas().setVisible(true);
		this.dispose();
	}
	
	private void mouseClickedPanelSalir() {
		Usuario usu = objUsu.buscarUsuarioPorUserName(Login.user);
		
		if(usu.getNivelusuario().equalsIgnoreCase("Administrador")) {
			new Administrador().setVisible(true);
			this.dispose();
		} else {
			this.dispose();
			System.exit(0);
		}
	}
	private void mouseClickedPanelMinimizar() {
		this.setExtendedState(1);
	}
	private void mouseClickedLblLogout() {
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
	
	
	/*Validar Logout*/
	private void validarLogout() {
		Usuario usu = objUsu.buscarUsuarioPorUserName(Login.user);
		if(usu.getNivelusuario().equalsIgnoreCase("Administrador")) {
			lblLogout.setVisible(false);
		} else {
			lblLogout.setVisible(true);
		}
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
