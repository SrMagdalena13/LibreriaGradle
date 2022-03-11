import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class UsoJDOM2 {
    public static void main(String[] args) {
        try {
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("localidad_36057.xml");
            Document document = builder.build(xml);
            Element root = document.getRootElement();

            List<Element> list = root.getChildren("prediccion");

            System.out.println("día\tviento\ttemperatura");

            for (int i = 0; i < list.size(); i++) {

                Element prediccion = list.get(i);

                List<Element> valores_prediccion = prediccion.getChildren();

                for (int j = 0; j < valores_prediccion.size(); j++) {

                    Element campo = valores_prediccion.get(j);

                    String fecha = campo.getAttributeValue("fecha");
                    String periodo = campo.getAttributeValue("direccion");
                    String temperatura = campo.getChildTextTrim("maxima");


                    System.out.println(fecha + "\t\t" + periodo + "\t\t" + temperatura);

                }
            }

        } catch (JDOMException | IOException ex) {
        }
    }
}
