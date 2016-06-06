import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Sudoku implements KeyListener {

	public static List<List<SudokuTile>> gameBoard;
	public static SudokuTile currentTile;
	public static String message = "";


	
	public static boolean isValidRow(SudokuTile tile) {
		
		for(int row = 0; row < 9; row++) {
			if(tile.getValue() == gameBoard.get(row).get(tile.getColumn()).getValue() && row != tile.getRow()) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidColumn(SudokuTile tile) {
		
		for(int column = 0; column < 9; column++) {
			if(tile.getValue() == gameBoard.get(tile.getRow()).get(column).getValue() && column != tile.getColumn()) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidSector(SudokuTile tile) {
		
		int value = tile.getValue();
		int tileRow = tile.getRow();
		int tileColumn = tile.getColumn();
		
		// check the sector that has tile. 
		int startRow;
		int endRow;
		int startColumn;
		int endColumn;
		
		if(tileRow < 3) {
			startRow = 0;
			endRow = 2;
		} else if(tileRow < 6) {
			startRow = 3;
			endRow = 5; 
		} else {
			startRow = 6;
			endRow = 8;
		}
		if(tileColumn < 3) {
			startColumn = 0;
			endColumn = 2;
		} else if(tileColumn < 6) {
			startColumn = 3;
			endColumn = 5; 
		} else {
			startColumn = 6;
			endColumn = 8;
		}
		
		for(int row = startRow; row <= endRow; row++) {
			for(int column = startColumn; column <= endColumn; column++) {
				if(gameBoard.get(row).get(column).getValue() == value && row != tileRow && column != tileColumn) {
					return false;
				}
			}
		}
	
		
		return true;
	}
	
	
	public static void makeBoard() {
		gameBoard = new ArrayList<List<SudokuTile>>();
		for(int row = 0; row < 9; row++) {
			List<SudokuTile> list = new ArrayList<SudokuTile>();
			for(int column = 0; column < 9; column++) {
				list.add(new SudokuTile(row, column, 0));				
			}
			gameBoard.add(list);
		}
		currentTile = new SudokuTile(0, 0, 0);
		
		
	}
	
	public static int update(int row, int column, int newValue) {
		// store old value
		// insert new value
		// check row, column, sector for validity
		// if not insert old value
		// draw with message
		SudokuTile tile = gameBoard.get(row).get(column);
		int oldValue = tile.getValue();
		tile.setValue(newValue);
		
		if(isValidColumn(tile) && isValidRow(tile) && isValidSector(tile)) {
			message = "Game board successfully updated to new value " + newValue;
			return newValue;
		} else {
			tile.setValue(oldValue);
			message = "You must enter a valid entry for this tile";
			return oldValue;
		} 
	}
	
	// because the update method will only change the value if it's a valid entry
	// we can assume that at any point during the game loop before or after a call to update()
	// the game board will be valid. This means that we only need to check for a full board
	// ie: if all the values in the board are between 1 and 9.
	public static boolean isSolved(){
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(gameBoard.get(i).get(j).getValue() == 0) return false;
			}			
		}		
		return true;
	}
	
	public static void draw(){
		
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
		
		
		String line;
		
		System.out.println();
		System.out.println();
		
		for(int row = 0; row < 9; row++) {
			line = "";
			for(int column = 0; column < 9; column++) {
				String spot = Integer.toString(gameBoard.get(row).get(column).getValue());
				if(currentTile.getRow() == row && currentTile.getColumn() == column) {
					spot = "[" + spot + "]";
				} else {
					spot = " " + spot + " ";
				}
				line += spot + " ";
				if (column == 2 || column == 5) {
					line += "| ";
				}
			}
			
			System.out.println(line);
			System.out.println();	
			
			if(row == 2 || row == 5) {
				line = "------------|-------------|-----------";
				System.out.println(line);
				System.out.println();	
			}
		}
		
		System.out.println();		
		System.out.println("Move to different locations with the directional pad, \nand type the correct value and press enter: ");
	}
	
	
	
	
	public static void main(String[] args) {
			
		makeBoard();
		
		Scanner s = new Scanner(System.in);
		
		boolean playing = true;
		while(playing) {
		
			draw();
				
			String newValue = s.nextLine();
			if(newValue.length() == 1 && Character.isDigit(newValue.charAt(0))) {
				System.out.println("update tile @ row,column: " + currentTile.getRow() + "," + currentTile.getColumn() + " to new value: " + newValue);
				System.out.println("Value after update: " + update(currentTile.getRow(), currentTile.getColumn(), Character.getNumericValue(newValue.charAt(0))));
				System.out.println(message);
				try {
				    TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			} else {
				s.nextLine();
			}
			
			if(isSolved()) {
				playing = false;
			}
		}

		s.close();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
			if(currentTile.getRow() < 8) {
				currentTile.setRow(currentTile.getRow() + 1);
			}
		} else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
			if(currentTile.getRow() > 0) {
				currentTile.setRow(currentTile.getRow() - 1);
			}
		} else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
			if(currentTile.getColumn() < 8) {
				currentTile.setColumn(currentTile.getColumn() + 1);
			}
		} else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
			if(currentTile.getColumn() > 0) {
				currentTile.setColumn(currentTile.getColumn() - 1);
			}
		}
		draw();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
