package Pendientes2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int op = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1)Leer Proveedores");
			System.out.println("2)Leer Pagos");
			System.out.println("3)Generar IVA de un trimestre");
			System.out.println("4)Informe de pagos anuales");

			op = sc.nextInt();

			switch (op) {
			case 1:
				Proveedor prov = new Proveedor(new ArrayList<Proveedor>());
				prov.CargarProveedores("proveedores.csv");
				prov.leerProveedores();
				
				break;
				
			case 2:
				Pagos pagos=new Pagos(new ArrayList<Pagos>());
				pagos.cargarPagos("pagos.csv");
				pagos.leerPagos();
				break;
				
			case 3:
				System.out.println("Introduce el año: ");
				int año=sc.nextInt();
				System.out.println("Introduce el trimestre: ");
				int trimestre=sc.nextInt();
				
				Pagos pagos1=new Pagos(new ArrayList<Pagos>());
				pagos1.cargarInformesIVA("pagos.csv", año, trimestre);
				
				System.out.println("Informe de IVA del trimestre "+ trimestre+ " del año "+año);
				pagos1.leerPagos();
				break;
				
			case 4:
				System.out.println("Introduce el año: ");
				int anio=sc.nextInt();
				Pagos pagos2=new Pagos(new ArrayList<Pagos>());
				pagos2.cargarPagosanuales("pagos.csv", anio);
				
				System.out.println("Informe anual del año "+anio);
				pagos2.leerPagos();
				break;

			}

		} while (true);

	}

}
