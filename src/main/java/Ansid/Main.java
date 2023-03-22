package Ansid;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] validCode = {
                "// This is a comment",
                "int a = 1;",
                "int b=a;",
                "int c = a + b;",
                "int d = a + b * c;",
                "int e = (a + b) * c;",
                "if (a == b)",
        };

        String[] invalidCode = {
                "int a=(1;",
                "int a ;= 1",
                "int a = 1",
                "a===b",
                "a+++++",

        };

        CheckCodeArray(validCode);
        CheckCodeArray(invalidCode);


    }

    private static void CheckCodeArray(String[] validCode) {
        for (String s : validCode) {
            LexicalAnalyzer lex = new LexicalAnalyzer();
            System.out.println("¶FOR CODE: `" + s + "`");
            System.out.println("--------------------Lexical Analysis:--------------------");
            lex.Analyze(s);
            lex.PrintTokenList();
            SyntaxAnalyzer syn = new SyntaxAnalyzer(lex.getErrorList());
            System.out.println("--------------------Syntax Analysis:--------------------");
            syn.Analyze(lex.getTokenList());
            lex.PrintErrorList();
            System.out.println("--------------------------------------------------------");
        }
    }
}