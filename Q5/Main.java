package Q5;
import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	 public static void main(String[] args) {
	        HashSet<Usuario> usuarios = new HashSet<>();
	        Scanner scanner = new Scanner(System.in);

	        // Adicionando 10 usuários com nome e CPF informados pelo usuário
	        for (int i = 1; i <= 10; i++) {
	            try {
	                System.out.print("Digite o nome do usuário " + i + ": ");
	                String nome = scanner.nextLine().trim();
	                
	                // Validação do nome
	                if (nome.isEmpty() || nome.matches("\\d+") || !nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
	                    // Verifica se o nome está vazio, se contém apenas números ou se contém caracteres não permitidos
	                    throw new IllegalArgumentException("O nome não pode estar vazio, ser somente numérico, ou conter caracteres não alfabéticos.");
	                }

	                System.out.print("Digite o CPF do usuário " + i + " (somente números): ");
	                String cpf = scanner.nextLine().trim();

	                // Validação do CPF
	                if (!cpf.matches("\\d{11}")) {  // Verifica se o CPF tem exatamente 11 dígitos
	                    throw new IllegalArgumentException("O CPF deve conter 11 dígitos numéricos.");
	                }

	                // Adicionando o usuário ao HashSet
	                usuarios.add(new Usuario(nome, cpf));

	            } catch (IllegalArgumentException e) {
	                System.out.println("Erro: " + e.getMessage());  // Mensagem customizada da exceção
	                i--; // Volta o índice para tentar novamente a inserção
	            } catch (Exception e) {
	                System.out.println("Erro inesperado: " + e.getMessage());
	                i--; // Volta o índice para tentar novamente a inserção
	            }
	        }

	        // Estrutura de repetição para continuar pesquisando ou sair do programa
	        while (true) {
	            System.out.println("\nDeseja buscar o usuário por:");
	            System.out.println("1. CPF");
	            System.out.println("2. Nome");
	            System.out.println("3. Sair");
	            
	            try {
	                int escolha = scanner.nextInt();
	                scanner.nextLine(); // Consumir a quebra de linha após o número

	                switch (escolha) {
	                    case 1: // Busca por CPF
	                        System.out.print("Digite o CPF a ser buscado: ");
	                        String cpfBusca = scanner.nextLine().trim();

	                        // Validação do CPF buscado
	                        if (!cpfBusca.matches("\\d{11}")) {
	                            throw new IllegalArgumentException("O CPF deve conter 11 dígitos numéricos.");
	                        }

	                        buscarPorCpf(usuarios, cpfBusca);
	                        break;

	                    case 2: // Busca por Nome
	                        System.out.print("Digite o nome a ser buscado: ");
	                        String nomeBusca = scanner.nextLine().trim();
	                        
	                        if (nomeBusca.isEmpty()) {
	                            throw new IllegalArgumentException("O nome não pode estar vazio.");
	                        }

	                        buscarPorNome(usuarios, nomeBusca);
	                        break;

	                    case 3: // Opção para sair
	                        System.out.println("Encerrando o programa...");
	                        scanner.close();
	                        return; // Sai do programa

	                    default:
	                        System.out.println("Opção inválida! Escolha entre 1, 2 ou 3.");
	                        break;
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Erro: Entrada inválida. Por favor, insira um número válido.");
	                scanner.nextLine(); // Consumir a entrada inválida
	            } catch (IllegalArgumentException e) {
	                System.out.println("Erro: " + e.getMessage());
	            } catch (Exception e) {
	                System.out.println("Erro inesperado: " + e.getMessage());
	            }
	        }
	    }

	    // Método para buscar usuário por CPF
	    public static void buscarPorCpf(HashSet<Usuario> usuarios, String cpf) {
	        for (Usuario usuario : usuarios) {
	            if (usuario.getCpf().equals(cpf)) {
	                System.out.println("Usuário encontrado: " + usuario);
	                return;
	            }
	        }
	        System.out.println("Nenhum usuário com o CPF " + cpf + " foi encontrado.");
	    }

	    // Método para buscar usuário por Nome
	    public static void buscarPorNome(HashSet<Usuario> usuarios, String nome) {
	        for (Usuario usuario : usuarios) {
	            if (usuario.getNome().equalsIgnoreCase(nome)) { // Comparação ignorando maiúsculas/minúsculas
	                System.out.println("Usuário encontrado: " + usuario);
	                return;
	            }
	        }
	        System.out.println("Nenhum usuário com o nome " + nome + " foi encontrado.");
	    }
	}