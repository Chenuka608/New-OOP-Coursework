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
    public List<Product> getShoppingCart(){

        return products;
    }
    public List<Product> getProductsByType(String productType) {
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : products) {
            if ("Clothing".equalsIgnoreCase(productType) && product instanceof Clothing) {
                filteredProducts.add(product);
            } else if ("Electronics".equalsIgnoreCase(productType) && product instanceof Electronics) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }
    public void addToShoppingCart(Product product) {
        products.add(product);
    }
}



