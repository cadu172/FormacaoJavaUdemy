package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color); 
	}
	
	@Override
	public String toString() {
		return "K";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		// gera uma matriz com as colunas e linhas do tabuleiro
		boolean[][] arrayOfPossibleMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];		
		
		Position posicaoAux = new Position(0, 0);		
		
		// testar para cima
		posicaoAux.setValues(position.getRow()-1, position.getColumn());
		
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}				
		}		
		
		// testar para baixo
		posicaoAux.setValues(position.getRow()+1, position.getColumn());
		
		if ( getBoard().positionExists(posicaoAux) ) {	
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;				
			}
		}
		
		// testar para esquerda
		posicaoAux.setValues(position.getRow(), position.getColumn()-1);
		
		if ( getBoard().positionExists(posicaoAux) ) {			
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;	
			}							
		}
		
		// testar para esquerda/superior
		posicaoAux.setValues(position.getRow()-1, position.getColumn()-1);
		
		if ( getBoard().positionExists(posicaoAux) ) {
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;				
			}
		}
		
		// testar para esquerda/inferior
		posicaoAux.setValues(position.getRow()+1, position.getColumn()-1);
		
		if ( getBoard().positionExists(posicaoAux) ) {
			if ( ( ! getBoard().thereIsAPiece(posicaoAux)  ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;				
			}
		}			
		
		// testar para direita
		posicaoAux.setValues(position.getRow(), position.getColumn()+1);
		
		if ( getBoard().positionExists(posicaoAux)  ) {
			if ( ( ! getBoard().thereIsAPiece(posicaoAux) ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;				
			}
		}
		
		// testar para direita/superior
		posicaoAux.setValues(position.getRow()-1, position.getColumn()+1);
		
		if ( getBoard().positionExists(posicaoAux)  ) {
			if ( ( ! getBoard().thereIsAPiece(posicaoAux) ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
			}
		}			
		
		// testar para direita/inferior
		posicaoAux.setValues(position.getRow()+1, position.getColumn()+1);
		
		if ( getBoard().positionExists(posicaoAux) ) {
			if ( ( ! getBoard().thereIsAPiece(posicaoAux) ) || this.isThereOponnentPiece(posicaoAux) ) {
				arrayOfPossibleMoves[posicaoAux.getRow()][posicaoAux.getColumn()] = true;
			}
		}			

		
		return arrayOfPossibleMoves;
	}
}
