package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import java.util.HashMap;
import java.util.Map;




public abstract class Tile {

  protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllEmptyTiles();

    private static Map<Integer, EmptyTile> createAllEmptyTiles() {

      final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

      for(int i = 0; i < 64; i++) {
        emptyTileMap.put(i, new EmptyTile(i));
      }

      return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
      return piece != null ? new OccupiedTitle(tileCoordinate, piece) : EMPTY_TILES.get(tileCoordinate);
    }

  Tile(int tileCoordinate) {
    this.tileCoordinate = tileCoordinate;
  }

  public abstract boolean isTileOccupied();

  public abstract Piece getPiece();

  public static final class EmptyTile extends Tile {

    EmptyTile(final int tileCoordinate) {
      super(tileCoordinate);
    }

    @Override
    public boolean isTileOccupied() {
      return false;
    }

    @Override
    public Piece getPiece() {
      return null;
    }
  }

  public static final class OccupiedTitle extends Tile {

    private final Piece pieceOnTile;

    OccupiedTitle(int tileCoordinate, Piece pieceOnTile) {
      super(tileCoordinate);
      this.pieceOnTile = pieceOnTile;
    }

    @Override
    public boolean isTileOccupied() {
      return true;
    }

    @Override
    public Piece getPiece() {
      return this.pieceOnTile;
    }

  }

}