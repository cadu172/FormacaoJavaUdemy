package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);		
	}

	@Override
	public boolean[][] possibleMoves() {
		
		if (  this.getColor()==Color.WHITE ) {
			return this.possibleMovesWHITE();
		}			
		else {
			return this.possibleMovesBLACK();
		}
		
	}
	
	@Override
	public String toString() {
		return "P";
	}		
	
	private boolean[][] possibleMovesWHITE() {
		
		boolean[][] arrayOfPossibleMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		
		Position auxiliar = new Position(0, 0);		
		
		if ( this.getMoveCount() == 0  ) {
			
			for (int i=1;i<=2; i++) {

				auxiliar.setValues(position.getRow()-i, position.getColumn());

				// peão não cosnsegue matar para frente, consegue somente se mover e não pode ter nenhuma peça na posição
				if ( getBoard().positionExists(auxiliar) ) {			
					if ( ! getBoard().thereIsAPiece(auxiliar) ) {
						arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;	
					}				
				}			
			
			}			
			
		}
		else {

			auxiliar.setValues(position.getRow()-1, position.getColumn());
			
			// peão não cosnsegue matar para frente, consegue somente se mover e não pode ter nenhuma peça na posição
			if ( getBoard().positionExists(auxiliar) ) {			
				if ( ! getBoard().thereIsAPiece(auxiliar) ) {
					arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;	
				}				
			}			
			
		}
		
		
		// testar para esquerda/superior
		auxiliar.setValues(position.getRow()-1, position.getColumn()-1);
		
		if ( getBoard().positionExists(auxiliar) ) {
			if ( this.isThereOponnentPiece(auxiliar) ) {
				arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;				
			}
		}
		
		// testar para direita/superior
		auxiliar.setValues(position.getRow()-1, position.getColumn()+1);
		
		if ( getBoard().positionExists(auxiliar) ) {
			if ( this.isThereOponnentPiece(auxiliar) ) {
				arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;				
			}
		}
		
		return arrayOfPossibleMoves;
		
	}

	private boolean[][] possibleMovesBLACK() {

		
		boolean[][] arrayOfPossibleMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
		
		Position auxiliar = new Position(0, 0);		
		
		if ( this.getMoveCount() == 0  ) {
			auxiliar.setValues(position.getRow()+2, position.getColumn());
		}
		else {
			auxiliar.setValues(position.getRow()+1, position.getColumn());
		}
		
		// peão não cosnsegue matar para frente, consegue somente se mover e não pode ter nenhuma peça na posição
		if ( getBoard().positionExists(auxiliar) ) {			
			if ( ! getBoard().thereIsAPiece(auxiliar) ) {
				arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;	
			}				
		}
		
		// testar para baixo/esquerda
		auxiliar.setValues(position.getRow()+1, position.getColumn()-1);
		
		if ( getBoard().positionExists(auxiliar) ) {
			if ( ( ! getBoard().thereIsAPiece(auxiliar)  ) || this.isThereOponnentPiece(auxiliar) ) {
				arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;				
			}
		}
		
		// testar para baixo/direita
		auxiliar.setValues(position.getRow()+1, position.getColumn()+1);
		
		if ( getBoard().positionExists(auxiliar) ) {
			if ( ( ! getBoard().thereIsAPiece(auxiliar)  ) || this.isThereOponnentPiece(auxiliar) ) {
				arrayOfPossibleMoves[auxiliar.getRow()][auxiliar.getColumn()] = true;				
			}
		}
		
		return arrayOfPossibleMoves;
	}


}
