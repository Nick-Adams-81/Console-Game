import java.util.Scanner;


public class ConsoleGame {

    // function generating a random number in a given range
    public static int randomInt(int Min, int Max) {
        return (int) (Math.random() * (Max - Min)) + Min;
    }

    // level 2 method
    public static void levelTwo(String name, int heroHealth, int enemyHealth) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", You made it past level 1, in your last fight you gained valuable experience and your health and attack have increased by 25%, \n you travel through a deep dark forest and encounter a tougher enemy! Your enemy challenges you to fight! Do you accept the challenge?[y/n]");

        boolean confirm;
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            int newHeroHealth = 125;
            int newEnemyHealth = 115;
            int potions = 3;
            System.out.println(name + ", Your health is now: " + newHeroHealth + ", and you now have " + potions + " potions, however your new enemy is much tougher, there health is: " + newEnemyHealth + ".");
            do {
                // using randomInt function to generate random hit points for hero and enemy when the user attacks
                int heroAttack = randomInt(7, 60);
                int enemyAttack = randomInt(20, 50);
                // re setting hero and enemy health

                System.out.println("");
                newHeroHealth -= enemyAttack;
                newEnemyHealth -= heroAttack;
                System.out.println("you attack! your attack dealt " + heroAttack + " damage to your enemy leaving him with " + newEnemyHealth + ", but his counter attack dealt " + enemyAttack + ", left you with " + newHeroHealth);
                if (newEnemyHealth <= 0) {
                    System.out.println("You defeated your enemy!");
                    System.out.println("");
                    MonsterOne.monsterOne();
                    break;
                } else if (newHeroHealth <= 0) {
                    System.out.println("You died, game over");
                    MonsterTwo.monsterTwo();
                    break;
                }
                System.out.println("Do you want to continue the attack, take a potion then attack, or run like a coward?[attack/potion/run]");
                String res = scanner.nextLine();
                if (res.equalsIgnoreCase("potion")) {
                    if (potions > 0) {
                        newHeroHealth += 20;
                        potions -= 1;
                        System.out.println("You took a potion, your health is now " + newHeroHealth + ", you have " + potions + " potions left");
                    } else if (potions == 0) {
                        System.out.println("You have no potions left! No health will be added!");
                    }

                } else if (res.equalsIgnoreCase("run")) {
                    System.out.println(name + ", Run away you coward!!!");
                }
                confirm = res.equalsIgnoreCase("attack") || res.equalsIgnoreCase("potion");

            } while (confirm);

        } else {
            System.out.println(name + " You are a coward for running! you could beat your enemy!!!");
        }
    }


    public static void bossFight(String name, int heroHealth2, int enemyHealth2) {

        // setting up boss fight hero and boss health
        int heroHealth = 200;
        int enemyHealth = 350;

        // setting up a scanner for user input in boss fight
        Scanner scanner = new Scanner(System.in);
        System.out.println("You made it past another enemy, the forrest starts to clear, you are finally home free, or so you think,\n just as the forest clears and you see the sun, a huge monster blocks your path! Do you run back to the dark woods, or do you fight?[run/fight]");
        String response = scanner.nextLine();
        // if the user fights the boss run this code
        if (response.equalsIgnoreCase("fight")) {

            // giving the user 2 potions
            int potions = 3;

            // asking the user one more time if they want to fight the boss
            System.out.println(name + ", You have gained much experience, your health is now: " + heroHealth + ", but you only have " + potions + " potions, but your enemy is powerful, his health is: " + enemyHealth + ", \n do you want to fight him?[y/n]");

            // saving the user response
            String response3 = scanner.nextLine();

            // if the user says yes again run this code
            if (response3.equalsIgnoreCase("y")) {
                System.out.println("");
                boolean confirm;
                do {

                    // using the random int method to get random attack points for the hero and the enemy
                    int heroAttack = randomInt(20, 90);
                    int enemyAttack = randomInt(30, 60);

                    // adjusting the hero and enemy health after an attack
                    heroHealth -= enemyAttack;
                    enemyHealth -= heroAttack;
                    System.out.println("You attack! your attack deals " + heroAttack + " damage, leaving the monster with " + enemyHealth + ", but the monster dealt " + enemyAttack + " damage,\n leaving you with " + heroHealth + " health");

                    // run this if the enemys health is 0 or less
                    if (enemyHealth <= 0) {
                        System.out.println("You have defeated the monster!!!!");
                        MonsterOne.monsterOne();
                        epilouge(name);
                        break;

                        // run this if the heros health is 0 or less
                    } else if (heroHealth <= 0) {
                        System.out.println("You have perished on your quest, a brave effort but all for naught...");
                        MonsterTwo.monsterTwo();
                        break;
                    }

                    // ask the user if they want to continue the fight, take a potion and continue the fight, or run away
                    System.out.println("Continue the fight, take a potion and continue the fight, or run away?[fight/potion/run]");
                    String response2 = scanner.nextLine();

                    // run this if the user input is potion
                    if (response2.equalsIgnoreCase("potion")) {
                        if (potions > 0) {
                            heroHealth += 50;
                            potions -= 1;
                            System.out.println("You took a potion, your health is now " + heroHealth + ", you have " + potions + " potion left");

                            // run this if the user has no more potions
                        } else if (potions == 0) {
                            System.out.println("You have no more potions left, no health will be added!");
                        }

                        // run thos of the user inputs run
                    } else if (response2.equalsIgnoreCase("run")) {
                        System.out.println(name + " I dont blame you for running, the monster is powerful");
                        break;
                    }

                    // setting the confirm boolean based on user input
                    confirm = response2.equalsIgnoreCase("fight") || response2.equalsIgnoreCase("potion");
                } while (confirm);
            } else {
                System.out.println(name + "I don't blame you for running, good luck back in the forest, you will need it to survive");
            }
        }

    }


    public static void epilouge(String name) {
        System.out.println(name + ", You have survived your journey, you are a powerful warrior, congratulations!");

    }


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
                levelTwo(name, newHeroHealth, newEnemyHealth);
                bossFight(name, heroHealth, enemyHealth);

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
