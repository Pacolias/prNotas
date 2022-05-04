package notas;

public class Alumno {

	private String dni;
	private String nombre;
	private double nota;

	public Alumno(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		nota = 0;
	}

	public Alumno(String dni, String nombre, double nota) throws AlumnoException {
		if (nota < 0)
			throw new AlumnoException("Calificacion negativa");

		this.dni = dni;
		this.nombre = nombre;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getCalificacion() {
		return nota;
	}

	@Override
	public String toString() {
		return getNombre() + " " + getDni();
	}


	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Alumno) {
			Alumno a = (Alumno) o;
			res = (a.nombre.equals(this.nombre)) && (a.dni.equalsIgnoreCase(this.dni));
		}

		return res;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode() + dni.toUpperCase().hashCode();
	}
}
