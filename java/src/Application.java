import control.GadgetController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private GadgetController controller;

    Scanner sc = new Scanner(System.in);

    public Application(GadgetController controller) {
        this.controller = controller;
    }

    public void start() {
        while (true) {

            System.out.println("------------------------------------------------------");
            System.out.println("Welcome to the electronic store!");
            System.out.println("What do you want to do?");
            System.out.println("Choose option:");
            System.out.println("1. Get information of gadget by ID");
            System.out.println("2. Get all information of gadgets");
            System.out.println("3. Add new gadgets at the store");
            System.out.println("4. Exit?");
            System.out.println("------------------------------------------------------");

            try {
                int a = sc.nextInt();
                switch(a) {
                    case 1:
                        System.out.println("Please enter ID...");
                        int id = sc.nextInt();
                        String response = controller.getGadget(id);
                        System.out.println(response);

                    case 2:
                        String response1 = controller.getAllGadgets();
                        System.out.println(response1);

                    case 3:
                        System.out.println("1. How much gadgets do you have?");
                        int amount = sc.nextInt();
                        System.out.println("2. What's Brand of the gadget?");
                        String brand = sc.next();
                        System.out.println("3. What's model of the gadget?");
                        String model = sc.next();
                        String response2 = controller.createGadget(amount,brand,model);
                        System.out.println(response2);

                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter only number!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

            System.out.println("------------------------------------------------------");
        }
    }
}

