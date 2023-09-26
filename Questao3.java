package com.exerciciosChicout;
import java.io.*;


public class App {
  public static void main(String[] args) {
    CriandoArquivo("C:\\Users\\Joana\\Desktop\\java\\arquivos\\texto.txt");
    escrevendoArquivo("C:\\Users\\Joana\\Desktop\\java\\arquivos\\texto.txt","OLÁ MUNDO!");
    lerArquivo("C:\\Users\\Joana\\Desktop\\java\\arquivos\\texto.txt");
    escrevendoArquivo("C:\\Users\\Joana\\Desktop\\java\\arquivos\\texto.txt","Isso é uma adição!");
    lerArquivo("C:\\Users\\Joana\\Desktop\\java\\arquivos\\texto.txt");
  }

  // Método para criar o arquivo
  public static void CriandoArquivo(String destino) {
    File arquivo = new File(destino);

    try {
      if (arquivo.createNewFile())
        System.out.println("Arquivo criado");
      else {
        System.out.println("Este arquivo já existe");

      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao criar o Arquivo " + e.getMessage());
    }
  }

  // Método para escrever no arquivo
  public static void escrevendoArquivo(String destino, String conteudo) {
    BufferedWriter escrever = null;
    try {
      FileWriter fileWriter = new FileWriter(destino, true);
      escrever = new BufferedWriter(fileWriter);
      escrever.write(conteudo);
      escrever.newLine();
    } catch (IOException e) {
      System.out.println("Erro ao tentar escrever");
    } finally {
      if (!(escrever == null)) {
        try {
          escrever.close();
        } catch (IOException e) {
          System.out.println("Erro ao fechar o BufferWriter" + e.getMessage());
        }
      }
    }
  }
  //função para ler o aquivo
  public static void lerArquivo (String destino){
    BufferedReader ler = null;
    try{
      FileReader fileReader = new FileReader(destino);
      ler = new BufferedReader(fileReader);
      String linha;
      while((linha = ler.readLine()) != null){
        System.out.println(linha);
      }
    }catch(IOException e){
      System.out.println("Erro ao tentar ler o arquivo" + e.getMessage());
    }finally{
      if(!(ler == null)){
        try{
          ler.close();
        }catch(IOException e){
          System.out.println("Erro ao tentar fechar o BufferedReader");
        }
      }
    }
  }
}
