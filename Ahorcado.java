import java.util.Scanner;

public class Ahorcado {
    private static final String[] PALABRAS = {"lenguaje"};
    private static final int max_intentos = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = seleccionarPalabraSecreta();
        char[] progreso = new char[palabraSecreta.length()];
        int intentosRestantes = max_intentos;

        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        while (intentosRestantes > 0) {
            System.out.println("Palabra: " + String.valueOf(progreso));
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().charAt(0);
            boolean letraAdivinada = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    progreso[i] = letra;
                    letraAdivinada = true;
                }
            }
            
            if (String.valueOf(progreso).equals(palabraSecreta)) {
                System.out.println("¡Adivinaste la palabra :D!");
                scanner.close(); 
            }

            if (!letraAdivinada) {
                intentosRestantes--;
                System.out.println("La letra no está en la palabra.");
            }
        }

        System.out.println("Perdiste :( . La palabra secreta era: " + palabraSecreta);
        scanner.close();
    }

    private static String seleccionarPalabraSecreta() {
        return PALABRAS[(int) (Math.random() * PALABRAS.length)];
    }
}
