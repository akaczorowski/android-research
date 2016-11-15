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


/**
*
* Use case
*
**/

db.execSQL(String.format("CREATE TABLE %s (%s)", TABLE_1, Strings.join(", ", Column.values()))); // values() używa toString()
db.execSQL(String.format("CREATE INDEX id ON %s (%s)", TABLE_1, Column.ID.name()));
db.execSQL(String.format("CREATE INDEX code ON %s (%s)", TABLE_1, Column.CODE.name()));