import java.io.BufferedReader; // Se usa para leer el archivo de texto
import java.io.FileReader; // Se usa para leer los caracteres dentro del archivo
import java.io.IOException; // Maneja lo del error dentro de un archivo
import java.util.HashMap; // Almacena el valor al igual que la .Map
import java.util.Map;

public class AnalasisTexto {
    public static void main(String[] args) {
        String filename = "prueba.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            String text = content.toString();
            int wordCount = text.split("\\s+").length;
            int sentenceCount = text.split("[.!?]+").length;
            String mostFrequentWord = findMostFrequentWord(text); // Metodo propio de Java que calcula la palabra mas repetida
            double avgWordLength = calculateAverageWordLength(text); // Metodo propio de java que calcula la longitud

            System.out.println("Número total de palabras: " + wordCount);
            System.out.println("Número total de oraciones: " + sentenceCount);
            System.out.println("Palabra más frecuente: " + mostFrequentWord);
            System.out.println("Longitud promedio de las palabras: " + avgWordLength);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static String findMostFrequentWord(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        return wordFreq.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    private static double calculateAverageWordLength(String text) {
        String[] words = text.split("\\s+");
        int totalLength = 0;
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            totalLength += word.length();
        }
        return (double) totalLength / words.length;
    }
}
