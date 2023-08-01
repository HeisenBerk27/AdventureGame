package locations;

import monster.*;
import player.*;

public class House extends SafeLocation{

    public House(ThisPlayer thisPlayer) {
        super(thisPlayer, "Home" , 1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------------------------------| Home |-------------------------------");
        System.out.println("Evim güzel evim");
        System.out.println(" -> Sağlık yeniden doldu");
        System.out.println("----------------------------------------------------------------------");
        getThisPlayer().setHealth(this.getThisPlayer().getCharhealth());
        return true;
    }
}