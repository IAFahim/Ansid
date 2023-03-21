package Ansid;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LexicalAnalyzerTest {

    @org.junit.jupiter.api.Test
    void Empty() {
        LexicalAnalyzer lex = new LexicalAnalyzer();
        lex.Analyze("");
        ArrayList<Token> tokens = lex.getTokenList();
        assertEquals(tokens.size(), 0);
        ArrayList<Error> errors = lex.getErrorList();
        assertEquals(errors.get(0).error, "No input @0");
    }

    @org.junit.jupiter.api.Test
    void CheckInt() {
        LexicalAnalyzer lex = new LexicalAnalyzer();
        lex.Analyze("int a = 1;");
        ArrayList<Token> tokens = lex.getTokenList();
        assertEquals(tokens.get(0).lexemes, "int");
    }
}