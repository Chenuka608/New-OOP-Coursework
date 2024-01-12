
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        if (productCount == 50) {
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

    public void saveListToFile(String productListSave) {
        try {
            FileWriter storeData = new FileWriter(productListSave);

            for (Product product : getProductList()) {
                String line = "";
                if (product instanceof Clothing) {
                    Clothing clothing = (Clothing) product;
                    line = "Clothing " + clothing.getProductID() + " " + clothing.getProductName() + " " +
                            clothing.getNumOfProducts() + " " + clothing.getPrice() + " " +
                            clothing.getSize() + " " + clothing.getColour();
                } else if (product instanceof Electronics) {
                    Electronics electronics = (Electronics) product;
                    line = "Electronics " + electronics.getProductID() + " " + electronics.getProductName() + " " +
                            electronics.getNumOfProducts() + " " + electronics.getPrice() + " " +
                            electronics.getBrand() + " " + electronics.getWarrantyPeriod();
                }
                storeData.write(line + "\n");
            }

            storeData.close();
            System.out.println("Product List Saved Successfully");

        } catch (IOException e) {
            System.out.println("An Error Occurred when writing: " + e.getMessage());
        }
    }
    public void loadListFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File does not exist!");
                return;
            }

            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] parts = line.split(" ");

                if (parts.length >= 2) {
                    String type = parts[0];

                    if (type.equalsIgnoreCase("Clothing") && parts.length == 7) {
                        // Parse Clothing information
                        String productId = parts[1];
                        String productName = parts[2];
                        int numOfProducts = Integer.parseInt(parts[3]);
                        double price = Double.parseDouble(parts[4]);
                        double size = Double.parseDouble(parts[5]);
                        String color = parts[6];

                        Clothing clothing = new Clothing(size, color, productId, productName, numOfProducts, price);
                        productList.add(clothing);
                    } else if (type.equalsIgnoreCase("Electronics") && parts.length == 7) {
                        // Parse Electronics information
                        String productId = parts[1];
                        String productName = parts[2];
                        int numOfProducts = Integer.parseInt(parts[3]);
                        double price = Double.parseDouble(parts[4]);
                        String brand = parts[5];
                        int warranty = (int) Double.parseDouble(parts[6]);

                        Electronics electronics = new Electronics(brand, warranty, productId, productName, numOfProducts, price);
                        productList.add(electronics);
                    }
                }
            }

            read.close();
            System.out.println("---------Product List Loaded Successfully!-------");

        } catch (IOException | NumberFormatException e) {
            System.out.println("An Error Occurred when loading data: " + e.getMessage());
        }
    }




    public List<Product>getProductList(){
        return productList;
    }
}


