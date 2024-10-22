package Q7;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Comparable<Aluno> {
    private int matricula;
    private String nome;
    private double ira;
    private String curso;
    private List<Disciplina> disciplinas; // Lista de disciplinas do aluno

    public Aluno(int matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.ira = 0.0;
        this.disciplinas = new ArrayList<>(); // Inicializa a lista de disciplinas
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getIra() {
        return ira;
    }

    public String getCurso() {
        return curso;
    }

    // Método para adicionar disciplina ao aluno
    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        calcularIra(); // Atualiza o IRA toda vez que uma nova disciplina é adicionada
    }

    // Método para calcular o IRA com base nas disciplinas
    public void calcularIra() {
        double somaNotas = 0;
        int totalCreditos = 0;

        for (Disciplina disciplina : disciplinas) {
            somaNotas += disciplina.getNota() * disciplina.getCreditos();
            totalCreditos += disciplina.getCreditos();
        }

        if (totalCreditos > 0) {
            this.ira = somaNotas / totalCreditos;
        }
    }

    @Override
    public int compareTo(Aluno outroAluno) {
        // Comparação decrescente do IRA (maior para menor)
        if (this.ira < outroAluno.ira) {
            return 1;
        } else if (this.ira > outroAluno.ira) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Nome: " + nome + ", IRA: " + ira + ", Curso: " + curso;
    }
}
