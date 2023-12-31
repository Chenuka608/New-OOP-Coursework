
import java.util.*;
public class WestminsterShoppingManager {
    private List<Product> productList;
    private int productCount = 0;


    public WestminsterShoppingManager (){
        this.productList = new ArrayList<>();
    }

    public void addCLothingProduct(Product product){
        if(productCount==50){
            System.out.println("----Sorry cannot add product!! , max product limit is 50 ----");
        }else{
            productList.add(product);
            productCount++;
            System.out.println("Clothing Product added Successfully !");
        }

    }


    public void printProducts() {
        for (Product product : productList ) {       //*Method prints all customers in the customers array list
            System.out.print(product);
            System.out.print(" ");
        }
    }

    public void SortProductList(){
        Collections.sort(productList, Comparator.comparing(Product::getProductID));
        System.out.println("----------Product List-----------");
        for(Product product :productList){
            System.out.println("Product ID : "+product.getProductID());
            System.out.println("Product Name : "+product.getProductName());
            System.out.println("No. of Products : "+product.getNumOfProducts());
            System.out.println("Type: " + (product instanceof Clothing ? "Clothing" : "Electronic"));
            if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                System.out.println("Size: " + clothing.getSize());
                System.out.println("Color: " + clothing.getColour());
            }
            else if (product instanceof  Electronics){
                Electronics electronics = (Electronics) product;
                System.out.println("Brand :"+ electronics.getBrand());
                System.out.println("Warranty :"+electronics.getWarrantyPeriod());

            }
            System.out.println("----------------------------------------");
        }
    }




    public void addElecProduct(Product product) {
        if (productCount == 0) {
            System.out.println("----Sorry cannot add product!! , max product limit is 50 ----");
        } else {
            productList.add(product);
            productCount++;
            System.out.println("Electronic Product added Successfully!");
        }

    }

    public void delClothingProduct(String productID) {
        boolean productFound=false;
        for (Product product : productList) {
            if (product instanceof Clothing && product.getProductID().equals(productID)) {
                productFound=true;
                productList.remove(product);
                System.out.println("Clothing product with ID: " + productID + " has been Deleted Successfully!");
                productCount--; // If needed
                break;
            }
        }
        if (!productFound) { // Check after the loop
            System.out.println("Clothing product with ID: " + productID + " has not been Found!");
        }
    }

    public void delElecProduct(String productID) {
        boolean productFound = false;
        for (Product product : productList) {
            if (product instanceof Electronics && product.getProductID().equals(productID)) {
                productList.remove(product);
                productFound=true;
                System.out.println("Electronic product with ID: " + productID + " has been Deleted Successfully!");
                productCount--;

                break;
            }
        }
        if (!productFound) { // Check after the loop
            System.out.println("Electronic product with ID: " + productID + " has not been Found!");
        }
        System.out.println("Remaining Product count: " + productCount );
    }



    public List<Product>getProductList(){
        return productList;
    }
}


