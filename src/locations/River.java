package locations;
import monster.*;
import player.*;

public class River extends BattleArea{

    public River(ThisPlayer thisPlayer){
        super(thisPlayer,"River",new Bear(),"Water");
    }
}