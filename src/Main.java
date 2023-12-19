

import java.util.*;
public class Main {

    private static boolean isTrue = true;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\nShopping System Menu \n------------------------------------------------------------------");
        System.out.println("Enter  1/add       Add a new product");
        System.out.println("Enter  2/del       Delete a product");
        System.out.println("Enter  3/printL    Print the list of products");
        System.out.println("Enter  4/saveL     Save the product list in a file ");
        System.out.println("Enter  5/loadL     Load the list of products from a file");
        System.out.println("Enter  0/EXT       Exit the Program .\n------------------------------------------------------------------");

        while(isTrue){
            System.out.println("Enter your Option : ");
            String option = input.next();

            switch (option){
                case "1": case"add":
                    addNewProduct(input);
                    break;

                case"2": case"del":
                    deleteProduct(input);
                    break;

                case"3": case"printL":
                    printProductList();
                    break;

                case"4": case"saveL":
                    saveListToFile();
                    break;

                case"5": case"loadL":
                    loadSavedList();
                    break;

                case"0": case"EXT":
                    System.out.println("Thank You , Have a Great Day !");
                    isTrue=false;
                    break;
            }

        }
    }
    public static void addNewProduct(Scanner input){

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