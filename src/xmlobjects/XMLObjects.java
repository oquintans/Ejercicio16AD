/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 *
 * @author oracle
 */
public class XMLObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("serial.txt"));
            XMLStreamWriter sw = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream("products.xml"));
//            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("serial.txt"));           
//
//            String[] cod = {"p1", "p2", "p3"};
//            String[] desc = {"parafusos", "cravos", "tachas"};
//            int[] price = {3, 4, 5};
//            for (int i = 0; i < cod.length; i++) {
//                Product p1 = new Product(cod[i], desc[i], price[i]);
//                os.writeObject(p1);
//            }
//            os.writeObject(null);
//            os.close();

            Product p2 = (Product) is.readObject();
            sw.writeStartDocument("1.0");
            sw.writeStartElement("products");
            while (p2 != null) {
                System.out.println(p2.toString());

                sw.writeStartElement("product");
                sw.writeAttribute("cod", p2.getCod());
                sw.writeStartElement("precio");
                sw.writeCharacters(String.valueOf(p2.getPrice()));
                sw.writeEndElement();
                sw.writeStartElement("descripcion");
                sw.writeCharacters(p2.getDesc());
                sw.writeEndElement();
                sw.writeEndElement();

                p2 = (Product) is.readObject();
            }
            sw.writeEndDocument();
            
            is.close();
            sw.flush();
            sw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLObjects.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException | XMLStreamException ex) {
            Logger.getLogger(XMLObjects.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
