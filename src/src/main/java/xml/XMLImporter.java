package xml;

import DAO.ProductoDAO;
import DAO.SupermercadoDAO;
import DAO.RegistroPrecioDAO;
import model.Producto;
import model.Supermercado;
import model.RegistroPrecio;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

import java.io.File;
import java.time.LocalDate;

public class XMLImporter {

    private final ProductoDAO productoDAO = new ProductoDAO();
    private final SupermercadoDAO supermercadoDAO = new SupermercadoDAO();
    private final RegistroPrecioDAO registroDAO = new RegistroPrecioDAO();

    public boolean importarXML(String ruta) {
        try {
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new File(ruta));

            NodeList productos = doc.getElementsByTagName("producto");

            for (int i = 0; i < productos.getLength(); i++) {
                Element p = (Element) productos.item(i);

                String nombre = p.getElementsByTagName("nombre").item(0).getTextContent();
                String categoria = p.getElementsByTagName("categoria").item(0).getTextContent();
                String unidad = p.getElementsByTagName("unidad_medida").item(0).getTextContent();

                // Buscar si ya existe
                Producto producto = productoDAO.findByName(nombre);

                if (producto == null) {
                    producto = new Producto(nombre, categoria, unidad);
                    productoDAO.create(producto);
                    producto = productoDAO.findByName(nombre);
                }

                int idProducto = producto.getId();

                NodeList registros = p.getElementsByTagName("registro");

                for (int j = 0; j < registros.getLength(); j++) {
                    Element r = (Element) registros.item(j);

                    LocalDate fecha = LocalDate.parse(r.getElementsByTagName("fecha").item(0).getTextContent());
                    double precio = Double.parseDouble(r.getElementsByTagName("precio").item(0).getTextContent());
                    String nombreSuper = r.getElementsByTagName("supermercado").item(0).getTextContent();

                    Supermercado superm = supermercadoDAO.findByName(nombreSuper);

                    if (superm == null) {
                        superm = new Supermercado(nombreSuper);
                        supermercadoDAO.create(superm);
                        superm = supermercadoDAO.findByName(nombreSuper);
                    }

                    RegistroPrecio rp = new RegistroPrecio(producto, superm, fecha, precio);
                    registroDAO.create(rp);
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error al importar XML: " + e.getMessage());
            return false;
        }
    }
}
