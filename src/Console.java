import java.util.*;                                                             //Name   - K.K.C.N Sarathchandra
public class Console {                                                          //Uow No - w1998757    IIT No - 20221022

    private static boolean isTrue = true;



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\nShopping System Menu \n------------------------------------------------------------------");
        System.out.println("Enter  [a]   To Add a new product");
        System.out.println("Enter  [d]   To Delete a product");
        System.out.println("Enter  [p]   To Print the list of products");
        System.out.println("Enter  [s]   To Save the product list in a file ");
        System.out.println("Enter  [l]   To Load the list of products from a file");
        System.out.println("Enter  [g]   To open the gui");
        System.out.println("Enter  [q]   To Exit the Program .\n------------------------------------------------------------------");

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
        System.out.println("Press [c]  in order to add Clothing Products");
        System.out.println("Press [e] in order to add Electronic Products");



    }

    public static void deleteProduct(Scanner input){

    }

    public static void printProductList(){

    }

    public static void saveListToFile(){

    }

    public static void loadSavedList(){

    }

}