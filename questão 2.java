package br.edu.uniaeso;
// Importa as classes necessárias para o código.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LerArquivo {
    public static void main(String[] args) {
        // Nome do arquivo a ser lido
        String nomeArquivo = "meuarquivo.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            // Lê cada linha do arquivo até o final
            while ((linha = reader.readLine()) != null) {
                // Imprime a linha no console
                System.out.println(linha);
            }
        } catch (IOException e) {
            // Caso ocorra falha, trata exceções de IO, como falha na leitura do arquivo
            System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
