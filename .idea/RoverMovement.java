import java.util.ArrayList;
//Plateau is split into 4 parts like so:
//0 1
//2 3

//input
//5 5
//1 2 N
//LMLMLMLMM
//3 3 E
//MMRMMRMRRM

public class RoverMovement{
    private int[][] plateau; // 0: not visited; 1: visited
    private Rover[] RoverCollection;

    // program to run the rovers sequentially
    public void RoverMovement(String[] input) {
        //setup plateau and rovers
        SetupPlateau(input[0]);
        initialiseRovers(input);

        //run the simulation
        RunRover();
    }

    //intialise the plateau grid
    private static void SetupPlateau(String UpperRightPosition){
        String[] line = UpperRightPosition.split(" ", -1);

        int w = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);

        System.out.println("width: " + w + ", height: " + h);

        plateau = new int[h][w];
    }

    //unpack the rest of the input, initialise the rovers and save them in an array
    private static void initialiseRovers(String line1, String line2){
        //setup the rovers array
        TotalRovers = input.length - 1 / 2;
        System.out.println(TotalRovers);
        Rover[] RoversTemp = new Rover[TotalRovers];
        int count = 0

        for(int i = 1; i < input.length; i++){
            //Landing Position
            String[] LandingPosition = input[i].split(" ");//splits the line using spaces
            int x = Integer.parseInt(LandingPosition[0]);
            int y = Integer.parseInt(LandingPosition[1]);
            char direction = LandingPosition[2].charAt(0);

            Position LandingPostion = new Position(x, y, direction);

            //rover commands
            String MovementCommands = input[i+1];
            char[] roverCommands = MovementCommands.toCharArray();
            Rover rover = new Rover(LandingPosition, roverCommands);
            RoversTemp[count] = rover;

            //increment variables
            count++;
            i++;
        }

    }

    //function to run the rover -> output the final location and return
    private static String RunRover(String input, int x, int y) {
        for(Rover rover : RoverCollection){

        }
    }

    public static void main(String[] args) {
        String[] input = {
                "5 5",
                "1 2 N",
                "LMLMLMLMM",
                "3 3 E",
                "MMRMMRMRRM"
        };
    }
}