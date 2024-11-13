import java.util.Random;
import java.util.Scanner;
 
public class Advina {
 
	//Palabras fijas para adivinar según nivel
	private static final String[] FACIL = {
			"casa", "misa", "mano", "rata", "mata", "foco", "rana", "pies"
	};
 
	private static final String[] INTERMEDIO = {
		"avenidas", "bizcocho", "caballos", "elefante",
		"langosta", "barbados", "analogos", "angoleña"
	};
 
	private static final String[] AVANZADO = {
			"bachillerato", "cabalisticos", "damnificados",	"dactilograma",
			"quebrantaras",	"objetivacion",	"quebrantaron",	"vacacionista",
			"vagabunderia", "ultrasonicas"
	};
 
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String entrada = "";
 
		while (!entrada.equals("0")) {
			System.out.println("\nElija nivel dificultad...");
			System.out.println("(1) --> Fácil");
			System.out.println("(2) --> Intermedio");
			System.out.println("(3) --> Avanzado");
			System.out.println("(0) --> SALIR");
			System.out.print("Su opción [0-3]: ");
			entrada = teclado.nextLine();
 
			if (!entrada.equals("0")) {
				//Pedimos una palabra en base al nivel de dificultad
				String palabra = obtenerPalabra(entrada);
 
				if (palabra == null) //Si hemos recibido null, es porque la opcion no es válida
					System.out.println("Escoja una opción válida.");
				else {
					String letra = "";
					System.out.print("\nIntroduce la letra: ");
					letra = teclado.nextLine().toLowerCase();
					while (!letra.equals("0")) {
						if (palabra.contains(letra)) {
							//Mostramos palabra pero solo enseñando la letra coincidente
							System.out.println("\nEsa letra SI existe en la palabra:");
							for (int i = 0; i < palabra.length(); i++) {
								if (palabra.charAt(i) == letra.charAt(0)) //Es la letra coincidente
									System.out.print(palabra.charAt(i));
								else //No es la letra, tapamos con asterisco
									System.out.print('*');
							}
						}
						else
							System.out.println("Intentalo de nuevo !!");
 
						System.out.print("\nIntroduce la letra: ");
						letra = teclado.nextLine();
					}
				}
			}
		}
		System.out.println("\n\nFIN DEL PROGRAMA");
		teclado.close();
 
	}
 
	/**
	 * Proporciona una palabra al azar de uno de los arrays de palabras
	 * prefijadas, según el nivel de dificultad indicado.
	 * @param nivel Valor del nivel de dificultad
	 * @return Palabra al azar o valor null si el valor de nivel no es válido.
	 */
	private static String obtenerPalabra(String nivel) {
		Random azar = new Random();
		switch(nivel) {
		case "1":
			return FACIL[azar.nextInt(FACIL.length)];
		case "2":
			return INTERMEDIO[azar.nextInt(INTERMEDIO.length)];
		case "3":
			return AVANZADO[azar.nextInt(AVANZADO.length)];
		default:
			return null;
 
		}
	}
 
}