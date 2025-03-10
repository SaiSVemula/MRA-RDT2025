//Plateau is split into 4 parts like so:
//0 1
//2 3

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class RoverMovement{
    private static int[][] plateau; // 0: empty can land; 1: Occupied cannot land or traverse
    private static ArrayList<Rover> RoverCollection = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    //store the inputs then run them one by one
    public static void main(String[] args) {
        getPlateauSize();
        boolean exit = false;
        while(!exit){
            String roverLandingPosition = getValidLandingPosition();
            if(roverLandingPosition == null){
                exit = true;
                continue;
            }
            String MovementCommands = getValidMovementCommands();

            // initialise rover
            // execute commands in the rover
        }
    }

    //Gets the user input for the plateau size and asks until it is correctly entered.
    public static void getPlateauSize(){
        final String invalid = "Invalid plateau size entered! Try again";
        boolean valid = false;
        while(!valid) {
            System.out.println("Enter plateau size(format: Width Height): ");

            String[] split = sc.nextLine().split(" ");
            if (split.length != 2) {
                System.out.println(invalid);
            }
            try {
                int width = Integer.parseInt(split[0]);
                int height = Integer.parseInt(split[1]);
                if (width < 1 || height < 1) {
                    System.out.println(invalid);
                } else {
                    //initialise the plateau grid once the size is entered correctly
                    plateau = new int[height + 1][width + 1];
                }
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        }

    }

    public static String getValidLandingPosition() {
        //initialising variables but the way it is designed there will be a manually entered correct value for these variables.
        int x = 0;
        int y = 0;
        char direction = 'n';
        final String invalid = "Invalid landing position entered! Try again";
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter the position of rover (format: x y direction) " + RoverCollection.size() + 1 + " or enter 'exit' to stop the program: ");
            String roverLandingInput = sc.nextLine();

            if (roverLandingInput.equals("exit")) {
                return null;
            }

            String[] split = roverLandingInput.split(" ");
            if (split.length != 3) {
                System.out.println(invalid);
                continue;
            }
            try {
                x = Integer.parseInt(split[0]);
                y = Integer.parseInt(split[1]);
                direction = split[2].charAt(0);

                if (direction != 'N' && direction != 'S' && direction != 'E' && direction != 'W') {
                    System.out.println(invalid);
                    continue;
                }
                //if the x y are out of bounds
                if (x < 0 || y < 0 || x >= plateau.length || y >= plateau[0].length) {
                    System.out.println(invalid);
                    continue;
                }
                //if the position is currently occupied by another rover
                if (plateau[x][y] == 1) {
                    System.out.println(invalid);
                    continue;
                }

                valid = true;

            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        }

        return x + " " + y + " " + direction;
    }

    public static String getValidMovementCommands() {
        boolean valid = false;
        String RoverCommands = "";
        final String invalid = "Invalid command entered! Try again";
        valid = true;
        while (!valid) {
            System.out.println("Enter the movement commands (format: L or R or M without spaces): ");
            for (int i = 0; i > RoverCommands.length(); i++) {
                char c = RoverCommands.charAt(i);
                if (c != 'L' && c != 'R' && c != 'M') {
                    System.out.println(invalid);
                    valid = false;
                    break;
                }
            }
        }
        return RoverCommands;
    }

//    // program to run the rovers sequentially
//    public RoverMovement(String[] input) {
//        //setup plateau and rovers
//        SetupPlateau(input[0]);
//        initialiseRovers(input);
//
//        System.out.println(plateau.length);
//        System.out.println(plateau[0].length);
//
//        for (int i = 0; i < RoverCollection.size(); i++) {
//            System.out.println(RoverCollection.get(i).toString());
//        }
//
//        //run the rovers
//        RunRover();
//    }

//    //intialise the plateau grid
//    private void SetupPlateau(String UpperRightPosition){
//        String[] line = UpperRightPosition.split(" ", -1);
//
//        int w = Integer.parseInt(line[0]);
//        int h = Integer.parseInt(line[1]);
//
//        System.out.println("width: " + w + ", height: " + h);
//
//        plateau = new int[h][w];
//    }

//    //unpack the rest of the input, initialise the rovers and save them in an array
//    private void initialiseRovers(String[] input){
//
//        for(int i = 1; i < input.length; i++){
//            //Landing Position
//            String[] LandingPosition = input[i].split(" ");//splits the line using spaces
//            int x = Integer.parseInt(LandingPosition[0]);
//            int y = Integer.parseInt(LandingPosition[1]);
//            char direction = LandingPosition[2].charAt(0);
//
//            Position RoverPosition = new Position(x, y, direction);
//
//            //rover commands
//            String MovementCommands = input[i+1];
//            char[] RoverCommands = MovementCommands.toCharArray();
//            Rover rover = new Rover(RoverPosition, RoverCommands);
//            RoverCollection.add(rover);
//        }
//    }
//
//    //function to run the rover -> output the final location and return
//    private void RunRover() {
//        for(Rover rover : RoverCollection){
//            String output = rover.executeCommands();
//            System.out.println(output);
//        }
//    }
}