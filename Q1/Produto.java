package Q1;

public class Produto implements Tributavel {
    private double preco; // Preço do produto
    private double aliquotaImposto; // Alíquota do imposto (em %)

    // Construtor
    public Produto(double preco, double aliquotaImposto) {
        this.preco = preco;
        this.aliquotaImposto = aliquotaImposto;
    }

    // Implementação do método da interface Tributavel
    @Override
    public double getValorImposto() {
        return preco * (aliquotaImposto / 100); // Calcula o valor do imposto sobre o preço
    }

    public double getPreco() {
        return preco;
    }
}
