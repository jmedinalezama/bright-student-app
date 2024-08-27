package clases;

public class FichaJugador {
	
	private int codigoficha;
	/*General*/
	private String categoria, piernahabil, posicion;
	/*Tecnica*/
	private int controlbalon, conduccion, vision, cabeceo, dribling, cambioderitmo, definicion, penal, tirolibre;
	/*Fisico*/
	private int resistencia, potencia, flexibilidad, velocidad;
	
	private String ultimamodificacion;
	
	public FichaJugador(int codigoficha, String categoria, String piernahabil, String posicion, int controlbalon, int conduccion,
			int vision, int cabeceo, int dribling, int cambioderitmo, int definicion, int penal, int tirolibre,
			int resistencia, int potencia, int flexibilidad, int velocidad, String ultimamodificacion) {

		this.codigoficha = codigoficha;
		this.categoria = categoria;
		this.piernahabil = piernahabil;
		this.posicion = posicion;
		this.controlbalon = controlbalon;
		this.conduccion = conduccion;
		this.vision = vision;
		this.cabeceo = cabeceo;
		this.dribling = dribling;
		this.cambioderitmo = cambioderitmo;
		this.definicion = definicion;
		this.penal = penal;
		this.tirolibre = tirolibre;
		this.resistencia = resistencia;
		this.potencia = potencia;
		this.flexibilidad = flexibilidad;
		this.velocidad = velocidad;
		this.ultimamodificacion = ultimamodificacion;
	}
	
	public FichaJugador(String categoria, String piernahabil, String posicion, int controlbalon, int conduccion,
			int vision, int cabeceo, int dribling, int cambioderitmo, int definicion, int penal, int tirolibre,
			int resistencia, int potencia, int flexibilidad, int velocidad, String ultimamodificacion) {

		this.categoria = categoria;
		this.piernahabil = piernahabil;
		this.posicion = posicion;
		this.controlbalon = controlbalon;
		this.conduccion = conduccion;
		this.vision = vision;
		this.cabeceo = cabeceo;
		this.dribling = dribling;
		this.cambioderitmo = cambioderitmo;
		this.definicion = definicion;
		this.penal = penal;
		this.tirolibre = tirolibre;
		this.resistencia = resistencia;
		this.potencia = potencia;
		this.flexibilidad = flexibilidad;
		this.velocidad = velocidad;
		this.ultimamodificacion = ultimamodificacion;
	}

	public int getCodigoficha() {
		return codigoficha;
	}

	public void setCodigoficha(int codigoficha) {
		this.codigoficha = codigoficha;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getPiernahabil() {
		return piernahabil;
	}

	public void setPiernahabil(String piernahabil) {
		this.piernahabil = piernahabil;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getControlbalon() {
		return controlbalon;
	}

	public void setControlbalon(int controlbalon) {
		this.controlbalon = controlbalon;
	}

	public int getConduccion() {
		return conduccion;
	}

	public void setConduccion(int conduccion) {
		this.conduccion = conduccion;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}

	public int getCabeceo() {
		return cabeceo;
	}

	public void setCabeceo(int cabeceo) {
		this.cabeceo = cabeceo;
	}

	public int getDribling() {
		return dribling;
	}

	public void setDribling(int dribling) {
		this.dribling = dribling;
	}

	public int getCambioderitmo() {
		return cambioderitmo;
	}

	public void setCambioderitmo(int cambioderitmo) {
		this.cambioderitmo = cambioderitmo;
	}

	public int getDefinicion() {
		return definicion;
	}

	public void setDefinicion(int definicion) {
		this.definicion = definicion;
	}

	public int getPenal() {
		return penal;
	}

	public void setPenal(int penal) {
		this.penal = penal;
	}

	public int getTirolibre() {
		return tirolibre;
	}

	public void setTirolibre(int tirolibre) {
		this.tirolibre = tirolibre;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resitencia) {
		this.resistencia = resitencia;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getFlexibilidad() {
		return flexibilidad;
	}

	public void setFlexibilidad(int flexibilidad) {
		this.flexibilidad = flexibilidad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public String getUltimamodificacion() {
		return ultimamodificacion;
	}
	public void setUltimamodificacion(String ultimamodificacion) {
		this.ultimamodificacion = ultimamodificacion;
	}
	
	
	/*valoracion del jugador*/
	public int valoracionJugador() {
		return (controlbalon + conduccion + vision + cabeceo + dribling + cambioderitmo + definicion + penal +
				tirolibre + resistencia + potencia + flexibilidad + velocidad) / 13;
	}
}
