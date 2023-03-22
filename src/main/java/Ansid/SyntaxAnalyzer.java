package Ansid;

import java.util.ArrayList;

public class SyntaxAnalyzer {
    ArrayList<Error> errorList;

    public SyntaxAnalyzer(ArrayList<Error> errorList) {
        this.errorList = errorList;
    }

    public void Analyze(ArrayList<Token> tokenList) {
        int parenCount = 0;
        boolean expectingSemicolon = false;
        boolean delimitFound = false;
        ArrayList<TokenType> previousTokens = new ArrayList<>();
        if (tokenList.size() == 1 && tokenList.get(0).type == TokenType.COMMENT) {
            return;
        }
        for (int i = 0; i < tokenList.size(); i++) {
            Token token = tokenList.get(i);
            if (delimitFound) {
                errorList.add(new Error(i, "Delimiter inside statement"));
            }
            switch (token.type) {
                case LEFT_PAREN:
                    parenCount++;
                    break;
                case RIGHT_PAREN:
                    parenCount--;
                    if (parenCount < 0) {
                        errorList.add(new Error(i, "Mismatched parentheses"));
                    }
                    break;
                case DELIMITER:
                    delimitFound = true;
                    if (parenCount != 0) {
                        errorList.add(new Error(i, "Mismatched parentheses"));
                    }
                    expectingSemicolon = false;
                    break;
                default:
                    if (expectingSemicolon) {
                        errorList.add(new Error(i, "Missing Delimiter at end"));
                        expectingSemicolon = false;
                    }
                    if (token.type == TokenType.IDENT && i + 1 < tokenList.size() && tokenList.get(i + 1).type == TokenType.LEFT_PAREN) {
                        expectingSemicolon = true;
                    }
            }
            checkIfPreviousTokensAreSame(previousTokens, token.type);
            previousTokens.add(token.type);
        }
        if (tokenList.get(tokenList.size() - 1).type != TokenType.DELIMITER) {
            errorList.add(new Error(tokenList.size() - 1, "Missing semicolon"));
        }
        if (parenCount > 0) {
            errorList.add(new Error(0, "Mismatched parentheses"));
        }
    }

    public void checkIfPreviousTokensAreSame(ArrayList<TokenType> previousTokens, TokenType type) {
        if (type == TokenType.LEFT_PAREN || type == TokenType.RIGHT_PAREN) return;
        if (type == TokenType.ADD_OP || type == TokenType.SUB_OP || type == TokenType.ASSIGN_OP) {
            if (previousTokens.size() > 1 && previousTokens.get(previousTokens.size() - 1) == type && previousTokens.get(previousTokens.size() - 2) == type) {
                errorList.add(new Error(0, "Consecutive 3 or more times type not allowed for: " + type));
                return;
            }
            return;
        }
        if (previousTokens.size() > 0 && previousTokens.get(previousTokens.size() - 1) == type) {
            errorList.add(new Error(0, "Consecutive times type not allowed for: " + type));
        }

    }
}
