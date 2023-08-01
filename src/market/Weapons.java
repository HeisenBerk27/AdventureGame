package market;

public abstract class Weapons {
    private String name;
    private int id;
    private int damage;
    private int cost;

    public Weapons(String name, int id, int damage, int cost){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.cost = cost;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}