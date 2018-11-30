package edu;
/**
 * Данный класс проверяет все ли открывающие скобки закрыты. Если какая-нибудь не закрыта, то программа отображает её.
 */
public class Brackets {
    public static void main(String[] args) {
        System.out.println(brackets("{sd((fd()}[]"));
    }
    /**
     * Метод проверяет все ли открывающие скобки закрыты. Если какая-нибудь не закрыта, то отображает её.
     * @param randomChars Строка из рандомных символов.
     * @return false or true.
     */
    public static boolean brackets(String randomChars) {
        boolean result = true;
        int squareBrackets = 0;
        int figureBrackets = 0;
        int roundBrackets = 0;
        char[] a = randomChars.toCharArray();

        for (int i = 0; i < randomChars.length(); i++) {
            if (a[i] == '{') {
                figureBrackets++;
            } else if (a[i] == '}') {
                figureBrackets--;
            }
            if (a[i] == '[') {
                squareBrackets++;
            } else if (a[i] == ']') {
                squareBrackets--;
            }
            if (a[i] == '(') {
                roundBrackets++;
            } else if (a[i] == ')') {
                roundBrackets--;
            }
        }
        if (squareBrackets != 0) {
            result = false;
            for (int i = 0; i < squareBrackets; i++) {
                System.out.print(']');
            }
        }
        if (figureBrackets != 0) {
            result = false;
            for (int i = 0; i < figureBrackets; i++) {
                System.out.print('}');
            }
        }
        if (roundBrackets != 0) {
            result = false;
            for (int i = 0; i < roundBrackets; i++) {
                System.out.print(')');
            }
        }
        System.out.println();
        return result;
    }
}
