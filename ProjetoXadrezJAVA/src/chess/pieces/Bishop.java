package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
	
	public Bishop(Board board, Color color) {
		super(board, color); 
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] arrayOfPossibleMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		
		Position posicaoAux = new Position(0, 0);		
		
		// --------------- Movendo-se PARA CIMA E ESQUERDA		
		posicaoAux.setValues(position.getRow()-1, position.getColumn()-1);
		
		// se a posição existe no tabuleiro e a posição informada não tem nenhuma peça
		while ( getBoard().positionExists(posicaoAux) && ( ! getBoard().thereIsAPiece(posicaoAux) ) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
			posicaoAux.setRow(posicaoAux.getRow()-1);
			posicaoAux.setColumn(posicaoAux.getColumn()-1);
		}
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) && this.isThereOponnentPiece(posicaoAux) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
		}
		// ------------------------------------------------------------------------

		
		// --------------- Movendo-se PARA CIMA E DIREITA		
		posicaoAux.setValues(position.getRow()-1, position.getColumn()+1);
		
		// se a posição existe no tabuleiro e a posição informada não tem nenhuma peça
		while ( getBoard().positionExists(posicaoAux) && ( ! getBoard().thereIsAPiece(posicaoAux) ) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
			posicaoAux.setRow(posicaoAux.getRow()-1);
			posicaoAux.setColumn(posicaoAux.getColumn()+1);
		}
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) && this.isThereOponnentPiece(posicaoAux) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
		}
		// ------------------------------------------------------------------------		
	

		// --------------- Movendo-se PARA BAIXO E ESQUERDA		
		posicaoAux.setValues(position.getRow()+1, position.getColumn()-1);
		
		// se a posição existe no tabuleiro e a posição informada não tem nenhuma peça
		while ( getBoard().positionExists(posicaoAux) && ( ! getBoard().thereIsAPiece(posicaoAux) ) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
			posicaoAux.setRow(posicaoAux.getRow()+1);
			posicaoAux.setColumn(posicaoAux.getColumn()-1);
		}
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) && this.isThereOponnentPiece(posicaoAux) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
		}
		// ------------------------------------------------------------------------		
		

		// --------------- Movendo-se PARA BAIXO E DIREITA		
		posicaoAux.setValues(position.getRow()+1, position.getColumn()+1);
		
		// se a posição existe no tabuleiro e a posição informada não tem nenhuma peça
		while ( getBoard().positionExists(posicaoAux) && ( ! getBoard().thereIsAPiece(posicaoAux) ) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
			posicaoAux.setRow(posicaoAux.getRow()+1);
			posicaoAux.setColumn(posicaoAux.getColumn()+1);
		}
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) && this.isThereOponnentPiece(posicaoAux) ) {
			arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
		}
		// ------------------------------------------------------------------------				
		

		
		return arrayOfPossibleMoves;
	}	

}
