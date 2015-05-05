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
	Specifics about release scoring

———————
CODE USED FROM ELSEWHERE 
———————

In order to do file I/O, our group found code clippings from these sites that proved to be very helpful
http://examples.javacodegeeks.com/core-java/io/file/delete-file-in-java-example/
http://www.mkyong.com/java/how-to-write-an-object-to-file-in-java/
http://www.mkyong.com/java/how-to-read-an-object-from-file-in-java/
