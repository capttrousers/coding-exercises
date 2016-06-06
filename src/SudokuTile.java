
public class SudokuTile {

	
	
	
	private int value;
	
	private int row;
	private int column;

	public SudokuTile(int row, int column, int value) {
		this.setRow(row);
		this.setColumn(column);
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
