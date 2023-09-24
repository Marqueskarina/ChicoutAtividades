package org.example; // Declaração do pacote
import java.io.FileInputStream;
import java.io.IOException;

public class LerPrimeirosBytes {

    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";  // Nome do arquivo a ser lido
        int numBytesLidos = 100;  // Número de bytes a serem lidos

        try (FileInputStream fis = new FileInputStream(nomeArquivo)) {
            byte[] buffer = new byte[numBytesLidos];  // Cria um buffer para armazenar os bytes lidos
            int bytesRead = fis.read(buffer, 0, numBytesLidos);  // Lê os bytes do arquivo

            if (bytesRead > 0) {
                // Se foram lidos bytes, imprime os primeiros bytes do arquivo
                System.out.println("Primeiros " + bytesRead + " bytes do arquivo:");
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                }
            } else {
                // Se nenhum byte foi lido, o arquivo está vazio
                System.out.println("O arquivo está vazio.");
            }
        } catch (IOException e) {
            // Trata exceções de IO ao ler o arquivo
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

