package Ansid;

import java.util.ArrayList;
import java.util.List;

public class ErrorList {
    private List<Error> errorList;

    public ErrorList() {
        errorList = new ArrayList<Error>();
    }

    public void AddError(int lineNumber, int columnNumber, String error) {
        errorList.add(new Error(lineNumber, columnNumber, error));
    }

}
