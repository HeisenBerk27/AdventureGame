package player;

import java.util.Scanner;

public class ThisPlayer {
    private int damage;
    private int health;
    private String charName;
    private int charhealth;
    private int money;
    private String name;
    private final Scanner scanner = new Scanner(System.in);
    private Inventory inventory;

    public ThisPlayer(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectPlayer() {


        Characters[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("--------------------------------------| Karakterler |--------------------------------------");
        for (Characters characters : charList) {
            System.out.println("Karakter " + characters.getId() + ": " + characters.getName() + " | " +
                    " Sağlık" + ": " + characters.getHealthy() + " | " +
                    " Hasar" + ": " + characters.getDamage() + " | " +
                    " Para" + ": " + characters.getMoney() + " | " +
                    " Durum " + " -> " + characters.getStatus());

        }
        System.out.println("--------------------------------------------------------------------------------------");
        ;
        System.out.print("Lütfen bir karakter seçin (numarayı yazın) -> ");

        boolean isCharPicked;
        do {
            switch (scanner.next()) {
                case "1":
                    isCharPicked = true;
                    chosenChar(new Samurai());
                    System.out.println(getCharName() + ": Kılıcım onuruma, zırhım gücüme ve savaşlarım kararlılığıma tanıklık ediyor !");
                    break;
                case "2":
                    isCharPicked = true;
                    chosenChar(new Archer());
                    System.out.println(getCharName() + ": Oklarım asla izlerini kaçırmaz, amacım doğrudur ve düşmanlarımın üzerine fırtına gibi yağacağım !");
                    break;
                case "3":
                    isCharPicked = true;
                    chosenChar(new Knight());
                    System.out.println(getCharName() + ": Kılıcım keskin, kalkanım sağlam, düşmanlarımın önümde ağlayacağı gün gelecek !");
                    break;
                default:
                    System.out.println("Geçersiz bir değer yazdınız! Lütfen karakter idsini yazınız");
                    isCharPicked = false;
                    break;
            }
        } while (!isCharPicked);
    }

    public void chosenChar(Characters characters) {
        this.setDamage(characters.getDamage());
        this.setHealth(characters.getHealthy());
        this.setMoney(characters.getMoney());
        this.setCharName(characters.getName());
        this.setCharhealth(characters.getHealthy());
    }

    public void showStatus() {
        int recentMoney = this.getMoney();
        int recentDamage = this.getDamage();
        int recentShield = this.getHealth();
        String recentHero = this.getCharName();
        String recentWeapon = this.getInventory().getWeaponName();

        System.out.println("Karakteriniz hakkında son bilgiler : ");
        System.out.println("Karakter : " + recentHero + ", " +
                "Para : " + recentMoney + ", " +
                "Hasar : " + recentDamage + ", " +
                "Sağlık : " + recentShield + ", " +
                "Eşya : " + recentWeapon);
    }

    public void awardStats(){
        System.out.println("Water    : "+this.getInventory().isWater());
        System.out.println("Food     : "+this.getInventory().isFood());
        System.out.println("Firewood : "+this.getInventory().isFireWoord());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeaponDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotalHealth() {
        return health + this.getInventory().getArmorDefence();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getCharhealth() {
        return charhealth;
    }

    public void setCharhealth(int charhealth) {
        this.charhealth = charhealth;
    }
}
