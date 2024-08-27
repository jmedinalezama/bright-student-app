package ventanas;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Toolkit;
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
import javax.swing.JScrollPane;

import arreglos.ArregloFicha;
import clases.FichaJugador;

import javax.swing.JTextArea;


public class VerFichaSecretario extends JDialog implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JScrollPane scpScroll;
	private JTextArea textADatos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerFichaSecretario dialog = new VerFichaSecretario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerFichaSecretario() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerFichaSecretario.class.getResource("/imagenes/icon-window.png")));
		setTitle("Ver Ficha - Secretario");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 600, 500, 25, 25));
		setSize(600, 500);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		panelBar = new JPanel();
		panelBar.addMouseListener(this);
		panelBar.addMouseMotionListener(this);
		panelBar.setBackground(Color.CYAN);
		panelBar.setBounds(0, 0, 600, 30);
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
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalir.setBounds(0, 0, 30, 30);
		panelSalir.add(lblSalir);
		
		lblTituloVentana = new JLabel("Ver Ficha de Jugador - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 600, 30);
		panelBar.add(lblTituloVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(570, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(50, 60, 500, 380);
		getContentPane().add(scpScroll);
		
		textADatos = new JTextArea();
		textADatos.setEditable(false);
		textADatos.setFont(new Font("Monospaced", Font.PLAIN, 18));
		scpScroll.setViewportView(textADatos);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 600, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.cargarDatos();
	}

	
	ArregloFicha objFiJug = new ArregloFicha();
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
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
	
	
	
	public void mouseClickedPanelSalir() {
		new InformacionJugador().setVisible(true);
		this.dispose();
	}
	
	
	
	public void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	
	
	
	
	public void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	
	
	
	
	public void mousePressedPanelBar(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
		panelBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	
	
	public void mouseReleasedPanelBar() {
		panelBar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	
	
	public void mouseDraggedPanelBar(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		this.setLocation(x - xMouse, y-yMouse);
	}
	
	
	/*Metodos adicionales*/
	public void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
	
	/*visualizar datos del apoderado*/
	private void cargarDatos() {
		
		FichaJugador fi_jug = objFiJug.buscarFicha(InformacionJugador.codigofichaseleccion);
		
		if(fi_jug != null) {
			imprimir(" -----------------------------------");
			imprimir(" -        DATOS DE LA FICHA        -");
			imprimir(" -----------------------------------\n");
			imprimir("   Código              : " + fi_jug.getCodigoficha());
			imprimir("   Categoria           : " + fi_jug.getCategoria());
			imprimir("   Pierna hábil        : " + fi_jug.getPiernahabil());
			imprimir("   Posición            : " + fi_jug.getPosicion());
			imprimir("   Control de balón    : " + this.valoracionDeFicha(fi_jug.getControlbalon()));
			imprimir("   Conducción          : " + this.valoracionDeFicha(fi_jug.getConduccion()));
			imprimir("   Visión              : " + this.valoracionDeFicha(fi_jug.getVision()));
			imprimir("   Cabeceo             : " + this.valoracionDeFicha(fi_jug.getCabeceo()));
			imprimir("   Dribling            : " + this.valoracionDeFicha(fi_jug.getDribling()));
			imprimir("   Cambio de ritmo     : " + this.valoracionDeFicha(fi_jug.getCambioderitmo()));
			imprimir("   Definición          : " + this.valoracionDeFicha(fi_jug.getDefinicion()));
			imprimir("   Penal               : " + this.valoracionDeFicha(fi_jug.getPenal()));
			imprimir("   Tiro libre          : " + this.valoracionDeFicha(fi_jug.getTirolibre()));
			imprimir("   Resistencia         : " + this.valoracionDeFicha(fi_jug.getResistencia()));
			imprimir("   Potencia            : " + this.valoracionDeFicha(fi_jug.getPotencia()));
			imprimir("   Flexibilidad        : " + this.valoracionDeFicha(fi_jug.getFlexibilidad()));
			imprimir("   Velocidad           : " + this.valoracionDeFicha(fi_jug.getVelocidad()));
			imprimir("   Valoración jug.     : " + this.valoracionDeFicha(fi_jug.valoracionJugador()));
			imprimir("   Ultima modificación : " + fi_jug.getUltimamodificacion());
			imprimir("");
			
		} else {
			mensaje("La ficha no se encontró", "¡Error!", "src/imagenes/error.png");
		}
	}
	
	private void imprimir(String texto) {
		textADatos.append(texto + "\n");
	}
	
	/*mensaje*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	/*Ver valoracion de la ficha en texto*/
	private String valoracionDeFicha(int numero) {
		switch(numero) {
		case 5: return "Excelente";
		case 4: return "Bueno";
		case 3: return "Aceptable";
		case 2: return "Regular";
		default: return "Deficiente";
		}
	}
	
}
