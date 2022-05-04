package notas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Asignatura {

	private String nombre;
	private ArrayList<String> errores;
	private ArrayList<Alumno> alumnos;

	public Asignatura(String nombre, String[] array) {
		this.nombre = nombre;

		errores = null;
		alumnos = null;

		procesarAlumnos(array);

	}

	public double getCalificacion(Alumno a) throws AlumnoException {
		int indice = -1;

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).equals(a))
				indice = i;
		}

		if (indice == -1)
			throw new AlumnoException("El alumno " + a.toString() + " no se encuentra");

		return alumnos.get(indice).getCalificacion();

	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public ArrayList<String> getErrores() {
		return errores;
	}

	@Override
	public String toString() {
		StringBuilder sb1 = new StringBuilder("[");

		for (int i = 0; i < alumnos.size(); i++) {
			sb1.append(alumnos.get(i).toString());

			if (i < alumnos.size() - 1)
				sb1.append(", ");

		}

		sb1.append("]");

		return nombre + ": { " + sb1 + ", " + errores.toString() + "}";
	}
	
	public double getMedia() throws AlumnoException {
		if (alumnos.size() == 0)
			throw new AlumnoException("No hay alumnos");

		double suma = 0;

		for (Alumno al : alumnos) {
			suma += getCalificacion(al);
		}

		return suma / Double.valueOf(alumnos.size());
	}

	public double getMedia(CalculoMedia c) throws AlumnoException {

		return c.calcular(alumnos);
	}

	private void procesarAlumnos(String[] array) {

		alumnos = new ArrayList<>();
		errores = new ArrayList<>();

		for (String alu : array) {

			try (Scanner sc = new Scanner(alu)) {

				sc.useDelimiter("\\s*[;]\\s*");
				sc.useLocale(Locale.ENGLISH);

				alumnos.add(new Alumno(sc.next(), sc.next(), sc.nextDouble()));

			} catch (InputMismatchException e) {

				errores.add("ERROR. Calificacion no numerica: " + alu);

			} catch (NoSuchElementException e) {

				errores.add("ERROR. Faltan datos: " + alu);

			} catch (AlumnoException e) {

				errores.add("ERROR. Calificacion negativa: " + alu);

			}
		}
	}

}
