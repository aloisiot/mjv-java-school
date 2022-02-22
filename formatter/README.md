# Estudo sobre as classes Java para a formataçao de dada, hora, texto e números

---

## java.util.Formatter

A classe `java.util.Formatter` fornece suporte para alinhamento e justificação de layout, formatos comuns para dados numéricos, string e data/hora e saída específica de localidade.

Exemplo de código:

```java
import java.util.Formatter;

public class FormmatterExemple {
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
```
[Código fonte](./src/exemple/util/FormatterExemple.java)

### Alguns métodos da classe java.util.Formatter

- `void close()`: Este método fecha o formatador;
- `void flush()`: Esse método libera o formatador;
- `Formatter format(Locale l, String format, Object... args)`: Esse método grava uma string formatada no destino desse objeto usando a localidade especificada, a string de formato e os argumentos;
- `Formatter format(String format, Object... args)`: Esse método grava uma string formatada no destino desse objeto usando a string e os argumentos de formato especificados;
- `String toString()`: Esse método retorna o resultado da invocação de toString() no destino da saída;

---

## java.time.format.DateTimeFormatter

Essa classe fornece meios para formatação de data e hora em um aplicativo com padrões predefinidos ou definidos pelo usuário.

Exemplo de código:

```java
package exemple.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterExemple {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        // Usando formato predefinido através de uma constante
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(now));

        // Usando formatos predefinidos em FormatStyle
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(now));

        // Formatação personalizada
        String pattern = "dd.MM.yyyy";
        DateTimeFormatter personalizedFormatter = DateTimeFormatter.ofPattern(pattern);
        System.out.println(personalizedFormatter.format(now));
    }
}
```

[Código fonte](./src/exemple/time/DateTimeFormatterExemple.java)

### Alguns formatadores com estilos predefinidos
- `ofLocalizedDate(dateStyle)`: Formatador com estilo de data da localidade;
- `oofLocalizedTime(timeStyle)`: Formatador com estilo de hora da localidade;
- `ISO_LOCAL_DATE`: Data Local ISO;

### FormatStyle
Enumeração de estilos de formato de data, hora ou data-hora localidade;
- `FULL`: Estilo de texto completo, com o máximo de detalhes;
- `LONG`: Estilo de texto longo, com muitos detalhes;
- `MEDIUM`: Estilo de texto médio, com alguns detalhes;
- `SHORT`: Estilo de texto curto, normalmente numérico;

---

## java.text.DecimalFormat

DecimalFormat é uma subclasse de NumberFormat que possui diversos recursos para analizar e formatar números indiferente da localidade. Incluindo suporte para dígitos ocidentais e índicos.

Exemplo de código:

```java
package exemple.text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatExemple {
    public static void main(String[] args) {
        double value = 2005.234;
        String pattern = "#,##0.00";

        String formatedNumber = new DecimalFormat(pattern).format(00005.234);
        System.out.println(formatedNumber); //> 5,23

        // Definindo primeira uma localodade
        NumberFormat usFormat = DecimalFormat.getInstance(Locale.US);
        DecimalFormat usDecimalFormat = (DecimalFormat) usFormat;

        // Definindo segunda uma localodade
        NumberFormat frFormat = DecimalFormat.getInstance(Locale.FRANCE);
        DecimalFormat frDecimalFormat = (DecimalFormat) frFormat;
        frDecimalFormat.applyPattern(pattern);

        System.out.println(Locale.US + " " + usDecimalFormat.format(value)); //> en_US 2,005.234
        System.out.println(Locale.FRANCE + " " + frDecimalFormat.format(value)); //> fr_FR 2 005,23
    }
}
```

[Código fonte](./src/exemple/text/DecimalFormatExemple.java)

### Caracters curinga na formatação
- `0`: Representa um dígito, caso não esteja presente um 0 é adicionado;
- `#`: Representa um dígito, caso não esteja presente nada é exibido;
- `.`: Espaço reservado para separador decimal;
- `,`: Espaço reservado para separador de agrupamento;
