package br.edu.uniaeso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class questao32 {
    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:mariadb://localhost:3306/seu_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";

        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita ao usuário o ID do cliente a ser excluído
            System.out.print("Digite o ID do cliente a ser excluído: ");
            int idCliente = scanner.nextInt();

            // Cria a conexão com o banco de dados
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                // Define a consulta SQL para excluir o cliente
                String sql = "DELETE FROM clientes WHERE id = ?";

                // Prepara a declaração SQL
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setInt(1, idCliente);

                    // Executa a consulta de exclusão
                    int rowsDeleted = preparedStatement.executeUpdate();

                    if (rowsDeleted > 0) {
                        System.out.println("Cliente excluído com sucesso!");
                    } else {
                        System.out.println("Nenhum cliente foi excluído. Verifique o ID do cliente.");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados ou executar a exclusão: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Erro de entrada: " + e.getMessage());
        }
    }
}
