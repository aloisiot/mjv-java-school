# Queue

Queue é uma interface java que respeita os conceitos FIFO (First in first out). A interface Queue presente no pacote java.util e estende a interface Collection é utilizada para conter os elementos prestes a serem processados ​​na ordem FIFO(First In First Out). É uma lista ordenada de objetos com seu uso limitado a inserir elementos no final da lista e excluir elementos do início da lista, ou seja, segue o princípio FIFO ou First-In-First-Out.

## Exemplos de classes que implementão a interfaces que estendem Queue

[Código fonte](./src/main/java/ColecoesExemplo.java)

### classe PriorityQueue

Um PriorityQueue é usado quando os objetos devem ser processados com base na prioridade. Sabe-se que uma Queue segue o algoritmo First-In-First-Out, mas às vezes os elementos da fila precisam ser processados ​​de acordo com a prioridade, é aí que entra o PriorityQueue. O PriorityQueue é baseado no heap de prioridade. Os elementos da fila de prioridade são ordenados de acordo com a ordenação natural, ou por um Comparador fornecido no momento da construção da fila, dependendo de qual construtor é utilizado.

**Exemplo de codigo**:
```java
import java.util.PriorityQueue;
import java.util.Queue;

public class ExemploPriorityQueue {
    public static void main(String[] args) {
        Queue <String> q = new PriorityQueue<>();

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
}

```

### Interface Deque

Todas as filas, exceto Deques, oferecem suporte para inserção e remoção no final e no início da fila, respectivamente. O Deques suporta a inserção e remoção do elemento em ambas as extremidades. Esta interface estende a Queueinterface. Quando um deque é usado como uma fila, ocorre o comportamento FIFO (First-In-First-Out). Os elementos são adicionados no final do deque e removidos desde o início. Os métodos herdados da interface Queue são precisamente equivalentes aos métodos Deque.

**Exemplo de codigo**:

```java



public class ExemploArrayDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque();

        // Adiciona elemento ao inicio da fila.
        deque.addFirst(1);

        // Adiciona elemento ao final da fila.
        deque.addLast(2);
        deque.addLast(2);

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
```
