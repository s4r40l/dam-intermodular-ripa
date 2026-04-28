package xml;

import DAO.ProductoDAO;
import DAO.RegistroPrecioDAO;
import model.Producto;
import model.RegistroPrecio;

import java.io.FileWriter;
import java.util.List;

public class XMLExporter {

    private final ProductoDAO productoDAO = new ProductoDAO();
    private final RegistroPrecioDAO registroDAO = new RegistroPrecioDAO();

    public boolean exportarXML(String ruta) {
        try (FileWriter fw = new FileWriter(ruta)) {

            fw.write("""
                    <?xml version="1.0" encoding="UTF-8"?>
                    <ripa xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                          xsi:noNamespaceSchemaLocation="ripa.xsd">
                    """);

            List<Producto> productos = productoDAO.findAll();

            for (Producto p : productos) {
                fw.write("  <producto id=\"" + p.getId() + "\">\n");
                fw.write("    <nombre>" + p.getNombre() + "</nombre>\n");
                fw.write("    <categoria>" + p.getCategoria() + "</categoria>\n");
                fw.write("    <unidad_medida>" + p.getUnidadMedida() + "</unidad_medida>\n");

                fw.write("    <registros>\n");

                List<RegistroPrecio> registros = registroDAO.findByProducto(p.getId());
                for (RegistroPrecio r : registros) {
                    fw.write("      <registro>\n");
                    fw.write("        <fecha>" + r.getFecha() + "</fecha>\n");
                    fw.write("        <precio>" + r.getPrecio() + "</precio>\n");
                    fw.write("        <supermercado>" + r.getSupermercado().getNombre() + "</supermercado>\n");
                    fw.write("      </registro>\n");
                }

                fw.write("    </registros>\n");
                fw.write("  </producto>\n");
            }

            fw.write("</ripa>");
            return true;

        } catch (Exception e) {
            System.err.println("Error al exportar XML: " + e.getMessage());
            return false;
        }

    }
}
