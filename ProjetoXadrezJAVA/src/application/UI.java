package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import boardgame.Board;
import boardgame.Piece;
import chess.ChessException;
import chess.ChessMatch;
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
				printPiece(pieces[row][col], false);
			}
			
			System.out.println();		
		}
		
		System.out.print("  A B C D E F G H");
		
	}
	
	//public static void printBoard(ChessPiece[][] pieces, Board board, boolean[][] arrayOfPossibleMoves) {
	public static void printBoard(ChessMatch chessMatch, ChessPosition source) {
		
		ChessPiece pieces[][] = chessMatch.getPieces();
		boolean[][] arrayOfPossibleMoves = chessMatch.possibleMovies(source);
		
		for ( int row=0; row<chessMatch.getBoard().getRows(); row++ ) {
			
			System.out.print((8-row)+ " ");
			
			for ( int col=0; col<chessMatch.getBoard().getColumns(); col++ ) {
				printPiece(pieces[row][col], arrayOfPossibleMoves[row][col]);
			}
			
			System.out.println();		
		}
		
		System.out.print("  A B C D E F G H");
		
	}	
	
	public static void printPiece(ChessPiece piece, boolean printBackground) {
		
		
		if (printBackground) {
			System.out.print(ANSI_RED_BACKGROUND);
		}
		
		if ( piece == null ) {
			System.out.print("-" + ANSI_RESET + " ");
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
	
	public static void printMatch(ChessMatch partidaDeXadrez) {
		
		printBoard(partidaDeXadrez.getPieces(), partidaDeXadrez.getBoard());
		
		printCapturedPieces(partidaDeXadrez.getCapturedPieces());
		
		System.out.println();
		System.out.println();
		System.out.println("Turno: " + partidaDeXadrez.getTurn());
		
		if ( partidaDeXadrez.getCheck() ) {
			
			System.out.println("CHECKMATE!");
			System.out.println("VENCEDOR: " + partidaDeXadrez.getCurrentPlayer());
		
		}
		else {
		
			System.out.println("Aguardando jogador: " + partidaDeXadrez.getCurrentPlayer());
			
			if( partidaDeXadrez.getCheck() ) {
				System.out.println("Rei em CHECK!");
				
			}
		
		}
		
	}
	
	public static void printCapturedPieces(List<ChessPiece> capturedPiece) {
		
		List<ChessPiece> white = capturedPiece.stream().filter(e -> e.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> black = capturedPiece.stream().filter(e -> e.getColor() == Color.BLACK).collect(Collectors.toList());
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Pecas Capturadas");
		System.out.print("WHITE: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(white.toArray()));	
		System.out.print(ANSI_RESET);
		System.out.print("BLACK: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(black.toArray()));	
		System.out.print(ANSI_RESET);

	
	}
	
	
}
