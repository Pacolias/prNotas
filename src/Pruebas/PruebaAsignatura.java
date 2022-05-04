package Pruebas;

import notas.AlumnoException;
import notas.Alumno;
import notas.Asignatura;
import notas.MediaAritmetica;

public class PruebaAsignatura {

	public static void main(String[] args) throws AlumnoException {
		
		String[] alumnos = {"12455666F;Lopez Perez, Pedro;6.7",
							"33678999D;Merlo Gomez, Isabel;5.8",
							"23555875G;Martinez Herrera, Lucia;9.1"};
		
		Asignatura POO = new Asignatura("POO", alumnos);
				
		System.out.println("Media de las calificaciones de POO: " + POO.getMedia(new MediaAritmetica()));

		
		for(Alumno al : POO.getAlumnos())
		{
			System.out.println(al.getDni());
		}
		
		System.out.println(POO.getCalificacion(new Alumno("12455666F", "Lopez Perez, Pedro")));
		
	}
}
