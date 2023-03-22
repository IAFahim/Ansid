package Ansid;

import java.util.HashMap;

public final class Keywords {
    private static final HashMap<String, TokenType> map = new HashMap<>();

    static {
        map.put("if", TokenType.IF);
        map.put("int", TokenType.INT_LET);
        map.put("else", TokenType.ELSE);
        map.put("float", TokenType.FLOAT_LET);
        map.put("=", TokenType.ASSIGN_OP);
        map.put("+", TokenType.ADD_OP);
        map.put("-", TokenType.SUB_OP);
        map.put("*", TokenType.MUL_OP);
        map.put("/", TokenType.DIV_OP);
        map.put("%", TokenType.MOD_OP);
        map.put(";", TokenType.DELIMITER);
        map.put("(", TokenType.LEFT_PAREN);
        map.put(")", TokenType.RIGHT_PAREN);
    }

    public static TokenType getTokenType(String keyword) {
        return map.getOrDefault(keyword, TokenType.IDENT);
    }
}
