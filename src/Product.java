public class Product {
    private String ProductID;
    private String productName;
    private int numOfProducts;
    private double Price;
    private int warranty;

    public Product(String ProductID ,String productName,int numOfProducts, double Price){
        this.ProductID = ProductID;
        this.productName = productName;
        this.numOfProducts =numOfProducts;
        this.warranty = warranty;

    }
    public String getProductID(){
        return this.ProductID;
    }

    public String getProductName(){
        return this.productName;
    }

    public double getPrice(){
        return this.Price;
    }
    public int getNumOfProducts(){
        return this.numOfProducts;
    }

}
