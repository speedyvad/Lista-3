package Q2;

public class Quadrado implements AreaCalculavel {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return lado * lado;  // Fórmula para calcular a área de um quadrado
    }
}

