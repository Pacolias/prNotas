package notas;

import java.util.ArrayList;

public class MediaArmonica implements CalculoMedia {

	public MediaArmonica() {

	}

	@Override
	public double calcular(ArrayList<Alumno> alumnos) throws AlumnoException {
		double numAlumnos = 0;
		double sumatorioCociente = 0;

		for (Alumno a : alumnos) {
			if (a.getCalificacion() > 0) {
				numAlumnos++;
				sumatorioCociente += 1 / a.getCalificacion();
			}
		}

		if (numAlumnos == 0)
			throw new AlumnoException("No hay alumnos");
		else
			return numAlumnos / sumatorioCociente;
	}

}
