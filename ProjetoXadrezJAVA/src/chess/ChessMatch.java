package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {		
		this.board = new Board(8, 8);
	}
	
	

	public Board getBoard() {
		return board;
	}



	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] piecesArray = new ChessPiece[board.getRows()][board.getColumns()];
		
		for ( int row=0; row<board.getRows(); row++ ) {
			for ( int col=0; col<board.getColumns(); col++ ) {
				piecesArray[row][col] = (ChessPiece)board.piece(row, col); 
			}
		}
		
		return piecesArray;
		
	}

}
