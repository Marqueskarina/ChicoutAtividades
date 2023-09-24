package br.edu.uniaeso;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class questao23 {
    public static void main(String[] args) {
        String csvFile = "produtos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> csvData = reader.readAll();

            // Ignorar o cabeçalho (Nome, Preço, Quantidade)
            csvData.remove(0);

            List<Produto> produtos = new ArrayList<>();

            // Carregar produtos do CSV
            for (String[] row : csvData) {
                String nome = row[0];
                double preco = Double.parseDouble(row[1]);
                int quantidade = Integer.parseInt(row[2]);

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

            // Exibir produtos
            System.out.println("Produtos disponíveis:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }

            // Solicitar ao usuário o nome do produto a ser excluído
            String produtoExcluir = "Smartphone"; // Substitua isso pela entrada do usuário

            // Verificar se o produto existe
            boolean produtoEncontrado = false;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(produtoExcluir)) {
                    produtos.remove(produto);
                    produtoEncontrado = true;
                    break;
                }
            }

            if (produtoEncontrado) {
                // Atualizar o arquivo CSV com os produtos restantes
                try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                    // Adicionar o cabeçalho
                    String[] header = {"Nome", "Preço", "Quantidade"};
                    writer.writeNext(header);

                    // Escrever os produtos restantes no CSV
                    for (Produto produto : produtos) {
                        String[] linhaProduto = {produto.getNome(), String.valueOf(produto.getPreco()), String.valueOf(produto.getQuantidade())};
                        writer.writeNext(linhaProduto);
                    }

                    System.out.println("Produto excluído com sucesso.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}