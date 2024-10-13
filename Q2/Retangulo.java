package Q2;

public class Retangulo implements AreaCalculavel {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return base * altura;  // Fórmula para calcular a área de um retângulo
    }
}
