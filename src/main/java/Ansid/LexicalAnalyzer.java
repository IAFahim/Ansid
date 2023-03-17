package Ansid;

public class LexicalAnalyzer {

    ErrorList errorList;

    public LexicalAnalyzer(String str) {
        errorList = new ErrorList();
        if (str == null || str.length() == 0) {
            errorList.AddError(0, 0, "No input");
            return;
        }
        if (!CharUtil.isLetter(str.charAt(0))) {
            errorList.AddError(0, 0, "First character must be a letter");
            return;
        }

        StringBuilder lexeme = new StringBuilder(str.length());
        for (int i = 1; i < str.length(); i++) {

        }
    }

    public char GetChar(String str, int i) {

        return ' ';
    }

    public char NextChar() {
        return ' ';
    }

    public char PrevChar() {
        return ' ';
    }

    public char CharClass() {
        return ' ';
    }

    public void AddChar() {
    }

    public void Lookup() {
    }

}
