package Q7;

public class Disciplina {
    private String nome;
    private double nota;
    private int creditos;

    public Disciplina(String nome, double nota, int creditos) {
        this.nome = nome;
        this.nota = nota;
        this.creditos = creditos;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public int getCreditos() {
        return creditos;
    }
}
