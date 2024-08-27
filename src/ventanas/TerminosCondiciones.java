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
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TerminosCondiciones extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	private JPanel contentPane;
	private JPanel panelBar;
	private JLabel lblNombreVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JPanel panelMinimizar;
	private JLabel lblMinimizar;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JScrollPane scpScroll;
	private JTextArea textATerminos;
	private JCheckBox chkAceptar;
	private JButton btnNoAcepto;
	private JButton btnAcepto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TerminosCondiciones frame = new TerminosCondiciones();
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
	public TerminosCondiciones() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TerminosCondiciones.class.getResource("/imagenes/icon-window.png")));
		setUndecorated(true);
		setTitle("Terminos y Condiciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 800, 500, 25, 25));
		setSize(800, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBar = new JPanel();
		panelBar.addMouseMotionListener(this);
		panelBar.addMouseListener(this);
		panelBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelBar.setBackground(Color.CYAN);
		panelBar.setBounds(0, 0, 800, 30);
		contentPane.add(panelBar);
		panelBar.setLayout(null);
		
		panelSalir = new JPanel();
		panelSalir.addMouseListener(this);
		panelSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSalir.setBounds(0, 0, 30, 30);
		panelSalir.setBackground(new Color(225,100,100));
		panelBar.add(panelSalir);
		panelSalir.setLayout(null);
		
		lblSalir = new JLabel("X");
		lblSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblMinimizar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblMinimizar.setBounds(0, 0, 30, 30);
		panelMinimizar.add(lblMinimizar);
		
		lblNombreVentana = new JLabel("T\u00E9rminos y Condiciones");
		lblNombreVentana.setForeground(Color.BLACK);
		lblNombreVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreVentana.setBackground(Color.WHITE);
		lblNombreVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreVentana.setBounds(0, 0, 800, 30);
		panelBar.add(lblNombreVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(770, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(100, 80, 600, 250);
		contentPane.add(scpScroll);
		
		textATerminos = new JTextArea();
		textATerminos.setEditable(false);
		textATerminos.setText("\n     TÉRMINOS Y CONDICIONES" +
                 "\n\n     A. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE JERSON MEDINA." +
                 "\n     B. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                 "\n     C. JERSON MEDINA NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                 "\n\n     Los acuerdos legales expuestos a continuación rigen el uso que usted haga de este software" +
                 "\n     (JERSON MEDINA), no se responsabiliza del uso que usted haga con este software y sus servicios." +
                 "\n     Para aceptar estos términos, haga clic en 'Acepto', si usted no acepta estos términos, haga clic en" +
                 "\n     'No Acepto' y no utilice este software y sus servicios." +
                 "\n\n     PARA MAYOR INFORMACIÓN SOBRE MIS PRODUCTOS Y/O SERVICIOS, POR FAVOR VISITE" +
                 "\n     Instagram: @jmedinalezama");
		scpScroll.setViewportView(textATerminos);
		
		chkAceptar = new JCheckBox("Aceptar T\u00E9rminos y Condiciones");
		chkAceptar.addActionListener(this);
		chkAceptar.setBounds(100, 330, 600, 30);
		contentPane.add(chkAceptar);
		
		btnNoAcepto = new JButton("No Acepto");
		btnNoAcepto.addActionListener(this);
		btnNoAcepto.addMouseListener(this);
		btnNoAcepto.setBackground(new Color(250,110,110));
		btnNoAcepto.setBorder(new LineBorder(Color.RED, 2));
		btnNoAcepto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNoAcepto.setBounds(580, 367, 120, 30);
		contentPane.add(btnNoAcepto);
		
		btnAcepto = new JButton("Acepto");
		btnAcepto.addActionListener(this);
		btnAcepto.addMouseListener(this);
		btnAcepto.setBackground(new Color(140,230,140));
		btnAcepto.setEnabled(false);
		btnAcepto.setBorder(new LineBorder(Color.GREEN, 2));
		btnAcepto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcepto.setBounds(450, 367, 100, 30);
		contentPane.add(btnAcepto);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 800, 470);
		contentPane.add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo1.jpg", lblFondo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == chkAceptar) {
			this.actionPerformedChKAceptar();
		}
		if(e.getSource() == btnNoAcepto) {
			this.actionPerformedBtnNoAcepto();
		}
		if(e.getSource() == btnAcepto) {
			this.actionPerformedBtnAcepto();
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseClickedPanelSalir();
		}
		if(e.getSource() == panelMinimizar) {
			this.mouseClickedPanelMinimizar();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseEnteredPanelSalir();
		}
		if(e.getSource() == panelMinimizar) {
			this.mouseEnteredPanelMinimizar();
		}
		if(e.getSource() == btnAcepto) {
			this.mouseEnteredBtnAcepto();
		}
		if(e.getSource() == btnNoAcepto) {
			this.mouseEnteredBtnNoAcepto();
		}
	}
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == panelSalir) {
			this.mouseExitedPanelSalir();
		}
		if(e.getSource() == panelMinimizar) {
			this.mouseExitedPanelMinimizar();
		}
		if(e.getSource() == btnAcepto) {
			this.mouseExitedBtnAcepto();
		}
		if(e.getSource() == btnNoAcepto) {
			this.mouseExitedBtnNoAcepto();
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
	public void mouseMoved(MouseEvent e) {
		
	}
	
	
	
	private void actionPerformedChKAceptar() {
		if(chkAceptar.isSelected()) {
			btnAcepto.setEnabled(true);
			btnNoAcepto.setEnabled(false);
		} else {
			btnAcepto.setEnabled(false);
			btnNoAcepto.setEnabled(true);
		}
		
	}
	
	private void actionPerformedBtnNoAcepto() {
		this.dispose();
	}
	
	private void actionPerformedBtnAcepto() {
		try {
			
			PrintWriter archivo;
			String valor = "Acepto";
			archivo = new PrintWriter(new FileWriter("Terminos.txt"));
			archivo.println(valor);
			archivo.close();
			
			new Login().setVisible(true);
			this.dispose();
			
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error al actualizar T�rminos y Condiciones " + ex);
		}
	}
	
	
	private void mouseClickedPanelSalir() {
		this.dispose();
		System.exit(0);
	}
	private void mouseClickedPanelMinimizar() {
		this.setExtendedState(1);
	}
	
	
	
	private void mouseEnteredPanelSalir() {
		panelSalir.setBackground(new Color(255,0,0));
		lblSalir.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredPanelMinimizar() {
		panelMinimizar.setBackground(new Color(10,240,0));
		lblMinimizar.setForeground(new Color(255,255,255));
	}
	private void mouseEnteredBtnAcepto() {
		if(btnAcepto.isEnabled() == true) {
			btnAcepto.setBackground(new Color(10,240,0));
			btnAcepto.setForeground(new Color(255,255,255));
			btnAcepto.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnAcepto.setText("ACEPTO");
		}
	}
	private void mouseEnteredBtnNoAcepto() {
		if(btnNoAcepto.isEnabled() == true) {
			btnNoAcepto.setBackground(new Color(255,0,0));
			btnNoAcepto.setForeground(new Color(255,255,255));
			btnNoAcepto.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNoAcepto.setText("NO ACEPTO");
		}
	}
	
	
	
	private void mouseExitedPanelSalir() {
		panelSalir.setBackground(new Color(225,100,100));
		lblSalir.setForeground(new Color(0,0,0));
	}
	private void mouseExitedPanelMinimizar() {
		panelMinimizar.setBackground(new Color(125,245,120));
		lblMinimizar.setForeground(new Color(0,0,0));
	}
	private void mouseExitedBtnAcepto() {
		btnAcepto.setBackground(new Color(140,230,140));
		btnAcepto.setForeground(new Color(0,0,0));
		btnAcepto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAcepto.setText("Acepto");
	}
	private void mouseExitedBtnNoAcepto() {
		btnNoAcepto.setBackground(new Color(250,110,110));
		btnNoAcepto.setForeground(new Color(0,0,0));
		btnNoAcepto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNoAcepto.setText("No Acepto");
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
}
