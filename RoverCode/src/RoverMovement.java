import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class RoverMovement{
    public static int[][] plateau; // 0: empty can land; 1: Occupied cannot land or traverse
    private static ArrayList<Rover> RoverCollection = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    //store the inputs then run them one by one
    public static void main(String[] args) {
        getPlateauSize();
        boolean exit = false;
        while(!exit){
            Position roverLandingPosition = getValidLandingPosition();
            if(roverLandingPosition == null){
                exit = true;
                continue;
            }

            boolean valid = false;
            //until the path is correct it will not be executed and will ask to re-enter it
            while(!valid){
                char[] RoverCommands = getValidMovementCommands();
                Rover rover = new Rover(roverLandingPosition, RoverCommands);
                String value = rover.executeCommands();
                if(value == null){
                    System.out.println("Invalid Movement commands Rover is either falling off the plateau or colliding with another rover, please try again!");
                    continue;
                }
                System.out.println(value);
                RoverCollection.add(rover);
                valid = true;
            }
        }
    }

    //Gets the user input for the plateau size and asks until it is correctly entered.
    public static void getPlateauSize(){
        final String invalid = "Invalid plateau size entered! Try again";
        boolean valid = false;
        while(!valid) {
            System.out.println("Enter plateau size(format: Width Height): ");
            try {
                String[] split = sc.nextLine().split(" ");
                if (split.length != 2) {
                    System.out.println(invalid);
                    continue;
                }
                int width = Integer.parseInt(split[0]);
                int height = Integer.parseInt(split[1]);
                if (width < 1 || height < 1) {
                    System.out.println(invalid);
                } else {
                    //initialise the plateau grid once the size is entered correctly
                    plateau = new int[height + 1][width + 1];
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        }

    }

    public static Position getValidLandingPosition() {
        //initialising variables but the way it is designed there will be a manually entered correct value for these variables.
        int x = 0;
        int y = 0;
        char direction = 'n';
        final String invalid = "Invalid landing position entered! Try again";
        boolean valid = false;

        while (!valid) {
            int currentRoverNumber = RoverCollection.size() + 1;
            System.out.println("Enter the position of rover (format: x y direction) " + currentRoverNumber + " or enter 'exit' to stop the program: ");
            String roverLandingInput = sc.nextLine();
            try {
                if (roverLandingInput.equals("exit")) {
                    return null;
                }

                String[] split = roverLandingInput.split(" ");
                if (split.length != 3) {
                    System.out.println(invalid);
                    continue;
                }
                x = Integer.parseInt(split[0]);
                y = Integer.parseInt(split[1]);
                direction = split[2].charAt(0);

                if (direction != 'N' && direction != 'S' && direction != 'E' && direction != 'W') {
                    System.out.println(invalid);
                    continue;
                }
                //if the x y are out of bounds
                if (x < 0 || y < 0 || y >= plateau.length || x >= plateau[0].length) {
                    System.out.println("Landing position is out of bounds! Please try again!");
                    continue;
                }
                //if the position is currently occupied by another rover
                if (plateau[y][x] == 1) {
                    System.out.println("A rover already is in this position cannot land here! Please try again!");
                    continue;
                }

                valid = true;

            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        }

        return new Position(x, y, direction);
    }

    public static char[] getValidMovementCommands() {
        boolean valid = false;
        String RoverCommands = "";
        final String invalid = "Invalid command entered! Try again";
        while (!valid) {
            System.out.println("Enter the movement commands (format: L or R or M without spaces): ");
            RoverCommands = sc.nextLine().trim();
            if(RoverCommands.isEmpty()){
                System.out.println(invalid);
                continue;
            }

            valid = true;
            for (int i = 0; i < RoverCommands.length(); i++) {
                char c = RoverCommands.charAt(i);
                if (c != 'L' && c != 'R' && c != 'M') {
                    System.out.println(invalid);
                    valid = false;
                    break;
                }
            }
        }
        return RoverCommands.toCharArray();
    }
}