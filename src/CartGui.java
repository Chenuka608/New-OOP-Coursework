import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CartGui extends JFrame {

    private JTable cartTable;
    private DefaultTableModel tableModel;

    private ShoppingCart shoppingCart;

    public CartGui() {
        setTitle("Shopping Cart");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 500);

        setLayout(new BorderLayout());

        // Create a table to display shopping cart contents
        cartTable = createCartTable();
        add(new JScrollPane(cartTable), BorderLayout.CENTER);

        // Initialize the table model and set it to the JTable
        String[] columnNames = {"Product", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        cartTable.setModel(tableModel);
    }

    private JTable createCartTable() {
        return new JTable(tableModel);
    }

    // Method to add a product to the shopping cart table
    public void addToCart(String product, int quantity, double price) {
        tableModel.addRow(new Object[]{product, quantity, price});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CartGui cartGui = new CartGui();
                cartGui.addToCart("Product1", 2, 10.0);
                cartGui.addToCart("Product2", 1, 15.0);
                cartGui.setVisible(true);
            }
        });
    }
}
