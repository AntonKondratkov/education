package edu;
/**
 * В классе происходит создание слова длинной 100 000 и реализация двух спсособов,
 * которые переворачивают данное слово. Также замеряется время выполнения программы.
 */
public class Revers {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(words());
        System.out.println(sb);
        long before1 = System.currentTimeMillis();
        System.out.println(sb.reverse());
        long after1 = System.currentTimeMillis();
        long runTimeSB = after1 - before1;
        System.out.println("Время выполнения программы при использовании StringBuilder: " + (runTimeSB));
        System.out.println();

        long before2 = System.currentTimeMillis();
        String string2 = new String(words());
        System.out.println(string2);
        string2 = reversArray(string2);
        long after2 = System.currentTimeMillis();
        long runTimeCharArray = after2 - before2;
        System.out.println(string2);
        System.out.println("Время выполнения программы при использовании массива символов: " + (runTimeCharArray));

        System.out.println();

        if (runTimeSB < runTimeCharArray) {
            System.out.println("Программа с использование StringBuilder работает быстрее");
        } else if (runTimeSB > runTimeCharArray) {
            System.out.println("Программа с использование массива символов работает быстрее");
        } else {
            System.out.println("Программы работают одинаково быстро");
        }
    }
    /**
     * Метод создаёт слово из 100 000 символов.
     * @return sb.
     */
    public static StringBuilder words() {
        StringBuilder  sb = new StringBuilder();
        sb.append("a");
        for (int i = 0; i < 99998; i++) {
            sb.append("b");
        }
        sb.append("c");
        return sb;
    }
    /**
     * Метод переворачивает слово с помощью массива символов.
     * @param string2 Слово, которое требуется перевернуть.
     * @return Перевернутое слово.
     */
    public static String reversArray(String string2) {
        char[] a = string2.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(a.length - 1) - i] = a[i];
        }
        return new String(b);
    }
}

