package util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public abstract class FormatadorDeTexto {
    public static String formatarCpf(String cpf) {
        String result = cpf;
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            result = mask.valueToString(cpf);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String formatarCep(String cep) {
        String result = cep;
        try {
            MaskFormatter mask = new MaskFormatter("#####-###");
            mask.setValueContainsLiteralCharacters(false);
            result = mask.valueToString(cep);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String preencher(String textoOriginal, int comprimento) {
        String formato = "%-" + comprimento + "s";
        String novaString = String.format(formato, textoOriginal);
        return novaString;
    }
    public static String cortar(String textoOriginal, int comprimento) {
        String  novaString = textoOriginal.substring(0, Math.min(comprimento, textoOriginal.length()));
        return novaString;
    }
    public static String ajustar(String textoOriginal, int comprimento) {
        String novaString = preencher(textoOriginal, comprimento);
        novaString = cortar(novaString, comprimento);
        return novaString;
    }
}
