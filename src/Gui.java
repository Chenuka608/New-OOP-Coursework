import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Gui extends JFrame {

    private ShoppingCart shoppingCart;  // Use ShoppingCart directly
    private JTextArea productDetails;
    private JTable productTable;
    private DefaultTableModel tableModel;

    public Gui() {
        shoppingCart = new ShoppingCart();  // Initialize the shopping cart

        shoppingCart.addElecProduct(new Electronics("Sony", 3, "w1998", "OLED TV", 5, 69.99));
        shoppingCart.addClothingProduct(new Clothing(5, "pink", "w199", "Hoodie", 4, 25.15));


        setTitle("Westminster Shopping Centre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        setLayout(new BorderLayout());

        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);

        // Create a table to display products
        productTable = createProductTable();
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        // Create a text area to display product details
        productDetails = new JTextArea();
        productDetails.setEditable(false);
        add(new JScrollPane(productDetails), BorderLayout.SOUTH);

        // Initialize the table model and set it to the JTable
        String[] columnNames = {"Product ID", "Product Name", "Category", "Price", "Info"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable.setModel(tableModel);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("View");

        String[] productType = {"All", "Electronics", "Clothing"};
        JComboBox<String> productTypeChoice = new JComboBox<>(productType);
        JMenuItem productTypeMenuItem = new JMenuItem("Product Type");
        productTypeMenuItem.add(productTypeChoice);

        viewMenu.add(productTypeMenuItem);
        menuBar.add(viewMenu);

        // Event handler for the product type choice
        productTypeChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) productTypeChoice.getSelectedItem();
                updateProductTable(selectedType);
            }
        });

        return menuBar;
    }

    private JTable createProductTable() {
        return new JTable(tableModel);

    }

    private void updateProductTable(String productType) {
        // Clear the existing data in the table
        tableModel.setRowCount(0);

        try {
            List<Product> products;

            if ("All".equalsIgnoreCase(productType)) {
                products = shoppingCart.getShoppingCart();
            } else {
                products = shoppingCart.getProductsByType(productType);
            }

            // Populate the table with product data
            for (Product product : products) {
                if (product instanceof Clothing) {
                    Clothing clothing = (Clothing) product;
                    tableModel.addRow(new Object[]{clothing.getProductID(), clothing.getProductName(), clothing.getNumOfProducts(), clothing.getPrice(), clothing.getSize(), clothing.getColour()});
                } else if (product instanceof Electronics) {
                    Electronics electronics = (Electronics) product;
                    tableModel.addRow(new Object[]{electronics.getProductID(), electronics.getProductName(), electronics.getNumOfProducts(), electronics.getPrice(), electronics.getBrand(), electronics.getWarrantyPeriod()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating product table: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui gui = new Gui();
                gui.updateProductTable("All"); // Call the instance method on the created instance
                gui.setVisible(true);
            }
        });
    }
}