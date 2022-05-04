package notas;

import java.util.ArrayList;

public class MediaSinExtremos implements CalculoMedia {

	private double min;
	private double max;

	public MediaSinExtremos(double min, double max) {
		this.min = min;
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	@Override
	public double calcular(ArrayList<Alumno> alumnos) throws AlumnoException {
		double sumaNotas = 0;
		double numAlumnos = 0;

		for (Alumno a : alumnos) {
			if (a.getCalificacion() < getMax() && a.getCalificacion() > getMin()) {
				numAlumnos++;
				sumaNotas += a.getCalificacion();
			}

		}

		if (numAlumnos == 0)
			throw new AlumnoException("No hay alumnos");

		return sumaNotas / numAlumnos;
	}

}
