package app.Model.tiles;

import app.Model.board.Position;

public class FlagTile extends Tile {
    // FlagTile constructors
    private int HPGain = 1;
    
    public FlagTile(Position position) {
        super("Flag", position);
    }

    public FlagTile(Position position,int HPGain) {
        super("Flag", position);
        this.HPGain = HPGain;
    }

    public int getHPGain(){
        return this.HPGain;
    }

}
