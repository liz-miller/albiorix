READ ME
———————
Group: Albiorix
Members: Alex Bittle, William Moore, Sean McCrone, Liz Miller, & Nathaniel Mahowald

———————
RUNNING THE GAME
———————
	The main method for our implementation of Sixes Wild is in the LaunchGUI.java file in the source folder. The packages that should exist are boundary, controller, and model. The game is delivered with levels in the level folder in the SixesWildGame folder. The game is delivered with a blank score folder. IF THAT FOLDER DOESN’T EXIST IT WILL NEED TO BE ADDED, next to level, titled “score”. Finally, our implementation of the “elimination” game type counts up in moves, but down in stars. This was a design decision we made to add some variety to the game, and it still limits the player because the player cannot move on past the level if they do not have at least one star, which could be true if they spend too much time on elimination. Stars are determined by the number of moves used.

———————
TESTING THE GAME
———————

	The test cases for the game are housed in the test folder, and can be run with the ecclema code coverage plugin. IMPORTANT: test case running will clear score progress, level unlocking will not be retained after test cases are run. A “score” folder is also required to run the test cases, so make sure that exists. Also, as we use “robot” to take the mouse for one of our cases, it helps to make sure not to touch the mouse while running the test cases. 

———————
THE LEVEL BUILDER(S)
———————

	Our group had two pseudo level builders because of a divide. One, created by Liz, is included in our submission. The main method can be found in the view/LevelBuilder.java file and executed from the main method in that file. The second level builder (the one that the rest of the group used to run and test code and to build our actual gameplay levels) is code-based, in the default package of our game, in LevelBuilder.java. This builder is executed using the main method in the file. A brief guide on our level builder:
	type determines the level type
	num determines the level number
	starThresholds determines the thresholds for the stars (for 1, 2 and 3)
	multWeight determines the probabilities for the mult weights (for 1, 2, and 3)
	valWeight determines the probabilities for the values (for 1 through 6)
	The first element in the constructors for Lightning, Release and Puzzle determines the number of moves
	The 5th and 6th elements (the threes) determine the number of eliminate tiles and swap tiles respectively
	the l.getBoard().setSquare(new Square(i,j,1)); method is used to set an inert square at (i,j)
	the l.getBoard().setSquare(new Square(i,j,2)); method is used to set a goal square at (i,j) in release levels
	the l.getBoard().setSquare(new Square(i,j,6,1)); method is used to set a 6 square at (i,j) in release levels
These changes can be used to make any level imaginable, simply compile and run LevelBuilder.java.


———————
CODE USED FROM ELSEWHERE 
———————

In order to do file I/O, our group found code clippings from these sites that proved to be very helpful
http://examples.javacodegeeks.com/core-java/io/file/delete-file-in-java-example/
http://www.mkyong.com/java/how-to-write-an-object-to-file-in-java/
http://www.mkyong.com/java/how-to-read-an-object-from-file-in-java/
