package market;

public class Shield {
    private String name;
    private int id;
    private int cost;
    private int dodge;

    public Shield(String name, int id, int cost, int dodge) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.dodge = dodge;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
}