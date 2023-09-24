mport java.io.*;

public class Main {
    public static void main(String[] args) {
        String arquivoEntrada = "C:\\Users\\Terci\\Downloads\\meuarquivo.txt"; // Caminho do arquivo de entrada
        String arquivoSaida = "C:\\Users\\Terci\\Downloads\\meuarquivo_sem_excluir.txt"; // Caminho do arquivo de saída

        try {
            // Abre o arquivo de entrada para leitura
            FileReader leitor = new FileReader(arquivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(leitor);

            // Abre o arquivo de saída para escrita
            FileWriter escritor = new FileWriter(arquivoSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(escritor);

            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                // Verifica se a linha contém a palavra "excluir"
                if (!linha.contains("excluir")) {
                    // Se não contiver, escreve a linha no arquivo de saída
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine(); // Adiciona uma nova linha após cada linha escrita
                }
            }

            // Fecha os arquivos
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Linhas contendo 'excluir' removidas com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}