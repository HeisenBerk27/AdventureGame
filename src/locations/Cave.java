package locations;
import monster.*;
import player.*;

public class Cave extends BattleArea{

    public Cave(ThisPlayer thisPlayer){
        super(thisPlayer,"Cave",new Zombie(),"Food");
    }
}