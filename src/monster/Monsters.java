package monster;

public abstract class Monsters {
    private String name;
    private int id;
    private int damage;
    private int healthy;
    private int mainHealhy;
    private int money;

    public Monsters(String name, int id, int damage, int healthy, int money){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.mainHealhy = healthy;
        this.healthy = healthy;
        this.money = money;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealthy(){
        return healthy;
    }
    public void setHealthy(int healthy){
        this.healthy = healthy;
    }

    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money = money;
    }

    public int getMainHealhy() {
        return mainHealhy;
    }

    public void setMainHealhy(int mainHealhy) {
        this.mainHealhy = mainHealhy;
    }
}