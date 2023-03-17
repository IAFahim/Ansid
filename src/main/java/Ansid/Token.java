package Ansid;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Token {
    String token;
    TokenType type;
    public static HashMap<String, TokenType> keywords;

    public Token(String token) {
        this.token = token;
        if(keywords==null){
            keywords = new HashMap<>();
            keywords.put("if", TokenType.IF);
            keywords.put("else", TokenType.ELSE);
            keywords.put("int", TokenType.INT_LET);
            keywords.put("float", TokenType.FLOAT_LET);
            keywords.put("=", TokenType.ASSIGN_OP);
            keywords.put("+", TokenType.ADD_OP);
            keywords.put("-", TokenType.SUB_OP);
            keywords.put("*", TokenType.MUL_OP);
            keywords.put("/", TokenType.DIV_OP);
            keywords.put("%", TokenType.MOD_OP);
            keywords.put("++", TokenType.INC_OP);
            keywords.put("--", TokenType.DEC_OP);
            keywords.put("==", TokenType.EQ_OP);
        }
    }

    public TokenType getType() {
        return type;
    }


    public TokenType FigureOutType(String token) {
        return keywords.get(token);
    }
}


