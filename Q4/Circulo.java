package Q4;

class Circulo {
    // Atributo do círculo
    private double raio;

    // Construtor da classe
    public Circulo(double raio) {
        this.raio = raio;
    }

    // Método para calcular a área do círculo
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    // Método getter para acessar o valor do raio
    public double getRaio() {
        return raio;
    }
}
