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

import arreglos.ArregloApoderados;
import arreglos.ArregloFicha;
import arreglos.ArregloJugador;
import arreglos.ArregloMatriculas;
import clases.Apoderado;
import clases.FichaJugador;
import clases.Jugador;
import clases.Matricula;

import javax.swing.JTextArea;

public class VerDatosCompletosJug extends JDialog implements MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JScrollPane scpScroll;
	private JTextArea textADatosJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerDatosCompletosJug dialog = new VerDatosCompletosJug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerDatosCompletosJug() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerDatosCompletosJug.class.getResource("/imagenes/icon-window.png")));
		setTitle("Ver Datos Completos del Jugador");
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
		
		lblTituloVentana = new JLabel("Ver Datos Completos del Jugador - Sesión de " + Login.user);
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
		
		textADatosJugador = new JTextArea();
		textADatosJugador.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textADatosJugador.setEditable(false);
		scpScroll.setViewportView(textADatosJugador);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 600, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.cargarDatos();
		
	}
	
	ArregloApoderados objApo = new ArregloApoderados();
	ArregloFicha objFiJug = new ArregloFicha();
	ArregloJugador objJug = new ArregloJugador();
	ArregloMatriculas objMat = new ArregloMatriculas();

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
	
	
	
	private void mouseClickedPanelSalir() {
		new InformacionJugador().setVisible(true);
		this.dispose();
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
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
	
	
	/*Metodos adicionales*/
	private void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
	
	/*visualizar los datos*/
	private void cargarDatos() {
		Jugador jug = objJug.buscarJugadorPorCodigo(GestionarJugadores.codigojugadorseleccionado);
		FichaJugador fi_jug = objFiJug.buscarFicha(InformacionJugador.codigofichaseleccion);
		Matricula mat = objMat.buscarMatricula(InformacionJugador.codigomatriculaseleccion);
		Apoderado apo = objApo.buscarApoderado(InformacionJugador.codigoapoderadoseleccion);
		
		if((apo != null) && (jug != null) && (fi_jug != null) && (mat != null)) {
			imprimir("\n   DATOS COMPLETOS DEL JUGADOR\n");
			imprimir(" -----------------------------------");
			imprimir(" -       DATOS DEL JUGADOR         -");
			imprimir(" -----------------------------------\n");
			imprimir("   Código            : " + jug.getCodigojugador());
			imprimir("   Nombres           : " + jug.getNombrejugador());
			imprimir("   Apellidos         : " + jug.getApellidojugador());
			imprimir("   DNI               : " + jug.getDnijugador());
			imprimir("   Fecha nacimiento  : " + this.fechaNacimiento(jug));
			imprimir("   Edad              : " + jug.getEdadjugador());
			imprimir("   Estatura          : " + jug.getEstaturajugador());
			imprimir("   Peso              : " + jug.getPesojugador());
			imprimir("   Dirección         : " + jug.getDireccionjugador());
			imprimir("   Teléfono          : " + jug.getTelefonojugador());
			imprimir("");
			imprimir(" -----------------------------------");
			imprimir(" -     DATOS FICHA DE JUGADOR      -");
			imprimir(" -----------------------------------\n");
			imprimir("   Código            : " + fi_jug.getCodigoficha());
			imprimir("   Categoria         : " + fi_jug.getCategoria());
			imprimir("   Pierna hábil      : " + fi_jug.getPiernahabil());
			imprimir("   Posición          : " + fi_jug.getPosicion());
			imprimir("   Control de balón  : " + this.valoracionDeFicha(fi_jug.getControlbalon()));
			imprimir("   Conducción        : " + this.valoracionDeFicha(fi_jug.getConduccion()));
			imprimir("   Visión            : " + this.valoracionDeFicha(fi_jug.getVision()));
			imprimir("   Cabeceo           : " + this.valoracionDeFicha(fi_jug.getCabeceo()));
			imprimir("   Dribling          : " + this.valoracionDeFicha(fi_jug.getDribling()));
			imprimir("   Cambio de ritmo   : " + this.valoracionDeFicha(fi_jug.getCambioderitmo()));
			imprimir("   Definición        : " + this.valoracionDeFicha(fi_jug.getDefinicion()));
			imprimir("   Penal             : " + this.valoracionDeFicha(fi_jug.getPenal()));
			imprimir("   Tiro libre        : " + this.valoracionDeFicha(fi_jug.getTirolibre()));
			imprimir("   Resistencia       : " + this.valoracionDeFicha(fi_jug.getResistencia()));
			imprimir("   Potencia          : " + this.valoracionDeFicha(fi_jug.getPotencia()));
			imprimir("   Flexibilidad      : " + this.valoracionDeFicha(fi_jug.getFlexibilidad()));
			imprimir("   Velocidad         : " + this.valoracionDeFicha(fi_jug.getVelocidad()));
			imprimir("   Valoración jug.   : " + this.valoracionDeFicha(fi_jug.valoracionJugador()));
			imprimir("");
			imprimir(" -----------------------------------");
			imprimir(" -       DATOS DE MATRICULA        -");
			imprimir(" -----------------------------------\n");
			imprimir("   Código            : " + mat.getCodigomatricula());
			imprimir("   Estado            : " + mat.getEstadomatricula());
			imprimir("   Fecha de registro : " + this.fechaRegistroMatricula(mat));
			imprimir("   Polo              : " + this.verificarOpcionales(mat.getPolo()));
			imprimir("   Short             : " + this.verificarOpcionales(mat.getPantalon()));
			imprimir("   Casaca            : " + this.verificarOpcionales(mat.getCasaca()));
			imprimir("   Buzo              : " + this.verificarOpcionales(mat.getBuzo()));
			imprimir("   Medias            : " + this.verificarOpcionales(mat.getMedias()));
			imprimir("   Botines           : " + this.verificarOpcionales(mat.getBotines()));
			imprimir("   Importe (S/.)     : " + mat.getPagomatricula());
			imprimir("");
			imprimir(" -----------------------------------");
			imprimir(" -       DATOS DEL APODERADO       -");
			imprimir(" -----------------------------------\n");
			imprimir("   Código            : " + apo.getCodigoapoderado());
			imprimir("   Nombres           : " + apo.getNombreapoderado());
			imprimir("   Apellidos         : " + apo.getApellidoapoderado());
			imprimir("   DNI               : " + apo.getDniapoderado());
			imprimir("   Dirección         : " + apo.getDireccionapoderado());
			imprimir("   Teléfono          : " + apo.getTelefonoapoderado());
			imprimir("");
			
		} else {
			mensaje("No cargaron los datos correctamente", "¡Error!", "src/imagenes/error.png");
		}		
	}
	
	/*fecha de nacimiento jugador*/
	private String fechaNacimiento(Jugador jug) {
		String anio = String.valueOf(jug.getAnionacimiento());
		String mes = this.obtenerMes(jug.getMesnacimiento());
		String dia = String.valueOf(jug.getDianacimiento());
		if(Integer.parseInt(dia)<10) {dia = "0"+dia;}
		
		return dia+" de "+ mes + " de " + anio;
	}
	
	/*obtener mes en texto*/
	private String obtenerMes(int numero) {
		switch(numero) {
		case 1: return "Enero";
		case 2: return "Febrero";
		case 3: return "Marzo";
		case 4: return "Abril";
		case 5: return "Mayo";
		case 6: return "Junio";
		case 7: return "Julio";
		case 8: return "Agosto";
		case 9: return "Septiembre";
		case 10: return "Octubre";
		case 11: return "Noviembre";
		default: return "Diciembre";
		}
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
	
	/*obtener fecha de registro de matricula*/
	private String fechaRegistroMatricula(Matricula mat) {
		String anio = mat.getAniomatricula();
		String mes = this.obtenerMes(Integer.parseInt(mat.getMesmatricula()));
		String dia = mat.getDiamatricula();
		if(Integer.parseInt(dia)<10) {dia = "0"+dia;}
		
		return dia+" de "+mes+" de "+anio;		
	}
	
	
	/*validar opcionales*/
	private String verificarOpcionales(int numero) {
		if(numero == 1) {
			return "Adquirido";
		} else {
			return "No Adquirido";
		}
	}
	
	/*mensaje*/
	private void imprimir(String texto) {
		textADatosJugador.append(texto + "\n");
	}
	
	/*mensaje*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
}
