package Q4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando um Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        try {
            // Pergunta ao usuário quantos círculos ele quer criar
            System.out.println("Quantos círculos você quer criar?");
            int numCirculos = scanner.nextInt();

            // Verificando se o número de círculos é válido
            if (numCirculos <= 0) {
                throw new IllegalArgumentException("O número de círculos deve ser maior que zero.");
            }

            // Criando uma lista (coleção) de círculos
            ArrayList<Circulo> listaDeCirculos = new ArrayList<>();

            // Loop para o usuário inserir os raios de cada círculo
            for (int i = 0; i < numCirculos; i++) {
                System.out.println("Digite o valor do raio do círculo " + (i + 1) + ":");
                double raio = scanner.nextDouble();

                // Verifica se o raio é um valor positivo
                if (raio <= 0) {
                    throw new IllegalArgumentException("O raio deve ser maior que zero.");
                }

                listaDeCirculos.add(new Circulo(raio));  // Adiciona um novo círculo na lista
            }

            // Mostrando as áreas de todos os círculos
            System.out.println("Áreas dos círculos:");
            for (int i = 0; i < listaDeCirculos.size(); i++) {
                Circulo circulo = listaDeCirculos.get(i);
                System.out.println("Círculo " + (i + 1) + ": Área = " + circulo.calcularArea());
            }

            // Pergunta ao usuário qual círculo ele quer ver
            System.out.println("Escolha o número do círculo que você deseja visualizar (1 a " + numCirculos + "):");
            int escolha = scanner.nextInt();

            // Verificando se a escolha é válida
            if (escolha > 0 && escolha <= numCirculos) {
                Circulo circuloEscolhido = listaDeCirculos.get(escolha - 1);
                System.out.println("Você escolheu o círculo " + escolha + " com raio " + circuloEscolhido.getRaio() + 
                                   " e área " + circuloEscolhido.calcularArea());
            } else {
                System.out.println("Número de círculo inválido!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Por favor, insira um número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            // Fechando o scanner para evitar vazamento de recursos
            scanner.close();
        }
    }
}
