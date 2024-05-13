package Pendientes2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Contacto {
	
	public String direccion;
	public int telefono;
	public int CP;
	public String nombre;
	public String email;
	
	
	

	public Contacto(String direccion, int telefono, int cP, String nombre, String email) {
		super();
		this.direccion = direccion;
		this.telefono = telefono;
		CP = cP;
		this.nombre = nombre;
		this.email = email;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "El cliente "+nombre+" de la localidad con Codigo Postal "+CP+
				" con correo "+email+" y telefono"+telefono+ " vive en la calle "+direccion;
	}


}
