import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Configuração da conexão
        String jdbcURL = "jdbc:mariadb://*ip*/seu_banco_de_dados"; // URL do banco de dados
        String username = "seu_usuario"; // Nome de usuário
        String password = "sua_senha"; // Senha

        // Tente estabelecer a conexão
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null) {
                System.out.println("Conexão com o banco de dados MariaDB estabelecida com sucesso.");
                // Realize suas operações no banco de dados aqui, se necessário.
                connection.close(); // Feche a conexão quando terminar.
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}