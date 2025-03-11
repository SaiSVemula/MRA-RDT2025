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
                boolean value = moveRover();
                if(!value){
                    return null;
                }
            }
        }

        int x = CurrentPosition.x;
        int y = CurrentPosition.y;
        RoverMovement.plateau[y][x] = 1;

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
    private boolean moveRover(){
        int tempx = CurrentPosition.x;
        int tempy = CurrentPosition.y;

        if(CurrentPosition.direction == 'N'){
            tempy += 1;
        }
        else if(CurrentPosition.direction == 'E'){
            tempx += 1;
        }
        else if(CurrentPosition.direction == 'S'){
            tempy -= 1;
        }
        else if(CurrentPosition.direction == 'W'){
            tempx -= 1;
        }

        //check if out of bounds
        if(tempx < 0 || tempy < 0 || tempy >= RoverMovement.plateau.length || tempx >= RoverMovement.plateau[0].length) {
            return false;
        }

        //check if the rover is colliding into another rover
        if(RoverMovement.plateau[tempy][tempx] == 1){
            return false;
        }

        //if the move is valid now update the position of the rover.
        CurrentPosition.x = tempx;
        CurrentPosition.y = tempy;

        return true;
    }
}