package Ansid;

public class Error {
    public int lineNumber;
    public int columnNumber;
    public String error;

    public Error(int lineNumber, int columnNumber, String error) {
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        this.error = error + ": " + lineNumber + ":" + columnNumber;
    }
}
