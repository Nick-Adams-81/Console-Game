import java.util.Scanner;

public class ConsoleGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // asking the user if they are ready to start the game
        System.out.println("Are you ready to start the game?[y/n]");
        String res = scanner.nextLine();
        // asking the user for their name
        System.out.println("Tell me your name");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + ", nice to meet you!");

        if(res.equalsIgnoreCase("y")) {
            Main.main(name);
        } else {
            System.out.println("Maybe next time!");
        }

    }

}
