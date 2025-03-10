import java.util.Arrays;

public class Rover{
    Position LandingPosition;
    char[] MovementCommands;
    Position CurrentPosition;

    @Override
    public String toString() {
        return "Rover{" +
                "LandingPosition=" + LandingPosition +
                ", MovementCommands=" + Arrays.toString(MovementCommands) +
                ", CurrentPosition=" + CurrentPosition +
                ", GridStarted=" + GridStarted +
                ", GridEnded=" + GridEnded +
                '}';
    }

    //might remove later
    int GridStarted;
    int GridEnded;

    public Rover(Position LandingPosition, char[] MovementCommands){
        this.LandingPosition = LandingPosition;
        this.MovementCommands = MovementCommands;
    }
}