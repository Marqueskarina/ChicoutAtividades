package br.edu.uniaeso;
// Importa a classe necessária para o código.
import java.io.*;

// Classe Pessoa que será serializada
class Pessoa implements Serializable {
    private String nome;
    private int idade;

    // Construtor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Métodos para obter nome e idade
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class Serializacao {
    public static void main(String[] args) {
        // Criando um objeto da classe Pessoa
        Pessoa pessoa = new Pessoa("Joicy", 32);

        // Nome do arquivo onde será armazenada a serialização
        String nomeArquivo = "pessoa.dat";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            // Serializa o objeto e escreve no arquivo
            oos.writeObject(pessoa);
            System.out.println("Objeto serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            // Caso ocorra falha, trata exceções de IO, como falha na escrita do arquivo
            System.err.println("Ocorreu um erro ao serializar o objeto: " + e.getMessage());
        }
    }
}

