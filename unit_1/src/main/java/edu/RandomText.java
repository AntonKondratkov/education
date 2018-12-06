package edu;

import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Метод считывает знаки препинания и буквы разного регистра из одного файла, вычисляет заглавные буквы
 * и записывает их в другой файл.
 */
public class RandomText {
    private static String[] randomChar = {"A", "B", "c", "D", "f", "E", ",", "!", ".", " ", "%"};
    public static void main(String[] args) {
        randomText();
        textToUpperCase();
        readFileRandomText();
        readFileUpperCase();
    }
    /**
     * Метод рандомно записывает буквы и знаки препинания из массива randomChar в файл RandomText.
     */
    public static void randomText() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("C:\\course\\RandomText.txt"));
            Random random = new Random();
            for (int i = 0; i < randomChar.length; i++) {
                bw.write(randomChar[random.nextInt(randomChar.length)]);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод вычисляет заглавные буквы в файле RandomText и записывает их в файл UpperCase.
     */
    public static void textToUpperCase()  {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("C:\\course\\RandomText.txt"));
            bw = new BufferedWriter(new FileWriter("C:\\course\\UpperCase.txt"));
            String result = br.readLine();
            char[] chars = result.toCharArray();
            for (int i = 0; i < result.length(); i++) {
                if (chekUpperCase(String.valueOf(chars[i]))) {
                    bw.write(chars[i]);
                }
            }
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод отображает содержимое файла RandomText.
     */
    public static void readFileRandomText() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\course\\RandomText.txt"));
            System.out.print(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     /**
     * Метод отображает содержимое файла UpperCase.
     */
    public static void readFileUpperCase() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\course\\UpperCase.txt"));
            System.out.println();
            System.out.print(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод проверяет соответствие переданной в аргументы строки регулярному выражению.
     * @param f Переданная для проверки строка.
     * @return false or true.
     */
    public static boolean chekUpperCase(String f) {
        Pattern p = Pattern.compile("^[A-Z]$");
        Matcher m = p.matcher(f);
        return m.find();
    }
}
