import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultarProdutosNoMariaDB {
    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:mariadb://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM produtos";

            // Executa a consulta SQL e obtém um conjunto de resultados
            ResultSet resultSet = statement.executeQuery(sql);

            // Exibe os resultados no console
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Preço: " + preco);
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            System.err.println("Erro de banco de dados: " + e.getMessage());
        }
    }
}
