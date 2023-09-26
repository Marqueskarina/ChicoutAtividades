import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LerCSV {
    public static void main(String[] args) {
        String nomeArquivo = "alunos.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(nomeArquivo))) {
            List<String[]> linhas = csvReader.readAll();

            for (String[] linha : linhas) {
                for (String campo : linha) {
                    System.out.print(campo + "\t");
                }
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
