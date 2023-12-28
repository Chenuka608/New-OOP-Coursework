
import java.util.*;
public class WestminsterShoppingManager {
    private List<Product> productList;


    public WestminsterShoppingManager (){
        this.productList = new ArrayList<>();
    }

    public void addClothProduct(Product product){
        productList.add(product);
        System.out.println("Product added Successfully !");

    }
    public void addElecProduct(Product product){
        productList.add(product);
        System.out.println("Electronic Product added Successfully");
    }

    public void delProduct (Product product){
        if(productList.remove(product)){
            System.out.println("Product has been removed !");
        }else{
            System.out.println("Product is not Found !");
        }
    }

    public List<Product>getProductList(){
        return productList;
    }
}


