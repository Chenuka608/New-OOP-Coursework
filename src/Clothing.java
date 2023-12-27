public class Clothing extends Product {


    private double size;
    private String colour;
    private String productID;
    private String productName;
    private int numOfProducts;
    private double price;

    public Clothing(double size, String colour, String productID, String productName, int numOfProducts, double price) {
        super(productID, productName, numOfProducts, price);
        this.size = size;
        this.colour = colour;
        this.productID = productID;
        this.productName = productName;
        this.numOfProducts = numOfProducts;
        this.price = price;

    }
    //getters & setters

}
