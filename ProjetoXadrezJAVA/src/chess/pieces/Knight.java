package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color); 
	}

	@Override
	public String toString() {
		return "N";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] arrayOfPossibleMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		
		Position posicaoAux = new Position(0, 0);		
		
		/* --------------- CIMA */
		posicaoAux.setValues(position.getRow()-2, position.getColumn()-1);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------


		// --------------- CIMA		
		posicaoAux.setValues(position.getRow()-2, position.getColumn()+1);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------
		
		
		
		// --------------- BAIXO		
		posicaoAux.setValues(position.getRow()+2, position.getColumn()-1);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------


		// --------------- BAIXO		
		posicaoAux.setValues(position.getRow()+2, position.getColumn()+1);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------		
		
		
		
		
		
		
		
		// --------------- ESQUERDA		
		posicaoAux.setValues(position.getRow()-1, position.getColumn()-2);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------


		// --------------- ESQUERDA		
		posicaoAux.setValues(position.getRow()+1, position.getColumn()-2);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------	
		
		
		
		// --------------- DIREITA		
		posicaoAux.setValues(position.getRow()-1, position.getColumn()+2);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------


		// --------------- DIREITA		
		posicaoAux.setValues(position.getRow()+1, position.getColumn()+2);
		
		// caso seja uma posição valida e na posição esteja um adversário
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}
		// ------------------------------------------------------------------------			
		
		
		
		
						
		

		return arrayOfPossibleMoves;
	}	
	
	
}
