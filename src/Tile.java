public abstract class Tile {
  // defined as abstract so Tile cannot be mutated
  // But the subclasses such as EmptyTile can!

  int tileCoordinate;

  Tile(int tileCoordinate) {
    this.tileCoordinate = tileCoordinate;
  }

  public abstract boolean isTileOccupied();

  public abstract Piece getPiece();

  public static final class EmptyTile extends Tile {

    EmptyTile(int tileCoordinate) {
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

    Piece pieceOnTile;

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