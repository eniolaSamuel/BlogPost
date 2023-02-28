import controllers.UserController;
import dtos.requests.RegisterRequest;

import javax.swing.*;

public class Main {
    private static UserController userController = new UserController();
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp(){
        String message = """
                Hi, how can i help you today?
                1 -> Register
                2 -> Find Users
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> register();
            case '2' -> findUser();
            default -> {
                display("Invalid input, Try Again");
                startApp();
            }
        }
    }

    private static void display (String message){
        JOptionPane.showMessageDialog(null, message);
    }

    private static void findUser() {
        String userInput = input("Enter user ID to search for:");
        display(userController.findUserById(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void register(){
        RegisterRequest request = new RegisterRequest();
        String firstName = input ("Enter first name");
        String lastname = input ("Enter last name");
        String userName = input ("Enter username");
        String password = input ("Enter first name");
        var result = userController.register(request);
        display(result.toString());
        startApp();

    }

    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
}