# Here you can read my though process through out coding this assessment, each timestamp represents almost one commit message so you can read my thought during each commit message. Hope this helps :)

## 5:50
- First I need to read the inputs setup the plateau as a graph grid then initialise all the rovers
- In order to setup a graph I can use an array list but I want it to be bare bones so I will find the height and width of the plateau using the upper right position which will be the limit. Then assign it to the plateau
- Then another function which will read two lines at a time and initialise a rover, reading the landing position then the movement commands as a char array or a single string which will be used to run through when it’s the rover’s turn.
- I now need to setup two classes RoverMovement and Rover which will contain most of the information until I get to the next parts of the code.
- I finished coding the 

## 6:46
- Having some issues running the code, troubles with intellij it is not recognising my file to run

## 7:07
- Fixed it needed to create a module forgot to do that
- Now that the setup process is done and I made sure it is setup correctly we need to run the rovers and return the final position outputs
- This will require additions to the Rover class where we need to include functions to execute each command, rotate, move one cell in the direction its facing, save the position after moving.
- Execute commands runs through each command R, L or M
- Rotate command needs to check which direction the rover is looking at and then rotate it appropriate to the command
- Then if it is to move then the rover in the direction it is looking at.

## 7:48
- Code is correctly returning the expected outputs for the initial test case
- We need to now account for the test cases that may have invalid commands
- Some of them may include
 - A rover might be trying to enter a grid cell which another rover may be sitting in as either last position of landing position. We don’t have traffic as a rover is run one after another.

## 7:52
- Just noticed last slide of the power point and only now accounting for the user input this means the initial structure of the rover movement must be changed.
- I need to take a quick break to eat I apologise for the gap in coding time I promise I am not thinking about the code while I do I am eating.

## 8:18
- Back from dinner
- Before coding the exception cases will need to adjust the input.
- To account for
 - either rovers falling off the plateau or
 - colliding with another rover that is stopped at its last location or
 - 	rover landing on another rover
-	We need to maintain a plateau grid to check if a rover is there or not
-	Done the input validation for the plateau because no particular instruction is given on how a false input needs to be dealt with I am letting the user enter inputs until they enter a correct one.
-	Need to amend the array of my rovers to a ArrayList due to how we need to dynamically change the number of rovers as user can enter 2 or 40 there is no limit. ArrayList will help us dynamically add more rovers as we need and deal with an overflow.

## 9:34
-	Added the functions to check all of the code that will take the inputs only if they are in the valid type and format now I will code the step where I check if the path is correct that is the only other invalid case that I cannot check until I simulate the path

## 9:57
-	Updated the Rover code to check if the move is valid so if the rover isn’t falling off the plateau by going out of bounds or the rover is not colliding with another rover in its path then the output of the last position is printed if not the rover is invalid and the user is asked to re-enter the path that is valid.
-	Because this is a very expensive project and the rovers cost a lot of time and money to make and then send to mars we reject any incorrect inputs and ensure only valid inputs are being passed to execute.
-	Will not run through some test cases and check this might take a while as I would need to come up with false test cases so I will try to write them down and purposefully make them collide or fall off so the program returns false.

## 10:36
-	Spent some time error checking and making sure everything is exactly how I wanted it to be. I have now I think finished fixing everything I need to.
-	Just another quick look at the code and I am ready to sent the email to Nikki.
