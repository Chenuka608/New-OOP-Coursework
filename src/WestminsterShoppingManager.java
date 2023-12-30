
import java.util.*;
public class WestminsterShoppingManager {
    private List<Product> productList;


    public WestminsterShoppingManager (){
        this.productList = new ArrayList<>();
    }

    public void addCLothingProduct(Product product){
        productList.add(product);
        System.out.println("Clothing Product added Successfully !");

    }


    public void printProducts() {
        for (Product product : productList ) {       //*Method prints all customers in the customers array list
            System.out.print(product);
            System.out.print(" ");
        }
    }


    public void addElecProduct(Product product){
        productList.add(product);
        System.out.println("Electronic Product added Successfully");
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

    public List<Product>getProductList(){
        return productList;
    }
}


