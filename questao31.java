package br.edu.uniaeso.questao31;

public class Main {
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.Scanner;
    
    public class ConsultaPedidosPorCliente {
        public static void main(String[] args) {
            // Configuração de conexão com o banco de dados
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados"; // Altere para a URL do seu banco de dados
            String usuario = "seu_usuario"; // Altere para o nome de usuário do seu banco de dados
            String senha = "sua_senha"; // Altere para a senha do seu banco de dados
    
            try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID do cliente: ");
                int idCliente = scanner.nextInt();
    
                // Consulta SQL para recuperar os pedidos do cliente específico
                String consultaSQL = "SELECT * FROM pedidos WHERE id_cliente = ?";
                
                // Preparando a consulta SQL com um PreparedStatement
                PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL);
                preparedStatement.setInt(1, idCliente); // Define o valor do parâmetro ID do cliente
                
                // Executa a consulta
                ResultSet resultSet = preparedStatement.executeQuery();
    
                // Exibe os resultados no console
                while (resultSet.next()) {
                    int idPedido = resultSet.getInt("id_pedido");
                    String descricao = resultSet.getString("descricao");
                    double valorTotal = resultSet.getDouble("valor_total");
                    System.out.println("ID do Pedido: " + idPedido);
                    System.out.println("Descrição: " + descricao);
                    System.out.println("Valor Total: " + valorTotal);
                    System.out.println("---------------------------------");
                }
    
                // Fecha os recursos
                resultSet.close();
                preparedStatement.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}