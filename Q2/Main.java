package Q2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vetor para armazenar as formas
        AreaCalculavel[] formas = new AreaCalculavel[100];  // Aumentamos o tamanho para 100, para acomodar mais entradas
        int index = 0;  // Índice para controlar a quantidade de formas no vetor

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Escolha a forma geométrica para calcular a área:");
                System.out.println("1. Quadrado");
                System.out.println("2. Retângulo");
                System.out.println("3. Círculo");
                System.out.println("4. Sair");

                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:  // Quadrado
                        System.out.print("Digite o valor do lado do quadrado: ");
                        double lado = scanner.nextDouble();
                        if (lado <= 0) throw new IllegalArgumentException("O lado deve ser maior que 0.");
                        formas[index] = new Quadrado(lado);
                        index++;
                        break;
                    case 2:  // Retângulo
                        System.out.print("Digite o valor da base do retângulo: ");
                        double base = scanner.nextDouble();
                        if (base <= 0) throw new IllegalArgumentException("A base deve ser maior que 0.");
                        System.out.print("Digite o valor da altura do retângulo: ");
                        double altura = scanner.nextDouble();
                        if (altura <= 0) throw new IllegalArgumentException("A altura deve ser maior que 0.");
                        formas[index] = new Retangulo(base, altura);
                        index++;
                        break;
                    case 3:  // Círculo
                        System.out.print("Digite o valor do raio do círculo: ");
                        double raio = scanner.nextDouble();
                        if (raio <= 0) throw new IllegalArgumentException("O raio deve ser maior que 0.");
                        formas[index] = new Circulo(raio);
                        index++;
                        break;
                    case 4:  // Sair
                        continuar = false;
                        break;
                    default:
                        System.out.println("Escolha inválida! Por favor, escolha uma opção entre 1 e 4.");
                }
            } catch (InputMismatchException e) {
                // Caso o usuário digite algo que não é um número esperado
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next();  // Limpa o scanner para continuar a leitura
            } catch (IllegalArgumentException e) {
                // Trata entradas de valores negativos ou inválidos
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                // Tratamento genérico para qualquer outro tipo de exceção inesperada
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }

        // Exibindo as áreas calculadas
        System.out.println("\nÁreas calculadas:");
        for (int i = 0; i < index; i++) {
            if (formas[i] instanceof Quadrado) {
                System.out.println("Área do Quadrado " + (i + 1) + " = " + formas[i].calculaArea());
            } else if (formas[i] instanceof Retangulo) {
                System.out.println("Área do Retângulo " + (i + 1) + " = " + formas[i].calculaArea());
            } else if (formas[i] instanceof Circulo) {
                System.out.println("Área do Círculo " + (i + 1) + " = " + formas[i].calculaArea());
            }
        }

        scanner.close();
    }
}
