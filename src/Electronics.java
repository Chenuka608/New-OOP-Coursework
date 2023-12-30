
public class Electronics extends Product{

    private String Brand;
    private int warrantyPeriod;
    private String productID;
    private String productName;
    private int numOfProducts;
    private double price;

    @Override
    public String toString() {        //override to String method to be able to print the electronic specifications
        return "" +
                " " + Brand + '\'' +
                " " + warrantyPeriod+ '\'' +
                " " + productID +
                " " + productName +
                " " + price +
                " ";
    }

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

