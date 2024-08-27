package arreglos;

import java.util.ArrayList;
import java.io.*;

import clases.Matricula;

public class ArregloMatriculas {

	private ArrayList<Matricula> matricula;
	
	public ArregloMatriculas() {
		matricula = new ArrayList<Matricula>();
		this.cargarMatriculas();
	}
	
	public int tamanioMatricula() {
		return matricula.size();
	}
	
	public void adicionarMatricula(Matricula nuevamatricula) {
		matricula.add(nuevamatricula);
		this.grabarMatriculas();
	}
	
	public Matricula obtenerMatricula(int pos) {
		return matricula.get(pos);
	}
	
	public Matricula buscarMatricula(int codigomatricula) {
		for(int i = 0; i< this.tamanioMatricula(); i++) {
			if(this.obtenerMatricula(i).getCodigomatricula() == codigomatricula) {
				return this.obtenerMatricula(i);
			}
		}
		return null;
	}
	
	public void modificarMatricula(Matricula matriculaactual, Matricula updatematricula) {
		matriculaactual.setPagomatricula(updatematricula.getPagomatricula());
		matriculaactual.setEstadomatricula(updatematricula.getEstadomatricula());
		matriculaactual.setPolo(updatematricula.getPolo());
		matriculaactual.setPantalon(updatematricula.getPantalon());
		matriculaactual.setCasaca(updatematricula.getCasaca());
		matriculaactual.setBuzo(updatematricula.getBuzo());
		matriculaactual.setMedias(updatematricula.getMedias());
		matriculaactual.setBotines(updatematricula.getBotines());
		this.grabarMatriculas();
	}
	
	public void eliminarMatricula(Matricula eliminarmatricula) {
		matricula.remove(eliminarmatricula);
		this.grabarMatriculas();
	}
	
	
	public void grabarMatriculas() {
		try {
			
			PrintWriter archivo;
			String datosmatricula;
			Matricula mat;
			archivo = new PrintWriter(new FileWriter("Matriculas.txt"));
			
			for(int i = 0; i < this.tamanioMatricula(); i++) {
				mat = this.obtenerMatricula(i);
				datosmatricula = mat.getCodigomatricula() + ";" +
							     mat.getPagomatricula() + ";" +
							     mat.getEstadomatricula() + ";" +
							     mat.getAniomatricula() + ";" +
							     mat.getMesmatricula() + ";" +
							     mat.getDiamatricula() + ";" +
							     mat.getPolo() + ";" +
							     mat.getPantalon() + ";" +
							     mat.getCasaca() + ";" +
							     mat.getBuzo() + ";" +
							     mat.getMedias() + ";" +
							     mat.getBotines();
				
				archivo.println(datosmatricula);
 			}
			archivo.close();

		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al grabar matriculas " + ex);
		}
	}
	
	
	private void cargarMatriculas() {
		try {
			
			BufferedReader archivo;
			String datosmatricula;
			String[] dato;
			
			int codigomatricula;
			String estadomatricula, aniomatricula, mesmatricula, diamatricula;
			double pagomatricula; 
			int polo, pantalon, casaca, buzo, medias, botines;
			
			archivo = new BufferedReader(new FileReader("Matriculas.txt"));
			
			while((datosmatricula = archivo.readLine()) != null) {
				dato = datosmatricula.split(";");
				codigomatricula = Integer.parseInt(dato[0].trim());
				pagomatricula = Double.parseDouble(dato[1].trim());
				estadomatricula = dato[2].trim();
				aniomatricula = dato[3].trim();
				mesmatricula = dato[4].trim();
				diamatricula = dato[5].trim();
				polo = Integer.parseInt(dato[6].trim());
				pantalon = Integer.parseInt(dato[7].trim());
				casaca = Integer.parseInt(dato[8].trim());
				buzo = Integer.parseInt(dato[9].trim());
				medias = Integer.parseInt(dato[10].trim());
				botines = Integer.parseInt(dato[11].trim());
				
				Matricula mat = new Matricula(codigomatricula, pagomatricula, estadomatricula, aniomatricula, 
						mesmatricula, diamatricula, polo, pantalon, casaca, buzo, medias, botines);
		
				this.adicionarMatricula(mat);
			}
			archivo.close();
			
		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al cargar matriculas " + ex);
		}
	}
	
	
	//codigo correlativo
	public int codigoCorrelativoMatricula() {
		if(this.tamanioMatricula() == 0) {
			return 5001;
		} else {
			return this.obtenerMatricula(this.tamanioMatricula()-1).getCodigomatricula()+1;
		}
	}

}
