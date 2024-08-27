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
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import arreglos.ArregloApoderados;
import arreglos.ArregloFicha;
import arreglos.ArregloJugador;
import arreglos.ArregloMatriculas;
import clases.Apoderado;
import clases.FichaJugador;
import clases.Jugador;
import clases.Matricula;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InformacionJugador extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	

	private static final long serialVersionUID = 1L;
	
	ArregloApoderados objApo = new ArregloApoderados();
	ArregloJugador objJug = new ArregloJugador();
	ArregloFicha objFiJug = new ArregloFicha();
	ArregloMatriculas objMat = new ArregloMatriculas(); 
	
	private int xMouse, yMouse;
	private int codigoactualapoderado = objJug.buscarJugadorPorCodigo(GestionarJugadores.codigojugadorseleccionado).getCodigoapoderado();
	
	public static int codigoapoderadoseleccion;
	public static int codigofichaseleccion;
	public static int codigomatriculaseleccion;
	
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
	private JLabel lblDireccionJugador;
	private JTextField txtDireccionJugador;
	private JLabel lblDniJugador;
	private JTextField txtDniJugador;
	private JPanel panelFechaNacimiento;
	private JLabel lblEdadJugador;
	private JTextField txtEdadJugador;
	private JLabel lblEstaturaJugador;
	private JTextField txtEstaturaJugador;
	private JLabel lblPesoJugador;
	private JTextField txtPesoJugador;
	private JLabel lblTelefonoJugador;
	private JTextField txtTelefonoJugador;
	private JLabel lblFechaNacimiento;
	private JLabel lblAnioNacJug;
	private JComboBox<String> cmbAnioNacJug;
	private JLabel lblMesNacJug;
	private JComboBox<String> cmbMesNacJug;
	private JLabel lblDiaNacJug;
	private JComboBox<String> cmbDiaNacJug;
	private JTextField txtCodigoFicha;
	private JTextField txtCodigoMatricula;
	private JPanel panelDatosAdicionales;
	private JLabel lblDatosAdicionales;
	private JLabel lblCodigoApoderado;
	private JComboBox<String> cmbCodigoApoderado;
	private JLabel lblCodigoFicha;
	private JLabel lblCodigoMatricula;
	private JButton btnVerApoderado;
	private JButton btnVerFicha;
	private JButton btnVerMatricula;
	private JLabel lblUltimaModificacion;
	private JTextField txtUltimaModificacion;
	private JButton btnEliminar;
	private JButton btnVerDatosCompletos;
	private JButton btnImprimirDatosCompletos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InformacionJugador dialog = new InformacionJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InformacionJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionJugador.class.getResource("/imagenes/icon-window.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setTitle("Información del Jugador");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 900, 500, 25, 25));
		setSize(900, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelBar = new JPanel();
		panelBar.addMouseListener(this);
		panelBar.addMouseMotionListener(this);
		panelBar.setBackground(Color.CYAN);
		panelBar.setBounds(0, 0, 900, 30);
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
		lblLogo.setBounds(870, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblTituloVentana = new JLabel("Información del Jugador - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 900, 30);
		panelBar.add(lblTituloVentana);
		
		panelDatosJugador = new JPanel();
		panelDatosJugador.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosJugador.setBounds(10, 40, 880, 233);
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
		lblCodigoJugador.setBounds(50, 30, 59, 20);
		panelDatosJugador.add(lblCodigoJugador);
		
		txtCodigoJugador = new JTextField();
		txtCodigoJugador.setEditable(false);
		txtCodigoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoJugador.setForeground(Color.WHITE);
		txtCodigoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoJugador.setColumns(10);
		txtCodigoJugador.setBackground(Color.BLACK);
		txtCodigoJugador.setBounds(126, 27, 106, 25);
		panelDatosJugador.add(txtCodigoJugador);
		
		lblNombreJugador = new JLabel("Nombre:");
		lblNombreJugador.setForeground(Color.WHITE);
		lblNombreJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreJugador.setBounds(261, 30, 66, 20);
		panelDatosJugador.add(lblNombreJugador);
		
		txtNombreJugador = new JTextField();
		txtNombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreJugador.setForeground(Color.WHITE);
		txtNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombreJugador.setColumns(10);
		txtNombreJugador.setBackground(Color.BLACK);
		txtNombreJugador.setBounds(337, 27, 183, 25);
		panelDatosJugador.add(txtNombreJugador);
		
		lblApellidoJugador = new JLabel("Apellido:");
		lblApellidoJugador.setForeground(Color.WHITE);
		lblApellidoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoJugador.setBounds(563, 30, 66, 20);
		panelDatosJugador.add(lblApellidoJugador);
		
		txtApellidoJugador = new JTextField();
		txtApellidoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidoJugador.setForeground(Color.WHITE);
		txtApellidoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellidoJugador.setColumns(10);
		txtApellidoJugador.setBackground(Color.BLACK);
		txtApellidoJugador.setBounds(639, 27, 199, 25);
		panelDatosJugador.add(txtApellidoJugador);
		
		lblDireccionJugador = new JLabel("Direcci\u00F3n:");
		lblDireccionJugador.setForeground(Color.WHITE);
		lblDireccionJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccionJugador.setBounds(50, 159, 66, 20);
		panelDatosJugador.add(lblDireccionJugador);
		
		txtDireccionJugador = new JTextField();
		txtDireccionJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccionJugador.setForeground(Color.WHITE);
		txtDireccionJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccionJugador.setColumns(10);
		txtDireccionJugador.setBackground(Color.BLACK);
		txtDireccionJugador.setBounds(124, 156, 321, 25);
		panelDatosJugador.add(txtDireccionJugador);
		
		lblDniJugador = new JLabel("DNI:");
		lblDniJugador.setForeground(Color.WHITE);
		lblDniJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDniJugador.setBounds(50, 70, 40, 20);
		panelDatosJugador.add(lblDniJugador);
		
		txtDniJugador = new JTextField();
		txtDniJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniJugador.setForeground(Color.WHITE);
		txtDniJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDniJugador.setColumns(10);
		txtDniJugador.setBackground(Color.BLACK);
		txtDniJugador.setBounds(126, 67, 106, 25);
		panelDatosJugador.add(txtDniJugador);
		
		lblEdadJugador = new JLabel("Edad:");
		lblEdadJugador.setForeground(Color.WHITE);
		lblEdadJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdadJugador.setBounds(707, 70, 55, 20);
		panelDatosJugador.add(lblEdadJugador);
		
		txtEdadJugador = new JTextField();
		txtEdadJugador.setEditable(false);
		txtEdadJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadJugador.setForeground(Color.WHITE);
		txtEdadJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEdadJugador.setColumns(10);
		txtEdadJugador.setBackground(Color.BLACK);
		txtEdadJugador.setBounds(772, 67, 66, 25);
		panelDatosJugador.add(txtEdadJugador);
		
		lblEstaturaJugador = new JLabel("Estatura(m):");
		lblEstaturaJugador.setForeground(Color.WHITE);
		lblEstaturaJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstaturaJugador.setBounds(271, 70, 90, 20);
		panelDatosJugador.add(lblEstaturaJugador);
		
		txtEstaturaJugador = new JTextField();
		txtEstaturaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstaturaJugador.setForeground(Color.WHITE);
		txtEstaturaJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEstaturaJugador.setColumns(10);
		txtEstaturaJugador.setBackground(Color.BLACK);
		txtEstaturaJugador.setBounds(371, 67, 90, 25);
		panelDatosJugador.add(txtEstaturaJugador);
		
		lblPesoJugador = new JLabel("Peso(Kg):");
		lblPesoJugador.setForeground(Color.WHITE);
		lblPesoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPesoJugador.setBounds(488, 70, 75, 20);
		panelDatosJugador.add(lblPesoJugador);
		
		txtPesoJugador = new JTextField();
		txtPesoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtPesoJugador.setForeground(Color.WHITE);
		txtPesoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPesoJugador.setColumns(10);
		txtPesoJugador.setBackground(Color.BLACK);
		txtPesoJugador.setBounds(573, 67, 106, 25);
		panelDatosJugador.add(txtPesoJugador);
		
		lblTelefonoJugador = new JLabel("Tel\u00E9fono:");
		lblTelefonoJugador.setForeground(Color.WHITE);
		lblTelefonoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefonoJugador.setBounds(50, 117, 75, 20);
		panelDatosJugador.add(lblTelefonoJugador);
		
		txtTelefonoJugador = new JTextField();
		txtTelefonoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoJugador.setForeground(Color.WHITE);
		txtTelefonoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelefonoJugador.setColumns(10);
		txtTelefonoJugador.setBackground(Color.BLACK);
		txtTelefonoJugador.setBounds(126, 114, 319, 25);
		panelDatosJugador.add(txtTelefonoJugador);
		
		lblUltimaModificacion = new JLabel("\u00DAltima Modificaci\u00F3n:");
		lblUltimaModificacion.setForeground(Color.WHITE);
		lblUltimaModificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUltimaModificacion.setBounds(50, 197, 146, 20);
		panelDatosJugador.add(lblUltimaModificacion);
		
		txtUltimaModificacion = new JTextField();
		txtUltimaModificacion.setEditable(false);
		txtUltimaModificacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtUltimaModificacion.setForeground(Color.WHITE);
		txtUltimaModificacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUltimaModificacion.setColumns(10);
		txtUltimaModificacion.setBackground(Color.BLACK);
		txtUltimaModificacion.setBounds(192, 192, 253, 25);
		panelDatosJugador.add(txtUltimaModificacion);
		
		panelFechaNacimiento = new JPanel();
		panelFechaNacimiento.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelFechaNacimiento.setBounds(455, 114, 383, 103);
		panelFechaNacimiento.setOpaque(false);
		panelDatosJugador.add(panelFechaNacimiento);
		panelFechaNacimiento.setLayout(null);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechaNacimiento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblFechaNacimiento.setBounds(0, 0, 172, 20);
		panelFechaNacimiento.add(lblFechaNacimiento);
		
		lblAnioNacJug = new JLabel("A\u00F1o:");
		lblAnioNacJug.setForeground(Color.WHITE);
		lblAnioNacJug.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnioNacJug.setBounds(8, 45, 40, 20);
		panelFechaNacimiento.add(lblAnioNacJug);
		
		cmbAnioNacJug = new JComboBox<String>();
		cmbAnioNacJug.addActionListener(this);
		cmbAnioNacJug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbAnioNacJug.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbAnioNacJug.setForeground(Color.WHITE);
		cmbAnioNacJug.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbAnioNacJug.setBackground(Color.BLACK);
		cmbAnioNacJug.setBounds(43, 40, 70, 25);
		panelFechaNacimiento.add(cmbAnioNacJug);
		
		lblMesNacJug = new JLabel("Mes:");
		lblMesNacJug.setForeground(Color.WHITE);
		lblMesNacJug.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMesNacJug.setBounds(125, 45, 40, 20);
		panelFechaNacimiento.add(lblMesNacJug);
		
		cmbMesNacJug = new JComboBox<String>();
		cmbMesNacJug.addActionListener(this);
		cmbMesNacJug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMesNacJug.setModel(new DefaultComboBoxModel<String>(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cmbMesNacJug.setForeground(Color.WHITE);
		cmbMesNacJug.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbMesNacJug.setBackground(Color.BLACK);
		cmbMesNacJug.setBounds(160, 40, 100, 25);
		panelFechaNacimiento.add(cmbMesNacJug);
		
		lblDiaNacJug = new JLabel("D\u00EDa:");
		lblDiaNacJug.setForeground(Color.WHITE);
		lblDiaNacJug.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiaNacJug.setBounds(275, 45, 30, 20);
		panelFechaNacimiento.add(lblDiaNacJug);
		
		cmbDiaNacJug = new JComboBox<String>();
		cmbDiaNacJug.addActionListener(this);
		cmbDiaNacJug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbDiaNacJug.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbDiaNacJug.setForeground(Color.WHITE);
		cmbDiaNacJug.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDiaNacJug.setBackground(Color.BLACK);
		cmbDiaNacJug.setBounds(305, 40, 60, 25);
		panelFechaNacimiento.add(cmbDiaNacJug);
		
		panelDatosAdicionales = new JPanel();
		panelDatosAdicionales.setLayout(null);
		panelDatosAdicionales.setOpaque(false);
		panelDatosAdicionales.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosAdicionales.setBounds(10, 295, 540, 153);
		getContentPane().add(panelDatosAdicionales);
		
		lblDatosAdicionales = new JLabel("Datos Adicionales");
		lblDatosAdicionales.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosAdicionales.setForeground(Color.GREEN);
		lblDatosAdicionales.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosAdicionales.setBorder(new LineBorder(Color.GREEN, 1, true));
		lblDatosAdicionales.setBounds(0, 0, 169, 20);
		panelDatosAdicionales.add(lblDatosAdicionales);
		
		lblCodigoApoderado = new JLabel("Codigo de Apoderado:");
		lblCodigoApoderado.setForeground(Color.WHITE);
		lblCodigoApoderado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoApoderado.setBounds(10, 30, 159, 20);
		panelDatosAdicionales.add(lblCodigoApoderado);
		
		cmbCodigoApoderado = new JComboBox<String>();
		cmbCodigoApoderado.addActionListener(this);
		cmbCodigoApoderado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbCodigoApoderado.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbCodigoApoderado.setForeground(Color.WHITE);
		cmbCodigoApoderado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCodigoApoderado.setBackground(Color.BLACK);
		cmbCodigoApoderado.setBounds(182, 25, 145, 25);
		panelDatosAdicionales.add(cmbCodigoApoderado);
		
		lblCodigoFicha = new JLabel("Codigo de Ficha:");
		lblCodigoFicha.setForeground(Color.WHITE);
		lblCodigoFicha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoFicha.setBounds(10, 75, 159, 20);
		panelDatosAdicionales.add(lblCodigoFicha);
		
		txtCodigoFicha = new JTextField();
		txtCodigoFicha.setEditable(false);
		txtCodigoFicha.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoFicha.setForeground(Color.WHITE);
		txtCodigoFicha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoFicha.setColumns(10);
		txtCodigoFicha.setBackground(Color.BLACK);
		txtCodigoFicha.setBounds(182, 70, 145, 25);
		panelDatosAdicionales.add(txtCodigoFicha);
		
		lblCodigoMatricula = new JLabel("Codigo de Matricula:");
		lblCodigoMatricula.setForeground(Color.WHITE);
		lblCodigoMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoMatricula.setBounds(10, 115, 159, 20);
		panelDatosAdicionales.add(lblCodigoMatricula);
		
		txtCodigoMatricula = new JTextField();
		txtCodigoMatricula.setEditable(false);
		txtCodigoMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoMatricula.setForeground(Color.WHITE);
		txtCodigoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoMatricula.setColumns(10);
		txtCodigoMatricula.setBackground(Color.BLACK);
		txtCodigoMatricula.setBounds(182, 110, 145, 25);
		panelDatosAdicionales.add(txtCodigoMatricula);
		
		btnVerApoderado = new JButton("Ver Apoderado");
		btnVerApoderado.addActionListener(this);
		btnVerApoderado.addMouseListener(this);
		btnVerApoderado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerApoderado.setForeground(Color.WHITE);
		btnVerApoderado.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerApoderado.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerApoderado.setBackground(Color.BLACK);
		btnVerApoderado.setBounds(358, 22, 150, 30);
		panelDatosAdicionales.add(btnVerApoderado);
		
		btnVerFicha = new JButton("Ver Ficha");
		btnVerFicha.addActionListener(this);
		btnVerFicha.addMouseListener(this);
		btnVerFicha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerFicha.setForeground(Color.WHITE);
		btnVerFicha.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerFicha.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerFicha.setBackground(Color.BLACK);
		btnVerFicha.setBounds(358, 67, 150, 30);
		panelDatosAdicionales.add(btnVerFicha);
		
		btnVerMatricula = new JButton("Ver Matricula");
		btnVerMatricula.addActionListener(this);
		btnVerMatricula.addMouseListener(this);
		btnVerMatricula.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerMatricula.setForeground(Color.WHITE);
		btnVerMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerMatricula.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerMatricula.setBackground(Color.BLACK);
		btnVerMatricula.setBounds(358, 107, 150, 30);
		panelDatosAdicionales.add(btnVerMatricula);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.setBounds(590, 295, 300, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEliminar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(590, 336, 300, 30);
		getContentPane().add(btnEliminar);
		
		btnVerDatosCompletos = new JButton("Ver Datos Completos");
		btnVerDatosCompletos.addActionListener(this);
		btnVerDatosCompletos.addMouseListener(this);
		btnVerDatosCompletos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerDatosCompletos.setForeground(Color.WHITE);
		btnVerDatosCompletos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerDatosCompletos.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerDatosCompletos.setBackground(Color.BLACK);
		btnVerDatosCompletos.setBounds(590, 377, 300, 30);
		getContentPane().add(btnVerDatosCompletos);
		
		btnImprimirDatosCompletos = new JButton("Imprimir Datos Completos");
		btnImprimirDatosCompletos.addActionListener(this);
		btnImprimirDatosCompletos.addMouseListener(this);
		btnImprimirDatosCompletos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimirDatosCompletos.setForeground(Color.WHITE);
		btnImprimirDatosCompletos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnImprimirDatosCompletos.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnImprimirDatosCompletos.setBackground(Color.BLACK);
		btnImprimirDatosCompletos.setBounds(590, 418, 300, 30);
		getContentPane().add(btnImprimirDatosCompletos);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 900, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.cargarCodigosApoderado();
		this.establecerAniosNacimiento();
		this.establecerDiasNacSegunMes();
		
		this.cargarDatosJugador();
	}
	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnModificar) {
			this.actionPerformedBtnModificarJugador();
		}
		if(e.getSource() == btnEliminar) {
			this.actionPerformedBtnEliminar();
		}
		if(e.getSource() == btnVerDatosCompletos) {
			this.actionPerformedBtnVerDatosCompletos();
		}
		if(e.getSource() == btnImprimirDatosCompletos) {
			this.actionPerformedBtnImprimirDatosCompletos();
		}
		
		if(e.getSource() == cmbAnioNacJug) {
			this.actionPerformedCmbAnioNacJug();
		}
		if(e.getSource() == cmbMesNacJug) {
			this.actionPerformedCmbMesNacJug();
		}
		if(e.getSource() == cmbDiaNacJug) {
			this.actionPerformedCmbDiaNacJug();
		}
		if(e.getSource() == cmbCodigoApoderado) {
			this.actionPerformedCmbCodigoApoderado();
		}
		
		if(e.getSource() == btnVerApoderado) {
			this.actionPerformedBtnVerApoderado();
		}
		if(e.getSource() == btnVerFicha) {
			this.actionPerformedBtnVerFicha();
		}
		if(e.getSource() == btnVerMatricula) {
			this.actionPerformedBtnVerMatricula();
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
		if(e.getSource() == btnVerApoderado) {
			this.mouseEnteredBtnX(btnVerApoderado, "VER APODERADO");
		}
		if(e.getSource() == btnVerFicha) {
			this.mouseEnteredBtnX(btnVerFicha, "VER FICHA");
		}
		if(e.getSource() == btnVerMatricula) {
			this.mouseEnteredBtnX(btnVerMatricula, "VER MATRICULA");
		}
		if(e.getSource() == btnModificar ) {
			this.mouseEnteredBtnX(btnModificar, "MODIFICAR");
		}
		if(e.getSource() == btnEliminar) {
			this.mouseEnteredBtnX(btnEliminar, "ELIMINAR");
		}
		if(e.getSource() == btnVerDatosCompletos) {
			this.mouseEnteredBtnX(btnVerDatosCompletos, "VER DATOS COMPLETOS");
		}
		if(e.getSource() == btnImprimirDatosCompletos) {
			this.mouseEnteredBtnX(btnImprimirDatosCompletos, "IMPRIMIR DATOS COMPLETOS");
		}
		
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnVerApoderado) {
			this.mouseExitedBtnX(btnVerApoderado, "Ver Apoderado");
		}
		if(e.getSource() == btnVerFicha) {
			this.mouseExitedBtnX(btnVerFicha, "Ver Ficha");
		}
		if(e.getSource() == btnVerMatricula) {
			this.mouseExitedBtnX(btnVerMatricula, "Ver Matricula");
		}
		if(e.getSource() == btnModificar ) {
			this.mouseExitedBtnX(btnModificar, "Modificar");
		}
		if(e.getSource() == btnEliminar) {
			this.mouseExitedBtnX(btnEliminar, "Eliminar");
		}
		if(e.getSource() == btnVerDatosCompletos) {
			this.mouseExitedBtnX(btnVerDatosCompletos, "Ver Datos Completos");
		}
		if(e.getSource() == btnImprimirDatosCompletos) {
			this.mouseExitedBtnX(btnImprimirDatosCompletos, "Imprimir Datos Completos");
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
	
	
	
	
	
	
	private void actionPerformedBtnModificarJugador() {
		boolean camposllenos = this.validarCampos();
		
		if(camposllenos) {
			int edadjugador = this.leerEdadJugador();
			
			if(edadjugador>11 && edadjugador<18) {
				int codigoFicha = this.leerCodigoFicha();
				String categoria = objFiJug.buscarFicha(codigoFicha).getCategoria();
				
				boolean edadporcategoria = this.validarCategoriaPorEdad(categoria, edadjugador);
				
				if(edadporcategoria) {
					
					int opcion = confirmar("�Modificar datos de jugador?"
							+ "\n Si cancela este proceso, se volver�n a cargar los datos"
							+ "\n originales del jugador",
							"Modificar", 
							"src/imagenes/confirmar.png");
					
					if(opcion == 0) {
						int codigojugador = this.leerCodigoJugador();
						String nombrejugador = this.leerNombreJugador();
						String apellidojugador = this.leerApellidoJugador();
						String dnijugador = this.leerDniJugador();
						double estaturajugador = this.leerEstaturaJugador();
						double pesojugador = this.leerPesoJugador();
						String telefonojugador = this.leerTelefonoJugador();
						String direccionjugador = this.leerDireccionJugador();
						int anionacjugador = this.leerAnioNacJugador();
						int mesnacjugador = this.leerMesNacJugador();
						int dianacjugador = this.leerDiaNacJugador();
						
						int codigoapoderado = this.leerCodigoApoderado();
						
						String ultimamodificacion = Login.user;
						
						Jugador jugactual = objJug.buscarJugadorPorCodigo(codigojugador);
						Jugador jugupdate = new Jugador(codigoapoderado, nombrejugador, apellidojugador, dnijugador, 
								anionacjugador, mesnacjugador, dianacjugador, edadjugador, estaturajugador, 
								pesojugador, direccionjugador, telefonojugador, ultimamodificacion);
						
						objJug.modificarJugador(jugactual, jugupdate);
						
						mensaje("Se modific� el jugador correctamente",
								"Modificaci�n correcta", 
								"src/imagenes/correcto.png");
						
						this.cargarDatosJugador();
						this.verificarCodigoApoderado();
						
					} else {
						this.cargarDatosJugador();
					}
					
				} else {
					mensaje("La edad del jugador no coincide con su categoria\n"
							+ "Categoria actual: " + categoria, 
							"Categoria", 
							"src/imagenes/informacion.png");
				}
				
			} else {
				mensaje("La edad del jugador debe estar entre 12 y 17 a�os", "Edad Jugador", 
						"src/imagenes/informacion.png");
			}
		}
	}
	
	private void actionPerformedBtnEliminar() {
		int codigojugador = this.leerCodigoJugador();
		int codigoficha = this.leerCodigoFicha();
		int codigomatricula = this.leerCodigoMatricula();
		
		Jugador jug = objJug.buscarJugadorPorCodigo(codigojugador);
		FichaJugador fi_jug = objFiJug.buscarFicha(codigoficha);
		Matricula mat = objMat.buscarMatricula(codigomatricula);
		
		int opcion = confirmar("�Eliminar datos de jugador?"
				+ "\n Este proceso elimina los datos del jugador, su ficha, y su matricula"
				+ "\n Si cancela este proceso, no se eliminan los datos y se volver�n a cargar los datos"
				+ "\n originales.",
				"Eliminar", 
				"src/imagenes/confirmar.png");
		
		if(opcion == 0) {
			objJug.eliminarJugador(jug);
			objFiJug.eliminarFicha(fi_jug);
			objMat.eliminarMatricula(mat);
			
			mensaje("Se elimin� los datos correctamente",
					"Eliminaci�n correcta", 
					"src/imagenes/correcto.png");
			
			new GestionarJugadores().setVisible(true);
			this.dispose();
			
		} else {
			this.cargarDatosJugador();
		}
		
	}
	
	private void actionPerformedBtnVerDatosCompletos() {
		codigoapoderadoseleccion = this.leerCodigoApoderado();
		codigofichaseleccion = this.leerCodigoFicha();
		codigomatriculaseleccion = this.leerCodigoMatricula();
		
		new VerDatosCompletosJug().setVisible(true);
		this.dispose();
	}
	
	private void actionPerformedBtnImprimirDatosCompletos() {
		try {
			
			Jugador jug = objJug.buscarJugadorPorCodigo(GestionarJugadores.codigojugadorseleccionado);
			FichaJugador fi_jug = objFiJug.buscarFicha(this.leerCodigoFicha());
			Matricula mat = objMat.buscarMatricula(this.leerCodigoMatricula());
			Apoderado apo = objApo.buscarApoderado(this.leerCodigoApoderado());
			
			String nombrearchivo = "JUG-" + String.valueOf(jug.getCodigojugador());
			
			
			PrintWriter archivo;
			archivo = new PrintWriter(new FileWriter(nombrearchivo+".txt"));
			this.imprimirDatos(archivo, apo, jug, fi_jug, mat);
			archivo.close();
			
			mensaje("Los datos se han impreso correctamente", "�xito", "src/imagenes/correcto.png");
			
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error al imprimir los datos " + ex);
			mensaje("Ha ocurrido un error al imprimir los datos", "�Error!", "src/imagenes/error.png");
		}
	}
	
	private void actionPerformedCmbAnioNacJug() {
		this.calcularEdadJugador();
	}
	private void actionPerformedCmbMesNacJug() {
		this.establecerDiasNacSegunMes();
		this.calcularEdadJugador();
	}
	private void actionPerformedCmbDiaNacJug() {
		this.calcularEdadJugador();
	}
	private void actionPerformedCmbCodigoApoderado() {
		this.verificarCodigoApoderado();
	}
	private void actionPerformedBtnVerApoderado() {
		codigoapoderadoseleccion = this.leerCodigoApoderado();
		
		new VerApoderadoSecretario().setVisible(true);
		this.dispose();	
	}
	private void actionPerformedBtnVerFicha() {
		codigofichaseleccion = this.leerCodigoFicha();
		
		new VerFichaSecretario().setVisible(true);
		this.dispose();
	}
	private void actionPerformedBtnVerMatricula() {
		codigomatriculaseleccion = this.leerCodigoMatricula();
		
		new InformacionMatricula().setVisible(true);
		this.dispose();
	}
	
	public void mouseClickedPanelSalir() {
		new GestionarJugadores().setVisible(true);
		this.dispose();
	}
	
	
	public void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	public void mouseEnteredBtnX(JButton boton, String nombreboton) {
		if(boton.isEnabled() == true) {
			boton.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			boton.setBackground(Color.GREEN);
			boton.setForeground(Color.BLACK);
			boton.setText(nombreboton);
		}
	}
	
	
	
	public void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	public void mouseExitedBtnX(JButton boton, String nombreboton) {
		if(boton.isEnabled() == true) {
			boton.setBorder(new LineBorder(new Color(10, 190, 1), 2));
			boton.setBackground(Color.BLACK);
			boton.setForeground(Color.WHITE);
			boton.setText(nombreboton);
		}
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
	
	/*mensaje y confirmacion*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	private int confirmar(String texto, String titulo, String img) {
		return JOptionPane.showConfirmDialog(this, texto, titulo, 2, -1, new ImageIcon(img));
	}
	
	/*Cargar Datos del usuario*/
	private void cargarDatosJugador() {
		Jugador jug = objJug.buscarJugadorPorCodigo(GestionarJugadores.codigojugadorseleccionado);
		
		if(jug != null) {
			this.establecerDatos(jug);
			codigoactualapoderado = objJug.buscarJugadorPorCodigo(GestionarJugadores.codigojugadorseleccionado).getCodigoapoderado();
		} else {
			mensaje("El jugador consultado no se encontr�", "No se encontr� jugador", "src/imagenes/error.png");
		}
		
	}
	/*metodo para establecer datos a las cajas de texto*/
	private void establecerDatos(Jugador jug) {
		txtCodigoJugador.setText(String.valueOf(jug.getCodigojugador()));
		txtNombreJugador.setText(jug.getNombrejugador());
		txtApellidoJugador.setText(jug.getApellidojugador());
		txtDniJugador.setText(jug.getDnijugador());
		txtEstaturaJugador.setText(String.valueOf(jug.getEstaturajugador()));
		txtPesoJugador.setText(String.valueOf(jug.getPesojugador()));
		txtEdadJugador.setText(String.valueOf(jug.getEdadjugador()));
		txtTelefonoJugador.setText(jug.getTelefonojugador());
		txtDireccionJugador.setText(jug.getDireccionjugador());
		txtUltimaModificacion.setText(jug.getUltimamodificacion());
		cmbAnioNacJug.setSelectedItem(String.valueOf(jug.getAnionacimiento()));
		cmbMesNacJug.setSelectedItem(this.obtenerMes(jug.getMesnacimiento()));
		cmbDiaNacJug.setSelectedItem(String.valueOf(jug.getDianacimiento()));
		
		cmbCodigoApoderado.setSelectedItem(String.valueOf(jug.getCodigoapoderado()));
		txtCodigoFicha.setText(String.valueOf(jug.getCodigoficha()));
		txtCodigoMatricula.setText(String.valueOf(jug.getCodigomatricula()));
	
		codigoactualapoderado = jug.getCodigoapoderado();
	}
	
	/*obtener mes de nacimiento*/
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
	
	/*Validar si el codigo del apoderado le pertenece al jugador*/
	private void verificarCodigoApoderado() {
		int codigoseleccion = Integer.parseInt(cmbCodigoApoderado.getSelectedItem().toString());
		
		if(codigoactualapoderado == codigoseleccion) {
			
			btnVerFicha.setEnabled(true);
			btnVerMatricula.setEnabled(true);
			btnEliminar.setEnabled(true);
			btnVerDatosCompletos.setEnabled(true);
			btnImprimirDatosCompletos.setEnabled(true);
		} else {
			
			btnVerFicha.setEnabled(false);
			btnVerMatricula.setEnabled(false);
			btnEliminar.setEnabled(false);
			btnVerDatosCompletos.setEnabled(false);
			btnImprimirDatosCompletos.setEnabled(false);
		}
	}
	
	/*cargar codigos de los apoderados registrados*/
	private void cargarCodigosApoderado() {
		for(int i = 0; i < objApo.tamanioApoderado(); i++) {
			cmbCodigoApoderado.addItem(String.valueOf(objApo.obtenerApoderado(i).getCodigoapoderado()));
		}
	}
	/*establecer los a�os*/
	private void establecerAniosNacimiento() {
		Calendar calendario = Calendar.getInstance();
		String anio = Integer.toString(calendario.get(Calendar.YEAR));
		int aniomin = Integer.parseInt(anio)-18;
		int aniomax = Integer.parseInt(anio)-12;
		
		for(int i = aniomin; i <= aniomax; i++) {
			cmbAnioNacJug.addItem(String.valueOf(i));
		}	
	}
	
	/*establecer dia nacimiento jugador*/
	private void establecerDiasNacSegunMes() {
		String mesnacjug = cmbMesNacJug.getSelectedItem().toString();
		
		switch(mesnacjug) {
		case "Enero":
			this.llenarCmbDiaNacJug(31);
			break;
		case "Febrero":
			this.llenarCmbDiaNacJug(28);
			break;
		case "Marzo":
			this.llenarCmbDiaNacJug(31);
			break;
		case "Abril":
			this.llenarCmbDiaNacJug(30);
			break;
		case "Mayo":
			this.llenarCmbDiaNacJug(31);
			break;
		case "Junio":
			this.llenarCmbDiaNacJug(30);
			break;
		case "Julio":
			this.llenarCmbDiaNacJug(31);
			break;
		case "Agosto":
			this.llenarCmbDiaNacJug(31);
			break;
		case "Septiembre":
			this.llenarCmbDiaNacJug(30);
			break;
		case "Octubre":
			this.llenarCmbDiaNacJug(31);
			break;
		case "Noviembre":
			this.llenarCmbDiaNacJug(30);
			break;
		default:
			this.llenarCmbDiaNacJug(31);
			break;
		}
	}
	
	/*for para llenar el dia nacimiento*/
	private void llenarCmbDiaNacJug(int numero){
		cmbDiaNacJug.removeAllItems();
		for(int i = 1; i <= numero; i++) {
			cmbDiaNacJug.addItem(String.valueOf(i));
		}
	}
	
	/*Calcular la edad del jugador*/ 
	private void calcularEdadJugador() {
		String anio = cmbAnioNacJug.getSelectedItem().toString();
		String mes = String.valueOf(cmbMesNacJug.getSelectedIndex()+1);
		if(Integer.parseInt(mes)<10) {mes = "0"+mes;}
		String dia = "";
		if(cmbDiaNacJug.getSelectedItem() == null) {
			dia = "1";
		} else {
			dia = cmbDiaNacJug.getSelectedItem().toString();
		}
		if(Integer.parseInt(dia)<10) {dia = "0"+dia;}
		
		String fechaingresada = dia+"/"+mes+"/"+anio;
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechanacjug = LocalDate.parse(fechaingresada, formato);
		Period edad = Period.between(fechanacjug, LocalDate.now());
		
		txtEdadJugador.setText(String.valueOf(edad.getYears()));
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
	
	
	/*Validar campos*/
	private boolean validarCampos() {
		try {
			
			String nombrejugador = this.leerNombreJugador();
			if(nombrejugador.length()>0) {
				String apellidojugador = this.leerApellidoJugador();
				if(apellidojugador.length()>0) {
					String dnijugador = this.leerDniJugador();
					if(dnijugador.length()>0) {
						double estaturajugador = this.leerEstaturaJugador();
						if(estaturajugador != -1) {
							double pesojugador = this.leerPesoJugador();
							if(pesojugador != -1) {
								String telefono = this.leerTelefonoJugador();
								if(telefono.length()>0) {
									String direccion = this.leerDireccionJugador();
									if(direccion.length()>0) {
										return true;
										
									} else {
										txtDireccionJugador.setBackground(Color.RED);
										mensaje("El campo 'Direcci�n' del Jugador est� vac�o", "Direcci�n Jugador", 
												"src/imagenes/advertencia.png");
										txtDireccionJugador.setBackground(Color.BLACK);
									}
									
								} else {
									txtTelefonoJugador.setBackground(Color.RED);
									mensaje("El campo 'Tel�fono' del Jugador est� vac�o", "Tel�fono Jugador", 
											"src/imagenes/advertencia.png");
									txtTelefonoJugador.setBackground(Color.BLACK);
								}

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

					} else {
						txtDniJugador.setBackground(Color.RED);
						mensaje("El campo 'DNI' del Jugador est� vac�o", "DNI Jugador", 
								"src/imagenes/advertencia.png");
						txtDniJugador.setBackground(Color.BLACK);
					}
					
				} else {
					txtApellidoJugador.setBackground(Color.RED);
					mensaje("El campo 'Apellido' del Jugador est� vac�o", "Apellido Jugador", 
							"src/imagenes/advertencia.png");
					txtApellidoJugador.setBackground(Color.BLACK);
				}
				
			} else {
				txtNombreJugador.setBackground(Color.RED);
				mensaje("El campo 'Nombre' del Jugador est� vac�o", "Nombre Jugador", "src/imagenes/advertencia.png");
				txtNombreJugador.setBackground(Color.BLACK);
			}
			
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error en Informacion del Jugador " + ex);
			mensaje("�Error! Contacte al administrador", "Error en Informaci�n del Jugador", "src/imagenes/error.png");
		}
		return false;
	}
	
	
	/*Metodos para leer los datos del frame*/
	private int leerCodigoJugador() {
		return Integer.parseInt(txtCodigoJugador.getText().trim());
	}
	private String leerNombreJugador() {
		return txtNombreJugador.getText().trim();
	}
	private String leerApellidoJugador() {
		return txtApellidoJugador.getText().trim();
	}
	private String leerTelefonoJugador() {
		return txtTelefonoJugador.getText().trim();
	}
	private String leerDniJugador() {
		return txtDniJugador.getText().trim();
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
	private int leerEdadJugador() {
		return Integer.parseInt(txtEdadJugador.getText().trim());
	}
	private String leerDireccionJugador() {
		return txtDireccionJugador.getText().trim();
	}
	private int leerAnioNacJugador() {
		return Integer.parseInt(cmbAnioNacJug.getSelectedItem().toString());
	}
	private int leerMesNacJugador() {
		return cmbMesNacJug.getSelectedIndex()+1;
	}
	private int leerDiaNacJugador() {
		return Integer.parseInt(cmbDiaNacJug.getSelectedItem().toString());
	}
	
	private int leerCodigoApoderado() {
		return Integer.parseInt(cmbCodigoApoderado.getSelectedItem().toString());
	}
	private int leerCodigoFicha() {
		return Integer.parseInt(txtCodigoFicha.getText().trim());
	}
	private int leerCodigoMatricula() {
		return Integer.parseInt(txtCodigoMatricula.getText().trim());
	}
	
	
	
	
	
	/*fecha de nacimiento jugador*/
	private String fechaNacimiento(Jugador jug) {
		String anio = String.valueOf(jug.getAnionacimiento());
		String mes = this.obtenerMes(jug.getMesnacimiento());
		String dia = String.valueOf(jug.getDianacimiento());
		if(Integer.parseInt(dia)<10) {dia = "0"+dia;}
		
		return dia+" de "+ mes + " de " + anio;
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
	
	private void imprimirDatos(PrintWriter archivo, Apoderado apo, Jugador jug, FichaJugador fi_jug, Matricula mat) {
		
		if((apo != null) && (jug != null) && (fi_jug != null) && (mat != null)) {
			archivo.println("\n   DATOS COMPLETOS DEL JUGADOR\n");
			archivo.println(" -----------------------------------");
			archivo.println(" -       DATOS DEL JUGADOR         -");
			archivo.println(" -----------------------------------\n");
			archivo.println("   C�digo            : " + jug.getCodigojugador());
			archivo.println("   Nombres           : " + jug.getNombrejugador());
			archivo.println("   Apellidos         : " + jug.getApellidojugador());
			archivo.println("   DNI               : " + jug.getDnijugador());
			archivo.println("   Fecha nacimiento  : " + this.fechaNacimiento(jug));
			archivo.println("   Edad              : " + jug.getEdadjugador());
			archivo.println("   Estatura          : " + jug.getEstaturajugador());
			archivo.println("   Peso              : " + jug.getPesojugador());
			archivo.println("   Direcci�n         : " + jug.getDireccionjugador());
			archivo.println("   Tel�fono          : " + jug.getTelefonojugador());
			archivo.println("");
			archivo.println(" -----------------------------------");
			archivo.println(" -     DATOS FICHA DE JUGADOR      -");
			archivo.println(" -----------------------------------\n");
			archivo.println("   C�digo            : " + fi_jug.getCodigoficha());
			archivo.println("   Categoria         : " + fi_jug.getCategoria());
			archivo.println("   Pierna h�bil      : " + fi_jug.getPiernahabil());
			archivo.println("   Posici�n          : " + fi_jug.getPosicion());
			archivo.println("   Control de bal�n  : " + this.valoracionDeFicha(fi_jug.getControlbalon()));
			archivo.println("   Conducci�n        : " + this.valoracionDeFicha(fi_jug.getConduccion()));
			archivo.println("   Visi�n            : " + this.valoracionDeFicha(fi_jug.getVision()));
			archivo.println("   Cabeceo           : " + this.valoracionDeFicha(fi_jug.getCabeceo()));
			archivo.println("   Dribling          : " + this.valoracionDeFicha(fi_jug.getDribling()));
			archivo.println("   Cambio de ritmo   : " + this.valoracionDeFicha(fi_jug.getCambioderitmo()));
			archivo.println("   Definici�n        : " + this.valoracionDeFicha(fi_jug.getDefinicion()));
			archivo.println("   Penal             : " + this.valoracionDeFicha(fi_jug.getPenal()));
			archivo.println("   Tiro libre        : " + this.valoracionDeFicha(fi_jug.getTirolibre()));
			archivo.println("   Resistencia       : " + this.valoracionDeFicha(fi_jug.getResistencia()));
			archivo.println("   Potencia          : " + this.valoracionDeFicha(fi_jug.getPotencia()));
			archivo.println("   Flexibilidad      : " + this.valoracionDeFicha(fi_jug.getFlexibilidad()));
			archivo.println("   Velocidad         : " + this.valoracionDeFicha(fi_jug.getVelocidad()));
			archivo.println("   Valoraci�n jug.   : " + this.valoracionDeFicha(fi_jug.valoracionJugador()));
			archivo.println("");
			archivo.println(" -----------------------------------");
			archivo.println(" -       DATOS DE MATRICULA        -");
			archivo.println(" -----------------------------------\n");
			archivo.println("   C�digo            : " + mat.getCodigomatricula());
			archivo.println("   Estado            : " + mat.getEstadomatricula());
			archivo.println("   Fecha de registro : " + this.fechaRegistroMatricula(mat));
			archivo.println("   Polo              : " + this.verificarOpcionales(mat.getPolo()));
			archivo.println("   Short             : " + this.verificarOpcionales(mat.getPantalon()));
			archivo.println("   Casaca            : " + this.verificarOpcionales(mat.getCasaca()));
			archivo.println("   Buzo              : " + this.verificarOpcionales(mat.getBuzo()));
			archivo.println("   Medias            : " + this.verificarOpcionales(mat.getMedias()));
			archivo.println("   Botines           : " + this.verificarOpcionales(mat.getBotines()));
			archivo.println("   Importe (S/.)     : " + mat.getPagomatricula());
			archivo.println("");
			archivo.println(" -----------------------------------");
			archivo.println(" -       DATOS DEL APODERADO       -");
			archivo.println(" -----------------------------------\n");
			archivo.println("   C�digo            : " + apo.getCodigoapoderado());
			archivo.println("   Nombres           : " + apo.getNombreapoderado());
			archivo.println("   Apellidos         : " + apo.getApellidoapoderado());
			archivo.println("   DNI               : " + apo.getDniapoderado());
			archivo.println("   Direcci�n         : " + apo.getDireccionapoderado());
			archivo.println("   Tel�fono          : " + apo.getTelefonoapoderado());
			archivo.println("");
			
		} else {
			mensaje("No cargaron los datos correctamente", "�Error!", "src/imagenes/error.png");
		}
	}
}
