package br.edu.uniaeso.questao4;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public class ContadorDeLinhas {

    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt"; // Substitua pelo caminho do seu arquivo
        int contadorLinhas = 0; // Inicializa um contador para armazenar o número de linhas

        try {
            // Abrimos o arquivo para leitura
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fileReader);

            String linha; // Declara uma variável para armazenar cada linha lida

            // O loop a seguir lê cada linha do arquivo até que não haja mais linhas a serem lidas
            while ((linha = br.readLine()) != null) {
                contadorLinhas++; // Incrementa o contador a cada linha lida
            }

            // Fechamos o arquivo após a leitura
            br.close();
        } catch (Exception e) { // Captura e lida com exceções, incluindo IOException
            e.printStackTrace(); // Em caso de erro, imprime o erro no console
        }

        // Após a leitura completa do arquivo, exibimos o número de linhas no console
        System.out.println("Número de linhas no arquivo: " + contadorLinhas);
    }
}
}