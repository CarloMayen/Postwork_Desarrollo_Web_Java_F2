package org.bedu.java.backend.Postwork_S4;

import org.bedu.java.backend.Postwork_S4.modelo.Persona;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PostworkS4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PostworkS4Application.class, args);
	}
	/**
	 * @author Edgar Grcia Aguilar
	 */


	@Override
	public void run(String... args) throws Exception {
		Scanner reader = new Scanner(System.in);

		System.out.print("Introduce el nombre: ");
		String nombre = reader.nextLine();

		System.out.print("Introduce el teléfono: ");
		String telefono = reader.nextLine();

		Persona persona = new Persona(nombre, telefono);

		System.out.println(persona);
	}
}
