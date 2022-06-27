import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
    public class Main {
        static Scanner sc = new Scanner(System.in);
        static char operation;
        static int num, num1;
        static int result;


        public static void main(String[] args){
            System.out.println("Введите выражение римскими или арабскими цифрами от 1 до 10:");
            String x = sc.nextLine();
            char[] ch = new char[10];
            for (int i = 0; i < x.length(); i++) {

                ch[i] = x.charAt(i);
                if (ch[i] == '+') {
                    operation = '+';
                }
                if (ch[i] == '-') {
                    operation = '-';
                }
                if (ch[i] == '*') {
                    operation = '*';
                }
                if (ch[i] == '/') {
                    operation = '/';
                }
            }
            String chS = String.valueOf(ch);
            String[] spl = chS.split("[+-/*]");

            String a = spl[0];
            String b = spl[1];
            String c = b.trim();
            num = romToNum(a);
            num1 = romToNum(c);
            if (num < 0 && num1 < 0) {
                result = 0;
            } else {
                result = calculated(num, num1, operation);
                String resultRom = numToRom(result);
                System.out.println(resultRom);
            }
            num = Integer.parseInt(a);//преобразует строку в число
            num1 = Integer.parseInt(c);
            result = calculated(num, num1, operation);


            if (num % 1 != 0 && num1 % 1 != 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Введены не целые числа.");
                }
            } else if (num == 0 && num1 == 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Похоже, оба числа равны нулю. Попробуйте еще раз.");

                }
            } else if (num <= 10 && num1 > 10 || num > 10 && num1 <= 10 || num > 10 && num1 > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Пожалуйста, введите два целых числа от 1 до 10.");
                }
            } else {
                System.out.println(result);
            }
        }


            public static String numToRom(int numArabian) {
                String[] rom = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                        "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                        "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                        "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
                };
                final String s = rom[numArabian];
                    return s;
            }
        public static int romToNum(String rom) {
            try {
                if (rom.equals("I")) {
                    return 1;
                } else if (rom.equals("II")) {
                    return 2;
                } else if (rom.equals("III")) {
                    return 3;
                } else if (rom.equals("IV")) {
                    return 4;
                } else if (rom.equals("V")) {
                    return 5;
                } else if (rom.equals("VI")) {
                    return 6;
                } else if (rom.equals("VII")) {
                    return 7;
                } else if (rom.equals("VIII")) {
                    return 8;
                } else if (rom.equals("IX")) {
                    return 9;
                } else if (rom.equals("X")) {
                    return 10;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Неверный формат.");
            }
            return -1;
        }

            public static int calculated ( int num, int num1, char op){
                int result = 0;
                switch (op) {
                    case '+':
                        result = num + num1;
                        break;
                    case '-':
                        result = num - num1;
                        break;
                    case '*':
                        result = num * num1;
                        break;
                    case '/':
                        try {
                            result = num / num1;
                        } catch (ArithmeticException | InputMismatchException e) {
                            System.out.println("Кажется, вы делите на ноль.");
                            break;
                        }
                        break;
                    default:
                        try {
                            throw new IllegalArgumentException();
                        }catch (IllegalArgumentException e){
                            System.out.println("Не верный знак операции.");
                        }

                }
            return result;
        }
    }