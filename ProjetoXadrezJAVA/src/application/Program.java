package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ChessMatch chessMatch = new ChessMatch();
		
		for(;;) {
			
			
			UI.printBoard(chessMatch.getPieces(), chessMatch.getBoard());
			
			
			System.out.println();
			System.out.println();
			System.out.print("Digite a Posicao de Origem: ");
			ChessPosition source = UI.readChessPosition(scan);
			
			System.out.println();			
			System.out.print("Digite a Posicao de Destino: ");
			ChessPosition target = UI.readChessPosition(scan);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);			

			
		}
		
		
	}

}
