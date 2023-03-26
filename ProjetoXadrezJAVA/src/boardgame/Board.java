package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public Piece piece(int row, int column) {
		return this.pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if ( positionExists(position) ) {
			return this.pieces[position.getRow()][position.getColumn()];
		}
		return null;
	}	

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public boolean positionExists(Position position) {
		
		int row = position.getRow();
		int column = position.getColumn();
		
		if ( ! ( row>=0 && row<this.rows && column>=0 && column<this.columns )  ) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		
		return true;
		
	}
	
	public boolean thereIsAPiece(Position position) {
		
		if ( positionExists(position) ) {
			
			int row = position.getRow();
			int column = position.getColumn();
			
			return this.pieces[row][column] != null;
			
		}
		
		return false;
		
	}

}
