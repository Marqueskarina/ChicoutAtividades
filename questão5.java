package br.edu.uniaeso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class questao5 
{
    public static void main( String[] args )
    {
      String inputFile = "meuarquivo.txt";
        String outputFile = "meuarquivo_python.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Substitui todas as ocorrências de "Java" por "Python" na linha
                line = line.replaceAll("Java", "Python");
                writer.write(line);
                writer.newLine(); // Adiciona uma quebra de linha após cada linha
            }

            System.out.println("Substituição concluída. O resultado foi salvo em " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}