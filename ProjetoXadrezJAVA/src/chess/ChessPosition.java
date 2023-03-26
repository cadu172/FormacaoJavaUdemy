package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;	
	
	public ChessPosition(char column, int row) {
		
		if ( ! ( column>='a' && column<='h' && row>=1 && row<=8 )  ) {
			throw new ChessException("Para a construcao do chessPosition informe valores entre [a..h] e [1..8]");
		}
		
		this.column = column;
		this.row = row;
	}

	protected Position toPosition() {
		return new Position(8-row, column-'a');
	}
	
	protected ChessPosition fromPostion(Position position) {
		return new ChessPosition((char)('a'+position.getColumn()),8-position.getRow() );
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	
	

}
