package util;

import java.util.Formatter;

public class FormatterExemple {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(); // Destino para o formatador
        Formatter formatter = new Formatter(sb); // Instância

        // Como primeiro argumento a string a ser formatada.
        // Os demais argumentos iram compor a string resultante
        formatter.format("Joana %s", "Santos");
        System.out.println(sb); // Printando a string destino

        // Simplificando
        String nomeCompleto = String.format("Marcos %s", "Vinicius");
        System.out.println(nomeCompleto);

        // Se a intenção é somente imprimir algo formatado temos  tambem
        System.out.printf("Tamires %s", "Fonseca");
    }
}
