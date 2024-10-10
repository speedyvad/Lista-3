package Q1;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeImpostoDeRenda {
    private List<Tributavel> tributaveis; // Lista para armazenar objetos Tributaveis
    private double totalImpostos; // Atributo para armazenar o total de impostos

    // Construtor
    public GerenciadorDeImpostoDeRenda() {
        tributaveis = new ArrayList<>(); // Inicializa a lista de tributáveis
        totalImpostos = 0;
    }

    // Método para adicionar um objeto Tributavel
    public void adicionarTributavel(Tributavel tributavel) {
        tributaveis.add(tributavel);
        totalImpostos += tributavel.getValorImposto(); // Soma o imposto ao total
    }

    // Método para retornar o total de impostos
    public double getTotalImpostos() {
        return totalImpostos;
    }
}
