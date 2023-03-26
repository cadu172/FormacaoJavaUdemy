package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		
		if (  ! ( rows==8 && columns==8  ) ) {
			throw new BoardException("O Tabuleiro do Xadrez requer 8 linhas e 8 colunas");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public boolean positionExists(int row, int column) {
		return ( row>=0 && row<this.rows && column>=0 && column<this.columns );
	}

	public boolean positionExists(Position position) {
		return this.positionExists(position.getRow(),position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if ( ! this.positionExists(position)  ) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return this.piece(position) != null;
	}	
	
	public Piece piece(int row, int column) {
		if ( ! this.positionExists(row,column)  ) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return this.pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return this.piece(position.getRow(),position.getColumn());
	}
	
	public void placePiece(Piece piece, Position position) {
		if ( this.thereIsAPiece(position) ) {
			throw new BoardException("Posicao selecionada ja possui uma peca");
		}
		this.pieces[position.getRow()][position.getColumn()] = piece;
		piece.setPositionOnBoard(position); 
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	

}
