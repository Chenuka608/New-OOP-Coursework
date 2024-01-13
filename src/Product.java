import java.util.*;

public class Product {
    private String ProductID;
    private String productName;
    private int numOfProducts;
    private double Price;
    private int warranty;

    public Product(String ProductID, String productName, int numOfProducts, double Price) {
        this.ProductID = ProductID;
        this.productName = productName;
        this.numOfProducts = numOfProducts;
        this.warranty = warranty;

    }

    public String getProductID() {
        return this.ProductID;
    }

    public String getProductName() {
        return this.productName;
    }

    public double getPrice() {
        return this.Price;
    }

    public int getNumOfProducts() {
        return this.numOfProducts;
    }

    // Static method to get a Product instance by ID from a list
    public static Product getProductByID(String productID, List<Product> productList) {
        for (Product product : productList) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null; // Return null if the product is not found
    }
    public void decrementAvailability() {
        if (numOfProducts > 0) {
            numOfProducts--;
        }
    }
}

