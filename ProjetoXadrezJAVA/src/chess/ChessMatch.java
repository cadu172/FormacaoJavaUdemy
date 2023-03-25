package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {		
		this.board = new Board(8, 8);
		this.InitialSetup();
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
	
	/*
	 * Este método vai inicializar o tabuleiro com as peças nas posições iniciais do jogo*/
	public void InitialSetup() {
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new Rook(board, Color.BLACK), new Position(0, 0));
		board.placePiece(new Rook(board, Color.BLACK), new Position(0, 7));
		
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
		board.placePiece(new Rook(board, Color.WHITE), new Position(7, 0));
		board.placePiece(new Rook(board, Color.WHITE), new Position(7, 7));

	}

}
