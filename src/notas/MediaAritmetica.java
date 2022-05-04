package notas;

import java.util.ArrayList;

public class MediaAritmetica implements CalculoMedia {

	public MediaAritmetica() {

	}

	@Override
	public double calcular(ArrayList<Alumno> alumnos) throws AlumnoException {
		if (alumnos.size() == 0)
			throw new AlumnoException("No hay alumnos");

		double suma = 0;

		for (Alumno a : alumnos) {
			suma += a.getCalificacion();
		}

		return suma / alumnos.size();

	}

}
