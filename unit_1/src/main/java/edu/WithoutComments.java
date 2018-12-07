package edu;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Класс считывает программный код из одного файла, убирает из него комментарии и
 * записывает в другой файл.
 */
public class WithoutComments {
    public static void main(String[] args) {
        withoutComments();
        readWithComments();
        readWithoutComments();
    }
    public static void withoutComments() {
        BufferedReader br;
        BufferedWriter bw;
        try {
            br = new BufferedReader(new FileReader("C:\\course\\WithoutComments\\withComments.txt"));
            bw = new BufferedWriter(new FileWriter("C:\\course\\WithoutComments\\withoutComments.txt"));
            String result;

            while ((result = br.readLine()) != null) {
//                if(!result.contains("/") & !result.contains("*")){
                if (!chekUpperCase(result)) {
                    bw.write(result);
                    bw.newLine();
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
     * Метод отображает содержимое файла withComments.
     */
    public static void readWithComments() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("C:\\course\\WithoutComments\\withComments.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Метод отображает содержимое файла withoutComments.
     */
    public static void readWithoutComments() {
        System.out.println();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("C:\\course\\WithoutComments\\withoutComments.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
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
        Pattern p = Pattern.compile("\\s*(/|\\*|/*\\*|\\*/)");
        Matcher m = p.matcher(f);
        return m.find();
    }
}
