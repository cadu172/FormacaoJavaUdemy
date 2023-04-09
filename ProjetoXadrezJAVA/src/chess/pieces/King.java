package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean testRookCastling(Position position) {
		
		ChessPiece piece = chessMatch.getPieces()[position.getRow()][position.getColumn()];
		
		return (piece != null) && ( piece instanceof Rook) && (piece.getMoveCount()==0);
		
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
		
		
		/* Teste de Roque (mudanca entre o rei e as torres)
		 regras:
		 
		 OK-1 - Rei e torre sem nenhum movimento
		 OK 2 - Duas casas a direita do rei vazia se o roque for com a torre da direita (roque do rei)
		 OK 3 - Duas casas a esquerda do rei vazia se o roque for com a torre da esquerda (roque da rainha)
		 OK-4 - O rei nao pode estar em xeque
		 */
		if ( this.getMoveCount() == 0 && ! this.chessMatch.getCheck() ) {
			
			// teste do Roque do rei
			Position positionRookOfKing = new Position(this.position.getRow(), this.position.getColumn()+3);
			
			if ( this.testRookCastling(positionRookOfKing)  ) {
				
				Position p1 = new Position(this.position.getRow(), this.position.getColumn()+1); 
				Position p2 = new Position(this.position.getRow(), this.position.getColumn()+2);
				
				if (  !  (  getBoard().thereIsAPiece(p1) || getBoard().thereIsAPiece(p2)  )  ) {					
					arrayOfPossibleMoves[this.position.getRow()][this.position.getColumn()+2] = true;					
				}
				
			}
			
			
			// teste do Roque do rei
			Position positionRookOfQueen = new Position(this.position.getRow(), this.position.getColumn()-4);
			
			if ( this.testRookCastling(positionRookOfQueen)  ) {
				
				Position p1 = new Position(this.position.getRow(), this.position.getColumn()-1); 
				Position p2 = new Position(this.position.getRow(), this.position.getColumn()-2);
				Position p3 = new Position(this.position.getRow(), this.position.getColumn()-3);
				
				
				if (  !  (  getBoard().thereIsAPiece(p1) || getBoard().thereIsAPiece(p2) || getBoard().thereIsAPiece(p3)  )  ) {					
					arrayOfPossibleMoves[this.position.getRow()][this.position.getColumn()-2] = true;					
				}
				
			}			
			
			
		}

		
		return arrayOfPossibleMoves;
	}
}
