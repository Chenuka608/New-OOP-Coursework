
public class Electronics extends Product{

    private String Brand;
    private int warrantyPeriod;
    private String productID;
    private String productName;
    private int numOfProducts;
    private double price;

    public Electronics (String Brand, int warrantyPeriod  , String productID, String productName, int numOfProducts, double price){
        super(productID, productName, numOfProducts, price);
        this.Brand = Brand;
        this.warrantyPeriod = warrantyPeriod;
        this.productID=productID;
        this.productName = productName;
        this.numOfProducts=numOfProducts;
        this.price=price;
    }

}

