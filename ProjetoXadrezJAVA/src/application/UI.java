package application;

import boardgame.Board;
import boardgame.Piece;
import chess.ChessPiece;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces, Board board) {
		
		for ( int row=0; row<board.getRows(); row++ ) {
			
			System.out.print((8-row)+ " ");
			
			for ( int col=0; col<board.getColumns(); col++ ) {
				printPiece(pieces[row][col]);
			}
			
			System.out.println();		
		}
		
		System.out.print("  A B C D E F G H");
		
	}
	
	public static void printPiece(Piece piece) {
		if ( piece == null ) {
			System.out.print("- ");
		}
		else {
			System.out.print(piece + " ");
		}		
	}
	
	
}
