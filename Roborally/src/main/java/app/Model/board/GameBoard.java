
public class GameBoard {

    private int Xdim;
    private int Ydim;


    // Game Board consturctor 
    public GameBoard(int Xdimension, int Ydimension){ 
        Xdim = Xdimension;
        Ydim = Ydimension;

        private Tile[][] gameboard = new Tile[Xdim][Ydim];


        // make the gameboard

        // loop to assign the positions of the tiles on the gameboard
        for(int i = 0; i < Xdim; i++){
            for(int j = 0; j < Xdim; j++){
                gameboard[i][j].position.x = i;
                gameboard[i][j].position.y = j;
                gameboard[i][j].TileType = BASE_TILE; 
                gameboard[i][j].direction = 0
            }
        }

        // specify the other special tiles 
        // special tile type
        // special tile direction 

    }

    // gameboard tile type getter 
    public Tile getTile(Postion pos){
        return gameboard[pos.getX][pos.getY];
    }

}

