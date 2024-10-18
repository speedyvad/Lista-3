package Q3;

public abstract class Conta {
    protected double saldo;

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        }else
        return false;
    }

    public double obterSaldo() {
        return saldo;
    }
}
