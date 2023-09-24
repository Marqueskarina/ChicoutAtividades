import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria o arquivo "registros.dat" se ele não existir
        criarArquivoSeNaoExistir();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Listar registros");
            System.out.println("2. Adicionar registro");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    listarRegistros();
                    break;
                case 2:
                    adicionarRegistro(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarArquivoSeNaoExistir() {
        // Verifica se o arquivo "registros.txt" não existe e, se não existir, cria-o.
        File arquivo = new File("C:\\Users\\Terci\\Downloads\\registros.txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

    private static void listarRegistros() {
        try (DataInputStream input = new DataInputStream(new FileInputStream("C:\\Users\\Terci\\Downloads\\registros.txt"))) {
            // Lê os registros do arquivo e os exibe no console
            while (input.available() > 0) {
                int id = input.readInt();
                String nome = input.readUTF();
                double salario = input.readDouble();
                System.out.println("ID: " + id + ", Nome: " + nome + ", Salário: " + salario);
            }
        } catch (IOException e) {
            System.err.println("Erro ao listar registros: " + e.getMessage());
        }
    }

    private static void adicionarRegistro(Scanner scanner) {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("C:\\Users\\Terci\\Downloads\\registros.txt", true))) {
            // Solicita informações do novo registro e as escreve no arquivo
            System.out.print("Informe o ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            System.out.print("Informe o Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Informe o Salário: ");
            double salario = scanner.nextDouble();

            output.writeInt(id);
            output.writeUTF(nome);
            output.writeDouble(salario);

            System.out.println("Registro adicionado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao adicionar registro: " + e.getMessage());
        }
    }
}