package Ansid;

import java.util.ArrayList;

public class LexicalAnalyzer {
    ArrayList<Error> errorList;
    ArrayList<Token> tokenList;

    public LexicalAnalyzer() {
        errorList = new ArrayList<>();
        tokenList = new ArrayList<>();
    }

    public void Analyze(String str) {
        if (str == null || str.length() == 0) {
            errorList.add(new Error(0, "No input"));
            return;
        }
        char[] chars = str.toCharArray();
        if (!CharUtil.isLetter(chars[0])) {
            errorList.add(new Error(0, "Not a statement"));
            return;
        }
        StringBuilder lexeme = new StringBuilder(chars.length);
    }

    public ArrayList<Token> getTokenList() {
        return tokenList;
    }

    public ArrayList<Error> getErrorList() {
        return errorList;
    }

    public void PrintTokenList() {
        for (int i = 0, tokenListSize = tokenList.size(); i < tokenListSize; i++) {
            System.out.printf("Token %d: %s%n", i, tokenList.get(i));
        }
    }

    public void PrintErrorList() {
        for (int i = 0, errorListSize = errorList.size(); i < errorListSize; i++) {
            System.out.printf("%d: %s%n", i, errorList.get(i));
        }
    }

    public void Clear() {
        tokenList = new ArrayList<>();
        errorList = new ArrayList<>();
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
