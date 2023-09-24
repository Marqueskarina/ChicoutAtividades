package org.example;  // Declaração do pacote
import java.util.Date;

// Classe que representa uma venda
public class Venda {
    private Date data;       // Data da venda
    private double valor;    // Valor da venda
    private String produto;  // Produto vendido

    // Construtor da classe Venda
    public Venda(Date data, double valor, String produto) {
        this.data = data;
        this.valor = valor;
        this.produto = produto;
    }
}

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe que exporta vendas para um arquivo CSV
public class ExportarVendas {

    public static void main(String[] args) {
        List<String[]> vendas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Adicionar vendas de exemplo à lista
        vendas.add(new String[]{dateFormat.format(new Date()), "150.0", "Produto A"});
        vendas.add(new String[]{dateFormat.format(new Date()), "200.0", "Produto B"});
        vendas.add(new String[]{dateFormat.format(new Date()), "180.0", "Produto C"});

        // Exportar as vendas para um arquivo CSV
        exportarParaCSV(vendas, "vendas.csv");
    }

    // Método para exportar vendas para um arquivo CSV
    private static void exportarParaCSV(List<String[]> vendas, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            // Escreve cada venda no arquivo CSV
            for (String[] venda : vendas) {
                writer.append(String.join(",", venda));
                writer.append("\n");
            }

            System.out.println("Vendas exportadas para " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar as vendas para o arquivo CSV: " + e.getMessage());
        }
    }
}
