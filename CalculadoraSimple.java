import java.util.Scanner;

public class CalculadoraSimple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión matemática (suma, resta, multiplicación y división de números enteros y decimales):");
        String expresion = scanner.nextLine();

        try {
            double resultado = evaluarExpresion(expresion);
            System.out.println("El resultado es: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Error: La expresión contiene caracteres no válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    public static double evaluarExpresion(String expresion) {
      
        String[] partes = expresion.split("(?=[+-])|(?<=[+-])|(?=\\*)|(?<=\\*)|(?=\\/)|(?<=\\/)");

        double resultado = 0;
        char operador = '+';

        for (String parte : partes) {
            
            parte = parte.trim();
            if (parte.isEmpty()) continue;

            // Verificar el operador
            if (parte.equals("+") || parte.equals("-") || parte.equals("*") || parte.equals("/")) {
                operador = parte.charAt(0);
                continue;
            }

            // Realizar la operación correspondiente
            double valor = Double.parseDouble(parte);
            switch (operador) {
                case '+':
                    resultado += valor;
                    break;
                case '-':
                    resultado -= valor;
                    break;
                case '*':
                    resultado *= valor;
                    break;
                case '/':
                    if (valor == 0) {
                        throw new IllegalArgumentException("División por cero no permitida");
                    }
                    resultado /= valor;
                    break;
            }
        }

        return resultado;
    }
}
