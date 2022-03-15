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
            // Lo primero que haremos es buildear nuestro XML para obtener el elemento raíz
            SAXBuilder builder = new SAXBuilder(); //Objeto Constructor
            File xml = new File("localidad_36057.xml"); //Creamos fichero donde se encuenta el XML que queremos parsear
            Document document = builder.build(xml); //Se construye
            Element root = document.getRootElement();
            //Cogemos el elemento hijo predicción
            List<Element> list = root.getChildren("prediccion"); //Lo metemos en una lista

            //Ahora leemos cada uno de los campos además del elemento predicción
            System.out.println("día\tviento\ttemperatura");

            for (int i = 0; i < list.size(); i++) { //recorremos la lista

                Element prediccion = list.get(i);

                List<Element> valores_prediccion = prediccion.getChildren();

                for (int j = 0; j < valores_prediccion.size(); j++) { //recorremos la lista

                    Element campo = valores_prediccion.get(j);

                    String fecha = campo.getAttributeValue("fecha");
                    String periodo = campo.getAttributeValue("direccion");
                    String temperatura = campo.getChildTextTrim("maxima");


                    System.out.println(fecha + "\t\t" + periodo + "\t\t" + temperatura); //Sacamos por pantalla el resultado

                }
            }

        } catch (JDOMException | IOException ex) {
        }
    }
}
