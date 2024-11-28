import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Estoque {
    private Map<String, Integer> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(String nome, int quantidade) {
        produtos.put(nome, produtos.getOrDefault(nome, 0) + quantidade);
        System.out.printf("Produto '%s' adicionado com quantidade: %d\n", nome, quantidade);
    }

    public void removerProduto(String nome, int quantidade) {
        if (produtos.containsKey(nome)) {
            int novaQuantidade = produtos.get(nome) - quantidade;
            if (novaQuantidade > 0) {
                produtos.put(nome, novaQuantidade);
                System.out.printf("Quantidade de '%s' reduzida para: %d\n", nome, novaQuantidade);
            } else {
                produtos.remove(nome);
                System.out.printf("Produto '%s' removido do estoque.\n", nome);
            }
        } else {
            System.out.printf("Produto '%s' não encontrado no estoque.\n", nome);
        }
    }

    public void buscarProduto(String nome) {
        if (produtos.containsKey(nome)) {
            System.out.printf("Produto '%s' tem quantidade: %d\n", nome, produtos.get(nome));
        } else {
            System.out.printf("Produto '%s' não encontrado no estoque.\n", nome);
        }
    }

    public void verEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            System.out.println("Estoque atual:");
            for (Map.Entry<String, Integer> entry : produtos.entrySet()) {
                System.out.printf("Produto: %s | Quantidade: %d\n", entry.getKey(), entry.getValue());
            }
        }
    }

    public void limparEstoque() {
        produtos.clear();
        System.out.println("Estoque limpo!");
    }

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1 - Adicionar produto
                    2 - Remover produto
                    3 - Buscar produto
                    4 - Ver estoque
                    5 - Limpar estoque
                    6 - Sair
                    """);
            String opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite o nome do produto:");
                    String nomeAdicionar = input.nextLine();
                    System.out.println("Digite a quantidade:");
                    int qtdAdicionar = Integer.parseInt(input.nextLine());
                    estoque.adicionarProduto(nomeAdicionar, qtdAdicionar);
                    break;

                case "2":
                    System.out.println("Digite o nome do produto:");
                    String nomeRemover = input.nextLine();
                    System.out.println("Digite a quantidade a remover:");
                    int qtdRemover = Integer.parseInt(input.nextLine());
                    estoque.removerProduto(nomeRemover, qtdRemover);
                    break;

                case "3":
                    System.out.println("Digite o nome do produto:");
                    String nomeBuscar = input.nextLine();
                    estoque.buscarProduto(nomeBuscar);
                    break;

                case "4":
                    estoque.verEstoque();
                    break;

                case "5":
                    estoque.limparEstoque();
                    break;

                case "6":
                    System.out.println("Encerrando o programa...");
                    input.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
