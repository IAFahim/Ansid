package Ansid;

import java.util.HashMap;

public class Token {
    String lexemes;
    TokenType type;
    public static HashMap<String, TokenType> keywords;

    public Token() {
        if (keywords == null) {
            keywords = new HashMap<>();

        }
    }

    public Token SetToken(String str, TokenType type) {
        this.lexemes = str;
        this.type = type;
        return this;
    }

    public TokenType CheckToken(String str) {
        return keywords.get(str);
    }

    @Override
    public String toString() {
        return "Token{" +
                "lexemes='" + lexemes + '\'' +
                ", type=" + type +
                '}';
    }
}


