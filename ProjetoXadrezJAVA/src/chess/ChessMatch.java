package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	private int turn;
	private List<ChessPiece> piecesOnTheBoard = new ArrayList<>();
	private List<ChessPiece> capturedPieces = new ArrayList<>();
	private boolean check = false;
	private boolean checkMate = false;
	private ChessPiece enPassantVulnerable;
	private ChessPiece promoted;	
	
	private Color currentPlayer; 
	
	public ChessMatch() {		
		this.board = new Board(8, 8);
		this.InitialSetup();
		this.turn = 0;
		this.currentPlayer = Color.WHITE;
	}
	
	public ChessPiece getEnPassantVulnerable() {
		return enPassantVulnerable;
	}
	
	public ChessPiece getPromoted() {
		return promoted;
	}	
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return this.checkMate;
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
		
		List<Piece> opponentList = piecesOnTheBoard.stream().filter(e -> e.getColor() == opponent(color)).collect(Collectors.toList());
		
		Position kingPosition = king(color).getChessPosition().toPosition();
		
		for (Piece piece : opponentList) {
			
			boolean[][] arrayOfOpponentMoves = piece.possibleMoves();
			
			// se o movimento atual colocar o rei em check, retornar true
			if ( arrayOfOpponentMoves[kingPosition.getRow()][kingPosition.getColumn()]  )  {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	private boolean testCheckMate(Color color) 
	{
		/*
		 * Regra: tentar mover todas as peças do meu adversário até encontrar uma peça que retire o Rei do Check
		 * Caso não seja possível é necessário declarar o checkMate
		 * */
		List<Piece> listaPecas = piecesOnTheBoard.stream().filter(e -> e.getColor() == color).collect(Collectors.toList());
		
		for (Piece piece : listaPecas) {
			
			boolean[][] arrayOfPossibleMoves = piece.possibleMoves();
			
			for(int i=0;i<arrayOfPossibleMoves.length;i++) {
				
				for(int j=0;j<arrayOfPossibleMoves.length;j++) {
					
					if(arrayOfPossibleMoves[i][j]) {
						
						Position origem = ((ChessPiece)piece).getChessPosition().toPosition();
						Position destino = new Position(i, j);
						
						Piece capturada = MakeMove(origem, destino);
						
						boolean estaEmCheque = testCheck(color);
						
						undoMove(origem, destino, capturada);
						
						if (  ! estaEmCheque ) {
							return false;
						}
						
					}
				
				}
			
			}
		
		}
		
		return true;		
		
		
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
		
		Color opponentPlayer = opponent(currentPlayer);
		
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		
		ChessPiece capturedPiece = (ChessPiece)this.MakeMove(source,target);
		
		if (  this.testCheck(currentPlayer) ) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("Movimento Ilegal - Voce nao pode se colocar em cheque");
		}
		
		
		ChessPiece movedPiece = (ChessPiece)board.piece(target);			
		
		// #specialmove promotion
		promoted = null;
		
		if (movedPiece instanceof Pawn) {
			if ((movedPiece.getColor() == Color.WHITE && target.getRow() == 0) || (movedPiece.getColor() == Color.BLACK && target.getRow() == 7)) {
				promoted = (ChessPiece)board.piece(target);
				promoted = replacePromotedPiece("Q");
			}
		}		
		
		// verificar se meu oponente está em check
		this.check = this.testCheck(opponentPlayer);
		
		// verificar se meu oponente está em checkMate
		if ( this.testCheckMate(opponentPlayer) ) {
			this.checkMate = true;
		}
		else {
			this.NextTurn();
		}

		
		// en passant no evento de movimento
		if (movedPiece instanceof Pawn && (target.getRow() == source.getRow() - 2 || target.getRow() == source.getRow() + 2)) {
			enPassantVulnerable = movedPiece;
		}
		else {
			enPassantVulnerable = null;
		}		
		
		return capturedPiece;
		
	}
	
	
	private ChessPiece newPiece(String type, Color color) {
		if (type.equals("B")) return new Bishop(board, color);
		if (type.equals("N")) return new Knight(board, color);
		if (type.equals("Q")) return new Queen(board, color);
		return new Rook(board, color);
	}
	
	
	
	public ChessPiece replacePromotedPiece(String type) {
		if (promoted == null) {
			throw new IllegalStateException("There is no piece to be promoted");
		}
		if (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
			return promoted;
		}
		
		Position pos = promoted.getChessPosition().toPosition();
		Piece p = board.removePiece(pos);
		piecesOnTheBoard.remove(p);
		
		ChessPiece newPiece = newPiece(type, promoted.getColor());
		
		board.placePiece(newPiece, pos);
		piecesOnTheBoard.add(newPiece);
		
		return newPiece;
	}
	
	public Piece MakeMove(Position source, Position target) {
		
		ChessPiece captured   = (ChessPiece)board.removePiece(target);		
		ChessPiece movedPiece = (ChessPiece)board.removePiece(source);
		
		movedPiece.increaseMoveCount();
		
		if ( captured != null ) {
			this.piecesOnTheBoard.remove(captured);
			this.capturedPieces.add((ChessPiece)captured);
		}
		
		board.placePiece(movedPiece, target);
		
		// #specialmove castling kingside rook
		if (movedPiece instanceof King && target.getColumn() == source.getColumn() + 2) {
			Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
			Position targetT = new Position(source.getRow(), source.getColumn() + 1);
			ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
			board.placePiece(rook, targetT);
			rook.increaseMoveCount();
		}

		// #specialmove castling queenside rook
		if (movedPiece instanceof King && target.getColumn() == source.getColumn() - 2) {
			Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
			Position targetT = new Position(source.getRow(), source.getColumn() - 1);
			ChessPiece rook = (ChessPiece)board.removePiece(sourceT);
			board.placePiece(rook, targetT);
			rook.increaseMoveCount();
		}
		
		// Jogada de EnPassant
		if (movedPiece instanceof Pawn) {
			if (source.getColumn() != target.getColumn() && captured == null) {
				Position pawnPosition;
				if (movedPiece.getColor() == Color.WHITE) {
					pawnPosition = new Position(target.getRow() + 1, target.getColumn());
				}
				else {
					pawnPosition = new Position(target.getRow() - 1, target.getColumn());
				}
				captured = (ChessPiece)board.removePiece(pawnPosition);
				capturedPieces.add(captured);
				piecesOnTheBoard.remove(captured);
			}
		}		

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
		
		ChessPiece movedPiece = (ChessPiece)board.removePiece(target);
		
		if ( movedPiece != null ) {
			movedPiece.decreaseMoveCount();
		}
		
		board.placePiece(movedPiece, source);
		
		if ( possibleCapturedPiece != null ) {
			board.placePiece(possibleCapturedPiece, target);
			capturedPieces.remove(possibleCapturedPiece);
			piecesOnTheBoard.add((ChessPiece)possibleCapturedPiece);
		}
		
		// rotina do roque pequeno (roque do rei)
		if (movedPiece instanceof King && target.getColumn() == source.getColumn() + 2) {
			Position sourceT = new Position(source.getRow(), source.getColumn() + 3);
			Position targetT = new Position(source.getRow(), source.getColumn() + 1);
			ChessPiece rook = (ChessPiece)board.removePiece(targetT);
			board.placePiece(rook, sourceT);
			rook.decreaseMoveCount();
		}

		// rotina de roque longo, roque da rainha
		if (movedPiece instanceof King && target.getColumn() == source.getColumn() - 2) {
			Position sourceT = new Position(source.getRow(), source.getColumn() - 4);
			Position targetT = new Position(source.getRow(), source.getColumn() - 1);
			ChessPiece rook = (ChessPiece)board.removePiece(targetT);
			board.placePiece(rook, sourceT);
			rook.decreaseMoveCount();
		}
		
		// #specialmove en passant
		if (movedPiece instanceof Pawn) {
			if (source.getColumn() != target.getColumn() && possibleCapturedPiece == enPassantVulnerable) {
				ChessPiece pawn = (ChessPiece)board.removePiece(target);
				Position pawnPosition;
				if (movedPiece.getColor() == Color.WHITE) {
					pawnPosition = new Position(3, target.getColumn());
				}
				else {
					pawnPosition = new Position(4, target.getColumn());
				}
				board.placePiece(pawn, pawnPosition);
			}
		}
		
		
	}
	
	
	/*
	 * Este método vai inicializar o tabuleiro com as peças nas posições iniciais do jogo*/
	public void InitialSetup() {
		
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('a', 8).toPosition());
		this.placePieceOnTheBoard(new Knight(board, Color.BLACK), new ChessPosition('b', 8).toPosition());
		this.placePieceOnTheBoard(new Bishop(board, Color.BLACK), new ChessPosition('c', 8).toPosition());
		this.placePieceOnTheBoard(new Queen(board, Color.BLACK), new ChessPosition('d', 8).toPosition());
		this.placePieceOnTheBoard(new King(board, Color.BLACK, this), new ChessPosition('e', 8).toPosition());		
		this.placePieceOnTheBoard(new Bishop(board, Color.BLACK), new ChessPosition('f', 8).toPosition());
		this.placePieceOnTheBoard(new Knight(board, Color.BLACK), new ChessPosition('g', 8).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.BLACK), new ChessPosition('h', 8).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('a', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('b', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('c', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('d', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('e', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('f', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('g', 7).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.BLACK), new ChessPosition('h', 7).toPosition());	
		//----------------------------------------------------------------------------------------------
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('a', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('b', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('c', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('d', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('e', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('f', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('g', 2).toPosition());
		this.placePieceOnTheBoard(new Pawn(board, Color.WHITE), new ChessPosition('h', 2).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('a', 1).toPosition());
		this.placePieceOnTheBoard(new Knight(board, Color.WHITE), new ChessPosition('b', 1).toPosition());
		this.placePieceOnTheBoard(new Bishop(board, Color.WHITE), new ChessPosition('c', 1).toPosition());		
		this.placePieceOnTheBoard(new Queen(board, Color.WHITE), new ChessPosition('d', 1).toPosition());
		this.placePieceOnTheBoard(new King(board, Color.WHITE, this), new ChessPosition('e', 1).toPosition());
		this.placePieceOnTheBoard(new Bishop(board, Color.WHITE), new ChessPosition('f', 1).toPosition());
		this.placePieceOnTheBoard(new Knight(board, Color.WHITE), new ChessPosition('g', 1).toPosition());
		this.placePieceOnTheBoard(new Rook(board, Color.WHITE), new ChessPosition('h', 1).toPosition());			
		
		
		
	}

}
