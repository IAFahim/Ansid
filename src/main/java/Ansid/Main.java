package Ansid;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] codeLine = {
                "",
                "int a = 1;",
        };
        LexicalAnalyzer lex = new LexicalAnalyzer();
        lex.Analyze("");
        System.out.println("Token List:");
        lex.PrintTokenList();
        System.out.println("Error List:");
        lex.PrintErrorList();
    }

    public String test() {
        return "Hello World!";
    }
}