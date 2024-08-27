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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloUsuarios;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionarUsuarios extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	
	private int xMouse, yMouse;
	private DefaultTableModel model;
	private boolean seleccionregistro = false;
	public static int updatecodigo;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JScrollPane scpScroll;
	private JTable tbUsuarios;
	private JLabel lblBuscar;
	private JComboBox<String> cmbBuscarNivel;
	private JButton btnVerUsuario;
	private JLabel lblFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionarUsuarios dialog = new GestionarUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionarUsuarios() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionarUsuarios.class.getResource("/imagenes/icon-window.png")));
		setTitle("Gestionar Usuarios");
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
		
		lblTituloVentana = new JLabel("Gestionar Usuarios - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 600, 30);
		panelBar.add(lblTituloVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(570, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(50, 110, 500, 260);
		getContentPane().add(scpScroll);
		
		tbUsuarios = new JTable();
		tbUsuarios.addMouseListener(this);
		scpScroll.setViewportView(tbUsuarios);
		
		lblBuscar = new JLabel("Buscar por nivel:");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBuscar.setBackground(Color.BLACK);
		lblBuscar.setBounds(245, 85, 150, 20);
		getContentPane().add(lblBuscar);
		
		cmbBuscarNivel = new JComboBox<String>();
		cmbBuscarNivel.addActionListener(this);
		cmbBuscarNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbBuscarNivel.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos", "Administrador", "Secretario", "Entrenador"}));
		cmbBuscarNivel.setBackground(Color.BLACK);
		cmbBuscarNivel.setForeground(Color.WHITE);
		cmbBuscarNivel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbBuscarNivel.setBounds(380, 80, 170, 25);
		getContentPane().add(cmbBuscarNivel);
		
		btnVerUsuario = new JButton("Ver Usuario");
		btnVerUsuario.addActionListener(this);
		btnVerUsuario.addMouseListener(this);
		btnVerUsuario.setBorder(new LineBorder(Color.GREEN, 2));
		btnVerUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerUsuario.setForeground(Color.WHITE);
		btnVerUsuario.setBackground(Color.BLACK);
		btnVerUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVerUsuario.setBounds(400, 385, 150, 30);
		getContentPane().add(btnVerUsuario);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 600, 470);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		model = new DefaultTableModel();
		model.addColumn("CODIGO");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDO");
		model.addColumn("NIVEL");
		model.addColumn("ESTADO");
		
		tbUsuarios.setModel(model);
		
		this.ajustarAnchoColumnas();
		this.listarUsuarios();
		
	}
	
	ArregloUsuarios objUsu = new ArregloUsuarios();
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cmbBuscarNivel) {
			this.actionPerformedCmbBuscarPorNivel();
		}
		if(e.getSource() == btnVerUsuario) {
			this.actionPerformedBtnVerUsuario();
		}
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == tbUsuarios) {
			this.mouseClickedTbUsuarios(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == btnVerUsuario) {
			this.mouseEnteredBtnVerUsuario();;
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == btnVerUsuario) {
			this.mouseExitedBtnVerUsuario();;
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
	
	
	
	
	
	private void actionPerformedCmbBuscarPorNivel() {
		this.listarUsuarios();
	}
	private void actionPerformedBtnVerUsuario() {
		if(seleccionregistro) {
			new InformacionUsuario().setVisible(true);
			this.dispose();
		} else {
			mensaje("No se seleccion� ning�n registro", "�Error!", "src/imagenes/error.png");
		}
	}
	
	private void mouseClickedPanelSalir() {
		new Administrador().setVisible(true);
		this.dispose();
	}
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnVerUsuario() {
		btnVerUsuario.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnVerUsuario.setBackground(Color.GREEN);
		btnVerUsuario.setForeground(Color.BLACK);
		btnVerUsuario.setText("VER USUARIO");
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnVerUsuario() {
		btnVerUsuario.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnVerUsuario.setBackground(Color.BLACK);
		btnVerUsuario.setForeground(Color.WHITE);
		btnVerUsuario.setText("Ver Usuario");
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
	private void mouseClickedTbUsuarios(MouseEvent e) {
		int filapos = tbUsuarios.rowAtPoint(e.getPoint());
		int columnapos = 0;
		
		if(filapos > -1) {
			updatecodigo = (int) model.getValueAt(filapos, columnapos);
			seleccionregistro = true;
		}
	}
	
	/*metodo listar usuarios*/
	private void listarUsuarios() {
		model.setRowCount(0);
		
		this.listarUsuariosPorNivel();
	
	}
	/*Listar por nivel o todos los usuarios*/
	private void listarUsuariosPorNivel() {
		seleccionregistro = false;
		String nivel = cmbBuscarNivel.getSelectedItem().toString().trim();
		
		switch(nivel) {
		case "Administrador":
			for(int i = 0; i < objUsu.tamanioUsuario(); i++) {
				if(objUsu.obtenerUsuario(i).getNivelusuario().equalsIgnoreCase("Administrador")) {
					Object fila[] = {
							objUsu.obtenerUsuario(i).getCodigousuario(),
							objUsu.obtenerUsuario(i).getNombreusuario(),
							objUsu.obtenerUsuario(i).getApellidousuario(),
							objUsu.obtenerUsuario(i).getNivelusuario(),
							objUsu.obtenerUsuario(i).getEstadousuario()
					};
					model.addRow(fila);
				}
			}
			break;
		case "Secretario":
			for(int i = 0; i < objUsu.tamanioUsuario(); i++) {
				if(objUsu.obtenerUsuario(i).getNivelusuario().equalsIgnoreCase("Secretario")) {
					Object fila[] = {
							objUsu.obtenerUsuario(i).getCodigousuario(),
							objUsu.obtenerUsuario(i).getNombreusuario(),
							objUsu.obtenerUsuario(i).getApellidousuario(),
							objUsu.obtenerUsuario(i).getNivelusuario(),
							objUsu.obtenerUsuario(i).getEstadousuario()
					};
					model.addRow(fila);
				}
			}
			break;
		
		case "Entrenador":
			for(int i = 0; i < objUsu.tamanioUsuario(); i++) {
				if(objUsu.obtenerUsuario(i).getNivelusuario().equalsIgnoreCase("Entrenador")) {
					Object fila[] = {
							objUsu.obtenerUsuario(i).getCodigousuario(),
							objUsu.obtenerUsuario(i).getNombreusuario(),
							objUsu.obtenerUsuario(i).getApellidousuario(),
							objUsu.obtenerUsuario(i).getNivelusuario(),
							objUsu.obtenerUsuario(i).getEstadousuario()
					};
					model.addRow(fila);
				}
			}
			break;
		default:
			for(int i = 0; i < objUsu.tamanioUsuario(); i++) {
				Object fila[] = {
						objUsu.obtenerUsuario(i).getCodigousuario(),
						objUsu.obtenerUsuario(i).getNombreusuario(),
						objUsu.obtenerUsuario(i).getApellidousuario(),
						objUsu.obtenerUsuario(i).getNivelusuario(),
						objUsu.obtenerUsuario(i).getEstadousuario()
				};
				model.addRow(fila);	
			}
			break;
		}
	}
	
	
	/*Ajustar el ancho de la columna*/
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbUsuarios.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(this.anchoColumna(6)); //codigo
		tcm.getColumn(1).setPreferredWidth(this.anchoColumna(10)); //nombre
		tcm.getColumn(2).setPreferredWidth(this.anchoColumna(10)); //apellido
		tcm.getColumn(3).setPreferredWidth(this.anchoColumna(15)); //nivel
		tcm.getColumn(4).setPreferredWidth(this.anchoColumna(10)); //estado
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
