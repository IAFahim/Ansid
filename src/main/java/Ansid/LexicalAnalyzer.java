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

        StringBuilder lexeme = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (CharUtil.isComment(c) && i < str.length() - 1 && str.charAt(i + 1) == '/') {
                tokenList.add(new Token().SetToken("Comment", TokenType.COMMENT));
                break;
            }

            if (CharUtil.isLetter(c)) {
                lexeme.append(c);
            } else if (CharUtil.isDigit(c)) {
                lexeme.append(c);
            } else if (CharUtil.isWhitespace(c)) {
                if (lexeme.length() > 0) {
                    tokenList.add(new Token().SetToken(lexeme.toString(), Keywords.getTokenType(lexeme.toString())));
                    lexeme = new StringBuilder(str.length());
                }
            } else if (CharUtil.isOperator(c)) {
                lexeme = getStringBuilder(str, lexeme, c);
            } else if (CharUtil.isSeparator(c)) {
                lexeme = getStringBuilder(str, lexeme, c);
            } else if (CharUtil.isAssignment(c)) {
                lexeme = getStringBuilder(str, lexeme, c);
            } else if (CharUtil.isDelimiter(c)) {
                if (lexeme.length() > 0) {
                    tokenList.add(new Token().SetToken(lexeme.toString(), Keywords.getTokenType(lexeme.toString())));
                    lexeme = new StringBuilder(str.length());
                }
                tokenList.add(new Token().SetToken(String.valueOf(c), TokenType.DELIMITER));
            } else {
                errorList.add(new Error(i, "Unknown character"));
            }
        }
    }

    private StringBuilder getStringBuilder(String str, StringBuilder lexeme, char c) {
        if (lexeme.length() > 0) {
            tokenList.add(new Token().SetToken(lexeme.toString(), Keywords.getTokenType(lexeme.toString())));
            lexeme = new StringBuilder(str.length());
        }
        tokenList.add(new Token().SetToken(c + "", Keywords.getTokenType(String.valueOf(c))));
        return lexeme;
    }

    public ArrayList<Token> getTokenList() {
        return tokenList;
    }

    public ArrayList<Error> getErrorList() {
        return errorList;
    }

    public void PrintTokenList() {
        if (tokenList.size() == 0) {
            System.out.println("No tokens");
            return;
        }
        System.out.println("Token List:");
        for (int i = 0, tokenListSize = tokenList.size(); i < tokenListSize; i++) {
            System.out.printf("Token %d: %s%n", i, tokenList.get(i));
        }
    }

    public void PrintErrorList() {
        if(errorList.size() == 0){
            System.out.println("No errors");
            return;
        }
        System.out.println("Error List:");
        for (int i = 0, errorListSize = errorList.size(); i < errorListSize; i++) {
            System.out.printf("%d: %s%n", i, errorList.get(i));
        }
    }
}
