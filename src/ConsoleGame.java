import java.util.Scanner;


public class ConsoleGame {

    // function generating a random number in a given range
//    public static int randomInt(int Min, int Max) {
//        return (int) (Math.random() * (Max - Min)) + Min;
//    }





    public static void main(String[] args) {
        boolean confirmation;
        // initializing a scanner to capture user input
        Scanner scanner = new Scanner(System.in);

        // asking the user if they are ready to start the game
        System.out.println("Are you ready to start the game?[y/n]");
        String res = scanner.nextLine();
        if (res.equalsIgnoreCase("y")) {

            do {

                Money.money();
                // setting up the hero and enemy health
                int heroHealth = 100;
                int enemyHealth = 80;

                // level 2 hero and enemy health
                int newHeroHealth = 125;
                int newEnemyHealth = 100;

                // asking the user for their name
                System.out.println("Tell me your name");
                String name = scanner.nextLine();
                System.out.println("Hello " + name + ", nice to meet you!");

                // calling the void level methods
                LevelOne.levelOne(name, heroHealth, enemyHealth);
                LevelTwo.levelTwo(name, newHeroHealth, newEnemyHealth);
                BossFight.bossFight(name, heroHealth, enemyHealth);y


                // asking the user if they want to play again
                System.out.println("Play again?[y/n]");
                String response = scanner.nextLine();
                confirmation = response.equalsIgnoreCase("y");

            } while (confirmation);
            // run this code if the user says no to playing the game
        } else {
            System.out.println("ok, maybe next time!");
        }

    }

}
