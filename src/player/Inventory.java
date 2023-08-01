package player;

public class Inventory {
    private boolean water;
    private boolean food;
    private boolean fireWoord;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorDefence;

    Inventory(){
        this.weaponName = "Punch";
        this.armorName = null;
        this.weaponDamage = 0;
        this.armorDefence = 0;
        this.water = false;
        this.food = false;
        this.fireWoord = false;

    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFireWoord() {
        return fireWoord;
    }

    public void setFireWoord(boolean fireWoord) {
        this.fireWoord = fireWoord;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }
}