
import java.util.*;                                                             //Name   - K.K.C.N Sarathchandra
public class Console {                                                          //Uow No - w1998757    IIT No - 20221022


    private static  Scanner input = new Scanner(System.in);

    private static boolean isTrue = true;

    static WestminsterShoppingManager m1 = new WestminsterShoppingManager();

    public static void main(String[] args) {



        System.out.println("\nShopping System Menu \n------------------------------------------------------------------");
        System.out.println("Enter  [a]  To Add a new product");
        System.out.println("Enter  [d]  To Delete a product");
        System.out.println("Enter  [p]  To Print the list of products");
        System.out.println("Enter  [s]  To Save the product list in a file ");
        System.out.println("Enter  [l]  To Load the list of products from a file");
        System.out.println("Enter  [g]  To open the gui");
        System.out.println("Enter  [q]  To Exit the Program .\n------------------------------------------------------------------");

        while(isTrue){
            System.out.println("\n Enter your Option : ");
            String option = input.next();

            switch (option){
                case "a": case"add":
                    addNewProduct(input);
                    break;

                case"d": case"del":
                    deleteProduct(input);
                    break;

                case"p": case"printL":
                    printProductList();
                    break;

                case"s": case"saveL":
                    saveListToFile();
                    break;

                case"l": case"loadL":
                    loadSavedList();
                    break;

                case"q": case"EXT":
                    System.out.println("Thank You , Have a Great Day !");
                    isTrue=false;
                    break;

                default:
                    System.out.println("Invalid Option !");  // handling in case invalid input
                    break;
            }

        }
    }
    //Method implementation for each relevent switch cases
    public static void addNewProduct(Scanner input){
        System.out.println("------------------------------------------------------\n");
        System.out.println("Select [c]  in order to add Clothing Products");
        System.out.println("Select [e] in order to add Electronic Products");
        System.out.println("------------------------------------------------------\n");
        System.out.println("Select your option :");
        String option = input.next().toLowerCase();
        if (option.equalsIgnoreCase("c"))
        {
            System.out.println("Enter Clothing product to Add");
            addClothingProduct();
        }
        else if(option.equalsIgnoreCase("e")){
            {
                System.out.println("Enter Electronic product to Add");
                addElecProduct();
            }

        }else{
            System.out.println("Invalid Option ! Pls Enter again ");
        }
    }

    public static void deleteProduct(Scanner input){
        System.out.println("------------------------------------------------------\n");
        System.out.println("Select [c] to Delete Clothing Item");
        System.out.println("Select [e] to Delete Electronic Item");
        System.out.println("------------------------------------------------------\n");
        String option = input.next().toLowerCase();
        if(option.equalsIgnoreCase("c")){
            deleteClothingItem();

        }else if(option.equalsIgnoreCase("e")){
            deleteElecItem();
        }

    }

    public static void printProductList(){

    }

    public static void saveListToFile(){

    }

    public static void loadSavedList(){                         // rest of the methods for delete and add products

    }
    public static void addClothingProduct() {
        while(isTrue){
            System.out.println("Enter Clothing product details :\n");
            System.out.println("Enter the ProductID:");
            String productId = input.next();
            System.out.println("Enter the Product Name:");
            String name = input.next();
            System.out.println("Enter no. of available Products :");
            int numOfProduct = input.nextInt();
            System.out.println("Enter the Product Price:");
            double price = input.nextDouble();
            System.out.println("Enter the Clothing Size:");
            int size = input.nextInt();
            System.out.println("Enter the Clothing Color:");
            String color = input.next();

            Clothing clothing = new Clothing(size,color,productId,name,numOfProduct,price);
            m1.addProduct(clothing);
        }

    }


    public static void addElecProduct(){
        while(isTrue){
            System.out.println("Enter Electronic Product Details :\n");
            System.out.println("Enter the ProductID :");
            String option = input.next();
            System.out.println("Enter the Product Name :");
            String name = input.next();
            System.out.println("Enter no. of available Products");
            int numOfProduct = input.nextInt();
            System.out.println("Enter the Product Price :");
            double Price = input.nextDouble();

            System.out.println("Enter the warranty Period :");
            int warranty = input.nextInt();

        }


    }
    public static void deleteClothingItem(){

    }

    public static void deleteElecItem(){

    }

}