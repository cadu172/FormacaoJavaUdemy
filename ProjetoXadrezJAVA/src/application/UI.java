package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static ChessPosition readChessPosition(Scanner scan) {
		
		try {
			
			String str = scan.nextLine();
			
			char column = str.charAt(0);
			int row = Integer.parseInt(str.substring(1));			
			
			return new ChessPosition(column, row);		
		}
		catch (ChessException e) {
			
			throw new InputMismatchException(e.getMessage());
		}
		catch (RuntimeException e) {
			
			throw new InputMismatchException("Posicao da peca invalida, informe valores entre A1 e H8");
		}
		
	}
	
	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}	
	
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
	
	public static void printPiece(ChessPiece piece) {
		if ( piece == null ) {
			System.out.print("- ");
		}
		else {
			
			if( piece.getColor() == Color.WHITE ) {
				
				System.out.print(ANSI_WHITE + piece + ANSI_RESET + " ");
				
			}
			else {
				
				System.out.print(ANSI_YELLOW + piece + ANSI_RESET + " ");
				
			}
			
		}		
	}
	
	
}
