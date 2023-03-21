package Ansid;

public class CharUtil {
    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isLetterOrDigit(char c) {
        return isLetter(c) || isDigit(c);
    }

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }

    public static boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }

    public static boolean isBracket(char c) {
        return c == '[' || c == ']';
    }

    public static boolean isBrace(char c) {
        return c == '{' || c == '}';
    }

    public static boolean isDelimiter(char c) {
        return c == ';' || c == ',';
    }

    public static boolean isQuote(char c) {
        return c == '\'' || c == '"';
    }

    public static boolean isSpecial(char c) {
        return c == '@' || c == '#' || c == '$' || c == '&' || c == '!' || c == '?' || c == '~' || c == '`';
    }

    public static boolean isSymbol(char c) {
        return isOperator(c) || isParenthesis(c) || isBracket(c) || isBrace(c) || isDelimiter(c) || isQuote(c) || isSpecial(c);
    }

    public static boolean isIdentifier(char c) {
        return isLetterOrDigit(c) || c == '_';
    }

    public static boolean isNumber(char c) {
        return isDigit(c) || c == '.';
    }

    public static boolean isComment(char c) {
        return c == '/' || c == '*';
    }

    public static boolean isString(char c) {
        return c == '"' || c == '\'';
    }

    public static boolean isEscape(char c) {
        return c == '\\';
    }


}
