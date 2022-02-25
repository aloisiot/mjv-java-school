// Aula 24 fev 2022 MJV School
// Array básico

public class ArrayExemplo {
    public static void main(String[] args) {
        // Instanciando um array de 52 posições
        Aluno [] alunos = new Aluno [52];

        alunos[0] = new Aluno("Marcos");
        alunos[1] = new Aluno("Vitoria");
        // ...
        alunos[51] = new Aluno("Carolina");

        for ( Aluno a : alunos ) {
            if ( a != null )
                System.out.println(a.getNome());
        }
    }
}
