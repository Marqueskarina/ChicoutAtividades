
/*Este código Java lê um arquivo CSV de funcionários no diretório de downloads, usando a biblioteca OpenCSV. Ele pula a 
    primeira linha (cabeçalho) e armazena os dados dos funcionários em uma lista. Em seguida, ele exibe todos os funcionários,
    incluindo seus nomes, cargos e salários. Após isso, ele filtra e exibe apenas os funcionários que têm o cargo "Analista" e 
    um salário mínimo de 5500, baseando-se nos critérios especificados. Se ocorrer algum erro durante a leitura do arquivo, ele 
    será capturado e impresso na saída de erro.
    */

package br.edu.uniaeso.chicoatv.br;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class questao24 {
    public static void main(String[] args) {
        String diretorioDownloads = "C:\\Users\\jhona\\Downloads\\";
        String arquivoCSV = diretorioDownloads + "funcionarios.csv";

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(arquivoCSV)).withSkipLines(1).build()) {
            List<String[]> funcionarios = reader.readAll();

            // Exibindo todos os funcionários
            System.out.println("Todos os funcionários:");
            for (String[] funcionario : funcionarios) {
                System.out.println("Nome: " + funcionario[0] + ", Cargo: " + funcionario[1] + ", Salário: " + funcionario[2]);
            }

            // Filtrando funcionários com base em critérios (exemplo: cargo e salário mínimo)
            String cargoFiltrado = "Analista";
            int salarioMinimo = 5500;

            System.out.println("\nFuncionários filtrados (Cargo: " + cargoFiltrado + ", Salário mínimo: " + salarioMinimo + "):");
            for (String[] funcionario : funcionarios) {
                String nome = funcionario[0];
                String cargo = funcionario[1];
                int salario = Integer.parseInt(funcionario[2]);

                if (cargo.equals(cargoFiltrado) && salario >= salarioMinimo) {
                    System.out.println("Nome: " + nome + ", Cargo: " + cargo + ", Salário: " + salario);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
