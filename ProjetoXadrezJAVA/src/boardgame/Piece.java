package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;	
	
	
	public Piece(Board board) {
		super();
		this.board = board;
		this.position = null;
	}

	public boolean[][] possibleMoves() {
		
		boolean[][] movies;
		
		movies = new boolean[1][1];
	
		return movies;
		
	}
	
	public boolean possibleMove(Position position) {
		return false;
	}
	
	public boolean isThereAnyPossibleMove() {
		return true;
	}

	protected Board getBoard() {
		return board;
	}
	
	public void setPositionOnBoard(Position position) {
		this.position = position;
	}
	
	

}
