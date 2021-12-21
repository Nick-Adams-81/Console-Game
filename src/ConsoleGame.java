import java.util.Scanner;

public class ConsoleGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // asking the user if they are ready to start the game
        System.out.println("Are you ready to start the game?[y/n]");
        String res = scanner.nextLine();
        if(res.equalsIgnoreCase("y")) {
            Main.main();
        } else {
            System.out.println("Maybe next time!");
        }

    }

}
