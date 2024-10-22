package Q8;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // Criar um usuário com suas contas
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();

        System.out.print("Digite uma senha (mínimo 7 caracteres, incluindo letras e números): ");
        String senha = scanner.next();
        
        Usuario usuario = null;

        try {
            usuario = new Usuario(nome, senha);
        } catch (SenhaInvalidaException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        boolean continuar = true;

        // Autenticação do usuário
        System.out.print("Digite seu nome para autenticar: ");
        String nomeAutenticacao = scanner.next();
        System.out.print("Digite sua senha para autenticar: ");
        String senhaAutenticacao = scanner.next();

        if (usuario.autenticar(nomeAutenticacao, senhaAutenticacao)) {
            System.out.println("Autenticação realizada com sucesso!");

            while (continuar) {
                System.out.println("\nEscolha uma opção:");
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
                            usuario.getContaCorrente().depositar(valorCC);
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
                            usuario.getContaPoupanca().depositar(valorCP);
                            System.out.println("Depósito de " + df.format(valorCP) + " realizado na Conta Poupança.");
                        } catch (InputMismatchException e) {
                            System.out.println("Valor inválido! Insira um número.");
                            scanner.next(); // Limpa o buffer
                        }
                        break;
                    case 3:
                        System.out.println("Seguro de Vida adicionado. Taxa fixa de 42.00 reais.");
                        break;
                    case 4:
                        // Exibe os saldos e tributos com o nome do usuário
                        System.out.println("\n--- Resultados ---");
                        System.out.println("Usuário: " + nomeAutenticacao);
                        System.out.println("Saldo Conta Corrente: R$ " + df.format(usuario.getContaCorrente().obterSaldo()));
                        System.out.println("Tributos Conta Corrente: R$ " + df.format(usuario.getContaCorrente().calculaTributos()));
                        System.out.println("Saldo Conta Poupança: R$ " + df.format(usuario.getContaPoupanca().obterSaldo()));
                        System.out.println("Tributos Seguro de Vida: R$ " + df.format(new SeguroDeVida().calculaTributos()));
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
        } else {
            // Se as credenciais não corresponderem
            System.out.println("Nome ou senha incorretos. Encerrando o programa.");
        }

        scanner.close();
    }
}
