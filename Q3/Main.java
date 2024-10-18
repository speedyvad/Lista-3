package Q3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        SeguroDeVida sv = new SeguroDeVida();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Depositar em Conta Corrente");
            System.out.println("2. Depositar em Conta Poupança");
            System.out.println("3. Adicionar Seguro de Vida");
            System.out.println("4. Calcular Tributos e Saldos");
            System.out.println("5. Sair");

            int opcao = 0;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, insira um número.");
                scanner.next(); // Limpa o buffer
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        System.out.print("Digite o valor para depositar na Conta Corrente: ");
                        double valorCC = scanner.nextDouble();
                        cc.depositar(valorCC);
                        System.out.println("Depósito de " + df.format(valorCC) + " realizado na Conta Corrente.");
                    } catch (InputMismatchException e) {
                        System.out.println("Valor inválido! Insira um número.");
                        scanner.next(); // Limpa o buffer
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Digite o valor para depositar na Conta Poupança: ");
                        double valorCP = scanner.nextDouble();
                        cp.depositar(valorCP);
                        System.out.println("Depósito de " + df.format(valorCP) + " realizado na Conta Poupança.");
                    } catch (InputMismatchException e) {
                        System.out.println("Valor inválido! Insira um número.");
                        scanner.next(); // Limpa o buffer
                    }
                    break;
                case 3:
                    System.out.println("Seguro de Vida adicionado. Taxa fixa de 42.00 reais.");
                    // Não há necessidade de adicionar valor ao seguro, já que é uma taxa fixa
                    break;
                case 4:
                    // Exibe os saldos e tributos
                    System.out.println("\n--- Resultados ---");
                    System.out.println("Saldo Conta Corrente: R$ " + df.format(cc.obterSaldo()));
                    System.out.println("Tributos Conta Corrente: R$ " + df.format(cc.calculaTributos()));
                    System.out.println("Saldo Conta Poupança: R$ " + df.format(cp.obterSaldo()));
                    System.out.println("Tributos Seguro de Vida: R$ " + df.format(sv.calculaTributos()));
                    System.out.println("\n----------------------");
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

