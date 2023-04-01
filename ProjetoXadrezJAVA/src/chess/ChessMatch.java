package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	private int turn;
	private List<ChessPiece> piecesOnTheBoard = new ArrayList<>();
	private List<ChessPiece> capturedPieces = new ArrayList<>();
	private boolean check = false;
	
	private Color currentPlayer;
	boolean checkMate;
	private ChessPiece enPassantVulnerable; 
	
	public ChessMatch() {		
		this.board = new Board(8, 8);
		this.InitialSetup();
		this.turn = 0;
		this.currentPlayer = Color.WHITE;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	private Color opponent(Color color) {
		return (color==Color.BLACK) ? Color.WHITE : Color.BLACK;
	}
	
	private ChessPiece king(Color color) {
		
		List<Piece> lista = piecesOnTheBoard.stream().filter(e -> e.getColor() == color).collect(Collectors.toList());
		
		for ( Piece item : lista ) {
			
			if ( item instanceof King ) {
				return (ChessPiece)item;
			}			
			
		}
		
		throw new BoardException("Nao foi encontrado o rei " + color + " no tabuleiro, impossivel continuar jogo ");
		
	}
	
	private boolean testCheck(Color color) {
		
		List<Piece> listaOpponent = piecesOnTheBoard.stream().filter(e -> e.getColor() == opponent(color)).collect(Collectors.toList());
		
		Position kingPosition = king(color).getChessPosition().toPosition();
		
		for (Piece piece : listaOpponent) {
			
			boolean[][] arrayOfPossibleMoves = piece.possibleMoves();
			
			if ( arrayOfPossibleMoves[kingPosition.getRow()][kingPosition.getColumn()]  )  {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public List<ChessPiece> getCapturedPieces() {
		return this.capturedPieces;
	}

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}
	
	public Board getBoard() {
		return board;
	}
	
	private void NextTurn() {
		this.turn++;
		this.currentPlayer = ( this.currentPlayer == Color.WHITE ) ? Color.BLACK : Color.WHITE;
	} 

	public ChessPiece[][] getPieces() {
		
		ChessPiece[][] piecesArray = new ChessPiece[board.getRows()][board.getColumns()];
		
		for ( int row=0; row<board.getRows(); row++ ) {
			for ( int col=0; col<board.getColumns(); col++ ) {
				piecesArray[row][col] = (ChessPiece)board.piece(row, col); 
			}
		}
		
		return piecesArray;
		
	}
	
	public boolean[][] possibleMovies(ChessPosition piecePosition) {		
		validateSourcePosition(piecePosition.toPosition());		
		return board.piece(piecePosition.toPosition()).possibleMoves();		
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) throws ChessException {
		
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		
		ChessPiece capturedPiece = (ChessPiece)this.MakeMove(source,target);
		
		if (  this.testCheck(currentPlayer) ) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("Movimento Ilegal - Voce nao pode se colocar em cheque");
		}
		
		this.check = this.testCheck(opponent(currentPlayer));
		
		this.NextTurn();
		
		return capturedPiece;
		
	}
	
	public ChessPiece replacePromotedPiece( String type) {
		return null;
	}
	
	public Piece MakeMove(Position source, Position target) {
		
		Piece captured = board.removePiece(target);
		Piece movedPiece = board.removePiece(source);
		
		if ( captured != null ) {
			this.piecesOnTheBoard.remove(captured);
			this.capturedPieces.add((ChessPiece)captured);
		}
		
		board.placePiece(movedPiece, target);
		
		return captured;
		

	}
	
	public void validateSourcePosition(Position sourcePosition) {
		if (  ! board.thereIsAPiece(sourcePosition) ) {
			throw new ChessException("Posicao informada nao possui uma peca");
		}
		
		if ( ! ( this.currentPlayer == ((ChessPiece)board.piece(sourcePosition)).getColor() ) ) {
			throw new ChessException("Eh a vez do jogador : " + this.currentPlayer.toString() );
		}
		
		if ( ! board.piece(sourcePosition).isThereAnyPossibleMove() ) {
			throw new ChessException("A peca selecionada nao pode de ser movida");
		}
		
	}
	

	
	public void validateTargetPosition(Position sourcePosition, Position targetPosition) { 
		
		if ( ! board.piece(sourcePosition).possibleMove(targetPosition)  ) {
			throw new ChessException("A peca selecionada nao pode de ser movida para a posicao de destino");		
		}
		
	}
	
	private void placePieceOnTheBoard ( ChessPiece piece, Position position  ) {
		
		board.placePiece(piece, position);
		
		this.piecesOnTheBoard.add(piece);
		
	}
	
	private void undoMove(Position source, Position target, Piece possibleCapturedPiece) {
		
		Piece movedPiece = board.removePiece(target);
		board.placePiece(movedPiece, source);
		
		if ( possibleCapturedPiece != null ) {
			board.placePiece(possibleCapturedPiece, target);
			capturedPieces.remove(possibleCapturedPiece);
			piecesOnTheBoard.add((ChessPiece)possibleCapturedPiece);
		}
		
		
	}
	
	
	/*
	 * Este método vai inicializar o tabuleiro com as peças nas posições iniciais do jogo*/
	public void InitialSetup() {
		this.placePieceOnTheBoard(new King(board, Color.BLACK), new ChessPosition('d', 8).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('c', 8).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('e', 8).toPosition());
		
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('d', 7).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('c', 7).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('e', 7).toPosition());		
		
		this.placePieceOnTheBoard(new King(board, Color.WHITE), new ChessPosition('d', 1).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('c', 1).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('e', 1).toPosition());

		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('d', 2).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('c', 2).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('e', 2).toPosition());		
		
	}

}
