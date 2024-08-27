package arreglos;

import clases.Jugador;

import java.io.*;
import java.util.ArrayList;

public class ArregloJugador {
	
	private ArrayList<Jugador> jugador;
	
	public ArregloJugador() {
		jugador = new ArrayList<Jugador>();
		this.cargarJugadores();
	}
	
	public int tamanioJugador() {
		return jugador.size();
	}
	
	public void adicionarJugador(Jugador nuevojugador) {
		jugador.add(nuevojugador);
		this.grabarJugadores();
	}
	
	public Jugador obtenerJugador(int pos) {
		return jugador.get(pos);
	}
	
	public Jugador buscarJugadorPorCodigo(int codigojugador) {
		for(int i = 0; i < this.tamanioJugador(); i++) {
			if(this.obtenerJugador(i).getCodigojugador() == codigojugador) {
				return this.obtenerJugador(i);
			}
		}
		return null;
	}
	
	public Jugador buscarJugadorPorCodigoApoderado(int codigoapoderado) {
		for(int i = 0; i < this.tamanioJugador(); i++) {
			if(this.obtenerJugador(i).getCodigoapoderado() == codigoapoderado) {
				return this.obtenerJugador(i);
			}
		}
		return null;
	}
	
	
	public void modificarJugador(Jugador jugadoractual, Jugador updatejugador) {
		jugadoractual.setCodigoapoderado(updatejugador.getCodigoapoderado());
		jugadoractual.setNombrejugador(updatejugador.getNombrejugador());
		jugadoractual.setApellidojugador(updatejugador.getApellidojugador());
		jugadoractual.setDnijugador(updatejugador.getDnijugador());
		jugadoractual.setAnionacimiento(updatejugador.getAnionacimiento());
		jugadoractual.setMesnacimiento(updatejugador.getMesnacimiento());
		jugadoractual.setDianacimiento(updatejugador.getDianacimiento());
		jugadoractual.setEdadjugador(updatejugador.getEdadjugador());
		jugadoractual.setEstaturajugador(updatejugador.getEstaturajugador());
		jugadoractual.setPesojugador(updatejugador.getPesojugador());
		jugadoractual.setDireccionjugador(updatejugador.getDireccionjugador());
		jugadoractual.setTelefonojugador(updatejugador.getTelefonojugador());
		jugadoractual.setUltimamodificacion(updatejugador.getUltimamodificacion());
		this.grabarJugadores();
			
	}
	
	public void eliminarJugador(Jugador eliminarjugador) {
		jugador.remove(eliminarjugador);
		this.grabarJugadores();
	}
	
	public void grabarJugadores() {
		try {
			
			PrintWriter archivo;
			String datosjugador;
			Jugador jug;
			archivo = new PrintWriter(new FileWriter("Jugadores.txt"));
			
			for(int i = 0; i < this.tamanioJugador(); i++) {
				jug = this.obtenerJugador(i);
				datosjugador = jug.getCodigojugador() + ";" +
							   jug.getCodigoapoderado() + ";" +
							   jug.getCodigoficha() + ";" +
							   jug.getCodigomatricula() + ";" +
							   jug.getNombrejugador() + ";" +
							   jug.getApellidojugador() + ";" +
							   jug.getDnijugador() + ";" +
							   jug.getAnionacimiento() + ";" +
							   jug.getMesnacimiento() + ";" +
							   jug.getDianacimiento() + ";" +
							   jug.getEdadjugador() + ";" +
							   jug.getEstaturajugador() + ";" +
							   jug.getPesojugador() + ";" +
							   jug.getDireccionjugador() + ";" +
							   jug.getTelefonojugador() + ";" +
							   jug.getUltimamodificacion();
				archivo.println(datosjugador);
 			}
			archivo.close();

		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al grabar jugadores " + ex);
		}
	}
	
	private void cargarJugadores() {
		try {
			
			BufferedReader archivo;
			String datosjugador;
			String[] dato;
			
			int codigojugador, codigoapoderado, codigoficha, codigomatricula;
			int anionacimiento, mesnacimiento, dianacimiento, edadjugador;
			String nombrejugador, apellidojugador, dnijugador, direccionjugador, telefonojugador, ultimamodificacion;
			double estaturajugador, pesojugador;
			
			archivo = new BufferedReader(new FileReader("Jugadores.txt"));
			
			while((datosjugador = archivo.readLine()) != null) {
				dato = datosjugador.split(";");
				codigojugador = Integer.parseInt(dato[0].trim());
				codigoapoderado = Integer.parseInt(dato[1].trim());
				codigoficha = Integer.parseInt(dato[2].trim());
				codigomatricula = Integer.parseInt(dato[3].trim());
				nombrejugador = dato[4].trim();
				apellidojugador = dato[5].trim();
				dnijugador = dato[6].trim();
				anionacimiento = Integer.parseInt(dato[7].trim());
				mesnacimiento = Integer.parseInt(dato[8].trim());
				dianacimiento = Integer.parseInt(dato[9].trim());
				edadjugador = Integer.parseInt(dato[10].trim());
				estaturajugador = Double.parseDouble(dato[11].trim());
				pesojugador = Double.parseDouble(dato[12].trim());
				direccionjugador = dato[13].trim();
				telefonojugador = dato[14].trim();
				ultimamodificacion = dato[15].trim();
				
				Jugador jug = new Jugador(codigojugador, codigoapoderado, codigoficha, codigomatricula, nombrejugador,
						apellidojugador, dnijugador, anionacimiento, mesnacimiento, dianacimiento, edadjugador,
						estaturajugador, pesojugador, direccionjugador, telefonojugador, ultimamodificacion);

				this.adicionarJugador(jug);;
			}
			archivo.close();
			
		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al cargar jugadores " + ex);
		}
	}
	
	
	
	//codigo correlativo
	public int codigoCorrelativoJugador() {
		if(this.tamanioJugador() == 0) {
			return 3001;
		} else {
			return this.obtenerJugador(this.tamanioJugador()-1).getCodigojugador()+1;
		}
	}
	
}
