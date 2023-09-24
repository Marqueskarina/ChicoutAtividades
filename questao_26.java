import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (FileWriter fileWriter = new FileWriter("funcionarios.csv");
             CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            // Inicialização de recursos: Abre os arquivos necessários para escrita

            // Solicitar ao usuário detalhes dos funcionários e escrevê-los no arquivo CSV
            while (true) {
                System.out.println("Informe o nome do funcionário (ou digite 'sair' para encerrar):");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("sair")) {
                    break; // Encerra o loop se o usuário digitar 'sair'
                }

                System.out.println("Informe o cargo do funcionário:");
                String cargo = scanner.nextLine();

                System.out.println("Informe o salário do funcionário:");
                String salario = scanner.nextLine();

                // Criar um array de strings com os dados do funcionário
                String[] linhaFuncionario = {nome, cargo, salario};

                // Escrever a linha no arquivo CSV
                csvWriter.writeNext(linhaFuncionario);
            }

            System.out.println("Dados dos funcionários foram escritos no arquivo 'funcionarios.csv'.");
        } catch (IOException e) {
            e.printStackTrace(); // Trata exceções de E/S (entrada/saída) imprimindo o rastreamento de pilha
        }
    }
}