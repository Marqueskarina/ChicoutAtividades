package br.edu.uniaeso.questao13;

public class Main {
    import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Classe que representa um produto
class Produto implements Serializable {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();

        // Criar alguns objetos de Produto
        Produto produto1 = new Produto("Produto 1", 19.99);
        Produto produto2 = new Produto("Produto 2", 29.99);
        Produto produto3 = new Produto("Produto 3", 39.99);

        // Adicionar os produtos à lista
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);

        // Serializar a lista de produtos em um arquivo binário
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
            outputStream.writeObject(listaProdutos);
            System.out.println("Lista de produtos serializada com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desserializar a lista de produtos do arquivo binário
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            List<Produto> listaDesserializada = (List<Produto>) inputStream.readObject();

            // Exibir os produtos no console
            System.out.println("Produtos desserializados:");
            for (Produto produto : listaDesserializada) {
                System.out.println(produto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
}