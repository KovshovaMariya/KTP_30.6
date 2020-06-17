package com.company;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        InputStreamReader isr = new InputStreamReader(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Введите номер задания (для завершения выберите 0):");
            int number = in.nextInt();
            switch (number) {
                case 0: {
                    isExit = true;
                    break;
                }
                case 1: {
                    System.out.println("Введите коэффициент a: ");
                    int a = in.nextInt();
                    System.out.println("Введите коэффициент b: ");
                    int b = in.nextInt();
                    System.out.println("Введите коэффициент c: ");
                    int c = in.nextInt();
                    One(a, b, c);
                    break;
                }
                case 2: {
                    System.out.println(Two("all zip files are zipped"));
                    System.out.println(Two("all zip files are compressed") );
                    break;
                }
                case 3: {
                    System.out.println("Введите число:");
                    int num = in.nextInt();
                    System.out.println("checkPerfect(" + num + ") = " + Three(num));
                }
                case 4: {
                    in.nextLine();
                    System.out.println("Введите строку:");
                    String str = in.nextLine();
                    Four(str);
                    break;
                }
                case 5: {
                    System.out.println(Five("#CD5C5C"));
                    System.out.println(Five("#EAECEE"));
                    System.out.println(Five("#eaecee"));
                    System.out.println(Five("#CD5C58C"));
                    System.out.println(Five("#CD5C5Z"));
                    System.out.println(Five("#CD5C&C"));
                    System.out.println(Five("CD5C5C"));
                    break;
                }
                case 6: {
                    System.out.println(Six(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7}));
                    System.out.println(Six(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1}));
                    System.out.println(Six(new int[]{2}, new int[]{3, 3, 3, 3, 3}));
                    break;
                }
                case 7: {
                    System.out.println(Seven(3));
                    System.out.println(Seven(5));
                    System.out.println(Seven(297));
                    break;
                }
                case 8: {
                    System.out.println(Eight("01100001011000"));
                    System.out.println(Eight("100100100"));
                    System.out.println(Eight("11111"));
                    break;
                }
                case 9: {
                    System.out.println(Nine(12));
                    System.out.println(Nine(24));
                    System.out.println(Nine(11));
                    break;
                }
                case 10: {
                    System.out.println(Ten(3, 4, 5));
                    System.out.println(Ten(145, 105, 100));
                    System.out.println(Ten(70, 130, 110));
                    break;
                }
            }
        }
    }
    public static void One(int a, int b, int c){
        int D = b*b - 4*a*c;
        if (D > 0) System.out.println("solutions(" + a + ", " + b + ", " + c + ") = 2");
        else if (D == 0) System.out.println("solutions(" + a + ", " + b + ", " + c + ") = 1");
        else System.out.println("solutions(" + a + ", " + b + ", " + c + ") = 0");
    }
    public static int Two(String string){
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.startsWith("zip", i))
                counter++;
            if (counter == 2)
                return i;
        }
        return -1;
    }
    public static boolean Three(int number){
       int sum = 0;
       for (int i = 1; i < number; i++){
           if (number % i == 0) sum += i;
       }
       if (sum == number) return true;
       else return false;
    }
    public static void Four(String str){
        //int temp = str.length()-1;
        char temp = str.charAt(0);
        if (str.length() < 2) System.out.println("flipEndChars(" + str + ") = Incompatible");
        else if (str.charAt(0) == str.charAt(str.length()-1)) System.out.println("flipEndChars(" + str + ") = Two's a pair");
        else {
           char[] chars = str.toCharArray();
           chars[0] = chars[str.length()-1];
           chars[str.length()-1] = temp;
            System.out.print("flipEndChars(" + str + ") = ");
            for (int i = 0; i < str.length(); i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
    public static boolean Five(String code){
        // если первый символ это # то мы убираем его из строки и продолжаем
        if (code.charAt(0) == '#') {
            // записываем в строку эту же строку но не с 0-го индекса а 1-го, чтобы удалить '#'
            code = code.substring(1);
        } else return false; // иначе возвращаем false и зваершаем работу метода
        // если в строке не 6 символом, завершаем работу метода и возвращаем false
        if (code.length() != 6)
            return false;
        // определяем переменную, которая показывает правильный ли символ
        boolean result = false;
        // перебираем все символы строки
        for (int i = 0; i < code.length(); i++) {
            // если символ это цифра, то присваиваем переменной result true
            if (code.charAt(i) >= '0' && code.charAt(i) <= '9') {
                result = true;
            }
            // если символ это буква по условию, то присваиваем переменной result true
            else if (code.charAt(i) >= 'A' && code.charAt(i) <= 'F' || code.charAt(i) >= 'a' && code.charAt(i) <= 'f') {
                result = true;
            } else result = false; // если ни одно условие не соблюдено присваиваем false
        }
        // возвращаем значение переменной
        return result;
    }
    public static boolean Six(int[] arr1, int[] arr2){
        ArrayList<Integer> arr1Copy = new ArrayList<>();
        ArrayList<Integer> arr2Copy = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1Copy.contains(arr1[i])) {
                arr1Copy.add(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (!arr2Copy.contains(arr2[i])) {
                arr2Copy.add(arr2[i]);
            }
        }
        return arr1Copy.size() == arr2Copy.size();
    }
    public static boolean Seven(int number){
        if (number == 0 || number == 1)
            return true;
        int square = number * number;
        String sNumber = String.valueOf(square);
        int left;
        int right;
        if (sNumber.length() % 2 != 0) {
            if (sNumber.length() == 1) {
                left = 0;
                right = square;
            } else {
                left = Integer.parseInt(sNumber.substring(0, (sNumber.length() - 1) / 2));
                right = Integer.parseInt(sNumber.substring((sNumber.length() - 1) / 2));
            }
        } else {
            left = Integer.parseInt(sNumber.substring(0, sNumber.length() / 2));
            right = Integer.parseInt(sNumber.substring(sNumber.length() / 2));
        }
        return left + right == number;
    }
    static String Eight(String string) {
        int maxAmount = 0;
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '0') {
                counter++;
            } else counter = 0;
            if (counter > maxAmount) {
                maxAmount = counter;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxAmount; i++) {
            result.append('0');
        }
        return result.toString();
    }
    static int Nine(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return Nine(number + 1);
        }
        return number;
    }

    public static boolean Ten(int a, int b, int c){
        int[] array = {a, b, c};
        Arrays.sort(array);
        int hypotenuse = array[2];
        int katet1 = array[1];
        int katet2 = array[0];
        return hypotenuse * hypotenuse == katet1 * katet1 + katet2 * katet2;
    }

}
