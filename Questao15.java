package br.edu.uniaeso.chicoatv.br;

import java.io.*;

public class exec2 {
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
