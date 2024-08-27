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
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarJugador extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JButton btnRegistrarDatosJugador;
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
	private JTextField txtNombreApoderado;
	private JTextField txtApellidoApoderado;
	private JTextField txtDniApoderado;
	private JPanel panelDatosApoderado;
	private JLabel lblDatosApoderado;
	private JLabel lblCodigoApoderado;
	private JComboBox<String> cmbCodigoApoderado;
	private JLabel lblNombreApoderado;
	private JLabel lblApellidoApoderado;
	private JLabel lblDniApoderado;
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
	private JLabel lblNotaFicha;
	private JLabel lblVerMas;
	private JTextField txtPagoMatricula;
	private JPanel panelDatosMatricula;
	private JLabel lblDatosMatricula;
	private JLabel lblCodigoMatricula;
	private JTextField txtCodigoMatricula;
	private JLabel lblEstadoMatricula;
	private JComboBox<String> cmbEstadoMatricula;
	private JLabel lblPagoMatricula;
	private JPanel panelMatriculaOpcionales;
	private JLabel lblMatriculaOpcionales;
	private JCheckBox chkPolo;
	private JCheckBox chkCasaca;
	private JCheckBox chkMedias;
	private JCheckBox chkShort;
	private JCheckBox chkBuzo;
	private JCheckBox chkBotines;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarJugador dialog = new RegistrarJugador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrarJugador.class.getResource("/imagenes/icon-window.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setTitle("Registrar Jugador y Matricula");
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
		
		lblTituloVentana = new JLabel("Registrar Jugador y Matricula - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 1000, 30);
		panelBar.add(lblTituloVentana);
		
		panelDatosJugador = new JPanel();
		panelDatosJugador.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosJugador.setBounds(10, 40, 980, 160);
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
		lblCodigoJugador.setBounds(10, 30, 59, 20);
		panelDatosJugador.add(lblCodigoJugador);
		
		txtCodigoJugador = new JTextField();
		txtCodigoJugador.setEditable(false);
		txtCodigoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoJugador.setForeground(Color.WHITE);
		txtCodigoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoJugador.setColumns(10);
		txtCodigoJugador.setBackground(Color.BLACK);
		txtCodigoJugador.setBounds(70, 25, 80, 25);
		panelDatosJugador.add(txtCodigoJugador);
		
		lblNombreJugador = new JLabel("Nombre:");
		lblNombreJugador.setForeground(Color.WHITE);
		lblNombreJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreJugador.setBounds(172, 30, 66, 20);
		panelDatosJugador.add(lblNombreJugador);
		
		txtNombreJugador = new JTextField();
		txtNombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreJugador.setForeground(Color.WHITE);
		txtNombreJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombreJugador.setColumns(10);
		txtNombreJugador.setBackground(Color.BLACK);
		txtNombreJugador.setBounds(230, 25, 183, 25);
		panelDatosJugador.add(txtNombreJugador);
		
		lblApellidoJugador = new JLabel("Apellido:");
		lblApellidoJugador.setForeground(Color.WHITE);
		lblApellidoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoJugador.setBounds(444, 30, 66, 20);
		panelDatosJugador.add(lblApellidoJugador);
		
		txtApellidoJugador = new JTextField();
		txtApellidoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidoJugador.setForeground(Color.WHITE);
		txtApellidoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellidoJugador.setColumns(10);
		txtApellidoJugador.setBackground(Color.BLACK);
		txtApellidoJugador.setBounds(520, 27, 156, 25);
		panelDatosJugador.add(txtApellidoJugador);
		
		lblDireccionJugador = new JLabel("Direcci\u00F3n:");
		lblDireccionJugador.setForeground(Color.WHITE);
		lblDireccionJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccionJugador.setBounds(573, 117, 66, 20);
		panelDatosJugador.add(lblDireccionJugador);
		
		txtDireccionJugador = new JTextField();
		txtDireccionJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccionJugador.setForeground(Color.WHITE);
		txtDireccionJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccionJugador.setColumns(10);
		txtDireccionJugador.setBackground(Color.BLACK);
		txtDireccionJugador.setBounds(649, 114, 321, 25);
		panelDatosJugador.add(txtDireccionJugador);
		
		lblDniJugador = new JLabel("DNI:");
		lblDniJugador.setForeground(Color.WHITE);
		lblDniJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDniJugador.setBounds(403, 70, 40, 20);
		panelDatosJugador.add(lblDniJugador);
		
		txtDniJugador = new JTextField();
		txtDniJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniJugador.setForeground(Color.WHITE);
		txtDniJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDniJugador.setColumns(10);
		txtDniJugador.setBackground(Color.BLACK);
		txtDniJugador.setBounds(444, 67, 106, 25);
		panelDatosJugador.add(txtDniJugador);
		
		lblEdadJugador = new JLabel("Edad:");
		lblEdadJugador.setForeground(Color.WHITE);
		lblEdadJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEdadJugador.setBounds(403, 117, 40, 20);
		panelDatosJugador.add(lblEdadJugador);
		
		txtEdadJugador = new JTextField();
		txtEdadJugador.setEditable(false);
		txtEdadJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdadJugador.setForeground(Color.WHITE);
		txtEdadJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEdadJugador.setColumns(10);
		txtEdadJugador.setBackground(Color.BLACK);
		txtEdadJugador.setBounds(444, 114, 66, 25);
		panelDatosJugador.add(txtEdadJugador);
		
		lblEstaturaJugador = new JLabel("Estatura(m):");
		lblEstaturaJugador.setForeground(Color.WHITE);
		lblEstaturaJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstaturaJugador.setBounds(573, 70, 90, 20);
		panelDatosJugador.add(lblEstaturaJugador);
		
		txtEstaturaJugador = new JTextField();
		txtEstaturaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstaturaJugador.setForeground(Color.WHITE);
		txtEstaturaJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEstaturaJugador.setColumns(10);
		txtEstaturaJugador.setBackground(Color.BLACK);
		txtEstaturaJugador.setBounds(673, 67, 90, 25);
		panelDatosJugador.add(txtEstaturaJugador);
		
		lblPesoJugador = new JLabel("Peso(Kg):");
		lblPesoJugador.setForeground(Color.WHITE);
		lblPesoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPesoJugador.setBounds(797, 70, 75, 20);
		panelDatosJugador.add(lblPesoJugador);
		
		txtPesoJugador = new JTextField();
		txtPesoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtPesoJugador.setForeground(Color.WHITE);
		txtPesoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPesoJugador.setColumns(10);
		txtPesoJugador.setBackground(Color.BLACK);
		txtPesoJugador.setBounds(882, 67, 88, 25);
		panelDatosJugador.add(txtPesoJugador);
		
		lblTelefonoJugador = new JLabel("Tel\u00E9fono:");
		lblTelefonoJugador.setForeground(Color.WHITE);
		lblTelefonoJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefonoJugador.setBounds(702, 30, 75, 20);
		panelDatosJugador.add(lblTelefonoJugador);
		
		txtTelefonoJugador = new JTextField();
		txtTelefonoJugador.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefonoJugador.setForeground(Color.WHITE);
		txtTelefonoJugador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelefonoJugador.setColumns(10);
		txtTelefonoJugador.setBackground(Color.BLACK);
		txtTelefonoJugador.setBounds(787, 27, 183, 25);
		panelDatosJugador.add(txtTelefonoJugador);
		
		panelFechaNacimiento = new JPanel();
		panelFechaNacimiento.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelFechaNacimiento.setBounds(10, 61, 383, 87);
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
		lblAnioNacJug.setBounds(5, 38, 40, 20);
		panelFechaNacimiento.add(lblAnioNacJug);
		
		cmbAnioNacJug = new JComboBox<String>();
		cmbAnioNacJug.addActionListener(this);
		cmbAnioNacJug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbAnioNacJug.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbAnioNacJug.setForeground(Color.WHITE);
		cmbAnioNacJug.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbAnioNacJug.setBackground(Color.BLACK);
		cmbAnioNacJug.setBounds(40, 35, 70, 25);
		panelFechaNacimiento.add(cmbAnioNacJug);
		
		lblMesNacJug = new JLabel("Mes:");
		lblMesNacJug.setForeground(Color.WHITE);
		lblMesNacJug.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMesNacJug.setBounds(125, 38, 40, 20);
		panelFechaNacimiento.add(lblMesNacJug);
		
		cmbMesNacJug = new JComboBox<String>();
		cmbMesNacJug.addActionListener(this);
		cmbMesNacJug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbMesNacJug.setModel(new DefaultComboBoxModel<String>(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		cmbMesNacJug.setForeground(Color.WHITE);
		cmbMesNacJug.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbMesNacJug.setBackground(Color.BLACK);
		cmbMesNacJug.setBounds(160, 35, 100, 25);
		panelFechaNacimiento.add(cmbMesNacJug);
		
		lblDiaNacJug = new JLabel("D\u00EDa:");
		lblDiaNacJug.setForeground(Color.WHITE);
		lblDiaNacJug.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDiaNacJug.setBounds(275, 38, 30, 20);
		panelFechaNacimiento.add(lblDiaNacJug);
		
		cmbDiaNacJug = new JComboBox<String>();
		cmbDiaNacJug.addActionListener(this);
		cmbDiaNacJug.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbDiaNacJug.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbDiaNacJug.setForeground(Color.WHITE);
		cmbDiaNacJug.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDiaNacJug.setBackground(Color.BLACK);
		cmbDiaNacJug.setBounds(305, 35, 60, 25);
		panelFechaNacimiento.add(cmbDiaNacJug);
		
		panelDatosApoderado = new JPanel();
		panelDatosApoderado.setLayout(null);
		panelDatosApoderado.setOpaque(false);
		panelDatosApoderado.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosApoderado.setBounds(10, 225, 980, 70);
		getContentPane().add(panelDatosApoderado);
		
		lblDatosApoderado = new JLabel("Datos del Apoderado");
		lblDatosApoderado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosApoderado.setForeground(Color.GREEN);
		lblDatosApoderado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosApoderado.setBorder(new LineBorder(Color.GREEN, 1, true));
		lblDatosApoderado.setBounds(0, 0, 169, 20);
		panelDatosApoderado.add(lblDatosApoderado);
		
		lblCodigoApoderado = new JLabel("Codigo:");
		lblCodigoApoderado.setForeground(Color.WHITE);
		lblCodigoApoderado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoApoderado.setBounds(10, 30, 59, 20);
		panelDatosApoderado.add(lblCodigoApoderado);
		
		cmbCodigoApoderado = new JComboBox<String>();
		cmbCodigoApoderado.addActionListener(this);
		cmbCodigoApoderado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbCodigoApoderado.setModel(new DefaultComboBoxModel<String>(new String[] {}));
		cmbCodigoApoderado.setForeground(Color.WHITE);
		cmbCodigoApoderado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbCodigoApoderado.setBackground(Color.BLACK);
		cmbCodigoApoderado.setBounds(66, 25, 80, 25);
		panelDatosApoderado.add(cmbCodigoApoderado);
		
		lblNombreApoderado = new JLabel("Nombre:");
		lblNombreApoderado.setForeground(Color.WHITE);
		lblNombreApoderado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreApoderado.setBounds(172, 30, 66, 20);
		panelDatosApoderado.add(lblNombreApoderado);
		
		txtNombreApoderado = new JTextField();
		txtNombreApoderado.setEditable(false);
		txtNombreApoderado.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreApoderado.setForeground(Color.WHITE);
		txtNombreApoderado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombreApoderado.setColumns(10);
		txtNombreApoderado.setBackground(Color.BLACK);
		txtNombreApoderado.setBounds(230, 25, 220, 25);
		panelDatosApoderado.add(txtNombreApoderado);
		
		lblApellidoApoderado = new JLabel("Apellido:");
		lblApellidoApoderado.setForeground(Color.WHITE);
		lblApellidoApoderado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoApoderado.setBounds(493, 30, 66, 20);
		panelDatosApoderado.add(lblApellidoApoderado);
		
		txtApellidoApoderado = new JTextField();
		txtApellidoApoderado.setEditable(false);
		txtApellidoApoderado.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellidoApoderado.setForeground(Color.WHITE);
		txtApellidoApoderado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtApellidoApoderado.setColumns(10);
		txtApellidoApoderado.setBackground(Color.BLACK);
		txtApellidoApoderado.setBounds(559, 27, 220, 25);
		panelDatosApoderado.add(txtApellidoApoderado);
		
		lblDniApoderado = new JLabel("DNI:");
		lblDniApoderado.setForeground(Color.WHITE);
		lblDniApoderado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDniApoderado.setBounds(800, 30, 40, 20);
		panelDatosApoderado.add(lblDniApoderado);
		
		txtDniApoderado = new JTextField();
		txtDniApoderado.setEditable(false);
		txtDniApoderado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDniApoderado.setForeground(Color.WHITE);
		txtDniApoderado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDniApoderado.setColumns(10);
		txtDniApoderado.setBackground(Color.BLACK);
		txtDniApoderado.setBounds(850, 27, 120, 25);
		panelDatosApoderado.add(txtDniApoderado);
		
		panelDatosFicha = new JPanel();
		panelDatosFicha.setLayout(null);
		panelDatosFicha.setOpaque(false);
		panelDatosFicha.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosFicha.setBounds(10, 325, 980, 93);
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
		txtCodigoFicha.setBounds(64, 25, 80, 25);
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
		lblPosicion.setBounds(710, 30, 71, 20);
		panelDatosFicha.add(lblPosicion);
		
		cmbPosicion = new JComboBox<String>();
		cmbPosicion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbPosicion.setModel(new DefaultComboBoxModel<String>(new String[] {"Portero", "Lateral Izquierdo", "Defensa Central", "Lateral Derecho", "Medio Centro", "Medio Derecho", "Medio Izquierdo", "Medio Ofensivo", "Delantero Centro", "Extremo"}));
		cmbPosicion.setForeground(Color.WHITE);
		cmbPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbPosicion.setBackground(Color.BLACK);
		cmbPosicion.setBounds(780, 27, 170, 25);
		panelDatosFicha.add(cmbPosicion);
		
		lblNotaFicha = new JLabel("NOTA: Los dem\u00E1s datos se registran con un valor predeterminado en 3.");
		lblNotaFicha.setForeground(Color.WHITE);
		lblNotaFicha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNotaFicha.setBounds(20, 61, 473, 20);
		panelDatosFicha.add(lblNotaFicha);
		
		lblVerMas = new JLabel("Ver m�s...");
		lblVerMas.addMouseListener(this);
		lblVerMas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblVerMas.setForeground(Color.RED);
		lblVerMas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVerMas.setBounds(489, 61, 80, 20);
		panelDatosFicha.add(lblVerMas);
		
		panelDatosMatricula = new JPanel();
		panelDatosMatricula.setLayout(null);
		panelDatosMatricula.setOpaque(false);
		panelDatosMatricula.setBorder(new LineBorder(Color.GREEN, 1, true));
		panelDatosMatricula.setBounds(10, 450, 980, 132);
		getContentPane().add(panelDatosMatricula);
		
		lblDatosMatricula = new JLabel("Datos de la Matricula");
		lblDatosMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosMatricula.setForeground(Color.GREEN);
		lblDatosMatricula.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosMatricula.setBorder(new LineBorder(Color.GREEN, 1, true));
		lblDatosMatricula.setBounds(0, 0, 169, 20);
		panelDatosMatricula.add(lblDatosMatricula);
		
		lblCodigoMatricula = new JLabel("Codigo:");
		lblCodigoMatricula.setForeground(Color.WHITE);
		lblCodigoMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCodigoMatricula.setBounds(10, 30, 59, 20);
		panelDatosMatricula.add(lblCodigoMatricula);
		
		txtCodigoMatricula = new JTextField();
		txtCodigoMatricula.setEditable(false);
		txtCodigoMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoMatricula.setForeground(Color.WHITE);
		txtCodigoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigoMatricula.setColumns(10);
		txtCodigoMatricula.setBackground(Color.BLACK);
		txtCodigoMatricula.setBounds(66, 25, 80, 25);
		panelDatosMatricula.add(txtCodigoMatricula);
		
		lblEstadoMatricula = new JLabel("Estado:");
		lblEstadoMatricula.setForeground(Color.WHITE);
		lblEstadoMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoMatricula.setBounds(172, 30, 66, 20);
		panelDatosMatricula.add(lblEstadoMatricula);
		
		cmbEstadoMatricula = new JComboBox<String>();
		cmbEstadoMatricula.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbEstadoMatricula.setModel(new DefaultComboBoxModel<String>(new String[] {"Pendiente", "Pagado"}));
		cmbEstadoMatricula.setForeground(Color.WHITE);
		cmbEstadoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbEstadoMatricula.setBackground(Color.BLACK);
		cmbEstadoMatricula.setBounds(237, 25, 141, 25);
		panelDatosMatricula.add(cmbEstadoMatricula);
		
		lblPagoMatricula = new JLabel("Importe Total (S/.):");
		lblPagoMatricula.setForeground(Color.WHITE);
		lblPagoMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPagoMatricula.setBounds(10, 87, 136, 20);
		panelDatosMatricula.add(lblPagoMatricula);
		
		txtPagoMatricula = new JTextField("100.0");
		txtPagoMatricula.setEditable(false);
		txtPagoMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtPagoMatricula.setForeground(Color.WHITE);
		txtPagoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPagoMatricula.setColumns(10);
		txtPagoMatricula.setBackground(Color.BLACK);
		txtPagoMatricula.setBounds(156, 84, 147, 25);
		panelDatosMatricula.add(txtPagoMatricula);
		
		panelMatriculaOpcionales = new JPanel();
		panelMatriculaOpcionales.setLayout(null);
		panelMatriculaOpcionales.setOpaque(false);
		panelMatriculaOpcionales.setBorder(new LineBorder(Color.WHITE, 1, true));
		panelMatriculaOpcionales.setBounds(447, 11, 523, 110);
		panelDatosMatricula.add(panelMatriculaOpcionales);
		
		lblMatriculaOpcionales = new JLabel("Opcionales");
		lblMatriculaOpcionales.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculaOpcionales.setForeground(Color.WHITE);
		lblMatriculaOpcionales.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatriculaOpcionales.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblMatriculaOpcionales.setBounds(0, 0, 172, 20);
		panelMatriculaOpcionales.add(lblMatriculaOpcionales);
		
		chkPolo = new JCheckBox("Polo");
		chkPolo.addActionListener(this);
		chkPolo.setBorderPainted(true);
		chkPolo.setBorder(new LineBorder(Color.WHITE));
		chkPolo.setForeground(Color.WHITE);
		chkPolo.setBackground(Color.BLACK);
		chkPolo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkPolo.setBounds(22, 27, 97, 23);
		panelMatriculaOpcionales.add(chkPolo);
		
		chkCasaca = new JCheckBox("Casaca");
		chkCasaca.addActionListener(this);
		chkCasaca.setBorderPainted(true);
		chkCasaca.setForeground(Color.WHITE);
		chkCasaca.setBackground(Color.BLACK);
		chkCasaca.setBorder(new LineBorder(Color.WHITE));
		chkCasaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkCasaca.setBounds(214, 27, 97, 23);
		panelMatriculaOpcionales.add(chkCasaca);
		
		chkShort = new JCheckBox("Short");
		chkShort.addActionListener(this);
		chkShort.setBorderPainted(true);
		chkShort.setForeground(Color.WHITE);
		chkShort.setBackground(Color.BLACK);
		chkShort.setBorder(new LineBorder(Color.WHITE));
		chkShort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkShort.setBounds(22, 69, 97, 23);
		panelMatriculaOpcionales.add(chkShort);
		
		chkBuzo = new JCheckBox("Buzo");
		chkBuzo.addActionListener(this);
		chkBuzo.setBorderPainted(true);
		chkBuzo.setBackground(Color.BLACK);
		chkBuzo.setForeground(Color.WHITE);
		chkBuzo.setBorder(new LineBorder(Color.WHITE));
		chkBuzo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkBuzo.setBounds(214, 69, 97, 23);
		panelMatriculaOpcionales.add(chkBuzo);
		
		chkMedias = new JCheckBox("Medias");
		chkMedias.addActionListener(this);
		chkMedias.setBorderPainted(true);
		chkMedias.setBackground(Color.BLACK);
		chkMedias.setForeground(Color.WHITE);
		chkMedias.setBorder(new LineBorder(Color.WHITE));
		chkMedias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkMedias.setBounds(366, 27, 97, 23);
		panelMatriculaOpcionales.add(chkMedias);
		
		chkBotines = new JCheckBox("Botines");
		chkBotines.addActionListener(this);
		chkBotines.setBorderPainted(true);
		chkBotines.setForeground(Color.WHITE);
		chkBotines.setBackground(Color.BLACK);
		chkBotines.setBorder(new LineBorder(Color.WHITE));
		chkBotines.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkBotines.setBounds(366, 69, 97, 23);
		panelMatriculaOpcionales.add(chkBotines);
		
		btnRegistrarDatosJugador = new JButton("Registrar Datos Jugador");
		btnRegistrarDatosJugador.addActionListener(this);
		btnRegistrarDatosJugador.setForeground(Color.WHITE);
		btnRegistrarDatosJugador.addMouseListener(this);
		btnRegistrarDatosJugador.setBackground(Color.BLACK);
		btnRegistrarDatosJugador.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnRegistrarDatosJugador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarDatosJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistrarDatosJugador.setBounds(350, 609, 300, 30);
		getContentPane().add(btnRegistrarDatosJugador);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 1000, 620);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.codigoCorrelativoJugador();
		this.codigoCorrelativoFicha();
		this.codigoCorrelativoMatricula();
		this.cargarCodigosApoderado();
		
		this.establecerAniosNacimiento();
		this.establecerDiasNacSegunMes();

	}
	
	
	ArregloJugador objJug = new ArregloJugador();
	ArregloFicha objFiJug = new ArregloFicha();
	ArregloMatriculas objMat = new ArregloMatriculas();
	ArregloApoderados objApo = new ArregloApoderados();
	
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrarDatosJugador) {
			this.actionPerformedBtnRegistrarDatosJugador();
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
		
		if(e.getSource() == chkPolo) {
			this.importeDeMatricula();
		}
		if(e.getSource() == chkShort) {
			this.importeDeMatricula();
		}
		if(e.getSource() == chkCasaca) {
			this.importeDeMatricula();
		}
		if(e.getSource() == chkBuzo) {
			this.importeDeMatricula();
		}
		if(e.getSource() == chkMedias) {
			this.importeDeMatricula();
		}
		if(e.getSource() == chkBotines) {
			this.importeDeMatricula();
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == lblVerMas) {
			this.mouseClickedLblVerMas();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == btnRegistrarDatosJugador) {
			this.mouseEnteredBtnRegistrar();
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnRegistrarDatosJugador) {
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
	
	
	
	
	private void actionPerformedBtnRegistrarDatosJugador() {
		boolean camposllenos = this.validarCampos();
		
		if(camposllenos) {
			int edadjugador = this.leerEdadJugador();
			
			if(edadjugador>11 && edadjugador<18) {
				String categoria = this.leerCategoria();
				
				boolean edadporcategoria = this.validarCategoriaPorEdad(categoria, edadjugador);
				
				if(edadporcategoria) {
					int codigojugador = this.leerCodigoJugador();
					String nombrejugador = this.leerNombreJugador();
					String apellidojugador = this.leerApellidoJugador();
					String telefonojugador = this.leerTelefonoJugador();
					String dnijugador = this.leerDniJugador();
					double estaturajugador = this.leerEstaturaJugador();
					double pesojugador = this.leerPesoJugador();
					String direccionjugador = this.leerDireccionJugador();
					int anionacjugador = this.leerAnioNacJugador();
					int mesnacjugador = this.leerMesNacJugador();
					int dianacjugador = this.leerDiaNacJugador();
					
					int codigoapoderado = this.leerCodigoApoderado();
					
					int codigoficha = this.leerCodigoFicha();
					String piernahabil = this.leerPiernaHabil();
					String posicion = this.leerPosicion();
					
					int codigomatricula = this.leerCodigoMatricula();
					String estadomatricula = this.leerEstadoMatricula();
					int polo = this.leerOpcionalMatricula(chkPolo);
					int pantalon = this.leerOpcionalMatricula(chkShort);
					int casaca = this.leerOpcionalMatricula(chkCasaca);
					int buzo = this.leerOpcionalMatricula(chkBuzo);
					int medias = this.leerOpcionalMatricula(chkMedias);
					int botines = this.leerOpcionalMatricula(chkBotines);
					double importematricula = this.leerImporteMatricula();
					
					String ultimamodificacion = Login.user;
					
					objJug.adicionarJugador(
							new Jugador(codigojugador, codigoapoderado, codigoficha, codigomatricula, nombrejugador, 
									apellidojugador, dnijugador, anionacjugador, mesnacjugador, dianacjugador, edadjugador,
									estaturajugador, pesojugador, direccionjugador, telefonojugador, ultimamodificacion)
					);
					
					objFiJug.adicionarFicha(
							new FichaJugador(codigoficha, categoria, piernahabil, posicion, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
									3, 3, 3, ultimamodificacion)
					);
					
					objMat.adicionarMatricula(
							new Matricula(codigomatricula, importematricula, estadomatricula, polo, pantalon, casaca,
									buzo, medias, botines)
					);
					
					mensaje("Se registraron los datos correctamente",
							"Registro correcto", 
							"src/imagenes/correcto.png");
					
					this.limpiarCampos();
					
				} else {
					mensaje("La edad del jugador no coincide con la categoria asignada", "Categoria", 
							"src/imagenes/informacion.png");
				}
			} else {
				mensaje("La edad del jugador debe estar entre 12 y 17 a�os", "Edad Jugador", 
						"src/imagenes/informacion.png");
			}
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
		if(cmbCodigoApoderado.getSelectedItem() != null) {
			int codigo = Integer.parseInt(cmbCodigoApoderado.getSelectedItem().toString());
			
			Apoderado apo = objApo.buscarApoderado(codigo);
			
			if(apo != null) {
				txtNombreApoderado.setText(apo.getNombreapoderado());
				txtApellidoApoderado.setText(apo.getApellidoapoderado());
				txtDniApoderado.setText(apo.getDniapoderado());
				
			} else {
				mensaje("No se encontr� apoderado", "�Error�", "src/imaganes/error.png");
			}
			
		}
	}
	
	
	
	private void mouseClickedPanelSalir() {
		new Secretario().setVisible(true);
		this.dispose();
	}
	private void mouseClickedLblVerMas() {
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
	private void mouseEnteredBtnRegistrar() {
		btnRegistrarDatosJugador.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnRegistrarDatosJugador.setBackground(Color.GREEN);
		btnRegistrarDatosJugador.setForeground(Color.BLACK);
		btnRegistrarDatosJugador.setText("REGISTRAR DATOS JUGADOR");
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnRegistrar() {
		btnRegistrarDatosJugador.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnRegistrarDatosJugador.setBackground(Color.BLACK);
		btnRegistrarDatosJugador.setForeground(Color.WHITE);
		btnRegistrarDatosJugador.setText("Registrar Datos Jugador");
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
	
	/*mensaje*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	
	/*limpiar campos*/
	private void limpiarCampos() {
		this.codigoCorrelativoJugador();
		txtNombreJugador.setText("");
		txtApellidoJugador.setText("");
		txtTelefonoJugador.setText("");
		txtDniJugador.setText("");
		txtEstaturaJugador.setText("");
		txtPesoJugador.setText("");
		txtDireccionJugador.setText("");
		cmbAnioNacJug.setSelectedIndex(0);
		cmbMesNacJug.setSelectedIndex(0);
		cmbDiaNacJug.setSelectedIndex(0);
		cmbCodigoApoderado.setSelectedIndex(0);
		this.codigoCorrelativoFicha();
		cmbCategoria.setSelectedIndex(0);
		cmbPiernaHabil.setSelectedIndex(0);
		cmbPosicion.setSelectedIndex(0);
		this.codigoCorrelativoMatricula();
		cmbEstadoMatricula.setSelectedIndex(0);
		txtPagoMatricula.setText("100.0");
		chkPolo.setSelected(false);
		chkShort.setSelected(false);
		chkCasaca.setSelected(false);
		chkBuzo.setSelected(false);
		chkMedias.setSelected(false);
		chkBotines.setSelected(false);
	}
	
	
	/*Codigos Correlativos*/
	private void codigoCorrelativoJugador() {
		txtCodigoJugador.setText(String.valueOf(objJug.codigoCorrelativoJugador()));
	}
	private void codigoCorrelativoFicha() {
		txtCodigoFicha.setText(String.valueOf(objFiJug.codigoCorrelativoFicha()));
	}
	private void codigoCorrelativoMatricula() {
		txtCodigoMatricula.setText(String.valueOf(objMat.codigoCorrelativoMatricula()));
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
	
	
	/*Calcular importe de matricula*/
	private void importeDeMatricula() {
		double importetotal = 100;
		
		if(chkPolo.isSelected()) {
			importetotal += 30;
		}
		if(chkShort.isSelected()) {
			importetotal += 30;
		}
		if(chkCasaca.isSelected()) {
			importetotal += 60;
		}
		if(chkBuzo.isSelected()) {
			importetotal += 60;
		}
		if(chkMedias.isSelected()) {
			importetotal += 10;
		}
		if(chkBotines.isSelected()) {
			importetotal += 80;
		}

		txtPagoMatricula.setText(String.valueOf(importetotal));
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
					String telefonojugador = this.leerTelefonoJugador();
					if(telefonojugador.length()>0) {
						String dnijugador = this.leerDniJugador();
						if(dnijugador.length()>0) {
							double estaturajugador = this.leerEstaturaJugador();
							if(estaturajugador != -1) {
								double pesojugador = this.leerPesoJugador();
								if(pesojugador != -1) {
									String direccionjugador = this.leerDireccionJugador();
									if(direccionjugador.length()>0) {
										return true;
										
									} else {
										txtDireccionJugador.setBackground(Color.RED);
										mensaje("El campo 'Direcci�n' del Jugador est� vac�o", "Direcci�n Jugador", 
												"src/imagenes/advertencia.png");
										txtDireccionJugador.setBackground(Color.BLACK);
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
						txtTelefonoJugador.setBackground(Color.RED);
						mensaje("El campo 'Tel�fono' del Jugador est� vac�o", "Tel�fono Jugador", 
								"src/imagenes/advertencia.png");
						txtTelefonoJugador.setBackground(Color.BLACK);
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
			
		}catch(Exception ex) {
			System.out.println("Ha ocurrido un error en Registrar Jugador y Matricula " + ex);
			mensaje("�Error! Contacte al administrador", "Error Registrar Jugador y Matricula", "src/imagenes/error.png");
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
	private String leerCategoria() {
		return cmbCategoria.getSelectedItem().toString();
	}
	private String leerPiernaHabil() {
		return cmbPiernaHabil.getSelectedItem().toString();
	}
	private String leerPosicion() {
		return cmbPosicion.getSelectedItem().toString();
	}
	
	
	private int leerCodigoMatricula() {
		return Integer.parseInt(txtCodigoMatricula.getText().trim());
	}
	private String leerEstadoMatricula() {
		return cmbEstadoMatricula.getSelectedItem().toString();
	}
	private double leerImporteMatricula() {
		return Double.parseDouble(txtPagoMatricula.getText().trim());
	}
	
	private int leerOpcionalMatricula(JCheckBox chkbox) {
		if(chkbox.isSelected()) {
			return 1;
		} else {
			return 0;
		}
	}

}
