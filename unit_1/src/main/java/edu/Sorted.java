package edu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * В классе организуется сортировка чисел.
 */
public class Sorted {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(10);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(5);
        arrayList.add(1);

        System.out.println(sort(arrayList));
    }
    /**
     * Метод убирает повторы в переданном списке, а также сортирует этот список.
     * @param list Лист содержащий неотсортированные и повторяющиеся числа.
     * @return Лист содержащий уникальные отсортированные числа.
     */
    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();
        integers.addAll(list);
        arrayList.addAll(integers);
        return arrayList;
    }
}
