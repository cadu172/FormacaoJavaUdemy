package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		while( ! chessMatch.getCheckMate()) {
			
			try {				
				
				UI.clearScreen();
				UI.printMatch(chessMatch);
				System.out.println();
				System.out.println();
				System.out.print("Digite a Posicao de Origem: ");
				ChessPosition source = UI.readChessPosition(scan);
				
				UI.clearScreen();				
				UI.printBoard(chessMatch,source);
				
				System.out.println();			
				System.out.print("Digite a Posicao de Destino: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				//ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				// no exemplo do professor ele armazena a peça capturada na calsse "UI", mantive essa responsabilidade para a classe chessMatch
				chessMatch.performChessMove(source, target);
							
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
		
		UI.clearScreen();
		UI.printMatch(chessMatch);	
	
	}

}
