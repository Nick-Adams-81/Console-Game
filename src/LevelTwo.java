import java.util.Scanner;

public class LevelTwo {


    public static void levelTwo(String name, int heroHealth) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", You made it past level 1, in your last fight you gained valuable experience and your health and attack have increased by 25%, \n you travel through a deep dark forest and encounter a tougher enemy! Your enemy challenges you to fight! Do you accept the challenge?[y/n]");

        boolean confirm;
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            heroHealth += 25;
            int newEnemyHealth = 115;
            int potions = 3;
            System.out.println(name + ", Your health is now: " + heroHealth + ", and you now have " + potions + " potions, however your new enemy is much tougher, there health is: " + newEnemyHealth + ".");
            do {
                // using randomInt function to generate random hit points for hero and enemy when the user attacks
                int heroAttack = RandomInt.randomInt(7, 60);
                int enemyAttack = RandomInt.randomInt(20, 50);

                heroHealth -= enemyAttack;
                newEnemyHealth -= heroAttack;
                System.out.println("you attack! your attack dealt " + heroAttack + " damage to your enemy leaving him with " + newEnemyHealth + ", but his counter attack dealt " + enemyAttack + ", left you with " + heroHealth);
                if (heroHealth <= 0) {
                    System.out.println("You died, game over!");
                    System.out.println("");
                    MonsterTwo.monsterTwo();
                    Main.main();
                } else if (newEnemyHealth <= 0) {
                    System.out.println("You defeated your enemy!");
                    MonsterOne.monsterOne();
                    break;
                }
                System.out.println("Do you want to continue the attack, take a potion then attack, or run like a coward?[attack/potion/run]");
                String res = scanner.nextLine();
                if (res.equalsIgnoreCase("potion")) {
                    if (potions > 0) {
                        heroHealth += 20;
                        potions -= 1;
                        System.out.println("You took a potion, your health is now " + heroHealth + ", you have " + potions + " potions left");
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
            Main.main();
        }
    }
}
