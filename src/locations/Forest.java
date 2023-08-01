package locations;
import monster.*;
import player.*;

public class Forest extends BattleArea{
    public Forest(ThisPlayer thisPlayer){
        super(thisPlayer,"Forest",new Vampire(),"Firewood");
    }
}