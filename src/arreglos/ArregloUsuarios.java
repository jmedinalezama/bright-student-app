package arreglos;

import clases.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ArregloUsuarios {

	private ArrayList<Usuario> usuario;
	
	public ArregloUsuarios() {
		usuario = new ArrayList<Usuario>();
		this.cargarUsuarios();
	}
	
	public int tamanioUsuario() {
		return usuario.size();
	}
	
	public void adicionarUsuario(Usuario nuevousuario) {
		usuario.add(nuevousuario);
		this.grabarUsuarios();
	}
	
	public Usuario obtenerUsuario(int pos) {
		return usuario.get(pos);
	}
	
	public Usuario buscarUsuarioPorCodigo(int codigousuario) {
		for(int i = 0; i < this.tamanioUsuario(); i++) {
			if(this.obtenerUsuario(i).getCodigousuario() == codigousuario) {
				return this.obtenerUsuario(i);
			}
		}
		return null;
	}
	
	public Usuario buscarUsuarioPorUserName(String username) {
		for(int i = 0; i < this.tamanioUsuario(); i++) {
			if(this.obtenerUsuario(i).getUsername().equalsIgnoreCase(username)) {
				return this.obtenerUsuario(i);
			}
		}
		return null;
	}
	
	public void modificarUsuario(Usuario usuarioactual, Usuario updateusuario) {
		usuarioactual.setNombreusuario(updateusuario.getNombreusuario());
		usuarioactual.setApellidousuario(updateusuario.getApellidousuario());
		usuarioactual.setCorreousuario(updateusuario.getCorreousuario());
		usuarioactual.setTelefonousuario(updateusuario.getTelefonousuario());
		usuarioactual.setDireccionusuario(updateusuario.getDireccionusuario());
		usuarioactual.setNivelusuario(updateusuario.getNivelusuario());
		usuarioactual.setEstadousuario(updateusuario.getEstadousuario());
		usuarioactual.setUsername(updateusuario.getUsername());
		usuarioactual.setPassword(updateusuario.getPassword());
		usuarioactual.setRegistradopor(updateusuario.getRegistradopor());
		this.grabarUsuarios();
		
	}
	
	public void eliminarUsuario(Usuario eliminarusuario) {
		usuario.remove(eliminarusuario);
		this.grabarUsuarios();
	}
	
	public void grabarUsuarios() {
		try {
			
			PrintWriter archivo;
			String datosusuario;
			Usuario usu;
			archivo = new PrintWriter(new FileWriter("Usuarios.txt"));
			
			for(int i = 0; i < this.tamanioUsuario(); i++) {
				usu = this.obtenerUsuario(i);
				datosusuario = usu.getCodigousuario() + ";" +
							   usu.getNombreusuario() + ";" +
							   usu.getApellidousuario() + ";" +
							   usu.getCorreousuario() + ";" +
							   usu.getTelefonousuario() + ";" +
							   usu.getDireccionusuario() + ";" +
							   usu.getNivelusuario() + ";" +
							   usu.getEstadousuario() + ";" +
							   usu.getUsername() + ";" +
							   usu.getPassword() + ";" +
							   usu.getRegistradopor();
				archivo.println(datosusuario);
 			}
			archivo.close();

		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al grabar usuarios " + ex);
		}
	}
	
	private void cargarUsuarios() {
		try {
			
			BufferedReader archivo;
			String datosusuario;
			String[] dato;
			
			int codigousuario;
			String nombreusuario, apellidousuario, correousuario, telefonousuario,
			direccionusuario, nivelusuario, estadousuario, username, password, registradopor;
			
			archivo = new BufferedReader(new FileReader("Usuarios.txt"));
			
			while((datosusuario = archivo.readLine()) != null) {
				dato = datosusuario.split(";");
				codigousuario = Integer.parseInt(dato[0].trim());
				nombreusuario = dato[1].trim();
				apellidousuario = dato[2].trim();
				correousuario = dato[3].trim();
				telefonousuario = dato[4].trim();
				direccionusuario = dato[5].trim();
				nivelusuario = dato[6].trim();
				estadousuario = dato[7].trim();
				username = dato[8].trim();
				password = dato[9].trim();
				registradopor = dato[10].trim();
				
				Usuario usu = new Usuario(codigousuario,nombreusuario,apellidousuario,correousuario,telefonousuario,
						direccionusuario,nivelusuario,estadousuario,username,password,registradopor);

				this.adicionarUsuario(usu);
			}
			archivo.close();
			
		} catch(Exception ex) {
			//System.out.println("Ha ocurrido un error al cargar usuarios " + ex);
		}
	}
	
	
	//codigo correlativo
	public int codigoCorrelativoUsuario() {
		if(this.tamanioUsuario() == 0) {
			return 1001;
		} else {
			return this.obtenerUsuario(this.tamanioUsuario()-1).getCodigousuario() + 1;
		}
	}
}
