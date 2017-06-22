/*
* [Life].java
* Author: [Austin Wilburn]
* Submission Date: [10/10/2014]
*
* Purpose: The program is a grid of black and white cells 
* representing dead or alive, respectively. First it randomizes 
* the color of each individual cell using loops and then based 
* on those values updates the next generation of cells based upon 
* the previous color values and its neighbors color values. 
* 
*
*/

//importing the random class to generate random numbers
import java.util.Random;
public class Life {
	public static void main(String[] args) {
		//declaring the integers needed
		int gridSize, cellSize, aliveColor, deadColor, colCount, rowCount, cellValue, aliveNeighbors;
		//setting the grid and cell size
		gridSize = 200;
		cellSize = 3;
		//creating the grid and calling it from the jar file with proper inputs
		Grid grid = new Grid(gridSize, cellSize, "The Game of Life");
		//setting delay between generations
		grid.setDelay(10);
		//setting aliveColor to 1 and deadColor to 2
		aliveColor = 1;
		deadColor = 0;
		//creating a new random variable from the random class
		Random r = new Random();
		//creating a for loop to start at column 0 and increase at every loop
	
		for(colCount = 0; colCount <= (gridSize - 1);colCount++) {
			//creating a for loop to start a row 0 and increase at every loop
			for(rowCount = 0; rowCount <= (gridSize - 1); rowCount++) {
				//setting the value at (row,column) to a random value either 0 or 1
				grid.setPos(rowCount, colCount, r.nextInt(2));
			}
		}
		//update and initialize the grid to store the starting values
		grid.update();
		grid.initialize();
		//while true loop to infinitely loop
		while(true) {
			//creating a for loop to start at column 0 and increase at every loop
			for(colCount = 0; colCount <= (gridSize - 1); colCount++) {
				//creating a for loop to start a row 0 and increase at every loop
				for(rowCount = 0; rowCount <= (gridSize - 1); rowCount++) {
					//gets the value either 0 or 1 of the cell
					cellValue = grid.getPos(rowCount, colCount);
					//gets the number of alive neighbor cells in respect to the cell
					aliveNeighbors = grid.matchingNeighbors(rowCount, colCount, aliveColor);
					//if statement, if cell is alive and has 2 or 3 alive neighbors, it stays alive
					if(cellValue == aliveColor && (aliveNeighbors == 2 || aliveNeighbors == 3));
					//else if, if cell is dead and has 3 alive neighbors, it lives
					else if(cellValue == deadColor && aliveNeighbors == 3) {
						//setting the cell to alive
						grid.setPos(rowCount, colCount, aliveColor);
					}
					//otherwise
					else {
						//setting the cell to dead
						grid.setPos(rowCount, colCount, deadColor);
					}
				}
			}
			//updating the grid after all cells have new values
			grid.update();
			//setting column and row back to 0 for when it loops again
			colCount = 0;
			rowCount = 0;
			}
		}
	}
		
	
	


