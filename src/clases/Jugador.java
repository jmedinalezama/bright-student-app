package clases;

public class Jugador {
	
	private int codigojugador, codigoapoderado, codigoficha, codigomatricula;
	private int anionacimiento, mesnacimiento, dianacimiento, edadjugador;
	private String nombrejugador, apellidojugador, dnijugador, direccionjugador, telefonojugador, ultimamodificacion;
	private double estaturajugador, pesojugador;
		
	public Jugador(int codigojugador, int codigoapoderado, int codigoficha, int codigomatricula, String nombrejugador,
			String apellidojugador, String dnijugador, int anionacimiento, int mesnacimineto, int dianacimiento, int edadjugador,
			double estaturajugador, double pesojugador, String direccionjugador, String telefonojugador, 
			String ultimamodificacion) {
		
		this.codigojugador = codigojugador;
		this.codigoapoderado = codigoapoderado;
		this.codigoficha = codigoficha;
		this.codigomatricula = codigomatricula;
		this.nombrejugador = nombrejugador;
		this.apellidojugador = apellidojugador;
		this.dnijugador = dnijugador;
		this.anionacimiento = anionacimiento;
		this.mesnacimiento = mesnacimineto;
		this.dianacimiento = dianacimiento;
		this.edadjugador = edadjugador;
		this.estaturajugador = estaturajugador;
		this.pesojugador = pesojugador;
		this.direccionjugador = direccionjugador;
		this.telefonojugador = telefonojugador;
		this.ultimamodificacion = ultimamodificacion;

	}
	
	public Jugador(int codigoapoderado, String nombrejugador,String apellidojugador, String dnijugador,
			int anionacimiento, int mesnacimineto, int dianacimiento, int edadjugador,
			double estaturajugador, double pesojugador, String direccionjugador, String telefonojugador, 
			String ultimamodificacion) {
		
		this.codigoapoderado = codigoapoderado;
		this.nombrejugador = nombrejugador;
		this.apellidojugador = apellidojugador;
		this.dnijugador = dnijugador;
		this.anionacimiento = anionacimiento;
		this.mesnacimiento = mesnacimineto;
		this.dianacimiento = dianacimiento;
		this.edadjugador = edadjugador;
		this.estaturajugador = estaturajugador;
		this.pesojugador = pesojugador;
		this.direccionjugador = direccionjugador;
		this.telefonojugador = telefonojugador;
		this.ultimamodificacion = ultimamodificacion;

	}

	public int getCodigojugador() {
		return codigojugador;
	}

	public void setCodigojugador(int codigojugador) {
		this.codigojugador = codigojugador;
	}

	public int getCodigoapoderado() {
		return codigoapoderado;
	}

	public void setCodigoapoderado(int codigoapoderado) {
		this.codigoapoderado = codigoapoderado;
	}

	public int getCodigoficha() {
		return codigoficha;
	}

	public void setCodigoficha(int codigoficha) {
		this.codigoficha = codigoficha;
	}

	public int getCodigomatricula() {
		return codigomatricula;
	}

	public void setCodigomatricula(int codigomatricula) {
		this.codigomatricula = codigomatricula;
	}

	public String getNombrejugador() {
		return nombrejugador;
	}

	public void setNombrejugador(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}

	public String getApellidojugador() {
		return apellidojugador;
	}

	public void setApellidojugador(String apellidojugador) {
		this.apellidojugador = apellidojugador;
	}

	public String getDnijugador() {
		return dnijugador;
	}

	public void setDnijugador(String dnijugador) {
		this.dnijugador = dnijugador;
	}
	
	public int getAnionacimiento() {
		return anionacimiento;
	}

	public void setAnionacimiento(int anionacimiento) {
		this.anionacimiento = anionacimiento;
	}

	public int getMesnacimiento() {
		return mesnacimiento;
	}

	public void setMesnacimiento(int mesnacimiento) {
		this.mesnacimiento = mesnacimiento;
	}

	public int getDianacimiento() {
		return dianacimiento;
	}

	public void setDianacimiento(int dianacimiento) {
		this.dianacimiento = dianacimiento;
	}

	public int getEdadjugador() {
		return edadjugador;
	}

	public void setEdadjugador(int edadjugador) {
		this.edadjugador = edadjugador;
	}

	public double getEstaturajugador() {
		return estaturajugador;
	}

	public void setEstaturajugador(double estaturajugador) {
		this.estaturajugador = estaturajugador;
	}

	public double getPesojugador() {
		return pesojugador;
	}

	public void setPesojugador(double pesojugador) {
		this.pesojugador = pesojugador;
	}
	
	public String getDireccionjugador() {
		return direccionjugador;
	}

	public void setDireccionjugador(String direccionjugador) {
		this.direccionjugador = direccionjugador;
	}

	public String getTelefonojugador() {
		return telefonojugador;
	}

	public void setTelefonojugador(String telefonojugador) {
		this.telefonojugador = telefonojugador;
	}

	public String getUltimamodificacion() {
		return ultimamodificacion;
	}

	public void setUltimamodificacion(String ultimamodificacion) {
		this.ultimamodificacion = ultimamodificacion;
	}


}
