package boardgame;

public abstract class Piece {
	
	protected Position position;
	private Board board;	
	
	
	public Piece(Board board) {
		super();
		this.board = board;
		this.position = null;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		
		boolean[][] arrayOfPosition = possibleMoves();
		
		for ( int i=0; i<this.getBoard().getRows(); i++ ) {
			for (int j=0; j<this.getBoard().getColumns(); j++) {
				if (  arrayOfPosition[i][j] ) {
					return true;
				}
			}
		}
		
		return false;
		
	}

	protected Board getBoard() {
		return board;
	}
	
	public void setPositionOnBoard(Position position) {
		this.position = position;
	}
	
	

}
