package edu;

import java.util.ArrayList;
import java.util.List;
/**
 * Класс вычисляет наибольшее число палиндром, которое является произведением двух простых пятизначных чисел,
 * а также возвращает сами множители.
 */
public class Palindromic {
    // Максимальное значение пятизначного числа.
    private static long maxValue = 50000;
    //Первый список простых чисел.
    private static List<Long> primeNumberOne = new ArrayList<>();
    //Второй список простых чисел.
    private static List<Long> primeNumberTwo = new ArrayList<>();
    //Результат перемножения двух списков простых чисел.
    private static List<Long> multipliedOfNumber = new ArrayList<>();
    //Список палиндромов.
    private static List<String> palindromes = new ArrayList<>();
    //Список множителей простых чисел.
    private static List<String> multipliersOfPN = new ArrayList<>();
    //Список множителей палиндромов.
    private static List<String> multipliersOfPalindroms = new ArrayList<>();

    public static void main(String[] args) {
        primeNumber();
        multipliedOfNumber.addAll(multiplication(primeNumberOne, primeNumberTwo));
        palindromes.addAll(palindrom(multipliedOfNumber));
        System.out.println(sort());
    }
    /**
     * Метод вычисляет простые пятизначные числа.
     */
    private static void primeNumber() {
        for (long i = 2; i < maxValue; i++) {
            boolean index = true;
            for (long j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    index = false;
                }
            }
            if (index && lengthofDigits(i) == 5) {
                primeNumberOne.add(i);
                primeNumberTwo.add(i);
            }
        }
    }
    /**
     * Метод вычисляет длинну числа.
     * @param number Число.
     * @return Длинна числа.
     */
    private static long lengthofDigits(long number) {
        long numberOfDigits = (long) (Math.log10(number) + 1);
        return numberOfDigits;
    }
    /**
     * Метод перемножает два множества простых чисел.
     * @param list1 Первое множество.
     * @param list2 Второе множество.
     * @return Результат перемножения.
     */
    private static List<Long> multiplication(List<Long> list1, List<Long> list2) {
        List<Long> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                list3.add(list1.get(i) * list2.get(j));
                multipliersOfPN.add(list1.get(i) + " " + list2.get(j));
            }
        }
        return list3;
    }
    /**
     * Метод вычисляет палиндромы из множества перемноженных простых чисел.
     */
    public static List<String> palindrom(List<Long> list1) {
        List<String> list2 = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (Long.toString(list1.get(i)).equals(new StringBuilder(Long.toString(list1.get(i))).reverse().toString())) {
                list2.add(index++, Long.toString(list1.get(i)));
                multipliersOfPalindroms.add(multipliersOfPN.get(i));
            }
        }
        return list2;
    }
    /**
     * Метод возвращает наибольшее число палиндром и отображает его множители.
     * @return result.
     */
    public static long sort() {
        String multipliers = "";
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