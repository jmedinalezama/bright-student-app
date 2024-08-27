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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import arreglos.ArregloMatriculas;
import clases.Matricula;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class InformacionMatricula extends JDialog implements ActionListener, MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel panelBar;
	private JLabel lblTituloVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JTextField txtCodigo;
	private JTextField txtPago;
	private JTextField txtFecha;
	private JLabel lblFecha;
	private JLabel lblCodigo;
	private JLabel lblEstado;
	private JComboBox<String> cmbEstado;
	private JPanel panelMatriculaOpcionales;
	private JLabel lblMatriculaOpcionales;
	private JCheckBox chkPolo;
	private JCheckBox chkCasaca;
	private JCheckBox chkShort;
	private JCheckBox chkBuzo;
	private JCheckBox chkMedias;
	private JCheckBox chkBotines;
	private JLabel lblPagoMatricula;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InformacionMatricula dialog = new InformacionMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InformacionMatricula() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InformacionMatricula.class.getResource("/imagenes/icon-window.png")));
		setTitle("Información Matricula");
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 600, 400, 25, 25));
		setSize(600, 400);
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
		
		lblTituloVentana = new JLabel("Información de la Matricula - Sesión de " + Login.user);
		lblTituloVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTituloVentana.setBounds(0, 0, 600, 30);
		panelBar.add(lblTituloVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(570, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(40, 65, 58, 20);
		getContentPane().add(lblCodigo);
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(96, 60, 93, 25);
		getContentPane().add(txtCodigo);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setForeground(Color.WHITE);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(Color.BLACK);
		
		lblFecha = new JLabel("Fecha de Registro:");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(227, 65, 129, 20);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setForeground(Color.WHITE);
		txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFecha.setColumns(10);
		txtFecha.setBackground(Color.BLACK);
		txtFecha.setBounds(356, 62, 200, 25);
		getContentPane().add(txtFecha);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(40, 116, 66, 20);
		getContentPane().add(lblEstado);
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cmbEstado = new JComboBox<String>();
		cmbEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Pendiente", "Pagado"}));
		cmbEstado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cmbEstado.setBounds(96, 113, 141, 25);
		getContentPane().add(cmbEstado);
		cmbEstado.setForeground(Color.WHITE);
		cmbEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbEstado.setBackground(Color.BLACK);
		
		panelMatriculaOpcionales = new JPanel();
		panelMatriculaOpcionales.setBounds(33, 166, 523, 110);
		getContentPane().add(panelMatriculaOpcionales);
		panelMatriculaOpcionales.setLayout(null);
		panelMatriculaOpcionales.setOpaque(false);
		panelMatriculaOpcionales.setBorder(new LineBorder(Color.WHITE, 1, true));
		
		lblMatriculaOpcionales = new JLabel("Opcionales");
		lblMatriculaOpcionales.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatriculaOpcionales.setForeground(Color.WHITE);
		lblMatriculaOpcionales.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMatriculaOpcionales.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblMatriculaOpcionales.setBounds(0, 0, 172, 20);
		panelMatriculaOpcionales.add(lblMatriculaOpcionales);
		
		chkPolo = new JCheckBox("Polo");
		chkPolo.addActionListener(this);
		chkPolo.setForeground(Color.WHITE);
		chkPolo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkPolo.setBorderPainted(true);
		chkPolo.setBorder(new LineBorder(Color.WHITE));
		chkPolo.setBackground(Color.BLACK);
		chkPolo.setBounds(22, 27, 97, 23);
		panelMatriculaOpcionales.add(chkPolo);
		
		chkCasaca = new JCheckBox("Casaca");
		chkCasaca.addActionListener(this);
		chkCasaca.setForeground(Color.WHITE);
		chkCasaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkCasaca.setBorderPainted(true);
		chkCasaca.setBorder(new LineBorder(Color.WHITE));
		chkCasaca.setBackground(Color.BLACK);
		chkCasaca.setBounds(214, 27, 97, 23);
		panelMatriculaOpcionales.add(chkCasaca);
		
		chkShort = new JCheckBox("Short");
		chkShort.addActionListener(this);
		chkShort.setForeground(Color.WHITE);
		chkShort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkShort.setBorderPainted(true);
		chkShort.setBorder(new LineBorder(Color.WHITE));
		chkShort.setBackground(Color.BLACK);
		chkShort.setBounds(22, 69, 97, 23);
		panelMatriculaOpcionales.add(chkShort);
		
		chkBuzo = new JCheckBox("Buzo");
		chkBuzo.addActionListener(this);
		chkBuzo.setForeground(Color.WHITE);
		chkBuzo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkBuzo.setBorderPainted(true);
		chkBuzo.setBorder(new LineBorder(Color.WHITE));
		chkBuzo.setBackground(Color.BLACK);
		chkBuzo.setBounds(214, 69, 97, 23);
		panelMatriculaOpcionales.add(chkBuzo);
		
		chkMedias = new JCheckBox("Medias");
		chkMedias.addActionListener(this);
		chkMedias.setForeground(Color.WHITE);
		chkMedias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkMedias.setBorderPainted(true);
		chkMedias.setBorder(new LineBorder(Color.WHITE));
		chkMedias.setBackground(Color.BLACK);
		chkMedias.setBounds(366, 27, 97, 23);
		panelMatriculaOpcionales.add(chkMedias);
		
		chkBotines = new JCheckBox("Botines");
		chkBotines.addActionListener(this);
		chkBotines.setForeground(Color.WHITE);
		chkBotines.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkBotines.setBorderPainted(true);
		chkBotines.setBorder(new LineBorder(Color.WHITE));
		chkBotines.setBackground(Color.BLACK);
		chkBotines.setBounds(366, 69, 97, 23);
		panelMatriculaOpcionales.add(chkBotines);
		
		lblPagoMatricula = new JLabel("Importe Total (S/.):");
		lblPagoMatricula.setBounds(33, 307, 136, 20);
		getContentPane().add(lblPagoMatricula);
		lblPagoMatricula.setForeground(Color.WHITE);
		lblPagoMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtPago = new JTextField();
		txtPago.setEditable(false);
		txtPago.setBounds(168, 304, 147, 25);
		getContentPane().add(txtPago);
		txtPago.setHorizontalAlignment(SwingConstants.CENTER);
		txtPago.setForeground(Color.WHITE);
		txtPago.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPago.setColumns(10);
		txtPago.setBackground(Color.BLACK);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBorder(new LineBorder(Color.GREEN, 2));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(436, 299, 120, 30);
		getContentPane().add(btnModificar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 600, 370);
		getContentPane().add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		this.cargarDatos();
		
	}
	
	ArregloMatriculas objMat = new ArregloMatriculas();
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnModificar) {
			this.actionPerformedBtnModificar();
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
	
	
	private void actionPerformedBtnModificar() {
		
		int opcion = confirmar("�Modificar datos de la matricula?"
				+ "\n Si cancela este proceso, se volver�n a cargar los datos"
				+ "\n originales de la matricula",
				"Modificar", 
				"src/imagenes/confirmar.png");
		if(opcion == 0) {
			int codigo = this.leerCodigoMatricula();
			String estado = this.leerEstadoMatricula();
			int polo = this.leerOpcionalMatricula(chkPolo);
			int pantalon = this.leerOpcionalMatricula(chkShort);
			int casaca = this.leerOpcionalMatricula(chkCasaca);
			int buzo = this.leerOpcionalMatricula(chkBuzo);
			int medias = this.leerOpcionalMatricula(chkMedias);
			int botines = this.leerOpcionalMatricula(chkBotines);
			double importematricula = this.leerImporteMatricula();
			
			Matricula matactual = objMat.buscarMatricula(codigo);
			Matricula matupdate = new Matricula(importematricula,estado,polo,pantalon,casaca,buzo,medias,botines);
			
			objMat.modificarMatricula(matactual, matupdate);
			
			mensaje("Se modific� la matricula correctamente",
					"Modificaci�n correcta", 
					"src/imagenes/correcto.png");
			
			this.cargarDatos();
		} else {
			this.cargarDatos();
		}
	}
	
	
	private void mouseClickedPanelSalir() {
		new InformacionJugador().setVisible(true);
		this.dispose();
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnModificar() {
		btnModificar.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnModificar.setBackground(Color.GREEN);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setText("MODIFICAR");
	}
	
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnModificar() {
		btnModificar.setBorder(new LineBorder(new Color(10, 190, 1), 2));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setText("Modificar");
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
	
	/*Cargar datos de la matricula*/
	private void cargarDatos() {
		Matricula mat = objMat.buscarMatricula(InformacionJugador.codigomatriculaseleccion);
		
		if(mat != null) {
			
			txtCodigo.setText(String.valueOf(mat.getCodigomatricula()));
			txtFecha.setText(this.fechaRegistroMatricula(mat));
			cmbEstado.setSelectedItem(mat.getEstadomatricula());
			this.verificarOpcionalMarcado(chkPolo, mat.getPolo());
			this.verificarOpcionalMarcado(chkShort, mat.getPantalon());
			this.verificarOpcionalMarcado(chkCasaca, mat.getCasaca());
			this.verificarOpcionalMarcado(chkBuzo, mat.getBuzo());
			this.verificarOpcionalMarcado(chkMedias, mat.getMedias());
			this.verificarOpcionalMarcado(chkBotines, mat.getBotines());
			txtPago.setText(String.valueOf(mat.getPagomatricula()));
			
		} else {
			mensaje("La matr�cula no se encontr�", "�Error!", "src/imagenes/error.png");
		}
	}
	
	
	/*obtener fecha de registro de matricula*/
	private String fechaRegistroMatricula(Matricula mat) {
		String anio = mat.getAniomatricula();
		String mes = this.obtenerMes(mat.getMesmatricula());
		String dia = mat.getDiamatricula();
		if(Integer.parseInt(dia)<10) {dia = "0"+dia;}
		
		return dia+" de "+mes+" de "+anio;		
	}
	
	/*obtener mes en Texto*/
	private String obtenerMes(String numero) {
		switch(numero) {
		case "1": return "Enero";
		case "2": return "Febrero";
		case "3": return "Marzo";
		case "4": return "Abril.";
		case "5": return "Mayo";
		case "6": return "Junio";
		case "7": return "Julio";
		case "8": return "Agosto";
		case "9": return "Septiembre";
		case "10": return "Octubre";
		case "11": return "Noviembre";
		default: return "Diciembre";
		}
	}
	
	
	/*verificar opcional marcado*/
	private void verificarOpcionalMarcado(JCheckBox chkbox, int numero) {
		if(numero == 1) {
			chkbox.setSelected(true);
		} else {
			chkbox.setSelected(false);
		}
	}
	
	/*mensaje y confirmacion*/
	private void mensaje(String texto, String titulo, String img ) {
		JOptionPane.showMessageDialog(this, texto,titulo,-1, new ImageIcon(img));
	}
	private int confirmar(String texto, String titulo, String img) {
		return JOptionPane.showConfirmDialog(this, texto, titulo, 2, -1, new ImageIcon(img));
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

		txtPago.setText(String.valueOf(importetotal));
	}
	
	
	/*leer datos del frame*/
	private int leerCodigoMatricula() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	private String leerEstadoMatricula() {
		return cmbEstado.getSelectedItem().toString();
	}
	private double leerImporteMatricula() {
		return Double.parseDouble(txtPago.getText().trim());
	}
	
	private int leerOpcionalMatricula(JCheckBox chkbox) {
		if(chkbox.isSelected()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}
