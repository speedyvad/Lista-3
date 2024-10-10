package Q1;

public class Tributos {
    private double totalTributos = 0; // Atributo para armazenar a soma dos tributos

    // Método para adicionar um tributo com valor passado como parâmetro
    public void adicionarTributo(double valor) {
        totalTributos += valor; // Soma o valor passado ao total de tributos
        System.out.println("Tributo de " + valor + " adicionado com sucesso!");
    }

    // Método que retorna o total dos tributos
    public double getTotalTributos() {
        return totalTributos;
    }
}
