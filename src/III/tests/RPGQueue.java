package III.tests;

import java.util.LinkedList;
import java.util.Queue;

class Character {
    String name;
    int health;
    int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    /**
     * Postava se pokusi zautocit na jinou
     * @param opponent postava, na kterou je utoceno
     */
    public void attack(Character opponent) {
        System.out.println(name + " attacks " + opponent.name + " for " + attack + " damage!");
        opponent.health -= attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (HP: " + health + ", Attack: " + attack + ")";
    }
}

public class RPGQueue {
    public static void main(String[] args) {
        Queue<Character> team1 = new LinkedList<>();
        Queue<Character> team2 = new LinkedList<>();

        //Naplnit obe fronty postavami

        team1.add(new Character("Warrior", 50, 10));
        team1.add(new Character("Mage", 30, 15));
        team1.add(new Character("Rogue", 40, 12));

        team2.add(new Character("Goofy Bear", 55, 8));
        team2.add(new Character("Spider", 15, 14));
        team2.add(new Character("AnotherSpider", 15, 14));
        team2.add(new Character("Wolf", 45, 10));

        //klasicka implementace by mela zvladnout vypis toString defaultne
        System.out.println("Starting Battle!");
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);


        // TODO: 20.11.2024 Zajistit combat dvou teamu

        while(!(team1.isEmpty()) || !(team2.isEmpty())){
            System.out.println("-----------------");
            System.out.println(team1);
            System.out.println(team2);
            if (team1.peek().isAlive() && team2.peek().isAlive()){
                team1.peek().attack(team2.peek());
                if (!(team2.peek().isAlive())){
                    System.out.println(team2.peek().name + " has been defeated");
                    team2.poll();
                    if (team2.isEmpty()){
                        break;
                    }
                }
            }
            if (team1.peek().isAlive() && team2.peek().isAlive()){
                team2.peek().attack(team1.peek());
                if (!(team1.peek().isAlive())){
                    System.out.println(team1.peek().name + " has been defeated");
                    team1.poll();
                    if (team1.isEmpty()){
                        break;
                    }
                }
            }
        }
        if (team1.isEmpty()){
            System.out.println("team 2 wins tge battle!");
        }
        if (team2.isEmpty()){
            System.out.println("team 1 wins tge battle!");
        }
        //RULES: turn based combat, bojuji vzdy ti na vrcholu fronty
        //combat se opakuje, dokud neni jeden team porazen tak, ze ve fronte nic neni

        //vzdy zacne nekdo z teamu 1 utocit na neco z teamu 2
        //pote neco z teamu 2 na nekoho v temau 1
        //Pokud je clen tymu na vrchu fronty porazen, je vyndan z fronty
        //to, kdo je porazen, za kolik utoci vyuzijte metody v Character


        // TODO: 20.11.2024 Vypsat viteze
    }
}
