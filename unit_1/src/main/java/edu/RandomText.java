package edu;

import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomText {
    private static String[] randomChar = {"A", "B", "c", "D", "f", "E", ",", "!", "."," ", "%"};

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        randomText();
        textToUpperCase();
        readFileRandomText();
        readFileUpperCase();
    }
    /**
     * Метод рандомно записывает буквы и знаки препинания из массива randomChar в файл RandomText.
     * @throws IOException
     */
    public static void randomText() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\course\\RandomText.txt"));
        Random random = new Random();
        for (int i = 0; i < randomChar.length; i++) {
            bw.write(randomChar[random.nextInt(randomChar.length)]);
        }
        bw.close();
    }
    /**
     * Метод вычисляет заглавные буквы в файле RandomText и записывает их в файл UpperCase.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void textToUpperCase() throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\course\\RandomText.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\course\\UpperCase.txt"));

        for (int i = 0; i < 11; i++) {
            String result = br.readLine();
            if(chekUpperCase(result)) {
                bw.write(result);
            }

        }
        br.close();
        bw.close();
    }
    /**
     * Метод отображает содержимое файла RandomText.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readFileRandomText() throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\course\\RandomText.txt"));

        for (int i = 0; i < randomChar.length; i++) {
            System.out.print(br.readLine());
        }
        br.close();
    }
    /**
     * Метод отображает содержимое файла UpperCase.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readFileUpperCase() throws IOException, ClassNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\course\\UpperCase.txt"));

        System.out.println();

        for (int i = 0; i < randomChar.length; i++) {
            System.out.print(br.readLine());
        }
        br.close();
    }
    public static boolean chekUpperCase(String f) {
        Pattern p = Pattern.compile("^[A-Z]$");
        Matcher m = p.matcher(f);
        return m.find();
    }
}
