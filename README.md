# COMP2042_CW_efyzw5
The following describes the details of the coursework that was assigned to in the module COMP2042 of the University of Nottingham Malaysia. The code was entirely done by student 20316558, Wong Zhen Lin. 

## Steps For Compilation(For IntelliJ users):
- if JavaFX is not installed
1. Download javaFX from the site https://gluonhq.com/products/javafx/  
2. Extracted the download folder to your directory of choice
3. Open IntelliJ and go to the navigation bar -> File -> Project structure -> Project -> SDK and select SDK version 17 or higher
4. Click on “Libraries” -> “+” sign -> Java and direct it to the directory of the extracted folder.
5. Click on “lib” then click ok.
6. Exit project structure and go to the main class. Build and run the code.

## JavaDoc location
COMP2042_CW_efyzw5-main\src\src\main\resources\com\example\demo\JavaDoc

## Features that are successfully implemented
- new features
1. An easter egg that can be activated in the main menu by pressing the keys “doge” in that order.
2. Music that plays in the background for Easter Egg and sound effect for activation of easter egg.
3. A start button that takes the user to the profile select screen.
4. A profile screen with preloaded profiles in a choice box that the user is able to choose from and a button to take the user to the mode select screen.
5. A mode select screen that is able to allow the user to choose the size of the playing field and a button for switching to the game scene.
6. Easter Egg modifies the game (by changing the graphics of each filled cell into a gif) when activated in the start menu.
7. Several new visual elements like a new background and a revamped score board.
8. A win condition that changes the text on the end game screen.
9. A high score indicator which lets the user know when a new high score is set.
10. Tile colours have been changed to the original 2048 colour scheme.
11. The ability for users to input new accounts has been added 
- Bug fixes
12. Score is now based on the number of merges per move.
13. Cells are only filled with values if a move is not a static move.
14. Positioning of the cells and Scoreboard have been changed.
15. Score does not increment on every button press now.
16. Win condition does not require the entire board to be filled anymore.
- Features not fully implemented
17. The account scene is not implemented due to the resources required would make the whole structure too complex and that it would be redundant as there wouldn't be much to display.
- List of new classes
18. sceneController
19. getProfileSceneController
20. mainMenuController
21. modeSelectSceneController
22. endGameVisuals
23. highScore
24. generalMovement
25. stateChecker
26. tileChecker
27. tileMovement
28. gameVisuals
29. Observer
30. Subject 
31. themeSelectController
- Classes that were modified
32. EndGame
33. GameScene
34. Cell
35. Main
36. TextMaker
37. Controller


