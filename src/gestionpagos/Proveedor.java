package Pendientes2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Gimnasio.MonitorAlumnos;

public class Proveedor {

	public int codigo;
	public String cif;
	public String nombre;
	public String tipo;
	public String direccion;
	public int telefono;
	public int CP;
	public String personacontacto;
	public String email;
	public ArrayList<Proveedor> Proveedores;

	public Proveedor(int codigo, String cif, String nombre, String tipo, String direccion, int telefono, int cP,
			String personacontacto, String email) {
		super();
		this.codigo = codigo;
		this.cif = cif;
		this.nombre = nombre;
		this.tipo = tipo;
		this.direccion = direccion;
		this.telefono = telefono;
		CP = cP;
		this.personacontacto = personacontacto;
		this.email = email;
	}

	public Proveedor(ArrayList<Proveedor> proveedores) {
		super();
		Proveedores = proveedores;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}

	public String getPersonacontacto() {
		return personacontacto;
	}

	public void setPersonacontacto(String personacontacto) {
		this.personacontacto = personacontacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Proveedor> getProveedores() {
		return Proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		Proveedores = proveedores;
	}

	@Override
	public String toString() {
		return "Proveedor [codigo=" + codigo + ", cif=" + cif + ", nombre=" + nombre + ", tipo=" + tipo + ", direccion="
				+ direccion + ", telefono=" + telefono + ", CP=" + CP + ", personacontacto=" + personacontacto
				+ ", email=" + email + "]";
	}

	public void CargarProveedores(String filename) {
		Proveedores = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero, "Windows-1252");

			// En caso de que queramos saltar la primera linea
			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");

				Proveedores.add(new Proveedor(Integer.parseInt(linea[0]), linea[1], linea[2], linea[3], linea[4],
						Integer.parseInt(linea[5]), Integer.parseInt(linea[6]), linea[7], linea[8]));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void leerProveedores() {
		System.out.println(Proveedores);
	}

	public double TotalTrimestre(ArrayList<Pagos>pagos,int codigo,int trimestre, int año) {
	    double total = 0;
	    for (Pagos pago : pagos) {
	        if (pago.getCodProveedor() == codigo && pago.getTrimestre() == trimestre && pago.getAño() == año) {
	            total += pago.getImporte();
	            
	        }
	        
	    }
	    return total;
	}
	public static void main(String[] args) {
	    Pagos pagos = new Pagos(new ArrayList<>());
	    pagos.cargarPagos("pagos.csv"); // Asegúrate de cargar los pagos correctamente
	    
	    Proveedor proveedor = new Proveedor(new ArrayList<>());
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Selecciona el proveedor con su codigo: ");
	    int codigo=sc.nextInt();
	    System.out.println("Selecciona el trimestre: ");
	    int trimestre=sc.nextInt();
	    System.out.println("Selecciona el año: ");
	    int año=sc.nextInt();
	    
	    double totalTrimestre = proveedor.TotalTrimestre(pagos.getPagos(),codigo, trimestre, año);
	    
	    String nombreproveedor=pagos.obtenerNombreProveedor(codigo);
	    System.out.println("El proveedor " + nombreproveedor+ " pagó en el trimestre "+trimestre+
	    		" del año "+año+ " un total de "+totalTrimestre+ "€");
	}



	public String obtenerNombrePorCodigo(int codigo) {
		for (Proveedor proveedor : Proveedores) {
			if (proveedor.getCodigo() == codigo) {
				return proveedor.getNombre();
			}
		}
		return "Proveedor no encontrado"; // O puedes manejar la situación de no encontrar el proveedor de otra manera
	}

}
