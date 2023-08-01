package player;

public abstract class Characters {
    Inventory inventoryManager;
    private int damage;
    private int healthy;
    private int money;
    private int id;
    private String name;
    private String status;

    Characters(int damage, int healthy, int money, String name, String status, int id) {
        this.status = status;
        this.damage = damage;
        this.healthy = healthy;
        this.name = name;
        this.money = money;
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void selected() {
        System.out.println("Seçilen kahraman : " + getName());
    }
}