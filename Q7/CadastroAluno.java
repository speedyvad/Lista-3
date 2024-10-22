package Q7;

import java.util.TreeSet;

public class CadastroAluno {
    private TreeSet<Aluno> alunos;

    public CadastroAluno() {
        this.alunos = new TreeSet<>(); // TreeSet ordena os elementos automaticamente
    }

    // Adiciona um aluno ao TreeSet (será automaticamente ordenado pelo IRA)
    public void adicionarAluno(Aluno aluno) {
        aluno.calcularIra(); // Calcula o IRA antes de adicionar
        alunos.add(aluno);
    }

    // Método para imprimir a lista de alunos ordenados por IRA (maior para menor)
    public void imprimirAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }
        }
    }
}
