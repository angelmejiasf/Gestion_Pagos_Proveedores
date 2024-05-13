package Pendientes2019;

public class ProveedorSuminstro extends Proveedor {

	public int retencion;

	public ProveedorSuminstro(int codigo, String cif, String nombre, String tipo, String direccion, int telefono,
			int cP, String personacontacto, String email, int retencion) {
		super(codigo, cif, nombre, tipo, direccion, telefono, cP, personacontacto, email);
		this.retencion = retencion;
	}

	public int getRetencion() {
		return retencion;
	}

	public void setRetencion(int retencion) {
		this.retencion = retencion;
	}
	
	
}
