import java.util.Scanner;

public class BossFight {



    public static void epilouge(String name) {
        System.out.println(name + ", You have survived your journey, you are a powerful warrior, congratulations!");

    }

    public static void bossFight(String name, int heroHealth) {

        // setting up boss fight hero and boss health
        heroHealth += 50;
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
                    int heroAttack = RandomInt.randomInt(20, 90);
                    int enemyAttack = RandomInt.randomInt(30, 60);

                    // adjusting the hero and enemy health after an attack
                    heroHealth -= enemyAttack;
                    enemyHealth -= heroAttack;
                    System.out.println("You attack! your attack deals " + heroAttack + " damage, leaving the monster with " + enemyHealth + ", but the monster dealt " + enemyAttack + " damage,\n leaving you with " + heroHealth + " health");

                    // run this if the enemys health is 0 or less
                    if (heroHealth <= 0) {
                        System.out.println("You have perished on your quest, a brave effort but all for naught...");
                        MonsterTwo.monsterTwo();
                        Main.main();
                        break;

                        // run this if the heros health is 0 or less
                    } else if (enemyHealth <= 0) {
                        System.out.println("You have defeated the monster!!!");
                        MonsterFour.monsterFour();
                        epilouge(name);
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
                Main.main();
            }
        }

    }

}
