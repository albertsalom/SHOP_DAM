package dao;

import model.Employee;
import model.Product;
import model.ProductList;

import javax.xml.bind.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImplFile implements Dao {

    private static final String INVENTORY_XML_FILE = "jaxb/inputInventory.xml";

    @Override
    public void connect() throws SQLException {
        // Implementación vacía: no se requiere conexión en un archivo local
    }

    @Override
    public void disconnect() throws SQLException {
        // Implementación vacía: no se requiere desconexión en un archivo local
    }

    @Override
    public Employee getEmployee(int employeeId, String password) throws SQLException {
        // Implementación ficticia: Retornar un empleado fijo para pruebas
        if (employeeId == 1 && "password123".equals(password)) {
            return new Employee(employeeId, "John Doe", password);
        }
        return null; // Empleado no encontrado
    }

    @Override
    public ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            // Crear contexto JAXB para la clase ProductList
            JAXBContext context = JAXBContext.newInstance(ProductList.class);

            // Crear unmarshaller para leer el archivo XML
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Deserializar el archivo XML en un objeto ProductList
            ProductList productList = (ProductList) unmarshaller.unmarshal(new File(INVENTORY_XML_FILE));

            // Convertir la lista deserializada en un ArrayList de productos
            if (productList != null && productList.getProducts() != null) {
                inventory.addAll(productList.getProducts());
            }
        } catch (JAXBException e) {
            System.err.println("Error al leer el archivo XML: " + e.getMessage());
        }

        return inventory;
    }

    @Override
    public boolean writeInventory(ArrayList<Product> inventory) {
        try {
            // Crear contexto JAXB para la clase ProductList
            JAXBContext context = JAXBContext.newInstance(ProductList.class);

            // Crear marshaller para escribir el archivo XML
            Marshaller marshaller = context.createMarshaller();

            // Configurar el marshaller para que el XML sea legible
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Crear un objeto ProductList con la lista de productos
            ProductList productList = new ProductList();
            productList.setProducts(new ArrayList<>(inventory));

            // Serializar el objeto ProductList en el archivo XML
            marshaller.marshal(productList, new File(INVENTORY_XML_FILE));
            return true;
        } catch (JAXBException e) {
            System.err.println("Error al guardar el archivo XML: " + e.getMessage());
            return false;
        }
    }
}

