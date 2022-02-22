package text;

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
