package br.edu.uniaeso;
// Importa as classes necessárias para o código.
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(int id, String nome, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void atualizarCliente(String novoEndereco, String novoTelefone) {
        this.endereco = novoEndereco;
        this.telefone = novoTelefone;
    }
}

public class AtualizacaoClientes {
    public static Cliente buscarClientePorId(List<Cliente> clientes, int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;  // Retorna null se o cliente não for encontrado
    }

    public static void main(String[] args) {
        String arquivoCSV = "clientes.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            List<String[]> linhas = reader.readAll();
            List<Cliente> clientes = new ArrayList<>();

            // Ignorando o cabeçalho
            for (int i = 1; i < linhas.size(); i++) {
                String[] linha = linhas.get(i);
                int id = Integer.parseInt(linha[0]);
                String nome = linha[1];
                String endereco = linha[2];
                String telefone = linha[3];
                clientes.add(new Cliente(id, nome, endereco, telefone));
            }

            // Simulando uma busca pelo cliente (você pode obter o ID do usuário)
            int idClienteParaAtualizar = 1;  // ID do cliente a ser atualizado (simulação)

            // Buscar cliente pelo ID
            Cliente clienteEncontrado = buscarClientePorId(clientes, idClienteParaAtualizar);

            // Atualizando as informações do cliente (simulação - você pode obter os novos dados do usuário)
            if (clienteEncontrado != null) {
                clienteEncontrado.atualizarCliente("Novo Endereco", "Novo Telefone");
            }

            // Salvando as atualizações no arquivo CSV
            try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
                // Escreve o cabeçalho
                writer.writeNext(new String[]{"ID", "Nome", "Endereco", "Telefone"});

                // Escreve os clientes atualizados
                for (Cliente cliente : clientes) {
                    writer.writeNext(new String[]{
                            String.valueOf(cliente.getId()),
                            cliente.getNome(),
                            cliente.getEndereco(),
                            cliente.getTelefone()
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

