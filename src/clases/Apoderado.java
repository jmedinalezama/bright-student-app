package clases;

public class Apoderado {
	
	private int codigoapoderado;
	private String nombreapoderado, apellidoapoderado, dniapoderado, direccionapoderado, telefonoapoderado, ultimamodificacion;
	
	
	public Apoderado(int codigoapoderado, String nombreapoderado, String apellidoapoderado, String dniapoderado,
			String direccionapoderado, String telefonoapoderado, String ultimamodificacion) {
		
		this.codigoapoderado = codigoapoderado;
		this.nombreapoderado = nombreapoderado;
		this.apellidoapoderado = apellidoapoderado;
		this.dniapoderado = dniapoderado;
		this.direccionapoderado = direccionapoderado;
		this.telefonoapoderado = telefonoapoderado;
		this.ultimamodificacion = ultimamodificacion;
	}
	
	public Apoderado(String nombreapoderado, String apellidoapoderado, String dniapoderado,
			String direccionapoderado, String telefonoapoderado, String ultimamodificacion) {
		
		this.nombreapoderado = nombreapoderado;
		this.apellidoapoderado = apellidoapoderado;
		this.dniapoderado = dniapoderado;
		this.direccionapoderado = direccionapoderado;
		this.telefonoapoderado = telefonoapoderado;
		this.ultimamodificacion = ultimamodificacion;
	}

	public int getCodigoapoderado() {
		return codigoapoderado;
	}

	public void setCodigoapoderado(int codigoapoderado) {
		this.codigoapoderado = codigoapoderado;
	}

	public String getNombreapoderado() {
		return nombreapoderado;
	}

	public void setNombreapoderado(String nombreapoderado) {
		this.nombreapoderado = nombreapoderado;
	}

	public String getApellidoapoderado() {
		return apellidoapoderado;
	}

	public void setApellidoapoderado(String apellidoapoderado) {
		this.apellidoapoderado = apellidoapoderado;
	}

	public String getDniapoderado() {
		return dniapoderado;
	}

	public void setDniapoderado(String dniapoderado) {
		this.dniapoderado = dniapoderado;
	}

	public String getDireccionapoderado() {
		return direccionapoderado;
	}

	public void setDireccionapoderado(String direccionapoderado) {
		this.direccionapoderado = direccionapoderado;
	}

	public String getTelefonoapoderado() {
		return telefonoapoderado;
	}

	public void setTelefonoapoderado(String telefonoapoderado) {
		this.telefonoapoderado = telefonoapoderado;
	}

	public String getUltimamodificacion() {
		return ultimamodificacion;
	}

	public void setUltimamodificacion(String ultimamodificacion) {
		this.ultimamodificacion = ultimamodificacion;
	}
	


}
