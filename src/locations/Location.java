package locations;

import java.util.Scanner;

import player.*;

public abstract class Location {
    protected Scanner scanner = new Scanner(System.in);
    private ThisPlayer thisPlayer;
    private String name;
    private boolean isWin = false;
    private int id;

    public Location(ThisPlayer thisPlayer, String name, int id) {
        this.thisPlayer = thisPlayer;
        this.name = name;
        this.id = id;
        this.isWin = false;
    }

    public abstract boolean onLocation();

    public ThisPlayer getThisPlayer() {
        return thisPlayer;
    }

    public void setThisPlayer(ThisPlayer thisPlayer) {
        this.thisPlayer = thisPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
