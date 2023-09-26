import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContadorDePalavras {
    public static void main(String[] args) {
        String nomeArquivo = "meuarquivo.txt";
        String palavraAlvo = "Java";
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Divida a linha em palavras usando espaços como delimitador
                String[] palavras = linha.split(" ");

                // Itere pelas palavras e conte quantas vezes "Java" aparece
                for (String palavra : palavras) {
                    if (palavra.equalsIgnoreCase(palavraAlvo)) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("A palavra 'Java' aparece " + contador + " vezes no arquivo.");
    }
}
