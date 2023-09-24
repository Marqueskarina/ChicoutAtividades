package org.example;  // Declaração do pacote
import java.io.*;

public class ConcatenarArquivos {

    public static void main(String[] args) {
        // Conteúdo dos arquivos originais
        String conteudoArquivo1 = "Conteúdo do arquivo 1.";
        String conteudoArquivo2 = "Conteúdo do arquivo 2.";

        // Caminhos dos arquivos
        String caminhoArquivo1 = "arquivo1.txt";
        String caminhoArquivo2 = "arquivo2.txt";
        String caminhoArquivoConcatenado = "arquivo_concatenado.txt";

        // Escreve o conteúdo nos arquivos originais
        escreverArquivo(caminhoArquivo1, conteudoArquivo1);
        escreverArquivo(caminhoArquivo2, conteudoArquivo2);

        // Junta o conteúdo dos arquivos
        concatenarArquivos(caminhoArquivo1, caminhoArquivo2, caminhoArquivoConcatenado);

        System.out.println("Arquivos concatenados com sucesso!");
    }

    // Método para escrever o conteúdo em um arquivo
    private static void escreverArquivo(String caminho, String conteudo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
            writer.println(conteudo);
        } catch (IOException e) {
            // Trata exceções de IO ao escrever no arquivo
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    // Método para juntar o conteúdo de dois arquivos em um terceiro arquivo
    private static void concatenarArquivos(String arquivo1, String arquivo2, String arquivoConcatenado) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(arquivo1));
             BufferedReader reader2 = new BufferedReader(new FileReader(arquivo2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoConcatenado))) {

            String linha;

            // Lê e escreve o conteúdo do primeiro arquivo no arquivo concatenado
            while ((linha = reader1.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }

            // Lê e escreve o conteúdo do segundo arquivo no arquivo concatenado
            while ((linha = reader2.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            // Trata exceções de IO ao concatenar os arquivos
            System.err.println("Erro ao concatenar os arquivos: " + e.getMessage());
        }
    }
}
