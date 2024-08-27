package ventanas;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class Bienvenida extends JFrame implements ActionListener, MouseListener, MouseMotionListener, Runnable{

	
	private static final long serialVersionUID = 1L;

	private int xMouse, yMouse;
	
	Thread hilo;
	
	private JPanel contentPane;
	private JPanel panelBar;
	private JLabel lblNombreVentana;
	private JPanel panelSalir;
	private JLabel lblSalir;
	private JLabel lblLogo;
	private JLabel lblFondo;
	private JLabel lblLogoBienvenida;
	private JProgressBar pbBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida frame = new Bienvenida();
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
	public Bienvenida() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bienvenida.class.getResource("/imagenes/icon-window.png")));
		setUndecorated(true);
		setTitle("Bienvenida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setShape(new RoundRectangle2D.Double(0, 0, 600, 500, 25, 25));
		setSize(600, 500);
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
		panelBar.setBounds(0, 0, 600, 30);
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
		
		lblNombreVentana = new JLabel("Bright Students");
		lblNombreVentana.setForeground(Color.BLACK);
		lblNombreVentana.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreVentana.setBackground(Color.WHITE);
		lblNombreVentana.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreVentana.setBounds(0, 0, 600, 30);
		panelBar.add(lblNombreVentana);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setBounds(570, 0, 30, 30);
		panelBar.add(lblLogo);
		this.colocarImagenLabel("src/imagenes/icon-frame.png", lblLogo);
		
		lblLogoBienvenida = new JLabel("");
		lblLogoBienvenida.setBackground(Color.RED);
		lblLogoBienvenida.setBounds(150, 55, 300, 250);
		contentPane.add(lblLogoBienvenida);
		this.colocarImagenLabel("src/imagenes/bienvenida.jpg", lblLogoBienvenida);
		
		pbBar = new JProgressBar();
		pbBar.setStringPainted(true);
		pbBar.setForeground(Color.GREEN);
		pbBar.setBackground(Color.BLACK);
		pbBar.setFont(new Font("Tahoma", Font.BOLD, 15));
		pbBar.setBounds(100, 380, 400, 30);
		contentPane.add(pbBar);
		
		lblFondo = new JLabel("");
		lblFondo.setBounds(0, 30, 600, 470);
		contentPane.add(lblFondo);
		this.colocarImagenLabel("src/imagenes/fondo-principal.png", lblFondo);
		
		hilo = new Thread(this);
		hilo.start();
		
	}
	
	public void run() {
		int i = 1;
		while(hilo != null) {
			try {
				Thread.sleep(30);
				pbBar.setValue(i);
				if(i > 100) {
					hilo = null;
					this.VerificarTerminosYCondiciones();
				}
				i++;
			}catch(Exception ex) {
			}
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
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
	public void mouseMoved(MouseEvent e) {
		
	}
	
	
	
	
	
	private void mouseClickedPanelSalir() {
		this.dispose();
		System.exit(0);
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
	
	
	
	/*Metodos para el JFrame*/
	private void VerificarTerminosYCondiciones() {
		
		String valor = this.ObtenerValorTerminosYCondiciones();
		
		if(valor.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "No se encontr� el archivo T�rminos y Condiciones");
		} else if(valor.equalsIgnoreCase("Acepto")) {
			new Login().setVisible(true);
		} else {
			new TerminosCondiciones().setVisible(true);
		}
		
		this.dispose();
	}
	
	private String ObtenerValorTerminosYCondiciones() {
		try {
			BufferedReader archivo;
			archivo = new BufferedReader(new FileReader("Terminos.txt"));
			
			String valor = archivo.readLine().trim();
			
			archivo.close();
			return valor;
			
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error al cargar valor de t�rminos y condiciones " + ex);
		}
		return "";
	}

	
	/*Metodos adicionales*/
	private void colocarImagenLabel(String ruta, JLabel label) {
		ImageIcon logo = new ImageIcon(ruta);
		Icon logo_icon = new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(logo_icon);
		this.repaint();
	}
}
