package Ansid;

import java.util.ArrayList;

public class IDENT {
    public static boolean CheckIDENT(char[] chars, int start, ArrayList<Error> errorList) {
        for (int i = start; i < chars.length; i++) {
            if (CharUtil.isLetter(chars[i]) || CharUtil.isDigit(chars[i])) {

            } else {
                return false;
            }
        }
        return true;
    }
}
