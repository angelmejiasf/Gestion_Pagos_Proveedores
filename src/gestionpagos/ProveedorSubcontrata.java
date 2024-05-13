package Pendientes2019;

public class ProveedorSubcontrata extends Proveedor{

	public int personal;

	public ProveedorSubcontrata(int codigo, String cif, String nombre, String tipo, String direccion, int telefono,
			int cP, String personacontacto, String email, int personal) {
		super(codigo, cif, nombre, tipo, direccion, telefono, cP, personacontacto, email);
		this.personal = personal;
	}

	public int getPersonal() {
		return personal;
	}

	public void setPersonal(int personal) {
		this.personal = personal;
	}
	
	
}
