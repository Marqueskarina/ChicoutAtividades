import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirClienteNoMariaDB {
    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:mariadb://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(url, usuario, senha)) {

            System.out.println("Inserir novo cliente:");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();

            // SQL para inserir um novo cliente na tabela "clientes"
            String sql = "INSERT INTO clientes (nome, idade, endereco) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setInt(2, idade);
                preparedStatement.setString(3, endereco);

                int linhasAfetadas = preparedStatement.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Cliente inserido com sucesso!");
                } else {
                    System.out.println("Falha ao inserir o cliente.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
        }
    }
}
