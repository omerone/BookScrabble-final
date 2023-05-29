package bookScrabble.model.logical;

import bookScrabble.model.data.Tile;

import java.util.ArrayList;
import java.util.Observable;

public class BuildTilesModel extends Observable {
    ArrayList<Tile> tileArrayList = new ArrayList<>();
    public void addTile(Tile tile){
        tileArrayList.add(tile);
    }
    public Tile[] getTiles(){
        return (Tile[]) tileArrayList.toArray();
    }
    public void resetTiles(){
        tileArrayList.clear();
    }

}
