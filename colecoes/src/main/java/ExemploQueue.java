import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class ExemploQueue {
    public static void main(String[] args) {
        testandoPriorityQueue();
        testandoArrayDeque();
    }

    private static void testandoPriorityQueue() {
        PriorityQueue <String> q = new PriorityQueue<>();

        // Adicionando elemento à fila
        q.add("eduardo");
        q.add("aloisio");
        q.add("henrique");
        System.out.println(q);

        // Observando o cabecalho da fila
        System.out.println(q.peek());

        // Diferente do metodo peek, lança uma exeção caso a fila esteja vazia
        System.out.println(q.element());

        // Remove o primeiro elemento da fila e o retorna
        System.out.println(q.poll());

        // Metodo para adicionar sem violar as restrições de capacidade
        // Retorna true se o objeto for adicionado com sucesso, se não retorna falso
        q.offer("paulo");
    }

    private static void testandoArrayDeque(){
        Deque<Integer> deque = new ArrayDeque();

        // Adiciona elemento ao inicio da fila.
        deque.addFirst(1);

        // Adiciona elemento ao final da fila.
        deque.addLast(2);
        deque.addLast(2);

        // Repete os elementos na ordem inversa
        System.out.println(deque.descendingIterator());

        // Recupera o elemento ao inicio da fila. Não remove o element.
        System.out.println(deque.getFirst());

        // Recupera o elemento ao fim da fila. Não remove o element.
        System.out.println(deque.removeLast());

        // Remove a ultima ocorrencia de determinado elemento no deque.
        System.out.println(deque.removeLastOccurrence(2));

        // Remove a primeira ocorrencia de determinado elemento no deque.
        System.out.println(deque.removeFirstOccurrence(2));

    }
}
