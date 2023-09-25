/* 
Esse código Java faz uma cópia de um arquivo binário. Ele lê o arquivo original "arquivo_grande.bin" e cria 
uma cópia chamada "copia_arquivo_grande.bin" no diretório de downloads. A leitura e escrita são realizadas de 
forma otimizada usando BufferedInputStream e BufferedOutputStream para melhor desempenho. Qualquer erro relacionado
a não encontrar o arquivo ou não poder lê-lo é tratado e impresso na saída correspondente.

    */
package br.edu.uniaeso.chicoatv.br;

import java.io.*;

public class questao15 {
    public static void main(String[] args) {
        String fi = "C:\\Users\\jhona\\Downloads\\";
        String arquivoOrigem = fi + "arquivo_grande.bin";
        String arquivoDestino = fi + "copia_arquivo_grande.bin";

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(arquivoOrigem));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(arquivoDestino))) {

            int byteLido;
            while ((byteLido = inputStream.read()) != -1) {
                outputStream.write(byteLido);
            }

            System.out.println("Arquivo copiado com sucesso.");

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado !!");
        } catch (IOException e) {
            System.out.println("Arquivo não pode ser lido !!");
        }
    }
}
