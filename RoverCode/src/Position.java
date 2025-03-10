public class Position{
    int x;
    int y;
    char direction;

    public Position(int x, int y, char direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString(){
        return x + " "+ y + " " + direction;
    }
}