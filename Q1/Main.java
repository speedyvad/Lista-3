package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do usuário
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        // Cria a pessoa e o gerenciador de impostos
        Pessoa pessoa = new Pessoa(nome);
        GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();

        boolean continuar = true;

        // Loop para permitir a adição de múltiplos produtos ou rendas
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Adicionar Renda");
            System.out.println("3. Sair e calcular o total de impostos");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Adicionar Produto
                    System.out.print("Digite o valor do produto: ");
                    double valorProduto = scanner.nextDouble();
                    System.out.print("Digite a alíquota de imposto para o produto (em %): ");
                    double aliquotaProduto = scanner.nextDouble();

                    // Cria o objeto Produto e adiciona ao gerenciador de impostos
                    Produto produto = new Produto(valorProduto, aliquotaProduto);
                    gerenciador.adicionarTributavel(produto);

                    System.out.println("Produto adicionado com sucesso!\n");
                    break;

                case 2: // Adicionar Renda
                    System.out.print("Digite o valor da renda: ");
                    double valorRenda = scanner.nextDouble();
                    System.out.print("Digite a alíquota de imposto para a renda (em %): ");
                    double aliquotaRenda = scanner.nextDouble();

                    // Cria o objeto Renda e adiciona ao gerenciador de impostos
                    Renda renda = new Renda(valorRenda, aliquotaRenda);
                    gerenciador.adicionarTributavel(renda);

                    System.out.println("Renda adicionada com sucesso!\n");
                    break;

                case 3: // Sair do loop e calcular o total de impostos
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        // Exibe o total de impostos acumulado
        System.out.println("===================================");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Total de impostos calculado: " + gerenciador.getTotalImpostos() + " REAIS");
        System.out.println("===================================");

        scanner.close();
    }
}
