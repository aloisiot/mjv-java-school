import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColecoesExemplo {
    public static void main(String[] args) {
        List < String > alunos = new ArrayList<>();
        alunos.add("Marcela");
        alunos.add("Clara");
        alunos.add("Tadeu");

        // Ordenando
        Collections.sort(alunos);

        // Ordenando (comparacao com lambda)
        alunos.sort((a1, a2) -> a1.compareTo(a2));

        // Imprimindo cada elemento da lista
        alunos.forEach(a -> System.out.println(a));

        // Verificando se a coleção comtem determinado elemento
        System.out.println(alunos.contains("Clara"));

        // Verificando o tamanho da colecao
        System.out.println(alunos.size());
    }
}
