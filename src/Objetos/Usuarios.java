package Objetos;

public class Usuarios {
	
	String nombre;
	String apellido;
	int telefono;
	String direccion;
	String correo;
	String fecha_nacimiento;
	String contraseña;
	
	public Usuarios(String nombre, String apellido, int telefono, String direccion, String correo,
			String fecha_nacimiento, String contraseña) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.contraseña = contraseña;
	}
	 
}
