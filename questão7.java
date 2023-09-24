package org.example;  // Declaração do pacote

import java.io.*;
import java.util.*;

public class Main {  // Declaração da classe principal

    public static void main(String[] args) {  // Método principal
        // Nomes dos arquivos de entrada e saída
        String arquivoOriginal = "meuarquivo.txt";
        String arquivoOrdenado = "meuarquivo_ordenado.txt";

        // Lista para armazenar as linhas lidas do arquivo original
        List<String> linhas = new ArrayList<>();

        // Leitura das linhas do arquivo original
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);  // Adiciona cada linha à lista
            }
        } catch (IOException e) {
            // Trata exceções de IO durante a leitura do arquivo
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        Collections.sort(linhas);  // Ordena as linhas em ordem alfabética

        // Escreve as linhas ordenadas no arquivo de saída
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoOrdenado))) {
            for (String linha : linhas) {
                bw.write(linha);  // Escreve cada linha
                bw.newLine();  // Adiciona uma nova linha
            }
        } catch (IOException e) {
            // Trata exceções de IO durante a escrita do arquivo
            System.err.println("Erro ao salvar o arquivo ordenado: " + e.getMessage());
        }

        System.out.println("Arquivo ordenado com sucesso!");  // Mensagem de sucesso
    }
}
