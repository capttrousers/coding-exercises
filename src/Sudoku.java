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
	



	public boolean isValidSector(SudokuTile tile) {
		
		int value = tile.value;
		int tileRow = tile.row;
		int tileColumn = tile.column;
		
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
				if(row != tileRow && column != tileColumn && gameBoard.get(row).get(column).value == value) {
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
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN) {
			if(currentTile.row < 8) {
				currentTile.row++;
			}
		} else if(key == KeyEvent.VK_UP) {
			if(currentTile.row > 0) {
				currentTile.row--;
			}
		} else if(key == KeyEvent.VK_RIGHT) {
			if(currentTile.column < 8) {
				currentTile.column++;
			}
		} else if(key == KeyEvent.VK_DOWN) {
			if(currentTile.column > 0) {
				currentTile.column--;
			}
		}
		draw();
		
	}


	
	public static int getValue(){
		
		
		// if no value exists yet, return 0
		return 0;
	}
	
	public static void update(int row, int column, int newValue) {
		// store old value
		// insert new value
		// check row, column, sector for validity
		// if not insert old value
		// draw with message
		
	}
	
	public static boolean isSolved(){
		return false;
	}
	
	public static void draw(){
		
		String line = "";
		
		System.out.println();
		System.out.println();
		
		for(int row = 0; row < 9; row++) {
			line = "";
			for(int column = 0; column < 9; column++) {
				String spot = gameBoard.get(row).get(column).toString();
				if(currentTile.row == row && currentTile.column == column) {
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
		

//		//board is list of lists for rows/columns cells with location & sector
//		List<List<Integer>> sectors = new LinkedList<List<Integer>>();
//		
//		sectors.add(Arrays.toList(1,1,1,2,2,2,3,3,3));
//		sectors.add(Arrays.toList(1,1,1,2,2,2,3,3,3));
//		sectors.add(Arrays.toList(1,1,1,2,2,2,3,3,3));
//		sectors.add(Arrays.toList(4,4,4,5,5,5,6,6,6));
//		sectors.add(Arrays.toList(4,4,4,5,5,5,6,6,6));
//		sectors.add(Arrays.toList(4,4,4,5,5,5,6,6,6));
//		sectors.add(Arrays.toList(7,7,7,8,8,8,9,9,9));
//		sectors.add(Arrays.toList(7,7,7,8,8,8,9,9,9));
//		sectors.add(Arrays.toList(7,7,7,8,8,8,9,9,9));
//		
//		List<List<Integer>> board = new 
//		
//		for(int row = 0; row < 9; row++) {
//			for(int column = 0; column < 9; column++) {
//				board.add(Arrays.asList(row, column, sectors.get(row,column)));
//			}
//		}
		
		makeBoard();
		
		Scanner s = new Scanner(System.in);
		
		boolean playing = true;
		while(playing) {
		
			for(int i = 0; i < 50; i++) {
				System.out.println();
			}
			
			draw();
			
			
			String newValue = s.nextLine();
			if(newValue.length() == 1 && Character.isDigit(newValue.charAt(0))) {
				System.out.println("update tile @ row,column: " + currentTile.row + "," + currentTile.column + " to new value: " + newValue);
				try {
				    TimeUnit.SECONDS.sleep(1);
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
