package ventanas;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloJugador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarJugadores extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private int xMouse, yMouse;
	private DefaultTableModel model;
	private boolean seleccionregistro = false;
	public static int codigojugadorseleccionado;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JScrollPane scpScroll;
	private JTable tbJugadores;
	private JButton btnVerJugador;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionarJugadores dialog = new GestionarJugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionarJugadores() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarJugadores.class.getResource("/imagenes/icon-window.png")));
		setTitle("Gestionar Jugadores");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 800, 500, 25, 25));
		setSize(800, 500);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
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
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalir.setBounds(0, 0, 30, 30);
		panelSalir.add(lblSalir);
		
		lblTituloVentana = new JLabel("Gestionar Jugadores - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 800, 30);
		panelBar.add(lblTituloVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(770, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(50, 110, 700, 260);
		getContentPane().add(scpScroll);
		
		tbJugadores = new JTable();
		tbJugadores.addMouseListener(this);
		scpScroll.setViewportView(tbJugadores);
		
		btnVerJugador = new JButton("Ver Jugador");
		btnVerJugador.addActionListener(this);
		btnVerJugador.addMouseListener(this);
		btnVerJugador.setBorder(new LineBorder(Color.GREEN, 2));
		btnVerJugador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerJugador.setForeground(Color.WHITE);
		btnVerJugador.setBackground(Color.BLACK);
		btnVerJugador.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerJugador.setBounds(600, 385, 150, 30);
		getContentPane().add(btnVerJugador);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		model = new DefaultTableModel();
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("EDAD");
		model.addColumn("APODERADO");
		model.addColumn("FICHA");
		model.addColumn("MATRICULA");
		
		tbJugadores.setModel(model);
		
		this.ajustarAnchoColumnas();
		this.listarJugadores();
		
	}

	ArregloJugador objJug = new ArregloJugador();
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVerJugador) {
			this.actionPerformedBtnVerJugador();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == tbJugadores) {
			this.mouseClickedTbJugadores(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == btnVerJugador) {
			this.mouseEnteredBtnVerJugador();;
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnVerJugador) {
			this.mouseExitedBtnVerJugador();
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
	
	
	
	private void actionPerformedBtnVerJugador() {
		if(seleccionregistro) {
			new InformacionJugador().setVisible(true);
			this.dispose();
		} else {
			mensaje("No se seleccion� ning�n registro", "�Error!", "src/imagenes/error.png");
		}
	}
	
	private void mouseClickedPanelSalir() {
		new Secretario().setVisible(true);
		this.dispose();
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnVerJugador() {
		btnVerJugador.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnVerJugador.setBackground(Color.GREEN);
		btnVerJugador.setForeground(Color.BLACK);
		btnVerJugador.setText("VER JUGADOR");
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnVerJugador() {
		btnVerJugador.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerJugador.setBackground(Color.BLACK);
		btnVerJugador.setForeground(Color.WHITE);
		btnVerJugador.setText("Ver Jugador");
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
	
	
	/*metodo para seleccionar un registro de la tabla*/
	private void mouseClickedTbJugadores(MouseEvent e) {
		int filapos = tbJugadores.rowAtPoint(e.getPoint());
		int columnapos = 0;
		
		if(filapos > -1) {
			codigojugadorseleccionado = (int) model.getValueAt(filapos, columnapos);
			seleccionregistro = true;
		}
	}
	
	
	/*metodo listar jugadores*/
	private void listarJugadores() {
		model.setRowCount(0);
		for(int i = 0; i < objJug.tamanioJugador(); i++) {
			Object fila[] = {
				objJug.obtenerJugador(i).getCodigojugador(),
				objJug.obtenerJugador(i).getNombrejugador(),
				objJug.obtenerJugador(i).getApellidojugador(),
				objJug.obtenerJugador(i).getEdadjugador(),
				objJug.obtenerJugador(i).getCodigoapoderado(),
				objJug.obtenerJugador(i).getCodigoficha(),
				objJug.obtenerJugador(i).getCodigomatricula()
			};
			model.addRow(fila);
		}
	}
	
	
	/*Ajustar el ancho de la columna*/
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbJugadores.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(this.anchoColumna(5)); //codigo
		tcm.getColumn(1).setPreferredWidth(this.anchoColumna(15)); //nombre
		tcm.getColumn(2).setPreferredWidth(this.anchoColumna(15)); //apellido
		tcm.getColumn(3).setPreferredWidth(this.anchoColumna(5)); //edad
		tcm.getColumn(4).setPreferredWidth(this.anchoColumna(8)); //apoderado
		tcm.getColumn(5).setPreferredWidth(this.anchoColumna(8)); //ficha
		tcm.getColumn(6).setPreferredWidth(this.anchoColumna(8)); //matricula
	}
	
	/*calcular ancho de columna*/
	private int anchoColumna(int porcentaje) {
		return porcentaje * scpScroll.getWidth() / 100;
	}
	
	
	/*Metodos adicionales*/
	private void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
	
	/*Metodos de mensaje*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
}
