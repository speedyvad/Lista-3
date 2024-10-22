package Q8;

public class ContaCorrente extends Conta implements Tributavel {
    
    // Construtor padrão
    public ContaCorrente() {
        super(); // Chama o construtor da classe pai (Conta)
    }

    @Override
    public double calculaTributos() {
        return this.saldo * 0.01; // 1% do saldo
    }
}
