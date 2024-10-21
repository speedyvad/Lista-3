package Q5;

//Classe que representa o usuário com nome e CPF
class Usuario {
 private String nome;
 private String cpf;

 public Usuario(String nome, String cpf) {
     this.nome = nome;
     this.cpf = cpf;
 }

 public String getNome() {
     return nome;
 }

 public String getCpf() {
     return cpf;
 }

 @Override
 public String toString() {
     return "Nome: " + nome + ", CPF: " + cpf;
 }

 @Override
 public int hashCode() {
     return cpf.hashCode(); // O hashCode é baseado no CPF (único)
 }

 @Override
 public boolean equals(Object obj) {
     if (this == obj) {
         return true;
     }
     if (obj == null || getClass() != obj.getClass()) {
         return false;
     }
     Usuario usuario = (Usuario) obj;
     return cpf.equals(usuario.cpf); // Dois usuários são iguais se tiverem o mesmo CPF
 }
}