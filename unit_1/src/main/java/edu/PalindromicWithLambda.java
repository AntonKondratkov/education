package edu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class PalindromicWithLambda {
    // Максимальное значение пятизначного числа.
    private static final long MAXVALUE = 15000;
    //Первый список простых чисел.
    private static List<Long> primeNumberOne = new ArrayList<>();
    //Второй список простых чисел.
    private static List<Long> primeNumberTwo = new ArrayList<>();
    //Список палиндромов.
    private static List<String> palindromes = new ArrayList<>();
    //Список множителей простых чисел.
    private static List<String> multipliersOfPN = new ArrayList<>();
    //Список множителей палиндромов.
    private static List<String> multipliersOfPalindroms = new ArrayList<>();

    public static void main(String[] args) {
        primeNumber(MAXVALUE);
        palindromes.addAll(palindrom(primeNumberOne, primeNumberTwo));
        System.out.println(sort());
    }
    /**
     * Метод вычисляет простые пятизначные числа.
     */
    private static void primeNumber(long maxValue) {
        UnaryOperator<Long> unaryOperator = x -> (long) (Math.log10(x) + 1);
        for (long i = 2; i < maxValue; i++) {
            boolean index = true;
            for (long j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    index = false;
                }
            }
            if (index && (unaryOperator.apply(maxValue)) == 5) {
                primeNumberOne.add(i);
                primeNumberTwo.add(i);
            }
        }
    }
    /**
     * Методы вычисляет палиндромы от двух переданных в аргументы листов простых чисел.
     * @param list1 Первый лист простых чисел.
     * @param list2 Второй лист простых чисел.
     * @return Лист палиндромов.
     */
    public static List<String> palindrom(List<Long> list1, List<Long> list2) {
        List<Long> list3 = new ArrayList<>();
        BiFunction<List, List, List> biFunction = (x, y) -> {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    list3.add(list1.get(i) * list2.get(j));
                    multipliersOfPN.add(list1.get(i) + " " + list2.get(j));
                }
            }
            return list3;
        };
        List list4 = biFunction.apply(list1, list2);
        List<String> list5 = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list4.size(); i++) {
            if (Long.toString((Long) list4.get(i)).equals(new StringBuilder(Long.toString((Long) list4.get(i))).reverse().toString())) {
                list5.add(index++, Long.toString((Long) list4.get(i)));
                multipliersOfPalindroms.add(multipliersOfPN.get(i));
            }
        }
        return list5;
    }
    /**
     * Метод возвращает наибольшее число палиндром и отображает его множители.
     * @return result.
     */
    public static long sort() {
        String multipliers = " ";
        long maxPalindrom = 0;
        for (int i = 0; i < palindromes.size(); i++) {
            if (Long.parseLong(palindromes.get(i)) > maxPalindrom) {
                maxPalindrom = Long.parseLong(palindromes.get(i));
                multipliers = multipliersOfPalindroms.get(i);
            }
        }
        System.out.println(multipliers);
        return maxPalindrom;
    }
}