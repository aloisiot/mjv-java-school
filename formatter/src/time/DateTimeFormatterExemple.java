package time;

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
