package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import main.Shop;

public class InventoryView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public InventoryView(Shop shop) {
        setTitle("Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        String[] columnNames = {"Nombre", "Precio Mayorista", "Stock", "Disponible"};
        Object[][] data = shop.getInventoryData();

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane);
    }
}