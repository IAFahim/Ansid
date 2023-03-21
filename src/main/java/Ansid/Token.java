package Ansid;

import java.util.Arrays;
import java.util.HashMap;

public class Token {
    String lexemes;
    TokenType type;
    public static HashMap<String, TokenType> keywords;
    public static HashMap<String, IDENT> identifiers;

    public Token() {
        if (keywords == null) {
            keywords = new HashMap<>();

        }
    }

    public Token SetToken(char[] bytes, TokenType type) {
        this.lexemes = Arrays.toString(bytes);
        this.type = type;
        return this;
    }

    public TokenType CheckToken(String str) {
        return keywords.get(str);
    }
}


