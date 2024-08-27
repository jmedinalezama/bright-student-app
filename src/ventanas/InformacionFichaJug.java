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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import arreglos.ArregloFicha;
import arreglos.ArregloJugador;
import clases.FichaJugador;
import clases.Jugador;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacionFichaJug extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	ArregloJugador objJug = new ArregloJugador();
	ArregloFicha objFiJug = new ArregloFicha();
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JButton btnModificar;
	private JPanel panelDatosJugador;
	private JLabel lblDatosJugador;
	private JLabel lblCodigoJugador;
	private JTextField txtCodigoJugador;
	private JLabel lblNombreJugador;
	private JTextField txtNombreJugador;
	private JLabel lblApellidoJugador;
	private JTextField txtApellidoJugador;
	private JLabel lblEdadJugador;
	private JTextField txtEdadJugador;
	private JLabel lblEstaturaJugador;
	private JTextField txtEstaturaJugador;
	private JLabel lblPesoJugador;
	private JTextField txtPesoJugador;
	private JPanel panelDatosFicha;
	private JLabel lblDatosFicha;
	private JLabel lblCodigoFicha;
	private JTextField txtCodigoFicha;
	private JLabel lblCategoria;
	private JComboBox<String> cmbCategoria;
	private JLabel lblPiernaHabil;
	private JComboBox<String> cmbPiernaHabil;
	private JLabel lblPosicion;
	private JComboBox<String> cmbPosicion;
	private JLabel lblVerValoracion;
	private JLabel lblControlBalon;
	private JComboBox<String> cmbControlBalon;
	private JLabel lblConduccion;
	private JComboBox<String> cmbConduccion;
	private JLabel lblVision;
	private JComboBox<String> cmbVision;
	private JLabel lblCabeceo;
	private JComboBox<String> cmbCabeceo;
	private JLabel lblDribling;
	private JComboBox<String> cmbDribling;
	private JLabel lblCambioRitmo;
	private JComboBox<String> cmbCambioRitmo;
	private JLabel lblDefinicion;
	private JComboBox<String> cmbDefinicion;
	private JLabel lblPenal;
	private JComboBox<String> cmbPenal;
	private JLabel lblTiroLibre;
	private JComboBox<String> cmbTiroLibre;
	private JLabel lblResistencia;
	private JComboBox<String> cmbResistencia;
	private JLabel lblPotencia;
	private JComboBox<String> cmbPotencia;
	private JLabel lblFlexibilidad;
	private JComboBox<String> cmbFlexibilidad;
	private JLabel lblVelocidad;
	private JComboBox<String> cmbVelocidad;
	private JLabel lblUltimaModificacion;
	private JTextField txtUltimaModificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InformacionFichaJug dialog = new InformacionFichaJug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InformacionFichaJug() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionFichaJug.class.getResource("/imagenes/icon-window.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setTitle("Información Ficha de Jugador");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 1000, 650, 25, 25));
		setSize(1000, 650);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelBar = new JPanel();
		panelBar.addMouseListener(this);
		panelBar.addMouseMotionListener(this);
		panelBar.setBackground(Color.CYAN);
		panelBar.setBounds(0, 0, 1000, 30);
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
		lblLogo.setBounds(970, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblTituloVentana = new JLabel("Información Ficha de Jugador - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 1000, 30);
		panelBar.add(lblTituloVentana);
		
		panelDatosJugador = new JPanel();
		panelDatosJugador.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosJugador.setBounds(10, 40, 980, 110);
		panelDatosJugador.setOpaque(false);
		getContentPane().add(panelDatosJugador);
		panelDatosJugador.setLayout(null);
		
		lblDatosJugador = new JLabel("Datos del Jugador");
		lblDatosJugador.setBorder(new LineBorder(Color.GREEN, 1, true));
		lblDatosJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosJugador.setForeground(Color.GREEN);
		lblDatosJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosJugador.setBounds(0, 0, 146, 20);
		panelDatosJugador.add(lblDatosJugador);
		
		lblCodigoJugador = new JLabel("Codigo:");
		lblCodigoJugador.setForeground(Color.WHITE);
		lblCodigoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoJugador.setBounds(50, 35, 59, 20);
		panelDatosJugador.add(lblCodigoJugador);
		
		txtCodigoJugador = new JTextField();
		txtCodigoJugador.setEditable(false);
		txtCodigoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoJugador.setForeground(Color.WHITE);
		txtCodigoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoJugador.setColumns(10);
		txtCodigoJugador.setBackground(Color.BLACK);
		txtCodigoJugador.setBounds(110, 30, 100, 25);
		panelDatosJugador.add(txtCodigoJugador);
		
		lblNombreJugador = new JLabel("Nombre:");
		lblNombreJugador.setForeground(Color.WHITE);
		lblNombreJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreJugador.setBounds(248, 35, 66, 20);
		panelDatosJugador.add(lblNombreJugador);
		
		txtNombreJugador = new JTextField();
		txtNombreJugador.setEditable(false);
		txtNombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreJugador.setForeground(Color.WHITE);
		txtNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombreJugador.setColumns(10);
		txtNombreJugador.setBackground(Color.BLACK);
		txtNombreJugador.setBounds(306, 30, 183, 25);
		panelDatosJugador.add(txtNombreJugador);
		
		lblApellidoJugador = new JLabel("Apellido:");
		lblApellidoJugador.setForeground(Color.WHITE);
		lblApellidoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoJugador.setBounds(525, 35, 66, 20);
		panelDatosJugador.add(lblApellidoJugador);
		
		txtApellidoJugador = new JTextField();
		txtApellidoJugador.setEditable(false);
		txtApellidoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidoJugador.setForeground(Color.WHITE);
		txtApellidoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellidoJugador.setColumns(10);
		txtApellidoJugador.setBackground(Color.BLACK);
		txtApellidoJugador.setBounds(601, 30, 156, 25);
		panelDatosJugador.add(txtApellidoJugador);
		
		lblEdadJugador = new JLabel("Edad:");
		lblEdadJugador.setForeground(Color.WHITE);
		lblEdadJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdadJugador.setBounds(805, 35, 40, 20);
		panelDatosJugador.add(lblEdadJugador);
		
		txtEdadJugador = new JTextField();
		txtEdadJugador.setEditable(false);
		txtEdadJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadJugador.setForeground(Color.WHITE);
		txtEdadJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEdadJugador.setColumns(10);
		txtEdadJugador.setBackground(Color.BLACK);
		txtEdadJugador.setBounds(846, 30, 66, 25);
		panelDatosJugador.add(txtEdadJugador);
		
		lblEstaturaJugador = new JLabel("Estatura(m):");
		lblEstaturaJugador.setForeground(Color.WHITE);
		lblEstaturaJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstaturaJugador.setBounds(50, 77, 90, 20);
		panelDatosJugador.add(lblEstaturaJugador);
		
		txtEstaturaJugador = new JTextField();
		txtEstaturaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstaturaJugador.setForeground(Color.WHITE);
		txtEstaturaJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEstaturaJugador.setColumns(10);
		txtEstaturaJugador.setBackground(Color.BLACK);
		txtEstaturaJugador.setBounds(150, 72, 100, 25);
		panelDatosJugador.add(txtEstaturaJugador);
		
		lblPesoJugador = new JLabel("Peso(Kg):");
		lblPesoJugador.setForeground(Color.WHITE);
		lblPesoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPesoJugador.setBounds(306, 77, 75, 20);
		panelDatosJugador.add(lblPesoJugador);
		
		txtPesoJugador = new JTextField();
		txtPesoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtPesoJugador.setForeground(Color.WHITE);
		txtPesoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPesoJugador.setColumns(10);
		txtPesoJugador.setBackground(Color.BLACK);
		txtPesoJugador.setBounds(389, 72, 100, 25);
		panelDatosJugador.add(txtPesoJugador);
		
		panelDatosFicha = new JPanel();
		panelDatosFicha.setLayout(null);
		panelDatosFicha.setOpaque(false);
		panelDatosFicha.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosFicha.setBounds(10, 192, 980, 292);
		getContentPane().add(panelDatosFicha);
		
		lblDatosFicha = new JLabel("Datos Ficha del Jugador");
		lblDatosFicha.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosFicha.setForeground(Color.GREEN);
		lblDatosFicha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosFicha.setBorder(new LineBorder(Color.GREEN, 1, true));
		lblDatosFicha.setBounds(0, 0, 206, 20);
		panelDatosFicha.add(lblDatosFicha);
		
		lblCodigoFicha = new JLabel("Codigo:");
		lblCodigoFicha.setForeground(Color.WHITE);
		lblCodigoFicha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoFicha.setBounds(10, 30, 59, 20);
		panelDatosFicha.add(lblCodigoFicha);
		
		txtCodigoFicha = new JTextField();
		txtCodigoFicha.setEditable(false);
		txtCodigoFicha.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoFicha.setForeground(Color.WHITE);
		txtCodigoFicha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoFicha.setColumns(10);
		txtCodigoFicha.setBackground(Color.BLACK);
		txtCodigoFicha.setBounds(64, 25, 100, 25);
		panelDatosFicha.add(txtCodigoFicha);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategoria.setBounds(195, 30, 80, 20);
		panelDatosFicha.add(lblCategoria);
		
		cmbCategoria = new JComboBox<String>();
		cmbCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Sub-12", "Sub-13", "Sub-14", "Sub-15", "Sub-16", "Sub-17"}));
		cmbCategoria.setForeground(Color.WHITE);
		cmbCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCategoria.setBackground(Color.BLACK);
		cmbCategoria.setBounds(285, 27, 120, 25);
		panelDatosFicha.add(cmbCategoria);
		
		lblPiernaHabil = new JLabel("Pierna H\u00E1bil:");
		lblPiernaHabil.setForeground(Color.WHITE);
		lblPiernaHabil.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPiernaHabil.setBounds(453, 30, 91, 20);
		panelDatosFicha.add(lblPiernaHabil);
		
		cmbPiernaHabil = new JComboBox<String>();
		cmbPiernaHabil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPiernaHabil.setModel(new DefaultComboBoxModel<String>(new String[] {"Derecha", "Izquierda"}));
		cmbPiernaHabil.setForeground(Color.WHITE);
		cmbPiernaHabil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbPiernaHabil.setBackground(Color.BLACK);
		cmbPiernaHabil.setBounds(554, 27, 120, 25);
		panelDatosFicha.add(cmbPiernaHabil);
		
		lblPosicion = new JLabel("Posici\u00F3n:");
		lblPosicion.setForeground(Color.WHITE);
		lblPosicion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPosicion.setBounds(728, 30, 71, 20);
		panelDatosFicha.add(lblPosicion);
		
		cmbPosicion = new JComboBox<String>();
		cmbPosicion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPosicion.setModel(new DefaultComboBoxModel<String>(new String[] {"Portero", "Lateral Izquierdo", "Defensa Central", "Lateral Derecho", "Medio Centro", "Medio Derecho", "Medio Izquierdo", "Medio Ofensivo", "Delantero Centro", "Extremo"}));
		cmbPosicion.setForeground(Color.WHITE);
		cmbPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbPosicion.setBackground(Color.BLACK);
		cmbPosicion.setBounds(809, 27, 150, 25);
		panelDatosFicha.add(cmbPosicion);
		
		lblControlBalon = new JLabel("Control de Bal\u00F3n:");
		lblControlBalon.setForeground(Color.WHITE);
		lblControlBalon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblControlBalon.setBounds(10, 82, 120, 20);
		panelDatosFicha.add(lblControlBalon);
		
		cmbControlBalon = new JComboBox<String>();
		cmbControlBalon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbControlBalon.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbControlBalon.setForeground(Color.WHITE);
		cmbControlBalon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbControlBalon.setBackground(Color.BLACK);
		cmbControlBalon.setBounds(129, 77, 100, 25);
		panelDatosFicha.add(cmbControlBalon);
		this.llenarCmb(cmbControlBalon);
		
		lblConduccion = new JLabel("Conducci\u00F3n:");
		lblConduccion.setForeground(Color.WHITE);
		lblConduccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConduccion.setBounds(272, 82, 90, 20);
		panelDatosFicha.add(lblConduccion);
		
		cmbConduccion = new JComboBox<String>();
		cmbConduccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbConduccion.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbConduccion.setForeground(Color.WHITE);
		cmbConduccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbConduccion.setBackground(Color.BLACK);
		cmbConduccion.setBounds(389, 79, 100, 25);
		panelDatosFicha.add(cmbConduccion);
		this.llenarCmb(cmbConduccion);
		
		lblVision = new JLabel("Visi\u00F3n:");
		lblVision.setForeground(Color.WHITE);
		lblVision.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVision.setBounds(529, 82, 60, 20);
		panelDatosFicha.add(lblVision);
		
		cmbVision = new JComboBox<String>();
		cmbVision.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbVision.setForeground(Color.WHITE);
		cmbVision.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbVision.setBackground(Color.BLACK);
		cmbVision.setBounds(607, 79, 100, 25);
		panelDatosFicha.add(cmbVision);
		this.llenarCmb(cmbVision);
		
		lblCabeceo = new JLabel("Cabeceo:");
		lblCabeceo.setForeground(Color.WHITE);
		lblCabeceo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCabeceo.setBounds(780, 82, 80, 20);
		panelDatosFicha.add(lblCabeceo);
		
		cmbCabeceo = new JComboBox<String>();
		cmbCabeceo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbCabeceo.setForeground(Color.WHITE);
		cmbCabeceo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCabeceo.setBackground(Color.BLACK);
		cmbCabeceo.setBounds(859, 79, 100, 25);
		panelDatosFicha.add(cmbCabeceo);
		this.llenarCmb(cmbCabeceo);
		
		lblDribling = new JLabel("Dribling:");
		lblDribling.setForeground(Color.WHITE);
		lblDribling.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDribling.setBounds(10, 138, 70, 20);
		panelDatosFicha.add(lblDribling);
		
		cmbDribling = new JComboBox<String>();
		cmbDribling.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbDribling.setForeground(Color.WHITE);
		cmbDribling.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDribling.setBackground(Color.BLACK);
		cmbDribling.setBounds(129, 135, 100, 25);
		panelDatosFicha.add(cmbDribling);
		this.llenarCmb(cmbDribling);
		
		lblCambioRitmo = new JLabel("Cambio de Ritmo:");
		lblCambioRitmo.setForeground(Color.WHITE);
		lblCambioRitmo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCambioRitmo.setBounds(272, 138, 120, 20);
		panelDatosFicha.add(lblCambioRitmo);
		
		cmbCambioRitmo = new JComboBox<String>();
		cmbCambioRitmo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbCambioRitmo.setForeground(Color.WHITE);
		cmbCambioRitmo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCambioRitmo.setBackground(Color.BLACK);
		cmbCambioRitmo.setBounds(389, 135, 100, 25);
		panelDatosFicha.add(cmbCambioRitmo);
		this.llenarCmb(cmbCambioRitmo);
		
		lblDefinicion = new JLabel("Definici\u00F3n:");
		lblDefinicion.setForeground(Color.WHITE);
		lblDefinicion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDefinicion.setBounds(529, 138, 80, 20);
		panelDatosFicha.add(lblDefinicion);
		
		cmbDefinicion = new JComboBox<String>();
		cmbDefinicion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbDefinicion.setForeground(Color.WHITE);
		cmbDefinicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDefinicion.setBackground(Color.BLACK);
		cmbDefinicion.setBounds(607, 135, 100, 25);
		panelDatosFicha.add(cmbDefinicion);
		this.llenarCmb(cmbDefinicion);
		
		lblPenal = new JLabel("Penal:");
		lblPenal.setForeground(Color.WHITE);
		lblPenal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPenal.setBounds(780, 136, 80, 20);
		panelDatosFicha.add(lblPenal);
		
		cmbPenal = new JComboBox<String>();
		cmbPenal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPenal.setForeground(Color.WHITE);
		cmbPenal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbPenal.setBackground(Color.BLACK);
		cmbPenal.setBounds(859, 133, 100, 25);
		panelDatosFicha.add(cmbPenal);
		this.llenarCmb(cmbPenal);
		
		lblTiroLibre = new JLabel("Tiro Libre:");
		lblTiroLibre.setForeground(Color.WHITE);
		lblTiroLibre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTiroLibre.setBounds(10, 195, 70, 20);
		panelDatosFicha.add(lblTiroLibre);
		
		cmbTiroLibre = new JComboBox<String>();
		cmbTiroLibre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbTiroLibre.setForeground(Color.WHITE);
		cmbTiroLibre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbTiroLibre.setBackground(Color.BLACK);
		cmbTiroLibre.setBounds(129, 192, 100, 25);
		panelDatosFicha.add(cmbTiroLibre);
		this.llenarCmb(cmbTiroLibre);
		
		lblResistencia = new JLabel("Resistencia:");
		lblResistencia.setForeground(Color.WHITE);
		lblResistencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResistencia.setBounds(272, 195, 90, 20);
		panelDatosFicha.add(lblResistencia);
		
		cmbResistencia = new JComboBox<String>();
		cmbResistencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbResistencia.setForeground(Color.WHITE);
		cmbResistencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbResistencia.setBackground(Color.BLACK);
		cmbResistencia.setBounds(389, 192, 100, 25);
		panelDatosFicha.add(cmbResistencia);
		this.llenarCmb(cmbResistencia);
		
		lblPotencia = new JLabel("Potencia:");
		lblPotencia.setForeground(Color.WHITE);
		lblPotencia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPotencia.setBounds(529, 195, 80, 20);
		panelDatosFicha.add(lblPotencia);
		
		cmbPotencia = new JComboBox<String>();
		cmbPotencia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPotencia.setForeground(Color.WHITE);
		cmbPotencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbPotencia.setBackground(Color.BLACK);
		cmbPotencia.setBounds(607, 192, 100, 25);
		panelDatosFicha.add(cmbPotencia);
		this.llenarCmb(cmbPotencia);
		
		lblFlexibilidad = new JLabel("Flexibilidad:");
		lblFlexibilidad.setForeground(Color.WHITE);
		lblFlexibilidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFlexibilidad.setBounds(780, 193, 80, 20);
		panelDatosFicha.add(lblFlexibilidad);
		
		cmbFlexibilidad = new JComboBox<String>();
		cmbFlexibilidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbFlexibilidad.setForeground(Color.WHITE);
		cmbFlexibilidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbFlexibilidad.setBackground(Color.BLACK);
		cmbFlexibilidad.setBounds(859, 190, 100, 25);
		panelDatosFicha.add(cmbFlexibilidad);
		this.llenarCmb(cmbFlexibilidad);
		
		lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setForeground(Color.WHITE);
		lblVelocidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVelocidad.setBounds(10, 249, 70, 20);
		panelDatosFicha.add(lblVelocidad);
		
		cmbVelocidad = new JComboBox<String>();
		cmbVelocidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbVelocidad.setForeground(Color.WHITE);
		cmbVelocidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbVelocidad.setBackground(Color.BLACK);
		cmbVelocidad.setBounds(129, 246, 100, 25);
		panelDatosFicha.add(cmbVelocidad);
		this.llenarCmb(cmbVelocidad);
		
		btnModificar = new JButton("Guardar Cambios");
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.addMouseListener(this);
		
		lblVerValoracion = new JLabel("Ver Valoraci\u00F3n...");
		lblVerValoracion.addMouseListener(this);
		lblVerValoracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVerValoracion.setForeground(Color.RED);
		lblVerValoracion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVerValoracion.setBounds(820, 161, 150, 20);
		getContentPane().add(lblVerValoracion);
		
		lblUltimaModificacion = new JLabel("\u00DAltima Modificaci\u00F3n:");
		lblUltimaModificacion.setForeground(Color.WHITE);
		lblUltimaModificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUltimaModificacion.setBounds(20, 502, 150, 20);
		getContentPane().add(lblUltimaModificacion);
		
		txtUltimaModificacion = new JTextField();
		txtUltimaModificacion.setEditable(false);
		txtUltimaModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtUltimaModificacion.setForeground(Color.WHITE);
		txtUltimaModificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUltimaModificacion.setColumns(10);
		txtUltimaModificacion.setBackground(Color.BLACK);
		txtUltimaModificacion.setBounds(159, 497, 200, 25);
		getContentPane().add(txtUltimaModificacion);
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(350, 560, 300, 30);
		getContentPane().add(btnModificar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 1000, 620);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.cargarDatos();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnModificar) {
			this.actionPerformedBtnModificar();
		}
	
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == lblVerValoracion) {
			this.mouseClickedLblVerValoracion();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == btnModificar) {
			this.mouseEnteredBtnModificar();
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnModificar) {
			this.mouseExitedBtnModificar();
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
	
	
	
	
	public void actionPerformedBtnModificar() {
		boolean camposllenos = this.validarCampos();
		
		if(camposllenos) {
			int edadjugador = this.leerEdadJugador();
			String categoria = this.leerCategoria();
			
			boolean edadporcategoria = this.validarCategoriaPorEdad(categoria, edadjugador);
			
			if(edadporcategoria) {
				int opcion = confirmar("�Modificar datos de ficha (incluyendo la estatura y peso del jugador)?"
						+ "\n Si cancela este proceso, se volver�n a cargar los datos"
						+ "\n originales",
						"Modificar", 
						"src/imagenes/confirmar.png");
				
				if(opcion == 0) {
					int codigojugador = this.leerCodigoJugador();
					double estatura = this.leerEstaturaJugador();
					double peso = this.leerPesoJugador();
					
					int codigoficha = this.leerCodigoFicha();
					String piernahabil = this.leerPiernaHabil();
					String posicion = this.leerPosicion();
					int controlbalon = this.leerValoracionCmb(cmbControlBalon);
					int conduccion = this.leerValoracionCmb(cmbConduccion);
					int vision = this.leerValoracionCmb(cmbVision);
					int cabeceo = this.leerValoracionCmb(cmbCabeceo);
					int dribling = this.leerValoracionCmb(cmbDribling);
					int cambioritmo = this.leerValoracionCmb(cmbCambioRitmo);
					int definicion = this.leerValoracionCmb(cmbDefinicion);
					int penal = this.leerValoracionCmb(cmbPenal);
					int tirolibre = this.leerValoracionCmb(cmbTiroLibre);
					int resistencia = this.leerValoracionCmb(cmbResistencia);
					int potencia = this.leerValoracionCmb(cmbPotencia);
					int flexibilidad = this.leerValoracionCmb(cmbFlexibilidad);
					int velocidad = this.leerValoracionCmb(cmbVelocidad);
					
					String ultimamodificacion = Login.user;
					
					FichaJugador fiactual = objFiJug.buscarFicha(codigoficha);
					FichaJugador fiupdate = new FichaJugador(categoria, piernahabil, posicion, controlbalon, conduccion,
							vision, cabeceo, dribling, cambioritmo, definicion, penal, tirolibre, resistencia, potencia,
							flexibilidad, velocidad, ultimamodificacion);
					
					objFiJug.modificarFicha(fiactual, fiupdate);
					
					Jugador jug = objJug.buscarJugadorPorCodigo(codigojugador);
					jug.setEstaturajugador(estatura);
					jug.setPesojugador(peso);
					objJug.grabarJugadores();
					
					mensaje("Se modific� los datos correctamente",
							"Modificaci�n correcta", 
							"src/imagenes/correcto.png");
					
					this.cargarDatos();
					
				} else {
					this.cargarDatos();
				}
				
			} else {
				mensaje("La edad del jugador no coincide con su categoria\n"
						+ "Categoria seleccionada: " + categoria + "\n"
						+ "Edad actual: " + edadjugador, 
						"Edad | Categoria", 
						"src/imagenes/informacion.png");
			}
		}
	}
	
	private void mouseClickedPanelSalir() {
		new GestionarFichaJug().setVisible(true);
		this.dispose();
	}
	private void mouseClickedLblVerValoracion() {
		mensaje("1. Deficiente \n"
				+ "2. Regular \n"
				+ "3. Aceptable \n"
				+ "4. Bueno \n"
				+ "5. Excelente",
				"Valoraciones de Ficha", 
				"src/imagenes/informacion.png");
	}
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnModificar() {
		btnModificar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnModificar.setBackground(Color.GREEN);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setText("GUARDAR CAMBIOS");
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnModificar() {
		btnModificar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setText("Guardar Cambios");
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
	
	/*mensaje y confirmacion*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	private int confirmar(String texto, String titulo, String img) {
		return JOptionPane.showConfirmDialog(this, texto, titulo, 2, -1, new ImageIcon(img));
	}
	
	/*llenar los combos*/
	private void llenarCmb(JComboBox<String> cmb) {
		cmb.addItem("Deficiente");
		cmb.addItem("Regular");
		cmb.addItem("Aceptable");
		cmb.addItem("Bueno");
		cmb.addItem("Excelente");
	}
	
	
	/*cargar datos*/
	private void cargarDatos() {
		Jugador jug = objJug.buscarJugadorPorCodigo(GestionarFichaJug.codigojugadorseleccionado);
		int codigoficha = jug.getCodigoficha();
		FichaJugador fi_jug = objFiJug.buscarFicha(codigoficha);
		
		if((jug != null) && (fi_jug != null)) {
			this.establecerDatos(jug, fi_jug);
		} else {
			mensaje("La ficha consultada no se encontr�", "No se encontr� ficha", "src/imagenes/error.png");
		}
		
	}
	
	/*metodo para establecer datos a las cajas de texto*/
	private void establecerDatos(Jugador jug, FichaJugador fi) {
		txtCodigoJugador.setText(String.valueOf(jug.getCodigojugador()));
		txtNombreJugador.setText(jug.getNombrejugador());
		txtApellidoJugador.setText(jug.getApellidojugador());
		txtEdadJugador.setText(String.valueOf(jug.getEdadjugador()));
		txtEstaturaJugador.setText(String.valueOf(jug.getEstaturajugador()));
		txtPesoJugador.setText(String.valueOf(jug.getPesojugador()));
		
		txtCodigoFicha.setText(String.valueOf(fi.getCodigoficha()));
		cmbCategoria.setSelectedItem(fi.getCategoria());
		cmbPiernaHabil.setSelectedItem(fi.getPiernahabil());
		cmbPosicion.setSelectedItem(fi.getPosicion());
		cmbControlBalon.setSelectedItem(this.valoracionDeFicha(fi.getControlbalon()));
		cmbConduccion.setSelectedItem(this.valoracionDeFicha(fi.getConduccion()));
		cmbVision.setSelectedItem(this.valoracionDeFicha(fi.getVision()));
		cmbCabeceo.setSelectedItem(this.valoracionDeFicha(fi.getCabeceo()));
		cmbDribling.setSelectedItem(this.valoracionDeFicha(fi.getDribling()));
		cmbCambioRitmo.setSelectedItem(this.valoracionDeFicha(fi.getCambioderitmo()));
		cmbDefinicion.setSelectedItem(this.valoracionDeFicha(fi.getDefinicion()));
		cmbPenal.setSelectedItem(this.valoracionDeFicha(fi.getPenal()));
		cmbTiroLibre.setSelectedItem(this.valoracionDeFicha(fi.getTirolibre()));
		cmbResistencia.setSelectedItem(this.valoracionDeFicha(fi.getResistencia()));
		cmbPotencia.setSelectedItem(this.valoracionDeFicha(fi.getPotencia()));
		cmbFlexibilidad.setSelectedItem(this.valoracionDeFicha(fi.getFlexibilidad()));
		cmbVelocidad.setSelectedItem(this.valoracionDeFicha(fi.getVelocidad()));
		
		txtUltimaModificacion.setText(fi.getUltimamodificacion());
	
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
	
	/*validar categoria por edad*/
	//"Sub-12", "Sub-13", "Sub-14", "Sub-15", "Sub-16", "Sub-17"
	private boolean validarCategoriaPorEdad(String categoria, int edad) {
		int edadvalida = 0;
		if(categoria.equals("Sub-12")) {
			edadvalida = 12;
			if(edadvalida == edad) {
				return true;
			} else {
				return false;
			}
		}
		if(categoria.equals("Sub-13")) {
			edadvalida = 13;
			if(edadvalida == edad) {
				return true;
			} else {
				return false;
			}
		}
		if(categoria.equals("Sub-14")) {
			edadvalida = 14;
			if(edadvalida == edad) {
				return true;
			} else {
				return false;
			}
		}
		if(categoria.equals("Sub-15")) {
			edadvalida = 15;
			if(edadvalida == edad) {
				return true;
			} else {
				return false;
			}
		}
		if(categoria.equals("Sub-16")) {
			edadvalida = 16;
			if(edadvalida == edad) {
				return true;
			} else {
				return false;
			}
		}
		if(categoria.equals("Sub-17")) {
			edadvalida = 17;
			if(edadvalida == edad) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	
	/*metodo para validar campos vacios*/
	private boolean validarCampos() {
		try {
			double estaturajugador = this.leerEstaturaJugador();
			if(estaturajugador != -1) {
				double pesojugador = this.leerPesoJugador();
				if(pesojugador != -1) {
					return true;
					
				} else {
					txtPesoJugador.setBackground(Color.RED);
					mensaje("El campo 'Peso' del Jugador est� vac�o", "Peso Jugador", 
							"src/imagenes/advertencia.png");
					txtPesoJugador.setBackground(Color.BLACK);
				}
				
			} else {
				txtEstaturaJugador.setBackground(Color.RED);
				mensaje("El campo 'Estatura' del Jugador est� vac�o", "Estatura Jugador", 
						"src/imagenes/advertencia.png");
				txtEstaturaJugador.setBackground(Color.BLACK);
			}
		}catch(Exception ex) {
			System.out.println("Ha ocurrido un error en Informacion Ficha " + ex);
			mensaje("�Error! Contacte al administrador", "Error al Modificar Ficha", "src/imagenes/error.png");
		}
		return false;
	}
	
	/*metodos para leer los datos*/
	private int leerCodigoJugador() {
		return Integer.parseInt(txtCodigoJugador.getText().trim());
	}
	private int leerEdadJugador() {
		return Integer.parseInt(txtEdadJugador.getText().trim());
	}
	private double leerEstaturaJugador() {
		if(txtEstaturaJugador.getText().trim().length()==0) {
			return -1;
		} else {
			return Double.parseDouble(txtEstaturaJugador.getText().trim());
		}
	}
	private double leerPesoJugador() {
		if(txtPesoJugador.getText().trim().length()==0) {
			return -1;
		} else {
			return Double.parseDouble(txtPesoJugador.getText().trim());
		}
	}
	
	private int leerCodigoFicha() {
		return Integer.parseInt(txtCodigoFicha.getText().trim());
	}
	private String leerCategoria() {
		return cmbCategoria.getSelectedItem().toString();
	}
	private String leerPiernaHabil() {
		return cmbPiernaHabil.getSelectedItem().toString();
	}
	private String leerPosicion() {
		return cmbPosicion.getSelectedItem().toString();
	}
	
	private int leerValoracionCmb(JComboBox<String> cmb) {
		return cmb.getSelectedIndex() + 1;
	}
	
}
