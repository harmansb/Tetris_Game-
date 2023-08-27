# Tetris_Game-
A GUI based Java Tetris game made using SWING class. A player has to form complete rows at the bottom of the game board by moving and rotating falling geometric shapes. The score is continuously updated and displayed on the screen and the highest score is saved
................................................................................................................................xxxxxx......................................................................................................................................

Tetris Game Project in Java:

This is a Tetris game project built using Swing and AWT in Java. The project is organized into two packages: Tetris and TetrisBlocks, containing classes with functions that handle the game's mechanics, such as spawning blocks, moving blocks, rotating blocks, checking collisions, clearing lines, and drawing the game area.


Installation:

To run the game, you need to have Java Development Kit (JDK) installed on your machine. You can download the latest version of JDK from Oracle's website.
Once you have installed the JDK, you can download all the files from java folder.Java folder contains two packages tetris and tetrisblocks.Import all the classes to your IDE and run the file GameForm.java


Usage:
This will start the game and display the game window. You can use the following keys to control the game:

Left Arrow Key- Move the block to the left

Right Arrow Key- Move the block to the right

Up Arrow Key- Rotate the block clockwise

Down Arrow Key- Drop the block to bottom

The goal of the game is to stack the blocks and create complete horizontal lines. When a complete line is formed, it will be removed from the game area, and the player will earn points. The game ends when the blocks reach the top of the game area.


Challenges:

Working on this Tetris game project in Java may present some challenges, especially for beginner programmers. Some of the possible challenges include:
Working with new IDE and unfamiliar graphic controls: If you are new to Java development or have not worked with Swing and AWT before, you may find it challenging to navigate the IDE and understand the graphic controls used in this project.

Managing threads: The game loop in this project runs on a separate thread to ensure smooth animation and user interaction. Managing threads can be challenging, especially when dealing with concurrency issues such as synchronization and deadlock.

Generating logic to build new shapes: Adding new shapes to the game requires generating the logic to build them, which can be challenging, especially for complex shapes with multiple rotations.
Rotating shapes, especially "I" shape: Rotating the "I" shape block can be challenging, as it requires handling multiple rotations and ensuring that the block does not go out of bounds or overlap with other blocks.
Handling exceptions: Like any software project, this Tetris game project may encounter errors and exceptions that need to be handled gracefully. It is essential to have good error handling practices in place to ensure that the game remains stable and does not crash unexpectedly.


Future Enhancements:

This project can be extended and customized in various ways, such as:
Adding new game modes, such as time trial or endless mode
Increasing the difficulty level by increasing the game speed or reducing the block size
Improving the graphics and sound effects to enhance the user experience
Adding multiplayer functionality to allow players to compete against each other
