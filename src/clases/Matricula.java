package clases;

import java.util.Calendar;

public class Matricula {

	private int codigomatricula;
	private String estadomatricula, aniomatricula, mesmatricula, diamatricula;
	private double pagomatricula; 
	private int polo, pantalon, casaca, buzo, medias, botines;
	
	/*constructor para ingresar nueva matricula*/
	public Matricula(int codigomatricula, double pagomatricula, String estadomatricula, int polo, int pantalon,
			int casaca, int buzo, int medias, int botines) {
		
		this.codigomatricula = codigomatricula;
		this.pagomatricula = pagomatricula;
		this.estadomatricula = estadomatricula;
		
		Calendar calendario = Calendar.getInstance();
		this.aniomatricula = Integer.toString(calendario.get(Calendar.YEAR));
		this.mesmatricula = Integer.toString(calendario.get(Calendar.MONTH)+1);
		this.diamatricula = Integer.toString(calendario.get(Calendar.DATE));
		
		this.polo = polo;
		this.pantalon = pantalon;
		this.casaca = casaca;
		this.buzo = buzo;
		this.medias = medias;
		this.botines = botines;
		
	}
	
	/*constructor para cargar las matriculas*/
	public Matricula(int codigomatricula, double pagomatricula, String estadomatricula, String aniomatricula,
			String mesmatricula, String diamatricula, int polo, int pantalon, int casaca, int buzo, int medias,
			int botines) {
		this.codigomatricula = codigomatricula;
		this.pagomatricula = pagomatricula;
		this.estadomatricula = estadomatricula;
		
		this.aniomatricula = aniomatricula;
		this.mesmatricula = mesmatricula;
		this.diamatricula = diamatricula;
		
		this.polo = polo;
		this.pantalon = pantalon;
		this.casaca = casaca;
		this.buzo = buzo;
		this.medias = medias;
		this.botines = botines;
	}
	
	
	/*constructor para actualizar matricula*/
	public Matricula(double pagomatricula, String estadomatricula, int polo, int pantalon,
			int casaca, int buzo, int medias, int botines) {
		
		this.pagomatricula = pagomatricula;
		this.estadomatricula = estadomatricula;		
		this.polo = polo;
		this.pantalon = pantalon;
		this.casaca = casaca;
		this.buzo = buzo;
		this.medias = medias;
		this.botines = botines;
		
	}

	

	public int getCodigomatricula() {
		return codigomatricula;
	}

	public void setCodigomatricula(int codigomatricula) {
		this.codigomatricula = codigomatricula;
	}
	
	public double getPagomatricula() {
		return pagomatricula;
	}

	public void setPagomatricula(double pagomatricula) {
		this.pagomatricula = pagomatricula;
	}
	
	public String getEstadomatricula() {
		return estadomatricula;
	}

	public void setEstadomatricula(String estadomatricula) {
		this.estadomatricula = estadomatricula;
	}
	
	public String getAniomatricula() {
		return aniomatricula;
	}

	public void setAniomatricula(String aniomatricula) {
		this.aniomatricula = aniomatricula;
	}

	public String getMesmatricula() {
		return mesmatricula;
	}

	public void setMesmatricula(String mesmatricula) {
		this.mesmatricula = mesmatricula;
	}

	public String getDiamatricula() {
		return diamatricula;
	}

	public void setDiamatricula(String diamatricula) {
		this.diamatricula = diamatricula;
	}

	public int getPolo() {
		return polo;
	}

	public void setPolo(int polo) {
		this.polo = polo;
	}

	public int getPantalon() {
		return pantalon;
	}

	public void setPantalon(int pantalon) {
		this.pantalon = pantalon;
	}

	public int getCasaca() {
		return casaca;
	}

	public void setCasaca(int casaca) {
		this.casaca = casaca;
	}

	public int getBuzo() {
		return buzo;
	}

	public void setBuzo(int buzo) {
		this.buzo = buzo;
	}

	public int getMedias() {
		return medias;
	}

	public void setMedias(int medias) {
		this.medias = medias;
	}

	public int getBotines() {
		return botines;
	}

	public void setBotines(int botines) {
		this.botines = botines;
	}
	

}
