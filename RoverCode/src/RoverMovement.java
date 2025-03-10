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

    //store the inputs then run them one by one
    public static void main(String[] args) {
        String[] input1 = { //given test input
                "5 5",
                "1 2 N",
                "LMLMLMLMM",
                "3 3 E",
                "MMRMMRMRRM"
        };
        new RoverMovement(input1);
        System.out.println("Rover Movement");
    }

    // program to run the rovers sequentially
    public RoverMovement(String[] input) {
        //setup plateau and rovers
        SetupPlateau(input[0]);
        initialiseRovers(input);

        System.out.println(plateau.length);
        System.out.println(plateau[0].length);

        for (int i = 0; i < RoverCollection.length; i++) {
            System.out.println(RoverCollection[i].toString());
        }

        //run the rovers
        RunRover();
    }

    //intialise the plateau grid
    private void SetupPlateau(String UpperRightPosition){
        String[] line = UpperRightPosition.split(" ", -1);

        int w = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);

        System.out.println("width: " + w + ", height: " + h);

        plateau = new int[h][w];
    }

    //unpack the rest of the input, initialise the rovers and save them in an array
    private void initialiseRovers(String[] input){
        //setup the rovers array
        int TotalRovers = (input.length - 1) / 2;
        System.out.println("Total Rovers: " + TotalRovers);
        Rover[] RoversTemp = new Rover[TotalRovers];
        int count = 0;

        for(int i = 1; i < input.length; i++){
            //Landing Position
            String[] LandingPosition = input[i].split(" ");//splits the line using spaces
            int x = Integer.parseInt(LandingPosition[0]);
            int y = Integer.parseInt(LandingPosition[1]);
            char direction = LandingPosition[2].charAt(0);

            Position RoverPosition = new Position(x, y, direction);

            //rover commands
            String MovementCommands = input[i+1];
            char[] RoverCommands = MovementCommands.toCharArray();
            Rover rover = new Rover(RoverPosition, RoverCommands);
            RoversTemp[count] = rover;

            //increment variables
            count++;
            i++;
        }

        RoverCollection = RoversTemp;
    }

    //function to run the rover -> output the final location and return
    private void RunRover() {
        for(Rover rover : RoverCollection){
            String output = rover.executeCommands();
            System.out.println(output);
        }
    }
}