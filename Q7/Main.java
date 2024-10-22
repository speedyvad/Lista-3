package Q7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroAluno cadastro = new CadastroAluno();
        boolean continuar = true;

        while (continuar) {
            try {
                // Menu interativo
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar novo Aluno");
                System.out.println("2. Ver lista de Alunos com IRA");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        // Adicionar um novo aluno
                        adicionarAluno(scanner, cadastro);
                        break;
                    case 2:
                        // Ver lista de alunos com IRA
                        System.out.println("\nLista de Alunos com IRA:");
                        cadastro.imprimirAlunos();
                        break;
                    case 3:
                        // Sair do programa
                        continuar = false;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número válido.");
                scanner.nextLine(); // Limpa o buffer de entrada
            }
        }

        scanner.close();
    }

    // Método para adicionar aluno
    private static void adicionarAluno(Scanner scanner, CadastroAluno cadastro) {
        try {
            System.out.println("\nDigite os dados do novo Aluno:");

            // Validação da matrícula (apenas 7 números)
            int matricula;
            while (true) {
                System.out.print("Matrícula (7 dígitos): ");
                String matriculaStr = scanner.nextLine();

                if (matriculaStr.matches("\\d{7}")) { // Regex para garantir 7 dígitos numéricos
                    matricula = Integer.parseInt(matriculaStr);
                    break;
                } else {
                    System.out.println("Erro: A matrícula deve ter exatamente 7 números.");
                }
            }

            // Validação do nome (somente letras)
            String nome;
            while (true) {
                System.out.print("Nome (somente letras): ");
                nome = scanner.nextLine();

                if (nome.matches("[a-zA-Z ]+")) { // Regex para garantir que só tenha letras e espaços
                    break;
                } else {
                    System.out.println("Erro: O nome deve conter apenas letras.");
                }
            }

            System.out.print("Curso: ");
            String curso = scanner.nextLine();

            Aluno aluno = new Aluno(matricula, nome, curso);

            // Adicionando disciplinas ao aluno
            System.out.print("Quantas disciplinas o aluno cursou? ");
            int numDisciplinas = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            for (int j = 0; j < numDisciplinas; j++) {
                System.out.println("Digite os dados da Disciplina " + (j + 1) + ":");

                // Validação do nome da disciplina (somente letras)
                String nomeDisciplina;
                while (true) {
                    System.out.print("Nome da Disciplina (somente letras): ");
                    nomeDisciplina = scanner.nextLine();

                    if (nomeDisciplina.matches("[a-zA-Z ]+")) { // Regex para garantir que só tenha letras e espaços
                        break;
                    } else {
                        System.out.println("Erro: O nome da disciplina deve conter apenas letras.");
                    }
                }

                System.out.print("Nota: ");
                double nota = scanner.nextDouble();
                System.out.print("Créditos: ");
                int creditos = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                Disciplina disciplina = new Disciplina(nomeDisciplina, nota, creditos);
                aluno.adicionarDisciplina(disciplina);
            }

            cadastro.adicionarAluno(aluno);
            System.out.println("Aluno adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada! Certifique-se de inserir corretamente os valores.");
            scanner.nextLine(); // Limpa o buffer de entrada para evitar loop infinito
        }
    }
}

