package Q8;

public class Usuario {
    private String nome;
    private String senha;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Usuario(String nome, String senha) throws SenhaInvalidaException {
        this.nome = nome;
        setSenha(senha);
        this.contaCorrente = new ContaCorrente();
        this.contaPoupanca = new ContaPoupanca();
    }

    public void setSenha(String senha) throws SenhaInvalidaException {
        if (isSenhaForte(senha)) {
            this.senha = senha;
        } else {
            throw new SenhaInvalidaException("A senha deve ter pelo menos 7 caracteres, incluindo letras e números.");
        }
    }

    private boolean isSenhaForte(String senha) {
        return senha.length() >= 7 && senha.matches(".*[a-zA-Z].*") && senha.matches(".*[0-9].*");
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public ContaPoupanca getContaPoupanca() {
        return contaPoupanca;
    }
}

