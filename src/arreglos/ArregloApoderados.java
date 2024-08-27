package arreglos;

import clases.Apoderado;

import java.io.*;
import java.util.ArrayList;

public class ArregloApoderados {
	
	private ArrayList<Apoderado> apoderado;
	
	public ArregloApoderados() {
		apoderado = new ArrayList<Apoderado>();
		this.cargarApoderados();
	}
	
	public int tamanioApoderado() {
		return apoderado.size();
	}
	
	public void adicionarApoderado(Apoderado nuevoapoderado) {
		apoderado.add(nuevoapoderado);
		this.grabarApoderados();
	}
	
	public Apoderado obtenerApoderado(int pos) {
		return apoderado.get(pos);
	}
	
	public Apoderado buscarApoderado(int codigoapoderado) {
		for(int i = 0; i < this.tamanioApoderado(); i++) {
			if(this.obtenerApoderado(i).getCodigoapoderado() == codigoapoderado) {
				return this.obtenerApoderado(i);
			}
		}
		return null;
	}
	
	public void modificarApoderado(Apoderado apoderadoactual, Apoderado updateapoderado) {
		apoderadoactual.setNombreapoderado(updateapoderado.getNombreapoderado());
		apoderadoactual.setApellidoapoderado(updateapoderado.getApellidoapoderado());
		apoderadoactual.setDniapoderado(updateapoderado.getDniapoderado());
		apoderadoactual.setDireccionapoderado(updateapoderado.getDireccionapoderado());
		apoderadoactual.setTelefonoapoderado(updateapoderado.getTelefonoapoderado());
		apoderadoactual.setUltimamodificacion(updateapoderado.getUltimamodificacion());
		this.grabarApoderados();
	}
	
	public void eliminarApoderado(Apoderado eliminarapoderado) {
		apoderado.remove(eliminarapoderado);
		this.grabarApoderados();
	}
	
	public void grabarApoderados() {
		try {
			
			PrintWriter archivo;
			String datosapoderado;
			Apoderado apo;
			archivo = new PrintWriter(new FileWriter("Apoderados.txt"));
			
			for(int i = 0; i < this.tamanioApoderado(); i++) {
				apo = this.obtenerApoderado(i);
				datosapoderado = apo.getCodigoapoderado() + ";" +
							   apo.getNombreapoderado() + ";" +
							   apo.getApellidoapoderado() + ";" +
							   apo.getDniapoderado() + ";" +
							   apo.getDireccionapoderado() + ";" +
							   apo.getTelefonoapoderado() + ";" +
							   apo.getUltimamodificacion();
				archivo.println(datosapoderado);
 			}
			archivo.close();

		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al grabar apoderado " + ex);
		}
	}
	
	private void cargarApoderados() {
		try {
			
			BufferedReader archivo;
			String datosapoderado;
			String[] dato;
			
			int codigoapoderado;
			String nombreapoderado, apellidoapoderado, dniapoderado, direccionapoderado, 
			telefonoapoderado, ultimamodificacion;
			
			archivo = new BufferedReader(new FileReader("Apoderados.txt"));
			
			while((datosapoderado = archivo.readLine()) != null) {
				dato = datosapoderado.split(";");
				codigoapoderado = Integer.parseInt(dato[0].trim());
				nombreapoderado = dato[1].trim();
				apellidoapoderado = dato[2].trim();
				dniapoderado = dato[3].trim();
				direccionapoderado = dato[4].trim();
				telefonoapoderado = dato[5].trim();
				ultimamodificacion = dato[6].trim();
				
				Apoderado apo = new Apoderado(codigoapoderado,nombreapoderado,apellidoapoderado,dniapoderado,
						direccionapoderado,telefonoapoderado,ultimamodificacion);

				this.adicionarApoderado(apo);
			}
			archivo.close();
			
		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al cargar apoderados " + ex);
		}
	}
	
	
	//codigo correlativo
	public int codigoCorrelativoApoderado() {
		if(this.tamanioApoderado() == 0) {
			return 2001;
		} else {
			return this.obtenerApoderado(this.tamanioApoderado()-1).getCodigoapoderado()+1;
		}
	}

	
}
