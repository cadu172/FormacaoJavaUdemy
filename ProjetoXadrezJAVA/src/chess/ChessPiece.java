package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;
	private int moveCount = 0;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected void increaseMoveCount() {
		this.moveCount++;
	}
	
	protected void decreaseMoveCount() {
		this.moveCount++;
	}
	
	public int getMoveCount() {
		return this.moveCount;
	}
	
	protected boolean isThereOponnentPiece(Position position) {
		ChessPiece selectedPiece = (ChessPiece)this.getBoard().piece(position);
		
		if ( selectedPiece != null ) {
			if ( selectedPiece.color != color ) {
				return true;
			}
		}
		return false;		
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPostion(position);
	}

	
}
