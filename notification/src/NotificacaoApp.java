import service.MessagerFacade;
import service.MessagerType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NotificacaoApp {
    private static final String path = "/media/aloisiot/HD1/MJV/mjv-java-school/output-agua-luz-atracao/contratos";

    public static void main(String[] args) throws IOException {
        System.out.println("\n");

        // Instanciando mensageiro SMS
        MessagerFacade messeger = new MessagerFacade("2342342", MessagerType.SMS);
//        messeger.send(message);

        // Alterando mensageiro para WHATSAPP
        messeger.setMessegerType(MessagerType.WHATSAPP);
//        messeger.send(message);

        File file = new File(path);

        for (File f : file.listFiles()) {
            if (! f.isDirectory()) {
                StringBuilder contratoSB = new StringBuilder();
                List<String> lines =  Files.readAllLines(Path.of(path + "/" + f.getName()));


                if(lines.get(0).equalsIgnoreCase("SMS")) {
                    messeger.setMessegerType(MessagerType.SMS);
                } else {
                    messeger.setMessegerType(MessagerType.WHATSAPP);
                }

                lines.remove(0); // Removendo linha correspondente ao TipoTransmissor
                lines.forEach(line -> contratoSB.append(line + "\n"));
                messeger.send(contratoSB.toString());
            }
        }
    }
}
