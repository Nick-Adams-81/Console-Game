import java.util.Scanner;

public class Main {

    public static void main() {
        boolean confirmation;
        // initializing a scanner to capture user input
        Scanner scanner = new Scanner(System.in);

            do {

                // setting up the hero and first enemy health
                int heroHealth = 100;
                int enemyHealth = 80;

                // asking the user for their name
                System.out.println("Tell me your name");
                String name = scanner.nextLine();
                System.out.println("Hello " + name + ", nice to meet you!");

                // calling the void level methods
                LevelOne.levelOne(name, heroHealth, enemyHealth);
                LevelTwo.levelTwo(name, heroHealth);
                BossFight.bossFight(name, heroHealth);


                // asking the user if they want to play again
                System.out.println("Play again?[y/n]");
                String response = scanner.nextLine();
                confirmation = response.equalsIgnoreCase("y");

            } while (confirmation);


    }
}
