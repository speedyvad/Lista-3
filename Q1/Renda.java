package Q1;

public class Renda implements Tributavel {
    private double valorRenda;
    private double aliquotaImposto; // Alíquota do imposto sobre a renda

    // Construtor
    public Renda(double valorRenda, double aliquotaImposto) {
        this.valorRenda = valorRenda;
        this.aliquotaImposto = aliquotaImposto;
    }

    // Implementação do método da interface Tributavel
    @Override
    public double getValorImposto() {
        return valorRenda * (aliquotaImposto / 100); // Calcula o valor do imposto sobre a renda
    }

    public double getValorRenda() {
        return valorRenda;
    }
}
