package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		for(;;) {
			
			try {
			
				UI.clearScreen();
				UI.printMatch(chessMatch, chessMatch.getBoard());
				System.out.println();
				System.out.println();
				System.out.print("Digite a Posicao de Origem: ");
				ChessPosition source = UI.readChessPosition(scan);
				
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), chessMatch.getBoard(),chessMatch.possibleMovies(source));
				
				System.out.println();			
				System.out.print("Digite a Posicao de Destino: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				//teste
			
			}
			catch(ChessException e) {
				
				System.out.println();
				System.out.println("Erro: " + e.getMessage());
				scan.nextLine();
				
			}			
			catch(InputMismatchException e) {
				
				System.out.println();
				System.out.println("Erro: " + e.getMessage());
				scan.nextLine();
				
			}

			
		}
		
		
	}

}
