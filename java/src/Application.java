import control.GadgetController;
import control.UserController;
import entity.Gadgets;
import entity.User;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    private GadgetController gadgetController;
    private UserController userController;

    Scanner sc = new Scanner(System.in);

    public Application(GadgetController gadgetController, UserController userController) {
        this.gadgetController = gadgetController;
        this.userController = userController;
    }

    public void start() {
        while (true) {

            System.out.println("------------------------------------------------------");
            System.out.println("Welcome to the electronic store!");
            System.out.println("What do you want to do?");
            System.out.println("Choose option:");
            System.out.println("1. Get information of gadget by ID");
            System.out.println("2. Get all information of gadgets");
            System.out.println("3. Add new gadgets at the store (Account Required)");
            System.out.println("4. Create a User account ");
            System.out.println("5. Exit?");
            System.out.println("------------------------------------------------------");

            try {
                int a = sc.nextInt();
                switch(a) {
                    case 1:
                        System.out.println("Please enter ID...");
                        int id = sc.nextInt();
                        String response = gadgetController.getGadget(id);
                        System.out.println(response);
                        break;

                    case 2:
                        List<Gadgets> response1 = gadgetController.getAllGadgets();
                        for(Gadgets gadget : response1)
                        {
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            System.out.println(gadget.getId() + " | " + gadget.getBrand() + " | " + gadget.getModel() + " | " + gadget.getAmount());
                            System.out.println("-------------------------------------------------------------------------------------------------");
                        }
                        break;

                    case 3:
                        System.out.println("Please, enter your login:");
                        String loginExist = sc.next();
                        System.out.println("Enter your password:");
                        String passwordExist = sc.next();

                        if(userController.checkUser(loginExist,passwordExist)){
                            System.out.println("Welcome back, " + loginExist);
                            System.out.println("1. How much gadgets do you have?");
                            int amount = sc.nextInt();
                            System.out.println("2. What's Brand of the gadget?");
                            String brand = sc.next();
                            System.out.println("3. What's model of the gadget?");
                            String model = sc.next();
                            String response2 = gadgetController.createGadget(amount,brand,model);
                            System.out.println(response2);
                            break;
                        }
                        else{
                            System.out.println("Wrong password or login, please try later!");
                            break;
                        }

                    case 4:
                        System.out.println("Please, enter your login");
                        System.out.println("Login:...");
                        String login = sc.next();
                        System.out.println("Enter password for you account.");
                        System.out.println("Password:...");
                        String password = sc.next();
                        String response3 = userController.createUser(login,password);
                        System.out.println(response3);
                        break;
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

