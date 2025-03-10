import java.util.Arrays;

public class Rover{
    Position LandingPosition;
    char[] MovementCommands;
    Position CurrentPosition;

    //just for testing
//    @Override
//    public String toString() {
//        return "Rover{" +
//                "LandingPosition=" + LandingPosition +
//                ", MovementCommands=" + Arrays.toString(MovementCommands) +
//                ", CurrentPosition=" + CurrentPosition +
//                ", GridStarted=" + GridStarted +
//                ", GridEnded=" + GridEnded +
//                '}';
//    }

    public Rover(Position LandingPosition, char[] MovementCommands){
        this.LandingPosition = LandingPosition;
        this.MovementCommands = MovementCommands;
        this.CurrentPosition = LandingPosition;
    }

    public String executeCommands(){
        for(char command : MovementCommands){
            if(command == 'L' || command == 'R'){
                rotateRover(command);
            }
            else{//assuming M
                moveRover();
            }
        }

        return CurrentPosition.toString();
    }

    //rotate the rover by one left or right
    private void rotateRover(char command){
        char[] directions = {'N', 'E', 'S', 'W'};
        int index = -1;

        //find the position in directions
        for(int i = 0; i < directions.length; i++){
            if(directions[i] == CurrentPosition.direction){
                index = i;
                break;
            }
        }

        //calculate the turn -> if left -1; if right +1
        if(command == 'L'){
            index = index - 1;
            if(index == -1){
                index = directions.length - 1;
            }
        }
        else{ //assuming R
            index += 1;
            if(index == directions.length){
                index = 0;
            }
        }

        CurrentPosition.direction = directions[index];
    }

    //move the rover forward which ever direction it is facing in.
    private void moveRover(){
        if(CurrentPosition.direction == 'N'){
            CurrentPosition.y += 1;
        }
        else if(CurrentPosition.direction == 'E'){
            CurrentPosition.x += 1;
        }
        else if(CurrentPosition.direction == 'S'){
            CurrentPosition.y -= 1;
        }
        else if(CurrentPosition.direction == 'W'){
            CurrentPosition.x -= 1;
        }
    }
}