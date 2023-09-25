/*Este código Java realiza a leitura de um arquivo CSV (Comma-Separated Values) e exibe seu conteúdo no console. Aqui está uma explicação simplificada do que o código faz:
Abertura do arquivo: O código tenta abrir o arquivo "C:\Users\jhona\Downloads\Dados.csv" usando um objeto FileInputStream. Se o arquivo não for encontrado, ele imprime "Arquivo 
não encontrado !!".
Preparação para leitura: O código utiliza um objeto StringBuilder chamado currentField para construir o conteúdo do campo atual enquanto lê os caracteres do arquivo. A variável i é 
usada para armazenar o valor do caractere lido.
Leitura e separação dos campos:
O programa entra em um loop do-while que continua até o final do arquivo (verifica se i é diferente de -1).
A cada iteração do loop, ele lê um caractere da entrada usando fi.read() e armazena o valor na variável i.
O programa verifica se o caractere é uma vírgula (,), uma quebra de linha (\n) ou um retorno de carro (\r).
Se o caractere for uma vírgula, o código imprime o conteúdo do campo atual no console, seguido por um espaço, e reinicializa o currentField para construir o próximo campo.
Se o caractere for uma quebra de linha ou retorno de carro, o código imprime o conteúdo do campo atual no console e reinicializa o currentField para começar a construir o próximo
campo na próxima linha.
*/
package br.edu.uniaeso.chicoatv.br;
import java.io.*;

public class questao6 {
    public static void main(String[] args) {
        InputStream fi = null;
        int i = -1;
        try {
            fi = new FileInputStream("C:\\Users\\jhona\\Downloads\\Dados.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado !!");
        }

        StringBuilder currentField = new StringBuilder();

        do {
            try {
                i = fi.read();
            } catch (IOException e) {
                System.out.println("Arquivo não pode ser lido !!");
            }

            if (i != -1) {
                char c = (char) i;

                if (c == ',') {
                    System.out.print(currentField.toString() + " ");
                    currentField.setLength(0);
                } else if (c == '\n' || c == '\r') {
                    System.out.println(currentField.toString());
                    currentField.setLength(0);
                } else {
                    currentField.append(c);
                }
            }
        } while (i != -1);
    }
}
