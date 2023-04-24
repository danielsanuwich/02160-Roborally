public class LaserTile extends Tile{
    // LaserTile attributes 
    int laserDamage;

    // LaserTile constructor
    public LaserTile(Position inputPosition,Direction inputDirection, int laserDamage){
        this.laserDamage = Math.abs(laserDamage); 
        super(inputPosition, inputDirection, "Laser");
    }

    // LaserTile getters 
    public int getDamage(){
        return this.laserDamage;
    }
}