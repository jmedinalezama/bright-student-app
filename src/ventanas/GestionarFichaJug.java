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

import arreglos.ArregloFicha;
import arreglos.ArregloJugador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarFichaJug extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private int xMouse, yMouse;
	private DefaultTableModel model;
	private boolean seleccionregistro = false;
	public static int codigojugadorseleccionado;
	
	ArregloJugador objJug = new ArregloJugador();
	ArregloFicha objFiJug = new ArregloFicha();
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JScrollPane scpScroll;
	private JTable tbFichaJug;
	private JButton btnVerFicha;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionarFichaJug dialog = new GestionarFichaJug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionarFichaJug() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarFichaJug.class.getResource("/imagenes/icon-window.png")));
		setTitle("Gestionar Ficha Jugador");
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
		
		lblTituloVentana = new JLabel("Gestionar Ficha de Jugador - Sesión de " + Login.user);
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
		
		tbFichaJug = new JTable();
		tbFichaJug.addMouseListener(this);
		scpScroll.setViewportView(tbFichaJug);
		
		btnVerFicha = new JButton("Ver Ficha");
		btnVerFicha.addActionListener(this);
		btnVerFicha.addMouseListener(this);
		btnVerFicha.setBorder(new LineBorder(Color.GREEN, 2));
		btnVerFicha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerFicha.setForeground(Color.WHITE);
		btnVerFicha.setBackground(Color.BLACK);
		btnVerFicha.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerFicha.setBounds(600, 385, 150, 30);
		getContentPane().add(btnVerFicha);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		model = new DefaultTableModel();
		model.addColumn("COD. JUG.");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("COD. FICHA");
		model.addColumn("CATEGORIA");
		model.addColumn("POSICION");
		
		tbFichaJug.setModel(model);
		
		this.ajustarAnchoColumnas();
		this.listarFichasJugadores();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnVerFicha) {
			this.actionPerformedBtnVerFicha();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == tbFichaJug) {
			this.mouseClickedTbFichasJug(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == btnVerFicha) {
			this.mouseEnteredBtnVerFicha();;
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnVerFicha) {
			this.mouseExitedBtnVerFicha();;
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
	
	
	
	private void actionPerformedBtnVerFicha() {
		if(seleccionregistro) {
			new InformacionFichaJug().setVisible(true);
			this.dispose();
		} else {
			mensaje("No se seleccion� ning�n registro", "�Error!", "src/imagenes/error.png");
		}
	}
	
	private void mouseClickedPanelSalir() {
		new Entrenador().setVisible(true);
		this.dispose();
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnVerFicha() {
		btnVerFicha.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnVerFicha.setBackground(Color.GREEN);
		btnVerFicha.setForeground(Color.BLACK);
		btnVerFicha.setText("VER FICHA");
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnVerFicha() {
		btnVerFicha.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerFicha.setBackground(Color.BLACK);
		btnVerFicha.setForeground(Color.WHITE);
		btnVerFicha.setText("Ver Ficha");
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
	private void mouseClickedTbFichasJug(MouseEvent e) {
		int filapos = tbFichaJug.rowAtPoint(e.getPoint());
		int columnapos = 0;
		
		if(filapos > -1) {
			codigojugadorseleccionado = (int) model.getValueAt(filapos, columnapos);
			seleccionregistro = true;
		}
	}
	
	
	/*listar fichas de jugadores*/
	private void listarFichasJugadores() {
		model.setRowCount(0);
		for(int i = 0; i < objJug.tamanioJugador(); i++) {
			Object fila[] = {
				objJug.obtenerJugador(i).getCodigojugador(),
				objJug.obtenerJugador(i).getNombrejugador(),
				objJug.obtenerJugador(i).getApellidojugador(),
				objFiJug.obtenerFicha(i).getCodigoficha(),
				objFiJug.obtenerFicha(i).getCategoria(),
				objFiJug.obtenerFicha(i).getPosicion()
			};
			model.addRow(fila);
		}
	}
	
	
	
	/*Ajustar el ancho de la columna*/
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbFichaJug.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(this.anchoColumna(6)); //codigo jugador
		tcm.getColumn(1).setPreferredWidth(this.anchoColumna(12)); //nombre
		tcm.getColumn(2).setPreferredWidth(this.anchoColumna(12)); //apellido
		tcm.getColumn(3).setPreferredWidth(this.anchoColumna(6)); //codigo ficha
		tcm.getColumn(4).setPreferredWidth(this.anchoColumna(8)); //categoria
		tcm.getColumn(5).setPreferredWidth(this.anchoColumna(15)); //posicion
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
