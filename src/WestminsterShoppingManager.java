
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


    public void addElecProduct(Product product){
        productList.add(product);
        System.out.println("Electronic Product added Successfully!");
    }

    public void delClothingProduct (String productID){
        for(Product product : productList){
            if (product instanceof Clothing && product.getProductID().equals(productID)) {
                productList.remove(product);
                    System.out.println("Clothing product with ID : " + product.getProductID() + " has been Deleted Successfully !");
                    return;

            }else{
                System.out.println("Clothing product with ID :" +product.getProductID()+" has not been Found!");
                return;
            }

        }

    }
    public void delElecProduct (String productID){
        for(Product product : productList){
            if (product instanceof Clothing && product.getProductID().equals(productID)) {
                productList.remove(product);
                productCount--;
                System.out.println("Electronic product with ID : " + product.getProductID() + " has been Deleted Successfully !");
                System.out.println("--Remaining Product count : "+ productCount + "--");
                return;


            }else{
                System.out.println("Electronic product with ID :" +product.getProductID()+" has not been Found!");
                System.out.println("--Remaining Product count : "+ productCount + "--");
                return;
            }

        }

    }

    public List<Product>getProductList(){
        return productList;
    }
}


