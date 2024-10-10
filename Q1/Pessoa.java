package Q1;

public class Pessoa {
    private String nome;              // Nome da pessoa
    private Tributos tributos;        // Objeto Tributos para gerenciar os impostos da pessoa

    // Construtor para inicializar o nome e o gerenciador de tributos
    public Pessoa(String nome) {
        this.nome = nome;
        this.tributos = new Tributos(); // Inicializa o objeto Tributos
    }

    // Getter para o nome
    public String getNome() {
        return nome;
    }

    // Setter para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para adicionar um tributo para a pessoa
    public void adicionarTributo(double valor) {
        tributos.adicionarTributo(valor); // Chama o método da classe Tributos
        System.out.println("Tributo de " + valor + " adicionado para " + nome);
    }

    // Método para visualizar o total de impostos da pessoa
    public double getTotalImpostos() {
        return tributos.getTotalTributos(); // Retorna o total de tributos da classe Tributos
    }
}
