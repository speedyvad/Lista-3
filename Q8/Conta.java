package Q8;

public abstract class Conta {
    protected double saldo;

    public Conta() {
        this.saldo = 0.0; // Inicializa o saldo com zero
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double obterSaldo() {
        return saldo;
    }
}
