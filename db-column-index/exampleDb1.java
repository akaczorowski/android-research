public enum ColumnType {
  TEXT, INTEGER
}

public enum Column {

  CODE  (ColumnType.TEXT),
  ID    (ColumnType.INTEGER),      
  NAME  (ColumnType.TEXT),
 

  private ColumnType type;

  Column(ColumnType type) {
    this.type = type;
  }

  public ColumnType type() {
    return type;
  }

  public int indexInCursor(Cursor cursor) {
    return cursor.getColumnIndex(name());
  }

  @Override
  public String toString() {
    return String.format("%s %s", name(), type().name());
  }
}