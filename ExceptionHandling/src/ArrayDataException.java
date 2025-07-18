public class ArrayDataException extends IllegalArgumentException {

    private final int column;
    private final int row;
    private final String element;

    public ArrayDataException(String message, final int column, final int row, final String element) {
        super(message);
        this.column = column;
        this.row = row;
        this.element = element;
    }

    public String getErrorIndex() {
        return "Column : " + column + ", row: " + row + ", element: " + element;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + getErrorIndex();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
