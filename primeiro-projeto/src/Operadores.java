public class Operadores {
    public static void main(String[] args) {
        // Concatenação
        String nomeCompleto = "Java" + " " + "Básico";
        System.out.println(nomeCompleto);

        // Precedendia da opeção entre parentese
        System.out.println("1" + (1+1+1));

        int num = 4;
        // A impresão será realisada antes que a variavel seja incrementada
        System.out.println(num++);

        int nota = 8;
        // Ternário
        System.out.println(nota >= 7 ? "aprovado" : "reprovado");

        String nome1 = "NOME";
        String nome2 = new String("NOME");
        // Falso porque apontam para referencias diferenter
        System.out.println(nome1 == nome2);
        // Verdadeiro por que compara valores e nâo referencia
        System.out.println(nome1.equals(nome2));

    }
}
