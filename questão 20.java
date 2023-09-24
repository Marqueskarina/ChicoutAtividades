package br.edu.uniaeso;

// Importa as classes necessárias para o código, incluindo classes do pacote com.opencsv para leitura de arquivos CSV.
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

class Produto {
    // Atributos da classe Produto
    private String nome;
    private double preco;
    private int quantidade;

    // Construtor da classe Produto
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Métodos para obter os atributos
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Método para representação textual do objeto
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}


  public static void main(String[] args) {
    // Caminho do arquivo CSV
    String arquivoCSV = "produtos.csv";

    try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
        List<String[]> linhas = reader.readAll();

        // Ignorando o cabeçalho e processando as linhas do arquivo CSV
        for (int i = 1; i < linhas.size(); i++) {
            String[] linha = linhas.get(i);

            // Obtendo os dados da linha e criando um objeto Produto
            String nome = linha[0];
            double preco = Double.parseDouble(linha[1]);
            int quantidade = Integer.parseInt(linha[2]);

            Produto produto = new Produto(nome, preco, quantidade);
            System.out.println(produto);
        }
    } catch (IOException | CsvException e) {
        // Tratamento de exceções
        e.printStackTrace();
    }
}
