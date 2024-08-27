package arreglos;

import clases.FichaJugador;

import java.io.*;
import java.util.ArrayList;

public class ArregloFicha {
	
	private ArrayList<FichaJugador> ficha;
	
	public ArregloFicha() {
		ficha = new ArrayList<FichaJugador>();
		this.cargarFichas();
	}
	
	public int tamanioFicha() {
		return ficha.size();
	}
	
	public void adicionarFicha(FichaJugador nuevaficha) {
		ficha.add(nuevaficha);
		this.grabarFichas();
	}
	
	public FichaJugador obtenerFicha(int pos) {
		return ficha.get(pos);
	}
	
	public FichaJugador buscarFicha(int codigoficha) {
		for(int i = 0; i < this.tamanioFicha(); i++) {
			if(this.obtenerFicha(i).getCodigoficha() == codigoficha) {
				return this.obtenerFicha(i);
			}
		}
		return null;
	}
	
	public void modificarFicha(FichaJugador fichaactual, FichaJugador updateficha) {
		fichaactual.setCategoria(updateficha.getCategoria());
		fichaactual.setPiernahabil(updateficha.getPiernahabil());
		fichaactual.setPosicion(updateficha.getPosicion());
		fichaactual.setControlbalon(updateficha.getControlbalon());
		fichaactual.setConduccion(updateficha.getConduccion());
		fichaactual.setVision(updateficha.getVision());
		fichaactual.setCabeceo(updateficha.getCabeceo());
		fichaactual.setDribling(updateficha.getDribling());
		fichaactual.setCambioderitmo(updateficha.getCambioderitmo());
		fichaactual.setDefinicion(updateficha.getDefinicion());
		fichaactual.setPenal(updateficha.getPenal());
		fichaactual.setTirolibre(updateficha.getTirolibre());
		fichaactual.setResistencia(updateficha.getResistencia());
		fichaactual.setPotencia(updateficha.getPotencia());
		fichaactual.setFlexibilidad(updateficha.getFlexibilidad());
		fichaactual.setVelocidad(updateficha.getVelocidad());
		fichaactual.setUltimamodificacion(updateficha.getUltimamodificacion());
		this.grabarFichas();
		
	}
	
	public void eliminarFicha(FichaJugador eliminarficha) {
		ficha.remove(eliminarficha);
		this.grabarFichas();
	}
	
	public void grabarFichas() {
		try {
			
			PrintWriter archivo;
			String datosficha;
			FichaJugador fi_jug;
			archivo = new PrintWriter(new FileWriter("Fichas.txt"));
			
			for(int i = 0; i < this.tamanioFicha(); i++) {
				fi_jug = this.obtenerFicha(i);
				datosficha = fi_jug.getCodigoficha() + ";" +
							 fi_jug.getCategoria() + ";" +
							 fi_jug.getPiernahabil() + ";" +
							 fi_jug.getPosicion() + ";" +
							 fi_jug.getControlbalon() + ";" +
							 fi_jug.getConduccion() + ";" +
							 fi_jug.getVision() + ";" +
							 fi_jug.getCabeceo() + ";" +
							 fi_jug.getDribling() + ";" +
							 fi_jug.getCambioderitmo() + ";" +
							 fi_jug.getDefinicion() + ";" +
							 fi_jug.getPenal() + ";" +
							 fi_jug.getTirolibre() + ";" +
							 fi_jug.getResistencia() + ";" +
							 fi_jug.getPotencia() + ";" +
							 fi_jug.getFlexibilidad() + ";" +
							 fi_jug.getVelocidad() + ";" +
							 fi_jug.getUltimamodificacion();
				
				archivo.println(datosficha);
 			}
			archivo.close();

		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al grabar fichas " + ex);
		}
	}
	
	
	private void cargarFichas() {
		try {
			
			BufferedReader archivo;
			String datosficha;
			String[] dato;
			
			int codigoficha;
			String categoria, piernahabil, posicion;
			int controlbalon, conduccion, vision, cabeceo, dribling, cambioderitmo, definicion, penal;
			int tirolibre, resistencia, potencia, flexibilidad, velocidad;
			String ultimamodificacion;
			
			archivo = new BufferedReader(new FileReader("Fichas.txt"));
			
			while((datosficha = archivo.readLine()) != null) {
				dato = datosficha.split(";");
				codigoficha = Integer.parseInt(dato[0].trim());
				categoria = dato[1].trim();
				piernahabil = dato[2].trim();
				posicion = dato[3].trim();
				controlbalon = Integer.parseInt(dato[4].trim());
				conduccion = Integer.parseInt(dato[5].trim());
				vision = Integer.parseInt(dato[6].trim());
				cabeceo = Integer.parseInt(dato[7].trim());
				dribling = Integer.parseInt(dato[8].trim());
				cambioderitmo = Integer.parseInt(dato[9].trim());
				definicion = Integer.parseInt(dato[10].trim());
				penal = Integer.parseInt(dato[11].trim());
				tirolibre = Integer.parseInt(dato[12].trim());
				resistencia = Integer.parseInt(dato[13].trim());
				potencia = Integer.parseInt(dato[14].trim());
				flexibilidad = Integer.parseInt(dato[15].trim());
				velocidad = Integer.parseInt(dato[16].trim());
				ultimamodificacion = dato[17].trim();
				
				FichaJugador fi_jug = new FichaJugador(codigoficha, categoria, piernahabil, posicion, controlbalon,
						conduccion, vision, cabeceo, dribling, cambioderitmo, definicion, penal, tirolibre,
						resistencia, potencia, flexibilidad, velocidad, ultimamodificacion);
				

				this.adicionarFicha(fi_jug);
			}
			archivo.close();
			
		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al cargar fichas " + ex);
		}
	}
	
	
	//codigo correlativo
	public int codigoCorrelativoFicha() {
		if(this.tamanioFicha() == 0) {
			return 4001;
		} else {
			return this.obtenerFicha(this.tamanioFicha()-1).getCodigoficha()+1;
		}
	}

}
