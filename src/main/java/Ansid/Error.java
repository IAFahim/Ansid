package Ansid;

public class Error {
    public int columnNumber;
    public String error;

    public Error( int columnNumber, String error) {
        this.columnNumber = columnNumber;
        this.error = error + " @" + columnNumber;
    }

    @Override
    public String toString() {
        return error;
    }
}
