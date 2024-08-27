package clases;

public class Usuario {
	
	private int codigousuario;
	private String nombreusuario, apellidousuario, correousuario, telefonousuario, direccionusuario;
	private String nivelusuario, estadousuario, username, password, registradopor;
	
	
	public Usuario(int codigousuario, String nombreusuario, String apellidousuario, String correousuario,
			String telefonousuario, String direccionusuario, String nivelusuario, String estadousuario, String username,
			String password, String registradopor) {
		this.codigousuario = codigousuario;
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.correousuario = correousuario;
		this.telefonousuario = telefonousuario;
		this.direccionusuario = direccionusuario;
		this.nivelusuario = nivelusuario;
		this.estadousuario = estadousuario;
		this.username = username;
		this.password = password;
		this.registradopor = registradopor;
	}
	
	public Usuario(String nombreusuario, String apellidousuario, String correousuario,
			String telefonousuario, String direccionusuario, String nivelusuario, String estadousuario, String username,
			String password, String registradopor) {
		this.nombreusuario = nombreusuario;
		this.apellidousuario = apellidousuario;
		this.correousuario = correousuario;
		this.telefonousuario = telefonousuario;
		this.direccionusuario = direccionusuario;
		this.nivelusuario = nivelusuario;
		this.estadousuario = estadousuario;
		this.username = username;
		this.password = password;
		this.registradopor = registradopor;
	}

	public int getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(int codigousuario) {
		this.codigousuario = codigousuario;
	}

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getApellidousuario() {
		return apellidousuario;
	}

	public void setApellidousuario(String apellidousuario) {
		this.apellidousuario = apellidousuario;
	}

	public String getCorreousuario() {
		return correousuario;
	}

	public void setCorreousuario(String correousuario) {
		this.correousuario = correousuario;
	}

	public String getTelefonousuario() {
		return telefonousuario;
	}

	public void setTelefonousuario(String telefonousuario) {
		this.telefonousuario = telefonousuario;
	}

	public String getDireccionusuario() {
		return direccionusuario;
	}

	public void setDireccionusuario(String direccionusuario) {
		this.direccionusuario = direccionusuario;
	}

	public String getNivelusuario() {
		return nivelusuario;
	}

	public void setNivelusuario(String nivelusuario) {
		this.nivelusuario = nivelusuario;
	}

	public String getEstadousuario() {
		return estadousuario;
	}

	public void setEstadousuario(String estadousuario) {
		this.estadousuario = estadousuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistradopor() {
		return registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}
	
	
	
	
	

}
