package Q6;
import java.util.HashSet;
import java.util.Set;
public class ConjuntoDePalavras {
    private Set<String> conjunto;

    // Construtor que recebe as palavras e as adiciona ao conjunto
    public ConjuntoDePalavras() {
        conjunto = new HashSet<>();
    }

    // Método para adicionar uma palavra ao conjunto
    public void adicionarPalavra(String palavra) {
        conjunto.add(palavra);
        System.out.println("Palavra '" + palavra + "' adicionada ao conjunto.");
    }

    // Método para remover uma palavra do conjunto
    public void removerPalavra(String palavra) {
        if (conjunto.remove(palavra)) {
            System.out.println("Palavra '" + palavra + "' removida do conjunto.");
        } else {
            System.out.println("Palavra '" + palavra + "' não encontrada no conjunto.");
        }
    }

    // Método para exibir as palavras do conjunto
    public void exibirPalavras() {
        if (conjunto.isEmpty()) {
            System.out.println("O conjunto está vazio.");
        } else {
            System.out.println("Palavras no conjunto: " + conjunto);
        }
    
    }
  }