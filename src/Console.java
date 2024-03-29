import javax.swing.SwingUtilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;                                                             //Name   - K.K.C.N Sarathchandra
public class Console {                                                 //Uow No - w1998757    IIT No - 20221022


    private static Scanner input = new Scanner(System.in);

    private static Gui gui;


    private static boolean isTrue = true;

    static WestminsterShoppingManager m1 = new WestminsterShoppingManager();

    public static void main(String[] args) {

        gui = new Gui();


        while (isTrue) {
            System.out.println("\nShopping System Menu \n------------------------------------------------------------------");
            System.out.println("Enter  [a]  To Add a new product");
            System.out.println("Enter  [d]  To Delete a product");
            System.out.println("Enter  [p]  To Print the list of products");
            System.out.println("Enter  [s]  To Save the product list in a file ");
            System.out.println("Enter  [l]  To Load the list of products from a file");
            System.out.println("Enter  [g]  To open the gui");
            System.out.println("Enter  [q]  To Exit the Program .\n------------------------------------------------------------------");

            System.out.println("---------------------------------\n");
            m1.printProducts();
            System.out.println("---------------------------------\n");
            System.out.println("\n Enter your Option : ");
            String option = input.next();

            switch (option) {
                case "a":
                case "A":
                    addNewProduct(input); //(done)
                    break;

                case "d":
                case "D":
                    deleteProduct(input);
                    break;

                case "p":
                case "P":
                    printProductList();
                    break;

                case "s":
                case "S":
                    saveListToFile();
                    break;

                case "l":
                case "L":
                    loadSavedList();
                    break;

                case "q":
                case "Q":
                    System.out.println("Thank You , Have a Great Day !");
                    isTrue = false;
                    break;

                case "g":
                case "G":
                    openGui();
                    break;

                default:
                    System.out.println("Invalid Option !");  // handling in case invalid input
                    break;
            }

        }
    }


    //Method implementation for each relevent switch cases
    public static void addNewProduct(Scanner input) {
        System.out.println("------------------------------------------------------\n");
        System.out.println("Select [c]  in order to add Clothing Products");
        System.out.println("Select [e] in order to add Electronic Products");
        System.out.println("------------------------------------------------------\n");
        System.out.println("Select your option :");
        String option = input.next().toLowerCase();
        if (option.equalsIgnoreCase("c")) {
            System.out.println("============Enter Clothing product to Add============\n");
            addClothingProduct();
        } else if (option.equalsIgnoreCase("e")) {
            {
                System.out.println("=============Enter Electronic product to Add============\n");
                addElecProduct();
            }

        } else {
            System.out.println("Invalid Option ! Pls Enter again ");
        }
    }

    public static void deleteProduct(Scanner input) {
        System.out.println("------------------------------------------------------\n");
        System.out.println("Select [c] to Delete Clothing Item");
        System.out.println("Select [e] to Delete Electronic Item");
        System.out.println("------------------------------------------------------\n");
        String option = input.next().toLowerCase();
        if (option.equalsIgnoreCase("c")) {
            deleteClothingItem();

        } else if (option.equalsIgnoreCase("e")) {
            deleteElecItem();
        } else {
            System.out.println("Invalid Option ! Pls Enter again");
        }

    }

    public static void printProductList() {
        m1.SortProductList();


    }

    public static void saveListToFile() {
        m1.saveListToFile("saveFile");
    }


    public static void loadSavedList() {
        m1.loadListFromFile("saveFile");


    }

    public static void addClothingProduct() {
        try {


            while (isTrue) {
                System.out.println("-----Enter Clothing product details :------\n");
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

                Clothing clothing = new Clothing(size, color, productId, name, numOfProduct, price);
                m1.addCLothingProduct(clothing);
                updateGui();
                System.out.println("If you want to add another Clothing product press [y] or press[n] to quit");
                String selection = input.next();
                if ("y".equalsIgnoreCase(selection)) {
                    continue;
                } else {
                    break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Pls Enter an Integer value!- cancelling product creation");input.next();
        }
    }


    public static void addElecProduct() {
        try {
            while (isTrue) {
                System.out.println("------Enter Electronic Product Details :-------\n");

                System.out.println("Enter the ProductID :");
                String productID = input.next();
                System.out.println("Enter the Product Name :");
                String name = input.next();
                System.out.println("Enter the Product Brand");
                String brand = input.next();
                System.out.println("Enter no. of available Products");
                int numOfProduct = input.nextInt();
                System.out.println("Enter the Product Price :");
                double price = input.nextDouble();

                System.out.println("Enter the warranty Period :");
                int warranty = input.nextInt();

                Electronics electronics = new Electronics(brand, warranty, productID, name, numOfProduct, price);
                m1.addElecProduct(electronics);
                updateGui();
                System.out.println("If you want to add another Electronic product press [y] or press[n] to quit");
                String selection = input.next();
                if ("y".equalsIgnoreCase(selection)) {
                    continue;
                } else {
                    break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Pls Enter an Integer value! - cancelling product creation");input.next();
        }
    }

    public static void deleteClothingItem() {
        System.out.println("Enter the productID of the Clothing to be deleted : ");
        String productID = input.next();
        m1.delClothingProduct(productID);
        updateGui();
    }

    public static void deleteElecItem() {
        System.out.println("Enter the productID of the Electronic to be deleted : ");
        String productID = input.next();
        m1.delElecProduct(productID);
        updateGui();

    }

    public static void openGui() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
                gui.updateProductTable("All"); // Update with all products
                System.out.println("GUI opened successfully.");
            }
        });
    }


    private static void updateGui() {
        if (gui != null) {
            System.out.println("Updating GUI...");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    gui.updateProductTable("All");
                    System.out.println("GUI updated successfully.");
                }
            });
        } else {
            System.out.println("GUI instance is null. Cannot update GUI.");
        }
    }
}
