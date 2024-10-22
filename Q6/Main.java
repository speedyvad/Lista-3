package Q6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConjuntoDePalavras conjunto = new ConjuntoDePalavras();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar uma palavra");
            System.out.println("2. Remover uma palavra");
            System.out.println("3. Ver a lista de palavras");
            System.out.println("4. Encerrar o programa");
            System.out.print("Opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a palavra a ser adicionada: ");
                        String palavraParaAdicionar = scanner.nextLine();
                        conjunto.adicionarPalavra(palavraParaAdicionar);
                        break;
                    case 2:
                        System.out.print("Digite a palavra a ser removida: ");
                        String palavraParaRemover = scanner.nextLine();
                        conjunto.removerPalavra(palavraParaRemover);
                        break;
                    case 3:
                        conjunto.exibirPalavras();
                        break;
                    case 4:
                        continuar = false;
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        }

        scanner.close();
    }
}
