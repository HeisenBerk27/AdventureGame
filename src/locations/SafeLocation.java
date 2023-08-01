package locations;

import player.*;

public abstract class SafeLocation extends Location {

    SafeLocation(ThisPlayer thisPlayer, String name, int id){
        super(thisPlayer,name,4);
    }

    @Override
    public boolean onLocation(){
        return true;
    }
}
