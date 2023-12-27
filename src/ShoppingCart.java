import java.util.*;
public class ShoppingCart {

    private List<Product> products;


    public ShoppingCart(){
        this.products =new ArrayList<>();
    }

    public void addElecProduct(Product product){
        products.add(product);

    }
    public void addClothingProduct(Product product){
        products.add(product);
    }
    public void delElecProduct(Product product){

        products.remove(product);
    }
    public void delClothingProduct (Product product){

        products.remove(product);
    }
    public List<Product> getShoppingCart (){

        return products;
    }

}
