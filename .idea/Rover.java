public class Rover{
    Postion LandingPosition;
    char[] MovementCommands;
    Postion CurrentPosition;

    //might remove later
    int GridStarted;
    int GridEnded;

    public Rover(Postion LandingPosition, char[] MovementCommands){
        this.LandingPosition = LandingPosition;
        this.MovementCommands = MovementCommands;
    }
}