import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirCliente {
    public static void main(String[] args) {
        // Configurações de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o ID do cliente a ser excluído: ");
            int idCliente = scanner.nextInt();

            // Consulta SQL para excluir o cliente com base no ID
            String sql = "DELETE FROM clientes WHERE id = ?";

            try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
                preparedStatement.setInt(1, idCliente);

                int linhasAfetadas = preparedStatement.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Cliente excluído com sucesso!");
                } else {
                    System.out.println("Nenhum cliente foi excluído. Verifique o ID fornecido.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
