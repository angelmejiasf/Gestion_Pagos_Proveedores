package Pendientes2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pagos {
	public int codProveedor;
	public String factura;
	public int trimestre;
	public int año;
	public double importe;
	public ArrayList<Pagos> Pagos;

	public Pagos(int codProveedor, String factura, int trimestre, int año, double d) {
		super();
		this.codProveedor = codProveedor;
		this.factura = factura;
		this.trimestre = trimestre;
		this.año = año;
		this.importe = d;
	}

	public Pagos(ArrayList<Pagos> Pagos) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Pagos> getPagos() {
		return Pagos;
	}

	public void setPagos(ArrayList<Pagos> pagos) {
		Pagos = pagos;
	}

	public int getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public int getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(int trimestre) {
		this.trimestre = trimestre;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		String nombreproveedor=obtenerNombreProveedor(codProveedor);
		return "Pagos [Proveedor=" + nombreproveedor + ", factura=" + factura + ", trimestre=" + trimestre + ", año="
				+ año + ", importe=" + importe + "]";
	}

	public void cargarPagos(String filename) {
		Pagos = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero, "Windows-1252");

			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");
				String importeString = linea[4].replace(",", ".");
				Pagos.add(new Pagos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]),
						Integer.parseInt(linea[3]), Double.parseDouble(importeString)));

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	public void cargarInformesIVA(String filename,int año,int trimestre) {
		Pagos = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero, "Windows-1252");

			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");
				String importeString = linea[4].replace(",", ".");
				
				if(Integer.parseInt(linea[3]) == año && Integer.parseInt(linea[2]) == trimestre) {
					Pagos.add(new Pagos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]),
						Integer.parseInt(linea[3]), Double.parseDouble(importeString)));
					
					
				}
				

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	
	
	


	public void cargarPagosanuales(String filename,int año) {
		Pagos = new ArrayList<>();
		File fichero = new File(filename);
		try {
			String cadena = "";
			String[] linea;
			Scanner entrada = new Scanner(fichero, "Windows-1252");

			cadena = entrada.nextLine();
			while (entrada.hasNext()) {
				cadena = entrada.nextLine();

				linea = cadena.split(";");
				String importeString = linea[4].replace(",", ".");
				
				if(Integer.parseInt(linea[3]) == año) {
					Pagos.add(new Pagos(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]),
						Integer.parseInt(linea[3]), Double.parseDouble(importeString)));
					
					
				}
				

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	public void leerPagos() {
		System.out.println(Pagos);
	}
	
	public String obtenerNombreProveedor(int codigoProveedor) {
        Proveedor proveedor = new Proveedor(new ArrayList<>());
        proveedor.CargarProveedores("proveedores.csv");
        return proveedor.obtenerNombrePorCodigo(codigoProveedor);
    }
}
