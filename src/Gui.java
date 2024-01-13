import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Gui extends JFrame {

    private ShoppingCart shoppingCart;
    private JTextArea productDetails;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JButton addToCartButton;
    private CartGui cartGui;




    private Product getProductById(String productID) {
        return Product.getProductByID(productID, shoppingCart.getShoppingCart());
    }

    public Gui() {
        shoppingCart = new ShoppingCart();  // Initialize the shopping cart
        cartGui = new CartGui();
        cartGui.setVisible(false);

        shoppingCart.addElecProduct(new Electronics("Sony", 3, "w1998", "OLED TV", 5, 69.99));
        shoppingCart.addElecProduct(new Electronics("Apple", 3, "w1999", "MacBook", 5, 299));
        shoppingCart.addClothingProduct(new Clothing(5, "pink", "w19", "Hoodie", 4, 25.15));
        shoppingCart.addClothingProduct(new Clothing(5, "brown", "w20", "Jacket", 4, 25.15));
        shoppingCart.addClothingProduct(new Clothing(5, "black", "w121", "Jeans", 4, 25.15));
        shoppingCart.addElecProduct(new Electronics("Nvidia", 2, "w2000", "RTX 4090", 5, 69.99));

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

        // Create "Add to Cart" button
        addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToShoppingCart();
            }
        });

        // Add the button directly to the menu bar
        menuBar.add(addToCartButton);





        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = productTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // When a row is selected, update the product details
                        String details = getProductDetails(selectedRow);
                        productDetails.setText(details);
                    }
                }
            }
        });


        // Initialize the table model and set it to the JTable
        String[] columnNames = {"Product ID", "Product Name", "Category", "Price", "Info"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable.setModel(tableModel);



    }
    private void addToShoppingCart() {
        int selectedRow = productTable.getSelectedRow();

        if (selectedRow != -1) {
            String productID = String.valueOf(tableModel.getValueAt(selectedRow, 0));
            Product selectedProduct = Product.getProductByID(productID, shoppingCart.getShoppingCart());

            if (selectedProduct != null && selectedProduct.getNumOfProducts() > 0) {
                // Check if the product is already in the cart
                boolean isProductInCart = shoppingCart.getShoppingCart().contains(selectedProduct);

                if (!isProductInCart) {
                    // If the product is not in the cart, add it
                    shoppingCart.addToShoppingCart(selectedProduct);
                }

                // Decrement the product availability
                selectedProduct.decrementAvailability();

                // Update the UI to reflect the changes
                updateProductTable("All");

                // Pass information to CartGui
                updateCartGui(selectedProduct);
            }
        }
    }
    private void updateCartGui(Product selectedProduct) {
        if (cartGui != null) {
            String productName = selectedProduct.getProductName();
            int quantity = 1;  // Assuming adding one item at a time
            double price = selectedProduct.getPrice();

            cartGui.addToCart(productName, quantity, price);
        }
    }


    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("Select Category");

        String[] productType = {"All", "Electronics", "Clothing"};

        for (String type : productType) {
            JMenuItem productTypeMenuItem = new JMenuItem(type);
            productTypeMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateProductTable(type);
                }
            });
            viewMenu.add(productTypeMenuItem);
        }

        JButton shoppingCartButton = new JButton("Shopping Cart");
        shoppingCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openShoppingCartGui();
            }
        });

        // This line should be present and is not an unreachable statement
        menuBar.add(viewMenu);

        menuBar.add(Box.createHorizontalGlue()); // Adds space between menu items
        menuBar.add(shoppingCartButton);

        return menuBar;
    }

    private JTable createProductTable() {
        return new JTable(tableModel);

    }

    public void updateProductTable(String category) {
        try {
            // Clear the existing data in the table
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    tableModel.setRowCount(0);
                }
            });

            // Get all products in the shopping cart
            List<Product> productList = shoppingCart.getShoppingCart();

            // Populate the table with product data based on the selected category
            for (Product product : productList) {
                if (category.equalsIgnoreCase("All") ||
                        (category.equalsIgnoreCase("Clothing") && product instanceof Clothing) ||
                        (category.equalsIgnoreCase("Electronics") && product instanceof Electronics)) {

                    String productType;
                    Object additionalInfo;

                    if (product instanceof Clothing) {
                        Clothing clothing = (Clothing) product;
                        productType = "Clothing";
                        additionalInfo = "Size: " + clothing.getSize() + ", Color: " + clothing.getColour();
                    } else if (product instanceof Electronics) {
                        Electronics electronics = (Electronics) product;
                        productType = "Electronics";
                        additionalInfo = "Brand: " + electronics.getBrand() + ", Warranty: " + electronics.getWarrantyPeriod();
                    } else {
                        // Handle other types of products if needed
                        continue;
                    }

                    // Add the row data to the table model
                    final Object[] rowData = new Object[]{product.getProductID(), product.getProductName(), productType, product.getPrice(), additionalInfo};

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            tableModel.addRow(rowData);
                        }
                    });
                }
            }

            // Update the UI
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    tableModel.fireTableDataChanged();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
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

    private String getProductDetails(int selectedRow) {
        try {
            // Get the product ID from the selected row
            String productID = String.valueOf(tableModel.getValueAt(selectedRow, 0));


            Product selectedProduct = Product.getProductByID(productID, shoppingCart.getShoppingCart());


            if (selectedProduct != null) {
                String details = "Product ID: " + selectedProduct.getProductID() + "\n"
                        + "Product Name: " + selectedProduct.getProductName() + "\n"
                        + "Number of Products Available: " + selectedProduct.getNumOfProducts() + "\n"
                        + "Price: $" + selectedProduct.getPrice() + "\n";

                if (selectedProduct instanceof Clothing) {
                    Clothing clothing = (Clothing) selectedProduct;
                    details += "Size: " + clothing.getSize() + "\n"
                            + "Colour: " + clothing.getColour();
                } else if (selectedProduct instanceof Electronics) {
                    Electronics electronics = (Electronics) selectedProduct;
                    details += "Brand: " + electronics.getBrand() + "\n"
                            + "Warranty Period: " + electronics.getWarrantyPeriod();
                }

                return details;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error getting product details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


        // Return a default message if details cannot be retrieved
        return "Product Details not available for Row " + selectedRow;
    }
    private void openShoppingCartGui() {
        CartGui cartGui = new CartGui();
        cartGui.setVisible(true);
    }
}

