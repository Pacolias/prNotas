package notas;

import java.util.ArrayList;

public interface CalculoMedia {

	double calcular(ArrayList<Alumno> alumnos) throws AlumnoException;
}
