package br.edu.uniaeso.questao22;

public class Main {
    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    
    // Classe que representa um produto
    class Produto implements Serializable {
        private String nome;
        private double preco;
        private int estoque;
    
        public Produto(String nome, double preco, int estoque) {
            this.nome = nome;
            this.preco = preco;
            this.estoque = estoque;
        }
    
        public String getNome() {
            return nome;
        }
    
        public double getPreco() {
            return preco;
        }
    
        public int getEstoque() {
            return estoque;
        }
    
        public void setPreco(double preco) {
            this.preco = preco;
        }
    
        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }
    
        @Override
        public String toString() {
            return "Produto{" +
                    "nome='" + nome + '\'' +
                    ", preco=" + preco +
                    ", estoque=" + estoque +
                    '}';
        }
    }
    
    public class AtualizarProdutoCSV {
        public static void main(String[] args) {
            List<Produto> listaProdutos = new ArrayList<>();
    
            // Ler a lista de produtos do arquivo CSV
            try (BufferedReader br = new BufferedReader(new FileReader("produtos.csv"))) {
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] partes = linha.split(",");
                    if (partes.length == 3) {
                        String nome = partes[0].trim();
                        double preco = Double.parseDouble(partes[1].trim());
                        int estoque = Integer.parseInt(partes[2].trim());
                        Produto produto = new Produto(nome, preco, estoque);
                        listaProdutos.add(produto);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o nome do produto que deseja atualizar: ");
            String nomeProduto = scanner.nextLine();
    
            Produto produtoParaAtualizar = null;
    
            // Procurar o produto pelo nome
            for (Produto produto : listaProdutos) {
                if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoParaAtualizar = produto;
                    break;
                }
            }
    
            if (produtoParaAtualizar != null) {
                System.out.println("Produto encontrado:");
                System.out.println(produtoParaAtualizar);
    
                System.out.print("Digite o novo preço: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer
    
                System.out.print("Digite a nova quantidade em estoque: ");
                int novoEstoque = scanner.nextInt();
    
                // Atualizar o preço e a quantidade em estoque do produto
                produtoParaAtualizar.setPreco(novoPreco);
                produtoParaAtualizar.setEstoque(novoEstoque);
    
                // Atualizar o arquivo CSV com os dados atualizados
                try (PrintWriter writer = new PrintWriter(new FileWriter("produtos.csv"))) {
                    for (Produto produto : listaProdutos) {
                        writer.println(produto.getNome() + "," + produto.getPreco() + "," + produto.getEstoque());
                    }
                    System.out.println("Produto atualizado com sucesso.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
    
            scanner.close();
        }
    }
    
}